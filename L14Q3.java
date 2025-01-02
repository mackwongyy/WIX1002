//WONG YOONG YEE, UM AY2023/2024, WIX1002
import java.util.*;
import java.io.*;

interface MessageCoder {
    String encode(String plainText);
    String decode(String cipherText);
}

class ShuffleCipher implements MessageCoder {
    private String inputFileName, outputFileName;
    private int N;

    public ShuffleCypher(String inputFileName, String outputFileName, int N) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
        this.N = N;
    }

    @Override
    public String encode(String plainText) {
        StringBuilder cypherText = new StringBuilder(plainText);

        for(int i = 0; i < N; i++) {
            int length = cypherText.length();
            StringBuilder shuffledText = new StringBuilder(length);

            for(int j = 0; j < length / 2; j++) {
                shuffledText.append(cypherText.charAt(j + half)).append(cypherText.charAt(j));
            }

            if(length % 2 != 0) {
                shuffledText.append(cipherText.charAt(length - 1));
            }

            cypherText = shuffledText;
        }

        return cypherText.toString();
    }

    @Override
    public String decode(String cypherText) {
        StringBuilder plainText = new StringBuilder(cypherText);

        for(int i = 0; i < N; i++) {
            int length = plainText.length();
            StringBuilder unshuffledText = new StringBuilder(length);

            for(int j = 0; j < length / 2; j++) {
                unshuffledText.append(plainText.charAt(j + length / 2)).append(plainText.charAt(j));
            }

            if(length % 2 != 0) {
                unshuffledText.append(plainText.charAt(length - 1));
            }

            plainText = unshuffledText;
        }

        return plainText.toString();
    }

    public void fileProcessor() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName)); BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            StringBuilder inputText = new StringBuilder();
            String line;

            while((line = reader.readLine()) != null) {
                inputText.append(line).append("\n");
            }

            String plainText = inputText.toString(), cypherText = encode(plainText);
            writer.write(cypherText);
            System.out.println("The file has been processed successfully and that there is no error.");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

public class L14Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Load the files for input and output.");
        System.out.println("Enter the number of shuffle cyphering you hope to achieve with the program.");
        long shuffleNumber = 0;
        do {
            shuffleNumber = input.nextLong();
        } while(shuffleNumber < 0);
        //Assume the files 'input.txt' and 'output.txt' exist and they are stored in the same directory as this java file. 
        ShuffleCypher shuffleCypher = new ShuffleCypher("input.txt", "output.txt", shuffleNumber);
        shuffleCypher.fileProcessor();

        String decodedText = shuffleCypher.decode(readFile("output.txt"));
        System.out.println("Decoded Text:\n" + decodedText);
        input.close();
    }

    private static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }
}