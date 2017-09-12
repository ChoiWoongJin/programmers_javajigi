package test.choi.third;

import java.util.Scanner;

public class Prompt {
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		calendar cal = new calendar();
		int month = 0, year = 0;

		while (true) {
			System.out.println("년도를 입력하세요");
			System.out.print("YEAR> ");
			year = scanner.nextInt(); // 년도를 키보드로 입력받는다
			if(year < 0) {
				break;
			}
			System.out.println("달을 입력하세요");
			System.out.print("MONTH> ");
			month = scanner.nextInt(); // 달을 키보드로 입력받는다
			if (month < 1) {
				break;
			} else if (month < 1 || month > 12) {
				continue;
			}
			
			cal.printCalendar(year, month); // 달력의 모양 출력
		}
		System.out.println("Have a nice day!");
		scanner.close();
	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();

	}

}
