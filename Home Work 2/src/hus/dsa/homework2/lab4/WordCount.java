package hus.dsa.homework2.lab4;

public class WordCount {
    private String word;
    private int count;

    public WordCount() {
        count = 1;
    }

    public WordCount(String word) {
        this.word = word;
        this.count = 1;
    }

    public void count() {
        count++;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.word.equals(((WordCount) obj).getWord())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "WordCount" + '[' +
                "word='" + word + '\'' +
                ", count=" + count +
                ']';
    }
}
