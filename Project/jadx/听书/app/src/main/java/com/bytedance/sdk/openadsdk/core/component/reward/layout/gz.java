package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.iq.ec;
import com.bytedance.sdk.openadsdk.core.iq.eo;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class gz extends g {
    private ImageView fv;
    private TextView io;
    private RelativeLayout iq;
    private TextView js;
    private TextView ls;
    private TextView p;
    private RelativeLayout pf;
    private RelativeLayout q;
    private TextView tb;
    private boolean uf;
    private RoundImageView v;
    private TextView zw;

    public gz(TTBaseVideoActivity tTBaseVideoActivity, na naVar, boolean z) {
        super(tTBaseVideoActivity, naVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.g
    public void z() {
        super.z();
        this.gz = (RelativeLayout) this.g.findViewById(2114387662);
        this.fo = (FrameLayout) this.g.findViewById(2114387754);
        this.uy = (TextView) this.g.findViewById(2114387658);
        this.v = (RoundImageView) this.g.findViewById(2114387882);
        this.pf = (RelativeLayout) this.g.findViewById(2114387911);
        this.ls = (TextView) this.g.findViewById(2114387921);
        this.p = (TextView) this.g.findViewById(2114387850);
        this.fv = (ImageView) this.g.findViewById(2114387881);
        this.js = (TextView) this.g.findViewById(2114387781);
        this.tb = (TextView) this.g.findViewById(2114387640);
        this.q = (RelativeLayout) this.g.findViewById(2114387663);
        this.iq = (RelativeLayout) this.g.findViewById(2114387835);
        this.kb = (RelativeLayout) this.g.findViewById(2114387717);
        this.zw = (TextView) this.g.findViewById(2114387752);
        this.io = (TextView) this.g.findViewById(2114387716);
        oq.z(this.uy, this.dl);
        kb();
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.dl)) {
            String strFo = eo.fo(this.dl);
            if (!TextUtils.isEmpty(strFo) && this.v != null) {
                oq.z((View) this.pf, 0);
                com.bytedance.sdk.openadsdk.gz.g.z(strFo).to(this.v);
            } else {
                oq.z((View) this.pf, 8);
            }
            if (this.ls != null) {
                this.ls.setText(eo.dl(this.dl));
            }
            if (this.p != null) {
                int iA = eo.a(this.dl);
                if (iA < 0) {
                    this.p.setVisibility(4);
                    oq.z((View) this.fv, 4);
                } else {
                    this.p.setText(String.format(tb.z(this.g, "tt_live_fans_text"), iA > 10000 ? (iA / 10000.0f) + "w" : String.valueOf(iA)));
                }
            }
            if (this.js != null) {
                int iGc = eo.gc(this.dl);
                if (iGc < 0) {
                    this.js.setVisibility(4);
                    oq.z((View) this.fv, 4);
                } else {
                    this.js.setText(String.format(tb.z(this.g, "tt_live_watch_text"), iGc > 10000 ? (iGc / 10000.0f) + "w" : String.valueOf(iGc)));
                }
            }
            if (this.tb != null) {
                this.tb.setText(eo.m(this.dl));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.g
    public void z(com.bytedance.sdk.openadsdk.core.g.g gVar, com.bytedance.sdk.openadsdk.core.g.g gVar2) {
        oq.z((View) this.zw, (View.OnTouchListener) gVar, "TTBaseVideoActivity#mLiveLoadingBtn");
        oq.z((View) this.zw, (View.OnClickListener) gVar, "TTBaseVideoActivity#mLiveLoadingBtn");
        oq.z((View) this.io, (View.OnClickListener) gVar, "TTBaseVideoActivity#mLiveVideoBtn");
        oq.z((View) this.io, (View.OnClickListener) gVar, "TTBaseVideoActivity#mLiveVideoBtn");
        z(gVar2);
        z((View.OnTouchListener) gVar2);
    }

    private void z(View.OnTouchListener onTouchListener) {
        oq.z(this.gz, onTouchListener, "TTBaseVideoActivity#mRlDownloadBar");
        oq.z(this.fo, onTouchListener, "TTBaseVideoActivity#mVideoNativeFrame");
        oq.z(this.tb, onTouchListener, "TTBaseVideoActivity#mLiveDesc");
        oq.z(this.p, onTouchListener, "TTBaseVideoActivity#mLiveFans");
        oq.z(this.js, onTouchListener, "TTBaseVideoActivity#mLiveWatch");
        oq.z(this.ls, onTouchListener, "TTBaseVideoActivity#mLiveName");
        oq.z(this.v, onTouchListener, "TTBaseVideoActivity#mLiveIcon");
        oq.z(this.kb, onTouchListener, "TTBaseVideoActivity#mLiveBtnLayout");
    }

    private void z(com.bytedance.sdk.openadsdk.core.g.g gVar) {
        z(this.fo, gVar, "click_live_feed");
        z(this.tb, gVar, "click_live_author_description");
        z(this.p, gVar, "click_live_author_follower_count");
        z(this.js, gVar, "click_live_author_following_count");
        z(this.ls, gVar, "click_live_author_nickname");
        z(this.v, gVar, "click_live_avata");
        z(this.gz, gVar, "click_live_button");
        z(this.kb, gVar, "click_live_btn_layout");
    }

    private void z(View view, final com.bytedance.sdk.openadsdk.core.g.g gVar, final String str) {
        if (view == null || gVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        view.setOnClickListener(new com.bytedance.sdk.openadsdk.core.g.g(this.g, this.dl, this.m ? "rewarded_video" : "fullscreen_interstitial_ad", this.m ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.gz.1
            @Override // com.bytedance.sdk.openadsdk.core.g.g, com.bytedance.sdk.openadsdk.core.g.a
            public void z(View view2, com.bytedance.sdk.openadsdk.core.iq.uy uyVar) {
                HashMap map = new HashMap();
                map.put("click_live_element", str);
                ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) gVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z(map);
                gVar.z(view2, uyVar);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.g
    public void dl(int i) {
        oq.z((View) this.q, i);
        oq.z((View) this.iq, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.g
    public void a(int i) {
        if (this.uf) {
            return;
        }
        oq.z((View) this.kb, i);
    }

    public void z(int i, int i2) {
        TextView textView;
        if (i != 0) {
            this.uf = true;
            oq.z((View) this.kb, 8);
            return;
        }
        oq.z((View) this.kb, 0);
        if (i2 >= 0 && com.bytedance.sdk.openadsdk.core.live.g.z().g(this.dl) && ec.z(this.dl) && ec.gc(this.dl) == 3 && (textView = (TextView) this.g.findViewById(2114387716)) != null) {
            textView.setText(String.format(tb.z(this.g, "tt_reward_auto_jump_live"), i2 + "s"));
        }
    }
}
