/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Implementacion;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author MEDAC
 */

public class Main extends JFrame {

  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int bi[][] = new int[10][10];
        int a = (int)(Math.random()*10);
        int b =(int)(Math.random()*10);
        int aux_a = a, aux_b = b;
        bi[a][b] = 9;
        

        for (int i = 0; i < bi.length; i++) {
            for (int j = 0; j < bi[i].length; j++) {
                if (comprobarA(a, i)) {
                    bi[i][j] = a - i;
                } else if (comprobarI(a, i)) {
                    bi[i][j] = i - a;
                }

                if (comprobarB(b, j)) {
                    if(bi[i][j]<b-j){
                        bi[i][j] = b-j;
                    }
                } else if (comprobarJ(b, j)) {
                    if(bi[i][j]<j-b){
                        bi[i][j] = j-b;
                    }
                }
            }
        }

        for (int i = 0; i < bi.length; i++) {
            for (int j = 0; j < bi[i].length; j++) {

                System.out.print(bi[i][j]);
            }
            System.out.println("");

        }

    }

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
