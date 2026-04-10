package com.bytedance.sdk.openadsdk.core.ga;

import android.content.Context;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.utils.wu;
import com.bytedance.sdk.component.zk.p;
import com.bytedance.sdk.openadsdk.core.lc;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import com.xiaomi.onetrack.b.a;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class e {
    private static volatile boolean e = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static void bf() {
        com.bytedance.sdk.component.zk.ga.bf(new p("fetch_lg_command") { // from class: com.bytedance.sdk.openadsdk.core.ga.e.2
            @Override // java.lang.Runnable
            public void run() {
                d.bf();
            }
        });
    }

    public static void d(String str, String str2) {
        if (e) {
            d.d(str, str2);
        }
    }

    public static void ga(String str, String str2) {
        if (e) {
            d.ga(str, str2);
        }
    }

    public static void tg(String str, String str2) {
        if (e) {
            d.tg(str, str2);
        }
    }

    public static void bf(String str, String str2) {
        if (e) {
            d.bf(str, str2);
        }
    }

    private static void e(Context context, bf bfVar) {
        if (bfVar == null) {
            wu.bf("ACL", "CL not init for no setting config");
            return;
        }
        if (LogAdapter.sAdapter != null) {
            wu.bf("ACL", "Log to tools");
            return;
        }
        if (!l.e(lc.getContext())) {
            wu.bf("ACL", "only main process init CL");
            return;
        }
        if (!bfVar.tg()) {
            wu.bf("ACL", "setting not open CL");
            return;
        }
        String path = context.getCacheDir().getPath();
        String string = context.getFilesDir().toString();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("buffer_dir_path", path + "/aa");
            jSONObject.putOpt("log_dir_path", string + "/aa");
            Boolean bool = Boolean.TRUE;
            jSONObject.putOpt("compress", bool);
            jSONObject.putOpt("encrypt", bool);
            jSONObject.putOpt(a.d, Integer.valueOf(bfVar.e()));
            jSONObject.putOpt("log_file_exp_days", Integer.valueOf(bfVar.bf()));
            jSONObject.putOpt("max_dir_size", Integer.valueOf(bfVar.d() * 1024 * 1024));
            jSONObject.putOpt("per_size", 2097152);
            jSONObject.putOpt("offload_main_write", bool);
            if (d.e(context, jSONObject)) {
                wu.e(new ga());
                d.e(context, "3892", com.bytedance.sdk.openadsdk.core.p.e().bf());
                d.e("mon.zijieapi.com");
                e = true;
                d.d();
            } else {
                wu.vn("ACL", "init failed");
            }
        } catch (JSONException e2) {
            wu.vn("ACL", "init failed:" + e2.getMessage());
        }
    }

    public static void bf(String str, String str2, Throwable th) {
        if (e) {
            d.bf(str, str2, th);
        }
    }

    public static void e(bf bfVar) {
        if (!e) {
            e(lc.getContext(), bfVar);
        } else if (bfVar != null && bfVar.tg()) {
            d.e(bfVar.e());
            v.e().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ga.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.bf();
                }
            }, 5000L);
        } else {
            d.e();
        }
    }

    public static void e(String str, String str2) {
        if (e) {
            d.e(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (e) {
            d.e(str, str2, th);
        }
    }

    public static void e(String str, Throwable th) {
        if (e) {
            d.e(str, th);
        }
    }
}
