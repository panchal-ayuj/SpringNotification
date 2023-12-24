package com.example.springnotification;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class NotificationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(columnDefinition = "LONGTEXT")
    private String resultData;

    public NotificationResult() {
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

    public String getResultData() {
        return resultData;
    }

    public void setResultData(String resultData) {
        this.resultData = resultData;
    }

    public NotificationResult(Long id, User user, String resultData) {
        this.id = id;
        this.user = user;
        this.resultData = resultData;
    }
}
