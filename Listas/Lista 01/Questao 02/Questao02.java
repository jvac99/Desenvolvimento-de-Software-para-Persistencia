import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Questao02 {
    public static void main(String[] args) throws FileNotFoundException {
        String origem;
        String destino;
        if (args.length < 2) {
            System.err.println("Sem argumentos");
            System.out.println("É necessário passar dois argumentos: origem e destino.");
        } else {
            origem = args[0];
            destino = args[1];
            InputStream is = new FileInputStream(origem);
            OutputStream os = new FileOutputStream(destino);
        }
    }
}