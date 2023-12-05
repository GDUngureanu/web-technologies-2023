package web.technologies.lab08.entity;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import web.technologies.lab08.model.UserRole;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String email;
    private String password;
    private String deliveryAddress;
    @Column(name = "NEW_COMPANY")
    private String company;
    private String address;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    
    @CreationTimestamp
    private Timestamp createdAt;

    public UserEntity() {

    }

    public UserEntity(UUID id, String name, String email, String password, String deliveryAddress, String company, String address, UserRole role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.deliveryAddress = deliveryAddress;
        this.company = company;
        this.address = address;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

}

