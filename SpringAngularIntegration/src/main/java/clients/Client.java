package clients;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "client")
public class Client {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;

    private Date date;

    public Client(){}

    public Client(String firstName, String lastName, String address, String email, String phone, Date date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.date = date;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "fname")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "lname")
    public String getLastName() {
        return lastName;
    }
    @Column(name = "address")
    public String getAddress() {
        return address;
    }
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
