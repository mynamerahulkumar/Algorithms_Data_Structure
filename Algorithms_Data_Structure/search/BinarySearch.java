package search;

public class BinarySearch {
    // Returns index of x if it is present in arr[l..
    // r], else return -1
    int binarSearch(int arr[],int l,int r,int x){
        if (r>=l) {
            // If the element is present at the
            // middle itself
            int mid = l + (r - 1) / 2;
            // If element is smaller than mid, then
            // it can only be present in left subarray
            if(arr[mid]==x){
                return mid;
            }

            if(arr[mid]>x){
                return binarSearch(arr,l,mid-1,x);
            }
            // Else the element can only be present
            // in right subarray
            return binarSearch(arr,mid+1,r,x);
        }
        return -1;
    }
    // Driver method to test above
    public static void main(String[] args) {
        BinarySearch ob=new BinarySearch();
        int arr[]={2,3,5,6,10};
        int n=arr.length;
        int x=6;
        int res= ob.binarSearch(arr,0,n-1,x);
        if (res==-1){
            System.out.println(x+" is not present in the list");
        }
        else{
            System.out.println(x +" is found at index: "+res);
        }
    }

}
