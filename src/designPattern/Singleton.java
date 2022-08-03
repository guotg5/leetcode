package designPattern;

/**
 * 单例
 *
 * @Author guotiangang
 * @Date 2022/8/3 14:11
 */
public class Singleton {
/*
写法较为简单，在类转载的时候就完成了实例化，避免了线程同步的问题。
缺点是在类装载的时候就完成实例化，没有达到懒加载的效果(Lazy Loading)。如果从始至终从未使用过这个实例，则会造成内存浪费，
这种基于类加载机制避免了多线程同步的问题，不过instance在类装载的时候就完成实例化，
在单例模式中大多数都是调用getInstance方法，但是导致类装载的原因有很多种
，因此不能确定有其他的方式导致类装载，这个时候初始化instance就没有达到懒加载的效果
这种单例模式可以用，有可能造成内存浪费
*/
//    饿汉式 第一次使用类 初始化静态变量
//    private static Singleton singleton = new Singleton();
//
//    public static Singleton getInstance() {
//        return singleton;
//    }

    //饿汉式 第一次使用类 执行static代码块
//    private volatile static Singleton singleton;
//
//    static {
//        System.out.println("static");
//        singleton = new Singleton();
//    }
//
//    public static Singleton getInstance() {
//        return singleton;
//    }

    //线程不安全懒汉式
//    private static Singleton singleton;
//
//    public static Singleton getInstance() {
//        if(singleton == null) {
//            singleton = new Singleton();
//        }
//        return singleton;
//    }

    //线程安全 双重检查锁 懒汉式
//    private volatile static Singleton singleton;
//
//    public static Singleton getInstance() {
//        if(singleton == null) {
//            synchronized (Singleton.class) {
//                if(singleton == null) {
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }

    /*
小结:
1.这种方式采用的类装载机制来保证初始化实例只有一个线程
2.静态内部类方式在Singleton类被加载的时候并不会立即实例化，
而是在需要实例化的时候，调用getInstacne方法，才会装在SingleInstance类，从而完成Singeleton的实例化
3.类的静态属性只会在第一次加载类的时候初始化，
所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化的时候，别的线程是无法进入的。
4.避免了线程不安全，利用静态内部类特点实现了延迟加载，效率高。
在工作中推荐使用
*/
    //静态内部类 推荐
    private static class SingletonInstance {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstance.instance;
    }

    private Singleton() {
        System.out.println("constructor");
    }

    public  String getName() {
        return this.getClass().getSimpleName();
    }
}
