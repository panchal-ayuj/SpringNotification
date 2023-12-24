package com.example.springnotification;

import jakarta.persistence.*;

@Entity
public class UserNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(columnDefinition = "LONGTEXT")
    private String message;

    public UserNotification(Long id, User user, String message) {
        this.id = id;
        this.user = user;
        this.message = message;
    }

    public UserNotification() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "UserNotification{" +
                "id=" + id +
                ", user=" + user +
                ", message='" + message + '\'' +
                '}';
    }
}
