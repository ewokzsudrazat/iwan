package lingkaran;

import java.util.Scanner;
public class Lingkaran {

    public static void main(String[] args) {

       Scanner input = new Scanner(System.in);
       float luas,kel,r; 
       float phi = 3.14f;

       System.out.print("Masukkan Jari-jari lingkaran : ");
       r = input.nextFloat();
       System.out.println("jika jari-jari lingkaran = "+r);
       System.out.print("# Maka Keliling lingkarannya = ");
       System.out.println(2*phi*r*r);
       System.out.print("# Maka Luas lingkarannya = ");
       System.out.println(phi*r*r);

   }

}