package com.unay.taskmanager.repository;

import com.unay.taskmanager.model.User;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    // @Modifying
    // @Query(value = "update users u set u.username = ?3 where u.username = ?1;", nativeQuery = true)
    // int updateUsername(String oldUsername, String oldPassword, String newUsername);

    // @Query("update users set password=:newPassword where username=:oldUsername
    // AND password=:oldPassword;")
    // public void updatePassword(@Param("oldUsername") String oldUsername,
    // @Param("oldPassword") String oldPassword,
    // @Param("newPassword") String newPassword);
}