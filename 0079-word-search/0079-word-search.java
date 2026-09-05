class Solution {
    public boolean exist(char[][] board, String word) {
        int r=board.length;
        int c=board[0].length;
        boolean[][]vis=new boolean[r][c];
       for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            if(find(board,word,i,j,0))return true;
        }
       }
       return false;
    }
    boolean find(char[][]board,String word,int i,int j,int idx){
        if(idx==word.length())return true;
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=word.charAt(idx))return false;
        char temp=board[i][j];
        board[i][j]='#';
      if (find(board,word,i+1,j,idx+1)||
        find(board,word,i,j+1,idx+1)||
        find(board,word,i-1,j,idx+1)||
        find(board,word,i,j-1,idx+1))return true;
       board[i][j]=temp;
        return false;
    }
}