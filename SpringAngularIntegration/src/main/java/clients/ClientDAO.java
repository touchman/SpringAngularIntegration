package clients;

import java.util.List;

public interface ClientDAO {
    void add(Client client);
    List<Client> getAllClients();
    void update(Client client);
    void delete(Client client);
    Client getClientsById(Long id);
}
