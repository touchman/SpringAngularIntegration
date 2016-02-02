package cards;

public class CardsFactory {
    private static CardsFactory instance;
    private static CardDAO cardDAO;

    private CardsFactory(){}

    public static synchronized CardsFactory getInstance(){
        if(instance == null){
            instance = new CardsFactory();
        }
        return instance;
    }

    public CardDAO getCardDAO(){
        if(cardDAO == null){
            cardDAO = new CardDAOImpl();
        }
        return cardDAO;
    }
}
