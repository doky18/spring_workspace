package com.edu.springboard.model.util;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.edu.springboard.domain.Gallery;

@Component
public class FileManager {
	
	//확장자 구하기
	public String getExt(String path) {
		//수많은 . 중에서 가장 마지막 점의 index를 가져올 것
		int lastIndex = path.lastIndexOf(".");
		String ext = path.substring(lastIndex+1, path.length());
		return ext;		//확장자 반환
	}
	
	//파일명 얻기
	public String createFileName(String path) {
		long time = System.currentTimeMillis();
		String filename=time+"."+getExt(path);
		return filename;
	}
	
	//서버에 저장
	//서버의 하드디스크 풀 경로를 두번째 인수로 넘겨야 한다 (realPath 넘겨야 함)
	public void save(Gallery gallery, String path) {
		MultipartFile[] photo = gallery.getPhoto();
		
		try {
			for(int i=0; i<photo.length;i++){

				photo[i].transferTo(new File(path+createFileName(photo[i].getOriginalFilename())));
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
