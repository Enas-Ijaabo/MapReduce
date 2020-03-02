package gui.controllers.start;

import gui.controllers.verify.VerificationController;
import javafx.scene.control.*;

public class StartBuilder {

    private StartController mapReduceController;

    public StartBuilder() {

        mapReduceController = new StartController();
    }

    public StartBuilder setInputFileTf(TextField inputFileTf) {
        mapReduceController.setInputFileTf(inputFileTf);
        return this;
    }

    public StartBuilder setOutputFileTf(TextField outputFileTf) {
        mapReduceController.setOutputFileTf(outputFileTf);
        return this;
    }

    public StartBuilder setNumOfMappersTf(TextField numOfMappersTf) {
        mapReduceController.setNumOfMappersTf(numOfMappersTf);
        return this;
    }

    public StartBuilder setNumOfReducerTf(TextField numOfReducerTf) {
        mapReduceController.setNumOfReducerTf(numOfReducerTf);
        return this;
    }

    public StartBuilder setMapperCodeTa(TextArea mapperCodeTa) {
        mapReduceController.setMapperCodeTa(mapperCodeTa);
        return this;
    }

    public StartBuilder setReducerCodeTa(TextArea reducerCodeTa) {
        mapReduceController.setReducerCodeTa(reducerCodeTa);
        return this;
    }
    public StartBuilder setNotesTa(TextArea notesTa) {
        mapReduceController.setNotesTa( notesTa);
        return this;
    }

    public StartBuilder setVerificationController(VerificationController verificationController) {
        mapReduceController.setVerificationController( verificationController);
        return this;
    }
    public StartController build(){
        return mapReduceController;
    }
}
