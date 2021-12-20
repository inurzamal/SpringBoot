package com.boot.restapi.uploadhelper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	public final String UPLOAD_DIR = "C:\\Users\\User\\Desktop\\SpringBoot\\SpringBootRestAPI\\src\\main\\resources\\static\\images";

	public boolean fileUpload(MultipartFile multipart)
	{
		boolean f=false;
		
		try {
			
			Files.copy(multipart.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipart.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			f=true;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
}
