package by.bsuir.courseproject.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.Null;

@Entity
@Table(name="user")
public class User extends Model{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private int idUser;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "status")
    private String status = "active";

    @OneToOne (optional=true, mappedBy="user")
    private Customer customer;

    @OneToOne (optional=true, mappedBy="user")
    private Worker worker;

    public User() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public User(int idUser, String status) {
        this.idUser = idUser;
        this.status = status;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role=role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(int id, String login, String password, String status) {
        this.idUser = id;
        this.login = login;
        this.password = password;
        this.status = status;
    }
}
