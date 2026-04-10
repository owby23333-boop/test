package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.sy;
import com.bytedance.sdk.openadsdk.core.un.un;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class m extends g {
    private final e e;
    private PlayableFeedWebView gc;
    private final com.bytedance.sdk.openadsdk.core.zw.g m;

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g
    protected int z() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g
    public boolean z(int i, int i2) {
        return true;
    }

    public m(na naVar, boolean z, z zVar, dl dlVar) {
        super(naVar, zVar, dlVar);
        this.e = new e() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.m.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e
            public void z() {
                if (m.this.gc != null) {
                    m.this.gc.m();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e
            public void z(boolean z2) {
                if (m.this.gc != null) {
                    m.this.gc.z(z2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e
            public void g() {
                if (m.this.gc != null) {
                    m.this.gc.e();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e
            public void dl() {
                m.this.gc.gz();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e
            public void a() {
                if (sy.z() && m.this.m != null) {
                    m.this.m.z(m.this.z);
                }
            }
        };
        this.m = new com.bytedance.sdk.openadsdk.core.zw.g(naVar);
        this.f1334a = z;
    }

    public boolean dl() {
        return sy.g(this.z);
    }

    public void z(final ViewGroup viewGroup, final View view, final boolean z) {
        if (viewGroup == null) {
            HashMap map = new HashMap();
            map.put("render_type", Integer.valueOf(z()));
            map.put("error_code", 100);
            this.dl.z(false, (Map<String, Object>) map);
            return;
        }
        this.dl.z(z());
        PlayableFeedWebView playableFeedWebView = new PlayableFeedWebView(this.m, viewGroup);
        this.gc = playableFeedWebView;
        this.m.z(playableFeedWebView);
        this.gc.setMaterialMeta(un.z(this.z));
        this.gc.setEasyPlayableListener(this.g);
        viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.m.2
            @Override // java.lang.Runnable
            public void run() {
                m mVar = m.this;
                mVar.z(viewGroup, view, mVar.gc, z, false, null, null);
            }
        });
    }

    public void a() {
        PlayableFeedWebView playableFeedWebView = this.gc;
        if (playableFeedWebView != null) {
            playableFeedWebView.destroy();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g
    public e g() {
        return this.e;
    }

    public void z(com.bytedance.sdk.openadsdk.io.z.g.z.g gVar) {
        this.m.z(gVar);
    }
}
