package com.xiaomi.push;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes8.dex */
public class bk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedList<a> f7827a = new LinkedList<>();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final bk f7828a = new bk();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f172a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f173a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f174a;

        public a(int i, Object obj) {
            this.f172a = i;
            this.f173a = obj;
        }
    }

    public static bk a() {
        return a.f7828a;
    }

    public synchronized void a(Object obj) {
        this.f7827a.add(new a(0, obj));
        m230a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m230a() {
        if (this.f7827a.size() > 100) {
            this.f7827a.removeFirst();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized int m231a() {
        return this.f7827a.size();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized LinkedList<a> m232a() {
        LinkedList<a> linkedList;
        linkedList = this.f7827a;
        this.f7827a = new LinkedList<>();
        return linkedList;
    }
}
