package com.xm.logsdk.log.logger.lib;

import android.util.Log;
import com.xm.logsdk.log.Logz;
import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/* JADX INFO: loaded from: classes8.dex */
public class ObjectPool<T> {
    private static long sMissNum;
    private ObjectCallback<T> callback;
    private Queue<WeakReference<T>> pool = new ConcurrentLinkedDeque();
    private int poolMaxSize;

    public interface ObjectCallback<T> {
        T initialize();

        void release(T t);

        void reset(T t);
    }

    public ObjectPool(int i, ObjectCallback<T> objectCallback) {
        this.poolMaxSize = 50;
        this.poolMaxSize = i;
        this.callback = objectCallback;
    }

    private void Log(String str) {
        if (Logz.sLogConfig.isEnableDEBUG()) {
            Log.i("LOGZ_POOL_LOG", str);
        }
    }

    public void clear() {
        Queue<WeakReference<T>> queue = this.pool;
        if (queue != null) {
            queue.clear();
        }
    }

    public T obtain() {
        T t;
        WeakReference<T> weakReferencePoll;
        Queue<WeakReference<T>> queue = this.pool;
        if (queue == null || queue.isEmpty() || (weakReferencePoll = this.pool.poll()) == null) {
            t = null;
        } else {
            t = weakReferencePoll.get();
            sMissNum = 0L;
        }
        if (t != null || this.callback == null) {
            return t;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("pool cache data missing sMissNum:");
        long j = sMissNum;
        sMissNum = 1 + j;
        sb.append(j);
        Log(sb.toString());
        return this.callback.initialize();
    }

    public void recycle(T t) {
        Queue<WeakReference<T>> queue = this.pool;
        if (queue == null || queue.size() > this.poolMaxSize) {
            ObjectCallback<T> objectCallback = this.callback;
            if (objectCallback != null) {
                objectCallback.release(t);
                return;
            }
            return;
        }
        this.pool.add(new WeakReference<>(t));
        ObjectCallback<T> objectCallback2 = this.callback;
        if (objectCallback2 != null) {
            objectCallback2.reset(t);
        }
    }
}
