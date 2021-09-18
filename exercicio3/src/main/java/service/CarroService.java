package service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import dao.CarroDAO;
import model.Carro;
import spark.Request;
import spark.Response;


public class CarroService {

	private CarroDAO carroDAO;

	public CarroService() {
		try {
			carroDAO = new CarroDAO("carro.dat");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public Object add(Request request, Response response) {
		String marca = request.queryParams("marca");
		float preco = Float.parseFloat(request.queryParams("preco"));
		int potencia = Integer.parseInt(request.queryParams("potencia"));
		LocalDateTime ano = LocalDateTime.parse(request.queryParams("ano"));

		int id = carroDAO.getMaxId() + 1;

		Carro carro = new Carro(id, marca, preco, potencia, ano);

		carroDAO.add(carro);

		response.status(201); // 201 Created
		return id;
	}

	public Object get(Request request, Response response) {
		int id = Integer.parseInt(request.params(":id"));
		
		Carro carro = (Carro) carroDAO.get(id);
		
		if (carro != null) {
    	    response.header("Content-Type", "application/xml");
    	    response.header("Content-Encoding", "UTF-8");

            return "<carro>\n" + 
            		"\t<id>" + carro.getId() + "</id>\n" +
            		"\t<descricao>" + carro.getMarca() + "</marca>\n" +
            		"\t<preco>" + carro.getPreco() + "</preco>\n" +
            		"\t<quantidade>" + carro.getPotencia() + "</potencia>\n" +
            		"\t<fabricacao>" + carro.getAno() + "</ano>\n"+
            		"</carro>\n";
        } else {
            response.status(404); // 404 Not found
            return "Carro " + id + " não encontrado.";
        }

	}

	public Object update(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        
		Carro carro = (Carro) carroDAO.get(id);

        if (carro != null) {
        	carro.setMarca(request.queryParams("marca"));
        	carro.setPreco(Float.parseFloat(request.queryParams("preco")));
        	carro.setPotencia(Integer.parseInt(request.queryParams("potencia")));
        	carro.setAno(LocalDateTime.parse(request.queryParams("ano")));

        	carroDAO.update(carro);
        	
            return id;
        } else {
            response.status(404); // 404 Not found
            return "Carro não encontrado.";
        }

	}

	public Object remove(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));

        Carro carro = (Carro) carroDAO.get(id);

        if (carro != null) {

            carroDAO.remove(carro);

            response.status(200); // success
        	return id;
        } else {
            response.status(404); // 404 Not found
            return "Carro não encontrado.";
        }
	}

	public Object getAll(Request request, Response response) {
		StringBuffer returnValue = new StringBuffer("<produtos type=\"array\">");
		for (Carro carro : carroDAO.getAll()) {
			returnValue.append("\n<carro>\n" + 
            		"\t<id>" + carro.getId() + "</id>\n" +
            		"\t<marca>" + carro.getMarca() + "</marca>\n" +
            		"\t<preco>" + carro.getPreco() + "</preco>\n" +
            		"\t<potencia>" + carro.getPotencia() + "</potencia>\n" +
            		"\t<ano>" + carro.getAno() + "</ano>\n" +
            		"</carro>\n");
		}
		returnValue.append("</carros>");
	    response.header("Content-Type", "application/xml");
	    response.header("Content-Encoding", "UTF-8");
		return returnValue.toString();
	}
}