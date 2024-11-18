package Project_2024;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class account {
	static boolean login(String id, String pw) throws InterruptedException {
		String directoryPath = "userdatas"; // 검색할 디렉토리 경로
		String targetFileName = id+"_pw.txt"; // 찾고자 하는 파일 이름

		File directory = new File(directoryPath);

	        // 디렉토리 내에서 특정 파일을 찾는다
	    File[] files = directory.listFiles((dir, name) -> name.equals(targetFileName));

	        // 파일이 발견되었는지 확인
	    if (files != null && files.length > 0) {
	        File foundFile = files[0]; // 발견된 파일
	            
	            // 파일 읽기
	        try (BufferedReader reader = new BufferedReader(new FileReader(foundFile))) {
	        	String[] line = (reader.readLine()).split(", ");
	                // 파일의 각 줄을 읽고 출력
	            if (line[0].equals(id) && line[1].equals(pw)) {
	            	return true;
	            }
	        } catch (IOException e) {
	        	System.out.println("파일을 찾는 도중 에러 발생: " + e.getMessage());
	        }
	    
	    }
	    return false;
	}
	
	static boolean sign_up(String id, String pw) throws InterruptedException {
		String directoryPath = "userdatas";
		String targetFileName = id+"_pw.txt"; // 찾고자 하는 파일 이름

		File directory = new File(directoryPath);

	        // 디렉토리 내에서 특정 파일을 찾는다
	    File[] files = directory.listFiles((dir, name) -> name.equals(targetFileName));

	        // 파일이 발견되었는지 확인
	    if (files != null && files.length > 0) {
	    	Client.console_clear();
	    	System.out.println("\n같은 아이디가 있습니다.\n다른 아이디를 입력해 주세요.");
	    	Thread.sleep(1500);
	        return false;
	    }
	    else {
	    	String idpw_file = "userdatas/"+id+"_pw.txt";
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(idpw_file))) {
				writer.write(id + ", " + pw);
				writer.newLine();
			}
			catch (IOException e ) {
				e.printStackTrace();
			}
			System.out.println("\n회원가입 완료!");
			Thread.sleep(1500);
			return true;
	    }
	    
	}
}
