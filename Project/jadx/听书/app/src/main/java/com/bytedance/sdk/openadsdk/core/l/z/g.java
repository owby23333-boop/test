package com.bytedance.sdk.openadsdk.core.l.z;

import android.os.Message;
import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.component.utils.iq;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g extends z implements l.z {
    private iq g;
    private final l z = new l(gz.z().getLooper(), this);

    public void z(JSONObject jSONObject, int i) {
        int iZ = z(i);
        if (g(i)) {
            z(jSONObject, com.bytedance.sdk.openadsdk.core.l.z.z().g(), iZ);
        } else if (dl(i)) {
            z(jSONObject, com.bytedance.sdk.openadsdk.core.l.z.z().dl(), iZ);
        }
    }

    private void z(JSONObject jSONObject, long j, long j2) {
        if (System.currentTimeMillis() - j > j2) {
            this.g = z();
            this.z.removeCallbacksAndMessages(null);
            this.z.sendEmptyMessage(1);
        }
    }

    private iq z() {
        iq iqVar = new iq(zw.getContext(), 1, uy.ls().gc());
        boolean z = iqVar.z(0);
        wp.g("csj_sen", "reg res:".concat(String.valueOf(z)));
        if (z) {
            return iqVar;
        }
        z(0, System.currentTimeMillis(), 0L);
        iqVar.g(0);
        return null;
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            iq iqVar = this.g;
            if (iqVar != null) {
                iqVar.g(0);
            }
            z(3, 0L, System.currentTimeMillis());
            return;
        }
        iq iqVar2 = this.g;
        if (iqVar2 == null) {
            return;
        }
        iqVar2.z(new iq.dl() { // from class: com.bytedance.sdk.openadsdk.core.l.z.g.1
            @Override // com.bytedance.sdk.component.utils.iq.dl
            public void z() {
                g.this.z(1, System.currentTimeMillis(), 0L);
                if (g.this.z != null) {
                    g.this.z.removeCallbacksAndMessages(null);
                }
                if (g.this.g != null) {
                    g.this.g.g(0);
                }
            }
        });
        this.z.sendEmptyMessageDelayed(2, z(zw.g().sd()));
    }
}
