package com.alipay.sdk.m.c0;

import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Stack<e> f1790a = new Stack<>();

    public void a(e eVar) {
        this.f1790a.push(eVar);
    }

    public boolean b() {
        return this.f1790a.isEmpty();
    }

    public e c() {
        return this.f1790a.pop();
    }

    public void a() {
        if (b()) {
            return;
        }
        Iterator<e> it = this.f1790a.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.f1790a.clear();
    }
}
