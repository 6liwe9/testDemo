package com.testNio.file;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class testCycliBarrier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CyclicBarrier cb=new CyclicBarrier(10);
		for(int i=0;i<10;i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					int time=new Random().nextInt(9)*1000; 
					System.out.println("thread"+time+"sleep");
					try {
						Thread.sleep(time);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						cb.await();
					} catch (InterruptedException | BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("thread"+time+"dosth");
				}
				
			}).start();;
		}
	}

}
