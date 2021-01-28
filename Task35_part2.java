import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Task35_part2 {
    static String filename;

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter text file name: ");
        filename = s.next()+".txt";
        TextFileAnalyzer tfaa = Task35_part2.getFileInfo(filename);
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.addTextfileObj(tfaa);
        System.out.println("Enter second text file name: ");
        filename = s.next()+".txt";
        TextFileAnalyzer tfa1 = Task35_part2.getFileInfo(filename);
        sl.addTextfileObj(tfa1);
        
        sl.showTextAnalysis();

    }

    static TextFileAnalyzer getFileInfo(String filename) throws Exception {
        File file = new File(filename);
        TextFileAnalyzer tf = new TextFileAnalyzer();
        tf.date = java.time.LocalDate.now();
        tf.time = java.time.LocalTime.now();
        int word1 = 0;
        int chars = 0;
        int frwords = 0;
        int lword = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            String[] words = null;
            while ((line = br.readLine()) != null) {

                line = line.toLowerCase().replaceAll("[!,':;.?\"]", " ");
                words = line.split(" ");

                for (String word : words) {
                    word1++;
                    frwords = frwords + wordCount(word);
                    chars = chars + word.length();
                    lword = lword + longWords(word);
                }
            }
            tf.nameOfFile = filename;
            tf.noofwords = word1;
            tf.noofcharacters = chars;
            tf.frequentWords = frwords;
            tf.longWords = lword;
        }
        return tf;
    }

    static int wordCount(String word) {
        if (word.length() >= 1 && word.length() <= 15) {
            return 1;
        }
        return 0;
    }

    static int longWords(String word) {
        if (word.length() > 15) {
            return 1;
        }
        return 0;

    }

}

class Node {
    TextFileAnalyzer tfa;
    Node next;
}

class SinglyLinkedList {
    Node head;

    public Node createNode(TextFileAnalyzer tfa) {
        Node node = new Node();
        node.tfa = tfa;
        node.next = null;
        return node;
    }

    public void addTextfileObj(TextFileAnalyzer tfa) {

        Node node = createNode(tfa);

        if (head == null) {
            head = node;
        }
       else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void showTextAnalysis() {
        Node temp = head;
        while (temp.next != null) {
            System.out.println(temp.tfa.getNameOfFile()+"\n"+ temp.tfa.getDate()+ temp.tfa.getTime() +"\n"+ temp.tfa.getNoofwords()+"\n"+ temp.tfa.getNoofcharacters()+ "\n"+ temp.tfa.getFrequentWords()+"\n"+ temp.tfa.getLongWords()) ;
            temp = temp.next;
        }
        System.out.println(temp.tfa.getNameOfFile()+"\n"+ temp.tfa.getDate()+ temp.tfa.getTime() +"\n"+ temp.tfa.getNoofwords()+"\n"+ temp.tfa.getNoofcharacters()+ "\n"+ temp.tfa.getFrequentWords()+"\n"+ temp.tfa.getLongWords()) ;
    }

}
