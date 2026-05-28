package estacio;

public class AppState {
    public static Gerenciador gerenciador = new Gerenciador(4);
    public static boolean funcionarioLogado = false;
    public static SerialService serialService;
    public static ArduinoMonitor monitor;
}