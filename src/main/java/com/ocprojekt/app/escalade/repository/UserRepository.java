package com.ocprojekt.app.escalade.repository;

import com.ocprojekt.app.escalade.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

    User findUserByUsername(String username);
}
