package com.bykv.vk.openvk.component.video.z.g;

import android.content.Context;
import com.bykv.vk.openvk.component.video.z.g.z.dl;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f111a;
    public static volatile Integer fo;
    static volatile com.bykv.vk.openvk.component.video.z.g.z.dl g;
    private static volatile Context kb;
    static volatile boolean m;
    private static volatile com.bykv.vk.openvk.component.video.z.g.g.dl uy;
    static volatile com.bykv.vk.openvk.component.video.z.g.z.g z;
    public static final boolean dl = com.bytedance.sdk.component.utils.wp.dl();
    static volatile boolean gc = true;
    static volatile int e = 0;
    public static volatile int gz = 3;

    public static Context getContext() {
        return kb;
    }

    public static void z(boolean z2) {
        gc = z2;
    }

    public static void g(boolean z2) {
        m = z2;
    }

    public static void z(int i) {
        e = i;
    }

    public static void z(com.bykv.vk.openvk.component.video.z.g.z.dl dlVar, Context context) {
        if (dlVar == null || context == null) {
            throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
        }
        kb = context.getApplicationContext();
        if (g != null) {
            return;
        }
        com.bykv.vk.openvk.component.video.z.g.z.g gVar = z;
        if (gVar != null && gVar.z.getAbsolutePath().equals(dlVar.z.getAbsolutePath())) {
            throw new IllegalArgumentException("DiskLruCache and DiskCache can't use the same dir");
        }
        g = dlVar;
        uy = com.bykv.vk.openvk.component.video.z.g.g.dl.z(context);
        g.z(new dl.z() { // from class: com.bykv.vk.openvk.component.video.z.g.gc.1
            @Override // com.bykv.vk.openvk.component.video.z.g.z.dl.z
            public void z(String str) {
                if (gc.dl) {
                    com.bytedance.sdk.component.utils.wp.z("TAG_PROXY_DiskLruCache", "new cache created: ".concat(String.valueOf(str)));
                }
            }

            @Override // com.bykv.vk.openvk.component.video.z.g.z.dl.z
            public void z(Set<String> set) {
                gc.uy.z(set, 0);
                if (gc.dl) {
                    com.bytedance.sdk.component.utils.wp.z("TAG_PROXY_DiskLruCache", "cache file removed, ".concat(String.valueOf(set)));
                }
            }
        });
        m mVarZ = m.z();
        mVarZ.z(dlVar);
        mVarZ.z(uy);
        a aVarDl = a.dl();
        aVarDl.z(dlVar);
        aVarDl.z(uy);
    }

    public static com.bykv.vk.openvk.component.video.z.g.z.dl z() {
        return g;
    }

    public static com.bykv.vk.openvk.component.video.z.g.z.g g() {
        return z;
    }
}
