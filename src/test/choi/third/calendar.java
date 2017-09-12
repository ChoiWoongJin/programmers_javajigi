package test.choi.third;

import java.util.Scanner;

public class calendar {

	/**
	 * 숫자를 입력받아 해당하는 달의 최대 월수를 출력
	 */
	private final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int maxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	public void printSampleCalendar() {
		System.out.println(" 일	월	화	수	목	금	토");
		System.out.println(" ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println(" 1	2	3	4	5	6	7");
		System.out.println(" 8	9	10	11	12	13	14");
		System.out.println(" 15	16	17	18	19	20	21");
		System.out.println(" 22	23	24	25	26	27	28");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		calendar cal = new calendar();

		System.out.println("반복 횟수를 입력하세요.");
		int repeat = scanner.nextInt();
		
		int[] month = new int[repeat];

		System.out.println("달을 입력하세요");
		for (int i = 0; i < repeat; i++) {
			month[i] = scanner.nextInt();
		}

		for (int i = 0; i < repeat; i++) {
			System.out.printf("%d월은 %d일까지 있습니다.\n", month[i], cal.maxDaysOfMonth(month[i]));
		}
		scanner.close();
	}

}
