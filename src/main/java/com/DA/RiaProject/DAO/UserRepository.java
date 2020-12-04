package com.DA.RiaProject.DAO;

import com.DA.RiaProject.entities.User;
import com.DA.RiaProject.entities.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByNickname(String nickname);
    Optional<User> findByEmail(String email);
    List<User> findByUserStatus(UserStatus userStatus);

}