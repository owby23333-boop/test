package com.bytedance.sdk.openadsdk.core.io;

import android.content.Context;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.fo.z;
import com.bytedance.sdk.openadsdk.core.io.z;
import com.bytedance.sdk.openadsdk.core.iq.lq;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private static volatile gc z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.sdk.component.fo.z f1145a;
    private com.bytedance.sdk.openadsdk.i.z.z dl;
    private Context g;

    public static gc z() {
        if (z == null) {
            synchronized (gc.class) {
                if (z == null) {
                    com.bytedance.sdk.component.g.z.z.z.z().z(com.bytedance.sdk.openadsdk.core.dl.dl.z().m() != 2);
                    z = new gc(zw.getContext());
                }
            }
        }
        return z;
    }

    private gc(Context context) {
        this.g = context == null ? zw.getContext() : context.getApplicationContext();
        com.bytedance.sdk.component.fo.z zVarZ = new z.C0131z().z(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).g(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).dl(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).z(new z.C0180z()).z(lq.z()).z(lq.g()).z(true).z();
        this.f1145a = zVarZ;
        com.bytedance.sdk.component.g.z.a aVarZ = zVarZ.m().z();
        if (aVarZ != null) {
            aVarZ.z(32);
            aVarZ.g(com.bytedance.sdk.openadsdk.core.dl.dl.z().gc());
        }
    }

    public com.bytedance.sdk.component.fo.z g() {
        return this.f1145a;
    }

    public com.bytedance.sdk.openadsdk.i.z.z dl() {
        a();
        return this.dl;
    }

    private void a() {
        if (this.dl == null) {
            this.dl = new com.bytedance.sdk.openadsdk.i.z.z();
        }
    }
}
