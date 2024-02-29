package com.difinite.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.difinite.demo.domain.UserDomain;

@Repository
@Transactional
public interface UserRepository  extends JpaRepository<UserDomain, Integer>{

    
    @Query(value = "SELECT * FROM m_users  ", nativeQuery = true)
     List<UserDomain> getUserList();

    @Query(value = "SELECT * FROM \"m_users\" WHERE id  = :id ", nativeQuery = true)
    Optional<UserDomain> getUserById(@Param("id") Integer userId);

    @Modifying
    @Query(value = "UPDATE m_users SET full_name = :newFullName WHERE id = :userId", nativeQuery = true)
    void updateFullNameById(int userId, String newFullName);

    @Modifying
    @Query(value = "UPDATE m_users SET is_delete = 1 WHERE id = :userId", nativeQuery = true)
    void softDelete(@Param("userId") int userId);

    
}
