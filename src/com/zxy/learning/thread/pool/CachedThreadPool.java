package com.zxy.learning.thread.pool;

import java.util.concurrent.*;

public class CachedThreadPool {
	public static void main(String[] args){
		ThreadFactory threadFactory = new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				return null;
			}
		};
		ExecutorService pool = new ThreadPoolExecutor(1, Integer.MAX_VALUE,
				60L, TimeUnit.SECONDS,
				new SynchronousQueue<>());

		ExecutorService threadPool = Executors.newCachedThreadPool();
		//创建实现了Runnable 接口对象
		Thread t1 = new MyThread();
		t1.setName("t1");
		Thread t2 = new MyThread();
		t2.setName("t2");
		Thread t3 = new MyThread();
		t3.setName("t3");
		Thread t4 = new MyThread();
		t4.setName("t4");
		Thread t5 = new MyThread();
		t5.setName("t5");
		Thread t6 = new MyThread();
		t6.setName("t6");
		//线程放入线程池中
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		pool.execute(t6);
		pool.shutdown();
	}
}
