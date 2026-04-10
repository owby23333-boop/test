package com.yuewen;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class nx2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<? extends mx2>, mx2> f15104a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class f15105b;

    public nx2(List<mx2> list, Class cls) {
        for (mx2 mx2Var : list) {
            this.f15104a.put((Class<? extends mx2>) mx2Var.getClass(), mx2Var);
        }
        e(cls);
    }

    public mx2 a() {
        return this.f15104a.get(this.f15105b);
    }

    public <T extends mx2> T b(Class<T> cls) {
        return (T) this.f15104a.get(cls);
    }

    public <T extends mx2> boolean c(Class<T> cls) {
        return this.f15105b.equals(cls);
    }

    public void d(int i) {
        Iterator<mx2> it = this.f15104a.values().iterator();
        while (it.hasNext()) {
            it.next().a(i);
        }
    }

    public <T extends mx2> void e(Class<T> cls) {
        if (!this.f15104a.containsKey(cls)) {
            throw new AssertionError();
        }
        this.f15105b = cls;
        for (mx2 mx2Var : this.f15104a.values()) {
            mx2Var.setVisible(c(mx2Var.getClass()));
        }
    }
}
