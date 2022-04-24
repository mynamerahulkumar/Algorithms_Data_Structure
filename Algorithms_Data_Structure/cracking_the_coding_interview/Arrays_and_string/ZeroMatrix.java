public class ZeroMatrix {
    public static void main(String[] args) {
        int matrix[][]={{1,2,4,5},{2,0,4,5},{0,1,2,3},{5,4,2,3}};
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
//        zeromatrixFun(matrix);
//        System.out.println("matrix updated with zero matrix");
//        for(int i=0;i<matrix.length;i++){
//            for(int j=0;j<matrix[0].length;j++){
//                System.out.print(matrix[i][j]+" ");
//            }
//            System.out.println();
//        }
        System.out.println("matrix updated with zero matrix with constant space");
        zeroMatrixConstSpace(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
    //do with O(1) space
    static void zeroMatrixConstSpace(int[][]matrix){
        boolean rowhasZero=false;
        boolean colhasZero=false;
        int row=matrix.length;
        int col=matrix[0].length;
        //check for first col
        for(int i=0;i<row;i++){
            if(matrix[i][0]==0){
                rowhasZero=true;
            }
        }
        //check for first row
        for(int j=0;j<col;j++){
            if(matrix[0][j]==0){
                colhasZero=true;
            }
        }
        //check from second row and second col
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        //check row wise
        for(int i=1;i<row;i++){
            if(matrix[i][0]==0){
                //update entire row to zero
                for(int j=1;j<col;j++){
                    matrix[i][j]=0;
                }
            }
        }
        //check col wise
        for(int j=1;j<col;j++){
            if(matrix[0][j]==0){
                //update entire col to zero
                for(int i=1;i<row;i++){
                    matrix[i][j]=0;
                }
            }
        }
        //check for first col
        if(rowhasZero){
            for(int i=0;i<row;i++){
                matrix[i][0]=0;
            }
        }
        //check for first row
        if(colhasZero){
            for(int j=0;j<col;j++){
                matrix[0][j]=0;
            }
        }

    }
    static void zeromatrixFun(int[][]matrix){
        int row=matrix.length;
        int col=matrix[0].length;
        int[]rowZero=new int[row];
        int[]colZero=new int[col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    rowZero[i]=1;
                    colZero[j]=1;
                }
            }
        }
        //update row
        for(int i=0;i<row;i++){
            if(rowZero[i]==1){
                for(int j=0;j<col;j++){//set entire row i to zero
                    matrix[i][j]=0;
                }
            }
        }
        //update col
        for(int j=0;j<col;j++){
            if(colZero[j]==1){
                for(int i=0;i<row;i++){ //set entire col to zero
                    matrix[i][j]=0;
                }
            }
        }
    }
}
