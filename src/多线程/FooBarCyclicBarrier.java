package 多线程;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/** 
 * @ClassName FooBarCyclicBarrier 
 * @Description 使用CyclicBarrier实现顺序输出 
 * @author guotg
 * @date 2020-8-5 15:41:48 
 *  
 */
class FooBarCyclicBarrier {
	private int n;

	public FooBarCyclicBarrier(int n) {
		this.n = n;
	}

	CyclicBarrier cb = new CyclicBarrier(2);

	volatile boolean fin = true;

	public void foo(Runnable printFoo) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			while(!fin);
			printFoo.run();
			fin = false;
			try {
				cb.await();
			} catch (BrokenBarrierException e) {
			}
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			while(fin);
			printBar.run();
			fin = true;
			try {
				cb.await();
			} catch (BrokenBarrierException e) {
			}
		}
	}

	public static void main(String[] args) {
		FooBarCyclicBarrier fb = new FooBarCyclicBarrier(10);
		new Thread(() -> {
			try {
				fb.foo(()-> System.out.print("foo"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(() -> {
			try {
				fb.bar(()-> System.out.print("bar"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}