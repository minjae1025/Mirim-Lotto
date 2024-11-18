package Project_2024;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Variables {
	int week = 1;
	private String id;
	private String password;
	int[][] my_lotto = new int[5][6];
	int[] prize_lotto = new int[7];
	int[] prize_rank = new int[5];
	int fixed_width = 3;
	int lotto_buy_cnt = 0;
	List<int[]> prize_list = new ArrayList<>();
	int money = 10000;
	
	Variables(String id, String pw) {
		this.id = id;
		this.password = pw;
	}
	
	String getName() { // 닉네임 변경 시 사용 예정
		return this.id;
	}
	
	// 출금
	void moneyDraw(int num) {
		money -= num;
	}
	
	// 입금
	void moneyDeposit(int num) {
		money += num;
	}
	
	String getID () {
		return id;
	}
	
	//정수 입력해서 문자 입력시 캐치
	public int InputMismatchTest() { 
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		while (true) {
			try {
				menu = sc.nextInt();
		        break;
		    } catch (InputMismatchException e) {
		        sc.nextLine(); // 잘못된 입력을 버퍼에서 제거
		        System.out.println("잘못 입력하셨습니다. 숫자를 입력해 주십시오.");
		        System.out.print(" 입력 : ");
		    }
		}
		return menu;
	}
	
	//콘솔 창 클리어
	static void console_clear(){ 
		for (int i = 0; i<25; i++) {
			System.out.println("");
		}
	}
}
