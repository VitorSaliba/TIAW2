package exercicio2;

public class Residencia {
	private int numero;
	private String rua;
	private String cor;
	private char tipo;
	
	public Residencia() {
		this.numero = -1;
		this.rua = "";
		this.cor = "";
		this.tipo = '*';
	}
	
	public Residencia(int numero, String rua, String cor, char tipo) {
		this.numero = numero;
		this.rua = rua;
		this.cor = cor;
		this.tipo = tipo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Residencia [numero=" + numero + ", rua=" + rua + ", cor=" + cor + ", tipo=" + tipo + "]";
	}	
}
