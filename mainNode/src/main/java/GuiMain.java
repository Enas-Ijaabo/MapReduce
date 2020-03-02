import gui.controllers.start.StartBuilder;
import gui.controllers.start.StartController;
import gui.controllers.verify.VerificationController;
import gui.controllers.verify.VerificationControllerBuilder;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuiMain extends Application {

    Label inputFileLbl;
    Label outputFileLbl;
    Label numOfMappersLbl;
    Label numOfReducerLbl;
    Label mapperCodeLbl;
    Label reducerCodeLbl;
    Label notesLbl;
    TextField inputFileTf;
    TextField outputFileTf;
    TextField numOfMappersTf;
    TextField numOfReducerTf;
    TextArea mapperCodeTa;
    TextArea reducerCodeTa;
    TextArea notesTa;
    Button startMapReduceBtn;
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        initializeComponents();
        Scene scene = new Scene(getMainPane());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setWidth(800d);
        primaryStage.setHeight(600d);
        primaryStage.setTitle("Map Reduce");
        primaryStage.show();



    }

    //initialize the gui components (Controls eg. Label and textfield)
    private void initializeComponents(){
        inputFileLbl = new Label("input file path");
        outputFileLbl= new Label("output directory path");
        numOfMappersLbl= new Label("num of mapper nodes");
        numOfReducerLbl= new Label("num of reducer nodes");
        mapperCodeLbl= new Label("Mapper code");
        reducerCodeLbl= new Label("Reducer code");
        notesLbl= new Label("Notes");
        inputFileTf= new TextField();
        outputFileTf= new TextField();
        numOfMappersTf= new TextField();
        numOfReducerTf= new TextField();

        initializeButton();
        initializeMapperTextArea();
        initializeReducerTextArea();
        initializeNotesTextArea();

    }

    //initialize start mapReduce button, and initialize its action event
    private void initializeButton() {

        startMapReduceBtn= new Button("Start MapReduce");

        startMapReduceBtn.setOnAction(e->{

           VerificationControllerBuilder verificationControllerBuilder= new VerificationControllerBuilder();
           VerificationController verificationController= verificationControllerBuilder.setInputFileTf(inputFileTf)
                    .setOutputFileTf(outputFileTf).setNumOfMappersTf(numOfMappersTf).setNumOfReducerTf(numOfReducerTf)
                    .setMapperCodeTa(mapperCodeTa).setReducerCodeTa(reducerCodeTa).setNotesTa(notesTa).build();

            StartBuilder startBuilder= new StartBuilder();
            StartController startMapReduceController= startBuilder.setInputFileTf(inputFileTf)
                    .setOutputFileTf(outputFileTf).setNumOfMappersTf(numOfMappersTf).setNumOfReducerTf(numOfReducerTf)
                    .setMapperCodeTa(mapperCodeTa).setVerificationController(verificationController)
                    .setReducerCodeTa(reducerCodeTa).setNotesTa(notesTa).build();
            startMapReduceController.start();
            });
    }

    //initialize mapper code textArea
    private void initializeMapperTextArea(){

        mapperCodeTa= new TextArea();
        mapperCodeTa.setText("public class Mapper{\n" +
                "public Map<key, value> startMapping(List<Character> text){}\n" +
                "}");
    }

    //initialize reducer code textArea
    private void initializeReducerTextArea(){

        reducerCodeTa= new TextArea();
        reducerCodeTa.setText("public class Reducer{\n" +
                "public Map<key, value> startReducing(Map<key, List<value>> mappersOutput){}\n" +
                "}");
    }

    //initialize the notes textArea
    private void initializeNotesTextArea(){

        notesTa= new TextArea();
        notesTa.setEditable(false);
    }

    //create the pane the will contain all of the other components
    // and add those component to it
    private Pane getMainPane(){

        VBox vBox= new VBox();
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.setSpacing(5);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(getFirstPane(), getMapperCodePane(),
                getReducerCodePane(),getNotesPane(), startMapReduceBtn);

        return vBox;
    }

    //create the GridPane that contain the tf and lbl for all of: inputFile, outputFile, numOfMappers,numOfReducerLbl
    private GridPane getFirstPane(){

        GridPane gridPane= new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        gridPane.add( inputFileLbl, 0, 0);
        gridPane.add(inputFileTf,1,0);
        gridPane.add( outputFileLbl, 0, 1);
        gridPane.add(outputFileTf,1,1);
        gridPane.add( numOfMappersLbl, 0, 2);
        gridPane.add(numOfMappersTf,1,2);
        gridPane.add( numOfReducerLbl, 0, 3);
        gridPane.add(numOfReducerTf,1,3);

        return gridPane;
    }

    //return the Vbox that contains mapperCodeLbl and mapperCodeTa
    private VBox getMapperCodePane(){
        VBox vBox= new VBox();
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(20,0,10,0));
        vBox.getChildren().addAll(mapperCodeLbl,mapperCodeTa);
        return vBox;
    }

    //return the Vbox that contains reducerCodeLbl and reducerCodeTa
    private VBox getReducerCodePane(){
        VBox vBox= new VBox();
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10,0,20,0));
        vBox.getChildren().addAll(reducerCodeLbl,reducerCodeTa);
        return vBox;
    }

    //return the Vbox that contains notesLbl and notesTa
    private VBox getNotesPane(){
        VBox vBox= new VBox();
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10,0,20,0));
        vBox.getChildren().addAll(notesLbl,notesTa);
        return vBox;
    }
}



