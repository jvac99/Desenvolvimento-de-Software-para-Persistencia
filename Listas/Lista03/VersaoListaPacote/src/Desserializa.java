import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import model.Filme;

public class Desserializa {
    public static void main(String[] args) {
        FileInputStream fis;
        ObjectInputStream ois;
        List<Filme> filmes;

        try {
            fis = new FileInputStream("arq.txt");
            ois = new ObjectInputStream(fis);

            filmes = (ArrayList<Filme>) ois.readObject();

            for (Filme filme : filmes) {
                System.out.println(filme);
            }

            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
