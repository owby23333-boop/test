package com.yuewen;

import com.duokan.reader.ui.store.data.FeedItem;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class gq3 {
    public static final int d = 0;
    public static final int e = -1;
    public static final int f = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedList<FeedItem> f11640a = new LinkedList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11641b = false;
    public boolean c = false;

    public void a(List<FeedItem> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this) {
            if (!this.f11641b && !this.c) {
                this.f11640a.addAll(list);
                notify();
            }
        }
    }

    public void b(FeedItem... feedItemArr) {
        a(Arrays.asList(feedItemArr));
    }

    public int c() {
        synchronized (this) {
            if (this.f11641b && this.f11640a.isEmpty()) {
                return this.c ? 1 : -1;
            }
            return 0;
        }
    }

    public List<FeedItem> d() {
        while (true) {
            synchronized (this) {
                if (!this.f11640a.isEmpty()) {
                    LinkedList<FeedItem> linkedList = this.f11640a;
                    this.f11640a = new LinkedList<>();
                    return linkedList;
                }
                if (this.f11641b) {
                    return Collections.emptyList();
                }
                try {
                    wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void e(boolean z) {
        synchronized (this) {
            this.f11641b = true;
            this.c = z;
            notifyAll();
        }
    }
}
