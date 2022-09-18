package heart.uel.br;

import java.util.Scanner;

public class TesteHeart {

	public static void main(String[] args) {
		HeartRates hr = new HeartRates();
		Scanner input = new Scanner(System.in);
		String nome, sobrenome;
		int dia, mes, ano;
		
		System.out.print("Insira seu nome: ");
		nome = input.nextLine();
		hr.setNome(nome);
		
		
		System.out.print("Insira seu sobrenome: ");
		sobrenome = input.nextLine();
		hr.setSobrenome(sobrenome);
		
		
		System.out.print("Insira o dia em que você nasceu: ");
		dia = input.nextInt();
		System.out.print("Insira o mes em que você nasceu: ");
		mes = input.nextInt();
		System.out.print("Insira o ano em que você nasceu: ");
		ano = input.nextInt();
				
		hr.setBirthday(dia, mes, ano);
		
		System.out.println("=========== Heart Rates ===============");	
		System.out.println(hr.getNome() + " " + hr.getSobrenome() + " - " + hr.getIdade() +" anos");
		System.out.println("Frequencia cardiaca maxima: " + hr.getFrequenciaMaxima());
		System.out.printf("Frequencia cardiaca alvo: %.2f ~ %.2f", hr.getAlvoMin(), hr.getAlvoMax());
		
		input.close();
	}

}