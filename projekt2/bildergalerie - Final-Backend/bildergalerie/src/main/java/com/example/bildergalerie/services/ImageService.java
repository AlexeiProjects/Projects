package com.example.bildergalerie.services;

import com.example.bildergalerie.models.ApplicationUser;
import com.example.bildergalerie.models.Image;
import com.example.bildergalerie.repository.ImageRepository;
import com.example.bildergalerie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.Collections;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ImageRepository imageRepository;


    public void addImage(Principal principal, MultipartFile file) throws IOException {

        // Get User by username
        String username = principal.getName();
        ApplicationUser user = userRepository.findByUsername(username).get();

        // Create image and save in Database
        Image image = new Image(file.getOriginalFilename(), file.getContentType(), file.getBytes(), user.getUserId());
        imageRepository.save(image);
    }

    public List<Image> getUserImages(Principal principal){

        // Get User by username
        String username = principal.getName();
        ApplicationUser user = userRepository.findByUsername(username).get();

        // Get all Images from user
        List<Image> images = imageRepository.findByUserId(user.getUserId());
        // Sortierung nach den neusten Bildern
        Collections.reverse(images);
        return images;
    }

    public void deleteImage(long id){
        imageRepository.deleteById(id);
    }
}
