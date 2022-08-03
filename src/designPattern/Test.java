package designPattern;

/**
 * 测试单例
 *
 * @Author guotiangang
 * @Date 2022/8/3 14:38
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("main");
        Class.forName("designPattern.Singleton");
    }
}
