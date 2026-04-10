package com.zwb.danmaku.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.zwb.danmaku.model.BaseDanmaku;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: DrawHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements f, g, h {
    private j a;
    private i b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private k f20642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f20643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f20644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f20645f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.zwb.danmaku.model.c f20646g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f20647h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f20648i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f20649j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f20650k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f20651l;

    private void d() {
        if (this.f20643d == null) {
            this.f20643d = new a();
        }
        a aVar = this.f20643d;
        aVar.a(this.f20647h);
        aVar.a(this.f20646g);
        aVar.b(this.f20649j);
        aVar.c(this.f20645f);
        aVar.b(this.f20648i);
    }

    private void e() {
        if (this.b == null) {
            this.b = new i();
        }
        i iVar = this.b;
        iVar.a(this.f20647h);
        iVar.a(this.f20646g);
        iVar.b(this.f20649j);
        iVar.c(this.f20645f);
        iVar.b(this.f20648i);
    }

    private void f() {
        if (this.a == null) {
            this.a = new j();
        }
        j jVar = this.a;
        jVar.a(this.f20647h);
        jVar.a(this.f20646g);
        jVar.b(this.f20649j);
        jVar.c(this.f20645f);
        jVar.b(this.f20648i);
    }

    private void g() {
        if (this.f20644e == null) {
            this.f20644e = new c();
        }
        c cVar = this.f20644e;
        cVar.a(this.f20647h);
        cVar.a(this.f20646g);
        cVar.b(this.f20645f);
        cVar.a(this.f20651l);
        cVar.a(this.f20650k);
    }

    private void h() {
        if (this.f20642c == null) {
            this.f20642c = new k();
        }
        k kVar = this.f20642c;
        kVar.a(this.f20647h);
        kVar.a(this.f20646g);
        kVar.b(this.f20649j);
        kVar.c(this.f20645f);
        kVar.b(this.f20648i);
    }

    public void a(Context context, @NonNull Paint paint, @NonNull Paint paint2, int i2, int i3) {
        j jVar = this.a;
        if (jVar != null) {
            jVar.a(context, paint, paint2, i2, i3);
        }
        i iVar = this.b;
        if (iVar != null) {
            iVar.a(context, paint, paint2, i2, i3);
        }
        k kVar = this.f20642c;
        if (kVar != null) {
            kVar.a(context, paint, paint2, i2, i3);
        }
        a aVar = this.f20643d;
        if (aVar != null) {
            aVar.a(context, paint, paint2, i2, i3);
        }
        c cVar = this.f20644e;
        if (cVar != null) {
            cVar.a(context, paint, paint2, i2, i3);
        }
    }

    public e b(float f2) {
        this.f20648i = f2;
        j jVar = this.a;
        if (jVar != null) {
            jVar.b(f2);
        }
        i iVar = this.b;
        if (iVar != null) {
            iVar.b(f2);
        }
        k kVar = this.f20642c;
        if (kVar != null) {
            kVar.b(f2);
        }
        a aVar = this.f20643d;
        if (aVar != null) {
            aVar.b(f2);
        }
        return this;
    }

    public void c() {
        j jVar = this.a;
        if (jVar != null) {
            jVar.d();
        }
        i iVar = this.b;
        if (iVar != null) {
            iVar.d();
        }
        k kVar = this.f20642c;
        if (kVar != null) {
            kVar.d();
        }
        a aVar = this.f20643d;
        if (aVar != null) {
            aVar.d();
        }
        c cVar = this.f20644e;
        if (cVar != null) {
            cVar.c();
        }
    }

    public e b(int i2) {
        this.f20649j = i2;
        j jVar = this.a;
        if (jVar != null) {
            jVar.b(i2);
        }
        i iVar = this.b;
        if (iVar != null) {
            iVar.b(i2);
        }
        k kVar = this.f20642c;
        if (kVar != null) {
            kVar.b(i2);
        }
        a aVar = this.f20643d;
        if (aVar != null) {
            aVar.b(i2);
        }
        return this;
    }

    public void a(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Paint paint2, @NonNull Paint paint3, int i2, int i3) {
        j jVar = this.a;
        if (jVar != null) {
            jVar.a(canvas, paint, paint2, paint3, i2, i3);
        }
        i iVar = this.b;
        if (iVar != null) {
            iVar.a(canvas, paint, paint2, paint3, i2, i3);
        }
        k kVar = this.f20642c;
        if (kVar != null) {
            kVar.a(canvas, paint, paint2, paint3, i2, i3);
        }
        a aVar = this.f20643d;
        if (aVar != null) {
            aVar.a(canvas, paint, paint2, paint3, i2, i3);
        }
        c cVar = this.f20644e;
        if (cVar != null) {
            cVar.a(canvas, paint, paint2, paint3, i2, i3);
        }
    }

    public int b() {
        int i2;
        int i3;
        int iB;
        int iC;
        int iC2;
        int iC3;
        int iC4;
        j jVar = this.a;
        if (jVar == null || (iC4 = jVar.c()) == 0) {
            i2 = 0;
            i3 = 0;
        } else {
            i3 = iC4 + 0;
            i2 = 1;
        }
        i iVar = this.b;
        if (iVar != null && (iC3 = iVar.c()) != 0) {
            i2++;
            i3 += iC3;
        }
        k kVar = this.f20642c;
        if (kVar != null && (iC2 = kVar.c()) != 0) {
            i2++;
            i3 += iC2;
        }
        a aVar = this.f20643d;
        if (aVar != null && (iC = aVar.c()) != 0) {
            i2++;
            i3 += iC;
        }
        c cVar = this.f20644e;
        if (cVar != null && (iB = cVar.b()) != 0) {
            i2++;
            i3 += iB;
        }
        if (i3 == 0) {
            return 0;
        }
        return i3 == i2 ? 1 : 2;
    }

    public BaseDanmaku a(float f2, float f3) {
        c cVar = this.f20644e;
        if (cVar != null && cVar.a(f2, f3) != null) {
            return this.f20644e.a(f2, f3);
        }
        a aVar = this.f20643d;
        if (aVar != null && aVar.a(f2, f3) != null) {
            return this.f20643d.a(f2, f3);
        }
        k kVar = this.f20642c;
        if (kVar != null && kVar.a(f2, f3) != null) {
            return this.f20642c.a(f2, f3);
        }
        i iVar = this.b;
        if (iVar != null && iVar.a(f2, f3) != null) {
            return this.b.a(f2, f3);
        }
        j jVar = this.a;
        if (jVar == null || jVar.a(f2, f3) == null) {
            return null;
        }
        return this.a.a(f2, f3);
    }

    public e a(com.zwb.danmaku.model.c cVar) {
        this.f20646g = cVar;
        j jVar = this.a;
        if (jVar != null) {
            jVar.a(cVar);
        }
        i iVar = this.b;
        if (iVar != null) {
            iVar.a(cVar);
        }
        k kVar = this.f20642c;
        if (kVar != null) {
            kVar.a(cVar);
        }
        a aVar = this.f20643d;
        if (aVar != null) {
            aVar.a(cVar);
        }
        c cVar2 = this.f20644e;
        if (cVar2 != null) {
            cVar2.a(cVar);
        }
        return this;
    }

    public e a(float f2) {
        this.f20647h = f2;
        j jVar = this.a;
        if (jVar != null) {
            jVar.a(f2);
        }
        i iVar = this.b;
        if (iVar != null) {
            iVar.a(f2);
        }
        k kVar = this.f20642c;
        if (kVar != null) {
            kVar.a(f2);
        }
        a aVar = this.f20643d;
        if (aVar != null) {
            aVar.a(f2);
        }
        c cVar = this.f20644e;
        if (cVar != null) {
            cVar.a(f2);
        }
        return this;
    }

    public void a(@NonNull List<BaseDanmaku> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (BaseDanmaku baseDanmaku : list) {
            if (baseDanmaku.getType() == BaseDanmaku.DanmakuType.TYPE_SCROLL_RL) {
                arrayList.add(baseDanmaku);
            } else if (baseDanmaku.getType() == BaseDanmaku.DanmakuType.TYPE_SCROLL_LR) {
                arrayList2.add(baseDanmaku);
            } else if (baseDanmaku.getType() == BaseDanmaku.DanmakuType.TYPE_SCROLL_TB) {
                arrayList3.add(baseDanmaku);
            } else if (baseDanmaku.getType() == BaseDanmaku.DanmakuType.TYPE_SCROLL_BT) {
                arrayList4.add(baseDanmaku);
            } else if (baseDanmaku.getType() == BaseDanmaku.DanmakuType.TYPE_SPECIAL) {
                arrayList5.add(baseDanmaku);
            }
        }
        if (!arrayList.isEmpty()) {
            f();
            this.a.b(arrayList);
        }
        if (!arrayList2.isEmpty()) {
            e();
            this.b.b(arrayList2);
        }
        if (!arrayList3.isEmpty()) {
            h();
            this.f20642c.b(arrayList3);
        }
        if (!arrayList4.isEmpty()) {
            d();
            this.f20643d.b(arrayList4);
        }
        if (arrayList5.isEmpty()) {
            return;
        }
        g();
        this.f20644e.a(arrayList5);
    }

    public void a(@NonNull BaseDanmaku baseDanmaku, int i2) {
        if (baseDanmaku.getType() == BaseDanmaku.DanmakuType.TYPE_SCROLL_RL) {
            f();
            this.a.a(baseDanmaku, i2);
            return;
        }
        if (baseDanmaku.getType() == BaseDanmaku.DanmakuType.TYPE_SCROLL_LR) {
            e();
            this.b.a(baseDanmaku);
            return;
        }
        if (baseDanmaku.getType() == BaseDanmaku.DanmakuType.TYPE_SCROLL_TB) {
            h();
            this.f20642c.a(baseDanmaku);
        } else if (baseDanmaku.getType() == BaseDanmaku.DanmakuType.TYPE_SCROLL_BT) {
            d();
            this.f20643d.a(baseDanmaku);
        } else if (baseDanmaku.getType() == BaseDanmaku.DanmakuType.TYPE_SPECIAL) {
            g();
            this.f20644e.a(baseDanmaku);
        }
    }

    public e a(long j2) {
        this.f20650k = j2;
        c cVar = this.f20644e;
        if (cVar != null) {
            cVar.a(j2);
        }
        return this;
    }

    public e a(int i2) {
        this.f20651l = i2;
        c cVar = this.f20644e;
        if (cVar != null) {
            cVar.a(i2);
        }
        return this;
    }

    public void a() {
        j jVar = this.a;
        if (jVar != null) {
            jVar.a();
        }
        i iVar = this.b;
        if (iVar != null) {
            iVar.a();
        }
        k kVar = this.f20642c;
        if (kVar != null) {
            kVar.a();
        }
        a aVar = this.f20643d;
        if (aVar != null) {
            aVar.a();
        }
        c cVar = this.f20644e;
        if (cVar != null) {
            cVar.a();
        }
    }
}
