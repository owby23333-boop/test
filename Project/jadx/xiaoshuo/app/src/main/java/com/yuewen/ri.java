package com.yuewen;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public class ri implements xl3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kv3<ri> f17049b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<a> f17050a = new LinkedList<>();

    public interface a {
        void K5(int i);
    }

    public static ri c() {
        kv3<ri> kv3Var = f17049b;
        if (kv3Var != null) {
            return kv3Var.get();
        }
        return null;
    }

    public static void e(kv3<ri> kv3Var) {
        f17049b = kv3Var;
    }

    public void b(a aVar) {
        this.f17050a.add(aVar);
    }

    public void d(a aVar) {
        this.f17050a.remove(aVar);
    }
}
