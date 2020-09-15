package com.unay.taskmanager.repository;

import java.util.List;

import com.unay.taskmanager.model.Tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {
    @Query(value = "SELECT t.id, t.parentId, u.username, t.description FROM tasks t, users u WHERE t.parentid = :id AND BINARY u.username = :username AND u.username = t.username AND BINARY u.password = :password", nativeQuery = true)
    List<Tasks> findAllByParentId(@Param("id") Long id, @Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT t.id from tasks t, users u WHERE t.id = :id AND BINARY u.username = :username AND u.username = t.username AND BINARY u.password = :password", nativeQuery = true)
    List<Long> checkParentExists(@Param("id") Long id, @Param("username") String username, @Param("password") String password);

}
