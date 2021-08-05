package bfs;
import java.util.*;

public class SurroundedRegions {

    public static void main(String args[]){


        System.out.println("BFS program on surrounded Region ");
        char [][] board = new char [][] {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };

        char [][] board2 = new char [][] {
                {'O','O','O'},
                {'O','O','O'},
                {'O','O','O'},
        };

        char [][] board1= new char [][] {
                {'X'}
        };

        char [][] board4 = new char [][] {
                {'O','X','X','O','X'},
                {'X','O','O','X','X'},
                {'X','O','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','X','O'}
        };

        solve(board4);
        for(char [] c : board4){
            System.out.println(Arrays.toString(c));
        }

    }

    public static void solve(char [][] board){

        //4  directions
        int[][] directions = new int [][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        int ROW = board.length;
        int COL = board[0].length;


        //Trick here is to mark all the border O's to B and then put them to queue. .and also verify if those boarder elements
        //have any close connections and are those close connections not O

        for(int i=0; i<ROW; i++){
            for(int j=0; j<COL; j++){

                if((i ==0 || j ==0|| i == ROW-1 || j == COL-1) && board[i][j] == 'O'){

                    board[i][j] = 'B';
                    Queue<int []> q = new LinkedList();
                    q.offer(new int [] {i,j});

                    while(!q.isEmpty()){

                        int []pos = q.poll();

                        for(int [] dir : directions){

                            int a = pos[0] + dir[0];
                            int b = pos[1] + dir[1];

                            if(a >=0 && b >=0 && a < ROW && b <COL && board[a][b] == 'O'){
                                board[a][b] = 'B';
                                q.offer(new int []{a,b});
                            }

                        }

                    }

                }
            }
        }


        for(int i=0; i<ROW; i++){
            for(int j=0; j<COL; j++){

                if(board[i][j] == 'B'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }

    }
}
