package com.bytedance.msdk.api.a.z.g.dl;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.ls.a;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f361a;
    private final int dl;
    private final String g;
    private final String gc;
    private final String z;

    public dl(String str, String str2, int i, int i2, String str3) {
        this.z = str;
        this.g = str2;
        this.dl = i;
        this.f361a = i2;
        this.gc = str3;
    }

    public SparseArray<Object> z() {
        a aVarZ = a.z();
        aVarZ.z(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec, this.z);
        aVarZ.z(2, this.g);
        aVarZ.z(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes, Integer.valueOf(this.dl));
        aVarZ.z(8094, Integer.valueOf(this.f361a));
        aVarZ.z(8547, this.gc);
        if (com.bytedance.msdk.core.z.kb().oq() != null) {
            HashMap map = new HashMap();
            map.put("live_ad_custom_config", com.bytedance.msdk.core.z.kb().oq());
            aVarZ.z(8075, map);
        }
        return aVarZ.g();
    }

    public int g() {
        return this.dl;
    }
}
