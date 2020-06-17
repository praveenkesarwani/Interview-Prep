class Solution {
    int N;
    int M;
    public void solve(char[][] board) {
        if(board.length == 0)
            return;
        N = board.length;
        M = board[0].length;

        //step 1
        //replace all Os with *
        for(int i = 0;i < N;i++){
            for(int j = 0;j < M;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = '#';
                }
            }
        }
        
        //step 2
        //replace all # on edges with O
        for(int i = 0;i < N;i++){ //left
            if(board[i][0] == '#'){
                replaceChar(board,i,0,'#','O');
            }
        }
        for(int i = 0;i < N;i++){ //right
            if(board[i][M - 1] == '#'){
                replaceChar(board,i,M - 1,'#','O');
            }
        }
        for(int i = 0;i < M;i++){ //up
            if(board[0][i] == '#'){
                replaceChar(board,0,i,'#','O');
            }
        }
        for(int i = 0;i < M;i++){ //down
            if(board[N-1][i] == '#'){
                replaceChar(board,N-1,i,'#','O');
            }
        }
        
        //step3
        //replace all # to X
        for(int i = 0;i < N;i++){
            for(int j = 0;j < M;j++){
                if(board[i][j] == '#'){
                    board[i][j] = 'X';
                }   
            }
        }
    }
    
    public void replaceChar(char[][]board,int i,int j,char oldV,char newV){
        if(i < 0 || i >= N || j < 0 || j >= M){
            return;
        }
        if(board[i][j] != oldV){
            return;
        }
        board[i][j] = 'O';
        replaceChar(board,i-1,j,oldV,newV);
        replaceChar(board,i,j+1,oldV,newV);
        replaceChar(board,i+1,j,oldV,newV);
        replaceChar(board,i,j-1,oldV,newV);
    }
}