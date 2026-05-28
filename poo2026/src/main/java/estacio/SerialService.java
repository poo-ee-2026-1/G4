package estacio;

import com.fazecast.jSerialComm.SerialPort;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SerialService {
    private SerialPort porta;
    private boolean conectado;
    private BufferedReader leitor;

    public SerialService() {
        conectar();
    }

    private void conectar() {
        try {
            porta = SerialPort.getCommPort("COM4"); // ajuste sua porta
            porta.setBaudRate(9600);
            porta.setNumDataBits(8);
            porta.setNumStopBits(1);
            porta.setParity(SerialPort.NO_PARITY);

            conectado = porta.openPort();
            if (conectado) {
                System.out.println("✅ Arduino conectado na porta " + porta.getSystemPortName());
                Thread.sleep(2000);
                leitor = new BufferedReader(new InputStreamReader(porta.getInputStream()));
            } else {
                System.out.println("⚠️ Modo simulação (Arduino não conectado)");
            }
        } catch (Exception e) {
            conectado = false;
            System.out.println("❌ Erro ao conectar: " + e.getMessage());
        }
    }

    public boolean estaConectado() {
        return conectado && porta != null && porta.isOpen();
    }

    public String lerLinha() {
        if (!estaConectado() || leitor == null) return null;
        try {
            if (leitor.ready()) {
                String linha = leitor.readLine();
                if (linha != null) {
                    // System.out.println("📡 Dado recebido: " + linha);
                    return linha;
                }
            }
        } catch (Exception e) {
            System.err.println("Erro na leitura: " + e.getMessage());
        }
        return null;
    }

    public void fechar() {
        try {
            if (leitor != null) leitor.close();
        } catch (Exception e) {}
        if (porta != null && porta.isOpen()) {
            porta.closePort();
            System.out.println("🔌 Porta serial fechada.");
        }
    }
}