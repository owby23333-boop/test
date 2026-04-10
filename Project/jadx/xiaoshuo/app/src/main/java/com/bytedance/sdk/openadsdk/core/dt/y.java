package com.bytedance.sdk.openadsdk.core.dt;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTImage;

/* JADX INFO: loaded from: classes10.dex */
public class y {
    private int bf;
    private int d;
    private String e;
    private boolean ga;
    private double tg;
    private String vn;

    public static final class e extends TTImage {
        private int bf;
        private String d;
        private int e;
        private double tg;

        public e(int i, int i2, String str, double d) {
            this.e = i;
            this.bf = i2;
            this.d = str;
            this.tg = d;
        }

        @Override // com.bytedance.sdk.openadsdk.TTImage
        public double getDuration() {
            return this.tg;
        }

        @Override // com.bytedance.sdk.openadsdk.TTImage
        public int getHeight() {
            return this.e;
        }

        @Override // com.bytedance.sdk.openadsdk.TTImage
        public String getImageUrl() {
            return this.d;
        }

        @Override // com.bytedance.sdk.openadsdk.TTImage
        public int getWidth() {
            return this.bf;
        }

        @Override // com.bytedance.sdk.openadsdk.TTImage
        public boolean isValid() {
            String str;
            return this.e > 0 && this.bf > 0 && (str = this.d) != null && str.length() > 0;
        }
    }

    public static final TTImage e(int i, int i2, String str, double d) {
        return new e(i, i2, str, d);
    }

    public int bf() {
        return this.bf;
    }

    public int d() {
        return this.d;
    }

    public boolean ga() {
        return !TextUtils.isEmpty(this.e) && this.bf > 0 && this.d > 0;
    }

    public String p() {
        return this.vn;
    }

    public double tg() {
        return this.tg;
    }

    public boolean vn() {
        return this.ga;
    }

    public static TTImage e(y yVar) {
        if (yVar == null || !yVar.ga()) {
            return null;
        }
        return new e(yVar.d(), yVar.bf(), yVar.e(), yVar.tg());
    }

    public void bf(int i) {
        this.d = i;
    }

    public void bf(String str) {
        this.vn = str;
    }

    public String e() {
        return this.e;
    }

    public void e(double d) {
        this.tg = d;
    }

    public void e(int i) {
        this.bf = i;
    }

    public void e(String str) {
        this.e = str;
    }

    public void e(boolean z) {
        this.ga = z;
    }
}
