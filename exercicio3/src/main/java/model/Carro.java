package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Carro implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String DESCRICAO_PADRAO = "Novo Carro";
	public static final int MAX_POTENCIA = 1825;
	private int id;
	private String marca;
	private float preco;
	private int potencia;
	private LocalDateTime ano;
	
	public Carro() {
		id = -1;
		marca = DESCRICAO_PADRAO;
		preco = 0.01F;
		potencia = 0;
		ano = LocalDateTime.now();
	}

	public Carro(int id, String marca, float preco, int potencia, LocalDateTime ano) {
		setId(id);
		setMarca(marca);
		setPreco(preco);
		setPotencia(potencia);
		setAno(ano);
	}		
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if (marca.length() >= 3)
			this.marca = marca;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		if (preco > 0)
			this.preco = preco;
	}

	public int getPotencia() {
		return potencia;
	}
	
	public void setPotencia(int potencia) {
		if (potencia >= 0 && potencia <= MAX_POTENCIA)
			this.potencia = potencia;
	}

	public LocalDateTime getAno() {
		return ano;
	}

	public void setAno(LocalDateTime ano) {
		// Pega a Data Atual
		LocalDateTime agora = LocalDateTime.now();
		// Garante que a data de fabricação não pode ser futura
		if (agora.compareTo(ano) >= 0)
			this.ano = ano;
	}


	/**
	 * Método sobreposto da classe Object. É executado quando um objeto precisa
	 * ser exibido na forma de String.
	 */
	@Override
	public String toString() {
		return "Carro: " + marca + "   Preço: R$" + preco + "   Pot�ncia: " + potencia + "   Ano: "
				+ ano;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.getId() == ((Carro) obj).getId());
	}	
}