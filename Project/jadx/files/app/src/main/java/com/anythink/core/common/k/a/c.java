package com.anythink.core.common.k.a;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.anythink.core.common.k.a.f;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    private final f a;
    private final Map<View, b> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<View, d<b>> f7638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f.b f7639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private f.d f7640e;

    public c() {
        WeakHashMap weakHashMap = new WeakHashMap();
        WeakHashMap weakHashMap2 = new WeakHashMap();
        f.b bVar = new f.b();
        f fVar = new f();
        new Handler(Looper.getMainLooper());
        this(weakHashMap, weakHashMap2, bVar, fVar);
    }

    @Deprecated
    private f.d c() {
        return this.f7640e;
    }

    public final void b() {
        a();
        this.a.b();
        this.f7640e = null;
    }

    public final void a(View view, b bVar) {
        if (this.b.get(view) == bVar) {
            return;
        }
        a(view);
        if (bVar.isImpressionRecorded()) {
            return;
        }
        this.b.put(view, bVar);
        f fVar = this.a;
        int impressionMinPercentageViewed = bVar.getImpressionMinPercentageViewed();
        fVar.a(view, view, impressionMinPercentageViewed, impressionMinPercentageViewed, bVar.getImpressionMinVisiblePx());
    }

    public c(int i2) {
        WeakHashMap weakHashMap = new WeakHashMap();
        WeakHashMap weakHashMap2 = new WeakHashMap();
        f.b bVar = new f.b();
        f fVar = new f(i2);
        new Handler(Looper.getMainLooper());
        this(weakHashMap, weakHashMap2, bVar, fVar);
    }

    private void b(View view) {
        this.f7638c.remove(view);
    }

    private c(Map<View, b> map, Map<View, d<b>> map2, f.b bVar, f fVar) {
        this.b = map;
        this.f7638c = map2;
        this.f7639d = bVar;
        this.a = fVar;
        this.f7640e = new f.d() { // from class: com.anythink.core.common.k.a.c.1
            @Override // com.anythink.core.common.k.a.f.d
            public final void a(List<View> list) {
                for (View view : list) {
                    b bVar2 = (b) c.this.b.get(view);
                    if (bVar2 == null) {
                        c.this.a(view);
                    } else {
                        bVar2.recordImpression(view);
                        bVar2.setImpressionRecorded();
                    }
                }
            }
        };
        this.a.a(this.f7640e);
    }

    public final void a(View view) {
        this.b.remove(view);
        b(view);
        this.a.a(view);
    }

    public final void a() {
        this.b.clear();
        this.f7638c.clear();
        this.a.a();
    }
}
