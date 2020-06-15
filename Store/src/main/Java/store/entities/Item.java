package store.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "items")
public class Item {
    @Id
    @GeneratedValue
    private int idOfItem;
    private String name;
    private String listOfCon;
    private String charac;
    private int price;
    private int numOfPar;
    private int number;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemsList")
    private List<Order> ordersList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "items")
    private Provider provider;

    public int getIdOfItem() {
        return idOfItem;
    }

    public void setIdOfItem(int idOfItem) {
        this.idOfItem = idOfItem;
    }

    public List<Order> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getListOfCon() {
        return listOfCon;
    }

    public void setListOfCon(String listOfCon) {
        this.listOfCon = listOfCon;
    }

    public String getCharac() {
        return charac;
    }

    public void setCharac(String charac) {
        this.charac = charac;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumOfPar() {
        return numOfPar;
    }

    public void setNumOfPar(int numOfPar) {
        this.numOfPar = numOfPar;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
