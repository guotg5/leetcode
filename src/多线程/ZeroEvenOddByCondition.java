package 多线程;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/** 
 * @ClassName ZeroEvenOddByCondition 
 * @Description 使用condition控制线程的休眠和唤醒  会一直休眠
 * @author guotg
 * @date 2020-8-5 17:32:59 
 *  
 */
class ZeroEvenOddByCondition {
	private int n;

	public ZeroEvenOddByCondition(int n) {
		this.n = n;
	}

	ReentrantLock lock = new ReentrantLock();
	Condition even = lock.newCondition();
	Condition odd = lock.newCondition();

	volatile boolean ifzero = true;
	volatile Integer m = 1;
	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
		do {
			lock.lock();
			try{
				if(ifzero) {
					printNumber.accept(0);
					ifzero = false;
					if(m%2==0) {
						even.signal();
					}else {
						odd.signal();
					}
				}
			}finally {
				lock.unlock();
			}
		}while(m<n);
	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		while(m<=n) {
			lock.lock();
			try{
				if(ifzero||m%2==1){
					even.await(10, TimeUnit.MILLISECONDS);
				}
				printNumber.accept(m);
				System.out.println();
				ifzero = true;
				m++;
			}finally {
				lock.unlock();
			}
		}
	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		while(m<=n) {
			lock.lock();
			try{
				if(ifzero||m%2==0) {
					even.await(10, TimeUnit.MILLISECONDS);
				}
				printNumber.accept(m);
				System.out.println();
				ifzero = true;
				m++;
			}finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		ZeroEvenOddByCondition zeroEvenOdd = new ZeroEvenOddByCondition(5);
		new Thread(() -> {
			try {
				zeroEvenOdd.zero(System.out::print);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(() -> {
			try {
				zeroEvenOdd.even(System.out::print);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(() -> {
			try {
				zeroEvenOdd.odd(System.out::print);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}