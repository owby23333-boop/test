package com.xiaomi.ad;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, s> f7294a = new HashMap();

    public <T extends p> s<T> a(String str) {
        s<T> sVar = this.f7294a.get(str);
        if (sVar != null) {
            return sVar;
        }
        s<T> sVar2 = new s<>(str);
        this.f7294a.put(str, sVar2);
        return sVar2;
    }
}
