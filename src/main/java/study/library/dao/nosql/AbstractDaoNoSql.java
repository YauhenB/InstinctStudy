package study.library.dao.nosql;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * /**
 * Common DAO methods for both types, using NoSQL database.
 *
 * @param <T> Entity name
  */
public abstract class AbstractDaoNoSql<T> {
    private static final String HOST = "localhost";
    private static final Integer PORT = 27017;
    private static MongoClient client = new MongoClient(HOST, PORT);
    private static MongoDatabase db = client.getDatabase("library");
    private final String collName = getCollName();
    private final MongoCollection<Document> collection = db.getCollection(collName);

    public abstract String getCollName();

    public void create(final T entity) {
        final Document dbObject = toMongoObj(entity);
        collection.insertOne(dbObject);
    }


    public void delete(final T entity) {
        collection.deleteOne(toMongoObj(entity));
    }

    /**
     * Loading all instances from database.
     * @return List of instances
     */
    public List<T> load() {
        final List<T> results = new ArrayList<T>();
        for (final Document document : collection.find()) {
            results.add(fromMongoObj(document));
        }

        return results;
    }

    /**
     * Loading instances from DB, filtered by parameter.
     * @param paramName Name of parameter
     * @param value Parameter value
     * @return List of instances
     */
    public List<T> load(final String paramName, final Object value) {
        final List<T> results = new ArrayList<T>();
        final Document searchQuery = new Document();
        searchQuery.put(paramName, value);
        for (final Document document : collection.find(searchQuery)) {
            results.add(fromMongoObj(document));
        }

        return results;
    }

    public abstract Document toMongoObj(T entity);

    public abstract T fromMongoObj(Document document);


}
