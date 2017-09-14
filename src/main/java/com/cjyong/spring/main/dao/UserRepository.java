package com.cjyong.spring.main.dao;

import com.cjyong.spring.main.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by cjyong on 2017/8/10.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    User findFirstByNameAndPasswd(String name,String passwd);

}
