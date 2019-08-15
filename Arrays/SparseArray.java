/**
 * 将棋盘二维数组转化成稀疏数组，存入磁盘
 * 从磁盘中读取稀疏数组，然后恢复成二维数组
 */
public class SparseArray {
    public static void main(String[] args) {

        // 0 表示没有棋子，1 表示黑子， 2 表示蓝子
        int[][] chessArr1=new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        chessArr1[4][5]=2;

        //打印二维数组
        System.out.println("-----------------原始二维数组-------------------");
        for(int[] row: chessArr1){
            for(int data: row){
                System.out.print(data+" ");
            }
            System.out.println();
        }

        //--------------二维数组转化成稀疏数组-----------------------
        //1. 统计二维数组中的非0数字的个数，用来生命稀疏数组长度
        int non_zero=0;
        for(int i=0;i<chessArr1.length;i++){
            for(int j=0;j<chessArr1[0].length;j++){
                if(chessArr1[i][j]!=0){
                    non_zero++;
                }
            }
        }
        //2. 创建稀疏数组
        int[][] sparseArr=new int[non_zero+1][3];

        //3. 将二维数组存入稀疏数组
        sparseArr[0][0]=chessArr1.length;
        sparseArr[0][1]=chessArr1[0].length;
        sparseArr[0][2]=non_zero;
        int count=1;
        for(int i=0;i<chessArr1.length;i++){
            for(int j=0;j<chessArr1[0].length;j++){
                if(chessArr1[i][j]!=0){
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                    count++;
                }
            }
        }
        //打印稀疏数组
        System.out.println("--------------稀疏数组----------------");
        for(int[] row: sparseArr){
            for(int data: row){
                System.out.print(data+" ");
            }
            System.out.println();
        }

        //--------------稀疏数组转化成二维数组----------------
        //1. 读取稀疏数组第一行数据，创建并且初始化二维数组
        int[][] chessArr2=new int[sparseArr[0][0]][sparseArr[0][1]];

        //2. 读取稀疏数组中剩下的数据，还原二维数组
        for(int i=1;i<sparseArr.length;i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        //打印还原的二维数组
        System.out.println("----------------还原二维数组--------------------");
        for(int[] row:chessArr2){
            for(int data:row){
                System.out.print(data+" ");
            }
            System.out.println();
        }
    }
}
