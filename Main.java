import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    static final String FILE_DICTIONARY = "Dicionario.txt";
    static final String FILE_PAPER = "Artigo.txt";
    static final String FILE_ERROR_WORDS = "Erros.txt";

    public static void main(String[] args) throws FileNotFoundException {
        String[] dictionary = getDictionaryFromFile(FILE_DICTIONARY);
        checkErrors(FILE_PAPER, FILE_ERROR_WORDS, dictionary);
        System.out.printf("Diferencas=%.1f%% %n",
                getPercentageDiference(FILE_PAPER, FILE_ERROR_WORDS));
    }

    private static String[] getDictionaryFromFile(String fileDictionary)
            throws FileNotFoundException {
        String[] result = new String[getNumberOfWordsFromFile(fileDictionary)];
        Scanner in = new Scanner(new File(fileDictionary));
        for (int i = 0; i < result.length; i++) {
            result[i] = in.next();
        }
        in.close();
        return result;
    }

    private static int getNumberOfWordsFromFile(String fileDictionary)
            throws FileNotFoundException {
        int result = 0;
        Scanner in = new Scanner(new File(fileDictionary));
        while (in.hasNext()) {
            in.next();
            result++;
        }
        in.close();
        return result;
    }

    private static void checkErrors(String filePaper, String fileErrors, String[] dictionary)
            throws FileNotFoundException {
        Scanner in = new Scanner(new File(filePaper));
        PrintWriter out = new PrintWriter(new File(fileErrors));
        while (in.hasNext()) {
            String word = in.next();
            if (!isWord(dictionary, word))
                out.println(word);
        }
        in.close();
        out.close();
    }

    private static boolean isWord(String[] dictionary, String word) {
        int i = 0;
        boolean inDictionary = false;
        while ((i < dictionary.length) && (!inDictionary)) {
            if (dictionary[i].equalsIgnoreCase(word))
                inDictionary = true;
            i++;
        }
        return inDictionary;
    }

    private static double getPercentageDiference(String filePaper, String fileErrorWords) throws FileNotFoundException {
// Contar o número total de palavras no artigo
        int totalWordsInPaper = countWordsInFile(filePaper);

        // Contar o número de palavras erradas no arquivo de erros
        int totalErrors = countWordsInFile(fileErrorWords);

        // Evitar divisão por zero se não houver palavras no artigo
        if (totalWordsInPaper == 0) {
            return 0.0;
        }

        // Calcular a percentagem de palavras erradas
        return (totalErrors / (double) totalWordsInPaper) * 100;
    }

    private static int countWordsInFile(String filename) throws FileNotFoundException {
        int wordCount = 0;
        Scanner in = new Scanner(new File(filename));
        while (in.hasNext()) {
            in.next();
            wordCount++;
        }
        in.close();
        return wordCount;
    }
}