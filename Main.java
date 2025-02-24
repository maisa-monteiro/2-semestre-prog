import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //chamar metodo para escrever no arquivo
        escrever();

        //chamar metodo para ler o arquivo
        leituraEMostrar ();

    }
    public static void leituraEMostrar () throws FileNotFoundException {
        //Abrir o arquivo dados.txt para leitura
        Scanner in =new Scanner(new File("dados.txt"));

        //cria a string linha que vai ler cada linha existente
        String linha=in.nextLine();

        //vai mostrar a linha lida
        while (in.hasNextLine()){
            linha=in.nextLine();
            System.out.println(linha);
        }

        //Fechar o arquivo
        in.close();
    }
    public static void escrever () throws FileNotFoundException {
        //Abrir o ficheiro dados.txt para escrita
        Formatter output = new Formatter(new File("dados.txt"));
                //Escrever no ficheiro
        output.format("%s%n", "  ");
        output.format("%s%n", "A UC de Programação I tem com objetivos:");
        output.format("%s%n", "- Conceção de algoritmos aplicando boas práticas de programação;");
        output.format("%s%n", "- Codificação de algoritmos em linguagem Java (na perspetiva procedimental);");
        output.format("%s%n", "- Aplicação de testes aos programas;");
        output.format("%s%n", "- Aplicação dos conhecimentos adquiridos à resolução de problemas do mundo real;");
        output.format("%s%n", "- Promoção de atitudes de aprendizagem ativa, colaborativa e responsável, de trabalho persistente e");
        output.format("%s%n", "  de aplicação de espírito crítico na análise e resolução de problemas.");

        //Fechar ficheiro
        output.close();
    }
}