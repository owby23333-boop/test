package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.g.v;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.multipro.g.z;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.p.z;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private String e;
    private FullRewardExpressView fo;
    private final TTBaseVideoActivity gc;
    private ViewGroup gz;
    private na m;
    com.bytedance.sdk.openadsdk.core.kb.g.dl z;
    boolean g = false;
    boolean dl = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f963a = false;

    public gc(TTBaseVideoActivity tTBaseVideoActivity) {
        this.gc = tTBaseVideoActivity;
    }

    public void z(na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, String str, boolean z, String str2) {
        if (this.f963a) {
            return;
        }
        this.f963a = true;
        this.m = naVar;
        this.e = str;
        this.fo = new FullRewardExpressView(this.gc, naVar, gVar, str, z, str2);
        FrameLayout expressFrameContainer = this.gc.mc().getExpressFrameContainer();
        this.gz = expressFrameContainer;
        expressFrameContainer.addView(this.fo, new FrameLayout.LayoutParams(-2, -2));
        this.fo.setEasyPlayableContainer(this.gc.mc().getEasyPlayableContainer());
    }

    public void z(CharSequence charSequence, int i, int i2, boolean z) {
        if (this.fo == null || !m()) {
            return;
        }
        this.fo.z(charSequence, i, i2, z);
    }

    public FrameLayout z() {
        FullRewardExpressView fullRewardExpressView = this.fo;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getVideoFrameLayout();
        }
        return null;
    }

    public boolean g() {
        return this.g;
    }

    public void z(boolean z) {
        this.g = z;
    }

    public boolean dl() {
        return this.dl;
    }

    public void g(boolean z) {
        this.dl = z;
    }

    public void z(com.bytedance.sdk.openadsdk.core.nativeexpress.gc gcVar, com.bytedance.sdk.openadsdk.core.nativeexpress.a aVar) {
        na naVar;
        if (this.fo == null || (naVar = this.m) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVarZ = z(naVar);
        this.z = dlVarZ;
        if (dlVarZ != null) {
            dlVarZ.z();
            if (this.fo.getContext() != null && (this.fo.getContext() instanceof Activity)) {
                this.z.z((Activity) this.fo.getContext());
            }
        }
        com.bytedance.sdk.openadsdk.core.i.a.z(this.m);
        EmptyView emptyViewZ = z((ViewGroup) this.fo);
        if (emptyViewZ == null) {
            na naVar2 = this.m;
            EmptyView emptyView = new EmptyView(this.gc, this.fo, naVar2 != null ? naVar2.wk() : 1000);
            emptyView.z(this.m, this.e);
            this.fo.addView(emptyView);
            emptyViewZ = emptyView;
        }
        emptyViewZ.setNeedCheckingShow(false);
        emptyViewZ.setCallback(new EmptyView.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.gc.1
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void z(View view, Map<String, Object> map) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void z(boolean z) {
                if (gc.this.z == null || !z) {
                    return;
                }
                gc.this.z.z();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void z() {
                if (gc.this.z != null) {
                    gc.this.z.z(false);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void g() {
                if (gc.this.z != null) {
                    gc.this.z.g();
                }
            }
        });
        gcVar.z(this.fo);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) gcVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.z);
        this.fo.setClickListener(gcVar);
        aVar.z(this.fo);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) aVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.z);
        this.fo.setClickCreativeListener(aVar);
        emptyViewZ.setNeedCheckingShow(false);
        z(this.z, this.fo);
    }

    private void z(com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar, NativeExpressView nativeExpressView) {
        if (dlVar == null || nativeExpressView == null) {
            return;
        }
        na naVar = this.m;
        final String strMj = naVar != null ? naVar.mj() : "";
        dlVar.z(new com.bytedance.sdk.openadsdk.core.kb.g.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.gc.2
            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void z() {
                gc.this.gc.z("点击开始下载");
                z.C0193z.z(strMj, 1, 0);
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void z(long j, long j2, String str, String str2) {
                if (j > 0) {
                    int i = (int) ((j2 * 100) / j);
                    gc.this.gc.z("已下载" + i + "%");
                    z.C0193z.z(strMj, 3, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void g(long j, long j2, String str, String str2) {
                gc.this.gc.z("下载暂停");
                if (j > 0) {
                    z.C0193z.z(strMj, 2, (int) ((j2 * 100) / j));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void dl(long j, long j2, String str, String str2) {
                gc.this.gc.z("下载失败");
                if (j > 0) {
                    z.C0193z.z(strMj, 4, (int) ((j2 * 100) / j));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void z(long j, String str, String str2) {
                gc.this.gc.z("点击安装");
                z.C0193z.z(strMj, 5, 100);
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void z(String str, String str2) {
                gc.this.gc.z("点击打开");
                z.C0193z.z(strMj, 6, 100);
            }
        });
    }

    private com.bytedance.sdk.openadsdk.core.kb.g.dl z(na naVar) {
        if (naVar.lt() == 4) {
            return com.bytedance.sdk.openadsdk.core.kb.gz.z((Context) this.gc, naVar, this.e, false);
        }
        return null;
    }

    private EmptyView z(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public void z(com.bytedance.sdk.openadsdk.core.nativeexpress.uy uyVar) {
        FullRewardExpressView fullRewardExpressView = this.fo;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.setExpressVideoListenerProxy(uyVar);
    }

    public void z(com.bytedance.sdk.openadsdk.core.nativeexpress.z zVar) {
        FullRewardExpressView fullRewardExpressView = this.fo;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.setExpressInteractionListener(zVar);
    }

    public void a() {
        FullRewardExpressView fullRewardExpressView = this.fo;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.i();
        }
    }

    public void gc() {
        FullRewardExpressView fullRewardExpressView = this.fo;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.fv();
        }
    }

    public boolean m() {
        FullRewardExpressView fullRewardExpressView = this.fo;
        return (fullRewardExpressView == null || fullRewardExpressView.q()) ? false : true;
    }

    public void e() {
        FullRewardExpressView fullRewardExpressView = this.fo;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.ls();
    }

    public void gz() {
        FullRewardExpressView fullRewardExpressView = this.fo;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.p();
            this.fo.fv();
        }
    }

    public int fo() {
        FullRewardExpressView fullRewardExpressView = this.fo;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getDynamicShowType();
        }
        return 0;
    }

    public void z(com.bykv.vk.openvk.component.video.api.a.dl dlVar) {
        FullRewardExpressView fullRewardExpressView = this.fo;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.setVideoController(dlVar);
        }
    }

    public void dl(boolean z) {
        ViewGroup viewGroup = this.gz;
        if (viewGroup != null) {
            viewGroup.setVisibility(z ? 0 : 8);
        }
    }

    public void z(String str, JSONObject jSONObject) {
        mc jsObject;
        FullRewardExpressView fullRewardExpressView = this.fo;
        if (fullRewardExpressView == null || (jsObject = fullRewardExpressView.getJsObject()) == null || this.gc.isFinishing()) {
            return;
        }
        jsObject.z(str, jSONObject);
    }

    public void z(z.InterfaceC0190z interfaceC0190z) {
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.z(interfaceC0190z);
        }
    }

    public boolean uy() {
        FullRewardExpressView fullRewardExpressView = this.fo;
        if (fullRewardExpressView == null) {
            return true;
        }
        return fullRewardExpressView.v();
    }

    public v kb() {
        FullRewardExpressView fullRewardExpressView = this.fo;
        if (fullRewardExpressView == null) {
            return null;
        }
        return fullRewardExpressView.getRenderResult();
    }

    public FullRewardExpressView wp() {
        return this.fo;
    }

    public void z(com.bytedance.sdk.openadsdk.core.component.reward.gc.dl dlVar) {
        if (this.fo != null) {
            this.fo.z((int) (dlVar.z() / 1000), dlVar.gc(), dlVar.g(), dlVar.a());
        }
    }

    public void i() {
        FullRewardExpressView fullRewardExpressView = this.fo;
        if (fullRewardExpressView != null && fullRewardExpressView.getJsObject() != null) {
            this.fo.getJsObject().e(true);
        }
        z("isVerifyReward", (JSONObject) null);
    }
}
