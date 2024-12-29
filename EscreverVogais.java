package ATVD_B;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscreverVogais {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura da frase
        System.out.println("Digite uma frase:");
        String frase = scanner.nextLine();

        // Definindo o caminho do arquivo onde as vogais serão escritas
        String caminhoArquivo = "vogais.txt";
        
        // Chamando o método para extrair e escrever as vogais no arquivo
        escreverVogaisNoArquivo(frase, caminhoArquivo);

        // Fechando o scanner
        scanner.close();
    }

    // Método para extrair as vogais da frase e escrever no arquivo
    public static void escreverVogaisNoArquivo(String frase, String caminhoArquivo) {
        // Filtrando apenas as vogais da frase
        StringBuilder vogais = new StringBuilder();
        for (int i = 0; i < frase.length(); i++) {
            char caractere = frase.charAt(i);
            if (ehVogal(caractere)) {
                vogais.append(caractere);
            }
        }

        // Escrevendo as vogais no arquivo
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            writer.write(vogais.toString());  // Escreve as vogais no arquivo
            System.out.println("As vogais foram gravadas no arquivo: " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    // Método para verificar se o caractere é uma vogal
    public static boolean ehVogal(char c) {
        // Convertendo para minúsculo e verificando se é uma vogal
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

