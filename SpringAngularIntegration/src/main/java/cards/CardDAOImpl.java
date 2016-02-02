package cards;

import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class CardDAOImpl implements CardDAO {
    @Override
    public void add(Card card) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(card);
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
    public List<Card> getAllCards() {
        Session session = null;
        List<Card> cards = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            cards = session.createCriteria(Card.class).list();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return cards;
    }

    @Override
    public void update(Card card) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(card);
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
    public void delete(Card card) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(card);
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
    public Card getCardById(Long id) {
        Session session = null;
        Card card = new Card();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            card = session.get(Card.class, id);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
        return card;
    }

    @Override
    public List<Card> getCardsById(Long id) {
        Session session = null;
        List<Card> cards = new ArrayList<>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            cards = session.createCriteria(Card.class).add(Expression.eq("cardId", id)).list();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
        return cards;
    }
}
