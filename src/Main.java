import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int [][] matrizSudoku = {{0,0,6,4,3,7,0,1,0},{0,3,1,0,0,5,4,6,7},{0,7,0,0,0,0,0,0,8},{0,2,9,0,0,0,3,0,0},{1,7,8,0,0,0,0,5,0},{3,0,0,0,2,6,0,0,0},{8,0,5,0,0,3,7,9,0},{0,0,4,5,0,9,0,8,6},{9,1,0,0,8,7,0,0,4}};

        int [] num = {1,6,5,3};
        System.out.println(Arrays.stream(num).sorted());
        //sudoku.display(matrizSudoku);

    }
}