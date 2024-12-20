package Project_2024;

import java.io.*;
import java.util.*;

public class Save_Sys extends Variables{
	
	Save_Sys(String id, String pw) {
		super(id, pw);
	}
	
	// 게임 저장
	String id = getName();
	void gameSave() {
		String Save_file = "userdatas/savefiles/"+id+"_savefile.txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(Save_file))) {
			writer.write(week + ", " + money + ", " + lotto_buy_cnt);
			for (int i = 0; i<4; i++) {
				writer.write(", "+end_state[i]);
			}
			for (int i = 0; i<5; i++) {
				writer.write(", "+rank_cnt[i]);
			}
			writer.newLine();
		}
		catch (IOException e ) {
			e.printStackTrace();
		}
		
		lotto_history_save();
		
		System.out.println("\n저장 성공!");
		
	}
	
	//로또 당첨 기록 저장
	void lotto_history_save() {
		String Lotto_history_file = "userdatas/lotto_history/"+id+"_prize_lotto_list.txt";
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Lotto_history_file));
			if (prize_list != null && !prize_list.isEmpty() && !prize_list.get(0)[0].equals(" ")) {
				for (String[] row : prize_list) {
					for (int i = 0; i<6; i++) {
						writer.write(row[i] + "_");
					}
					writer.newLine();
				}
			}
		}
		catch (IOException e) {
			System.out.println("목록이 비어있음");
		}
	}
	
	// 저장본 불러오기
	boolean saveLoad() {
		String directoryPath = "userdatas/savefiles"; // 검색할 디렉토리 경로
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
            	String line = reader.readLine(); // 첫 번째 줄 읽기
                if (line == null || line.isEmpty()) { // 파일이 비어 있으면 처리
                    System.out.println("저장된 데이터가 없습니다.");
                    return false;
                }
                else {
                	String[] parts = line.split(", ");
                    week = Integer.parseInt(parts[0]);
                    money = Integer.parseInt(parts[1]);
                    lotto_buy_cnt = Integer.parseInt(parts[2]);
                    for (int i = 0; i<4; i++) {
    					end_state[i] = Integer.parseInt(parts[i+3]);
    				}
                    for (int i = 0; i<5; i++) {
                    	rank_cnt[i] = Integer.parseInt(parts[i+7]);
                    }
                    if (lotto_list_load()); {
                    	return true;
                    }
                }
            } catch (IOException e) {
                System.out.println("파일을 찾는 도중 에러 발생: " + e.getMessage());
            }
        } else {
        	return false;
    	}
        return true;
	}
	
	//로또 당첨 기록 로드
	boolean lotto_list_load() {
		String directoryPath = "userdatas/lotto_history"; // 검색할 디렉토리 경로
        String targetFileName = id+"_prize_lotto_list.txt"; // 찾고자 하는 파일 이름

        File directory = new File(directoryPath);

        // 디렉토리 내에서 특정 파일을 찾기
        File[] files = directory.listFiles((dir, name) -> name.equals(targetFileName));

        // 파일이 발견되었는지 확인
        if (files != null && files.length > 0) {
            File foundFile = files[0]; // 발견된 파일
            System.out.println("파일 찾음: " + foundFile.getAbsolutePath());
            try (BufferedReader reader = new BufferedReader(new FileReader(foundFile))) {
            	List<String[]> list = new ArrayList<>();
            	String lotto_list;
            	while ((lotto_list = reader.readLine()) != null) {
                    String[] parts = lotto_list.trim().split("_");
                    list.add(parts); // 각 행을 리스트에 추가
                    
                }

            	prize_list = list;
            } catch (IOException e) {
                System.out.println("파일을 찾는 도중 에러 발생: " + e.getMessage());
            }
            return true;
        }
        else {
        	System.out.println("파일 찾지 못함");
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
