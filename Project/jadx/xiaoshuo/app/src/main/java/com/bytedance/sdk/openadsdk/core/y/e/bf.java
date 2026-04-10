package com.bytedance.sdk.openadsdk.core.y.e;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.utils.tg;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class bf {
    private byte[] bf;
    private Bitmap d;
    int e;
    private Map<String, String> ga;
    private List<Object> tg;

    public bf(byte[] bArr, int i) {
        this.d = null;
        this.tg = null;
        this.ga = null;
        this.bf = bArr;
        this.e = i;
    }

    public int bf() {
        return this.e;
    }

    public byte[] d() {
        try {
            if (this.bf == null) {
                this.bf = tg.bf(this.d);
            }
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        return this.bf;
    }

    public Bitmap e() {
        return this.d;
    }

    public boolean ga() {
        byte[] bArr = this.bf;
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public boolean tg() {
        if (this.d != null) {
            return true;
        }
        byte[] bArr = this.bf;
        return bArr != null && bArr.length > 0;
    }

    public bf(Bitmap bitmap, int i) {
        this.bf = null;
        this.tg = null;
        this.ga = null;
        this.d = bitmap;
        this.e = i;
    }
}
