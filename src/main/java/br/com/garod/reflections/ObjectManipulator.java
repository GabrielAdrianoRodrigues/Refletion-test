package br.com.garod.reflections;

import java.util.Map;
import java.util.stream.Stream;

public class ObjectManipulator {
    private Object instance;

    public ObjectManipulator(Object newInstance) {
        this.instance = newInstance;
    }
    
    public MethodManipulator getMethod(String name, Map<Object, String> params) {
        try {
            return new MethodManipulator(instance, Stream.of(instance.getClass().getDeclaredMethods()).filter(x -> x.getName().equals(name) && x.getParameterCount() == params.values().size() && Stream.of(x.getParameters()).allMatch(y -> params.keySet().contains(y.getName()) && params.get(y.getName()).getClass().equals(y.getType()))).findFirst().orElseThrow(Exception::new), params); 
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
