package com.duokan.common;

import com.duokan.core.diagnostic.LogLevel;
import com.yuewen.ia0;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes12.dex */
public abstract class CacheVars<T> extends LinkedList<T> {
    private static final String TAG = "CacheVars";
    private final a<T> mCreator;
    private final int mMaxSize;

    public interface a<T> {
        T a();
    }

    public CacheVars(a<T> aVar, int i) {
        this.mCreator = aVar;
        this.mMaxSize = i;
    }

    public T acquire() {
        while (this.mMaxSize > 0 && size() >= this.mMaxSize) {
            ia0.w().f(LogLevel.INFO, TAG, "acquire remove head:" + size());
            onRemoveOut(poll());
        }
        T tA = this.mCreator.a();
        add(tA);
        return tA;
    }

    public abstract void onRemoveOut(T t);

    public void trimToLast(int i) {
        ia0.w().f(LogLevel.INFO, TAG, "trimToLast:" + size());
        while (size() > i) {
            onRemoveOut(poll());
        }
    }
}
