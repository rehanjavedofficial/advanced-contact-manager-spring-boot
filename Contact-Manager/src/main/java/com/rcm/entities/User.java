package com.rcm.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    @Column(columnDefinition = "TEXT")
    private String about;
    @Column(columnDefinition = "TEXT")
    private String profilePic;
    private String phoneNumber;
    // information
    private boolean enabled = false;
    private boolean emailVerified = false;
    private boolean phoneVerified = false;
    // provider
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Provider provider = Provider.SELF;
    private String providerUserId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true )
    private List<Contact> contacts = new ArrayList<>();

    public void update(User user) {
        this.about = user.getAbout();
        this.profilePic = user.getProfilePic();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
        this.enabled = user.isEnabled();
        this.phoneVerified = user.isPhoneVerified();
        this.emailVerified = user.isEmailVerified();
        this.provider = user.getProvider() == null ? Provider.SELF : user.getProvider();
        this.providerUserId = user.getProviderUserId();
        this.name = user.getName();
        this.password = user.getPassword();
    }

}
