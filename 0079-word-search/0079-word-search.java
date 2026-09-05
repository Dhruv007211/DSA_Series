class Solution {
    public boolean exist(char[][] board, String word) {
        int r=board.length;
        int c=board[0].length;
        boolean[][]vis=new boolean[r][c];
       for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            if(find(board,word,i,j,0,vis))return true;
        }
       }
       return false;
    }
    boolean find(char[][]board,String word,int i,int j,int idx,boolean[][]vis){
        if(idx==word.length())return true;
        if(i<0||j<0||i>=board.length||j>=board[0].length||vis[i][j]||board[i][j]!=word.charAt(idx))return false;
        vis[i][j]=true;
      if (find(board,word,i+1,j,idx+1,vis)||
        find(board,word,i,j+1,idx+1,vis)||
        find(board,word,i-1,j,idx+1,vis)||
        find(board,word,i,j-1,idx+1,vis))return true;
        vis[i][j]=false;
        return false;
    }
}