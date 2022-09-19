package Arrays I;

//Generate the pattern for given n;
//n = 4 :
//0 0 0 1
//0 0 2 1
//0 3 2 1
//4 3 2 1


public class GenPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int arr [][] = new int[4][4];
		for(int i=0; i<n; i++) {
			int j = n -1;
			for(int val=0; val<=i; val++) {
				arr[i][j] = val+1;
				j--;
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}