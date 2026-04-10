package com.bytedance.sdk.openadsdk.core.component.reward.z.z;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.gc.a.gc;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.un.iq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.dl;
import java.io.File;
import java.io.FileFilter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static volatile z z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f985a;
    private final g dl;
    private final Context g;

    public static z z() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z(zw.getContext());
                }
            }
        }
        return z;
    }

    private z(Context context) {
        this.g = context == null ? zw.getContext() : context.getApplicationContext();
        this.dl = new g();
    }

    public void g() {
        File fileDl;
        File[] fileArrListFiles;
        gc.z(7).z();
        gc.z(8).z();
        if (("mounted".equals(dl.z()) || !Environment.isExternalStorageRemovable()) && com.bytedance.sdk.openadsdk.api.plugin.g.dl(this.g) != null) {
            fileDl = com.bytedance.sdk.openadsdk.api.plugin.g.dl(this.g);
        } else {
            fileDl = com.bytedance.sdk.openadsdk.api.plugin.g.g(this.g);
        }
        if (fileDl == null || !fileDl.exists() || !fileDl.isDirectory() || (fileArrListFiles = fileDl.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.z.z.z.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file != null) {
                    return file.getName().contains("reward_video_cache");
                }
                return false;
            }
        })) == null || fileArrListFiles.length <= 0) {
            return;
        }
        for (File file : fileArrListFiles) {
            try {
                m.dl(file);
            } catch (Throwable unused) {
            }
        }
    }

    public String z(boolean z2, String str) {
        long jDl = zw.g().dl(str);
        if (jDl > 0 && System.currentTimeMillis() - this.f985a < jDl) {
            return "1";
        }
        int i = z2 ? 7 : 8;
        na naVarG = g(z2, str);
        if (naVarG == null) {
            return "0";
        }
        if (naVarG.ti() + naVarG.zw() < System.currentTimeMillis()) {
            gc.z(i).z(str);
            return "1";
        }
        JSONObject jSONObjectZ = z(naVarG);
        if (jSONObjectZ == null) {
            return "0";
        }
        this.f985a = System.currentTimeMillis();
        return jSONObjectZ.toString();
    }

    private JSONObject z(na naVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("req_id", naVar.h());
            jSONObject.put("aid", Long.valueOf(naVar.mk()));
            jSONObject.put(CmcdConfiguration.KEY_CONTENT_ID, Long.valueOf(naVar.mj()));
            jSONObject.put("price", naVar.un());
            jSONObject.put("material_key", naVar.lq());
            jSONObject.put("s_send_ts", naVar.ti());
            jSONObject.put("cache_time", naVar.zw());
            jSONObject.put("ext", naVar.io());
            return jSONObject;
        } catch (JSONException e) {
            wp.z(e);
            return null;
        }
    }

    public void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, String str) {
        this.dl.z(str, gVar);
    }

    public com.bytedance.sdk.openadsdk.ls.dl.dl.g z(String str) {
        return this.dl.z(str);
    }

    public void g(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        z(gVar, str);
    }

    public synchronized na g(boolean z2, String str) {
        na naVarZ = com.bytedance.sdk.openadsdk.core.component.reward.z.gc.z(z2, false).z(str, 0L);
        if (naVarZ == null) {
            return null;
        }
        if (iq.dl(naVarZ)) {
            if (TextUtils.isEmpty(str) || !str.endsWith("again")) {
                return naVarZ;
            }
            return null;
        }
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(naVarZ)) {
            return naVarZ;
        }
        if (tf.v(naVarZ) == null) {
            return null;
        }
        return naVarZ;
    }
}
