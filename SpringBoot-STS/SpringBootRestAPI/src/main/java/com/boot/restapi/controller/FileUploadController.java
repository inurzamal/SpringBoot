package com.boot.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.boot.restapi.uploadhelper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping("/upload")
	public ResponseEntity<String> upoadFile(@RequestParam("file") MultipartFile f)
	{
//		System.out.println("File Parameter Name: "+f.getName());
//		System.out.println("File Size in Bytes: "+f.getSize());
//		System.out.println(f.getContentType());
		
		
		try {
			//validation
			if(f.isEmpty())
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Must upload image");
			
			if(f.getContentType().equals("images/jpeg"))
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG images are allowed");
			
			//uploading file
			boolean upload = fileUploadHelper.fileUpload(f);
			
			if(upload)
				return ResponseEntity.ok("File Uploaded Successfully");						
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Somethong Wrong ! Try again");
	}

}
