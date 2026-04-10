package com.zwb.danmaku.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.zwb.danmaku.model.BaseDanmaku;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: BaseScrollerDrawHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements f, g {
    int a;
    int b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f20627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f20628e;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.zwb.danmaku.model.c f20633j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f20626c = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f20629f = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<BaseDanmaku> f20630g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<BaseDanmaku> f20631h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    List<com.zwb.danmaku.model.h> f20632i = new ArrayList();

    private com.zwb.danmaku.model.h e() {
        com.zwb.danmaku.model.h hVarB;
        return (this.f20632i.isEmpty() || (hVarB = b()) == null) ? this.f20632i.size() < this.f20626c ? a(a(this.f20632i.size() - 1)) : a(f()) : hVarB;
    }

    private List<com.zwb.danmaku.model.h> f() {
        if (this.f20632i.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.zwb.danmaku.model.h hVar : this.f20632i) {
            if (hVar.e() < this.f20629f) {
                arrayList.add(hVar);
            }
        }
        return arrayList;
    }

    protected abstract com.zwb.danmaku.model.h a(List<com.zwb.danmaku.model.h> list);

    protected abstract com.zwb.danmaku.model.h a(float[] fArr);

    public synchronized void a(Context context, @NonNull Paint paint, @NonNull Paint paint2, int i2, int i3) {
        com.zwb.danmaku.model.h hVarE;
        this.b = i3;
        this.a = i2;
        if (!this.f20631h.isEmpty()) {
            Iterator<BaseDanmaku> it = this.f20631h.iterator();
            while (it.hasNext() && (hVarE = e()) != null) {
                BaseDanmaku next = it.next();
                it.remove();
                if (!next.C()) {
                    if (this.f20633j != null) {
                        this.f20633j.a(next, false);
                    }
                    next.a(paint);
                }
                a(next, hVarE, i2, i3);
                next.a(context);
                next.a(true);
                next.a(BaseDanmaku.ShowState.STATE_NEVER_SHOWED);
                hVarE.g().add(next);
            }
        }
    }

    protected abstract void a(BaseDanmaku baseDanmaku, com.zwb.danmaku.model.h hVar, int i2, int i3);

    protected abstract com.zwb.danmaku.model.h b();

    public synchronized void b(@NonNull List<BaseDanmaku> list) {
        a();
        this.f20630g.addAll(list);
        this.f20631h.addAll(list);
    }

    public b c(int i2) {
        this.f20629f = i2;
        return this;
    }

    public synchronized void d() {
        this.f20631h.clear();
        this.f20632i.clear();
        for (BaseDanmaku baseDanmaku : this.f20630g) {
            baseDanmaku.a(BaseDanmaku.ShowState.STATE_NEVER_SHOWED);
            baseDanmaku.a(com.zwb.danmaku.model.a.a);
        }
        this.f20631h.addAll(this.f20630g);
    }

    public int c() {
        if (this.f20631h.isEmpty()) {
            int size = 0;
            int size2 = 0;
            for (com.zwb.danmaku.model.h hVar : this.f20632i) {
                size += hVar.c().size();
                size2 += hVar.g().size();
            }
            if (size == 0 && size2 == 0) {
                return 0;
            }
            if (size > 0 && size2 == 0) {
                return 1;
            }
        }
        return 2;
    }

    public b b(float f2) {
        this.f20628e = f2;
        return this;
    }

    public b b(int i2) {
        if (i2 > 0) {
            this.f20626c = i2;
        }
        return this;
    }

    public synchronized void a(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Paint paint2, @NonNull Paint paint3, int i2, int i3) {
        this.b = i3;
        this.a = i2;
        for (com.zwb.danmaku.model.h hVar : this.f20632i) {
            Iterator<BaseDanmaku> it = hVar.g().iterator();
            while (it.hasNext()) {
                it.next().a(canvas, paint, paint2, paint3, i2, i3);
            }
            hVar.a();
        }
    }

    public b a(com.zwb.danmaku.model.c cVar) {
        this.f20633j = cVar;
        return this;
    }

    public b a(float f2) {
        this.f20627d = f2;
        return this;
    }

    public synchronized void a(@NonNull BaseDanmaku baseDanmaku) {
        this.f20630g.add(baseDanmaku);
        this.f20631h.add(baseDanmaku);
    }

    synchronized void a(@NonNull BaseDanmaku baseDanmaku, int i2) {
        try {
            this.f20630g.add(i2, baseDanmaku);
            this.f20631h.add(0, baseDanmaku);
        } catch (Exception unused) {
            a(baseDanmaku);
        }
    }

    public synchronized void a() {
        this.f20630g.clear();
        this.f20631h.clear();
        this.f20632i.clear();
    }

    float[] a(int i2) {
        com.zwb.danmaku.model.h hVar;
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        if (i2 >= 0 && !this.f20632i.isEmpty() && this.f20632i.size() > i2 && (hVar = this.f20632i.get(i2)) != null) {
            a(hVar);
            fArr[0] = hVar.d();
            fArr[1] = hVar.h();
            fArr[2] = hVar.f();
            fArr[3] = hVar.b();
        }
        return fArr;
    }

    void a(com.zwb.danmaku.model.h hVar) {
        if (hVar == null) {
            return;
        }
        List<BaseDanmaku> listG = hVar.g();
        float f2 = 0.0f;
        if (!listG.isEmpty()) {
            float f3 = 0.0f;
            float f4 = 0.0f;
            float f5 = 0.0f;
            for (int i2 = 0; i2 < listG.size(); i2++) {
                BaseDanmaku baseDanmaku = listG.get(i2);
                float fN = baseDanmaku.n();
                float fN2 = baseDanmaku.n() + baseDanmaku.A();
                float fO = baseDanmaku.o();
                float fO2 = baseDanmaku.o() + baseDanmaku.f();
                if (i2 == 0) {
                    f2 = fN;
                    f4 = fN2;
                    f3 = fO;
                } else {
                    if (f2 > fN) {
                        f2 = fN;
                    }
                    if (f4 < fN2) {
                        f4 = fN2;
                    }
                    if (f3 > fO) {
                        f3 = fO;
                    }
                    if (f5 < fO2) {
                    }
                }
                f5 = fO2;
            }
            hVar.a(f2, f3, f4, f5);
            return;
        }
        hVar.a(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public BaseDanmaku a(float f2, float f3) {
        List<com.zwb.danmaku.model.h> list = this.f20632i;
        if (list == null) {
            return null;
        }
        for (com.zwb.danmaku.model.h hVar : list) {
            if (!hVar.g().isEmpty()) {
                for (BaseDanmaku baseDanmaku : hVar.g()) {
                    if (baseDanmaku.s() == BaseDanmaku.ShowState.STATE_SHOWING && f2 >= baseDanmaku.n() && f2 <= baseDanmaku.n() + baseDanmaku.A() && f3 >= baseDanmaku.o() && f3 <= baseDanmaku.o() + baseDanmaku.f()) {
                        return baseDanmaku;
                    }
                }
            }
        }
        return null;
    }
}
