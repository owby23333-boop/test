package com.yuewen;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes17.dex */
public class fw {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile fw f11336b = null;
    public static final String c = "BUSINESS_CODE_KEY";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, gw> f11337a = new ConcurrentHashMap<>();

    public static fw b() {
        if (f11336b == null) {
            synchronized (fw.class) {
                if (f11336b == null) {
                    f11336b = new fw();
                }
            }
        }
        return f11336b;
    }

    public gw a(String str) {
        if (str == null) {
            return null;
        }
        gw gwVar = this.f11337a.get(str);
        if (gwVar != null) {
            this.f11337a.remove(str);
        }
        return gwVar;
    }

    public String c() {
        return UUID.randomUUID().toString();
    }

    public void d(String str, gw gwVar) {
        this.f11337a.put(str, gwVar);
    }
}
