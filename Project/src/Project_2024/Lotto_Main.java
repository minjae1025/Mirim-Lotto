package Project_2024;

import java.io.*;
import java.util.*;

public class Lotto_Main extends account{

	public static void main(String[] args) throws InterruptedException {
		String[] id_pw = loginMenu();
		
		Client player = new Client(id_pw[0], id_pw[1]);
		player.console_clear();
		player.game_start_menu();
		System.out.println("\n테스트 종료");
		
//		int[] lotto = new int[7];
//		int[] in_num = new int[6];
//		for (int i = 0; i<lotto.length; i++) {
//			lotto[i] = (int)(Math.random() * 45)+1;
//			for (int j = 0; j<i; j++) {
//				if (lotto[i] == lotto[j]) {
//					i--;
//				}
//			}
//		}
//		for (int i = 0; i<in_num.length; i++) {
//			System.out.print(i+1+"번째 번호를 입력하세요 : ");
//		}
//		for (int i = 0; i<lotto.length; i++) {
//			System.out.println(lotto[i]);
//		}
//		sc.close();

	}
	
	static String[] loginMenu() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int login_menu;
		boolean check = false;
		String id = "";
		String pw = "";
		System.out.println(""
				+ "##   ##    ##              ##            \r\n"
				+ "### ###                                  \r\n"
				+ "#######   ###    #####    ###    ##   ## \r\n"
				+ "## # ##    ##    ##  ##    ##    ####### \r\n"
				+ "##   ##    ##    ##        ##    ####### \r\n"
				+ "##   ##    ##    ##        ##    ## # ## \r\n"
				+ "##   ##   ####   ##       ####   ##   ## \r\n");
		
		System.out.println(""
				+ "##       #####   ######  ######   #####  \r\n"
				+ "##      ### ###    ##      ##    ### ### \r\n"
				+ "##      ##   ##    ##      ##    ##   ## \r\n"
				+ "##      ##   ##    ##      ##    ##   ## \r\n"
				+ "##      ### ###    ##      ##    ### ### \r\n"
				+ "######   #####     ##      ##     #####  \r\n");
		
		System.out.println(" 1. 로그인");
		System.out.println(" 2. 회원가입");
		System.out.println(" 3. 게임 종료");
		System.out.print("\n입력 : ");
		login_menu = sc.nextInt();
		Client.console_clear();
		
		if (login_menu == 1) {
			do {
				System.out.println("\n아이디를 입력하시오.");
				id = sc.next();
				System.out.println("\n비밀번호를 입력하시오.");
				pw = sc.next();
				check = login(id, pw);
				if (check == false) {
					Client.console_clear();
					System.out.println("\n아이디 혹은 비밀번호가 틀렸습니다.\n다시 입력하십시오.");
				}
			} while (!check);
			System.out.println("\n 로그인 성공! \n 잠시 후 게임 화면으로 넘어갑니다");
			Thread.sleep(2000);
		}
		else if (login_menu == 2) {
			boolean overlap_check = false;
			do {
				System.out.println("\n돌아가실려면 [B] 입력\n주의 : 비밀번호를 잊을 경우 불러오지 못합니다.");
				System.out.println("\n사용할 아이디를 입력하시오");
				id = sc.next();
				if (id.equals("B")) {
					Client.console_clear();
					loginMenu();
				}
				System.out.println("\n사용할 비밀번호를 입력하시오.");
				pw = sc.next();
				if (pw.equals("B")) {
					Client.console_clear();
					loginMenu();
				}
				overlap_check = login(id, pw);
			} while (!overlap_check);
		}
		else {
			System.out.println("게임 종료");
			System.exit(0);
			sc.close();
		}
		return new String[]{id, pw};
	}
	
	
	
}


