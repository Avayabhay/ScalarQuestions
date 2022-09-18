//Given an Array of size N and a values K, around which we need to right rotate the array
//Input: Array[] = {1, 3, 5, 7, 9}, K = 2.
// Output: 7 9 1 3 5


public class RotateArrayByKUnits{
    import java.util.Scanner;

    public class RotateArrayByK {
    
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the value of n");
            int n = sc.nextInt();
            System.out.println("Enter the value of k");
            int k = sc.nextInt();
            
            int arr [] = new int [n];
            System.out.println("Enter the elements of the array");
            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            
            rotateArrayByK(k, arr);
            for(int a : arr) {
                System.out.println(a);
            }
        }
        
        public static void rotateArrayByK(int k, int arr[]){
            int n = arr.length;
            if(k>n){
                k = k%n;
            }
    
            //If k == 0 or k == n, return the array itself
            if(k == 0 || k == n){
                //return arr;
                return;
            }
    
            //Main Logic
            //Reverse both the subarrays i.e, before k and after k
            reverseArray(arr, 0, k-1);
            reverseArray(arr, k, n-1);
            //Reverse the whole array
            reverseArray(arr, 0, n-1);
    
    //        return arr;
            return;
    
        }
    
        //Function to Reverse the Array
        public static void reverseArray(int arr[], int i, int j){
            while(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--; 
            }
        }
    
    }