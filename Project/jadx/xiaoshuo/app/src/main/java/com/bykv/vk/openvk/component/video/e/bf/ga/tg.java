package com.bykv.vk.openvk.component.video.e.bf.ga;

import android.text.TextUtils;
import com.bytedance.sdk.component.bf.e.bh;
import com.bytedance.sdk.component.bf.e.s;
import com.bytedance.sdk.component.bf.e.wu;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class tg implements bf {
    private wu e;

    public tg() {
        this.e = null;
        this.e = com.bykv.vk.openvk.component.video.api.d.d();
    }

    @Override // com.bykv.vk.openvk.component.video.e.bf.ga.bf
    public e e(ga gaVar) throws IOException {
        bh.e eVar = new bh.e();
        try {
            Map<String, String> map = gaVar.ga;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        String value = entry.getValue();
                        if (value == null) {
                            value = "";
                        }
                        eVar.bf(key, value);
                    }
                }
            }
            s sVarE = this.e.e(eVar.e(gaVar.bf).e().bf()).e();
            com.bykv.vk.openvk.component.video.api.vn.d.bf("NetworkSoureVolleyImpl", "response code = ", Integer.valueOf(sVarE.d()));
            return new vn(sVarE, gaVar);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
