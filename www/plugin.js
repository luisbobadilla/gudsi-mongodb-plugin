
  var exec = cordova.require('cordova/exec');
  function mongodb() { }

  //general functions
  mongodb.prototype.initiate = function (appId) {
    return call('Mongodb', 'initiate', [appId]);
  };

  mongodb.prototype.dropDatabase = function (databaseName, collectionName, schema) {
    return call('Mongodb', 'dropDatabase', [databaseName, collectionName, schema]);
  };

  //database functions
  mongodb.prototype.createCollection = function (databaseName, collectionName, schema) {
    return call('Mongodb', 'createCollection', [databaseName, collectionName, schema]);
  };

  mongodb.prototype.dropCollection = function (databaseName, collectionName) {
    return call('Mongodb', 'dropCollection', [databaseName, collectionName]);
  };

  mongodb.prototype.listCollectionNames = function (databaseName) {
    return call('Mongodb', 'listCollectionNames', [databaseName]);
  };

  //collection functions
  mongodb.prototype.createIndex = function (databaseName, collectionName, keys,indexOptions) {
    return call('Mongodb', 'createIndex', [databaseName, collectionName, keys,indexOptions||{}]);
  };

  mongodb.prototype.dropIndex = function (databaseName, collectionName, indexName) {
    return call('Mongodb', 'dropIndex', [databaseName, collectionName, indexName]);
  };

  mongodb.prototype.aggregate = function (databaseName, collectionName, pipeline) {
    return call('Mongodb', 'aggregate', [databaseName, collectionName, pipeline||[]]);
  };

  mongodb.prototype.count = function (databaseName, collectionName, filter) {
    return call('Mongodb', 'count', [databaseName, collectionName, filter||{}]);
  };

  mongodb.prototype.find = function (databaseName, collectionName, filter) {
    return call('Mongodb', 'find', [databaseName, collectionName, filter||{}]);
  };

  mongodb.prototype.findOne = function (databaseName, collectionName, filter) {
    return call('Mongodb', 'findOne', [databaseName, collectionName, filter||{}]);
  };

  mongodb.prototype.findById = function (databaseName, collectionName,id) {
    return call('Mongodb', 'findById', [databaseName, collectionName,id||'']);
  };

  mongodb.prototype.findOneAndUpdate = function (databaseName, collectionName,filter, update) {
    return call('Mongodb', 'findOneAndUpdate', [databaseName, collectionName,filter, update]);
  };

  mongodb.prototype.findOneAndReplace = function (databaseName, collectionName,filter, update) {
    return call('Mongodb', 'findOneAndReplace', [databaseName, collectionName,filter, update]);
  };

  mongodb.prototype.findOneAndDelete = function (databaseName, collectionName,filter) {
    return call('Mongodb', 'findOneAndDelete', [databaseName, collectionName,filter]);
  };

  mongodb.prototype.insertOne = function (databaseName, collectionName, document) {
    return call('Mongodb', 'insertOne', [databaseName, collectionName, document||{}]);
  };

  mongodb.prototype.insertMany = function (databaseName, collectionName, documents) {
    return call('Mongodb', 'insertMany', [databaseName, collectionName, documents||[]]);
  };

  mongodb.prototype.replaceOne = function (databaseName, collectionName, filter, update) {
    return call('Mongodb', 'replaceOne', [databaseName, collectionName, filter, update]);
  };

  mongodb.prototype.updateOne = function (databaseName, collectionName, filter, update) {
    return call('Mongodb', 'updateOne', [databaseName, collectionName, filter, update]);
  };

  mongodb.prototype.updateMany = function (databaseName, collectionName, filter, update) {
    return call('Mongodb', 'updateMany', [databaseName, collectionName, filter, update]);
  };

  mongodb.prototype.deleteOne = function (databaseName, collectionName, filter) {
    return call('Mongodb', 'deleteOne', [databaseName, collectionName, filter]);
  };

  mongodb.prototype.deleteMany = function (databaseName, collectionName, filter) {
    return call('Mongodb', 'deleteMany', [databaseName, collectionName, filter]);
  };

  function call(className, action, options) {
    return new Promise(function (resolve, reject) {
      exec(resolve, reject, className, action, options);
    });
  }




