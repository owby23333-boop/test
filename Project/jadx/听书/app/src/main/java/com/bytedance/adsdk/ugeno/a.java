package com.bytedance.adsdk.ugeno;

import android.content.Context;
import com.bytedance.adsdk.ugeno.gc.gc;
import com.bytedance.adsdk.ugeno.gc.gz;
import com.bytedance.adsdk.ugeno.gc.uy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static volatile a z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z f219a;
    private com.bytedance.adsdk.ugeno.dl.dl dl;
    private com.bytedance.adsdk.ugeno.dl.z.z e;
    private List<com.bytedance.adsdk.ugeno.dl.g> g;
    private com.bytedance.adsdk.ugeno.a.z gc;
    private com.bytedance.adsdk.ugeno.dl.g.a m;

    public static a z() {
        if (z == null) {
            synchronized (a.class) {
                if (z == null) {
                    z = new a();
                }
            }
        }
        return z;
    }

    private a() {
    }

    public void z(Context context, com.bytedance.adsdk.ugeno.dl.dl dlVar, z zVar) {
        this.dl = dlVar;
        this.f219a = zVar;
        m();
    }

    public z g() {
        return this.f219a;
    }

    private void m() {
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        com.bytedance.adsdk.ugeno.dl.dl dlVar = this.dl;
        if (dlVar != null) {
            arrayList.addAll(dlVar.z());
        }
        com.bytedance.adsdk.ugeno.dl.a.z(this.g);
    }

    public void z(com.bytedance.adsdk.ugeno.a.z zVar) {
        this.gc = zVar;
    }

    public com.bytedance.adsdk.ugeno.a.z dl() {
        return this.gc;
    }

    public void z(gz gzVar) {
        ArrayList arrayList = new ArrayList(new com.bytedance.adsdk.ugeno.gc.z().z());
        if (gzVar != null) {
            arrayList.addAll(gzVar.z());
        }
        uy.z(arrayList);
    }

    public void z(com.bytedance.adsdk.ugeno.gc.dl dlVar) {
        ArrayList arrayList = new ArrayList(new gc().z());
        if (dlVar != null) {
            arrayList.addAll(dlVar.z());
        }
        com.bytedance.adsdk.ugeno.gc.a.z(arrayList);
    }

    public void z(com.bytedance.adsdk.ugeno.dl.g.a aVar) {
        this.m = aVar;
    }

    public com.bytedance.adsdk.ugeno.dl.g.a a() {
        return this.m;
    }

    public void z(com.bytedance.adsdk.ugeno.dl.z.z zVar) {
        this.e = zVar;
    }

    public com.bytedance.adsdk.ugeno.dl.z.z gc() {
        return this.e;
    }
}
