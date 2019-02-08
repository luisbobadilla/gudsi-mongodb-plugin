package com.gudsi.mongodb;

import com.mongodb.MongoCommandException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.result.DeleteResult;

import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.bson.types.ObjectId;
import java.util.List;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import java.util.ArrayList;

public class CollectionControl {

  MongoClient mobileClient;

  public void setClient(MongoClient _mobileClient) {
    mobileClient = _mobileClient;
  }

  public String createIndex(String databaseName, String collectionName, JSONObject keys, JSONObject indexOptions) {
    MongoCollection<Document> localCollection = mobileClient.getDatabase(databaseName).getCollection(collectionName);
    Document _keys = Document.parse(keys.toString());
    IndexOptions _indexOptions = new IndexOptions();
    Iterator<String> opts = indexOptions.keys();
    try {
      while (opts.hasNext()) {
        String _option = opts.next();
        switch (_option) {
        case "name":
          _indexOptions.name(indexOptions.getString("name"));
          break;
        case "expireAfter":
          _indexOptions.expireAfter(indexOptions.getLong("expireAfter"), TimeUnit.MILLISECONDS);
          break;
        case "unique":
          _indexOptions.unique(indexOptions.getBoolean("unique"));
          break;
        case "max":
          _indexOptions.max(indexOptions.getDouble("max"));
          break;
        case "min":
          _indexOptions.min(indexOptions.getDouble("min"));
          break;
        }
      }
    } catch (JSONException e) {
      return "false";
    }
    String name = localCollection.createIndex(_keys, _indexOptions);
    return name;

  }

  public String dropIndex(String databaseName, String collectionName, String indexName) {
    try {
      MongoCollection<Document> localCollection = mobileClient.getDatabase(databaseName).getCollection(collectionName);
      localCollection.dropIndex(indexName);
      return "true";
    } catch (MongoCommandException e) {
      return "false";
    }
  }

  public ArrayList<Document> aggregate(String databaseName, String collectionName, JSONArray pipeline) {
    MongoCollection<Document> localCollection = mobileClient.getDatabase(databaseName).getCollection(collectionName);
    List<Bson> _pipeline = new ArrayList();
    try {
      for (int i = 0, size = pipeline.length(); i < size; i++) {
        JSONObject stage = pipeline.getJSONObject(i);
        _pipeline.add(Document.parse(stage.toString()));
      }
    } catch (JSONException err) {

    }
    AggregateIterable<Document> cursor = localCollection.aggregate(_pipeline);
    ArrayList<Document> results = (ArrayList<Document>) cursor.into(new ArrayList<Document>());
    return results;
  }

  public int count(String databaseName, String collectionName, JSONObject filter) {
    MongoCollection<Document> localCollection = mobileClient.getDatabase(databaseName).getCollection(collectionName);
    return (int) localCollection.count(Document.parse(filter.toString()));
  }

