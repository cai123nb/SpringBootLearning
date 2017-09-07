package com.cjyong.spring.main.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * Created by cjyong on 2017/8/10.
 */
@Entity
@Table(name="user")
@Data
@Accessors(chain = true)
@RequiredArgsConstructor(staticName = "of")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String passwd;

    private Date createdDate = new Date(System.currentTimeMillis());
}
