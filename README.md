# gudsi-mongodb-plugin

This is a Cordova plugin that exposes the functionality of MongoDB Mobile to a Cordova Android app for local storage.

### Install
To install this plugin run `cordova plugin add gudsi-mongodb-plugin` in your projects root folder.

### Ionic integration
To use the plugin in ionic project run `npm install ionic-native-mongodb` in your projects root folder.<br>
[Ionic Native MongoDB](https://github.com/luisbobadilla/ionic-native-mongodb) 

### Functions

Below are the functions that are exposed in the plugin.

---

#### initiate(`appId: string`)

This function has to be called before doing anything else, this is a mongodb mobile requirement <br>
`appId` the id of this app, this is more usefull when you are using stitch but mongo does it need the initialization.  <br>

---

#### dropDatabase(`databaseName: string`)

[API reference for dropDatabase](https://docs.mongodb.com/manual/reference/method/db.dropDatabase/) <br>

`databaseName` the name of the database to delete.

---

#### createCollection(`databaseName: string`,`collectionName: string`,`schema?: JSONObject`)

[API reference for createCollection](https://docs.mongodb.com/manual/reference/method/db.createCollection/) <br>

`databaseName` the name of the database.<br>
`collectionName` the name of the new collection.<br>
`schema` the schema with JSON Schema validation $jsonSchema.<br>

---

#### dropCollection(`databaseName: string`,`collectionName: string`)

[API reference for dropCollection](https://docs.mongodb.com/manual/reference/method/db.collection.drop/) <br>

`databaseName` the name of the database that contains the database to delete.
`collectionName` the name of the collection to delete.

---

#### listCollectionNames(`databaseName: string`)

[API reference for getCollectionNames](https://docs.mongodb.com/manual/reference/method/db.getCollectionNames/) <br>

`databaseName` the name of the database to explore.

---

#### createIndex(`databaseName: string`, `collectionName: string`, `keys: JSONObject`, `indexOptions: JSONObject`) 

[API reference for createIndex](https://docs.mongodb.com/manual/reference/method/db.collection.createIndex/) <br>

`databaseName` the name of the database that is to be used. <br>
`collectionName` the name of the collection that is to be used. <br>
`keys` a document that contains the field and value pairs where the field is the index key and the value describes the type of index for that field. <br>
`indexOptions` a document that contains a set of options that controls the creation of the index. <br>

---

#### dropIndex(`databaseName: string`, `collectionName: string`, `indexName: string`) 

[API reference for dropIndex](https://docs.mongodb.com/manual/reference/method/db.collection.dropIndex/) <br>

`databaseName` the name of the database that is to be used. <br>
`collectionName` the name of the collection that is to be used. <br>
`indexName` Specifies the name of the index to drop. <br>

---

#### aggregate(`databaseName: string`, `collectionName: string`, `pipeline: JSONArray`) 

[API reference for aggregate](https://docs.mongodb.com/manual/reference/method/db.collection.aggregate/) <br>

`databaseName` the name of the database that is to be used. <br>
`collectionName` the name of the collection that is to be used. <br>
`pipeline` A sequence of data aggregation operations or stages. <br>
[API reference for aggregation pipeline stages](https://docs.mongodb.com/manual/reference/operator/aggregation-pipeline/) <br>

---

#### count(`databaseName: string`, `collectionName: string`, `query?: JSONObject`) 

[API reference for count](https://docs.mongodb.com/manual/reference/method/db.collection.count/) <br>

`databaseName` the name of the database that is to be used. <br>
`collectionName` the name of the collection that is to be used. <br>
`query` the query selection criteria. <br>

---

#### find(`databaseName: string`, `collectionName: string`, `query?: JSONObject`) 

[API reference for find](https://docs.mongodb.com/manual/reference/method/db.collection.find/) <br>

`databaseName` the name of the database that is to be used. <br>
`collectionName` the name of the collection that is to be used. <br>
`query` (optional) Specifies selection filter using query operators. To return all documents in a collection, omit this parameter or pass an empty document  <br>

---

#### findOne(`databaseName: string`, `collectionName: string`, `query?: JSONObject`) 

[API reference for findOne](https://docs.mongodb.com/manual/reference/method/db.collection.findOne/) <br>

`databaseName` the name of the database that is to be used. <br>
`collectionName` the name of the collection that is to be used. <br>
`query` (optional) Specifies query selection criteria using query operators. <br>

---

#### findById(`databaseName: string`, `collectionName: string`, `id: string | {$oid:string}`) 

`databaseName` the name of the database that is to be used. <br>
`collectionName` the name of the collection that is to be used. <br>
`id` the id of the element to find. <br>

---

#### findOneAndUpdate(`databaseName: string`, `collectionName: string`, `query: JSONObject`,`update: JSONObject`) 

[API reference for findOneAndUpdate](https://docs.mongodb.com/manual/reference/method/db.collection.findOneAndUpdate/) <br>

`databaseName` the name of the database that is to be used. <br>
`collectionName` the name of the collection that is to be used. <br>
`query` the selection criteria for the update. The same query selectors as in the find() method are available. <br>
`update` the update document. <br>

---

#### findOneAndReplace(`databaseName: string`, `collectionName: string`, `query: JSONObject`,`replacement: JSONObject`) 

[API reference for findOneAndReplace](https://docs.mongodb.com/manual/reference/method/db.collection.findOneAndReplace/) <br>

`databaseName` the name of the database that is to be used. <br>
`collectionName` the name of the collection that is to be used. <br>
`query` the selection criteria for the update. The same query selectors as in the find() method are available. <br>
`replacement` the replacement document. <br>

---

#### findOneAndDelete(`databaseName: string`, `collectionName: string`, `query: JSONObject`) 

[API reference for findOneAndDelete](https://docs.mongodb.com/manual/reference/method/db.collection.findOneAndDelete/) <br>

`databaseName` the name of the database that is to be used. <br>
`collectionName` the name of the collection that is to be used. <br>
`query` the selection criteria for the delete. The same query selectors as in the find() method are available. <br>

---

#### insertOne(`databaseName: string`, `collectionName: string`, `document: JSONObject`) 

[API reference for insertOne](https://docs.mongodb.com/manual/reference/method/db.collection.insertOne/) <br>

`databaseName` the name of the database that is to be used. <br>
`collectionName` the name of the collection that is to be used. <br>
`document` a document to insert into the collection. <br>

---

#### insertMany(`databaseName: string`, `collectionName: string`, `documents: JSONArray`) 

[API reference for insertMany](https://docs.mongodb.com/manual/reference/method/db.collection.insertMany/) <br>

`databaseName` the name of the database that is to be used. <br>
`collectionName` the name of the collection that is to be used. <br>
`documents` an array of documents to insert into the collection. <br>

---

#### replaceOne(`databaseName: string`, `collectionName: string`, `query: JSONObject` , `replacement: JSONObject`) 

[API reference for replaceOne](https://docs.mongodb.com/manual/reference/method/db.collection.replaceOne/) <br>

`databaseName` the name of the database that is to be used. <br>
`collectionName` the name of the collection that is to be used. <br>
`query` the selection criteria for the update. The same query selectors as in the find() method are available. <br>
`replacement` the replacement document. <br>

---

#### updateOne(`databaseName: string`, `collectionName: string`, `query: JSONObject` , `update: JSONObject`) 

[API reference for updateOne](https://docs.mongodb.com/manual/reference/method/db.collection.updateOne/) <br>

`databaseName` the name of the database that is to be used. <br>
`collectionName` the name of the collection that is to be used. <br>
`query` the selection criteria for the update. The same query selectors as in the find() method are available. <br>
`update` the modifications to apply. <br>

---

#### updateMany(`databaseName: string`, `collectionName: string`, `query: JSONObject` , `update: JSONObject`) 

[API reference for updateMany](https://docs.mongodb.com/manual/reference/method/db.collection.updateMany/) <br>

`databaseName` the name of the database that is to be used. <br>
`collectionName` the name of the collection that is to be used. <br>
`query` the selection criteria for the update. The same query selectors as in the find() method are available. <br>
`update` the modifications to apply. <br>

---

#### deleteOne(`databaseName: string`, `collectionName: string`, `query: JSONObject`) 

[API reference for deleteOne](https://docs.mongodb.com/manual/reference/method/db.collection.deleteOne/) <br>

`databaseName` the name of the database that is to be used. <br>
`collectionName` the name of the collection that is to be used. <br>
`query` specifies deletion criteria using query operators. <br>

---

#### deleteMany(`databaseName: string`, `collectionName: string`, `query: JSONObject`) 

[API reference for deleteMany](https://docs.mongodb.com/manual/reference/method/db.collection.deleteMany/) <br>

`databaseName` the name of the database that is to be used. <br>
`collectionName` the name of the collection that is to be used. <br>
`query` specifies deletion criteria using query operators. <br>

---