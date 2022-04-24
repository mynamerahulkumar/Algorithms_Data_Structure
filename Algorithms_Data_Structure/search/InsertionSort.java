package search;

public class InsertionSort {
    void insertionSort(int arr[],int n){
        int i,key,j;
        for (i=1;i<n;i++){
            key=arr[i];
            j=i-1;
            while (j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
        }
    }
    void printList(int arr[],int n){
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        InsertionSort insertionSort=new InsertionSort();
        int arr[]={4,5,2,3,19};
        int n=arr.length;
        insertionSort.insertionSort(arr,n);
        System.out.println("Sorted array: ");
        insertionSort.printList(arr,n);
    }
}
