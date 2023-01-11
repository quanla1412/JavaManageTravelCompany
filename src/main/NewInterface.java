package main;

/**
 *
 * @author LeAnhQuan
 */
public interface NewInterface {
    abstract void hello();
    abstract void bye();
    default void xuat() {
        System.out.println("xin chao");
    }
}
