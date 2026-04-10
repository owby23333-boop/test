package com.bytedance.sdk.openadsdk.core.io.z;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.wp;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Object> f1146a;
    private Bitmap dl;
    private byte[] g;
    private Map<String, String> gc;
    int z;

    public g(byte[] bArr, int i) {
        this.dl = null;
        this.f1146a = null;
        this.gc = null;
        this.g = bArr;
        this.z = i;
    }

    public g(Bitmap bitmap, int i) {
        this.g = null;
        this.f1146a = null;
        this.gc = null;
        this.dl = bitmap;
        this.z = i;
    }

    public Bitmap z() {
        return this.dl;
    }

    public int g() {
        return this.z;
    }

    public byte[] dl() {
        try {
            if (this.g == null) {
                this.g = a.g(this.dl);
            }
        } catch (OutOfMemoryError e) {
            wp.z(e);
        }
        return this.g;
    }

    public boolean a() {
        if (this.dl != null) {
            return true;
        }
        byte[] bArr = this.g;
        return bArr != null && bArr.length > 0;
    }

    public boolean gc() {
        byte[] bArr = this.g;
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }
}
