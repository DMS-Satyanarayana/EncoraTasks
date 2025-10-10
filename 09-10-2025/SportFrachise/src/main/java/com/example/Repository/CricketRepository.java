package com.example.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.Model.CricketPlayer;
@Component
public interface CricketRepository extends JpaRepository<CricketPlayer, Long>{
	 Optional<CricketPlayer> findByUsername(String username);
}
