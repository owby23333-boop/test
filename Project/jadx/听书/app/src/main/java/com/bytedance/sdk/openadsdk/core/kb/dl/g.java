package com.bytedance.sdk.openadsdk.core.kb.dl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.iq.ls;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class g extends m {
    public g(Context context, na naVar, String str, boolean z) {
        super(context, naVar, str, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.gc
    public boolean m() {
        if (this.gc.vy() == null) {
            return false;
        }
        String strG = this.gc.vy().g();
        if (!TextUtils.isEmpty(strG)) {
            ls.z((String) null);
            Uri uri = Uri.parse(strG);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            eo.g(intent);
            if (this.p) {
                com.bytedance.sdk.openadsdk.core.i.a.g(this.gc, this.m, "lp_open_dpl", z(strG));
            }
            try {
                Context context = getContext();
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                if (!z(this.m, "open_url_app", this.gc)) {
                    HashMap map = new HashMap();
                    map.put("source", "AndroidRDMLicManager");
                    com.bytedance.sdk.openadsdk.core.i.a.gz(this.gc, this.m, "open_url_app", map);
                }
                eo.z(this.p, this.gc, this.m);
                com.bytedance.sdk.component.utils.g.startActivity(context, intent, TextUtils.equals("main", UMModuleRegister.INNER));
                com.bytedance.sdk.openadsdk.core.i.e.z().z(this.gc, this.m, this.p);
                if (this.p) {
                    com.bytedance.sdk.openadsdk.core.i.a.dl(this.gc, this.m, "lp_openurl");
                    com.bytedance.sdk.openadsdk.core.i.a.z(this.gc, this.m, "lp_deeplink_success_realtime", (Throwable) null);
                } else {
                    com.bytedance.sdk.openadsdk.core.i.a.z(this.gc, this.m, "deeplink_success_realtime", (Throwable) null);
                }
                return true;
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.core.i.a.dl(this.gc, this.m, "open_fallback_download");
                if (this.p) {
                    com.bytedance.sdk.openadsdk.core.i.a.dl(this.gc, this.m, "lp_openurl_failed");
                    z(this.gc, this.m, "lp_deeplink_fail_realtime", th);
                } else {
                    z(this.gc, this.m, "deeplink_fail_realtime", th);
                }
            }
        }
        if (this.e.get() == 4 || this.e.get() == 3) {
            return false;
        }
        if (this.fo && !this.gz.get()) {
            return false;
        }
        this.fo = true;
        if (z(this.m, "open_fallback_url", this.gc)) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.i.a.gz(this.gc, this.m, "open_fallback_url", null);
        return false;
    }
}
