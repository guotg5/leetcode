package 多线程;

import java.util.concurrent.Semaphore;

/** 
 * @ClassName Foo 
 * @Description TODO 
 * @author guotg
 * @date 2020-8-5 15:13:53 
 *  
 */
class TestSemaphore {
	
	private Semaphore one = new Semaphore(0);
	private Semaphore two = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        one.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        one.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        one.release();
        two.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        two.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        two.release();
    }
}