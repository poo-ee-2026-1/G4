package pacote;

public class Vaga {
    private int id;
    private Statusvaga status;

    public Vaga(int id) {
        this.id = id;
        this.status = Statusvaga.LIVRE;
    }

    public int getId() {
        return id;
    }

    public Statusvaga getStatus() {
        return status;
    }

    public void setStatus(Statusvaga status) {
        this.status = status;
    }
}