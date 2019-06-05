package com.one.mpp.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "image_id")
    private String imageId;

    @OneToMany(mappedBy = "user")
    private List<FollowingEntity> followings;

    @OneToMany(mappedBy = "relatedUser", cascade = CascadeType.ALL)
    private List<FollowingEntity> followers;

    public int getFollowingCount() {
        return followings.size();
    }

    public int getFollowersCount() {
        return followers.size();
    }

    public UserEntity() {
    }

    public UserEntity(String email, String password) {
        this.email = email;
        this.password = password;
        //this.imageId = null;
    }

    public UserEntity(String email, String password, String firstName, String lastName, String imageId) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageId = imageId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public List<FollowingEntity> getFollowings() {
        return followings;
    }

    public void setFollowings(List<FollowingEntity> followings) {
        this.followings = followings;
    }

    public List<FollowingEntity> getFollowers() {
        return followers;
    }

    public void setFollowers(List<FollowingEntity> followers) {
        this.followers = followers;
    }
}
