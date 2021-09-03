package def;
import java.util.*;
public class SomarNumeros {
	public static Scanner sc = new Scanner(System.in);
		public static void main (String args[]){
			//Declaracao de variaveis
			int num1, num2, soma;
			//Leituras
			System.out.println("Digite um n�mero: ");
			num1 = sc.nextInt();
			System.out.println("Digite outro n�mero: ");
			num2 = sc.nextInt();
			//Somar
			soma = num1 + num2;
			//Mostrar na tela
			System.out.println("Soma: " + soma);
			}
}
