package com.bytedance.adsdk.ugeno.z;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.g.dl f273a;
    private Context dl;
    private List<z> g;
    private List<dl> z;

    public m(Context context, com.bytedance.adsdk.ugeno.g.dl dlVar, List<dl> list) {
        this.f273a = dlVar;
        this.dl = context;
        this.z = list;
        a();
    }

    private void a() {
        this.g = new ArrayList();
        List<dl> list = this.z;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.z.size(); i++) {
            dl dlVar = this.z.get(i);
            if (dlVar != null) {
                this.g.add(new z(this.dl, this.f273a, dlVar));
            }
        }
    }

    public void z() {
        List<z> list = this.g;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (z zVar : this.g) {
            if (zVar != null) {
                zVar.a();
            }
        }
    }

    public void g() {
        List<z> list = this.g;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (z zVar : this.g) {
            if (zVar != null) {
                zVar.z();
            }
        }
    }

    public void dl() {
        List<z> list = this.g;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (z zVar : this.g) {
            if (zVar != null) {
                zVar.dl();
            }
        }
    }

    public void z(Canvas canvas) {
        List<z> list = this.g;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (z zVar : this.g) {
            if (zVar != null) {
                zVar.z(canvas);
            }
        }
    }

    public void z(int i, int i2) {
        List<z> list = this.g;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (z zVar : this.g) {
            if (zVar != null) {
                zVar.z(i, i2);
            }
        }
    }

    public z z(String str) {
        List<z> list = this.g;
        if (list != null && !list.isEmpty()) {
            for (z zVar : this.g) {
                if (zVar != null && TextUtils.equals(zVar.gc(), str)) {
                    return zVar;
                }
            }
        }
        return null;
    }
}
