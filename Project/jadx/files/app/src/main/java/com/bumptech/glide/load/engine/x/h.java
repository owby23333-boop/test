package com.bumptech.glide.load.engine.x;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.x.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GroupedLinkedMap.java */
/* JADX INFO: loaded from: classes2.dex */
class h<K extends m, V> {
    private final a<K, V> a = new a<>();
    private final Map<K, a<K, V>> b = new HashMap();

    /* JADX INFO: compiled from: GroupedLinkedMap.java */
    private static class a<K, V> {
        final K a;
        private List<V> b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        a<K, V> f13612c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        a<K, V> f13613d;

        a() {
            this(null);
        }

        @Nullable
        public V a() {
            int iB = b();
            if (iB > 0) {
                return this.b.remove(iB - 1);
            }
            return null;
        }

        public int b() {
            List<V> list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(K k2) {
            this.f13613d = this;
            this.f13612c = this;
            this.a = k2;
        }

        public void a(V v2) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            this.b.add(v2);
        }
    }

    h() {
    }

    private void b(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.a;
        aVar.f13613d = aVar2.f13613d;
        aVar.f13612c = aVar2;
        d(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f13613d;
        aVar2.f13612c = aVar.f13612c;
        aVar.f13612c.f13613d = aVar2;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.f13612c.f13613d = aVar;
        aVar.f13613d.f13612c = aVar;
    }

    public void a(K k2, V v2) {
        a<K, V> aVar = this.b.get(k2);
        if (aVar == null) {
            aVar = new a<>(k2);
            b(aVar);
            this.b.put(k2, aVar);
        } else {
            k2.a();
        }
        aVar.a(v2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z2 = false;
        for (a aVar = this.a.f13612c; !aVar.equals(this.a); aVar = aVar.f13612c) {
            z2 = true;
            sb.append('{');
            sb.append(aVar.a);
            sb.append(':');
            sb.append(aVar.b());
            sb.append("}, ");
        }
        if (z2) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    @Nullable
    public V a(K k2) {
        a<K, V> aVar = this.b.get(k2);
        if (aVar == null) {
            aVar = new a<>(k2);
            this.b.put(k2, aVar);
        } else {
            k2.a();
        }
        a(aVar);
        return aVar.a();
    }

    @Nullable
    public V a() {
        for (a aVar = this.a.f13613d; !aVar.equals(this.a); aVar = aVar.f13613d) {
            V v2 = (V) aVar.a();
            if (v2 != null) {
                return v2;
            }
            c(aVar);
            this.b.remove(aVar.a);
            ((m) aVar.a).a();
        }
        return null;
    }

    private void a(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.a;
        aVar.f13613d = aVar2;
        aVar.f13612c = aVar2.f13612c;
        d(aVar);
    }
}
