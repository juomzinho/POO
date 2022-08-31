import java.util.Scanner;

public class PrintTree {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o nível da árvore: ");
        int level = input.nextInt();

        for(int i = 0; i < level; i++){
            int j = -1;
            do{
                System.out.print("*");
                j++;
            }while(j != i);
            System.out.println();
        }
        input.close();
    }
}
