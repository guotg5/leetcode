package 多线程;

import java.util.concurrent.Semaphore;

/** 
 * @ClassName H2O 
 * @Description 打印水分子 HHO 顺序无所谓 
 * @author guotg
 * @date 2020-8-6 10:10:10 
 *  
 */
class H2O {

    public H2O() {
        
    }
    
    Semaphore h = new Semaphore(2);
    Semaphore o = new Semaphore(2);
    

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    	h.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        o.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
		h.release(2);
    }
}