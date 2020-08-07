package 多线程;

import java.util.function.IntConsumer;

/** 
 * @ClassName ZeroEvenOdd 
 * @Description 0 奇数 偶数 
 * @author guotg
 * @date 2020-8-5 17:32:39 
 *  
 */
class ZeroEvenOdd {
	private int n;

	public ZeroEvenOdd(int n) {
		this.n = n;
	}

	volatile boolean ifzero = true;
	volatile Integer m = 1;
	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
		do {
			if(ifzero) {
				printNumber.accept(0);
				ifzero = false;
			}
		}while(m<n);
	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		while(m<=n) {
			synchronized (this) {
				if(!ifzero&&m%2==0) {
					printNumber.accept(m);
					System.out.println();
					ifzero = true;
					m++;
				}
			}
		}
	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		while(m<=n) {
			synchronized (this) {
				if(!ifzero&&m%2==1) {
					printNumber.accept(m);
					System.out.println();
					ifzero = true;
					m++;
				}
			}
		}
	}
	
	 public static void main(String[] args) {
	        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);
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