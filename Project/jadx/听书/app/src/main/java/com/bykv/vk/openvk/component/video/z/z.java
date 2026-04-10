package com.bykv.vk.openvk.component.video.z;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.m.dl;
import com.bykv.vk.openvk.component.video.api.z.g;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.model.AdnName;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f120a = 10;
    public static int dl = 10;
    public static int g = 10;
    private static g gc = null;
    public static int z = 10;

    public static void z(Context context) {
        com.bykv.vk.openvk.component.video.api.m.z.z(context);
    }

    public static void z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            z = jSONObject.optInt(MediationConstant.RIT_TYPE_SPLASH, 10);
            g = jSONObject.optInt("reward", 10);
            dl = jSONObject.optInt("brand", 10);
            int iOptInt = jSONObject.optInt(AdnName.OTHER, 10);
            f120a = iOptInt;
            if (z < 0) {
                z = 10;
            }
            if (g < 0) {
                g = 10;
            }
            if (dl < 0) {
                dl = 10;
            }
            if (iOptInt < 0) {
                f120a = 10;
            }
            dl.z("MediaConfig", "splash=", Integer.valueOf(z), ",reward=", Integer.valueOf(g), ",brand=", Integer.valueOf(dl), ",other=", Integer.valueOf(f120a));
        } catch (Throwable th) {
            dl.dl("MediaConfig", th.getMessage());
        }
    }

    public static void z(g gVar) {
        gc = gVar;
    }

    public static void z() {
        g gVar = gc;
        if (gVar != null) {
            gVar.gc();
        }
    }

    public static int g() {
        return z;
    }

    public static int dl() {
        return g;
    }

    public static int a() {
        return dl;
    }

    public static int gc() {
        return f120a;
    }
}
