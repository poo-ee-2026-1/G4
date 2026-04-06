package pacote;
import java.util.List;
public class Gerenciador {
	 private List<Vaga> vagas;
	    private Sensorsimulado sensor;

	    public Gerenciador(List<Vaga> vagas) {
	        this.vagas = vagas;
	        this.sensor = new Sensorsimulado();
	    }

	    public void atualizarVagas() {
	        for (Vaga vaga : vagas) {
	            boolean ocupado = sensor.detectarVeiculo();
	            vaga.setStatus(ocupado ? Statusvaga.OCUPADA : Statusvaga.LIVRE);
	        }
	    }

	    public int vagasLivres() {
	        int count = 0;
	        for (Vaga v : vagas) {
	            if (v.getStatus() == Statusvaga.LIVRE) {
	                count++;
	            }
	        }
	        return count;
	    }

	    public List<Vaga> getVagas() {
	        return vagas;
	    }
	}

