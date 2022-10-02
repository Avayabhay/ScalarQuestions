class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans [] = new int[]{-1,-1};

        int firOcc = findFirstOcc(nums, target);
        if(firOcc == -1){
            return ans;
        }
        else{
            ans[0] = firOcc;
            ans[1] = findLastOcc(nums, target);
        }
        return ans;
    }

    public int findFirstOcc(int [] arr, int target){
        int n =   arr.length;
        int low =0, high = n-1;
        int result = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                result = mid;
                high = mid-1;
            }
            else if(arr[mid] > target){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return result;
    }

    public int findLastOcc(int [] arr, int target){
        int n =   arr.length;
        int low =0, high = n-1;
        int result = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                result = mid;
                low = mid+1;
            }
            else if(arr[mid] > target){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return result;
    }
}