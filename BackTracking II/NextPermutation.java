

import java.util.ArrayList;
import java.util.Scanner;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Enter the Elements");
		//int target = sc.nextInt();
//		int arr [] = new int[n];
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			arr.add(sc.nextInt());
		}
		
		ArrayList<Integer> ans  =  getNextPermutation(arr);
		for(int a : ans) {
			System.out.println(a);
		}
		 
		
		sc.close();
	}

	private static ArrayList<Integer> getNextPermutation(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		int n = arr.size();
		int i = n-2;
		
		if(n == 1) {
			return arr;
		}
		
		//Position of the 1st small no.
		while(i>=0 && arr.get(i) > arr.get(i+1)) {
			i--;
		}
		
		//Edge Case
		if(i == -1) {
			//Handle it
			reverse(arr, i+1);
			return arr;
		}
		
		//Getting the smallest element just greater than arr[i]
		int j = n-1;
		while(j > i && arr.get(j) < arr.get(i)) {
			j--;
		}
		
		//Swap arr[i] with arr[j] 
		int temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j,  temp);
		
		reverse(arr, i+1);
		
		return arr;
		
		//return null;
	}
	
	
	public static void reverse(ArrayList<Integer> arr, int i) {
		int j = arr.size() - 1;
		
		while(i < j) {
			int temp = arr.get(j);
			arr.set(j, arr.get(i));
			arr.set(i, temp);
			i++;
			j--;
		}
	}

}













