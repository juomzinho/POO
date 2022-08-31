import java.util.Scanner;

public class PrintNameScanned {
    public static void Print(String name, int n) {
        for(int i = 0; i < n; i++){
            System.out.println(name);
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Insira seu nome: ");
        String name = input.next();
        System.out.println("Insira quantas vezes o nome será impresso: ");
        int n = input.nextInt();

        Print(name, n);

        input.close();
    }
}
