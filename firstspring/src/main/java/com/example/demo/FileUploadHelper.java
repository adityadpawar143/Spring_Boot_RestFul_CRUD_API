package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper 
{
  public final String UPLOAD_DIR = "C:\\Users\\Lenovo\\eclipse-workspace\\firstspring\\src\\main\\resources\\static\\images";

	
	public boolean uploadfile(MultipartFile multipart) throws IOException
	{
		boolean f = false;
		
		Files.copy(multipart.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipart.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		
		return f;
	}

}
