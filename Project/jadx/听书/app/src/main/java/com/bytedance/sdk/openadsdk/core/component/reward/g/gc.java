package com.bytedance.sdk.openadsdk.core.component.reward.g;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.media3.common.C;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.top.RewardBrowserMixTopLayoutImpl;
import com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl;
import com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.widget.TopProxyLayout;

/* JADX INFO: loaded from: classes2.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f957a;
    private com.bytedance.sdk.openadsdk.core.component.reward.top.z dl;
    private com.bytedance.sdk.openadsdk.core.component.reward.top.m e;
    private com.bytedance.sdk.openadsdk.core.component.reward.top.gc fo;
    private na g;
    private UgenBanner gc;
    private com.bytedance.sdk.openadsdk.core.component.reward.top.a gz;
    private com.bytedance.sdk.openadsdk.core.g.g m;
    private final TTBaseVideoActivity z;

    public gc(TTBaseVideoActivity tTBaseVideoActivity) {
        this.z = tTBaseVideoActivity;
    }

    public void z(na naVar, g gVar, boolean z, com.bytedance.sdk.openadsdk.core.g.g gVar2) {
        this.g = naVar;
        this.m = gVar2;
        gz();
        this.e = new com.bytedance.sdk.openadsdk.core.component.reward.top.m(this.z, this.g, gVar, this, z);
        this.fo = new com.bytedance.sdk.openadsdk.core.component.reward.top.gc(this.z, this.g, gVar, this, z);
        this.gz = new com.bytedance.sdk.openadsdk.core.component.reward.top.a(this.z, this.g, gVar, this, z);
        z(1);
    }

    private void gz() {
        TopProxyLayout topProxyLayout = (TopProxyLayout) this.z.findViewById(2114387721);
        if (topProxyLayout != null) {
            z(topProxyLayout);
        }
        this.f957a = (TextView) this.z.findViewById(2114387801);
        this.gc = (UgenBanner) this.z.findViewById(2114387901);
    }

    public void z(TopProxyLayout topProxyLayout) {
        View viewZ;
        if (js.kb(this.g)) {
            viewZ = new RewardBrowserMixTopLayoutImpl(topProxyLayout.getContext()).z(this.g);
        } else {
            viewZ = new TopLayoutImpl(topProxyLayout.getContext()).z(this.g);
        }
        if (viewZ != null) {
            this.dl = (com.bytedance.sdk.openadsdk.core.component.reward.top.z) viewZ;
        } else {
            wp.a("RewardFullTopProxyManager", "view not implements ITopLayout interface");
        }
        ViewParent parent = topProxyLayout.getParent();
        if (parent instanceof ViewGroup) {
            z(topProxyLayout, viewZ, (ViewGroup) parent);
        }
    }

    private void z(TopProxyLayout topProxyLayout, View view, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(topProxyLayout);
        viewGroup.removeViewInLayout(topProxyLayout);
        ViewGroup.LayoutParams layoutParams = topProxyLayout.getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
    }

    public void z(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.z zVar = this.dl;
        if (zVar != null) {
            zVar.setVisible(z);
        }
    }

    public void g(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.z zVar = this.dl;
        if (zVar != null) {
            zVar.setShowDislike(z);
        }
    }

    public void dl(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.z zVar = this.dl;
        if (zVar != null) {
            zVar.setDislikeLeft(z);
        }
    }

    public void a(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.z zVar = this.dl;
        if (zVar != null) {
            zVar.setSoundMute(z);
        }
    }

    public void gc(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.z zVar = this.dl;
        if (zVar != null) {
            zVar.setShowSound(z);
        }
    }

    public void m(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.z zVar = this.dl;
        if (zVar != null) {
            zVar.setShowBack(z);
        }
    }

    public void z(boolean z, String str, String str2, boolean z2, boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.z zVar = this.dl;
        if (zVar != null) {
            zVar.z(z, str, str2, z2, z3);
        }
    }

    public void z(String str, String str2, boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.z zVar = this.dl;
        if (zVar != null) {
            zVar.z(str, str2, z);
        }
    }

    public void z() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.z zVar = this.dl;
        if (zVar != null) {
            zVar.z();
        }
    }

    public void g() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.z zVar = this.dl;
        if (zVar != null) {
            zVar.g();
        }
    }

    public void dl() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.z zVar = this.dl;
        if (zVar != null) {
            zVar.dl();
        }
    }

    public View a() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.z zVar = this.dl;
        if (zVar != null) {
            return zVar.getCloseButton();
        }
        return null;
    }

    public boolean gc() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.z zVar = this.dl;
        if (zVar != null) {
            return zVar.getSkipOrCloseVisible();
        }
        return false;
    }

    public void z(int i) {
        if (i == 2) {
            z(this.gz);
        } else if (i == 4) {
            z(this.fo);
        } else {
            z(this.e);
        }
    }

    public void z(com.bytedance.sdk.openadsdk.core.component.reward.top.g gVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.z zVar = this.dl;
        if (zVar != null) {
            zVar.setListener(gVar);
        }
    }

    public void e(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.z zVar = this.dl;
        if (zVar != null) {
            zVar.setShowAgain(z);
        }
    }

    public void z(String str) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.z zVar = this.dl;
        if (zVar != null) {
            zVar.setPlayAgainEntranceText(str);
        }
    }

    public void g(String str) {
        TextView textView = this.f957a;
        if (textView != null) {
            textView.setText(str);
            this.f957a.setVisibility(0);
            this.f957a.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.g.gc.1
                @Override // java.lang.Runnable
                public void run() {
                    gc.this.f957a.setVisibility(8);
                }
            }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        }
    }

    public void m() {
        UgenBanner ugenBanner = this.gc;
        if (ugenBanner == null) {
            return;
        }
        ugenBanner.z(this.g, this.m);
    }

    public void e() {
        UgenBanner ugenBanner = this.gc;
        if (ugenBanner == null) {
            return;
        }
        ugenBanner.z();
    }

    public void z(na naVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.m mVar = this.e;
        if (mVar != null) {
            mVar.z(naVar);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.top.a aVar = this.gz;
        if (aVar != null) {
            aVar.z(naVar);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.top.gc gcVar = this.fo;
        if (gcVar != null) {
            gcVar.z(naVar);
        }
    }
}
