import java.util.ArrayList;
import java.util.List;

public class Database {

    private static Database instance = null;
    private static ArrayList<Client> clients = new ArrayList<>();

    private Database() {}

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public static void addClient(Client newClient) {
        clients.add(newClient);
    }


    public static List<Client> getClient() {
        return clients;
    }
}



