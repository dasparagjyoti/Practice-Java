import java.util.Scanner;
import java.util.*;

public class Polynomial {

    private int[] cof;
    private int deg;

    public Polynomial() {
        cof = new int[5];
        deg = -1;
    }

    public void setCoefficient(int deg, int coficient) {
        if (deg >= cof.length) {
            restructure(deg);
        }
        cof[deg] = coficient;
        if (deg >= this.deg) {
            this.deg = deg;
        }
    }

    public Polynomial add(Polynomial p) {

        Polynomial x = new Polynomial();

        int i = 0, j = 0, k = 0;
        while (i < p.cof.length && j < this.cof.length) {
            x.setCoefficient(k, p.cof[i] + this.cof[i]);
            i++;
            j++;
            k++;
        }
        while (i < p.cof.length) {
            x.setCoefficient(k, p.cof[i]);
            k++;
            i++;
        }
        while (j < this.cof.length) {
            x.setCoefficient(k, this.cof[j]);
            k++;
            j++;
        }


        return x;

    }

    public Polynomial subtract(Polynomial p) {

        Polynomial x = new Polynomial();

        int i = 0, j = 0, k = 0;
        while (i < p.cof.length && j < this.cof.length) {
            x.setCoefficient(k, this.cof[i] - p.cof[i]);
            i++;
            j++;
            k++;
        }
        while (i < p.cof.length) {
            x.setCoefficient(k, -p.cof[i]);
            k++;
            i++;
        }
        while (j < this.cof.length) {
            x.setCoefficient(k, this.cof[j]);
            k++;
            j++;
        }


        return x;

    }

    public Polynomial multiply(Polynomial p) {

        Polynomial x = new Polynomial();

        for (int i = 0; i < p.cof.length; i++) {
            for (int j = 0; j < this.cof.length; j++) {
                if (i + j <= x.deg)
                    x.setCoefficient(i + j, x.cof[i + j] + p.cof[i] * this.cof[j]);
                else
                    x.setCoefficient(i + j, p.cof[i] * this.cof[j]);
            }
        }
        return x;

    }

    public void print() {
        for (int i = 0; i < cof.length; i++) {
            if (cof[i] != 0)
                System.out.print(cof[i] + "x" + i + " ");
        }
    }

    private void restructure(int deg) {

        int[] temp = cof;
        cof = new int[deg + 1];
        for (int i = 0; i < temp.length; i++) {
            cof[i] = temp[i];
        }
    }
}

public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int degree1[] = new int[n];
        for(int i = 0; i < n; i++){
            degree1[i] = s.nextInt();
        }
        int coeff1[] = new int[n];
        for(int i = 0; i < n; i++){
            coeff1[i] = s.nextInt();
        }
        Polynomial first = new Polynomial();
        for(int i = 0; i < n; i++){
            first.setCoefficient(degree1[i],coeff1[i]);
        }
        n = s.nextInt();
        int degree2[] = new int[n];
        for(int i = 0; i < n; i++){
            degree2[i] = s.nextInt();
        }
        int coeff2[] = new int[n];
        for(int i = 0; i < n; i++){
            coeff2[i] = s.nextInt();
        }
        Polynomial second = new Polynomial();
        for(int i = 0; i < n; i++){
            second.setCoefficient(degree2[i],coeff2[i]);
        }
        int choice = s.nextInt();
        Polynomial result;
        switch(choice){
            // Add
            case 1:
                result = first.add(second);
                result.print();
                break;
            // Subtract
            case 2 :
                result = first.subtract(second);
                result.print();
                break;
            // Multiply
            case 3 :
                result = first.multiply(second);
                result.print();
                break;
        }

    }