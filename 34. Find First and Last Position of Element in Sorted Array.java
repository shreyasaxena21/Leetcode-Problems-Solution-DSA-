class Solution {

    public static int getFirst(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        int firstIndex = -1;
        while(low<=high){
            int mid = low+(high-low)/2;

            if(arr[mid]==x){
                firstIndex = mid;
                high = mid-1;
            }

            else if(arr[mid]<x){
                low = mid+1;
            }

            else{
                high = mid-1;
            }
        }
        return firstIndex;
    }

     public static int getLast(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        int lastIndex = -1;
        while(low<=high){
            int mid = low+(high-low)/2;

            if(arr[mid]==x){
                lastIndex = mid;
                low = mid+1;
            }

            else if(arr[mid]<x){
                low = mid+1;
            }

            else{
                high = mid-1;
            }
        }
        return lastIndex;
    }


    public int[] searchRange(int[] nums, int target) {
        int [] list = new int[2];
        int first = getFirst(nums, target);
        int last = getLast(nums, target);

        list[0] = first;
        list[1] = last;
        return list;
    }
}