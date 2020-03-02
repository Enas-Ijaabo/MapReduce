package gui.controllers.start;

import gui.controllers.verify.VerificationController;
import gui.input.GuiInputBuilder;
import gui.input.GuiInputs;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import mapReduce.start.StartMapReduce;

public class StartController {

   private TextField inputFileTf;
   private TextField outputFileTf;
   private TextField numOfMappersTf;
   private TextField numOfReducerTf;
   private TextArea mapperCodeTa;
   private TextArea reducerCodeTa;
   private TextArea notesTa;
   private VerificationController verificationController;
   private GuiInputs guiInputs;

    /*checks if the gui inputs verified, if so store this input and start mapReduce
    otherwise, return
     */
    public void start(){

        if (!isGuiInputVerified()){
            return;
        }
        storeInput();
        StartMapReduce startMapReduce= new StartMapReduce(guiInputs);
        startMapReduce.start();
        done();
    }

    //checks if the gui input is verified
    private boolean isGuiInputVerified(){
        if (!verificationController.verifyInput()){
            return false;
        }
        return true;
    }

    //store gui Input in a GuiInput object
    private void storeInput() {
        GuiInputBuilder guiInputBuilder= new GuiInputBuilder();
        guiInputs= guiInputBuilder.setInputFilePath(inputFileTf.getText()).setMapperCode(mapperCodeTa.getText())
                .setNumOfMapperNodes(numOfMappersTf.getText()).setNumOfReducerNodes(numOfReducerTf.getText())
                .setOutputFilePath(outputFileTf.getText()).setReducerCode(reducerCodeTa.getText()).build();
    }

    //set the notes textArea's text to Done
    private void done() {
        notesTa.setText("Done ...");
    }

    public void setVerificationController(VerificationController verificationController) {
        this.verificationController = verificationController;
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
