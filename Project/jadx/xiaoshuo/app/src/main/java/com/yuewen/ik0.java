package com.yuewen;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ik0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Class, Object> f12507a = new HashMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ik0 f12508a = new ik0();
    }

    public static ik0 a() {
        return a.f12508a;
    }

    public <T> T b(Class<T> cls) {
        T t = (T) this.f12507a.get(cls);
        if (t != null && cls != null && cls.isInstance(t)) {
            return t;
        }
        throw new RuntimeException("Search interface, not registered or type not match, interface=" + cls + ", impl=" + t);
    }

    public <T> void c(Class<T> cls, Object obj) {
        if (cls == null || obj == null || !cls.isInstance(obj)) {
            throw new RuntimeException("register interface class not match");
        }
        this.f12507a.put(cls, obj);
    }

    public void d(Class cls) {
        if (cls != null) {
            this.f12507a.remove(cls);
        }
    }
}
