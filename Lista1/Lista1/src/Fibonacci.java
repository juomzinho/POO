import java.util.Scanner;

public class Fibonacci {
    public static int CalcFibonacci(int f1, int f2, int n){
        int x = f1 + f2;
        n--;
        if(n != 1){
            System.out.println(x);
            x = CalcFibonacci(f2, x, n);
        }

        return x; 
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        System.out.print("Insira quantas vezes dejesa percorrer a sequência: ");
        int n = input.nextInt();

        if(n < 2) {
            System.out.print("O n-ésimo termo é: " + n);
        }else{
            System.out.print("O n-ésimo termo é: "+ CalcFibonacci(0, 1, n));
        }


        input.close();
    }
}
