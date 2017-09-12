package test.choi.third;

import java.util.Scanner;

public class Prompt {
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		calendar cal = new calendar();
		String menu = "";
		
		while (true) {			
			printMenu(); // 메뉴를 출력
			
			System.out.print("명령 (1, 2, 3, h, q)\n> ");
			menu = scanner.next();
			
			if(menu.equals("1")) { // 1. 일정 등록
				menuRegist();
			} else if(menu.equals("2")) { // 2. 일정 검색
				menuSearch();
			} else if(menu.equals("3")) { // 3. 달력 보기 (완료)
				menuCal(scanner, cal);
			} else if(menu.equals("h")) { // h. 도움말
				menuHelp();
			} else if(menu.equals("q")) { // q. 종료 (완료)
				break;
			}
		}
		System.out.println("Have a nice day!");
		scanner.close();
	}
	
	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록           ");
		System.out.println("| 2. 일정 검색           ");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
	}
	
	public void menuRegist() {
		
	}
	
	public void menuSearch() {
		
	}
	
	public void menuCal(Scanner scanner, calendar cal) {
		int month = 0, year = 0;
		
		System.out.println("년도를 입력하세요");
		System.out.print("YEAR> ");
		year = scanner.nextInt(); // 년도를 키보드로 입력받는다
		if(year < 0) {
			System.out.println("년도 입력이 잘 못 되었습니다.");
			return;
		}
		System.out.println("달을 입력하세요");
		System.out.print("MONTH> ");
		month = scanner.nextInt(); // 달을 키보드로 입력받는다
		if (month < 1 || month > 12) {
			System.out.println("달의 입력이 잘 못 되었습니다.");
			return;
		}
		
		cal.printCalendar(year, month); // 달력의 모양 출력
	}
	
	public void menuHelp() {
		
	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
