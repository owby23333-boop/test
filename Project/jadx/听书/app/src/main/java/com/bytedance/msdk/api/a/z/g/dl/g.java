package com.bytedance.msdk.api.a.z.g.dl;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.ls.a;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f362a;
    private final String dl;
    private final String e;
    private final String fo;
    private final String g;
    private final String gc;
    private final String gz;
    private final String kb;
    private final String m;
    private final String uy;
    private final String wp;
    private final String z;

    public g() {
        this.dl = "";
        this.z = "";
        this.g = "";
        this.f362a = "";
        this.gc = "";
        this.m = "";
        this.e = "";
        this.gz = "";
        this.fo = "";
        this.uy = "";
        this.kb = "";
        this.wp = "";
    }

    public g(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.dl = str;
        this.z = str2;
        this.g = str3;
        this.f362a = str4;
        this.gc = str5;
        this.m = str6;
        this.e = str7;
        this.gz = str8;
        this.fo = str9;
        this.uy = str10;
        this.kb = str11;
        this.wp = str12;
    }

    public SparseArray<Object> z() {
        a aVarZ = a.z();
        aVarZ.z(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec, this.dl);
        aVarZ.z(8534, this.z);
        aVarZ.z(8535, this.g);
        aVarZ.z(8536, this.f362a);
        aVarZ.z(8537, this.gc);
        aVarZ.z(8538, this.m);
        aVarZ.z(8539, this.e);
        aVarZ.z(8540, this.gz);
        aVarZ.z(8541, this.fo);
        aVarZ.z(8542, this.uy);
        aVarZ.z(8543, this.kb);
        aVarZ.z(8544, this.wp);
        return aVarZ.g();
    }

    public String g() {
        return this.dl;
    }

    public String dl() {
        return this.f362a;
    }

    public z z(int i, int i2) {
        switch (i) {
            case 1:
                return new z(this.gc, com.bytedance.msdk.api.a.z.g.z.z.class);
            case 2:
                return new z(this.m, com.bytedance.msdk.api.a.z.g.e.z.class);
            case 3:
                return new z(this.fo, com.bytedance.msdk.api.a.z.g.uy.z.class);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                if (i2 == 4) {
                    return new z(this.uy, com.bytedance.msdk.api.a.z.g.gz.z.class);
                }
                if (i2 == 5) {
                    return new z(this.kb, com.bytedance.msdk.api.a.z.g.a.z.class);
                }
                if (i2 == 3) {
                    return new z(this.gc, com.bytedance.msdk.api.a.z.g.z.z.class);
                }
                return new z(this.uy, com.bytedance.msdk.api.a.z.g.gz.z.class);
            case 7:
                if (i2 == 6) {
                    return new z(this.e, com.bytedance.msdk.api.a.z.g.fo.z.class);
                }
                if (i2 == 7) {
                    return new z(this.gz, com.bytedance.msdk.api.a.z.g.gc.z.class);
                }
                return new z(this.e, com.bytedance.msdk.api.a.z.g.fo.z.class);
            case 8:
                return new z(this.gz, com.bytedance.msdk.api.a.z.g.gc.z.class);
            case 9:
                break;
            case 10:
                if (i2 == 1) {
                    return new z(this.m, com.bytedance.msdk.api.a.z.g.e.z.class);
                }
                if (i2 == 2) {
                    return new z(this.gz, com.bytedance.msdk.api.a.z.g.gc.z.class);
                }
                break;
        }
        return new z(this.kb, com.bytedance.msdk.api.a.z.g.a.z.class);
    }

    public boolean a() {
        return TextUtils.equals(this.wp, "1");
    }

    public String toString() {
        return "GMCustomInitConfig{mAppId='" + this.z + "', mAppKey='" + this.g + "', mADNName='" + this.dl + "', mAdnInitClassName='" + this.f362a + "', mBannerClassName='" + this.gc + "', mInterstitialClassName='" + this.m + "', mRewardClassName='" + this.e + "', mFullVideoClassName='" + this.gz + "', mSplashClassName='" + this.fo + "', mDrawClassName='" + this.kb + "', mFeedClassName='" + this.uy + "'}";
    }
}
