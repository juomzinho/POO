import java.util.Scanner;

public class IMC {
    
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
    
        System.out.print("Insira seu peso: ");
        float peso = input.nextFloat();
        System.out.print("Insira sua altura: ");
        float altura = input.nextFloat();

        float imc = peso / (altura * altura);
        String status = "";

        if(imc < 18.5){
            status = "Magreza";
        }else if((imc >= 18.5) && (imc < 24.9)){
            status = "Peso ideal";
        }
        else if((imc >= 25) && (imc < 29.9)){
            status = "Sobrepeso";
        }
        else if((imc >= 30) && (imc < 39.9)){
            status = "Obesidade";
        }
        else if(imc >= 40){
            status = "Obesidade grave";
        }

        System.out.print("Seu peso ideal é: " + imc + " - "+ status);

        input.close();
    }
}
