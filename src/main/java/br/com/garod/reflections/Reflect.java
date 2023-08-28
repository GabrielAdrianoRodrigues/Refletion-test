package br.com.garod.reflections;

public class Reflect {
    
    public ClassManipulator reflectClass(String fullQualifiedName) {
        try {
            return new ClassManipulator(Class.forName(fullQualifiedName));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Class<?> getClass(String fullQualifiedName) {
        try {
            return Class.forName(fullQualifiedName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
