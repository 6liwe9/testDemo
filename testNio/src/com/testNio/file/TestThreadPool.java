package com.testNio.file;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool implements ThreadFactory ,Runnable {
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		ThreadPoolExecutor pool=new ThreadPoolExecutor(5, 6, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(10), new TestThreadPool(121) );
		 for(int i=0;i<15;i++){
			 TestThreadPool myTask = new TestThreadPool(i);
			 pool.execute(myTask);
             System.out.println("�̳߳����߳���Ŀ��"+pool.getPoolSize()+"�������еȴ�ִ�е�������Ŀ��"+
            		 pool.getQueue().size()+"����ִ������������Ŀ��"+pool.getCompletedTaskCount());
         }
		 pool.shutdown();
	}
	int taskNum;
    public TestThreadPool(int n) {
    	taskNum=n;
    }
	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		return new Thread(r);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		 System.out.println("����ִ��task "+taskNum);
	        try {
	            Thread.currentThread().sleep(4000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        System.out.println("task "+taskNum+"ִ�����");
		
	}
	
}
