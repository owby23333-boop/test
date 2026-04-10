package com.bykv.vk.openvk.component.video.z.g.gc;

import android.text.TextUtils;
import com.bytedance.sdk.component.g.z.ls;
import com.bytedance.sdk.component.g.z.v;
import com.bytedance.sdk.component.g.z.wp;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a implements g {
    private wp z;

    public a() {
        this.z = null;
        this.z = com.bykv.vk.openvk.component.video.api.dl.dl();
    }

    @Override // com.bykv.vk.openvk.component.video.z.g.gc.g
    public z z(gc gcVar) throws IOException {
        v.z zVar = new v.z();
        try {
            if (gcVar.gc != null) {
                for (Map.Entry<String, String> entry : gcVar.gc.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        String value = entry.getValue();
                        if (value == null) {
                            value = "";
                        }
                        zVar.g(key, value);
                    }
                }
            }
            ls lsVarG = this.z.z(zVar.z(gcVar.g).z().g()).g();
            com.bykv.vk.openvk.component.video.api.m.dl.z("NetworkSoureVolleyImpl", "response code = ", Integer.valueOf(lsVarG.dl()));
            return new m(lsVarG, gcVar);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            return null;
        }
    }
}
