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
public class Contact {

    @Id
    private String id;
    @Column(name = "contact_name", nullable = false)
    private String name;
    private String email;
    private String phone;
    private String address;
    @Column(columnDefinition = "TEXT")
    private String picture;
    @Column(columnDefinition = "TEXT")
    private String description;
    private boolean favourite = false;
    private String websiteLink;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true )
    private List<SocialLink> links = new ArrayList<>();

}
