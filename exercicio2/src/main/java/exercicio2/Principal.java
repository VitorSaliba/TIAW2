package exercicio2;

public class Principal {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();

		
		//Inserir um elemento na tabela
		Residencia residencia = new Residencia(171, "Elson Nunes de Souza", "branco",'A');
		if(dao.inserirResidencia(residencia) == true) {
			System.out.println("Inserção com sucesso -> " + residencia.toString());
		}
		
		//Mostrar apartamentos		
		System.out.println("==== Mostrar apartamentos === ");
		Residencia[] residencias = dao.getResidenciasApartamentos();
		for(int i = 0; i < residencias.length; i++) {
			System.out.println(residencias[i].toString());
		}

		//Atualizar residencia
		residencia.setCor("nova cor");
		dao.atualizarResidencia(residencia);

		//Mostrar apartamentos
		System.out.println("==== Mostrar apartamentos === ");
		residencia = dao.getResidencias();
		for(int i = 0; i < residencias.length; i++) {
			System.out.println(residencias[i].toString());
		}
		
		//Excluir residencia
		dao.excluirResidencia(residencia.getNumero());
		
		//Mostrar apartamentos
		residencias = dao.getResidencias();
		System.out.println("==== Mostrar apartamentos === ");		
		for(int i = 0; i < residencias.length; i++) {
			System.out.println(residencias[i].toString());
		}
		
		dao.close();
	}
}
