package br.com.garod.containers;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class IoCContainer {

    private Map<Class<?>, Class<?>> mapOfTypes = new HashMap<>();
 
    public Object getInstance(Class<?> type) {
        try {
            Class<?> destinyType = mapOfTypes.get(type);

            if(destinyType != null) {
                return getInstance(destinyType);
            }

            Optional<Constructor<?>> construtor = Stream.of(type.getConstructors()).filter(x -> x.getParameterCount() == 0).findFirst();
            return construtor.isPresent() ? construtor.get().newInstance() : altenativeConstrutorInstance(type);      
        } catch(Exception e) {    
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public <T, K extends T> void register(Class<T> sourceType, Class<K> destinyType) {
        mapOfTypes.put(sourceType, destinyType);
    }

    private Object altenativeConstrutorInstance(Class<?> type) throws Exception {
        Constructor<?> construtor = type.getDeclaredConstructors()[0];
        return construtor.newInstance(Stream.of(construtor.getParameters()).map(x -> getInstance(x.getType())).toArray());
    }

}