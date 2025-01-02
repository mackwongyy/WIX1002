//WONG YOONG YEE, UM AY2023/2024, WIX1002
import java.util.*;
import java.io.*;

interface MessageCoder {
    String encode(String plainText);
    String decode(String cipherText);
}

class SubstitutionCypher implements MessageCoder {
    private String inputFileName, outputFileName;
    private int shift;

    public SubstitutionCypher(String inputFileName, String outputFileName, int shift) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
        this.shift = shift;
    }

    @Override
    public String encode(String plainText) {
        StringBuilder cypherText = new StringBuilder();

        for(char character : plainText.toCharArray()) {
            if(Character.isLetter(character)) {
                char shiftedCharacter = (char) (character + shift);
                cypherText.append(shiftedCharacter);
            } else {
                cypherText.append(character);
            }
        }

        return cypherText.toString();
    }

    @Override
    public String decode(String cypherText) {
        StringBuilder plainText = new StringBuilder();

        for(char character : cypherText.toCharArray()) {
            if(Character.isLetter(character)) {
                char shiftedCharacter = (char) (character - shift);
                plainText.append(shiftedCharacter);
            } else {
                plainText.append(character);
            }
        }

        return plainText.toString();
    }

    public void fileProcessor() {
        try(BufferedReader reader = new BufferedReader(new FileReader(inputFileName)); BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
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

public class L14Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Load the files for input and output.");
        System.out.println("Enter the number of shift you hope to achieve with the program.");
        long shiftNumber = 0;
        do {
            shiftNumber = input.nextLong();
        } while(shiftNumber < 0);
        //Assume the files 'input.txt' and 'output.txt' exist and they are stored in the same directory as this java file. 
        SubstitutionCypher cypher = new SubstitutionCypher("input.txt", "output.txt", shiftNumber);
        cypher.fileProcessor();

        String decodedText = cypher.decode(readFile("output.txt"));
        System.out.println("Decoded Text:\n" + decodedText);
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