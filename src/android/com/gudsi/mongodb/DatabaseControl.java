package com.gudsi.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.ValidationAction;
import com.mongodb.client.model.ValidationLevel;
import com.mongodb.client.model.ValidationOptions;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

public class DatabaseControl {

    MongoClient mobileClient;

    public void setClient(MongoClient _mobileClient){
        mobileClient=_mobileClient;
    }

    public String createCollection(String database, String collectionName, JSONObject schema) {
        MongoDatabase _database = mobileClient.getDatabase(database);
        Document _schema = Document.parse(schema.toString());
        CreateCollectionOptions _options = new CreateCollectionOptions().autoIndex(true)
                .validationOptions(new ValidationOptions().validationLevel(ValidationLevel.STRICT).validationAction(ValidationAction.ERROR).validator(_schema));
        _database.createCollection(collectionName, _options);
        return collectionName;
    }

    public String dropCollection(String database, String collectionName) {
        MongoDatabase _database = mobileClient.getDatabase(database);
        _database.getCollection(collectionName).drop();
        return "true";
    }

    public JSONArray listCollectionNames(String database) {
        MongoDatabase _database = mobileClient.getDatabase(database);
        MongoIterable<String> names = _database.listCollectionNames();
        JSONArray result = new JSONArray();
        MongoCursor<String> cursor = names.iterator();
        while (cursor.hasNext()) {
            String _name = cursor.next();
            result.put(_name);
        }
        return result;
    }
}
