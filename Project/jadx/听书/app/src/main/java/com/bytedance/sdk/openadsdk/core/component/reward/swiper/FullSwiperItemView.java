package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.g.m;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.y;
import com.bytedance.sdk.openadsdk.core.nativeexpress.uy;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.video.g.z;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.res.gc;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class FullSwiperItemView extends FrameLayout implements l.z, uy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f964a;
    public FrameLayout dl;
    public TTProgressBar e;
    private float fo;
    private z fv;
    public FrameLayout g;
    public FrameLayout gc;
    private float gz;
    private com.bytedance.sdk.openadsdk.core.component.reward.m.z i;
    private boolean js;
    private FullRewardExpressView kb;
    private boolean ls;
    public FrameLayout m;
    private final l p;
    private boolean pf;
    private g q;
    private int tb;
    private com.bytedance.sdk.openadsdk.core.component.reward.swiper.z uy;
    private int v;
    private Context wp;
    public ViewGroup z;

    public interface g {
        void z(View view, float f, float f2);
    }

    public interface z {
        void z();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void dl(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void fo() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void g(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void gc() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public long getActualPlayDuration() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void kb() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void m() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void setPauseFromExpressView(boolean z2) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(float f) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(int i, String str) {
    }

    public FullSwiperItemView(Context context, com.bytedance.sdk.openadsdk.core.component.reward.swiper.z zVar, float f, float f2) {
        super(context);
        this.p = new l(Looper.getMainLooper(), this);
        this.uy = zVar;
        this.gz = f;
        this.fo = f2;
        this.wp = context;
        setBackgroundColor(0);
        wp();
        this.tb = eo.fo(zVar.z());
        this.js = zw.g().z(zVar.z(), this.tb);
        i();
        this.kb = new FullRewardExpressView(this.z.getContext(), this.uy.z(), com.bytedance.sdk.openadsdk.core.un.l.z(8, String.valueOf(this.tb), this.gz, this.fo), this.uy.g(), this.js, null);
    }

    public void wp() {
        View viewWp = gc.wp(this.wp);
        addView(viewWp);
        this.z = (ViewGroup) viewWp.findViewById(2114387892);
        this.g = (FrameLayout) viewWp.findViewById(2114387778);
        this.dl = (FrameLayout) viewWp.findViewById(2114387812);
        this.f964a = (FrameLayout) viewWp.findViewById(2114387670);
        this.gc = (FrameLayout) viewWp.findViewById(2114387821);
        this.m = (FrameLayout) viewWp.findViewById(2114387679);
        this.e = (TTProgressBar) viewWp.findViewById(2114387767);
    }

    public void i() {
        na naVarZ = this.uy.z();
        if (naVarZ == null) {
            return;
        }
        float fTk = naVarZ.tk();
        int iZr = naVarZ.zr();
        float fLa = naVarZ.la();
        float[] fArrZ = com.bytedance.sdk.openadsdk.core.component.reward.gc.g.z(this.wp.getApplicationContext(), naVarZ.tk(), naVarZ.zr());
        float f = fArrZ[0];
        float f2 = fArrZ[1];
        if (fTk == 100.0f) {
            this.gz = f;
            this.fo = f2;
            return;
        }
        int[] iArrZ = com.bytedance.sdk.openadsdk.core.component.reward.gc.g.z(this.wp.getApplicationContext(), fTk, fLa, iZr);
        int i = iArrZ[0];
        int i2 = iArrZ[1];
        int i3 = iArrZ[2];
        int i4 = iArrZ[3];
        this.gz = (int) ((f - i) - i3);
        this.fo = (int) ((f2 - i2) - i4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
    }

    public void v() {
        if (this.uy == null) {
            return;
        }
        this.e.setVisibility(0);
        this.kb.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
            public void z(View view, float f, float f2) {
                if (FullSwiperItemView.this.q != null) {
                    FullSwiperItemView.this.q.z(view, f, f2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
            public void z(View view, int i) {
                super.z(view, i);
            }
        });
        this.kb.setExpressVideoListenerProxy(this);
        this.kb.setInteractListener(this.fv);
        this.kb.setOnVideoSizeChangeListener(new FullRewardExpressView.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.z
            public void z(int i) {
                FullSwiperItemView.this.v = i;
            }
        });
        if (this.kb.getParent() != null) {
            ((ViewGroup) this.kb.getParent()).removeView(this.kb);
        }
        this.gc.addView(this.kb);
        this.i = new com.bytedance.sdk.openadsdk.core.component.reward.m.z(this.z.getContext(), this.dl, this.uy.z(), null);
        this.i.z(new dl(this.uy.gc(), y.dl(this.uy.z()), new dl.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.3
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.dl.z
            public void z() {
                if (FullSwiperItemView.this.wp instanceof TTBaseVideoActivity) {
                    ((TTBaseVideoActivity) FullSwiperItemView.this.wp).zx();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.dl.z
            public void z(long j, long j2) {
                m mVarEc;
                if (FullSwiperItemView.this.kb == null || !(FullSwiperItemView.this.wp instanceof TTBaseVideoActivity) || (mVarEc = ((TTBaseVideoActivity) FullSwiperItemView.this.wp).ec()) == null) {
                    return;
                }
                mVarEc.g(j);
                FullSwiperItemView.this.kb.z(String.valueOf(mVarEc.h()), (int) (mVarEc.gk() / 1000), 0, j == j2 || mVarEc.mc());
            }
        }, this.p));
        this.i.g(this.js);
        this.kb.setVideoController(this.i);
        this.uy.z(this.dl, this.f964a, this.kb);
        this.kb.p();
        this.kb.fv();
    }

    public void g(boolean z2) {
        FullRewardExpressView fullRewardExpressView = this.kb;
        if (fullRewardExpressView == null) {
            return;
        }
        if (fullRewardExpressView.q()) {
            Context context = this.wp;
            if (context instanceof TTBaseVideoActivity) {
                ((TTBaseVideoActivity) context).js();
            }
        } else {
            this.kb.z((ViewGroup) this.g, false);
        }
        this.pf = true;
        this.uy.dl(z2);
        pf();
        this.e.setVisibility(8);
    }

    public void pf() {
        if (this.i != null && this.pf) {
            this.uy.fo();
            this.kb.ls();
            this.ls = true;
            if (na.g(this.uy.z())) {
                this.p.sendEmptyMessageDelayed(102, 5000L);
            }
            this.uy.z(this.kb);
            if (this.kb.q()) {
                return;
            }
            this.i.z(this.uy.uy());
        }
    }

    public void ls() {
        com.bytedance.sdk.openadsdk.core.component.reward.m.z zVar = this.i;
        if (zVar == null) {
            return;
        }
        zVar.m();
    }

    public void p() {
        com.bytedance.sdk.openadsdk.core.component.reward.m.z zVar = this.i;
        if (zVar != null) {
            zVar.gz();
        }
    }

    public void fv() {
        l lVar = this.p;
        if (lVar != null) {
            lVar.removeMessages(102);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(boolean z2) {
        if (this.js != z2) {
            this.js = z2;
            com.bytedance.sdk.openadsdk.core.component.reward.m.z zVar = this.i;
            if (zVar != null) {
                zVar.g(z2);
            }
            Context context = this.wp;
            if (context instanceof TTBaseVideoActivity) {
                ((TTBaseVideoActivity) context).gb().z().g();
            }
            z zVar2 = this.fv;
            if (zVar2 != null) {
                zVar2.z();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void e() {
        v.z().dl(this.uy.z(), "stats_reward_full_click_express_close");
        Context context = this.wp;
        if (context instanceof TTBaseVideoActivity) {
            ((TTBaseVideoActivity) context).gb().z().z();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            na naVarZ = this.uy.z();
            if (naVarZ != null && naVarZ.dp() != null) {
                jSONObject.put("refresh_num", this.uy.z().dp().dl());
            }
        } catch (JSONException e) {
            wp.z(e);
        }
        v.z().z(this.uy.z(), "stats_reward_full_click_native_close", jSONObject);
        z zVar = this.fv;
        if (zVar != null) {
            zVar.z();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void gz() {
        z zVar = this.fv;
        if (zVar != null) {
            zVar.z();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            na naVarZ = this.uy.z();
            if (naVarZ != null && naVarZ.dp() != null) {
                jSONObject.put("refresh_num", this.uy.z().dp().dl());
            }
        } catch (JSONException e) {
            wp.z(e);
        }
        v.z().z(this.uy.z(), "stats_reward_full_click_express_close", jSONObject);
        Context context = this.wp;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public long z() {
        return this.i.kb();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public int g() {
        com.bytedance.sdk.openadsdk.core.component.reward.m.z zVar = this.i;
        if (zVar == null || !this.ls) {
            return 2;
        }
        if (zVar.sv()) {
            return 5;
        }
        if (this.i.iq()) {
            return 1;
        }
        if (this.i.f()) {
            return 2;
        }
        this.i.io();
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public int dl() {
        com.bytedance.sdk.openadsdk.core.component.reward.m.z zVar = this.i;
        if (zVar == null) {
            return 0;
        }
        return (int) (zVar.kb() / 1000);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void uy() {
        com.bytedance.sdk.openadsdk.core.component.reward.a.z zVarGb;
        z zVar = this.fv;
        if (zVar != null) {
            zVar.z();
        }
        Context context = this.wp;
        if (!(context instanceof TTBaseVideoActivity) || (zVarGb = ((TTBaseVideoActivity) context).gb()) == null || zVarGb.z() == null) {
            return;
        }
        zVarGb.z().dl();
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        if (message.what != 102) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.swiper.z zVar = this.uy;
        if (zVar != null) {
            zVar.e();
        }
        Context context = this.wp;
        if (context instanceof TTBaseVideoActivity) {
            ((TTBaseVideoActivity) context).kb();
        }
        z zVar2 = this.fv;
        if (zVar2 != null) {
            zVar2.z();
        }
    }

    private static class dl implements z.InterfaceC0210z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f965a;
        private boolean dl = false;
        private final z g;
        private final l gc;
        private final z.InterfaceC0210z z;

        interface z {
            void z();

            void z(long j, long j2);
        }

        dl(z.InterfaceC0210z interfaceC0210z, int i, z zVar, l lVar) {
            this.z = interfaceC0210z;
            this.g = zVar;
            this.f965a = i;
            this.gc = lVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
        public void z() {
            this.dl = false;
            z.InterfaceC0210z interfaceC0210z = this.z;
            if (interfaceC0210z != null) {
                interfaceC0210z.z();
            }
            z zVar = this.g;
            if (zVar != null) {
                zVar.z();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
        public void z(int i, String str) {
            this.dl = false;
            z.InterfaceC0210z interfaceC0210z = this.z;
            if (interfaceC0210z != null) {
                interfaceC0210z.z(i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
        public void g() {
            z.InterfaceC0210z interfaceC0210z = this.z;
            if (interfaceC0210z != null) {
                interfaceC0210z.g();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
        public void z(long j, long j2) {
            this.gc.removeMessages(102);
            z.InterfaceC0210z interfaceC0210z = this.z;
            if (interfaceC0210z != null) {
                interfaceC0210z.z(j, j2);
            }
            z zVar = this.g;
            if (zVar != null) {
                zVar.z(j, j2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
        public void dl() {
            z.InterfaceC0210z interfaceC0210z = this.z;
            if (interfaceC0210z != null) {
                interfaceC0210z.dl();
            }
        }
    }

    public void setOnSwiperItemInteractListener(z zVar) {
        this.fv = zVar;
    }

    public void setOnSwiperItemRenderResultListener(g gVar) {
        this.q = gVar;
    }

    public void js() {
        FullRewardExpressView fullRewardExpressView = this.kb;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.i();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.m.z zVar = this.i;
        if (zVar != null) {
            zVar.fo();
        }
    }
}
