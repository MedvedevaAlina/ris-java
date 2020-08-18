package by.bsuir.courseproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="orders")
public class Orders extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idorder")
    private int idOrder;

    @Column(name = "orderdate", nullable = true)
    private long orderDate;

    @Column(name = "deliverydate", nullable = true)
    private long deliveryDate;

    @Column(name = "processing")
    private String processing;

    @Column(name = "cost")
    private double cost;

    @ManyToOne(optional=false, cascade= CascadeType.ALL)
    @JoinColumn(name="customer_idcustomer")
    private Customer customer;

    @ManyToOne(optional=false, cascade= CascadeType.ALL)
    @JoinColumn(name="warehouse_idwarehouse")
    private Warehouse warehouse;

    @OneToMany(fetch=FetchType.EAGER, mappedBy="id.order", cascade = CascadeType.ALL)
    private List<OrderProduct> orderProducts = new ArrayList<>();


    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Orders() {
    }

    public Orders(long idCustomer, long orderDate, long deliveryDate, String processing) {
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.processing = processing;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public long getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(long orderDate) {
        this.orderDate = orderDate;
    }

    public long getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(long deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getProcessing() {
        return processing;
    }

    public void setProcessing(String processing) {
        this.processing = processing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orders)) return false;
        Orders orders = (Orders) o;
        return idOrder == orders.idOrder &&
                Objects.equals(orderDate, orders.orderDate) &&
                Objects.equals(deliveryDate, orders.deliveryDate) &&
                Objects.equals(processing, orders.processing);
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        final int factor = 31;
        int result = 1;
        result += factor * idOrder;
        result += factor + ((processing == null) ? 0 : processing.hashCode());
        result += factor + ((orderDate == 0) ? 0 : orderDate);
        result += ((deliveryDate == 0) ? 0 : deliveryDate);
        return result;
    }
}
