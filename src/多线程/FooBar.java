package 多线程;

import java.util.concurrent.Semaphore;

/** 
 * @ClassName FooBar 
 * @Description 保证forbar顺序打出 
 * @author guotg
 * @date 2020-8-5 15:27:58 
 *  
 */
class FooBar {

	private Semaphore foo = new Semaphore(1);
	private Semaphore bar = new Semaphore(0);

	private int n;

	public FooBar(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			foo.acquire();
			// printFoo.run() outputs "foo". Do not change or remove this line.
			printFoo.run();
			bar.release();
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			bar.acquire();
			// printBar.run() outputs "bar". Do not change or remove this line.
			printBar.run();
			foo.release();
		}
	}
}