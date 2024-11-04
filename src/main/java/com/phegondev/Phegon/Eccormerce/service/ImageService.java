
package com.phegondev.Phegon.Eccormerce.service;

import com.phegondev.Phegon.Eccormerce.entity.Image;
import com.phegondev.Phegon.Eccormerce.repository.ImageRepository; // Create this repository
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;
    
    

    public ImageService(ImageRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	}



	public String saveImage(MultipartFile photo) {
        try {
            // Create an Image entity from the MultipartFile
            Image image = new Image();
            image.setFileName(photo.getOriginalFilename());
            image.setContentType(photo.getContentType());
            image.setData(photo.getBytes()); // Store the image as byte array

            // Save the image to MongoDB
            imageRepository.save(image);

            // Return the image ID or some other identifier if needed
            return image.getId(); // Assuming the Image entity has a method to get its ID

        } catch (IOException e) {
//            log.error("Unable to upload image to MongoDB: {}", e.getMessage());
        	
        	System.out.println("Unable to upload image to MongoDB: " + e.getMessage());

            throw new RuntimeException("Unable to upload image: " + e.getMessage());
        }
    }
}
