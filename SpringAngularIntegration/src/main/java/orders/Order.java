package orders;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "orders")
public class Order {
    private Long id;
    private Long orderId;
    private Date date;
    private Long amount;
    private String status;

    public Order(){}

    public Order(Long orderId, Date date, Long amount, String status) {
        this.orderId = orderId;
        this.date = date;
        this.amount = amount;
        this.status = status;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "order_id")
    public Long getOrderId() {
        return orderId;
    }

    @Column(name = "date")
    public Date getDate() {
        return date;
    }
    @Column(name = "amount")
    public Long getAmount() {
        return amount;
    }
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
