package by.bsuir.courseproject.entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name="worker")
public class Worker extends Model{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idworker")
    private int idWorker;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "seniority")
    private double seniority;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String regionWorker;

    @OneToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="user_iduser")
    private User user;

    public Worker() {
    }

    public Worker(String surname, String name, double seniority, String phone, String regionWorker) {
        this.surname = surname;
        this.name = name;
        this.seniority = seniority;
        this.phone = phone;
        this.regionWorker = regionWorker;
    }

    public Worker(int id, String surname, String name, double seniority, String phone, String regionWorker) {
        this.idWorker = id;
        this.surname = surname;
        this.name = name;
        this.seniority = seniority;
        this.phone = phone;
        this.regionWorker = regionWorker;
    }

    public Worker(String surname, String name, double seniority, String phone) {
        this.surname = surname;
        this.name = name;
        this.seniority = seniority;
        this.phone = phone;
    }

    public int getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSeniority() {
        return seniority;
    }

    public void setSeniority(double seniority) {
        this.seniority = seniority;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRegionWorker() {
        return regionWorker;
    }

    public void setRegionWorker(String regionWorker) {
        this.regionWorker = regionWorker;
    }

    //TODO refactor equals hasCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        Worker worker = (Worker) o;
        return idWorker == worker.idWorker &&
                Double.compare(worker.seniority, seniority) == 0 &&
                surname.equals(worker.surname) &&
                name.equals(worker.name) &&
                regionWorker.equals(worker.regionWorker);
    }

    @Override
    public int hashCode() {
        final int factor = 31;
        int result = 1;
        result += factor * idWorker;
        result += factor + ((surname == null) ? 0 : surname.hashCode());
        result += factor + ((name == null) ? 0 : name.hashCode());
        result *= factor + (int) seniority;
        result += ((regionWorker == null) ? 0 : regionWorker.hashCode());
        return result;
    }
}
