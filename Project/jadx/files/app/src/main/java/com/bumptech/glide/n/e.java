package com.bumptech.glide.n;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ResourceDecoderRegistry.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    private final List<String> a = new ArrayList();
    private final Map<String, List<a<?, ?>>> b = new HashMap();

    /* JADX INFO: compiled from: ResourceDecoderRegistry.java */
    private static class a<T, R> {
        private final Class<T> a;
        final Class<R> b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final g<T, R> f13805c;

        public a(@NonNull Class<T> cls, @NonNull Class<R> cls2, g<T, R> gVar) {
            this.a = cls;
            this.b = cls2;
            this.f13805c = gVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.b);
        }
    }

    public synchronized void a(@NonNull List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.a);
        this.a.clear();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.a.add(it.next());
        }
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.a.add(str);
            }
        }
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> b(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.b)) {
                        arrayList.add(aVar.b);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <T, R> List<g<T, R>> a(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f13805c);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void a(@NonNull String str, @NonNull g<T, R> gVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        a(str).add(new a<>(cls, cls2, gVar));
    }

    @NonNull
    private synchronized List<a<?, ?>> a(@NonNull String str) {
        List<a<?, ?>> arrayList;
        if (!this.a.contains(str)) {
            this.a.add(str);
        }
        arrayList = this.b.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.b.put(str, arrayList);
        }
        return arrayList;
    }
}
