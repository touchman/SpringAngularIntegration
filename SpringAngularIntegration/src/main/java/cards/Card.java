package cards;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "client_card")
public class Card {
    private Long id;
    private Long cardId;
    private String make;
    private String model;
    private Date year;
    private String vin;

    public Card(Long cardId, String make, String model, Date year, String vin) {
        this.cardId = cardId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.vin = vin;
    }

    public Card(){}

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "card_id")
    public Long getCardId() {
        return cardId;
    }

    @Column(name = "make")
    public String getMake() {
        return make;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    @Column(name = "year")
    public Date getYear() {
        return year;
    }

    @Column(name = "vin")
    public String getVin() {
        return vin;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
