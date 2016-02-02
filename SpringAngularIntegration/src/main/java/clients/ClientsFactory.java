package clients;

public class ClientsFactory {
    private static ClientsFactory instance;
    private static ClientDAO clientDAO;
    
    private ClientsFactory(){}

    public static synchronized ClientsFactory getInstance(){
        if(instance == null){
            instance = new ClientsFactory();
        }
        return instance;
    }

    public ClientDAO getClientDAO(){
        if(clientDAO == null){
            clientDAO = new ClientDAOImpl();
        }
        return clientDAO;
    }
}
