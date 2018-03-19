package com.testNio.file;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class testFileChannle {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		Callable<String> call=new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				Thread.sleep(10000);
				
				return "scuess";
			}
			
		};
		FutureTask<String> future=new FutureTask<String>(call);
		Thread th=new Thread(future);
		th.start();
		System.out.println(future.get());
		System.out.println("end");
	}

}
