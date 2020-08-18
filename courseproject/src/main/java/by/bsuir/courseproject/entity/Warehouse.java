package by.bsuir.courseproject.entity;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="warehouse")
public class Warehouse extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idwarehouse")
    private int idWarehouse;

    @Column(name = "address")
    private String address;

    @Column(name = "fax")
    private String fax;

    @OneToMany (mappedBy="warehouse", fetch=FetchType.LAZY)
    private List<Orders> orders;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="id.product", cascade = CascadeType.ALL)
    private List<WarehouseProduct> warehouseProducts = new ArrayList<>();

    public List<WarehouseProduct> getWarehouseProducts() {
        return warehouseProducts;
    }

    public void setWarehouseProducts(List<WarehouseProduct> warehouseProducts) {
        this.warehouseProducts = warehouseProducts;
    }

    public Warehouse() {
    }

    public Warehouse(int idWarehouse, String address, String fax) {
        this.idWarehouse = idWarehouse;
        this.address = address;
        this.fax = fax;
    }

    public int getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
