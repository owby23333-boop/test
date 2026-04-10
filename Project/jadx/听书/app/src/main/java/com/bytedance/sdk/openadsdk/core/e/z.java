package com.bytedance.sdk.openadsdk.core.e;

import android.content.Context;
import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.un.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static volatile boolean z;

    private static void z(Context context, g gVar) {
        if (gVar != null && LogAdapter.z == null && p.z(zw.getContext()) && gVar.a()) {
            String path = com.bytedance.sdk.openadsdk.api.plugin.g.g(context).getPath();
            String string = com.bytedance.sdk.openadsdk.api.plugin.g.z(context).toString();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("buffer_dir_path", path + "/aa");
                jSONObject.putOpt("log_dir_path", string + "/aa");
                jSONObject.putOpt("compress", Boolean.TRUE);
                jSONObject.putOpt("encrypt", Boolean.TRUE);
                jSONObject.putOpt("level", Integer.valueOf(gVar.z()));
                jSONObject.putOpt("log_file_exp_days", Integer.valueOf(gVar.g()));
                jSONObject.putOpt("max_dir_size", Integer.valueOf(gVar.dl() * 1024 * 1024));
                jSONObject.putOpt("per_size", 2097152);
                jSONObject.putOpt("offload_main_write", Boolean.TRUE);
                if (dl.z(context, jSONObject)) {
                    wp.z(new gc());
                    dl.z(context, "3892", uy.p());
                    dl.z("mon.zijieapi.com");
                    z = true;
                    dl.dl();
                    return;
                }
                wp.a("ACL", "init failed");
            } catch (JSONException e) {
                wp.a("ACL", "init failed:" + e.getMessage());
            }
        }
    }

    public static void z(g gVar) {
        if (!z) {
            z(zw.getContext(), gVar);
        } else if (gVar == null || !gVar.a()) {
            dl.z();
        } else {
            dl.z(gVar.z());
            gz.z().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.e.z.1
                @Override // java.lang.Runnable
                public void run() {
                    z.g();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g() {
        e.g(new fo("fetch_lg_command") { // from class: com.bytedance.sdk.openadsdk.core.e.z.2
            @Override // java.lang.Runnable
            public void run() {
                dl.g();
            }
        });
    }

    public static void z(String str, String str2) {
        if (z) {
            dl.z(str, str2);
        }
    }

    public static void g(String str, String str2) {
        if (z) {
            dl.g(str, str2);
        }
    }

    public static void dl(String str, String str2) {
        if (z) {
            dl.dl(str, str2);
        }
    }

    public static void z(String str, String str2, Throwable th) {
        if (z) {
            dl.z(str, str2, th);
        }
    }

    public static void a(String str, String str2) {
        if (z) {
            dl.a(str, str2);
        }
    }

    public static void g(String str, String str2, Throwable th) {
        if (z) {
            dl.g(str, str2, th);
        }
    }

    public static void z(String str, Throwable th) {
        if (z) {
            dl.z(str, th);
        }
    }
}
