package com.example.bildergalerie;

import com.example.bildergalerie.models.ApplicationUser;
import com.example.bildergalerie.models.Role;
import com.example.bildergalerie.repository.RoleRepository;
import com.example.bildergalerie.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BildergalerieApplication {


	public static void main(String[] args) {
		SpringApplication.run(BildergalerieApplication.class, args);
	}

	// Erzeugt Rolen in der Datenbank, wenn noch keine vorhanden sind
	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncode){
		return args ->{
			if(roleRepository.findByAuthority("ADMIN").isPresent() && roleRepository.findByAuthority("USER").isPresent()) return;

			roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

		};
	}
}
