package me.drakeet.multitype;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: MultiTypePool.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements g {

    @NonNull
    private final List<Class<?>> a = new ArrayList();

    @NonNull
    private final List<b<?, ?>> b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final List<c<?>> f21074c = new ArrayList();

    @Override // me.drakeet.multitype.g
    public <T> void a(@NonNull Class<? extends T> cls, @NonNull b<T, ?> bVar, @NonNull c<T> cVar) {
        f.a(cls);
        f.a(bVar);
        f.a(cVar);
        this.a.add(cls);
        this.b.add(bVar);
        this.f21074c.add(cVar);
    }

    @Override // me.drakeet.multitype.g
    public boolean b(@NonNull Class<?> cls) {
        f.a(cls);
        boolean z2 = false;
        while (true) {
            int iIndexOf = this.a.indexOf(cls);
            if (iIndexOf == -1) {
                return z2;
            }
            this.a.remove(iIndexOf);
            this.b.remove(iIndexOf);
            this.f21074c.remove(iIndexOf);
            z2 = true;
        }
    }

    @Override // me.drakeet.multitype.g
    @NonNull
    public c<?> b(int i2) {
        return this.f21074c.get(i2);
    }

    @Override // me.drakeet.multitype.g
    public int a(@NonNull Class<?> cls) {
        f.a(cls);
        int iIndexOf = this.a.indexOf(cls);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            if (this.a.get(i2).isAssignableFrom(cls)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // me.drakeet.multitype.g
    @NonNull
    public b<?, ?> a(int i2) {
        return this.b.get(i2);
    }
}
