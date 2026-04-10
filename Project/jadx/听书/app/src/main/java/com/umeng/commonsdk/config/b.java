package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: CollectController.java */
/* JADX INFO: loaded from: classes4.dex */
public class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Boolean> f2290a = new HashMap();
    private static Object b = new Object();

    private b() {
    }

    public void a() {
        synchronized (b) {
            f2290a.clear();
        }
    }

    /* JADX INFO: compiled from: CollectController.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f2291a = new b();

        private a() {
        }
    }

    public static b b() {
        return a.f2291a;
    }

    public static boolean a(String str) {
        if (!d.a(str)) {
            return false;
        }
        synchronized (b) {
            if (!f2290a.containsKey(str)) {
                return true;
            }
            return f2290a.get(str).booleanValue();
        }
    }

    @Override // com.umeng.commonsdk.config.f
    public void a(String str, Boolean bool) {
        if (d.a(str)) {
            synchronized (b) {
                Map<String, Boolean> map = f2290a;
                if (map != null) {
                    map.put(str, bool);
                }
            }
        }
    }
}
