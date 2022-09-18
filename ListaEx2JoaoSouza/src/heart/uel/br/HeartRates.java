package heart.uel.br;

import java.time.LocalDate;
import java.time.Period;

public class HeartRates {
	private String nome;
	private String sobrenome;
	
	private int dia;
	private int mes;
	private int ano;
	
	private int idade;
	
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setSobrenome(String novoSobrenome) {
		this.sobrenome = novoSobrenome;
	}
	
	public String getSobrenome() {
		return this.sobrenome;
	}
	
	public void setBirthday(int novoDia, int novoMes, int novoAno) {
		this.ano = novoAno;
		this.mes = novoMes;
		this.dia = novoDia;
	}
	
	public int getIdade() {
		this.idade = Period.between(LocalDate.of(ano, mes, dia), LocalDate.now()).getYears();
		return idade;
	}
	
	public int getFrequenciaMaxima() {
		return 220 - idade;
	}
	
	public double getAlvoMin() {
		return (220 - idade) * 0.5;
	}
	
	public double getAlvoMax() {
		return (220 - idade) * 0.85;
	}
}