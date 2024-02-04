package com.debugs.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

// 인터페이스 구현
public class MyFileRenamePolicy implements FileRenamePolicy {

	// 미완성된 rename함수 오버라이딩
	// 기존의 파일을 매개변수로 전달받아서 수정작업을 한 후 해당 파일을 반환해주는 메서드
	@Override
	public File rename(File originFile) {
		// 원본파일명
		String originName = originFile.getName();
		
		// 수정파일명
		// 1. 파일 업로드된 시간 (String currentTime)
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		// 2. 5자리 랜덤값 (int ran)
		// 	  10000 ~ 99999
		int ran = (int)(Math.random() * 90000) + 10000;
		
		// 3. 원본파일의 확장자 (String ext)
		String ext = originName.substring(originName.lastIndexOf("."));
		
		String changeName = currentTime + ran + ext;
		
		// 원본 파일을 수정된 파일명으로 적용시켜서 파일 객체 반환
		return new File(originFile.getParent(), changeName);
	}

}
