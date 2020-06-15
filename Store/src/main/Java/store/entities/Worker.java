package store.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.Set;

@Entity(name = "workers")
public class Worker {
    @Id
    @GeneratedValue
    private int idOfWorker;
    private String login;
    private String password;
    private String fullname;
    private String post;
    @Size(min = 9, max = 11)
    private String phone;
    private Date dateofstart;
    private Date dateofbirthday;
    private String idencode;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idOfWorker")
    private Set<Order> order;

    public Worker() {
    }

    public int getIdOfWorker() {
        return idOfWorker;
    }

    public void setIdOfWorker(int idOfWorker) {
        this.idOfWorker = idOfWorker;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateofstart() {
        return dateofstart;
    }

    public void setDateofstart(Date dateofstart) {
        this.dateofstart = dateofstart;
    }

    public Date getDateofbirthday() {
        return dateofbirthday;
    }

    public void setDateofbirthday(Date dateofbirthday) {
        this.dateofbirthday = dateofbirthday;
    }

    public String getIdencode() {
        return idencode;
    }

    public void setIdencode(String idencode) {
        this.idencode = idencode;
    }

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }
}
