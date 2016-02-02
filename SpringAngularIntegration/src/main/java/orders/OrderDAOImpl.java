package orders;

import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public void add(Order order) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public List<Order> getAllOrders() {
        Session session = null;
        List<Order> orders = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            orders = session.createCriteria(Order.class).list();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
        return orders;
    }

    @Override
    public void update(Order order) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(order);
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
    public void delete(Order order) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(order);
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
    public Order getOrderById(Long id) {
        Session session = null;
        Order order = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            order = session.get(Order.class, id);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
        return order;
    }

    @Override
    public List<Order> getOrdersById(Long id) {
        Session session = null;
        List<Order> orders = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            orders = session.createCriteria(Order.class).add(Expression.eq("orderId", id)).list();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
        return orders;
    }

}
