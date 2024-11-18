package Project_2024;

import java.io.*;
import java.util.*;

public class Save_Sys extends Variables{
	// 게임 저장
	Save_Sys(String id, String pw) {
		super(id, pw);
	}
	String id = getName();
	void gameSave() {
		String Save_file = "savefiles/"+id+"_savefile.txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(Save_file))) {
			writer.write(week + ", " + money + ", " + lotto_buy_cnt);
			writer.newLine();
		}
		catch (IOException e ) {
			e.printStackTrace();
		}
		System.out.println("\n저장 성공!");
		
	}
	
	// 저장본 불러오기
	boolean saveLoad() {
		String directoryPath = "savefiles"; // 검색할 디렉토리 경로
        String targetFileName = id+"_savefile.txt"; // 찾고자 하는 파일 이름

        File directory = new File(directoryPath);

        // 디렉토리 내에서 특정 파일을 찾기
        File[] files = directory.listFiles((dir, name) -> name.equals(targetFileName));

        // 파일이 발견되었는지 확인
        if (files != null && files.length > 0) {
            File foundFile = files[0]; // 발견된 파일
            System.out.println("파일 찾음: " + foundFile.getAbsolutePath());
            
            // 파일 읽기
            try (BufferedReader reader = new BufferedReader(new FileReader(foundFile))) {
            	String[] line = (reader.readLine()).split(", ");
                // 파일의 각 줄을 읽고 출력
            	if (line != null) {
                    week = Integer.parseInt(line[0]);
                    money = Integer.parseInt(line[1]);
                    lotto_buy_cnt = Integer.parseInt(line[2]);
                    return true;
                } else {
                	return false;
                }
            } catch (IOException e) {
                System.out.println("파일을 찾는 도중 에러 발생: " + e.getMessage());
            }
        } else {
        	return false;
    	}
        return false;
	}
	// 종료 확인창
		public boolean realExit() {
			Scanner sc = new Scanner(System.in);
			String menu = "";
			System.out.println("정말 종료하시겠습니까?");
			System.out.println(" Y. 예");
			System.out.println(" N. 아니오");
			System.out.print("\n입력 : ");
			menu = sc.next();
			if (menu.toUpperCase().charAt(0) == 'Y') {
				gameSave();
				return true;
			}
			else {
				return false;
			}
		}
}
