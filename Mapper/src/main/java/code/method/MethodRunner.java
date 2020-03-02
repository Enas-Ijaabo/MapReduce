package code.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodRunner {

   private Class<?> aClass;
   private String methodName;
   private Class<?>[] paramsClass;
   private  Method method;

    public MethodRunner(Class<?> aClass, String methodName, Class<?>[] paramsClass) {
        this.aClass = aClass;
        this.methodName = methodName;
        this.paramsClass = paramsClass;
        createMethod();
    }

    // declare a method object
    private void createMethod() {
      try {
         method= aClass.getDeclaredMethod(methodName, paramsClass);

      } catch (NoSuchMethodException e) {
          e.printStackTrace();
      }

    }

    /*execute the given method with the given arguments in the array paramsObj.
    return the object returned by the given method   */
    public Object runMethod(Object[] paramsObj){

        Object  methodOutput= null;
        try {
            Object classObject = aClass.newInstance();
            methodOutput = method.invoke(classObject, paramsObj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return methodOutput;
    }
}
