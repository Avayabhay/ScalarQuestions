import java.util.ArrayList;

public record PaintersPartitionProblem() {
    
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int n = boards.size();
       //int sum []  = new int[n];
        int max =0, sum = 0;
       for(int i=0; i<n; i++){
           max  = Math.max(max,boards.get(i));
           sum += boards.get(i);
        }
        int low = max;//sum[0];
        int high = sum;//Nsum[n-1];
        int result =0;
        while(low <= high){
            int mid = low + ((high - low)>>1);
            if(isPoss(mid, boards, k)){
                result =mid;
                high = mid - 1;
            }
            else{
                low = mid+1;
            }
        }
        return result;
    }
    
    public static boolean isPoss(int share, ArrayList<Integer> boards, int k){
        int n = boards.size();
        int board = 0;
        int student = 1;
        for(int i=0; i<n; i++){
           if(boards.get(i) > share){
               return false;
           }
            board += boards.get(i);
            if(board <= share){
                
            }
            else{
                student++;
                board = boards.get(i);
            }
        }
        if(student > k){
            return false;
        }
        return true;
    }
    
}


