package gui.input;

public class GuiInputBuilder {

    GuiInputs guiInputs;

    public GuiInputBuilder() {
        guiInputs= new GuiInputs();
    }

    public GuiInputBuilder setInputFilePath(String inputFilePath) {
        guiInputs.setInputFilePath(inputFilePath);
        return this;
    }

    public GuiInputBuilder setOutputFilePath(String outputFilePath) {
        guiInputs.setOutputFilePath(outputFilePath);
        return this;
    }

    public GuiInputBuilder setNumOfMapperNodes(int numOfMapperNodes) {
        guiInputs.setNumOfMapperNodes(numOfMapperNodes);
        return this;
    }

    public GuiInputBuilder setNumOfMapperNodes(String numOfMapperNodes) {
        guiInputs.setNumOfMapperNodes(Integer.parseInt(numOfMapperNodes));
        return this;
    }
    public GuiInputBuilder setNumOfReducerNodes(int numOfReducerNodes) {
        guiInputs.setNumOfReducerNodes(numOfReducerNodes);
        return this;
    }

    public GuiInputBuilder setNumOfReducerNodes(String numOfReducerNodes) {
        guiInputs.setNumOfReducerNodes(Integer.parseInt(numOfReducerNodes));
        return this;
    }

    public GuiInputBuilder setMapperCode(String mapperCode) {
        guiInputs.setMapperCode(mapperCode);
        return this;
    }

    public GuiInputBuilder setReducerCode(String reducerCode) {
        guiInputs.setReducerCode(reducerCode);
        return this;
    }

    public GuiInputs build(){
        return guiInputs;
    }
}
