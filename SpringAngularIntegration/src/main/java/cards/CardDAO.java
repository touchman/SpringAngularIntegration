package cards;

import java.util.List;

public interface CardDAO {
    void add(Card card);
    List<Card> getAllCards();
    void update(Card card);
    void delete(Card card);
    List<Card> getCardsById(Long id);
    Card getCardById(Long id);
}
