//package Arrays I;

//Smallest subarray containing minimum and maximum values
//Input : A[] = {1, 5, 9, 7, 1, 9, 4}
//Output : 2
//subarray {1, 9} has both maximum and minimum value.
//
//Input : A[] = {2, 2, 2, 2}
//Output : 1
//2 is both maximum and minimum here.
import java.util.Scanner;

public class SmallestSubArrayContainingMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int arr [] = new int[n];
		
		System.out.println("Enter the elements");
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		findSubArray(arr);
		
		sc.close();
	}

	//Brute Force :
	// find the min and max in one iteration
	// find all the subarrays
	//return count of the lowest subarray that contains min and max elements as their starting and ending ele or vice-versa
	// TC - O(n^2)
	
	//Approach-2
	// find the min and max in one iteration
	//	iterate over each element and find if the element is smallest
			//iterate from i+1 -> n
			//find the next largest element
			//ans = min(ans, larEle - smlEle + 1)
	//   if it is the largest element, find the next smallest element
			// iterate from i+1 -> n
			//ans  min(ans, smlEle - larEle + 1)
//	/// TC - O(n^2)
	
	
	//Approach 3:
	// find the min and max in one iteration
	//maintain 3 vars -> latMin, latMax, ans;
	//iterate from i=0 -> n
	// if(ele == min)
			//update latestMin
			//if(latMax != -1)
				//ans =min(ans, latMin - latMax + 1)
	//if(ele == max)
			//upadate latMax
			//if(latMin != -1)
				//ans = min(ans, latMax - latMin +1)
	//TC - O(n)
	
	private static void findSubArray(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		
		//Main Logic
		int ans = n;
		int latMax = -1;
		int latMin = -1;
		for(int i=0; i<n; i++) {
			if(arr[i] == max) {
				latMax = i;
				if(latMin != -1) {
					ans = Math.min(ans, latMax - latMin + 1);
				}
			}
			if(arr[i] == min) {
				latMin = i;
				if(latMax != -1) {
					ans = Math.min(ans, latMin - latMax + 1);
				}
			}
			
		}
		System.out.println(ans);
	}

}
