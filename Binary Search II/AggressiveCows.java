import java.util.ArrayList;
import java.util.Collections;


public class AggressiveCows {

    public static int aggressiveCows(ArrayList<Integer> stalls, int k) 
    {
        //    Write your code here.
        Collections.sort(stalls);
//         int n = stalls.get(stalls.size()-1) - stalls.get(0);
        int  low = 0;//stalls.get(0);
        int high = stalls.get(stalls.size()-1);
        int result = -1;
        while(low <= high){
            int mid = low + ((high - low) >> 1);
            
            if(isPlacementPoss(mid, stalls, k)){
                result = mid;
                low = mid+1;
            }
            else{
                high = mid -1;
            }
        }
        return result;
        
    }

    private static boolean isPlacementPoss(int mid, ArrayList<Integer> stalls, int k) {
        // TODO Auto-generated method stub
        int n = stalls.size();
        k--;         //placing 1st cow
        int lastCowIndex = 0;
        for(int i=1; i<n; i++){
            if(stalls.get(i) - stalls.get(lastCowIndex) >= mid) {
                k--;
                lastCowIndex = i;
                if(k <= 0) {
                    return true;
                }
            }
        }
        if(k <= 0) {
            return true;
        }
        return false;
    }
}
