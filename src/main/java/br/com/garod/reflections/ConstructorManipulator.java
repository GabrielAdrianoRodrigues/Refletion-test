package br.com.garod.reflections;

import java.lang.reflect.Constructor;

public class ConstructorManipulator {

    private Constructor<?> constructor;

    public ConstructorManipulator(Constructor<?> constructor) {
        this.constructor = constructor;
    }

    public ObjectManipulator newInstance() {
        try {
            return new ObjectManipulator(this.constructor.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
