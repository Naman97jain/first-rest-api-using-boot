package com.rest.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.api.entities.MultiType;
import com.rest.api.services.FileUploadService;

@RestController
public class MultipartController {

	@Autowired
	public FileUploadService fileUploadService;

	@GetMapping("upload-file")
	public ResponseEntity<String> uploadFile(@ModelAttribute MultiType multiType) {
		System.out.println(multiType.getFileData().getName());
		System.out.println(multiType.getFileData().getOriginalFilename());
		System.out.println(multiType.getFileData().getSize());
		System.out.println(multiType.getTest());

		try {
			if (multiType.getFileData().isEmpty()) {
				return ResponseEntity.badRequest().body("File can not be blank");
			} else if (!multiType.getFileData().getContentType().equals("image/jpeg")) {
				return ResponseEntity.badRequest().body("Only JPEG image are acceptable");
			}
			
			boolean isUploaded = this.fileUploadService.uploadFile(multiType.getFileData());
			if (isUploaded) {
				System.out.println(ServletUriComponentsBuilder.fromCurrentContextPath().path("image/")
						.path(multiType.getFileData().getOriginalFilename()).toUriString());
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("image/")
						.path(multiType.getFileData().getOriginalFilename()).toUriString());
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Some unknown error occurred while uploading file. Please Check");
		}
	}

}
