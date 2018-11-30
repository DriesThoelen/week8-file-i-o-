package be.pxl.fileio.Files.oefening2;

public class WordCount implements Comparable<WordCount>, CharSequence {
    private String word;
    private int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
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
    public int length() {
        return this.word.length();
    }

    @Override
    public char charAt(int index) {
        return this.word.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.word.subSequence(start, end);
    }

    @Override
    public String toString() {
        return word + " " + count;
    }

    @Override
    public int compareTo(WordCount wc) {
        return wc.count - this.count;
    }
}
