package com.edu.springboard.model.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.edu.springboard.domain.Gallery;
import com.edu.springboard.domain.Photo;
import com.edu.springboard.exception.FileUploadException;

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
	public void save(Gallery gallery, String path) throws FileUploadException {
		MultipartFile[] photo = gallery.getPhoto();//업로드한 파일 정보
		//galleryDTO의 비어있는 photoList를 여기서 채우자
		List<Photo> photoList = new ArrayList<Photo>();	
		gallery.setPhotoList(photoList);		//끄집어내서 메모리에 올리기. 지금 텅 빈 상태
		
		
		try {
			for(int i=0; i<photo.length;i++){
				Thread.sleep(10);		//너무 빨라지면 안됨
				
				String filename=createFileName(photo[i].getOriginalFilename());
				Photo dto=new Photo();
				dto.setFilename(filename);
				photoList.add(dto);
				photo[i].transferTo(new File(path+createFileName(photo[i].getOriginalFilename())));
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
			throw new FileUploadException("파일 저장 실패", e);
			//썬사가 만들어 둔 예외를 이렇게 우리만의 예외로 바꾸는 것을 *예외의 전환*이라고 한다
		} catch (IOException e) {
			e.printStackTrace();
			throw new FileUploadException("파일 저장 실패", e);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
