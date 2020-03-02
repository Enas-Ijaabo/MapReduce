package reducer;

public class ReducerClassText {

    String reducerClassText;

    public ReducerClassText(String mapperClass) {
        reducerClassText = mapperClass;
    }

    public String getReducerClassText() {

        return reducerClassText;
    }

    public void setReducerClassText(String reducerClassText) {

        this.reducerClassText = reducerClassText;
    }

    @Override
    public String toString() {
        return "ReducerClassText{" +
                "reducerClassText='" + reducerClassText + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReducerClassText that = (ReducerClassText) o;

        return reducerClassText != null ? reducerClassText.equals(that.reducerClassText) : that.reducerClassText == null;
    }

    @Override
    public int hashCode() {
        return reducerClassText != null ? reducerClassText.hashCode() : 0;
    }
}
