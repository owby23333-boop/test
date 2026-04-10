package com.dangdang.zframework.task;

import com.dangdang.zframework.log.LogM;
import com.dangdang.zframework.task.BaseTask;
import com.dangdang.zframework.utils.deque.BlockingDeque;
import com.dangdang.zframework.utils.deque.LinkedBlockingDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes10.dex */
public class TaskManager implements ITaskManager, Runnable {
    private static final int DEFAULT_THREAD_POOL_SIZE = 1;
    protected ThreadPoolExecutor extService;
    private BaseTask mRunningTask;
    private Thread thread;
    protected BlockingDeque<BaseTask<?>> taskQueue = new LinkedBlockingDeque();
    protected BlockingDeque<Future<?>> resultList = new LinkedBlockingDeque();
    protected Map<Future, BaseTask> taskMap = new HashMap();
    private AtomicBoolean running = new AtomicBoolean();

    public class DefaultThreadFactory implements ThreadFactory {
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger poolNumber;
        private final AtomicInteger threadNumber;

        public DefaultThreadFactory() {
            AtomicInteger atomicInteger = new AtomicInteger(1);
            this.poolNumber = atomicInteger;
            this.threadNumber = new AtomicInteger(1);
            SecurityManager securityManager = System.getSecurityManager();
            this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = "pool-" + atomicInteger.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != TaskManager.this.getPriority()) {
                thread.setPriority(TaskManager.this.getPriority());
            }
            return thread;
        }
    }

    @Override // com.dangdang.zframework.task.ITaskManager
    public void clearTask() {
        this.taskQueue.clear();
        this.resultList.clear();
        this.taskMap.clear();
    }

    public int getPriority() {
        return 5;
    }

    public int getTaskSize() {
        return this.taskQueue.size();
    }

    public int getThreadPoolSize() {
        return 1;
    }

    @Override // com.dangdang.zframework.task.ITaskManager
    public boolean isRunning() {
        return this.running.get();
    }

    public boolean isTasking() {
        return this.mRunningTask != null;
    }

    public void onAllTaskFinished(boolean z) {
        LogM.d("task", "onAllTaskFinished");
    }

    public void onPrepareRun() {
    }

    @Override // com.dangdang.zframework.task.ITaskManager
    public synchronized boolean putTask(BaseTask<?> baseTask) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!isRunning()) {
            if (this.taskQueue.contains(baseTask)) {
                return false;
            }
            this.taskQueue.put(baseTask);
            return false;
        }
        baseTask.setStatus(BaseTask.Status.WAITING);
        Future<?> futureSubmit = this.extService.submit(baseTask);
        this.taskMap.put(futureSubmit, baseTask);
        this.resultList.add(futureSubmit);
        return true;
    }

    public synchronized void putTaskAndRun(BaseTask<?> baseTask) {
        putTask(baseTask);
        if (!isRunning()) {
            startTask();
        }
    }

    @Override // com.dangdang.zframework.task.ITaskManager
    public boolean putTaskToFirst(BaseTask<?> baseTask) {
        try {
            if (isRunning()) {
                return false;
            }
            this.taskQueue.putFirst(baseTask);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.dangdang.zframework.task.ITaskManager
    public void removeTask(BaseTask<?> baseTask) {
        this.taskQueue.remove(baseTask);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.extService == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(getThreadPoolSize(), getThreadPoolSize(), 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            this.extService = threadPoolExecutor;
            threadPoolExecutor.setThreadFactory(new DefaultThreadFactory());
        }
        this.running.set(true);
        try {
            try {
                for (BaseTask<?> baseTask : this.taskQueue) {
                    baseTask.setStatus(BaseTask.Status.WAITING);
                    Future<?> futureSubmit = this.extService.submit(baseTask);
                    this.taskMap.put(futureSubmit, baseTask);
                    this.resultList.add(futureSubmit);
                }
                this.taskQueue.clear();
                while (this.running.get()) {
                    Future<?> futureTake = this.resultList.take();
                    BaseTask baseTask2 = this.taskMap.get(futureTake);
                    this.mRunningTask = baseTask2;
                    baseTask2.setStatus(BaseTask.Status.RUNNING);
                    this.mRunningTask.handleResult(futureTake.get());
                    this.mRunningTask.setStatus(BaseTask.Status.FINISHED);
                    this.mRunningTask = null;
                    this.taskMap.remove(futureTake);
                }
                onAllTaskFinished(true);
            } catch (Exception e) {
                e.printStackTrace();
                onAllTaskFinished(false);
            }
        } finally {
            stopTask();
        }
    }

    @Override // com.dangdang.zframework.task.ITaskManager
    public final synchronized void startTask() {
        if (isRunning()) {
            return;
        }
        onPrepareRun();
        Thread thread = new Thread(this);
        this.thread = thread;
        thread.start();
        this.running.set(true);
    }

    @Override // com.dangdang.zframework.task.ITaskManager
    public final void stopTask() {
        this.running.set(false);
        clearTask();
    }

    public final boolean taskIsRunning(BaseTask baseTask) {
        return this.mRunningTask == baseTask;
    }
}
