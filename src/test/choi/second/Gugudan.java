package test.choi.second;

public class Gugudan {	
	public static int[] calculate(int times)
	{
		int[] result = new int[9];
		for(int i=0; i<result.length; i++)
		{
			result[i] = times * (i + 1);
		}
		
		return result;
	}
	
	public static void print(int[] result)
	{
		System.out.println("[ " + result[0] + " 단 ]");
		for(int i=1; i<=9; i++)
		{
			System.out.println(result[0] + " X " + i + " = " + result[i-1]);
		}
	}
}
