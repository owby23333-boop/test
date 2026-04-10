package com.bytedance.sdk.openadsdk.core.g.z.g;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.media3.exoplayer.ExoPlayer;
import com.bytedance.sdk.component.utils.g;
import com.bytedance.sdk.component.utils.hh;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.ja;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.sy;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.iq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.e;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private static volatile boolean gz;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1073a;
    private final Context dl;
    private ja e;
    private final na g;
    private String gc;
    private boolean m;
    private Toast z;

    public interface z {
        void g();

        void z();
    }

    public static boolean z() {
        return gz;
    }

    public static void z(boolean z2) {
        gz = z2;
    }

    public gc(na naVar, Context context) {
        this.g = naVar;
        this.dl = context;
    }

    public gc z(String str) {
        this.gc = str;
        return this;
    }

    public gc z(int i) {
        this.f1073a = i;
        return this;
    }

    public gc g(boolean z2) {
        this.m = z2;
        return this;
    }

    public boolean z(z zVar) {
        int iG;
        if (this.e == null) {
            na naVar = this.g;
            this.e = naVar != null ? naVar.fx() : null;
        }
        ja jaVar = this.e;
        if (jaVar == null) {
            return false;
        }
        int iG2 = jaVar.g();
        if (iG2 != 1) {
            if (iG2 != 2 || (iG = g(zVar)) == 0) {
                return false;
            }
            if (iG == 2) {
                return true;
            }
            if (TextUtils.isEmpty(this.e.z())) {
                return false;
            }
            z(zVar, this.e, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            return true;
        }
        if (this.m && (TextUtils.isEmpty(this.e.gz()) || g(zVar) == 2)) {
            return true;
        }
        return false;
    }

    private int g(z zVar) {
        ja jaVarFx;
        na naVar = this.g;
        if (naVar == null || (jaVarFx = naVar.fx()) == null) {
            return 0;
        }
        if (jaVarFx.m() != 1 || !a.dl().z()) {
            return 1;
        }
        if (TextUtils.isEmpty(jaVarFx.e())) {
            return 0;
        }
        z(zVar, jaVarFx);
        return 2;
    }

    private void z(final z zVar, ja jaVar) {
        g();
        zw.z().z(jaVar, this.g.fp(), this.g.vk(), new g(zVar, jaVar, this.z) { // from class: com.bytedance.sdk.openadsdk.core.g.z.g.gc.1
            @Override // com.bytedance.sdk.openadsdk.core.g.z.g.gc.g, com.bytedance.sdk.openadsdk.core.sy.dl
            public void z(JSONObject jSONObject) {
                String strOptString = jSONObject.optString("userName");
                String strOptString2 = jSONObject.optString("path");
                if (!TextUtils.isEmpty(strOptString)) {
                    if (gc.this.z != null) {
                        gc.this.z.cancel();
                    }
                    a.dl().z(gc.this.g, strOptString, strOptString2, zVar, gc.this.gc, gc.this.m);
                    return;
                }
                z(605, " userName or path is null!");
            }
        }, 1, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    private void z(z zVar, ja jaVar, long j) {
        g();
        zw.z().z(jaVar, this.g.fp(), this.g.vk(), new g(zVar, jaVar, this.z), 2, j);
    }

    class g implements sy.dl<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Toast f1075a;
        private final ja g;
        private final z z;

        g(z zVar, ja jaVar, Toast toast) {
            this.z = zVar;
            this.g = jaVar;
            this.f1075a = toast;
        }

        @Override // com.bytedance.sdk.openadsdk.core.sy.dl
        public void z(int i, String str) {
            wp.g("WechatClickHandler", "getWechatLink failed:" + i + ", " + str);
            this.g.g(0);
            Toast toast = this.f1075a;
            if (toast != null) {
                toast.cancel();
            }
            z zVar = this.z;
            if (zVar != null) {
                zVar.g();
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.sdk.openadsdk.core.sy.dl
        public void z(JSONObject jSONObject) {
            String strOptString = jSONObject.optString("scheme");
            if (!TextUtils.isEmpty(strOptString)) {
                gc.this.z(strOptString, this.g, this.z);
            } else {
                z(605, " scheme is null!");
            }
        }
    }

    private void g() {
        e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.g.z.g.gc.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (gc.this.z != null) {
                        gc.this.z.cancel();
                    }
                    gc gcVar = gc.this;
                    gcVar.z = hh.z(gcVar.dl, "即将跳转微信...", 1, 17, 0, 0);
                    gc.this.z.show();
                } catch (Throwable th) {
                    wp.dl("toast error:" + th.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, final ja jaVar, final z zVar) {
        Toast toast = this.z;
        if (toast != null) {
            toast.cancel();
        }
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(268435456);
        final String strZ = iq.g(this.g) ? this.gc : eo.z(this.f1073a);
        com.bytedance.sdk.component.utils.g.z(this.dl, intent, new g.z() { // from class: com.bytedance.sdk.openadsdk.core.g.z.g.gc.3
            @Override // com.bytedance.sdk.component.utils.g.z
            public void z() {
                jaVar.g(1);
                com.bytedance.sdk.openadsdk.core.i.a.z(gc.this.g, strZ, "deeplink_success_realtime", (Throwable) null);
                HashMap map = new HashMap();
                map.put("source", "WechatClickProcesser");
                com.bytedance.sdk.openadsdk.core.i.a.gz(gc.this.g, strZ, "open_url_app", map);
                com.bytedance.sdk.openadsdk.core.i.e.z().z(gc.this.g, strZ, false);
                z zVar2 = zVar;
                if (zVar2 != null) {
                    zVar2.z();
                }
            }

            @Override // com.bytedance.sdk.component.utils.g.z
            public void z(Throwable th) {
                jaVar.g(0);
                z zVar2 = zVar;
                if (zVar2 != null) {
                    zVar2.g();
                }
            }
        }, TextUtils.equals("main", UMModuleRegister.INNER));
    }
}
