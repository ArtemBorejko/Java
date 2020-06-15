package store.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.Set;

@Entity(name = "clients")
public class Client {
    @Id
    @GeneratedValue
    private int idOfClient;
    private String fullname;
    private String email;
    @Size(min = 9, max = 11)
    private String phone;
    private String address;
    private Date dateOfBirth;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idOfClient")
    private Set<Order> order;

    public Client() {
    }

    public int getIdOfClient() {
        return idOfClient;
    }

    public void setIdOfClient(int idOfClient) {
        this.idOfClient = idOfClient;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }
}
