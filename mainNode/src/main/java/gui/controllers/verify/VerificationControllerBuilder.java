package gui.controllers.verify;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class VerificationControllerBuilder {

    private VerificationController verificationController;

    public VerificationControllerBuilder() {

        verificationController = new VerificationController();
    }

    public VerificationControllerBuilder setInputFileTf(TextField inputFileTf) {
        verificationController.setInputFileTf(inputFileTf);
        return this;
    }

    public VerificationControllerBuilder setOutputFileTf(TextField outputFileTf) {
        verificationController.setOutputFileTf(outputFileTf);
        return this;
    }

    public VerificationControllerBuilder setNumOfMappersTf(TextField numOfMappersTf) {
        verificationController.setNumOfMappersTf(numOfMappersTf);
        return this;
    }

    public VerificationControllerBuilder setNumOfReducerTf(TextField numOfReducerTf) {
        verificationController.setNumOfReducerTf(numOfReducerTf);
        return this;
    }

    public VerificationControllerBuilder setMapperCodeTa(TextArea mapperCodeTa) {
        verificationController.setMapperCodeTa(mapperCodeTa);
        return this;
    }

    public VerificationControllerBuilder setReducerCodeTa(TextArea reducerCodeTa) {
        verificationController.setReducerCodeTa(reducerCodeTa);
        return this;
    }

    public VerificationControllerBuilder setNotesTa(TextArea notesTa) {
        verificationController.setNotesTa(notesTa);
        return this;
    }

    public VerificationController build() {
        return verificationController;
    }

}
