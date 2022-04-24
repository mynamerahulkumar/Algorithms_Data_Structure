public class RotateMatrix {
    public static void main(String[] args) {
        int [][]arr={{1,2,3},{4,5,6},{7,8,9}};
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("rotate matrix by 90 degree");
        if(rotatematrixNinety(arr)){
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[0].length;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("rotation is not possible");
        }
    }
    static boolean rotatematrixNinety(int[][]matrix){
        //considering square matrix
        if(matrix.length==0||matrix.length!=matrix[0].length){
            return false;
        }
        int n=matrix.length;
        for(int layer=0;layer<n/2;layer++){
            int first=layer;
            int last=n-1-layer;
            for(int i=first;i<last;i++){
                int offset=i-first;
                //save top
                int t=matrix[first][i];
              //replace top left to bottom left
                matrix[first][i]=matrix[last-offset][first];
                //replace bottom left to bottom right
                matrix[last-offset][first]=matrix[last][last-offset];
                //replace bottom right with right top
                matrix[last][last-offset]=matrix[i][last];
                //replace top right to top
                matrix[first][last]=t;
            }
        }
return true;
    }
}
