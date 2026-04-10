package com.efs.sdk.base.core.b;

import com.efs.sdk.base.core.util.Log;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Byte, e> f1532a = new ConcurrentHashMap<>();

    public final e a(byte b) {
        if (!this.f1532a.containsKey(Byte.valueOf(b))) {
            if (b == 1) {
                this.f1532a.putIfAbsent(Byte.valueOf(b), new g());
            } else if (b == 2) {
                this.f1532a.putIfAbsent(Byte.valueOf(b), new d());
            } else {
                Log.w("efs.cache", "Cache module not support protocol ".concat(String.valueOf((int) b)));
            }
        }
        return this.f1532a.get(Byte.valueOf(b));
    }
}
