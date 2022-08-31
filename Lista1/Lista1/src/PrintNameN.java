import java.util.Scanner;

public class PrintNameN {
    public static void Print(String name, int n) {
        for(int i = 0; i < n; i++){
            System.out.println(name);
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Insira quantas vezes o nome será impresso: ");
        int n = input.nextInt();

        Print("João Paulo Cardoso", n);

        input.close();
    }
}
