package test.choi.third;

import java.util.Scanner;

public class Sum {

	/**
	 * 요구사항
	 * 1. 키보드로 입력받은 두 숫자의 합을 구한다.
	 * 2. 입력 및 출력 예시
	 * 두 수를 입력하세요
	 * 5 10 (엔터)
	 * 두 수의 합은 15입니다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] number = new String[2];
		int[] get_number = new int[2];
		System.out.println("두 수를 입력하세요.");
		number[0] = sc.next();
		number[1] = sc.next();
		get_number[0] = Integer.parseInt(number[0]);
		get_number[1] = Integer.parseInt(number[1]);
		
		System.out.println("두 수의 합은 " + (get_number[0] + get_number[1]) + " 입니다.");
		
		sc.close();
	}

}
