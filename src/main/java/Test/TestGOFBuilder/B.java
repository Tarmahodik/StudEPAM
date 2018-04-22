package Test.TestGOFBuilder;

public interface B extends A {



    String getChildrenRequiredField();
    String getChildrenOptionalField();

    interface Builder<T extends B, V extends Builder<T, V>> extends A.Builder<T, V> {

        V setChildrenOptionalField(String childrenOptionalField);
    }
}