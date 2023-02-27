package com.edu.springshop.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.edu.springshop.exception.HashException;

//평문을 해시값을 변경 (이때 개발자는 알고리즘을 선택할 수 있다) 
public class PassConverter {
	
	public static String convertHash(String text) throws HashException{
		StringBuilder sb = new StringBuilder();
		
		try {
			MessageDigest digest=MessageDigest.getInstance("SHA-256");
			//일반 스트링 쪼개기
			byte[] hash = digest.digest(text.getBytes("UTF-8"));
			
			for(int i=0;i<hash.length;i++) {
				//16진수 문자열로 변환
				String hex=Integer.toHexString(0xff & hash[i]);
				if(hex.length()==1)sb.append("0"); //1자리수는 2자리로..
				sb.append(hex);
			}
			//System.out.println(sb.toString().length());
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new HashException("암호화에 실패", e);
		} catch (UnsupportedEncodingException e) {
			throw new HashException("암호화에 실패", e);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String hash=convertHash("doky");
		System.out.println(hash);
	}
}



