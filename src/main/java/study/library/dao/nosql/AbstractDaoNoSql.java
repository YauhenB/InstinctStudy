package study.library.dao.nosql;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yauhen on 16.12.16.
 */
public abstract class AbstractDaoNoSql<T> {
    private static MongoClient client = new MongoClient("localhost", 27017);
    private static MongoDatabase db = client.getDatabase("library");
    private String collName = getCollName();
    private MongoCollection<Document> collection = db.getCollection(collName);

    public String getCollName() {
        return "";
    }

    public void create(T entity) {
        Document dbObject = toMongoObj(entity);
        collection.insertOne(dbObject);
    }


    public void delete(final T entity) {
        collection.deleteOne(toMongoObj(entity));
    }

    public List<T> getAll() {
        List<T> results = new ArrayList<T>();
        for (Document document : collection.find()) {
            results.add(fromMongoObj(document));
        }

        return results;
    }

    public List<T> getByParam(final String paramName, final Object value) {
        List<T> results = new ArrayList<T>();
        Document searchQuery = new Document();
        searchQuery.put(paramName, value);
        for (Document document : collection.find(searchQuery)) {
            results.add(fromMongoObj(document));
        }

        return results;
    }

    public abstract Document toMongoObj(T entity);

    public abstract T fromMongoObj(Document document);


}
