package com.bytedance.sdk.openadsdk.core.live.dl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.i.a;
import com.bytedance.sdk.openadsdk.core.i.e;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.q;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private String z = "";

    public z z(String str) {
        this.z = str;
        return this;
    }

    public void z(final Context context, final na naVar) {
        if (naVar == null || naVar.vy() == null || TextUtils.isEmpty(naVar.vy().g())) {
            return;
        }
        q.m().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.dl.z.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(naVar.vy().g()));
                    intent.addFlags(268435456);
                    if (com.bytedance.sdk.component.utils.g.z(context, intent, null, TextUtils.equals("main", UMModuleRegister.INNER))) {
                        a.z(naVar, z.this.z, "deeplink_success_realtime", (Throwable) null);
                    } else {
                        a.z(naVar, z.this.z, "deeplink_fail_realtime", (Throwable) null);
                    }
                    HashMap map = new HashMap();
                    map.put("source", "LiveDoubleOpenProcessor");
                    a.gz(naVar, z.this.z, "open_url_app", map);
                    e.z().z(naVar, z.this.z, false);
                } catch (Throwable th) {
                    wp.z(th);
                }
            }
        }, 50L);
    }
}
