package br.com.garod.reflections;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Stream;

public class MethodManipulator {
    private Object instance;
    private Method method;
    private Map<Object, String> params;

    public MethodManipulator(Object instance, Method declaredMethod, Map<Object, String> params) {
        this.method = declaredMethod;
        this.instance = instance;
        this.params = params;
    }

    public Object invoke() {
        try {
            return method.invoke(instance, Stream.of(method.getParameters()).map(x -> params.get(x.getName())).toArray());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
}