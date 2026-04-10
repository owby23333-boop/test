package com.bytedance.z.g.e;

import android.content.Context;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.z.g.gz;
import com.bytedance.z.g.gz.ls;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static volatile z z;
    private volatile Context g;

    public static z z() {
        if (z == null) {
            z = new z(gz.a());
        }
        return z;
    }

    private z(Context context) {
        this.g = context;
    }

    public String z(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                return com.bytedance.z.g.gz.a.z(com.bytedance.z.g.gz.gz.z(this.g), com.bytedance.z.g.gz.gz.z(), g.z(gz.z().z()), jSONObject, g.z());
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public void g(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        try {
            String strZ = g.z(gz.z().z());
            String strZ2 = com.bytedance.z.g.gz.a.z(com.bytedance.z.g.gz.gz.z(this.g), com.bytedance.z.g.gz.gz.g(), strZ, jSONObject, g.g());
            jSONObject.put("upload_scene", "direct");
            if (g.z(strZ, jSONObject.toString()).z()) {
                com.bytedance.z.g.gz.a.z(strZ2);
            }
        } catch (Throwable unused) {
        }
    }

    public void dl(final JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        ls.z(new Runnable() { // from class: com.bytedance.z.g.e.z.1
            @Override // java.lang.Runnable
            public void run() {
                String strZ = g.z(gz.z().z());
                try {
                    jSONObject.put("upload_scene", "direct");
                } catch (JSONException e) {
                    wp.z(e);
                }
                g.z(strZ, jSONObject.toString());
            }
        });
    }
}
