package com.bytedance.sdk.openadsdk.core.dislike;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.hh;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.gk.gz;
import com.bytedance.sdk.openadsdk.core.iq.j;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.e;
import com.bytedance.sdk.openadsdk.i.z;
import com.bytedance.sdk.openadsdk.ls.dl.g.m;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.an;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements com.bytedance.sdk.openadsdk.core.dislike.g.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1025a;
    private final a dl;
    private final WeakReference<Context> g;
    private final na z;

    public gc(na naVar, Context context, a aVar) {
        this.z = naVar;
        this.g = new WeakReference<>(context);
        this.dl = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dislike.g.z
    public boolean z(String str, Dialog dialog) {
        if (TextUtils.isEmpty(str) || this.g.get() == null || !str.startsWith("#oncall#")) {
            return false;
        }
        return z(this.g.get(), str, dialog);
    }

    @Override // com.bytedance.sdk.openadsdk.core.dislike.g.z
    public boolean z(m mVar, String str, Dialog dialog) {
        com.bytedance.sdk.openadsdk.core.dislike.dl.dl dlVarZ = a.z();
        if (dlVarZ == null || !TextUtils.equals(mVar.z(), dlVarZ.z()) || !TextUtils.equals(mVar.g(), dlVarZ.g())) {
            return false;
        }
        wp.g("TTAdDislikeImpl", "click feedback :" + mVar.g() + ":" + mVar.z());
        return z(this.g.get(), str, dialog);
    }

    public boolean z(Context context, final String str, Dialog dialog) {
        try {
            if (this.f1025a == null) {
                this.f1025a = UUID.randomUUID().toString();
            }
            if (dialog != null) {
                dialog.dismiss();
            }
            new AlertDialog.Builder(context).setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.gc.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    gc gcVar = gc.this;
                    gcVar.z(gcVar.f1025a, str);
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.gc.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).setMessage(this.dl.a() + "\n\n您此次反馈的id为：" + this.f1025a).setCancelable(true).create().show();
            return true;
        } catch (Exception e) {
            wp.z(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final String str) {
        e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.gc.3
            @Override // java.lang.Runnable
            public void run() {
                if (gc.this.g.get() != null) {
                    hh.z((Context) gc.this.g.get(), str, 1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final String str, final String str2) {
        z("反馈上传中，请您稍等！");
        com.bytedance.sdk.component.uy.e.g(new fo("upload_oncall") { // from class: com.bytedance.sdk.openadsdk.core.dislike.gc.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    gc.this.g(str, str2);
                } catch (Throwable th) {
                    wp.g("#oncall#", th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, String str2) throws Throwable {
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.g.g(zw.getContext()), str);
        file.mkdirs();
        com.bytedance.sdk.openadsdk.core.hh hhVar = (com.bytedance.sdk.openadsdk.core.hh) zw.z();
        com.bytedance.sdk.openadsdk.ls.dl.dl.g gVarLw = this.z.lw();
        JSONObject jSONObjectZ = hhVar.z(gVarLw, new j(), gVarLw.tb(), false, 6);
        if (jSONObjectZ == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.hh.a.z(com.bytedance.sdk.openadsdk.core.dl.m.z().g(jSONObjectZ.toString()).a().toString(), new File(file, "request.info"));
        HashMap map = null;
        com.bytedance.sdk.openadsdk.hh.a.z(com.bytedance.sdk.component.utils.z.z(gz.z((com.bytedance.sdk.openadsdk.core.gk.gc) null).gc()).toString(), new File(file, "setting.info"));
        com.bytedance.sdk.openadsdk.hh.a.z(com.bytedance.sdk.component.utils.z.z(this.z.kv()).toString(), new File(file, "meta.info"));
        File fileZ = com.bytedance.sdk.openadsdk.hh.a.z(file, str + ".zip");
        String strDl = dl(str2, str);
        HashMap map2 = new HashMap();
        Pair<Integer, JSONObject> pairZ = com.bytedance.sdk.openadsdk.core.dl.m.z().z(strDl, false);
        if (pairZ != null) {
            map = new HashMap();
            map2.put("deviceInfo", ((JSONObject) pairZ.second).optString("message"));
            map.put("x-pglcypher", String.valueOf(pairZ.first));
        }
        new com.bytedance.sdk.openadsdk.i.z().z(this.dl.dl(), fileZ, map2, new z.InterfaceC0219z() { // from class: com.bytedance.sdk.openadsdk.core.dislike.gc.5
            @Override // com.bytedance.sdk.openadsdk.i.z.InterfaceC0219z
            public void z(String str3) {
                gc.this.z("反馈上传成功！");
            }

            @Override // com.bytedance.sdk.openadsdk.i.z.InterfaceC0219z
            public void z(int i, String str3) {
                gc.this.z("反馈失败！");
            }
        }, map);
        fileZ.delete();
        com.bytedance.sdk.openadsdk.hh.a.z(file);
    }

    private String dl(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, uy.ls().iq());
            jSONObject.putOpt(PluginConstants.KEY_APP_ID, uy.ls().q());
            jSONObject.putOpt("os_api", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt(an.y, Build.VERSION.RELEASE);
            jSONObject.putOpt("manufacturer", Build.MANUFACTURER);
            jSONObject.putOpt("did", com.bytedance.sdk.openadsdk.core.un.uy.p());
            jSONObject.putOpt("sdk_version", 7105);
            jSONObject.putOpt("sdk_api_version", Integer.valueOf(gk.dl));
            jSONObject.putOpt("live_sdk_version", com.bytedance.sdk.openadsdk.core.live.g.z().e());
            jSONObject.putOpt(NotificationCompat.CATEGORY_MESSAGE, str);
            jSONObject.putOpt("recordId", str2);
            jSONObject.putOpt(an.x, "Android");
            jSONObject.putOpt("ad_info", this.z.nv());
            com.bytedance.sdk.openadsdk.ls.dl.dl.g gVarLw = this.z.lw();
            if (gVarLw != null) {
                jSONObject.putOpt("ad_slot_type", Integer.valueOf(gVarLw.tb()));
                jSONObject.putOpt("rit", gVarLw.js());
            }
            return jSONObject.toString();
        } catch (Exception e) {
            wp.g("#oncall#", e);
            return str;
        }
    }

    public static void z(Context context, com.bytedance.sdk.openadsdk.core.dislike.ui.z zVar, na naVar) {
        a aVarWn;
        if (zVar == null || naVar == null || (aVarWn = zw.g().wn()) == null || !aVarWn.g() || TextUtils.isEmpty(aVarWn.dl())) {
            return;
        }
        zVar.z(new gc(naVar, context, aVarWn));
    }
}
