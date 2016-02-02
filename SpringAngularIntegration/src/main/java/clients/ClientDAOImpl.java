package clients;

import org.hibernate.Session;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {
    @Override
    public void add(Client client) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public List<Client> getAllClients() {
        Session session = null;
        List<Client> clients = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            clients = session.createCriteria(Client.class).list();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
        return clients;
    }

    @Override
    public void update(Client client) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(client);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Client client) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Client getClientsById(Long id) {
        Session session = null;
        Client client = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            client =(Client) session.get(Client.class, id);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
        return client;
    }
}
