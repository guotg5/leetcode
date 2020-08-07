package 多线程;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/** 
 * @ClassName FizzBuzz 
 * @Description 顺序打印 1195
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
	Semaphore common = new Semaphore(1);
	// printFizz.run() outputs "fizz".
	public void fizz(Runnable printFizz) throws InterruptedException {
		for(int i=1;i<=n;i++) {
			if(i%3==0&&i%5!=0) {
				fizz.acquire();
				printFizz.run();
				common.release();
			}
		}
	}

	// printBuzz.run() outputs "buzz".
	public void buzz(Runnable printBuzz) throws InterruptedException {
		for(int i=1;i<=n;i++) {
			if(i%5==0&&i%3!=0) {
				buzz.acquire();
				printBuzz.run();
				common.release();
			}
		}
	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		for(int i=1;i<=n;i++) {
			if(i%5==0&&i%3==0) {
				fizzbuzz.acquire();
				printFizzBuzz.run();
				common.release();
			}
		}
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void number(IntConsumer printNumber) throws InterruptedException {
		while(count <= n) {
				common.acquire();
				if(count%3==0&&count%5==0) {
					fizzbuzz.release();
				}else if(count%3==0) {
					fizz.release();
				}else if(count%5==0) {
					buzz.release();
				}else {
					printNumber.accept(count);
					common.release();
				}
				count++;
		}
	}

	public static void main(String[] args) {
		FizzBuzz fb = new FizzBuzz(15);
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