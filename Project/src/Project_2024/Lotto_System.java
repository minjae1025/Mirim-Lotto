package Project_2024;

class Lotto_System {
	//등수에 따른 당첨금 계산
	static int getPrizeAmount(int rank) {
	    switch (rank) {
	        case 1:
	            return 100000000; // 1억
	        case 2:
	            return (int) (Math.random() * 10000000) + 20000000; // 2000만~3000만
	        case 3:
	            return (int) (Math.random() * 5000000) + 2000000;  // 500만~700만
	        case 4:
	            return (int) (Math.random() * 1000000) + 1000000;  // 100만~200만
	        case 5:
	            return (int) (Math.random() * 300000) + 100000;   // 10만~40만
	        default:
	            return 0; // 낙첨
	    }
	}
	
	//당첨 번호 뽑기
	static int[] prize_num_sel() {
		int[] prize_lotto = new int[7];
		for (int i = 0; i<prize_lotto.length; i++) {
			prize_lotto[i] = (int)(Math.random() * 45)+1;
			for (int j = 0; j<i; j++) {
				if (prize_lotto[i] == prize_lotto[j]) {
					i--;
					break;
				}
			}
		}
		return prize_lotto;
	}
	
	//자신이 입력한 번호 출력
	static void numberPrint(int cnt, int[][] my_lotto) {
		System.out.print((cnt+1)+"번째 장 번호 :");
		for (int j = 0; j<my_lotto[cnt].length; j++) {
			System.out.printf(" |%2d| ", my_lotto[cnt][j]);
		}
		System.out.println();
	}
			
	//당첨 번호 출력
	static void prizeNumPrint(int[] prize_lotto) {
		System.out.print("당첨 번호 :");
		for (int i = 0; i<prize_lotto.length; i++) {
			if (i == 6) {
				System.out.print("+");
			}
			System.out.print(" |"+prize_lotto[i]+"| ");
		}
		System.out.println();
	}
}
