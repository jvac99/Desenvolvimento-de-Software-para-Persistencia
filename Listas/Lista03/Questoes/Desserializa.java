import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Desserializa {
    public static void main(String[] args) {
        FileInputStream fis;
        ObjectInputStream ois;
        List<Filme> filmes = new ArrayList<Filme>();
        Filme filme;

        try {
            fis = new FileInputStream("arq.txt");
            ois = new ObjectInputStream(fis);
            // ele vai cair na exception e vai parar
            while ((filme = (Filme) ois.readObject()) != null) {
                filmes.add(filme);
                System.out.println(filme);
            }

            fis.close();
        } catch (Exception e) {
        }
    }
}
