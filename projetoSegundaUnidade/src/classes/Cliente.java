package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Pessoa {

	private double dinheiro;
	private ArrayList<Veiculo> veiculos = new ArrayList<>();
	
	public Cliente(String nome, String cpf, int idade, double dinheiro) {
		super(nome, cpf, idade);
		this.dinheiro = dinheiro;
	}
	
	public boolean comprar(double valor, Veiculo veiculo) {
		if (this.dinheiro >= valor) {
			System.out.println("\nCompra realizada com sucesso!\n");
			this.dinheiro -= valor;
			this.veiculos.add(veiculo);
		} else {
			System.out.println("\nVocê não tem saldo suficiente.\n");
		}
		
		return this.dinheiro >= valor;
	}
	
	public void listarVeiculos() {
		if (this.veiculos.size() == 0) {
			System.out.println("Você ainda não possui nenhum veículo");
			return; // para encerrar o método
		}
		
		for (int i = 0; i < this.veiculos.size(); i++) {
			System.out.println((i+1) + ". " + this.veiculos.get(i).nome);
		}
	}
	
	public void selecionarVeiculo(Scanner scn) {
		
		if (this.veiculos.size() == 0) {
			System.out.println("Você ainda não possui nenhum veículo");
			return;
		}
		
		this.listarVeiculos();
		System.out.print("Digite o ID do veiculo que deseja selecionar: ");
		int index = scn.nextInt();
		scn.nextLine();
		
		if (index > this.veiculos.size() || index <= 0) {
			System.out.println("Veiculo não encontrado.");
			return;
		}
		
		index -= 1;
		Veiculo veiculoAtual = this.veiculos.get(index);
		System.out.println("Novo veiculo selecionado: " + veiculoAtual.nome);
		
		veiculoAtual.testeDrive(scn);
		
	}
	
}
