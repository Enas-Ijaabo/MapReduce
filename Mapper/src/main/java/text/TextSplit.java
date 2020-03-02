package text;

import java.util.List;

public class TextSplit {

    List<Character> text;

    public TextSplit(List<Character> text) {
        this.text = text;
    }

    public List<Character> getText() {
        return text;
    }

    public void setText(List<Character> text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TextSplit{" +
                "text=" + text +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextSplit textSplit = (TextSplit) o;

        return text != null ? text.equals(textSplit.text) : textSplit.text == null;
    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }
}
