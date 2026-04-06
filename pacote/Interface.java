package pacote;
import java.util.List;
public class Interface {
	 public void mostrarVagas(List<Vaga> vagas) {
	        System.out.println("\n===== STATUS DAS VAGAS =====");

	        for (Vaga v : vagas) {
	            System.out.println("Vaga " + v.getId() + ": " + v.getStatus());
	        }
	    }
	}
