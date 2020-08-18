package by.bsuir.courseproject.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name="customer")
public class Customer extends Model{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcustomer")
    private int idCustomer;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "representative")
    private String representative;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String regionCustomer;

    @OneToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="user_iduser")
    private User user;

    @OneToMany (mappedBy="customer", fetch=FetchType.LAZY)
    private List<Orders> orders;

    public Customer() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Customer(int idCustomer, String name, String representative, String email, String regionCustomer) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.representative = representative;
        this.email = email;
        this.regionCustomer = regionCustomer;
    }

    public Customer(String name, String representative, String email, String regionCustomer) {
        this.name = name;
        this.representative = representative;
        this.email = email;
        this.regionCustomer = regionCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegionCustomer() {
        return regionCustomer;
    }

    public void setRegionCustomer(String regionCustomer) {
        this.regionCustomer = regionCustomer;
    }

    //fixme equals hasCOde
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return idCustomer == customer.idCustomer &&
                Objects.equals(name, customer.name) &&
                Objects.equals(representative, customer.representative) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(regionCustomer, customer.regionCustomer);
    }

    @Override
    public int hashCode() {
        final int factor = 31;
        int result = 1;
        result += factor * idCustomer;
        result += factor + ((name == null) ? 0 : name.hashCode());
        result += factor + ((representative == null) ? 0 : representative.hashCode());
        result += factor + ((email == null) ? 0 : email.hashCode());
        result += ((regionCustomer == null) ? 0 : regionCustomer.hashCode());
        return result;
    }
}
