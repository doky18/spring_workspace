package com.edu.mvc3.model.util;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.edu.mvc3.domain.Gallery;
import com.edu.mvc3.exception.UploadException;

//context:component-scan에 의해 메모리에 자동 생성
@Component
public class FileManager {
	
	//파일명 생성하기
	String createFileName(String filename) {
		long time=System.currentTimeMillis();
		String ext = filename.substring(filename.lastIndexOf(".")+1, filename.length());
		
		String fianlname= time+"."+ext;
		return fianlname;
	}
	
	//서버에 저장
	public void save(Gallery gallery, String path) throws UploadException{
		MultipartFile multi=gallery.getFile();
		try {
			multi.transferTo(new File(path));  //동네방네 알릴 필요가 있다 왜????
			//에러가난걸 다른곳에서모른다면 파일이 업로드가 안된상태로
			//DAO는 파일업로드가 정상적으로 됬으니 DB에 저장하자 라고 될테니까
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
			throw new UploadException("업로드 실패",e);
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new UploadException("업로드 실패",e);
			
		} 
	}

}
