package com.jpa.test.book.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
//	public final String 
//	UPLOAD_DIR = "C:\\Users\\Mishan\\eclipse-workspace-1\\spring-boot-jsp\\src\\main\\resources\\static\\images";
	
	// dynamic file path
	public final String 
	UPLOAD_DIR = new ClassPathResource("static/images/").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException{
		
	}

	public boolean uploadFile(MultipartFile multipartFile) {
		boolean isUploaded = false;
		
		try {
//			// First way of moving file
//			// read file
//			InputStream is = MultipartFile.getInputStream();
//			byte data[] = new byte[is.available()];
//			is.read(data);
//			// write fil
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+MultipartFile.getOriginalFileName());
//			fos.write(data);
//			fos.flush();
//			fos.close();
//			isUploaded = true;
			
			// second way of moving file
			Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			isUploaded = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isUploaded;
	}
}
