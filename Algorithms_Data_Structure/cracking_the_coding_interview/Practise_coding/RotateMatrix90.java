public class RotateMatrix90 {
    public static void main(String[] args) {
        int[][]A={{1,2},{3,4}};
        int n=A.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int temp=A[i][j];
                A[i][j]=A[j][i];
                A[j][i]=temp;
            }
        }
    }
}
