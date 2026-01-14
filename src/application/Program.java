package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.Ordem;
import entities.OrdemItem;
import entities.Produto;
import entities.enums.Order_Status;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do cliente: ");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Data de nascimento: (DD/MM/YYYY): ");
		Date dataDeNascimento = sdf.parse(sc.next());
		
		Cliente cliente = new Cliente(nome, email, dataDeNascimento);
		
		System.out.println("Entre com os dados dos pedidos: ");
		System.out.println("Status: ");
		System.out.print("PAGAMENTO_PENDENTE, PREPARANDO, ENVIADO, ENTREGUE: ");
		Order_Status status = Order_Status.valueOf(sc.next().toUpperCase());
		
		Ordem ordem = new Ordem(new Date(), status, cliente);
		
		System.out.print("Quantos itens o pedido tem: ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Item #"+(i + 1)+ ": ");
			System.out.print("Nome:");
			sc.nextLine();
			String nomeProduto = sc.nextLine();
			System.out.print("Preço: ");
			double precoProduto = sc.nextDouble();
			System.out.print("Quantidade: ");
			int quantidadeProduto = sc.nextInt();
			
			Produto produto = new Produto(nomeProduto, precoProduto);
			
			OrdemItem item = new OrdemItem(quantidadeProduto, precoProduto, produto);
			
			ordem.addItem(item);
		}
		
		System.out.println();
		System.out.println(ordem);
		sc.close();
	}

}
