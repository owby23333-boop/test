package anet.channel.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class a extends ThreadPoolExecutor {
    public a(int i2, int i3, long j2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i2, i3, j2, timeUnit, blockingQueue, threadFactory);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t2) {
        return new C0009a(runnable, t2);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C0009a(callable);
    }

    /* JADX INFO: renamed from: anet.channel.thread.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Taobao */
    class C0009a<V> extends FutureTask<V> implements Comparable<C0009a<V>> {
        private Object b;

        public C0009a(Callable<V> callable) {
            super(callable);
            this.b = callable;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(C0009a<V> c0009a) {
            if (this == c0009a) {
                return 0;
            }
            if (c0009a == null) {
                return -1;
            }
            Object obj = this.b;
            if (obj != null && c0009a.b != null && obj.getClass().equals(c0009a.b.getClass())) {
                Object obj2 = this.b;
                if (obj2 instanceof Comparable) {
                    return ((Comparable) obj2).compareTo(c0009a.b);
                }
            }
            return 0;
        }

        public C0009a(Runnable runnable, V v2) {
            super(runnable, v2);
            this.b = runnable;
        }
    }
}
