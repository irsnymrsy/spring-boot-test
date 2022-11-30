package com.example.springBootTest.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private Long socialSecurityNumber;

    @Column(nullable = false)
    private Date birthday;

    @Column(nullable = false)
    @CreationTimestamp
    private Date dateCreated;

    @Column(nullable = false)
    @UpdateTimestamp
    private Date lastUpdated;

    @Column(nullable = false)
    @CreatedBy
    private String updatedBy;

    @Column(nullable = false)
    @LastModifiedBy
    private String modifiedBy;

    @Column(nullable = false)
    private Boolean isDeleted = false;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
