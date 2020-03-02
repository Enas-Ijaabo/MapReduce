package gui.input;

public class GuiInputs {

    private String inputFilePath;
    private String outputFilePath;
    private int numOfMapperNodes;
    private int numOfReducerNodes;
    private String mapperCode;
    private String reducerCode;

    public String getInputFilePath() {
        return inputFilePath;
    }

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }

    public void setOutputFilePath(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    public int getNumOfMapperNodes() {
        return numOfMapperNodes;
    }

    public void setNumOfMapperNodes(int numOfMapperNodes) {
        this.numOfMapperNodes = numOfMapperNodes;
    }

    public int getNumOfReducerNodes() {
        return numOfReducerNodes;
    }

    public void setNumOfReducerNodes(int numOfReducerNodes) {
        this.numOfReducerNodes = numOfReducerNodes;
    }

    public String getMapperCode() {
        return mapperCode;
    }

    public void setMapperCode(String mapperCode) {
        this.mapperCode = mapperCode;
    }

    public String getReducerCode() {
        return reducerCode;
    }

    public void setReducerCode(String reducerCode) {
        this.reducerCode = reducerCode;
    }
}

