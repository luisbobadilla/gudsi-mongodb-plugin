package com.gudsi.mongodb;

import com.mongodb.client.MongoClient;

public class MongodbControl {

  MongoClient mobileClient;
  public void setClient(MongoClient _mobileClient){
    mobileClient=_mobileClient;
  }

  public void dropDatabase(String databaseName) {
    mobileClient.getDatabase(databaseName).drop();
  }

}
