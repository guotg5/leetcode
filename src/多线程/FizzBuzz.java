package 多线程;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/** 
 * @ClassName FizzBuzz 
 * @Description 顺序打印 
 * @author guotg
 * @date 2020-8-6 10:21:51 
 *  
 */
class FizzBuzz {
	private int n;

	public FizzBuzz(int n) {
		this.n = n;
	}

	volatile int count = 1;
	Semaphore fizz = new Semaphore(0);
	Semaphore buzz = new Semaphore(0);
	Semaphore fizzbuzz = new Semaphore(0);
	// printFizz.run() outputs "fizz".
	public void fizz(Runnable printFizz) throws InterruptedException {
		fizz.acquire();
		printFizz.run();
		synchronized (this) {
			this.notifyAll();
		}

	}

	// printBuzz.run() outputs "buzz".
	public void buzz(Runnable printBuzz) throws InterruptedException {
		buzz.acquire();
		printBuzz.run();
		synchronized (this) {
			this.notifyAll();
		}
	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		fizzbuzz.acquire();
		printFizzBuzz.run();
		synchronized (this) {
			this.notifyAll();
		}
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void number(IntConsumer printNumber) throws InterruptedException {
		while(count <= n) {
			synchronized (this) {
				if(count%3==0&&count%5==0) {
					fizzbuzz.release();
					this.wait();
				}else if(count%3==0) {
					fizz.release();
					this.wait();
				}else if(count%5==0) {
					buzz.release();
					this.wait();
				}else {
					printNumber.accept(count);
				}
				count++;
			}
		}
	}

	public static void main(String[] args) {
		FizzBuzz fb = new FizzBuzz(10);
		new Thread(() -> {
			try {
				fb.fizz(()->System.out.print(" fizz"));
			} catch (InterruptedException e) {
			}
		}).start();
		new Thread(() -> {
			try {
				fb.buzz(()->System.out.print(" buzz"));
			} catch (InterruptedException e) {
			}
		}).start();
		new Thread(() -> {
			try {
				fb.fizzbuzz(()->System.out.print(" fizzbuzz"));
			} catch (InterruptedException e) {
			}
		}).start();
		new Thread(() -> {
			try {
				fb.number(System.out::print);
			} catch (InterruptedException e) {
			}
		}).start();
	}
}