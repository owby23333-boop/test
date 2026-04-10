package com.bytedance.sdk.component.m.a;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.m.tb;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends z {
    private com.bytedance.sdk.component.m.e g;
    private byte[] z;

    @Override // com.bytedance.sdk.component.m.a.fo
    public String z() {
        return "decode";
    }

    public gc(byte[] bArr, com.bytedance.sdk.component.m.e eVar) {
        this.z = bArr;
        this.g = eVar;
    }

    @Override // com.bytedance.sdk.component.m.a.fo
    public void z(com.bytedance.sdk.component.m.dl.dl dlVar) {
        com.bytedance.sdk.component.m.dl.m mVarWp = dlVar.wp();
        com.bytedance.sdk.component.m.dl.g.z zVarZ = mVarWp.z(dlVar);
        try {
            tb tbVarPf = dlVar.pf();
            if (tbVarPf != null) {
                tbVarPf.onStep(10, null);
            }
            Bitmap bitmapZ = zVarZ.z(this.z);
            if (bitmapZ != null) {
                dlVar.z(new i(bitmapZ, this.z, this.g, false));
                mVarWp.z(dlVar.i()).z(dlVar.getMemoryCacheKey(), bitmapZ);
            } else {
                z(1002, "decode failed bitmap null", null, dlVar);
            }
            if (tbVarPf != null) {
                tbVarPf.onStep(11, bitmapZ);
            }
        } catch (Throwable th) {
            z(1002, "decode failed:" + th.getMessage(), th, dlVar);
        }
    }

    private void z(int i, String str, Throwable th, com.bytedance.sdk.component.m.dl.dl dlVar) {
        if (this.g == null) {
            dlVar.z(new kb());
        } else {
            dlVar.z(new gz(i, str, th));
        }
    }
}
