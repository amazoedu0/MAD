package Lab_2;
import java.io.*;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;

public class WordCount {

    public static void task_1(String str) {
        System.out.println("Total number of Words: " + countWords(str));
    }

    public static void task_2(String str) throws IOException {
        char choice = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("a. Count Vowels");
        System.out.println("b. Count Spaces");
        System.out.println("c. Write data to other file");
        System.out.print("Your Choice : ");

        choice = sc.next().charAt(0);

        if (toUpperCase(choice) == 'A')
            System.out.println("Total number of Vowels: " + countVowels(str));
        else if (toUpperCase(choice) == 'B')
            System.out.println("Total number of Spaces: " + countSpaces(str));
        else if (toUpperCase(choice) == 'C') {
            System.out.print("\nEnter File Name (without space): ");
            String filename = "Lab_2/" + sc.next() + ".txt";
            System.out.println(filename);
            File newFile = new File(filename);
            if (newFile.createNewFile()) {
                System.out.println("File created: " + newFile.getName());

                BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

                writer.write(str);
                writer.close();

            } else {
                System.out.println("Already Exists!\nRerun with new name.");
            }
        }
    }

    public static String readFile(File fileObj) throws IOException {
//        FileReader fileReader = new FileReader(fileObj);
        BufferedReader reader = new BufferedReader(new FileReader(fileObj));
        char ch = 0;
        String str = "";
        while (true) {
            ch = (char) reader.read();
            if (ch == '\uFFFF') {
                break;
            }
            str += ch;
        }
        return str;
    }

    public static int countSpaces(String s) {
        int spaces = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {
                spaces++;
            }
        }
        return spaces;
    }

    public static int countWords(String s) {
        int words = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\t' || s.charAt(i) == ' ' || s.charAt(i) == '\n') {
                words++;
            }
        }
        return words + 1;
    }

    public static int countVowels(String s) {
        int vowels = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
                vowels++;
        }
        return vowels;
    }

    public static void main(String[] args) {

        try {
            File fileObj = new File("Lab_2/file.txt");
            if (fileObj.createNewFile()) {
                System.out.println("File created: " + fileObj.getName());
            } else {

                String str = readFile(fileObj);
                task_1(str);
                task_2(str);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}
