package Controller;

import cards.Card;
import cards.CardsFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    @RequestMapping(method = RequestMethod.GET, value = "/{cardId}/")
    public List<Card> getClient(@PathVariable Long cardId) {
        return CardsFactory.getInstance().getCardDAO().getCardsById(cardId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<Card> getAllCards(){
        List<Card> cards = CardsFactory.getInstance().getCardDAO().getAllCards();
        return cards;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{cardId}")
    public void delete(@PathVariable Long cardId){
        Card card = CardsFactory.getInstance().getCardDAO().getCardById(cardId);
        CardsFactory.getInstance().getCardDAO().delete(card);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public void addClient(@RequestBody Card card){
        CardsFactory.getInstance().getCardDAO().add(card);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{cardId}")
    public void update(@RequestBody Card card, @PathVariable Long cardId){
        card.setId(cardId);
        CardsFactory.getInstance().getCardDAO().update(card);
    }
}
