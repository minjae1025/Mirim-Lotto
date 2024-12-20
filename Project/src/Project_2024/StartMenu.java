package Project_2024;

import java.util.*;

public class StartMenu {

	static Scanner sc = new Scanner(System.in);
	
	//시작 메뉴 프린트
	void menuPrint() {
		Logo_Print.Print();
		System.out.println("=========================================");
		System.out.println("      Mirim Lotto에 오신걸 환영합니다!");
		System.out.println("=========================================");
		System.out.println("                            제작자 : 김민재");
		System.out.println("                 [메뉴]");
		System.out.println(" 1. 게임 시작");
		System.out.println(" 2. 게임 설명");
		System.out.println(" 3. 계정 초기화");
		System.out.println(" 4. 게임 종료");
	}
	
	//시작 메뉴 첫번째
	boolean One() throws InterruptedException {
		System.out.println("=======================================");
		System.out.println("\n                ※주의!※");
		System.out.println("\n 1. 본 게임은 가상의 머니로 실행됩니다.");
		System.out.println(" 2. 게임 소요시간은 사용자에 따라 다릅니다.");
		System.out.println(" 3. 강제종료 시 저장이 안되므로 유의바랍니다.");
		System.out.println();
		System.out.println("=======================================");
		System.out.println("확인 [Y], 돌아가기 [N]");
		String check = sc.next().toUpperCase();
		console_clear();
		if (check.charAt(0) == 'Y') {
			return true;
		}
		else {
			return false;
		}
	}
		
	//시작 메뉴 두번째
	void Two() {
		Scanner sc = new Scanner(System.in);
		System.out.println("               [기본 규칙]");
		System.out.println(" 1. 자금은 30000원으로 시작합니다");
		System.out.println(" 2. 로또 가격은 1000원입니다.");
		System.out.println(" 3. 5장 까지 구매가 가능합니다.");
		System.out.println(" 4. 수동과 자동 방법이 존재합니다.");
		System.out.println("\n               [엔딩 종류]");
		System.out.println(" 1. 1억원 이상 시 : 해피엔딩");
		System.out.println(" 2. 0원 이하 시 : 베드엔딩");
		System.out.println(" 3. 1000회 이상 구매 시  : 로또 중독");
		System.out.println("\n[엔터]를 입력하여 돌아가기");
		String check = " ";
		while (!check.isEmpty()) {
			check = sc.nextLine();
		}
	}
	
	//시작 메뉴 세번째
	void Four() throws InterruptedException {
		System.out.println("게임을 종료합니다.");
		System.exit(0);
	}
	
	void console_clear(){ 
		for (int i = 0; i<40; i++) {
			System.out.println("");
		}
	}
}