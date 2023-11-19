package com.example.handwork.repository;

import com.example.handwork.entity.UserSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionRepository extends CrudRepository<UserSession,String> {
}
