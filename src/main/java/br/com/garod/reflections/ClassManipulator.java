package br.com.garod.reflections;

public class ClassManipulator {

    private Class<?> clazz;

    public ClassManipulator(Class<?> clazz) {
        this.clazz = clazz;
    }

    public ConstructorManipulator getDefaultConstructor() {
        try {
            return new ConstructorManipulator(clazz.getDeclaredConstructor());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } 
    }
}
