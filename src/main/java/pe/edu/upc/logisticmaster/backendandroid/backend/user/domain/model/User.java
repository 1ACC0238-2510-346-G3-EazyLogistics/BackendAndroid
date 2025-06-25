package pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.model;

import jakarta.persistence.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model.AuthAggregate;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private String profilePictureUrl;

    private boolean isActive;

    // Relación con AuthAggregate (email es la referencia)
    @OneToOne
    @JoinColumn(name = "email", referencedColumnName = "email", insertable = false, updatable = false)
    private AuthAggregate authAggregate;

    // Constructor
    public User(String name, String email, String phoneNumber, String profilePictureUrl, boolean isActive) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.profilePictureUrl = profilePictureUrl;
        this.isActive = isActive;
    }


    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
