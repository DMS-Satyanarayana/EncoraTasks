package com.example.Service;


import com.example.Model.CricketPlayer;
import com.example.Repository.CricketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class InitialAdmin {

    @Bean
    public CommandLineRunner initDefaultUser(CricketRepository cricketRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String username = "surya";
            String rawPassword = "123";

            // Check if user already exists
            boolean userExists = cricketRepository.findByUsername(username).isPresent();

            if (!userExists) {
                CricketPlayer player = new CricketPlayer();
                player.setUsername(username);
                player.setPassword(passwordEncoder.encode(rawPassword));
                player.setRole("ROLE_USER");

                cricketRepository.save(player);
                System.out.println("✅ Default CricketPlayer created: " + username);
            } else {
                System.out.println("ℹ️ CricketPlayer already exists: " + username);
            }
        };
    }
}

