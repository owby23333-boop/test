package com.zwb.danmaku.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.zwb.danmaku.model.BaseDanmaku;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: BaseSpecialHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements f, h {
    private List<BaseDanmaku> a = new ArrayList();
    private List<BaseDanmaku> b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<BaseDanmaku> f20634c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<BaseDanmaku> f20635d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f20636e = 1000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f20637f = 10;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f20638g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.zwb.danmaku.model.c f20639h;

    private void d() {
        if (this.f20634c.isEmpty()) {
            return;
        }
        Iterator<BaseDanmaku> it = this.f20634c.iterator();
        while (it.hasNext()) {
            BaseDanmaku next = it.next();
            if (!next.B()) {
                return;
            }
            it.remove();
            next.F();
            this.f20635d.add(next);
        }
    }

    public c a(float f2) {
        return this;
    }

    public synchronized void a(Context context, @NonNull Paint paint, @NonNull Paint paint2, int i2, int i3) {
        if (System.currentTimeMillis() - this.f20638g > this.f20636e && !this.b.isEmpty() && this.f20634c.size() < this.f20637f) {
            BaseDanmaku baseDanmakuRemove = this.b.remove(0);
            if (!baseDanmakuRemove.C()) {
                if (this.f20639h != null) {
                    this.f20639h.a(baseDanmakuRemove, true);
                }
                baseDanmakuRemove.a(paint);
            }
            baseDanmakuRemove.a(context);
            baseDanmakuRemove.a(true);
            this.f20634c.add(baseDanmakuRemove);
            this.f20638g = System.currentTimeMillis();
        }
    }

    public int b() {
        if (this.b.isEmpty() && this.f20634c.isEmpty() && !this.f20635d.isEmpty()) {
            return 1;
        }
        return (this.b.isEmpty() && this.f20634c.isEmpty()) ? 0 : 2;
    }

    public c b(int i2) {
        return this;
    }

    public synchronized void c() {
        this.b.clear();
        this.f20634c.clear();
        this.f20635d.clear();
        for (BaseDanmaku baseDanmaku : this.a) {
            baseDanmaku.a(BaseDanmaku.ShowState.STATE_NEVER_SHOWED);
            baseDanmaku.a(com.zwb.danmaku.model.a.a);
            baseDanmaku.l(0.0f);
        }
        this.b.addAll(this.a);
    }

    public synchronized void a(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Paint paint2, @NonNull Paint paint3, int i2, int i3) {
        Iterator<BaseDanmaku> it = this.f20634c.iterator();
        while (it.hasNext()) {
            it.next().a(canvas, paint, paint2, paint3, i2, i3);
        }
        d();
    }

    public c a(com.zwb.danmaku.model.c cVar) {
        this.f20639h = cVar;
        return this;
    }

    public c a(long j2) {
        this.f20636e = j2;
        return this;
    }

    public c a(int i2) {
        this.f20637f = i2;
        return this;
    }

    public synchronized void a(@NonNull List<BaseDanmaku> list) {
        a();
        this.a.addAll(list);
        this.b.addAll(list);
    }

    public synchronized void a(@NonNull BaseDanmaku baseDanmaku) {
        this.a.add(baseDanmaku);
        this.b.add(baseDanmaku);
    }

    public synchronized void a() {
        this.a.clear();
        this.b.clear();
        this.f20634c.clear();
        this.f20635d.clear();
    }

    public BaseDanmaku a(float f2, float f3) {
        if (this.f20634c.isEmpty()) {
            return null;
        }
        for (BaseDanmaku baseDanmaku : this.f20634c) {
            if (baseDanmaku.s() == BaseDanmaku.ShowState.STATE_SHOWING && f2 >= baseDanmaku.n() && f2 <= baseDanmaku.n() + baseDanmaku.A() && f3 >= baseDanmaku.o() && f3 <= baseDanmaku.o() + baseDanmaku.f()) {
                return baseDanmaku;
            }
        }
        return null;
    }
}
