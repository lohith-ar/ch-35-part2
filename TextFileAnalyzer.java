import java.time.LocalDate;
import java.time.LocalTime;

public class TextFileAnalyzer {
    String nameOfFile;
    LocalDate date;
    LocalTime time;
    int noofwords;
    int noofcharacters;
    int frequentWords;
    int longWords;

    public String getNameOfFile() {
        return nameOfFile;
    }

    public void setNameOfFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }

    

    public int getNoofwords() {
        return noofwords;
    }

    public void setNoofwords(int noofwords) {
        this.noofwords = noofwords;
    }

    public int getNoofcharacters() {
        return noofcharacters;
    }

    public void setNoofcharacters(int noofcharacters) {
        this.noofcharacters = noofcharacters;
    }

    public int getFrequentWords() {
        return frequentWords;
    }

    public void setFrequentWords(int frequentWords) {
        this.frequentWords = frequentWords;
    }

    public int getLongWords() {
        return longWords;
    }

    public void setLongWords(int longWords) {
        this.longWords = longWords;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
    

    
}
