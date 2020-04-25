package LeetcodeJava.Design;

import java.lang.reflect.Array;
import java.util.*;

public class SolveSudokuWrong {

    Character[] allPosibility = new Character[]{'1','2','3','4','5','6','7','8','9'};

    class Cell{
        //        public ArrayList<E> gridExist;
        public int row;
        public int column;
        public ArrayList<Character> posibility;
        public Cell(int r, int c, Character[] allPos){
            row = r;
            column = c;
            posibility = new ArrayList<Character>(Arrays.asList(allPos));
        }
        public void clearSelf(){
            posibility.clear();
        }
        public boolean clearNum(Character num){
            if(!posibility.contains(num)) return false;
            else {
                posibility.remove(num);
//                System.out.printf("Now size = %d, ",posibility.size());
                return true;
            }
        }
        public Character getLast() {
            if (posibility.size() == 1) {
                return posibility.get(0);
            } else {
                if (posibility.size() > 1){
                    System.out.println("There are options!");
                }else{
                    System.out.println("Something Wrong");
                }
                return null;
            }
        }
    }

    public void clearRelated(Cell[][] cells, int row, int column, char num){
        cells[row][column].clearSelf();

        for(int i = 0; i < 9;i++){
            cells[i][column].clearNum(num);
        }
        for(int i = 0; i < 9;i++){
            cells[row][i].clearNum(num);
        }
        //删除同一个九宫格里的
        int gridRow = row/3;
        int gridColumn = column/3;
        for(int i = 0; i < 3;i++){
            for(int j = 0; j < 3;j++){
                cells[gridRow*3+i][gridColumn*3+j].clearNum(num);
            }
        }
    }

    public void reduceMap(Cell cell, Map<Integer,Set<Cell>> cellMap){
        cellMap.get(cell.posibility.size()+1).remove(cell);
        cellMap.get(cell.posibility.size()).add(cell);
    }

    public void clearRelatedWithMap(Cell[][] cells, Map<Integer, Set<Cell>> cellMap, int row, int column, char num){
//        System.out.println(row+","+column+":"+num);
        cells[row][column].clearSelf();
        reduceMap(cells[row][column],cellMap);

//        cellMap.get(1).remove(cells[row][column]);
//        cellMap.get(0).add(cells[row][column]);

        for(int i = 0; i < 9;i++){
            boolean shouldReduce = cells[i][column].clearNum(num);

            if(shouldReduce){
//                System.out.printf("Clear cell [%d][%d]: %c\n",i,column,num);
                reduceMap(cells[i][column],cellMap);
            }

        }
        for(int i = 0; i < 9;i++){
            boolean shouldReduce = cells[row][i].clearNum(num);
            if(shouldReduce){
//                System.out.printf("Clear cell [%d][%d]: %c\n",row,i,num);
                reduceMap(cells[row][i],cellMap);
            }

        }
        //删除同一个九宫格里的
        int gridRow = row/3;
        int gridColumn = column/3;
        for(int i = 0; i < 3;i++){
            for(int j = 0; j < 3;j++){
//                System.out.println(cells[gridRow*3+i][gridColumn*3+j].posibility.size());
                boolean shouldReduce = cells[gridRow*3+i][gridColumn*3+j].clearNum(num);
                if(shouldReduce){
//                    System.out.printf("Clear cell [%d][%d]: %c\n",gridRow*3+i,gridColumn*3+j,num);
                    reduceMap(cells[gridRow*3+i][gridColumn*3+j],cellMap);
                }
            }
        }
    }

    public void solveSudoku(char[][] board) {
        //---遍历，将所有非空的格子生成cell
        //---根据cell来统计哪些位置的可能性只有一种


        //遍历，将所有格子生成cell，每个cell带一个ArrayList
        Cell[][] cells = new Cell[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Cell cell = new Cell(i, j, allPosibility);
                cells[i][j] = cell;
            }
        }

        //存储<可能性次数-Cell节点>
        Map<Integer, Set<Cell>> cellMap = new HashMap<>();

        //将已有数字的对应行列格可能性去掉
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    clearRelated(cells, i, j, board[i][j]);
                }
            }
        }
//        System.out.println(cells[]);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (cellMap.containsKey(cells[i][j].posibility.size())) {
                    cellMap.get(cells[i][j].posibility.size()).add(cells[i][j]);
                } else {
                    Set<Cell> s = new HashSet<>();
                    s.add(cells[i][j]);
                    cellMap.put(cells[i][j].posibility.size(), s);
                }
            }
        }
//        for (Integer key : cellMap.keySet()) {
//            System.out.println(key + ":" + cellMap.get(key).size());
//        }

        while (cellMap.get(1).size() != 0) {
            List<Cell> cells1 = new ArrayList<>(cellMap.get(1));
//            for(int i = cellMap.get(1).size() - 1; i >=0; i--){
            for (Cell cell : cells1) {
//                System.out.println("cell:" + cell.getLast());
                board[cell.row][cell.column] = cell.getLast();
//                System.out.println(cell.row + "," + cell.column + ":" + board[cell.row][cell.column]);
                clearRelatedWithMap(cells, cellMap, cell.row, cell.column, board[cell.row][cell.column]);
//
            }
            System.out.println("Finished. Rest 1:" + cellMap.get(1).size());

        }
        for (Integer key : cellMap.keySet()) {
            System.out.println(key + ":" + cellMap.get(key).size());
        }

    }

    public static void main(String[] args) {
//        char[][] board = new char[][]
//                {{'5','3','.','.','7','.','.','.','.'},
//                 {'6','.','.','1','9','5','.','.','.'},
//                 {'.','9','8','.','.','.','.','6','.'},
//                 {'8','.','.','.','6','.','.','.','3'},
//                 {'4','.','.','8','.','3','.','.','1'},
//                 {'7','.','.','.','2','.','.','.','6'},
//                 {'.','6','.','.','.','.','2','8','.'},
//                 {'.','.','.','4','1','9','.','.','5'},
//                 {'.','.','.','.','8','.','.','7','9'}};
        char[][] board = new char[][]
                {{'.','.','9','7','4','8','.','.','.'},
                        {'7','.','.','.','.','.','.','.','.'},
                        {'.','2','.','1','.','9','.','.','.'},
                        {'.','.','7','.','.','.','2','4','.'},
                        {'.','6','4','.','1','.','5','9','.'},
                        {'.','9','8','.','.','.','3','.','.'},
                        {'.','.','.','8','.','3','.','2','.'},
                        {'.','.','.','.','.','.','.','.','6'},
                        {'.','.','.','2','7','5','9','.','.'}};


        for(char[] boardRow:board){
            System.out.println(boardRow);
        }

        SolveSudokuWrong s = new SolveSudokuWrong();
        s.solveSudoku(board);
        System.out.println("-----------After-------------");
        for(char[] boardRow:board){
            System.out.println(boardRow);
        }
////        for(Map.Entry<Integer, ArrayList<Cell>> entry : solution.entrySet()){
////            System.out.println(entry);
////        }
//
//        for(Integer key : solution.keySet()){
//            System.out.println(key+":"+solution.get(key).size());
////            System.out.println(solution.get(key).get(0).row+","+solution.get(key).get(0).column);
//        }
    }
}
