// src/main/java/pe/edu/upc/logisticmaster/backendandroid/backend/user/domain/model/User.java
package pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.domain.model.ReserveAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model.AuthAggregate;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Clave natural para enlazar con AuthAggregate
    @Column(unique = true, nullable = false)
    private String email;

    private String name;
    private String phoneNumber;
    private String profilePictureUrl;
    private boolean isActive;

    // FK user.email → auth_aggregate.email
    @OneToOne
    @JoinColumn(
            name = "email",
            referencedColumnName = "email",
            insertable = false,
            updatable = false
    )
    private AuthAggregate authAggregate;

    @OneToMany(mappedBy = "user")
    private Set<ReserveAggregate> reserves = new HashSet<>();

    public User() {}

    public User(String email, String name, String phoneNumber, String profilePictureUrl, boolean isActive) {
        this.email             = email;
        this.name              = name;
        this.phoneNumber       = phoneNumber;
        this.profilePictureUrl = profilePictureUrl;
        this.isActive          = isActive;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public AuthAggregate getAuthAggregate() {
        return authAggregate;
    }

    public Set<ReserveAggregate> getReserves() {
        return reserves;
    }

    public void setReserves(Set<ReserveAggregate> reserves) {
        this.reserves = reserves;
    }
}
