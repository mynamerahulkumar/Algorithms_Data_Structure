package LeetCode;

public class MediaOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int mid=0;
        float median=0;
        boolean IsEven=false;
        if(n1==0 && n2==0){
            return 0.0;
        }
        if(n1==0){
            if(n2%2==0){
                mid=(n2/2)-1;
                median=(float)(nums2[mid]+nums2[mid+1])/2;
            }
            else{
                if(n2==1){
                    median=nums2[0];
                }
                else{
                    mid=(n2/2);
                    median=nums2[mid];
                }
            }
            return median;
        }
        if(n2==0){
            if(n1%2==0){
                mid=(n1/2)-1;
                median=(float)(nums1[mid]+nums1[mid+1])/2;
            }
            else{
                if(n1==1){
                    median=nums1[0];
                }
                else{
                    mid=(n1/2);
                    median=nums1[mid];
                }
            }
            return median;
        }
        if((n1+n2)%2==0){
            mid=(n1+n2)/2-1;
            IsEven=true;
        }
        else{
            mid=(n1+n2)/2;
        }


        median=findMedian(nums1,nums2,n1,n2,mid,IsEven);

        // else{
        //     median=findMedian(nums2,nums2,n1,n2,mid);
        // }
        return median;
    }
    public float  findMedian(int []arr1,int [] arr2,int n1,int n2,int mid,boolean isEven){
        float median1=0,median2=0,median=0;
        int k=0;
        int j=0;
        int i=0;
        boolean medianFnd=false;

        for(int l=0;l<n1+n2;l++){
            if(j<n2 && i<n1){
                if(arr1[i]<=arr2[j]){

                    if(k==mid){
                        median1= (float)arr1[i];
                        medianFnd=true;
                        if(!isEven){
                            break;
                        }
                        i++;
                        k++;
                        continue;
                    }
                    if(medianFnd){
                        median2=arr1[i];
                        break;
                    }
                    i++;
                    k++;
                }
                else{
                    if(k==mid){
                        median1= (float)arr2[j];
                        medianFnd=true;
                        if(!isEven){
                            break;
                        }
                        j++;
                        k++;
                        continue;
                    }
                    if(medianFnd){
                        median2=arr2[j];
                        break;
                    }
                    j++;
                    k++;
                }
            }
            else if(j>=n2){
                if(i<n1){
                    if(k==mid){
                        median1= (float)arr1[i];
                        medianFnd=true;
                        if(!isEven){
                            break;
                        }
                        i++;
                        k++;
                        continue;
                    }
                    if(medianFnd){
                        median2=arr1[i];
                        break;
                    }
                    i++;
                    k++;
                }
            }
            else if(i>=n1){
                if(j<n2){
                    if(k==mid){
                        median=(float)arr2[j];
                        medianFnd=true;
                        if(!isEven){
                            break;
                        }
                        j++;
                        k++;
                        continue;
                    }
                    if(medianFnd){
                        median2=arr2[j];
                        break;
                    }
                    j++;
                    k++;
                }
            }
        }
        if(isEven){
            median=(median1+median2)/2;
        }
        else{
            median=median1;
        }
        return median;

    }


    public static void main(String[] args) {
        int[] arr1=new int[3];
        int[] arr2=new int[4];

        arr1[0]=2;
        arr1[1]=2;
        arr1[2]=2;

        arr2[0]=2;
        arr2[1]=2;
        arr2[2]=2;
        arr2[3]=2;

        MediaOfTwoSortedArrays mediaOfTwoSortedArrays=new MediaOfTwoSortedArrays();
        mediaOfTwoSortedArrays.findMedianSortedArrays(arr1,arr2);
    }
}
