package com.arialyy.aria.core.manager;

import android.text.TextUtils;
import com.arialyy.aria.core.task.IThreadTask;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public class ThreadTaskManager {
    private static final int CORE_POOL_NUM = 20;
    private static volatile ThreadTaskManager INSTANCE;
    private static final ReentrantLock LOCK = new ReentrantLock();
    private final String TAG = CommonUtil.getClassName(this);
    private Map<String, Set<FutureContainer>> mThreadTasks = new ConcurrentHashMap();
    private ThreadPoolExecutor mExePool = new ThreadPoolExecutor(20, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue());

    private class FutureContainer {
        Future future;
        IThreadTask threadTask;

        private FutureContainer() {
        }
    }

    private ThreadTaskManager() {
        this.mExePool.allowsCoreThreadTimeOut();
    }

    public static synchronized ThreadTaskManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ThreadTaskManager();
        }
        return INSTANCE;
    }

    private String getKey(String str) {
        return CommonUtil.getStrMd5(str);
    }

    public void removeAllThreadTask() {
        try {
            if (this.mThreadTasks.isEmpty()) {
                return;
            }
            try {
                LOCK.tryLock(2L, TimeUnit.SECONDS);
                for (Set<FutureContainer> set : this.mThreadTasks.values()) {
                    for (FutureContainer futureContainer : set) {
                        if (!futureContainer.future.isDone() && !futureContainer.future.isCancelled()) {
                            futureContainer.threadTask.destroy();
                        }
                    }
                    set.clear();
                }
                this.mThreadTasks.clear();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        } finally {
            LOCK.unlock();
        }
    }

    public boolean removeSingleTaskThread(String str, String str2) {
        try {
            try {
                LOCK.tryLock(2L, TimeUnit.SECONDS);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.mExePool.isShutdown()) {
                ALog.e(this.TAG, "线程池已经关闭");
            } else {
                if (!TextUtils.isEmpty(str2)) {
                    Set<FutureContainer> set = this.mThreadTasks.get(getKey(str));
                    if (set != null && set.size() > 0) {
                        FutureContainer futureContainer = null;
                        Iterator<FutureContainer> it = set.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            FutureContainer next = it.next();
                            if (next.threadTask.getThreadName().equals(str2)) {
                                futureContainer = next;
                                break;
                            }
                        }
                        if (futureContainer != null) {
                            futureContainer.threadTask.destroy();
                            set.remove(futureContainer);
                            return true;
                        }
                    }
                    return false;
                }
                ALog.e(this.TAG, "线程名为空");
            }
            return false;
        } finally {
            LOCK.unlock();
        }
    }

    public void removeTaskThread(String str) {
        try {
            try {
                LOCK.tryLock(2L, TimeUnit.SECONDS);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.mExePool.isShutdown()) {
                ALog.e(this.TAG, "线程池已经关闭");
                return;
            }
            String key = getKey(str);
            Set<FutureContainer> set = this.mThreadTasks.get(key);
            if (set != null && set.size() > 0) {
                for (FutureContainer futureContainer : set) {
                    if (!futureContainer.future.isDone() && !futureContainer.future.isCancelled()) {
                        futureContainer.threadTask.destroy();
                    }
                }
                set.clear();
                this.mThreadTasks.remove(key);
            }
        } finally {
            LOCK.unlock();
        }
    }

    public void retryThread(IThreadTask iThreadTask) {
        try {
            try {
                LOCK.tryLock(2L, TimeUnit.SECONDS);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.mExePool.isShutdown()) {
                ALog.e(this.TAG, "线程池已经关闭");
            } else {
                if (iThreadTask != null) {
                    try {
                        if (!iThreadTask.isDestroy()) {
                            this.mExePool.submit(iThreadTask);
                            return;
                        }
                    } catch (Exception e3) {
                        ALog.e(this.TAG, "", e3);
                    }
                }
                ALog.e(this.TAG, "线程为空或线程已经中断");
            }
        } finally {
            LOCK.unlock();
        }
    }

    public void startThread(String str, IThreadTask iThreadTask) {
        try {
            try {
                LOCK.tryLock(2L, TimeUnit.SECONDS);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.mExePool.isShutdown()) {
                ALog.e(this.TAG, "线程池已经关闭");
                return;
            }
            String key = getKey(str);
            Set<FutureContainer> hashSet = this.mThreadTasks.get(key);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.mThreadTasks.put(key, hashSet);
            }
            FutureContainer futureContainer = new FutureContainer();
            futureContainer.threadTask = iThreadTask;
            futureContainer.future = this.mExePool.submit(iThreadTask);
            hashSet.add(futureContainer);
        } finally {
            LOCK.unlock();
        }
    }

    public boolean taskIsRunning(String str) {
        return this.mThreadTasks.get(getKey(str)) != null;
    }

    public boolean removeSingleTaskThread(String str, IThreadTask iThreadTask) {
        try {
            try {
                LOCK.tryLock(2L, TimeUnit.SECONDS);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.mExePool.isShutdown()) {
                ALog.e(this.TAG, "线程池已经关闭");
            } else if (iThreadTask == null) {
                ALog.e(this.TAG, "线程任务为空");
            } else {
                Set<FutureContainer> set = this.mThreadTasks.get(getKey(str));
                if (set != null && set.size() > 0) {
                    FutureContainer futureContainer = null;
                    Iterator<FutureContainer> it = set.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        FutureContainer next = it.next();
                        if (next.threadTask == iThreadTask) {
                            futureContainer = next;
                            break;
                        }
                    }
                    if (futureContainer != null) {
                        iThreadTask.destroy();
                        set.remove(futureContainer);
                        return true;
                    }
                }
                return false;
            }
            return false;
        } finally {
            LOCK.unlock();
        }
    }
}
