package mapReduce.start;

import mapper.MapTaskStarter;
import gui.input.GuiInputs;
import mapper.global_output.MappersOutput;
import output.writer.OutputFileWriter;
import reducer.ReduceTaskStarter;
import reducer.global_output.ReducersOutput;
import server.Server;
import shuffel.ShuffleTaskStarter;
import splitter.SplitTaskStarter;
import splitter.TextSplits;
import java.util.List;
import java.util.Map;

public class StartMapReduce {


    GuiInputs guiInputs;

    public StartMapReduce(GuiInputs guiInputs) {
        this.guiInputs = guiInputs;

    }

    public void start(){

        MappersOutput.reset();
        ReducersOutput.reset();
        TextSplits textSplits= startSplittingStage();
        startMappingStage(textSplits);
        List<Map> reducersInputs= startShufflingStage();
        startReducingStage(reducersInputs);
        writeOutput();
    }

    //start Splitting stage
    private TextSplits startSplittingStage() {

        SplitTaskStarter splitTaskStarter= new SplitTaskStarter(  guiInputs.getNumOfMapperNodes()
                ,guiInputs.getInputFilePath());
        TextSplits textSplits= splitTaskStarter.startSplittingTask();
        return textSplits;

    }

    //start Mapping Stage
    private void startMappingStage(TextSplits textSplits){

        Server server= Server.getInstance();
        MapTaskStarter mapTaskStarter= new MapTaskStarter(guiInputs.getNumOfMapperNodes(), textSplits,
                guiInputs.getMapperCode(), server.getServerSocket());
        mapTaskStarter.startMapTask();
    }

    //start shuffling stage
    private List<Map> startShufflingStage(){

        ShuffleTaskStarter shuffleTaskStarter= new ShuffleTaskStarter(guiInputs.getNumOfReducerNodes());
        List<Map> reducersInputs= shuffleTaskStarter.startShufflingTask();
        return reducersInputs;
    }

    //start reducing stage
    private void startReducingStage(List<Map> reducersInputs){

        Server server= Server.getInstance();
        ReduceTaskStarter reduceTaskStarter= new ReduceTaskStarter(guiInputs.getNumOfReducerNodes(), reducersInputs ,
                guiInputs.getReducerCode(), server.getServerSocket());
        reduceTaskStarter.startReduceTask();
    }

    //write output file
    private void writeOutput() {

        OutputFileWriter outputFileWriter=
                new OutputFileWriter(guiInputs.getOutputFilePath(),"output", ReducersOutput.getReducersOutputList());
        outputFileWriter.writeFile();
    }
}
