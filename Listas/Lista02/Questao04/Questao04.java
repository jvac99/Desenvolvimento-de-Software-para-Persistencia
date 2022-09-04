import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Questao04 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        InputStream is;
        Scanner sc;
        String nome;
        int inicio;
        int fim;

        try {
            // Leitura do arquivo de destino.
            is = new FileInputStream("config.properties");
            prop.load(is);
            nome = prop.getProperty("arquivo");
            inicio = Integer.parseInt(prop.getProperty("linha_inicial"));
            fim = Integer.parseInt(prop.getProperty("linha_final"));
            is.close();

            is = new FileInputStream(nome);
            sc = new Scanner(is);

            for (int i = inicio; i <= fim && sc.hasNextLine(); i++) {
                System.out.println(sc.nextLine());
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}