package Controller;

import clients.Client;
import clients.ClientsFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {


    @RequestMapping(method = RequestMethod.GET, value = "/{clientId}/")
    public Client getClient(@PathVariable Long clientId) {
        return ClientsFactory.getInstance().getClientDAO().getClientsById(clientId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<Client> getAllClients(){
        List<Client> clients = ClientsFactory.getInstance().getClientDAO().getAllClients();
        return clients;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{clientId}")
    public void delete(@PathVariable Long clientId){
        Client client = ClientsFactory.getInstance().getClientDAO().getClientsById(clientId);
        ClientsFactory.getInstance().getClientDAO().delete(client);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public void addClient(@RequestBody Client client){
        ClientsFactory.getInstance().getClientDAO().add(client);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{clientId}")
    public void update(@RequestBody Client client, @PathVariable Long clientId){
        client.setId(clientId);
        ClientsFactory.getInstance().getClientDAO().update(client);
    }
}