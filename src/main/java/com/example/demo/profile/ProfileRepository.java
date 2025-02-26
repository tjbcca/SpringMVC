package com.example.demo.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    //SELECT * FROM profile WHERE email = ?
    Optional<Profile> findProfileByEmail(String email);

    List<Profile> findProfileById(Long id);
}
