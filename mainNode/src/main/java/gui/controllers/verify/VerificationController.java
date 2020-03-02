package gui.controllers.verify;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import verifiers.*;

public class VerificationController {

    private TextField inputFileTf;
    private TextField outputFileTf;
    private TextField numOfMappersTf;
    private TextField numOfReducerTf;
    private TextArea mapperCodeTa;
    private TextArea reducerCodeTa;
    private TextArea notesTa;

    //check the verification for all of the textFields and textAreas in the gui
    public boolean verifyInput(){
        notesTa.setText("");
        boolean allInputVerified= verifyInputFilePath()&& verifyOutputPath() && verifyMapperCode()
                && verifyReducerCode() && verifyMapperNodeNumber()&& verifyReducerNodeNumber();

        if (allInputVerified ){
            return true;
        }
        return false;
    }

    //check if the input file exist, if not write an error message on notesTa
    private  boolean verifyInputFilePath(){

        if (InputFileVerifier.verify(inputFileTf.getText())){

            return true;
        }
        String errorMessage= "\n Input file doesn't exist, make sure the path is correct";
        notesTa.setText(notesTa.getText()+ errorMessage);
        return false;
    }

    //check if the output directory exist, if not write an error message on notesTa
    private  boolean verifyOutputPath(){

        if (OutputFileVerifier.verify(outputFileTf.getText())){

            return true;
        }
        String errorMessage= "\n Output directory doesn't exist, make sure the path is correct";
        notesTa.setText(notesTa.getText()+ errorMessage);
        return false;
    }

    //check if the nodeNumber entered is an integer, if not write an error message on notesTa
    private  boolean verifyMapperNodeNumber(){

        if (NumOfNodesVerifier.verify(numOfMappersTf.getText())){
            return true;
        }
        String errorMessage= "\n The number Of Mapper nodes is not valid";
        notesTa.setText(notesTa.getText()+ errorMessage);
        return false;
    }

    //check if the nodeNumber entered is an integer, if not write an error message on notesTa
    private  boolean verifyReducerNodeNumber(){

        if (NumOfNodesVerifier.verify(numOfReducerTf.getText())){
            return true;
        }
        String errorMessage= "\n The number Of Reducer nodes is not valid";
        notesTa.setText(notesTa.getText()+ errorMessage);
        return false;
    }

    //check if the MapperCode is correctly compiled, if not write an error message on notesTa
    private  boolean verifyMapperCode(){

        if (CodeVerifier.verify(mapperCodeTa.getText(), "Mapper")){
            return true;
        }
        String errorMessage= "\n error compiling the mapper code";
        notesTa.setText(notesTa.getText()+ errorMessage);
        return false;
    }

    //check if the MapperCode is correctly compiled, if not write an error message on notesTa
    private  boolean verifyReducerCode(){

        if (CodeVerifier.verify(reducerCodeTa.getText(), "Reducer")){
            return true;
        }
        String errorMessage= "\n error compiling the reducer code";
        notesTa.setText(notesTa.getText()+ errorMessage);
        return false;
    }

    public void setInputFileTf(TextField inputFileTf) {
        this.inputFileTf = inputFileTf;
    }

    public void setOutputFileTf(TextField outputFileTf) {
        this.outputFileTf = outputFileTf;
    }

    public void setNumOfMappersTf(TextField numOfMappersTf) {
        this.numOfMappersTf = numOfMappersTf;
    }

    public void setNumOfReducerTf(TextField numOfReducerTf) {
        this.numOfReducerTf = numOfReducerTf;
    }

    public void setMapperCodeTa(TextArea mapperCodeTa) {
        this.mapperCodeTa = mapperCodeTa;
    }

    public void setReducerCodeTa(TextArea reducerCodeTa) {
        this.reducerCodeTa = reducerCodeTa;
    }

    public void setNotesTa(TextArea notesTa) {
        this.notesTa = notesTa;
    }
}

