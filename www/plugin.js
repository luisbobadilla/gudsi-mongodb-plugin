
  var exec = cordova.require('cordova/exec');
  var mongodb = {
    //general functions
    initiate: function (appId) {
      return call('Mongodb', 'initiate', [appId]);
    },

    dropDatabase: function (databaseName) {
      return call('Mongodb', 'dropDatabase', [databaseName]);
    },

    //database functions
    createCollection: function (databaseName, collectionName, schema) {
      return call('Mongodb', 'createCollection', [databaseName, collectionName, schema || {}]);
    },

    dropCollection: function (databaseName, collectionName) {
      return call('Mongodb', 'dropCollection', [databaseName, collectionName]);
    },

    listCollectionNames: function (databaseName) {
      return call('Mongodb', 'listCollectionNames', [databaseName]);
    },

    //collection functions
    createIndex: function (databaseName, collectionName, keys,indexOptions) {
      return call('Mongodb', 'createIndex', [databaseName, collectionName, keys,indexOptions||{}]);
    },

    dropIndex: function (databaseName, collectionName, indexName) {
      return call('Mongodb', 'dropIndex', [databaseName, collectionName, indexName]);
    },

    aggregate: function (databaseName, collectionName, pipeline) {
      return call('Mongodb', 'aggregate', [databaseName, collectionName, pipeline||[]]);
    },

    count: function (databaseName, collectionName, query) {
      return call('Mongodb', 'count', [databaseName, collectionName, query||{}]);
    },

    find: function (databaseName, collectionName, query) {
      return call('Mongodb', 'find', [databaseName, collectionName, query||{}]);
    },

    findOne: function (databaseName, collectionName, query) {
      return call('Mongodb', 'findOne', [databaseName, collectionName, query||{}]);
    },

    findById: function (databaseName, collectionName,id) {
      return call('Mongodb', 'findById', [databaseName, collectionName,id||'']);
    },

    findOneAndUpdate: function (databaseName, collectionName,query, update) {
      return call('Mongodb', 'findOneAndUpdate', [databaseName, collectionName,query, update]);
    },

    findOneAndReplace: function (databaseName, collectionName,query, update) {
      return call('Mongodb', 'findOneAndReplace', [databaseName, collectionName,query, update]);
    },

    findOneAndDelete: function (databaseName, collectionName,query) {
      return call('Mongodb', 'findOneAndDelete', [databaseName, collectionName,query]);
    },

    insertOne: function (databaseName, collectionName, document) {
      return call('Mongodb', 'insertOne', [databaseName, collectionName, document||{}]);
    },

    insertMany: function (databaseName, collectionName, documents) {
      return call('Mongodb', 'insertMany', [databaseName, collectionName, documents||[]]);
    },

    replaceOne: function (databaseName, collectionName, query, update) {
      return call('Mongodb', 'replaceOne', [databaseName, collectionName, query, update]);
    },

    updateOne: function (databaseName, collectionName, query, update) {
      return call('Mongodb', 'updateOne', [databaseName, collectionName, query, update]);
    },

    updateMany: function (databaseName, collectionName, query, update) {
      return call('Mongodb', 'updateMany', [databaseName, collectionName, query, update]);
    },

    deleteOne: function (databaseName, collectionName, query) {
      return call('Mongodb', 'deleteOne', [databaseName, collectionName, query]);
    },

    deleteMany: function (databaseName, collectionName, query) {
      return call('Mongodb', 'deleteMany', [databaseName, collectionName, query]);
    }
  }
  function call(className, action, options) {
    return new Promise(function (resolve, reject) {
      exec(resolve, reject, className, action, options);
    });
  }
  module.exports = mongodb;