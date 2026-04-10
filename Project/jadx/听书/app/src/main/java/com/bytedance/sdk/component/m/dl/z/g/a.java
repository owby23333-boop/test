package com.bytedance.sdk.component.m.dl.z.g;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.m.hh;

/* JADX INFO: loaded from: classes2.dex */
public class a implements hh {
    private final com.bytedance.sdk.component.m.dl.z.g g;
    private final hh z;

    public a(hh hhVar) {
        this(hhVar, null);
    }

    public a(hh hhVar, com.bytedance.sdk.component.m.dl.z.g gVar) {
        this.z = hhVar;
        this.g = gVar;
    }

    @Override // com.bytedance.sdk.component.m.z
    public boolean z(String str, Bitmap bitmap) {
        boolean z = this.z.z(str, bitmap);
        if (this.g != null) {
            Boolean.valueOf(z);
        }
        return z;
    }

    @Override // com.bytedance.sdk.component.m.z
    public Bitmap z(String str) {
        return this.z.z(str);
    }

    @Override // com.bytedance.sdk.component.m.z
    public boolean g(String str) {
        return this.z.g(str);
    }

    @Override // com.bytedance.sdk.component.m.z
    public void z(double d) {
        this.z.z(d);
    }
}
