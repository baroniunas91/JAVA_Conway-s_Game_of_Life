/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife1;

/**
 *
 * @author Edgaras
 */
public class Gameoflife1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int dim = 50;
//        char[][] field = {
//            {'.','X','.'},
//            {'.','X','.'},
//            {'.','X','.'},
//        };
        char[][] field = new char[dim][dim];
//        Generuojam
        for(int i=0; i<field.length; i++) {
            for(int j=0; j<field[i].length; j++) {
                if(Math.random() < 0.22) {
                    
                    field[i][j] = 'X';
                } else {
                    field[i][j] = '.';
                }
            }
        }
        //Spausdinam
        System.out.println("Generated table");
        for(int i=0; i<field.length; i++) {
            for(int j=0; j<field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
        
        char[][][] history = new char [dim][dim][dim];
        for (int cycle=1; cycle <= dim; cycle++ ) {
            char[][] newField = new char [dim][dim];
            for(int i=0; i<dim; i++) {
                for(int j=0; j<dim; j++) {
                    int n = 0;
                    
                    if(i>0){
                        n += (j > 0 && field[i - 1][j - 1] == 'X') ? 1 : 0;
                        n += (field[i - 1][j] == 'X') ? 1 : 0;
                        n += (j < dim - 1 && field[i - 1][j + 1] == 'X') ? 1 : 0;
                    }
                    n += (j > 0 && field[i][j - 1] == 'X') ? 1 : 0;
                    n += (j < dim - 1 && field[i][j + 1] == 'X') ? 1 : 0;
                    if (i < dim - 1) {
                        n += (j > 0 && field[i + 1][j - 1] == 'X') ? 1 : 0;
                        n += (field[i + 1][j] == 'X') ? 1 : 0;
                        n += (j < dim - 1 && field[i + 1][j + 1] == 'X') ? 1 : 0;
                    }
                    if (field[i][j] == 'X' && (n == 2 || n == 3)) {
                        newField[i][j] = 'X';
                        
                    } else if (field[i][j] != 'X' && n == 3) {
                        newField[i][j] = 'X';
                        
                    } else {
                        newField[i][j] = '.';
                        
                    }
                }
            }
            history[cycle - 1] = field;
            int hi = -1;
            for(int h=history.length - 1; h>=0; h--) {
                boolean same = true;
                for(int i=0; i<dim && same; i++) {
                    for(int j=0; j<dim && same; j++){
                        if (history[h][i][j] != newField[i][j]) {
                        same = false;
                        }
                    }
                }
                if (same) {
                    hi = h;
                    break;
                }
                

            }
            if (hi >= 0) {
                System.out.print("Config repeats at iteration");
                System.out.println(hi + 1);
                break;
            }
            field = newField;
            System.out.print(cycle);
            System.out.println(" --------------------------------------------------");
//            Spausdinam
            for(int i=0; i<dim; i++) {
                for(int j=0; j<dim; j++) {
                    System.out.print(field[i][j]);
                }
                System.out.println();
            }
            
        }
        
    }  
    
}
