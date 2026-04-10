package com.bytedance.sdk.component.m.dl;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.component.m.fv;
import com.bytedance.sdk.component.m.hh;
import com.bytedance.sdk.component.m.js;
import com.bytedance.sdk.component.m.l;
import com.bytedance.sdk.component.m.sy;
import com.bytedance.sdk.component.m.x;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private fv e;
    private sy fo;
    private final js g;
    private ExecutorService gz;
    private com.bytedance.sdk.component.m.gc m;
    private Map<String, List<dl>> z = new ConcurrentHashMap();
    private Map<String, hh> dl = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, l> f768a = new HashMap();
    private Map<String, com.bytedance.sdk.component.m.a> gc = new HashMap();

    public m(Context context, js jsVar) {
        this.g = (js) gz.z(jsVar);
        com.bytedance.sdk.component.m.dl.z.z.z(context, jsVar.fo());
    }

    public Collection<hh> z() {
        return this.dl.values();
    }

    public Collection<l> g() {
        return this.f768a.values();
    }

    public Collection<com.bytedance.sdk.component.m.a> dl() {
        return this.gc.values();
    }

    public hh z(com.bytedance.sdk.component.m.g gVar) {
        if (gVar == null) {
            gVar = com.bytedance.sdk.component.m.dl.z.z.z();
        }
        String string = gVar.getCacheDir().toString();
        hh hhVar = this.dl.get(string);
        if (hhVar != null) {
            return hhVar;
        }
        hh hhVarA = a(gVar);
        this.dl.put(string, hhVarA);
        return hhVarA;
    }

    private hh a(com.bytedance.sdk.component.m.g gVar) {
        hh hhVarGc = this.g.gc();
        if (hhVarGc != null) {
            return com.bytedance.sdk.component.m.dl.z.g.z.z(hhVarGc);
        }
        return com.bytedance.sdk.component.m.dl.z.g.z.z(gVar.getMemoryCacheSize());
    }

    public l g(com.bytedance.sdk.component.m.g gVar) {
        if (gVar == null) {
            gVar = com.bytedance.sdk.component.m.dl.z.z.z();
        }
        String string = gVar.getCacheDir().toString();
        l lVar = this.f768a.get(string);
        if (lVar != null) {
            return lVar;
        }
        l lVarGc = gc(gVar);
        this.f768a.put(string, lVarGc);
        return lVarGc;
    }

    private l gc(com.bytedance.sdk.component.m.g gVar) {
        l lVarM = this.g.m();
        return lVarM != null ? lVarM : com.bytedance.sdk.component.m.dl.z.g.gc.z(gVar.getRawMemoryCacheSize());
    }

    public com.bytedance.sdk.component.m.a dl(com.bytedance.sdk.component.m.g gVar) {
        if (gVar == null) {
            gVar = com.bytedance.sdk.component.m.dl.z.z.z();
        }
        String string = gVar.getCacheDir().toString();
        com.bytedance.sdk.component.m.a aVar = this.gc.get(string);
        if (aVar != null) {
            return aVar;
        }
        com.bytedance.sdk.component.m.a aVarM = m(gVar);
        this.gc.put(string, aVarM);
        return aVarM;
    }

    public com.bytedance.sdk.component.m.a z(String str) {
        return dl(com.bytedance.sdk.component.m.dl.z.z.z(new File(str)));
    }

    private com.bytedance.sdk.component.m.a m(com.bytedance.sdk.component.m.g gVar) {
        com.bytedance.sdk.component.m.a aVarE = this.g.e();
        return aVarE != null ? aVarE : new com.bytedance.sdk.component.m.dl.z.z.g(gVar.getCacheDir(), gVar.getFileCacheSize(), m());
    }

    public com.bytedance.sdk.component.m.gc a() {
        if (this.m == null) {
            this.m = fo();
        }
        return this.m;
    }

    private com.bytedance.sdk.component.m.gc fo() {
        com.bytedance.sdk.component.m.gc gcVarA = this.g.a();
        return gcVarA == null ? com.bytedance.sdk.component.m.g.g.z() : gcVarA;
    }

    public fv gc() {
        if (this.e == null) {
            this.e = uy();
        }
        return this.e;
    }

    private fv uy() {
        fv fvVarZ = this.g.z();
        return fvVarZ != null ? fvVarZ : com.bytedance.sdk.component.m.z.g.z();
    }

    public ExecutorService m() {
        ExecutorService executorServiceZ;
        x xVarDl = this.g.dl();
        if (xVarDl != null && (executorServiceZ = xVarDl.z()) != null) {
            return executorServiceZ;
        }
        if (this.gz == null) {
            this.gz = kb();
        }
        return this.gz;
    }

    private ExecutorService kb() {
        ExecutorService executorServiceG = this.g.g();
        return executorServiceG != null ? executorServiceG : com.bytedance.sdk.component.m.z.dl.z();
    }

    public Map<String, List<dl>> e() {
        return this.z;
    }

    public com.bytedance.sdk.component.m.dl.g.z z(dl dlVar) {
        ImageView.ScaleType scaleType = dlVar.getScaleType();
        if (scaleType == null) {
            scaleType = com.bytedance.sdk.component.m.dl.g.z.z;
        }
        ImageView.ScaleType scaleType2 = scaleType;
        Bitmap.Config configA = dlVar.a();
        if (configA == null) {
            configA = com.bytedance.sdk.component.m.dl.g.z.g;
        }
        return new com.bytedance.sdk.component.m.dl.g.z(dlVar.getWidth(), dlVar.getHeight(), scaleType2, configA, dlVar.z(), dlVar.g());
    }

    public sy gz() {
        if (this.fo == null) {
            this.fo = wp();
        }
        return this.fo;
    }

    private sy wp() {
        sy syVarGz = this.g.gz();
        return syVarGz == null ? new e() : syVarGz;
    }
}
