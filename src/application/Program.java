package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Conta;
import exceptions.ExcecaoNegocios;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe os dados da conta");
		System.out.print("Número: ");
		int numero = sc.nextInt();
		System.out.print("Títular: ");
		sc.nextLine();
		String titular = sc.nextLine();
		System.out.print("Saldo inicial: ");
		double saldo = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double limiteSaldo = sc.nextDouble();

		Conta conta = new Conta(numero, titular, saldo, limiteSaldo);

		System.out.println();
		System.out.print("Informe uma quantia para sacar: ");
		double quantia = sc.nextDouble();

		try {
			conta.saque(quantia);
			System.out.printf("Novo saldo: %.2f%n", conta.getSaldo());
		} catch (ExcecaoNegocios e) {
			System.out.println(e.getMessage());
		}

		sc.close();

	}

}
