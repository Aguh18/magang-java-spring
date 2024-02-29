package com.difinite.demo.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "m_users")
public class UserDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "no_telp")
    private String noTelp;

    @Column(name = "gender")
    private String gender;

    @Column(name = "created_at")
    private  Date  createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    private  Date updateAt;

    @Column(name = "updated_by")
    private String updateBy;

    @Column(name = "deleted_at")
    private  Date deleteAt;

    @Column(name = "deleted_by")
    private String deleteBy;

    @Column(name = "is_delete")
    private int isDeleted;

}
