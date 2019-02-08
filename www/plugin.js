
  var exec = cordova.require('cordova/exec');
  function mongodb() { }

  //general functions
  mongodb.prototype.initiate = function (appId) {
    return call('Mongodb', 'initiate', [appId]);
  };

  mongodb.prototype.dropDatabase = function (databaseName) {
    return call('Mongodb', 'dropDatabase', [databaseName]);
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

  mongodb.prototype.count = function (databaseName, collectionName, query) {
    return call('Mongodb', 'count', [databaseName, collectionName, query||{}]);
  };

  mongodb.prototype.find = function (databaseName, collectionName, query) {
    return call('Mongodb', 'find', [databaseName, collectionName, query||{}]);
  };

  mongodb.prototype.findOne = function (databaseName, collectionName, query) {
    return call('Mongodb', 'findOne', [databaseName, collectionName, query||{}]);
  };

  mongodb.prototype.findById = function (databaseName, collectionName,id) {
    return call('Mongodb', 'findById', [databaseName, collectionName,id||'']);
  };

  mongodb.prototype.findOneAndUpdate = function (databaseName, collectionName,query, update) {
    return call('Mongodb', 'findOneAndUpdate', [databaseName, collectionName,query, update]);
  };

  mongodb.prototype.findOneAndReplace = function (databaseName, collectionName,query, update) {
    return call('Mongodb', 'findOneAndReplace', [databaseName, collectionName,query, update]);
  };

  mongodb.prototype.findOneAndDelete = function (databaseName, collectionName,query) {
    return call('Mongodb', 'findOneAndDelete', [databaseName, collectionName,query]);
  };

  mongodb.prototype.insertOne = function (databaseName, collectionName, document) {
    return call('Mongodb', 'insertOne', [databaseName, collectionName, document||{}]);
  };

  mongodb.prototype.insertMany = function (databaseName, collectionName, documents) {
    return call('Mongodb', 'insertMany', [databaseName, collectionName, documents||[]]);
  };

  mongodb.prototype.replaceOne = function (databaseName, collectionName, query, update) {
    return call('Mongodb', 'replaceOne', [databaseName, collectionName, query, update]);
  };

  mongodb.prototype.updateOne = function (databaseName, collectionName, query, update) {
    return call('Mongodb', 'updateOne', [databaseName, collectionName, query, update]);
  };

  mongodb.prototype.updateMany = function (databaseName, collectionName, query, update) {
    return call('Mongodb', 'updateMany', [databaseName, collectionName, query, update]);
  };

  mongodb.prototype.deleteOne = function (databaseName, collectionName, query) {
    return call('Mongodb', 'deleteOne', [databaseName, collectionName, query]);
  };

  mongodb.prototype.deleteMany = function (databaseName, collectionName, query) {
    return call('Mongodb', 'deleteMany', [databaseName, collectionName, query]);
  };

  function call(className, action, options) {
    return new Promise(function (resolve, reject) {
      exec(resolve, reject, className, action, options);
    });
  }




