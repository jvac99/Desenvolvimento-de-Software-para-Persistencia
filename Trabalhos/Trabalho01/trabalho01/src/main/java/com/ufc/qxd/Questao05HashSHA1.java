package com.ufc.qxd;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.xml.bind.DatatypeConverter;

public class Questao05HashSHA1 {
    public static void main(String[] args) {
        String origem;
        MessageDigest md;
        FileInputStream in;
        byte[] digest;

        // Recebendo origem
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo: ");
        origem = scanner.nextLine();

        try {
            // Leitura do arquivo de origem.
            in = new FileInputStream(origem);
            // Referência a um objeto pronto para criptografar.
            md = MessageDigest.getInstance("SHA-1");
            // Recebe o que deve ser criptografado (em Array de bytes).
            md.update(in.readAllBytes());
            // Efetua a criptografia, retornando um Array de bytes.
            digest = md.digest();
            // Converte uma matriz de bytes em uma string.
            String sha1 = DatatypeConverter.printHexBinary(digest).toUpperCase();
            System.out.println(sha1);
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }

    }
}
