package com.example.bildergalerie.services;

import com.example.bildergalerie.models.ApplicationUser;
import com.example.bildergalerie.models.LoginResponseDTO;
import com.example.bildergalerie.models.Role;
import com.example.bildergalerie.repository.RoleRepository;
import com.example.bildergalerie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;



    public ApplicationUser registerUser(String username, String password){

        Optional<ApplicationUser> user = userRepository.findByUsername(username);

        // Return Invalid wenn Username schon vorhanden ist
        if(user.isPresent()){
            return new ApplicationUser(-1,username,"",null);
        }

        // Create User
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);

        return userRepository.save(new ApplicationUser(0, username, encodedPassword, authorities));
    }

    public LoginResponseDTO loginUser(String username, String password){

        try{
            //  Check username and password
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            // User valid, create jwt
            String token = tokenService.generateJwt(auth);
            ApplicationUser user = userRepository.findByUsername(username).get();

            return new LoginResponseDTO(user.getUserId(),user.getUsername(), token);

        } catch(AuthenticationException e){
            return new LoginResponseDTO(-1,"", "");
        }
    }
}
