package com.bytedance.z.g;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private Map<dl, List<z>> z = new HashMap();
    private Map<String, String> g = new HashMap();
    private final List<Object> dl = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Object> f1514a = new CopyOnWriteArrayList();
    private final List<Object> gc = new CopyOnWriteArrayList();
    private final List<Object> m = new CopyOnWriteArrayList();
    private m e = null;

    public List<z> z(dl dlVar) {
        return this.z.get(dlVar);
    }

    void z(Map<? extends String, ? extends String> map) {
        this.g.putAll(map);
    }

    public Map<String, String> z() {
        return this.g;
    }

    public List<Object> g() {
        return this.f1514a;
    }

    public List<Object> dl() {
        return this.m;
    }

    void z(m mVar) {
        this.e = mVar;
    }

    public m a() {
        return this.e;
    }
}
