package com.bytedance.sdk.openadsdk.core.component.reward.view.ugen;

import android.os.Looper;
import android.os.Message;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.adsdk.ugeno.dl.iq;
import com.bytedance.sdk.component.adexpress.g.e;
import com.bytedance.sdk.component.adexpress.g.gz;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.nativeexpress.fv;
import com.bytedance.sdk.openadsdk.core.ugeno.dl;
import com.bytedance.sdk.openadsdk.core.ugeno.express.g;
import com.bytedance.sdk.openadsdk.core.ugeno.express.m;
import com.bytedance.sdk.openadsdk.core.ugeno.express.z.g;
import com.bytedance.sdk.openadsdk.core.ugeno.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z implements l.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f980a;
    private final na dl;
    private m g;
    private gz gc;
    private g m;
    l z = new l(Looper.getMainLooper(), this);

    public z(na naVar) {
        this.dl = naVar;
    }

    public void z(gz gzVar) {
        this.gc = gzVar;
    }

    public void z(e eVar) {
        this.f980a = eVar;
    }

    public void z(g gVar) {
        this.m = gVar;
    }

    public void z(String str, String str2, final int i, final int i2, int i3) {
        if (i3 > 0) {
            this.z.sendEmptyMessageDelayed(1, i3);
        }
        uy.z(str, str2, new dl() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.z.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.dl
            public void z(String str3) {
                try {
                    z zVar = z.this;
                    zVar.z(zVar.dl, new JSONObject(str3), i, i2);
                } catch (Throwable unused) {
                    if (z.this.f980a != null) {
                        z.this.f980a.z(-1, "render fail");
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.dl
            public void z() {
                if (z.this.f980a != null) {
                    z.this.f980a.z(-1, "request fail");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(na naVar, JSONObject jSONObject, int i, int i2) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(MediaFormat.KEY_WIDTH, i);
            jSONObject2.put(MediaFormat.KEY_HEIGHT, i2);
        } catch (Throwable unused) {
        }
        g.z zVar = new g.z();
        zVar.z(com.bytedance.sdk.openadsdk.core.nativeexpress.g.g.z(naVar, jSONObject2, jSONObject, false, null));
        zVar.z((iq) new fv());
        zVar.z(i);
        zVar.g(0.0f);
        m mVar = new m(zw.getContext(), null, zVar.z(), null);
        this.g = mVar;
        e eVar = this.f980a;
        if (eVar != null) {
            mVar.z(eVar);
        }
        gz gzVar = this.gc;
        if (gzVar != null) {
            this.g.z(gzVar);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.express.z.g gVar = this.m;
        if (gVar != null) {
            this.g.z(gVar);
        }
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        e eVar;
        if (message.what == 1 && (eVar = this.f980a) != null) {
            eVar.z(-2, "render timeout");
        }
    }
}
