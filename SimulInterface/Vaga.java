package SimulInterface;

public class Vaga {

    private int id;
    private StatusVaga status;

    public Vaga(int id) {
        this.id = id;
        this.status = StatusVaga.LIVRE;
    }

    public int getId() {
        return id;
    }

    public StatusVaga getStatus() {
        return status;
    }

    public void setStatus(StatusVaga status) {
        this.status = status;
    }
}