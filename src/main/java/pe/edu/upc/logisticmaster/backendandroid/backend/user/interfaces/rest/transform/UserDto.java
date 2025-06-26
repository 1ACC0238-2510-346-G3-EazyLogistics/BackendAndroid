package pe.edu.upc.logisticmaster.backendandroid.backend.user.interfaces.rest.transform;

import pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.model.User;

public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String profilePictureUrl;
    private boolean isActive;

    public UserDto(User u) {
        this.id                = u.getId();
        this.name              = u.getName();
        this.email             = u.getEmail();
        this.phoneNumber       = u.getPhoneNumber();
        this.profilePictureUrl = u.getProfilePictureUrl();
        this.isActive          = u.isActive();
    }

    // getters...
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getProfilePictureUrl() { return profilePictureUrl; }
    public boolean isActive() { return isActive; }
}
