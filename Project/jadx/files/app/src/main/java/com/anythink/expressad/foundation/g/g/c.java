package com.anythink.expressad.foundation.g.g;

import android.annotation.SuppressLint;
import android.content.Context;
import com.anythink.expressad.foundation.g.g.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    ThreadPoolExecutor a;
    HashMap<Long, a> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    WeakReference<Context> f10613c;

    @SuppressLint({"UseSparseArrays"})
    public c(Context context, int i2) {
        if (i2 == 0) {
            this.a = new ThreadPoolExecutor(1, 5, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        } else {
            this.a = new ThreadPoolExecutor(i2, (i2 * 2) + 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        }
        this.a.allowCoreThreadTimeOut(true);
        this.b = new HashMap<>();
        this.f10613c = new WeakReference<>(context);
    }

    private synchronized void b(a aVar) {
        if (aVar != null) {
            if (this.b.containsKey(Long.valueOf(a.e()))) {
                a aVar2 = this.b.get(Long.valueOf(a.e()));
                if (aVar2 != null) {
                    aVar2.f();
                }
                this.b.remove(Long.valueOf(a.e()));
            }
        }
    }

    public final synchronized void a() {
        try {
            Iterator<Map.Entry<Long, a>> it = this.b.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().f();
            }
            this.b.clear();
        } catch (Exception unused) {
        }
    }

    private synchronized void b(final a aVar, final a.b bVar) {
        this.b.put(Long.valueOf(a.e()), aVar);
        aVar.f10606d = new a.b() { // from class: com.anythink.expressad.foundation.g.g.c.1
            @Override // com.anythink.expressad.foundation.g.g.a.b
            public final void a(a.EnumC0209a enumC0209a) {
                if (enumC0209a == a.EnumC0209a.CANCEL || enumC0209a == a.EnumC0209a.FINISH) {
                    c.this.b.remove(Long.valueOf(a.e()));
                } else if (enumC0209a == a.EnumC0209a.RUNNING && c.this.f10613c.get() == null) {
                    c.this.a();
                }
                a.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(enumC0209a);
                }
            }
        };
    }

    @SuppressLint({"UseSparseArrays"})
    public c(Context context) {
        this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        this.a.allowCoreThreadTimeOut(true);
        this.b = new HashMap<>();
        this.f10613c = new WeakReference<>(context);
    }

    public final void a(a aVar) {
        b(aVar, null);
        this.a.execute(aVar);
    }

    public final void a(a aVar, a.b bVar) {
        b(aVar, bVar);
        this.a.execute(aVar);
    }

    private void b() {
        Iterator<Map.Entry<Long, a>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            a value = it.next().getValue();
            a.EnumC0209a enumC0209a = value.f10605c;
            if (enumC0209a == a.EnumC0209a.PAUSE) {
                value.g();
            } else if (enumC0209a == a.EnumC0209a.READY) {
                this.a.execute(value);
            }
        }
    }

    @SuppressLint({"UseSparseArrays"})
    private c(Context context, byte b) {
        int iAvailableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        this.a = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        this.a.allowCoreThreadTimeOut(true);
        this.b = new HashMap<>();
        this.f10613c = new WeakReference<>(context);
    }
}
