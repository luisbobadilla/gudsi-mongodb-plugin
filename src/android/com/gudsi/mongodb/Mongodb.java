package com.gudsi.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.stitch.android.core.Stitch;
import com.mongodb.stitch.android.core.StitchAppClient;
import com.mongodb.stitch.android.services.mongodb.local.LocalMongoDbService;

import java.util.ArrayList;

import org.bson.Document;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONObject;

public class Mongodb extends CordovaPlugin {

  protected CallbackContext context;
  private MongodbControl mongo = new MongodbControl();
  private CollectionControl collection = new CollectionControl();
  private DatabaseControl database = new DatabaseControl();
  MongoClient mobileClient;

  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) {

    context = callbackContext;
    boolean result = true;
    switch (action){
      //general functions
      case "initiate":
        try {
            this.initiate(args.getString(0));
            mongo.setClient(mobileClient);
            database.setClient(mobileClient);
            collection.setClient(mobileClient);
          callbackContext.success("true");
        } catch (Exception e) {
          callbackContext.error(e.toString());
        }
        break;
      case "dropDatabase":
        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            try {
              mongo.dropDatabase(args.getString(0));
              callbackContext.success("true");
            } catch (Exception e) {
              callbackContext.error(e.toString());
            }
          }
        });
        break;
      //database functions
      case "createCollection":
        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            try {
              String result = database.createCollection(args.getString(0), args.getString(1), args.getJSONObject(2));
              callbackContext.success(result);
            } catch (Exception e) {
              callbackContext.error(e.toString());
            }
          }
        });
        break;
      case "dropCollection":
        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            try {
              String result = database.dropCollection(args.getString(0), args.getString(1));
              callbackContext.success(result);
            } catch (Exception e) {
              callbackContext.error(e.toString());
            }
          }
        });
        break;
      case "listCollectionNames":
        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            try {
              JSONArray result = database.listCollectionNames(args.getString(0));
              callbackContext.success(result);
            } catch (Exception e) {
              callbackContext.error(e.toString());
            }
          }
        });
        break;
      //collection functions
      case "createIndex":
        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            try {
              String created = collection.createIndex(args.getString(0), args.getString(1), args.getJSONObject(2), args.getJSONObject(3));
              callbackContext.success(created);
            } catch (Exception e) {
              callbackContext.error(e.toString());
            }
          }
        });
        break;
      case "dropIndex":
        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            try {
              String created = collection.dropIndex(args.getString(0), args.getString(1), args.getString(2));
              callbackContext.success(created);
            } catch (Exception e) {
              callbackContext.error(e.toString());
            }
          }
        });
        break;
      case "aggregate":
        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            try {
              ArrayList<Document> document = collection.aggregate(args.getString(0),args.getString(1),args.getJSONArray(2));
              JSONArray returnJSON = new JSONArray();
              for (int i = 0; i < document.size(); i++) {
                JSONObject json = new JSONObject(document.get(i).toJson());
                returnJSON.put(json);
              }
              callbackContext.success(returnJSON);
            } catch (Exception e) {
              callbackContext.error(e.toString());
            }
          }
        });
        break;
      case "count":
        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            try {
              int results = collection.count(args.getString(0),args.getString(1),args.getJSONObject(2));
              callbackContext.success(results);
            } catch (Exception e) {
              callbackContext.error(e.toString());
            }
          }
        });
        break;
      case "find":
        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            try {
              JSONArray result = collection.find(args.getString(0), args.getString(1),args.getJSONObject(2));
              callbackContext.success(result);
            } catch (Exception e) {
              callbackContext.error(e.toString());
            }
          }
        });
        break;
      case "findOne":
        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            try {
              JSONObject result = collection.findOne(args.getString(0), args.getString(1), args.getJSONObject(2));
              if(result==null){
                callbackContext.success("null");
              }else{
                callbackContext.success(result);
              }
            } catch (Exception e) {
              callbackContext.error(e.toString());
            }
          }
        });
        break;
      case "findById":
        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            try {
              JSONObject result = collection.findById(args.getString(0), args.getString(1), args.getString(2));
              if(result==null){
                callbackContext.success("null");
              }else{
                callbackContext.success(result);
              }
            } catch (Exception e) {
              callbackContext.error(e.toString());
            }
          }
        });
        break;
      case "findOneAndUpdate":
        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            try {
              JSONObject result = collection.findOneAndUpdate(args.getString(0), args.getString(1), args.getJSONObject(2), args.getJSONObject(3));
              if(result==null){
                callbackContext.success("null");
              }else{
                callbackContext.success(result);
              }
            } catch (Exception e) {
              callbackContext.error(e.toString());
            }
          }
        });
        break;
      case "findOneAndReplace":
        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            try {
              JSONObject result = collection.findOneAndReplace(args.getString(0), args.getString(1), args.getJSONObject(2), args.getJSONObject(3));
              if(result==null){
                callbackContext.success("null");
              }else{
                callbackContext.success(result);
              }
            } catch (Exception e) {
              callbackContext.error(e.toString());
            }
          }
        });
        break;
      case "findOneAndDelete":
        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            try {
              JSONObject result = collection.findOneAndDelete(args.getString(0), args.getString(1), args.getJSONObject(2));
              if(result==null){
                callbackContext.success("null");
              }else{
                callbackContext.success(result);
              }
            } catch (Exception e) {
              callbackContext.error(e.toString());
            }
          }
        });
        break;
      case "insertOne":
        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            try {
              JSONObject result = collection.insertOne(args.getString(0), args.getString(1), args.getJSONObject(2));
              callbackContext.success(result);
            } catch (Exception e) {
              callbackContext.error(e.getMessage());
            }
          }
        });
        break;
      case "insertMany":
        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            try {
              JSONArray result = collection.insertMany(args.getString(0), args.getString(1), args.getJSONArray(2));
              callbackContext.success(result);
            } catch (Exception e) {
              callbackContext.error(e.toString());
            }
          }
        });
        break;
      case "replaceOne":
        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            try {
              JSONObject result = collection.replaceOne(args.getString(0), args.getString(1), args.getJSONObject(2),args.getJSONObject(3));
              callbackContext.success(result);
            } catch (Exception e) {
              callbackContext.error(e.toString());
            }
          }
        });
        break;
      case "updateOne":
        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            try {
              JSONObject result = collection.updateOne(args.getString(0), args.getString(1), args.getJSONObject(2),args.getJSONObject(3));
              callbackContext.success(result);
            } catch (Exception e) {
              callbackContext.error(e.toString());
            }
          }
        });
        break;
      case "updateMany":
        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            try {
              JSONObject result = collection.updateMany(args.getString(0), args.getString(1), args.getJSONObject(2),args.getJSONObject(3));
              callbackContext.success(result);
            } catch (Exception e) {
              callbackContext.error(e.toString());
            }
          }
        });
        break;
      case "deleteOne":
        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            try {
              JSONObject result = collection.deleteOne(args.getString(0), args.getString(1), args.getJSONObject(2));
              callbackContext.success(result);
            } catch (Exception e) {
              callbackContext.error(e.toString());
            }
          }
        });
        break;
      case "deleteMany":
        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            try {
              JSONObject result = collection.deleteMany(args.getString(0), args.getString(1), args.getJSONObject(2));
              callbackContext.success(result);
            } catch (Exception e) {
              callbackContext.error(e.toString());
            }
          }
        });
        break;
        default:
          context.error("Invalid Action");
          result = false;
          break;
    }

    return result;

  }


  public void initiate(String appID) {
    try{
      StitchAppClient _default = Stitch.getAppClient(appID);
      mobileClient = _default.getServiceClient(LocalMongoDbService.clientFactory);
    }catch (IllegalStateException e){
      final StitchAppClient client = Stitch.initializeDefaultAppClient(appID);
      mobileClient = client.getServiceClient(LocalMongoDbService.clientFactory);
    }
  }
}
