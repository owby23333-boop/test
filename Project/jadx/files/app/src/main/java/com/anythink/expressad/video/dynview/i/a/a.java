package com.anythink.expressad.video.dynview.i.a;

import android.graphics.Bitmap;
import android.view.View;
import com.anythink.expressad.foundation.h.p;
import com.anythink.expressad.video.dynview.c;
import com.anythink.expressad.video.dynview.g.a;
import com.anythink.expressad.video.dynview.i.b;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static volatile a a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bitmap f11640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bitmap f11641d;

    private a() {
    }

    public static a a() {
        a aVar;
        if (a != null) {
            return a;
        }
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public final void b() {
        if (this.b != null) {
            this.b = null;
        }
        Bitmap bitmap = this.f11640c;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f11640c.recycle();
            this.f11640c = null;
        }
        Bitmap bitmap2 = this.f11641d;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        this.f11641d.recycle();
        this.f11641d = null;
    }

    public final void a(Map map, c cVar, View view) {
        Bitmap bitmap;
        List<com.anythink.expressad.foundation.d.c> listG;
        this.b = view;
        int iE = cVar.e();
        float fD = cVar.d();
        float fC = cVar.c();
        if (map != null && map.size() > 1 && (listG = cVar.g()) != null && listG.size() > 1) {
            if (map.get(p.a(listG.get(0).be())) != null && (map.get(p.a(listG.get(0).be())) instanceof Bitmap)) {
                Bitmap bitmap2 = (Bitmap) map.get(p.a(listG.get(0).be()));
                if (listG.get(0) != null && bitmap2 != null && !bitmap2.isRecycled()) {
                    b.a();
                    this.f11640c = b.a(bitmap2, 0);
                }
            }
            if (map.get(p.a(listG.get(1).be())) != null && (map.get(p.a(listG.get(1).be())) instanceof Bitmap)) {
                Bitmap bitmap3 = (Bitmap) map.get(p.a(listG.get(1).be()));
                if (listG.get(1) != null && !bitmap3.isRecycled()) {
                    b.a();
                    this.f11641d = b.a(bitmap3, 1);
                }
            }
        }
        Bitmap bitmap4 = this.f11640c;
        if (bitmap4 == null || bitmap4.isRecycled() || (bitmap = this.f11641d) == null || bitmap.isRecycled()) {
            return;
        }
        a(iE, fD, fC, this.f11640c, this.f11641d);
    }

    private synchronized void a(int i2, float f2, float f3, Bitmap bitmap, Bitmap bitmap2) {
        a.C0223a c0223aA = com.anythink.expressad.video.dynview.g.a.a();
        c0223aA.a(i2).a(bitmap).b(bitmap2);
        if (i2 != 2 || f2 > f3) {
            c0223aA.a(f2).b(f3);
        } else {
            c0223aA.a(f3).b(f2);
        }
        this.b.setBackgroundDrawable(c0223aA.b());
    }
}
