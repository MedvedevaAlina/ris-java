package by.bsuir.courseproject.entity;

import javax.persistence.*;

@Entity
@Table(name="warehouse_product")
@AssociationOverrides({
        @AssociationOverride(name = "id.warehouse", joinColumns = @JoinColumn(name = "warehouse_idwarehouse")),
        @AssociationOverride(name="id.product", joinColumns = @JoinColumn(name="product_idproduct")) })
public class WarehouseProduct {
    @EmbeddedId
    private WarehouseProductPK id = new WarehouseProductPK();

    @Column(name="quantity")
    private int quantity;

    @Column(name="date")
    private long date;

    public WarehouseProductPK getId() {
        return id;
    }

    public void setId(WarehouseProductPK id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public Warehouse getWarehouse() {
        return getId().getWarehouse();
    }

    public void setWarehouse(Warehouse warehouse) {
        getId().setWarehouse(warehouse);
    }

    public Product getProduct() {
        return getId().getProduct();
    }

    public void setProduct(Product product) {
        getId().setProduct(product);
    }
}
