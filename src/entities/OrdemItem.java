package entities;

public class OrdemItem {
	
	private Integer quantidade;
	private Double preco;
	private Produto produto;

	public OrdemItem() {
	}

	public OrdemItem(Integer quantidade, Double preco, Produto produto) {
		this.quantidade = quantidade;
		this.preco = preco;
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public Double subTotal() {
		return preco * quantidade;
	}

	@Override
	public String toString() {
		return produto.getNome()
				+ ", $"
				+ String.format("%.2f", preco)
				+ ", Quantidade: "
				+ quantidade
				+ ", Subtotal: $"
				+ String.format("%.2f", subTotal());
	}
}
