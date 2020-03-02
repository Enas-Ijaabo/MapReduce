package reducer.runner;

import code.compiler.CodeCompiler;
import code.method.MethodRunner;
import code.run.ClassRunner;
import reducer.ReducerClassText;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReduceRunner {

    private  Map<Object, List> inputMap;
    private ReducerClassText reducerClassText;

    public ReduceRunner(Map<Object, List> inputMap, ReducerClassText reducerClassText) {
        this.inputMap = inputMap;
        this.reducerClassText = reducerClassText;
    }

    /* run the reducing function on the inputMap and return the result as a Map
    * 1-compile the Reducer class
    * 2- load the Reducer class to the memory
    * 3- execute reduce function on the inputMap and return the result*/
    public Map runReducer() {
        compileReducerClass();
        Class reducer= LoadReducerClass();
        Map map= executeReduceFunction(inputMap,reducer);

        return map;
    }

    //compile the Reducer class
    private void compileReducerClass() {
        CodeCompiler codeCompiler= new CodeCompiler(reducerClassText.getReducerClassText(), "/","Reducer");
        codeCompiler.compile();
    }

   // load the Reducer class to the memory
    private Class LoadReducerClass() {

        ClassRunner classRunner= new ClassRunner("/","Reducer");
        Class reducer= classRunner.run();
        return reducer;
    }

    //execute reducer function on the InputMap and return the result as a Map
    private Map executeReduceFunction(Map<Object, List> inputMap, Class mapper) {

        Map reducerOutput= new HashMap();
        try {
            Class<?>[] params = {Class.forName("java.util.Map")};
            Object paramsObj[] = {inputMap};

            MethodRunner methodRunner= new MethodRunner(mapper, "reduce", params);
            reducerOutput = (Map) methodRunner.runMethod(paramsObj);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return reducerOutput;
    }
}
