package Arrays I;

//Given a String, Find how many subsequences of 'ag' exists in the String
import java.util.Scanner;

public class FindNoOfSubseqOfAG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str  = sc.nextLine();
		findNoOfSubseq(str);
		
		sc.close();
	}
	
	//Brute Force : find first occurance of 'a', then for all occurances of 'a' find no. of
	//occurnaces of 'g' after that and sum all of it
	
	
	//2nd Approach : Use two variables occA & occG to mark the occurances of A & G 
	//				 When we find 'a' increase OccA & when we find 'g' increase the occG & 
	//				 add the occA to the sum i.e, sum += 
	public static void findNoOfSubseq(String str) {
		int occA = 0, occG = 0, ans = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == 'a') {
				occA++;
			}
			else if(str.charAt(i) == 'g') {
				ans += occA;
			}
		}
		System.out.println(ans);
	}

}