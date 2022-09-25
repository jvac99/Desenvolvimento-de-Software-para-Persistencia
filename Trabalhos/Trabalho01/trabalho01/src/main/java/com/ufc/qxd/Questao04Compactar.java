package com.ufc.qxd;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Questao04Compactar {

    public static void main(String[] args) {

        String origem;
        String destino;
        int cont;
        InputStreamReader isr;
        BufferedReader br;
        FileInputStream fis;
        FileOutputStream fos;
        ZipOutputStream zos;
        ZipEntry entry;
        InputStream is = System.in;
        File file;
        File file2;
        BufferedOutputStream bos;

        // Recebendo origem
        Scanner scanner = new Scanner(is);
        System.out.println("Digite o nome do arquivo: ");
        origem = scanner.nextLine();

        try {
            // Leitura do arquivo de origem.
            file = new File(origem);
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            // Leitura do arquivo de destino.
            destino = file.getName();
            entry = new ZipEntry(destino);
            destino = destino.substring(0, destino.lastIndexOf('.')) + ".zip";
            file2 = new File(destino);
            fos = new FileOutputStream(file2);
            bos = new BufferedOutputStream(fos);
            zos = new ZipOutputStream(bos);
            zos.putNextEntry(entry);

            while ((cont = br.read()) != -1) {
                zos.write(cont);
            }

            br.close();
            zos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
