import java.util.Scanner;

public class TicTacToe {
  static Scanner scan = new Scanner(System.in);
  public static void main(String[] args) {
    System.out.println("\nLet's play tic tac toe");
    char[][] board = {
      {'_', '_', '_'}, 
      {'_', '_', '_'},
      {'_', '_', '_'}
    };
    printBoard(board);

    for (int i = 0; i < 9; i++) {
      if((i % 2) == 0) {
        System.out.println("Turn: X");
        int[] reply = askUser(board);
        board[reply[0]][reply[1]] = 'X';
        printBoard(board);
        Boolean winner = checkWin(board, 'X');
        if(winner){
          System.out.println("X wins!!");
          System.exit(0);
        }
      } else {
        System.out.println("Turn: O");
        int[] reply = askUser(board);
        board[reply[0]][reply[1]] = 'O';
        printBoard(board);
        Boolean winner = checkWin(board, 'O');
        if(winner){
          System.out.println("O wins!!");
          System.exit(0);
        }
      }
    }
    System.out.println("It's a tie");
    scan.close();
  }

  public static void printBoard(char[][] board) {
    for (int i = 0; i < 3; i++){
      System.out.print("\n\t");
      for (int j = 0; j < 3; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.print("\n");
    }
    System.out.print("\n");
  }

  public static int[] askUser(char[][] board) {
    System.out.print(" - Pick a row and column number: ");
    int[] reply = {scan.nextInt(), scan.nextInt()};
    while((board[reply[0]][reply[1]]) == 'X' || (board[reply[0]][reply[1]]) == 'O') {
      System.out.print("\nSpot taken, try again: ");
      reply[0] = scan.nextInt();
      reply[1] = scan.nextInt();
    }
    return reply;
  }
  
  public static boolean checkWin(char[][] board, char xochar) {
    for(int i = 0; i < 3; i++)
      if (board[0][i] == board[1][i] && board[2][i] == xochar && xochar == board[1][i]) {
        return true;
      } else if (board[i][0] == board[i][1] && board[i][2] == xochar && xochar == board[i][1]) {
        return true;
      }
    if((board[1][1] == board[0][0] && board[2][2] == xochar && board[0][0] == xochar) ||
      (board[0][2] == board[1][1] && board[2][0] == xochar && board[1][1] == xochar)){
      return true;
    } else {
      return false;
    }
  }
}