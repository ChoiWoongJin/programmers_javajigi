package test.choi.third;

import java.util.ArrayList;

public class calendar {

	/**
	 * 숫자를 입력받아 해당하는 달의 최대 월수를 출력
	 */
	private final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final String[] GET_DAY = { "일", "월", "화", "수", "목", "금", "토" };

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;

		return false;
	}

	public int maxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) // 윤년 계산
		{
			return LEAP_MAX_DAYS[month - 1];
		} else {
			return MAX_DAYS[month - 1];
		}
	}

	/**
	 * 년도와 월을 입력받으면 해당 월의 1일이 무슨 요일인지 확인 후 반환 반환된 값을 getDay(int i) 함수의 매개변수로 보내면 요일명
	 * 확인 가능
	 * 
	 * @param int
	 *            year
	 * @param int
	 *            month
	 * @return int getFirst
	 */
	public int getFirstDay(int year, int month) {
		// 첼러의 합동식 사용
		int getFirst = (((13 * (month + 1)) / 5) + (year - ((year / 100) * 100)) + ((year - ((year / 100) * 100)) / 4)
				+ ((year / 100) / 4) - (2 * (year / 100))) % 7;
		if (getFirst < 0) {
			getFirst = -getFirst;
		}

		return getFirst;
	}

	/**
	 * 입력받은 매개변수에 따라 요일명을 출력한다.
	 * 
	 * @param int
	 *            i
	 * @return String GET_DAY[i]
	 */
	public String getDay(int i) {
		return GET_DAY[i];
	}

	/**
	 * - 년도와 월을 입력하면 달력을 출력한다.
	 */
	public void printCalendar(int year, int month) {
		System.out.printf("\n	    <<%4d년  %3d월>>\n", year, month);
		System.out.println(" 일	월	화	수	목	금	토");
		System.out.println(" ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

		int maxDay = maxDaysOfMonth(year, month);

		for (int i = 1; i <= getFirstDay(year, month); i++) // 첫째 주가 입력되기 전 공백값을 입력
		{
			System.out.print("\t");
		}

		for (int i = 1; i <= maxDay; i++) {
			System.out.printf(" %d	", i);

			if ((i + getFirstDay(year, month)) % 7 == 0) { // 일주일을 7일 단위로 끊는다
				System.out.println();
			}

		}
		System.out.println();
	}
}
