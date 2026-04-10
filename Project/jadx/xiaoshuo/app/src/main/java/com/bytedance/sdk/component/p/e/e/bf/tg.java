package com.bytedance.sdk.component.p.e.e.bf;

import com.bytedance.sdk.component.p.e.tg.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public abstract class tg<T extends com.bytedance.sdk.component.p.e.tg.e> {
    private Queue<T> bf = new ConcurrentLinkedQueue();
    private Queue<String> d;
    private com.bytedance.sdk.component.p.e.tg.bf.e e;
    private String tg;

    public tg(com.bytedance.sdk.component.p.e.tg.bf.e eVar, Queue<String> queue, String str) {
        this.e = eVar;
        this.d = queue;
        this.tg = str;
    }

    public synchronized boolean bf(int i, int i2) {
        int size = this.bf.size();
        int iE = this.e.e();
        com.bytedance.sdk.component.p.e.d.d.e(this.tg + " size:" + size + " cacheCount:" + iE + " message:" + i);
        if (i != 2 && i != 1) {
            return size >= iE;
        }
        if (com.bytedance.sdk.component.p.e.d.e.d()) {
            return size >= 1;
        }
        return size >= iE;
    }

    public void e(T t) {
        Queue<T> queue = this.bf;
        if (queue == null || t == null) {
            return;
        }
        queue.offer(t);
    }

    public synchronized List<com.bytedance.sdk.component.p.e.tg.e> e(int i, int i2) {
        if (!bf(i, i2)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.e.e());
        do {
            T tPoll = this.bf.poll();
            if (tPoll == null) {
                break;
            }
            arrayList.add(tPoll);
        } while (arrayList.size() != this.e.bf());
        return arrayList;
    }

    public synchronized void e(int i, List<T> list) {
        if (i != -1 && i != 200 && i != 509) {
            this.bf.addAll(list);
        } else {
            com.bytedance.sdk.component.p.e.d.d.e(this.tg + " memory size：" + this.bf.size());
        }
    }
}
