package com.app.challenge_foro.domain.user;

import com.app.challenge_foro.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserRepository extends JpaRepository<User, Long>{
    UserDetails findByLogin(String username);
}
