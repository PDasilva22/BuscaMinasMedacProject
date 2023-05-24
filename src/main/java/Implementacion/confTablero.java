/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Implementacion;

import java.sql.Array;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author MEDAC
 */
public class confTablero extends JFrame {

    public void iniciarTablero(ArrayList<JButton> listaBotones) {

    
    };
    
    /**
     * @param args the command line arguments
     * @return retorna el tablero en formato array bidimensional
     */
    public ArrayList<Integer> obtenerTablero() {

        int bi[][] = new int[8][8];
        int a = (int) (Math.random() * 8);
        int b = (int) (Math.random() * 8);
        int aux_a = a, aux_b = b;
        bi[a][b] = 0;

        for (int i = 0; i < bi.length; i++) {
            for (int j = 0; j < bi[i].length; j++) {
                if (comprobarA(a, i)) {
                    bi[i][j] = a - i;
                } else if (comprobarI(a, i)) {
                    bi[i][j] = i - a;
                }

                if (comprobarB(b, j)) {
                    if (bi[i][j] < b - j) {
                        bi[i][j] = b - j;
                    }
                } else if (comprobarJ(b, j)) {
                    if (bi[i][j] < j - b) {
                        bi[i][j] = j - b;
                    }
                }
            }
        }
        //Se crea una bomba contemplando que no se posicione en el mismo numero que el jugador o ¡una bomba
        int contador = 3; //Este contador seria segun el nivel de dificultad
        for (int i = 0; i < contador; i++) {
            int aBomba;
            int bBomba;
            do {
                aBomba = (int) (Math.random() * 8);
                bBomba = (int) (Math.random() * 8);
            } while (a == aBomba && b == bBomba || bi[aBomba][bBomba] == 9);
            bi[aBomba][bBomba] = 9;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int[] row : bi) {
            for (int element : row) {
                arrayList.add(element);
            }
        }
        return arrayList;
    }

    /*
    public static void main(String[] args) {
        int bi[][] = new int[8][8];
        int a = (int) (Math.random() * 8);
        int b = (int) (Math.random() * 8);
        int aux_a = a, aux_b = b;
        bi[a][b] = 0;

        for (int i = 0; i < bi.length; i++) {
            for (int j = 0; j < bi[i].length; j++) {
                if (comprobarA(a, i)) {
                    bi[i][j] = a - i;
                } else if (comprobarI(a, i)) {
                    bi[i][j] = i - a;
                }

                if (comprobarB(b, j)) {
                    if (bi[i][j] < b - j) {
                        bi[i][j] = b - j;
                    }
                } else if (comprobarJ(b, j)) {
                    if (bi[i][j] < j - b) {
                        bi[i][j] = j - b;
                    }
                }
            }
        }
        //Se crea una bomba contemplando que no se posicione en el mismo numero que el jugador o ¡una bomba
        int contador = 3; //Este contador seria segun el nivel de dificultad
        for (int i = 0; i < contador; i++) {
            int aBomba;
            int bBomba;
            do {
                aBomba = (int) (Math.random() * 8);
                bBomba = (int) (Math.random() * 8);
            } while (a == aBomba && b == bBomba || bi[aBomba][bBomba] == 9);
            bi[aBomba][bBomba] = 9;
        }

        //mostrar
        for (int i = 0; i < bi.length; i++) {
            for (int j = 0; j < bi[i].length; j++) {

                System.out.print(bi[i][j]);
            }
            System.out.println("");

        }

    }*/
    public static boolean comprobarA(int a, int i) {
        boolean comprobado = false;
        if (a > i) {
            comprobado = true;
        }

        return comprobado;
    }

    public static boolean comprobarI(int a, int i) {
        boolean comprobado = false;
        if (i > a) {
            comprobado = true;
        }

        return comprobado;
    }

    public static boolean comprobarB(int b, int j) {
        boolean comprobado = false;
        if (b > j) {
            comprobado = true;
        }

        return comprobado;
    }

    public static boolean comprobarJ(int b, int j) {
        boolean comprobado = false;
        if (j > b) {
            comprobado = true;
        }

        return comprobado;
    }
}
