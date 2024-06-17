package com.example.bildergalerie.controllers;


import com.example.bildergalerie.models.Image;
import com.example.bildergalerie.repository.ImageRepository;
import com.example.bildergalerie.repository.UserRepository;
import com.example.bildergalerie.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ImageService imageService;


    // Upload Image
    @PostMapping("")
    public void  uploadImage(@RequestParam("file") MultipartFile file, Principal principal) throws IOException {

        imageService.addImage(principal,file);

    }

    // Download all Images form User
    @GetMapping("")
    public ResponseEntity<List<Image>> downloadImagesbyUserId(Principal principal) {

        List<Image> images = imageService.getUserImages(principal);

        return ResponseEntity.ok(images);
    }


    // Delete Image
    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable Long id){
        imageService.deleteImage(id);
    }
}
