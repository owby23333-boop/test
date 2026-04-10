package com.bytedance.msdk.a;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.msdk.gz.a.dl;
import com.bytedance.sdk.component.fo.z;
import com.bytedance.sdk.component.g.z.a;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static volatile g z;
    private final com.bytedance.sdk.component.fo.z dl;
    private Context g;

    public static g z() {
        if (z == null) {
            synchronized (g.class) {
                if (z == null) {
                    z = new g(com.bytedance.msdk.core.g.getContext());
                }
            }
        }
        return z;
    }

    private g(Context context) {
        this.g = context == null ? com.bytedance.msdk.core.g.getContext() : context.getApplicationContext();
        z.C0131z c0131zZ = new z.C0131z().z(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).g(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).dl(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).z(true);
        if (dl.z() && dl.z != null) {
            Object obj = dl.z.get("case_id");
            if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
                c0131zZ.z(new dl.z());
            }
        }
        com.bytedance.sdk.component.fo.z zVarZ = c0131zZ.z();
        this.dl = zVarZ;
        a aVarZ = zVarZ.m().z();
        if (aVarZ != null) {
            aVarZ.z(16);
        }
    }

    public com.bytedance.sdk.component.fo.z g() {
        return this.dl;
    }
}
