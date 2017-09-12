package test.choi.third;

import java.io.BufferedReader; // scanner로는 장문의 문장 입력이 제한되어 BufferedReader 사용
import java.io.IOException; // scanner로는 장문의 문장 입력이 제한되어 BufferedReader 사용
import java.io.InputStream; // scanner로는 장문의 문장 입력이 제한되어 BufferedReader 사용
import java.io.InputStreamReader;
import java.text.ParseException;
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
				menuRegist(scanner, cal);
			} else if(menu.equals("2")) { // 2. 일정 검색
				menuSearch(scanner, cal);
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
	
	/**
	 * 일정을 등록
	 * @param scanner
	 * @param cal
	 * @throws ParseException : 메뉴로 돌아감
	 */
	public void menuRegist(Scanner scanner, calendar cal) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("[일정 등록]");
		System.out.print("날짜를 입력해 주세요.(yyyy-MM-dd)\n> ");
		String strDate = scanner.next();
		System.out.print("일정을 입력해 주세요.( . 을 입력하면 입력이 종료됩니다\n> ");
		String plan = ""; // scanner로는 장문의 문장 입력이 제한되어 BufferedReader 사용
		try {
			plan = br.readLine();
		} catch (IOException e1) {
			System.out.println("내용 입력 중 오류가 발생했습니다. 메뉴로 돌아갑니다");
			return;
		}
		
		try {
			cal.registPlan(strDate, plan);
		} catch (ParseException e) {
			System.out.println("날짜를 잘 못 입력하셨습니다. 메뉴로 돌아갑니다");
			return;
		}
	}
	
	public void menuSearch(Scanner scanner, calendar cal) {
		System.out.println("[일정 검색]");
		System.out.print("날짜를 입력해 주세요.(yyyy-MM-dd)\n> ");
		String strDate = scanner.next();
		String plan = "";
		try {
			plan = cal.searchPlan(strDate);
		} catch (ParseException e) {
			System.out.println("날짜를 잘 못 입력하셨습니다. 메뉴로 돌아갑니다");
			return;
		}
		System.out.println("일정 : " + plan);
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