  public JSONArray find(String databaseName, String collectionName, JSONObject filter) {
    MongoCollection<Document> localCollection = mobileClient.getDatabase(databaseName).getCollection(collectionName);
    Document query = Document.parse(filter.toString());
    FindIterable<Document> cursor = localCollection.find(query);
    ArrayList<Document> results = (ArrayList<Document>) cursor.into(new ArrayList<Document>());
    JSONArray _result = new JSONArray();
    try {
      for (int i = 0; i < results.size(); i++) {
        JSONObject json = new JSONObject(results.get(i).toJson());
        _result.put(json);
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return _result;
  }

  public JSONObject findOne(String database, String collection, JSONObject criteria) {
    MongoCollection<Document> localCollection = mobileClient.getDatabase(database).getCollection(collection);
    Document query = Document.parse(criteria.toString());
    Document queryResult = localCollection.find(query).first();
    JSONObject _response = null;
    if (queryResult != null) {
      try {
        _response = new JSONObject(queryResult.toJson());
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
    return _response;
  }

  public JSONObject findById(String database, String collection, String id) {
    MongoCollection<Document> localCollection = mobileClient.getDatabase(database).getCollection(collection);
    JSONObject _query = new JSONObject();
    try {
      try {
        ObjectId oid = new ObjectId(id);
        JSONObject _oid = new JSONObject();
        _oid.put("$oid", id);
        _query.put("_id", _oid);
      } catch (IllegalArgumentException ie) {
        _query.put("_id", new JSONObject(id));
      }
    } catch (JSONException e) {
      try {
        _query.put("_id", id);
      } catch (JSONException e2) {
        e.printStackTrace();
      }
    }
    Document queryResult = localCollection.find(Document.parse(_query.toString())).first();
    JSONObject _response = null;
    if (queryResult != null) {
      try {
        _response = new JSONObject(queryResult.toJson());
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
    return _response;
  }

  public JSONObject findOneAndUpdate(String database, String collection, JSONObject criteria, JSONObject updateJSON) {
    MongoCollection<Document> localCollection = mobileClient.getDatabase(database).getCollection(collection);
    Document query = Document.parse(criteria.toString());
    Document updateDoc = Document.parse(updateJSON.toString());
    Document result = localCollection.findOneAndUpdate(query, updateDoc);
    JSONObject _response = null;
    if (result != null) {
      try {
        _response = new JSONObject(result.toJson());
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
    return _response;
  }

  public JSONObject findOneAndReplace(String database, String collection, JSONObject criteria, JSONObject updateJSON) {
    MongoCollection<Document> localCollection = mobileClient.getDatabase(database).getCollection(collection);
    Document query = Document.parse(criteria.toString());
    Document replaceDoc = Document.parse(updateJSON.toString());
    Document result = localCollection.findOneAndReplace(query, replaceDoc);
    JSONObject _response = null;
    if (result != null) {
      try {
        _response = new JSONObject(result.toJson());
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
    return _response;
  }

  public JSONObject findOneAndDelete(String database, String collection, JSONObject criteria) {
    MongoCollection<Document> localCollection = mobileClient.getDatabase(database).getCollection(collection);
    Document query = Document.parse(criteria.toString());
    Document result = localCollection.findOneAndDelete(query);
    JSONObject _response = null;
    if (result != null) {
      try {
        _response = new JSONObject(result.toJson());
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
    return _response;
  }

  public JSONObject insertOne(String database, String collection, JSONObject document) {
    MongoCollection<Document> localCollection = mobileClient.getDatabase(database).getCollection(collection);
    Document _document = Document.parse(document.toString());
    localCollection.insertOne(_document);
    JSONObject _response = new JSONObject();
    try {
      _response = new JSONObject(_document.toJson());
    } catch (JSONException e) {
      e.printStackTrace();
    }

    return _response;
  }

  public JSONArray insertMany(String database, String collection, JSONArray documents) {
    MongoCollection<Document> localCollection = mobileClient.getDatabase(database).getCollection(collection);
    List<Document> _documents = new ArrayList();
    JSONArray _result = new JSONArray();
    try {
      for (int i = 0, size = documents.length(); i < size; i++) {
        JSONObject stage = documents.getJSONObject(i);
        _documents.add(Document.parse(stage.toString()));
      }
      localCollection.insertMany(_documents);
      for (int i = 0; i < _documents.size(); i++) {
        JSONObject json = new JSONObject(_documents.get(i).toJson());
        _result.put(json);
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return _result;
  }

  public JSONObject replaceOne(String database, String collection, JSONObject criteria, JSONObject updateJSON) {
    MongoCollection<Document> localCollection = mobileClient.getDatabase(database).getCollection(collection);
    Document query = Document.parse(criteria.toString());
    Document updateDoc = Document.parse(updateJSON.toString());
    UpdateResult result = localCollection.replaceOne(query, updateDoc, new UpdateOptions().upsert(true));
    JSONObject _result = new JSONObject();
    try {
      _result.put("matchedCount", result.getMatchedCount());
      _result.put("modifiedCount", result.getModifiedCount());
      BsonValue id = result.getUpsertedId();
      if (id != null) {
        JSONObject oid = new JSONObject();
        oid.put("$oid", id.asObjectId().getValue());
        _result.put("upsertedId", oid);
      }
      _result.put("query", criteria);
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return _result;
  }

  public JSONObject updateOne(String database, String collection, JSONObject criteria, JSONObject updateJSON) {
    MongoCollection<Document> localCollection = mobileClient.getDatabase(database).getCollection(collection);
    Document query = Document.parse(criteria.toString());
    Document updateDoc = Document.parse(updateJSON.toString());
    UpdateResult result = localCollection.updateOne(query, updateDoc);
    JSONObject _result = new JSONObject();
    try {
      _result.put("matchedCount", result.getMatchedCount());
      _result.put("modifiedCount", result.getModifiedCount());
      BsonValue id = result.getUpsertedId();
      if (id != null) {
        JSONObject oid = new JSONObject();
        oid.put("$oid", id.asObjectId().getValue());
        _result.put("upsertedId", oid);
      }
      _result.put("query", criteria);
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return _result;
  }

  public JSONObject updateMany(String database, String collection, JSONObject criteria, JSONObject updateJSON) {
    MongoCollection<Document> localCollection = mobileClient.getDatabase(database).getCollection(collection);
    Document query = Document.parse(criteria.toString());
    Document updateDoc = Document.parse(updateJSON.toString());
    UpdateResult result = localCollection.updateMany(query, updateDoc);
    JSONObject _result = new JSONObject();
    try {
      _result.put("matchedCount", result.getMatchedCount());
      _result.put("modifiedCount", result.getModifiedCount());
      BsonValue id = result.getUpsertedId();
      if (id != null) {
        JSONObject oid = new JSONObject();
        oid.put("$oid", id.asObjectId().getValue());
        _result.put("upsertedId", oid);
      }
      _result.put("query", criteria);
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return _result;
  }

  public JSONObject deleteOne(String database, String collection, JSONObject criteria) {
    MongoCollection<Document> localCollection = mobileClient.getDatabase(database).getCollection(collection);
    Document query = Document.parse(criteria.toString());
    DeleteResult result = localCollection.deleteOne(query);
    JSONObject _result = new JSONObject();
    try {
      _result.put("deletedCount", result.getDeletedCount());
      _result.put("query", criteria);
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return _result;
  }

  public JSONObject deleteMany(String database, String collection, JSONObject criteria) {
    MongoCollection<Document> localCollection = mobileClient.getDatabase(database).getCollection(collection);
    Document query = Document.parse(criteria.toString());
    DeleteResult result = localCollection.deleteMany(query);
    JSONObject _result = new JSONObject();
    try {
      _result.put("deletedCount", result.getDeletedCount());
      _result.put("query", criteria);
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return _result;
  }

}
