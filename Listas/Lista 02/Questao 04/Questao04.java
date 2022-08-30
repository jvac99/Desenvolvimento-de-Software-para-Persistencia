import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Questao04 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        InputStream in;

        try {
            // Leitura do arquivo de destino.
            in = new FileInputStream("config.properties");
            prop.load(in);
            System.out.println(prop.getProperty("arquivo"));
            System.out.println(prop.getProperty("linha_inicial"));
            System.out.println(prop.getProperty("linha_final"));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}