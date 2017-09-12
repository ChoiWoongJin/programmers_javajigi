package test.choi.second;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GugudanMain {

	public static void main(String[] args) {
		int number;
		Scanner sacnner = new Scanner(System.in);
		
		System.out.println("구구단 출력 프로그램(2~9단)");
		
		while(true)
		{
			try{
				System.out.print("구구단을 출력할 단은? : ");
				number = sacnner.nextInt();
				if(number < 2 || number > 9)
					throw new IllegalArgumentException("[경고 : 2 미만, 9 초과하는 숫자를 입력할 수 없습니다!]");
				break;
			}catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}catch(InputMismatchException e)
			{
				System.out.println("[경고 : 잘 못된 값을 입력하셨습니다. 정수를 입력하세요.]");
				sacnner = new Scanner(System.in);
			}
		}
		
		int[] result = Gugudan.calculate(number);
		Gugudan.print(result);	

	}

}
