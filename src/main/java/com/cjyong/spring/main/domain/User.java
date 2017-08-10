package com.cjyong.spring.main.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Created by cjyong on 2017/8/10.
 */
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String passwd;
    private Date createdDate = new Date(System.currentTimeMillis());
    private Date modifyedDate = new Date(System.currentTimeMillis());

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

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifyedDate() {
        return modifyedDate;
    }

    public void setModifyedDate(Date modifyedDate) {
        this.modifyedDate = modifyedDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                ", createdDate=" + createdDate +
                ", modifyedDate=" + modifyedDate +
                '}';
    }
}
