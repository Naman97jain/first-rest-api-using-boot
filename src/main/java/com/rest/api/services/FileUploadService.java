package com.rest.api.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private final String UploadDir = new ClassPathResource("/META-INF/").getFile().getAbsolutePath();
		
	public FileUploadService() throws IOException {

	}

	public boolean uploadFile(MultipartFile file) {
		try {
			byte data[] = file.getBytes();
			Files.write(Paths.get(this.UploadDir + File.separator + file.getOriginalFilename()), data);
			return true;
 
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
