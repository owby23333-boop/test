package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: GlideExperiments.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    private final Map<Class<?>, b> a;

    /* JADX INFO: compiled from: GlideExperiments.java */
    static final class a {
        private final Map<Class<?>, b> a = new HashMap();

        a() {
        }

        a update(b bVar, boolean z2) {
            if (z2) {
                a(bVar);
            } else {
                this.a.remove(bVar.getClass());
            }
            return this;
        }

        a a(b bVar) {
            this.a.put(bVar.getClass(), bVar);
            return this;
        }

        f a() {
            return new f(this);
        }
    }

    /* JADX INFO: compiled from: GlideExperiments.java */
    interface b {
    }

    f(a aVar) {
        this.a = Collections.unmodifiableMap(new HashMap(aVar.a));
    }

    public boolean a(Class<? extends b> cls) {
        return this.a.containsKey(cls);
    }
}
