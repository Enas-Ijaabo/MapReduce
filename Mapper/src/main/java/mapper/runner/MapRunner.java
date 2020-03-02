package mapper.runner;

import code.run.ClassRunner;
import code.method.MethodRunner;
import code.compiler.CodeCompiler;
import mapper.MapperClassText;
import text.TextSplit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapRunner {

    private TextSplit textSplit;
    private MapperClassText mapperClassText;

    public MapRunner(TextSplit textSplit, MapperClassText mapperClassText) {
        this.textSplit = textSplit;
        this.mapperClassText = mapperClassText;
    }

    /* run the mapping function on the text split and return the result as a Map
    * 1-compile the Mapper class
    * 2- load the Mapper class to the memory
    * 3- execute map function on the text split and return the result*/
    public Map runMapper() {
        compileMapperClass();
        Class mapper= LoadMapperClass();
        Map map=executeMapFunction(textSplit.getText(),mapper);

        return map;
    }

    //compile the Mapper class
    private void compileMapperClass() {
        code.compiler.CodeCompiler codeCompiler= new CodeCompiler(mapperClassText.getMapperClassText(), "/","Mapper");
        codeCompiler.compile();
    }

   // load the Mapper class to the memory
    private Class LoadMapperClass() {

        ClassRunner classRunner= new ClassRunner("/","Mapper");
        Class mapper= classRunner.run();
        return mapper;
    }

    //execute map function on the text split and return the result as a Map
    private Map executeMapFunction(List<Character> text, Class mapper) {

        Map mapperOutput= new HashMap();
        try {
            Class<?>[] params = {Class.forName("java.util.List")};
            Object paramsObj[] = {text};

            MethodRunner methodRunner= new MethodRunner(mapper, "map", params);
            mapperOutput = (Map) methodRunner.runMethod(paramsObj);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return mapperOutput;
    }
}
