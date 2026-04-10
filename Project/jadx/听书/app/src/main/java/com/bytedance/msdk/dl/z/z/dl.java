package com.bytedance.msdk.dl.z.z;

import android.util.SparseArray;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class dl extends com.bytedance.msdk.g.dl {
    protected com.bytedance.msdk.dl.dl.g.z.z.g fo;
    protected Function<SparseArray<Object>, Object> uy;

    @Override // com.bytedance.msdk.g.dl
    public boolean gc() {
        return false;
    }

    public dl(com.bytedance.msdk.dl.dl.g.z.z.g gVar, Function<SparseArray<Object>, Object> function) {
        this.fo = gVar;
        this.uy = function;
    }

    @Override // com.bytedance.msdk.g.dl
    public Integer m() {
        com.bytedance.msdk.dl.dl.g.z.z.g gVar = this.fo;
        if (gVar != null) {
            return gVar.uy();
        }
        return super.m();
    }

    @Override // com.bytedance.msdk.g.dl
    public void p() {
        super.p();
        com.bytedance.msdk.dl.dl.g.z.z.g gVar = this.fo;
        if (gVar != null) {
            gVar.wp();
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public void ls() {
        super.ls();
        com.bytedance.msdk.dl.dl.g.z.z.g gVar = this.fo;
        if (gVar != null) {
            gVar.kb();
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public void fv() {
        super.fv();
        com.bytedance.msdk.dl.dl.g.z.z.g gVar = this.fo;
        if (gVar != null) {
            gVar.i();
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public void z(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        int i = 10001;
        try {
            Object obj = map.get("bidding_lose_reason_NUM");
            int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
            if (iIntValue > 0) {
                i = iIntValue;
            }
        } catch (Exception unused) {
        }
        z(false, -1.0d, i, null);
    }

    @Override // com.bytedance.msdk.g.dl
    public void g(Map<String, Object> map) {
        z(true, u(), -1, null);
    }

    public void z(boolean z, double d, int i, Map<String, Object> map) {
        com.bytedance.msdk.dl.dl.g.z.z.g gVar = this.fo;
        if (gVar != null) {
            gVar.z(z, d, i, map);
        }
    }
}
