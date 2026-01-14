package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.Order_Status;

public class Ordem {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date momento;
	private Order_Status status;
	private Cliente cliente;
	private List<OrdemItem> itens = new ArrayList<>(); // lista comça vazia

	public Ordem() {
	}

	public Ordem(Date momento, Order_Status status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public Order_Status getStatus() {
		return status;
	}

	public void setStatus(Order_Status status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	// removi o getters e setters da lista por questão de segurança

	public void addItem(OrdemItem item) {
		itens.add(item);
	}
	
	public void removeItem(OrdemItem item) {
		itens.remove(item);
	}
	
	
	public double total() {
	    double total = 0.0;

	    for (OrdemItem item : itens) {
	        total += item.subTotal(); // delegando responsabilidades da classe OrdemItem
	    }

	    return total;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Ordem momento: ");
		sb.append(sdf.format(momento) + "\n");
		sb.append("Ordem status: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Ordem itens:\n");
		for (OrdemItem item : itens) {
			sb.append(item + "\n");
		}
		sb.append("Preço Total: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}
