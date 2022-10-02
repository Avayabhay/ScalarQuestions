/import java.util.ArrayList;
import java.util.Scanner;

public class MaxSubArraySize {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		System.out.println("ENter the value of k");
		int k  =  sc.nextInt();
		System.out.println("ENter the value of n");
		int n  =  sc.nextInt();
		System.out.println("ENter the elements");
		int arr [] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		System.out.println(maxSubArrSizeBinary(arr, k));
		sc.close();
	}
	//Binary Logic
	public static int maxSubArrSizeBinary(int [] arr, int k) {
		
		int n = arr.length;

//		for(int i=1; i<=n; i++) {
//			if(!isSubArrPoss(arr, i, k)) {
//				return i-1;
//			}
//		}
//		
//		return n;
		int low = 1, high = n;
		int result = -1;
		while(low <= high) {
			
			int mid = low + ((high - low)>>1);
			if(isSubArrPoss(arr, mid, k)){
				result = mid;
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		return result;
	}
	
	//Linear Logic
	public static int maxSubArrSize(int [] arr, int k) {
		
		int n = arr.length;

		for(int i=1; i<=n; i++) {
			if(!isSubArrPoss(arr, i, k)) {
				return i-1;
			}
		}
		
		return n;
	}

	private static boolean isSubArrPoss(int[] arr, int w, int k) {
		
		//int window [] = new int [w];
		//ArrayList<Integer> window = new ArrayList<Integer>();
		int n = arr.length;
		int sum = 0;
		for(int i=0; i<w; i++) {
			//window.add(arr[i]);
//			sum += window.get(i);
			sum += arr[i];
		}
		
		if(sum > k) {
			return false;
		}
		
		for(int i=w; i<n; i++) {
//			window.remove(0);
//			window.add(arr[i]);
			sum -= arr[i-w];
			sum += arr[i];
			if(sum > k) {
				return false;
			}
		}
		
		return true;
	}

}
