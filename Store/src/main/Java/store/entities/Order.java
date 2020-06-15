package store.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private int idOfOrder;
    private int numOfOr;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idOfClient")
    private Client idOfClient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idOfWorker")
    private Worker idOfWorker;
    private Date dateOfOrder;
    private String orderStatus;
    private int priceOfOrder;
    private String paymentMeth;
    private String methOfObt;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "ordersList")
    private List<Item> itemsList;

    public int getIdOfOrder() {
        return idOfOrder;
    }

    public void setIdOfOrder(int idOfOrder) {
        this.idOfOrder = idOfOrder;
    }

    public List<Item> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Item> itemsList) {
        this.itemsList = itemsList;
    }

    public int getNumOfOr() {
        return numOfOr;
    }

    public void setNumOfOr(int numOfOr) {
        this.numOfOr = numOfOr;
    }

    public Client getIdOfClient() {
        return idOfClient;
    }

    public void setIdOfClient(Client idOfClient) {
        this.idOfClient = idOfClient;
    }

    public Worker getIdOfWorker() {
        return idOfWorker;
    }

    public void setIdOfWorker(Worker idOfWorker) {
        this.idOfWorker = idOfWorker;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPriceOfOrder() {
        return priceOfOrder;
    }

    public void setPriceOfOrder(int priceOfOrder) {
        this.priceOfOrder = priceOfOrder;
    }

    public String getPaymentMeth() {
        return paymentMeth;
    }

    public void setPaymentMeth(String paymentMeth) {
        this.paymentMeth = paymentMeth;
    }

    public String getMethOfObt() {
        return methOfObt;
    }

    public void setMethOfObt(String methOfObt) {
        this.methOfObt = methOfObt;
    }
}
