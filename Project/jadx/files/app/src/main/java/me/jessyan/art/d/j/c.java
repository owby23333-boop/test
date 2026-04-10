package me.jessyan.art.d.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import me.jessyan.art.f.g;

/* JADX INFO: compiled from: IntelligentCache.java */
/* JADX INFO: loaded from: classes.dex */
public class c<V> implements a<String, V> {
    private final Map<String, V> a = new HashMap();
    private final a<String, V> b;

    public c(int i2) {
        this.b = new d(i2);
    }

    @NonNull
    public static String d(@NonNull String str) {
        g.a(str, "key == null");
        return "Keep=" + str;
    }

    @Override // me.jessyan.art.d.j.a
    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized V put(String str, V v2) {
        if (str.startsWith("Keep=")) {
            return this.a.put(str, v2);
        }
        return this.b.put(str, v2);
    }

    @Override // me.jessyan.art.d.j.a
    @Nullable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized V get(String str) {
        if (str.startsWith("Keep=")) {
            return this.a.get(str);
        }
        return this.b.get(str);
    }

    @Override // me.jessyan.art.d.j.a
    @Nullable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public synchronized V remove(String str) {
        if (str.startsWith("Keep=")) {
            return this.a.remove(str);
        }
        return this.b.remove(str);
    }

    @Override // me.jessyan.art.d.j.a
    public void clear() {
        this.b.clear();
        this.a.clear();
    }

    @Override // me.jessyan.art.d.j.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized boolean containsKey(String str) {
        if (str.startsWith("Keep=")) {
            return this.a.containsKey(str);
        }
        return this.b.containsKey(str);
    }
}
