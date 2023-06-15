import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBServiceSender {
    public static void sendAccountName(String accountName) {
        try {
            // Set up connection to MongoDB database
            String connectionString = "mongodb://localhost:27017"; // Replace with your MongoDB connection string
            MongoClientURI uri = new MongoClientURI(connectionString);
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("your_database_name"); // Replace with your database name

            // Get or create a collection to store account names
            MongoCollection<Document> collection = database.getCollection("account_names");

            // Create a document with the account name
            Document accountNameDocument = new Document("name", accountName);

            // Insert the document into the collection
            collection.insertOne(accountNameDocument);

            System.out.println("Account name sent successfully to MongoDB.");
        } catch (Exception e) {
            System.out.println("An error occurred while sending account name: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String accountName = "Example Account";
        sendAccountName(accountName);
    }
}
