package com.yuewen;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
public class u33 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f18332b = "ReadingViewPool";
    public static final int c = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SparseArray<a> f18333a = new SparseArray<>();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LinkedList<b<?>> f18334a = new LinkedList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f18335b = 5;

        public void a(b<?> bVar) {
            bVar.d();
            if (this.f18334a.size() < this.f18335b) {
                this.f18334a.add(bVar);
            }
        }

        public b<?> b() {
            if (this.f18334a.size() > 0) {
                return this.f18334a.remove(0);
            }
            return null;
        }
    }

    public static abstract class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f18336a;

        public b(@NonNull View view) {
            this.f18336a = view;
        }

        public abstract void a(T t, int i);

        public Context b() {
            return this.f18336a.getContext();
        }

        public abstract int c();

        public abstract void d();
    }

    public interface c {
        b<?> onCreate();
    }

    public void a(b<?> bVar) {
        d(bVar.c()).a(bVar);
    }

    public void b(List<b<?>> list) {
        if (list.size() > 0) {
            a aVarD = d(list.get(0).c());
            Iterator<b<?>> it = list.iterator();
            while (it.hasNext()) {
                aVarD.a(it.next());
            }
        }
    }

    public void c() {
        this.f18333a.clear();
    }

    @NotNull
    public final a d(int i) {
        a aVar = this.f18333a.get(i);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        this.f18333a.put(i, aVar2);
        return aVar2;
    }

    public <T extends b<?>> T e(int i) {
        T t = (T) d(i).b();
        if (t == null) {
            return null;
        }
        return t;
    }

    public <T extends b<?>> T f(int i, c cVar) {
        T t = (T) d(i).b();
        return t == null ? (T) cVar.onCreate() : t;
    }

    public void g(int i, int i2) {
        d(i).f18335b = i2;
    }
}
