package com.edu.springboard.android;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/*
 * 웹브라우저만이 Http 상의 요청과 응답을 받을 수 있는게 아니다!
 * 일반적인 응용프로그램이라면 어떤 언어라도 웹브라우저 역할의 프로그램을 제작할 수 있다
 * 왜 javaSE에서 수업을 하나? android는 javaSE 차용하고 있으므로 그게 그 소스,,,
 */
public class HttpClient {
	public static void main(String[] args) {
		// 자바언어에서 웹서버와의 요청 및 응답정보를 받기 위한 전용 객체는 바로
		// HttpURLConnection 객체가 있으며, URLConnection의 자식이다

		// 요청용 출력 스트림 : 얘를 이용하여 파라미터를 전송 할 것임
		DataOutputStream dos = null;

		// 서버의
		BufferedReader buffr = null;

		InputStreamReader is = null;

		try {
			URL url = new URL("http://172.30.1.54:7777/rest/notice/regist");
			URLConnection uCon = url.openConnection();
			HttpURLConnection httpCon = (HttpURLConnection) uCon;
			httpCon.setRequestMethod("POST");

			// 파라미터 만들기
			String postData = "title=안녕하세요&writer=도경&content=청소해요";
			httpCon.setDoOutput(true);
			httpCon.setUseCaches(false);
			// POST 전송 application/x-www-form-uriencoded
			httpCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			// 출력스트림을 이용하여 데이터 전송할 예정
			// httpCon.getOutputStream();
			dos = new DataOutputStream(httpCon.getOutputStream());
			dos.writeBytes(postData); // 포스트 전송

			// 서버의 응답 정보 받기
			is = new InputStreamReader(httpCon.getInputStream());
			buffr = new BufferedReader(is);

			String msg = null;
			while (true) {
				buffr.readLine();
				if (msg == null)
					break;

				System.out.println(msg);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (buffr != null) {
				try {
					buffr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
