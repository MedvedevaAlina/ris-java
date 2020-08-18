package by.bsuir.courseproject.entity;


import javax.persistence.*;

@Entity
@Table(name = "order_product")
@AssociationOverrides({
        @AssociationOverride(name = "id.product", joinColumns = @JoinColumn(name = "product_idproduct")),
        @AssociationOverride(name = "id.order", joinColumns = @JoinColumn(name = "order_idorder")) })
public class OrderProduct extends Model {

    @EmbeddedId
    private OrderProductPK id = new OrderProductPK();

    @Column(name = "amount")
    private int amount;

    public OrderProductPK getId() {
        return id;
    }

    public void setId(OrderProductPK id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return getId().getProduct();
    }

    public void setProduct(Product product) {
        getId().setProduct(product);
    }


}
