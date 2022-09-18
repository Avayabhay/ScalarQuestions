package Hashing;

import java.util.HashMap;
import java.util.Scanner;

//Problem Statment : Given a  Array, Find 4 elements such that a+b = c+d.
public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		int arr [] = new int[n];
		System.out.println("Enter the elements");
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		solveBruteForce(arr);
		solveEfficient(arr);
		
		sc.close();
	}
	
	//1st Approach - Brute Force
	//Logic - make vis Array, Take any 2 elemnts and find their sum
	//		- then search for some other 2 elements whose sum is the same
	public static void solveBruteForce(int arr []) {
		int n=arr.length;
		//boolean vis [] = new boolean[n];	//For marking the elements which are already visited
		HashMap<Integer,Integer> myMap = new HashMap<Integer, Integer>();
		int sum = 0;
		for(int i=0; i<n; i++) {
			//vis[i] = true;
			for(int j=i+1; j<n; j++) {
				//vis[j] = true;
				sum = arr[i] + arr[j];
				
				for(int k=0; k<n; k++) {
					if(k!=i && k!=j) {
						if(!myMap.containsKey(sum - arr[k])) {
							myMap.put(arr[k],1);
						}
						else {
							System.out.println(arr[i]+" + "+arr[j]+" = "+arr[k]+" + "+(sum - arr[k]));
							return;
						}
					}
				}
				myMap.clear();
				
				//vis[j] = false;
			}
			//vis[i] = false;
		}
		System.out.println("No Pairs Found!");
	}
	
	
	//Approach 2 : Since all the elements are distinct
	public static void solveEfficient(int arr []) {
		int n = arr.length;
		HashMap<Integer, pair> myMap = new HashMap<Integer, pair>();
		
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				 int sum = arr[i] + arr[j];
				 if(!myMap.containsKey(sum)) {
					 myMap.put(sum, new pair(arr[i],arr[j]));
//					 System.out.println(i+" "+j+" "+sum);
				 }
				 else {
					 System.out.println(myMap.get(sum).a+" + "+myMap.get(sum).b+" = "+arr[i]+" + "+arr[j]);
					 return;
				 }
			}
		}
	}
	
	
}

 class pair{
	int a;
	int b;
	public pair(int a, int b){
		this.a = a;
		this.b = b;
	}
}











