package Test.TestGOFBuilder;


public interface A {



    interface Builder<T extends A, V extends A.Builder<T, V>> {

        T build();


    }
}
