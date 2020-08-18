package by.bsuir.courseproject.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class WarehouseProductPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    private Warehouse warehouse;

    @ManyToOne
    private Product product;

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
