package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
class wp extends BackupView {
    private static ls[] i = {new ls(2, 3.0241935f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 124), new ls(3, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300), new ls(4, 1.4044944f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME), new ls(16, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300), new ls(5, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300), new ls(15, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300)};
    private TextView fv;
    private TextView js;
    private NativeExpressView ls;
    private com.bytedance.sdk.openadsdk.core.kb.g.dl p;
    private View pf;
    private ImageView tb;
    private int v;

    wp(Context context) {
        super(context);
        this.z = context;
    }

    void z(na naVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar) {
        setBackgroundColor(-1);
        this.g = naVar;
        this.ls = nativeExpressView;
        this.p = dlVar;
        int iFo = eo.fo(this.g);
        this.v = iFo;
        g(iFo);
        int iGz = eo.gz(this.g);
        dl(iGz);
        gc(com.bytedance.sdk.openadsdk.core.uy.ls().bv());
        int i2 = iGz != 9 ? -2 : -1;
        this.ls.addView(this, new ViewGroup.LayoutParams(i2, i2));
    }

    private void dl(int i2) {
        ls lsVarA = a(this.g.ou());
        this.m = oq.dl(this.z, this.ls.getExpectExpressWidth());
        this.e = oq.dl(this.z, this.ls.getExpectExpressHeight());
        if (this.m <= 0) {
            this.m = oq.a(this.z);
        }
        if (this.e <= 0) {
            this.e = Float.valueOf(this.m / lsVarA.dl).intValue();
        }
        if (this.m > 0 && this.m > oq.a(this.z)) {
            this.m = oq.a(this.z);
            this.e = Float.valueOf(this.e * (oq.a(this.z) / this.m)).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.m, this.e);
        }
        layoutParams.width = this.m;
        layoutParams.height = this.e;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        if (i2 == 9) {
            this.gc = "draw_ad";
            if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.g)) {
                kb();
                return;
            } else {
                gz();
                return;
            }
        }
        this.gc = "embeded_ad";
        int iOu = this.g.ou();
        if (iOu == 2) {
            dl();
            return;
        }
        if (iOu == 3) {
            m();
            return;
        }
        if (iOu == 4) {
            a();
            return;
        }
        if (iOu == 5) {
            fo();
            return;
        }
        if (iOu == 15) {
            e();
            return;
        }
        if (iOu == 16) {
            uy();
            return;
        }
        if (iOu == 131) {
            uy();
        } else if (iOu == 166) {
            wp();
        } else {
            uy();
        }
    }

    private ls a(int i2) {
        ls[] lsVarArr = i;
        ls lsVar = lsVarArr[0];
        try {
            for (ls lsVar2 : lsVarArr) {
                if (lsVar2.z == i2) {
                    return lsVar2;
                }
            }
            return lsVar;
        } catch (Throwable unused) {
            return lsVar;
        }
    }

    private void z(ImageView imageView) {
        com.bytedance.sdk.openadsdk.gz.g.z(this.g.jz().get(0)).to(imageView);
        if (com.bytedance.sdk.openadsdk.gc.z.a(this.g)) {
            UpieImageView upieImageView = new UpieImageView(imageView.getContext(), com.bytedance.sdk.openadsdk.gc.z.fo(this.g), com.bytedance.sdk.openadsdk.gc.z.uy(this.g));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.bytedance.sdk.openadsdk.gc.z.z(imageView, upieImageView);
        }
    }

    private void dl() {
        View viewXl = com.bytedance.sdk.openadsdk.res.gc.xl(this.z);
        this.pf = viewXl;
        addView(viewXl);
        ImageView imageView = (ImageView) this.pf.findViewById(2114387936);
        this.tb = (ImageView) this.pf.findViewById(2114387854);
        this.js = (TextView) this.pf.findViewById(2114387920);
        this.fv = (TextView) this.pf.findViewById(2114387940);
        z((LinearLayout) this.pf.findViewById(2114387660), (TextView) this.pf.findViewById(2114387658), this.g);
        z(imageView);
        this.js.setText(getDescription());
        this.fv.setText(getTitle());
        this.tb.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.wp.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                wp.this.gc();
            }
        });
        z(this, true);
    }

    private void z(View view, TextView textView, na naVar) {
        if (view == null || textView == null) {
            return;
        }
        if (naVar == null) {
            view.setVisibility(0);
            return;
        }
        if (TextUtils.isEmpty(naVar.sa())) {
            view.setVisibility(0);
            textView.setVisibility(8);
            oq.z(view, naVar);
        } else {
            view.setVisibility(8);
            textView.setVisibility(0);
            oq.z(textView, naVar);
        }
    }

    private void a() {
        View viewGb = com.bytedance.sdk.openadsdk.res.gc.gb(this.z);
        this.pf = viewGb;
        addView(viewGb);
        ImageView imageView = (ImageView) this.pf.findViewById(2114387695);
        ImageView imageView2 = (ImageView) this.pf.findViewById(2114387692);
        ImageView imageView3 = (ImageView) this.pf.findViewById(2114387690);
        ImageView imageView4 = (ImageView) this.pf.findViewById(2114387931);
        this.tb = (ImageView) this.pf.findViewById(2114387854);
        this.js = (TextView) this.pf.findViewById(2114387920);
        this.fv = (TextView) this.pf.findViewById(2114387940);
        TextView textView = (TextView) this.pf.findViewById(2114387633);
        oq.z((TextView) this.pf.findViewById(2114387658), this.g);
        com.bytedance.sdk.openadsdk.gz.g.z(this.g.jz().get(0)).to(imageView);
        com.bytedance.sdk.openadsdk.gz.g.z(this.g.jz().get(1)).to(imageView2);
        com.bytedance.sdk.openadsdk.gz.g.z(this.g.jz().get(2)).to(imageView3);
        com.bytedance.sdk.openadsdk.gz.g.z(this.g.kp()).to(imageView4);
        this.tb.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.wp.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                wp.this.gc();
            }
        });
        this.js.setText(getDescription());
        this.fv.setText(getTitle());
        if (!TextUtils.isEmpty(this.g.no())) {
            textView.setText(this.g.no());
        }
        z(this, false);
        z(textView, true);
    }

    private void m() {
        View viewEc = com.bytedance.sdk.openadsdk.res.gc.ec(this.z);
        this.pf = viewEc;
        addView(viewEc);
        this.pf.findViewById(2114387734).setVisibility(8);
        this.pf.findViewById(2114387955).setVisibility(0);
        ImageView imageView = (ImageView) this.pf.findViewById(2114387936);
        this.tb = (ImageView) this.pf.findViewById(2114387854);
        this.js = (TextView) this.pf.findViewById(2114387920);
        this.fv = (TextView) this.pf.findViewById(2114387940);
        TextView textView = (TextView) this.pf.findViewById(2114387633);
        oq.z((TextView) this.pf.findViewById(2114387658), this.g);
        imageView.setAdjustViewBounds(true);
        imageView.setMaxHeight(this.e);
        z(imageView);
        this.tb.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.wp.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                wp.this.gc();
            }
        });
        this.js.setText(getDescription());
        this.fv.setText(getTitle());
        if (!TextUtils.isEmpty(this.g.no())) {
            textView.setText(this.g.no());
        }
        z(this, false);
        z(textView, true);
    }

    private void e() {
        View viewSv = com.bytedance.sdk.openadsdk.res.gc.sv(this.z);
        this.pf = viewSv;
        addView(viewSv);
        this.pf.findViewById(2114387734).setVisibility(0);
        this.pf.findViewById(2114387955).setVisibility(8);
        FrameLayout frameLayout = (FrameLayout) this.pf.findViewById(2114387965);
        ImageView imageView = (ImageView) this.pf.findViewById(2114387913);
        this.tb = (ImageView) this.pf.findViewById(2114387854);
        this.js = (TextView) this.pf.findViewById(2114387920);
        this.fv = (TextView) this.pf.findViewById(2114387940);
        TextView textView = (TextView) this.pf.findViewById(2114387855);
        TextView textView2 = (TextView) this.pf.findViewById(2114387856);
        TextView textView3 = (TextView) this.pf.findViewById(2114387633);
        TextView textView4 = (TextView) this.pf.findViewById(2114387908);
        TTRatingBar tTRatingBar = (TTRatingBar) this.pf.findViewById(2114387874);
        oq.z((TextView) this.pf.findViewById(2114387617), this.g);
        com.bytedance.sdk.openadsdk.gz.g.z(this.g.kp()).to(imageView);
        this.tb.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.wp.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                wp.this.gc();
            }
        });
        int iGc = this.g.c() != null ? this.g.c().gc() : 4;
        textView4.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(iGc)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(iGc);
        tTRatingBar.setStarImageWidth(oq.dl(this.z, 15.0f));
        tTRatingBar.setStarImageHeight(oq.dl(this.z, 14.0f));
        tTRatingBar.setStarImagePadding(oq.dl(this.z, 4.0f));
        tTRatingBar.z();
        textView.setText(getNameOrSource());
        textView2.setText(getTitle());
        this.js.setText(getDescription());
        this.fv.setText(getTitle());
        if (!TextUtils.isEmpty(this.g.no())) {
            textView3.setText(this.g.no());
        }
        View viewZ = z(this.ls);
        if (viewZ != null) {
            int i2 = (this.m * 123) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
            frameLayout.removeAllViews();
            frameLayout.addView(viewZ, new ViewGroup.LayoutParams(i2, (i2 * 16) / 9));
        }
        z(this, false);
        z(textView3, true);
    }

    private void gz() {
        View viewVm = com.bytedance.sdk.openadsdk.res.gc.vm(this.z);
        this.pf = viewVm;
        addView(viewVm);
        FrameLayout frameLayout = (FrameLayout) this.pf.findViewById(2114387734);
        ImageView imageView = (ImageView) this.pf.findViewById(2114387936);
        TextView textView = (TextView) this.pf.findViewById(2114387920);
        TextView textView2 = (TextView) this.pf.findViewById(2114387940);
        TextView textView3 = (TextView) this.pf.findViewById(2114387633);
        TextView textView4 = (TextView) this.pf.findViewById(2114387658);
        textView.setText(getDescription());
        textView2.setText(getTitle());
        oq.z(textView4, this.g);
        if (!TextUtils.isEmpty(this.g.no())) {
            textView3.setText(this.g.no());
        }
        if (!na.g(this.g)) {
            z(imageView);
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        } else {
            imageView.setVisibility(8);
        }
        View viewZ = z(this.ls);
        NativeExpressView nativeExpressView = this.ls;
        if ((nativeExpressView instanceof NativeExpressVideoView) && (viewZ instanceof NativeVideoTsView)) {
            NativeExpressVideoView nativeExpressVideoView = (NativeExpressVideoView) nativeExpressView;
            NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) viewZ;
            nativeVideoTsView.setVideoAdLoadListener(nativeExpressVideoView);
            nativeVideoTsView.setVideoAdInteractionListener(nativeExpressVideoView);
        }
        if (viewZ != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(viewZ, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.pf.setBackgroundColor(-16777216);
        }
        z(textView2, false);
        z(textView, false);
        z(textView3, true);
    }

    private void fo() {
        View viewEc = com.bytedance.sdk.openadsdk.res.gc.ec(this.z);
        this.pf = viewEc;
        addView(viewEc);
        FrameLayout frameLayout = (FrameLayout) this.pf.findViewById(2114387734);
        frameLayout.setVisibility(0);
        this.pf.findViewById(2114387955).setVisibility(8);
        this.tb = (ImageView) this.pf.findViewById(2114387854);
        this.js = (TextView) this.pf.findViewById(2114387920);
        this.fv = (TextView) this.pf.findViewById(2114387940);
        TextView textView = (TextView) this.pf.findViewById(2114387633);
        oq.z((TextView) this.pf.findViewById(2114387658), this.g);
        this.tb.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.wp.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                wp.this.gc();
            }
        });
        this.js.setText(getDescription());
        this.fv.setText(getTitle());
        if (!TextUtils.isEmpty(this.g.no())) {
            textView.setText(this.g.no());
        }
        View viewZ = z(this.ls);
        if (viewZ != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(viewZ, new ViewGroup.LayoutParams(this.m, (this.m * 9) / 16));
        }
        z(this, false);
        z(textView, true);
    }

    private void uy() {
        View viewSv = com.bytedance.sdk.openadsdk.res.gc.sv(this.z);
        this.pf = viewSv;
        addView(viewSv);
        this.pf.findViewById(2114387734).setVisibility(8);
        this.pf.findViewById(2114387955).setVisibility(0);
        ImageView imageView = (ImageView) this.pf.findViewById(2114387936);
        this.tb = (ImageView) this.pf.findViewById(2114387854);
        this.js = (TextView) this.pf.findViewById(2114387920);
        this.fv = (TextView) this.pf.findViewById(2114387940);
        TextView textView = (TextView) this.pf.findViewById(2114387633);
        oq.z((TextView) this.pf.findViewById(2114387658), this.g);
        z(imageView);
        this.tb.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.wp.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                wp.this.gc();
            }
        });
        this.js.setText(getDescription());
        this.fv.setText(getTitle());
        if (!TextUtils.isEmpty(this.g.no())) {
            textView.setText(this.g.no());
        }
        z(this, false);
        z(textView, true);
    }

    private void kb() {
        if (this.g == null) {
            return;
        }
        View viewY = com.bytedance.sdk.openadsdk.res.gc.y(this.z);
        this.pf = viewY;
        addView(viewY);
        FrameLayout frameLayout = (FrameLayout) this.pf.findViewById(2114387765);
        TextView textView = (TextView) this.pf.findViewById(2114387899);
        View view = (RelativeLayout) this.pf.findViewById(2114387650);
        RoundImageView roundImageView = (RoundImageView) this.pf.findViewById(2114387818);
        RelativeLayout relativeLayout = (RelativeLayout) this.pf.findViewById(2114387777);
        TextView textView2 = (TextView) this.pf.findViewById(2114387768);
        TextView textView3 = (TextView) this.pf.findViewById(2114387619);
        TextView textView4 = (TextView) this.pf.findViewById(2114387895);
        ImageView imageView = (ImageView) this.pf.findViewById(2114387881);
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.g)) {
            String strFo = com.bytedance.sdk.openadsdk.core.iq.eo.fo(this.g);
            if (!TextUtils.isEmpty(strFo) && roundImageView != null) {
                oq.z((View) relativeLayout, 0);
                com.bytedance.sdk.openadsdk.gz.g.z(strFo).to(roundImageView);
            } else {
                oq.z((View) relativeLayout, 8);
            }
            if (textView != null) {
                textView.setText(com.bytedance.sdk.openadsdk.core.iq.eo.dl(this.g));
            }
            if (textView2 != null) {
                int iA = com.bytedance.sdk.openadsdk.core.iq.eo.a(this.g);
                if (iA < 0) {
                    textView2.setVisibility(4);
                    oq.z((View) imageView, 4);
                } else {
                    textView2.setText(String.format(com.bytedance.sdk.component.utils.tb.z(this.z, "tt_live_fans_text"), iA > 10000 ? (iA / 10000.0f) + "w" : String.valueOf(iA)));
                }
            }
            if (textView3 != null) {
                int iGc = com.bytedance.sdk.openadsdk.core.iq.eo.gc(this.g);
                if (iGc < 0) {
                    oq.z((View) imageView, 4);
                    textView3.setVisibility(4);
                } else {
                    textView3.setText(String.format(com.bytedance.sdk.component.utils.tb.z(this.z, "tt_live_watch_text"), iGc > 10000 ? (iGc / 10000.0f) + "w" : String.valueOf(iGc)));
                }
            }
            if (textView4 != null) {
                textView4.setText(com.bytedance.sdk.openadsdk.core.iq.eo.m(this.g));
            }
            View viewZ = z(this.ls);
            if (viewZ != null) {
                frameLayout.removeAllViews();
                frameLayout.addView(viewZ, new ViewGroup.LayoutParams(-1, -1));
            }
            com.bytedance.sdk.openadsdk.core.g.z zVarI = i();
            z(roundImageView, zVarI, "click_live_avata");
            z(textView, zVarI, "click_live_author_nickname");
            z(textView2, zVarI, "click_live_author_follower_count");
            z(textView3, zVarI, "click_live_author_following_count");
            z(textView4, zVarI, "click_live_author_description");
            z(frameLayout, zVarI, "click_live_feed");
            z(view, zVarI, "click_live_button");
        }
    }

    private void wp() {
        if (this.g == null) {
            return;
        }
        View viewBv = com.bytedance.sdk.openadsdk.res.gc.bv(this.z);
        this.pf = viewBv;
        addView(viewBv);
        FrameLayout frameLayout = (FrameLayout) this.pf.findViewById(2114387621);
        TextView textView = (TextView) this.pf.findViewById(2114387827);
        TextView textView2 = (TextView) this.pf.findViewById(2114387937);
        View view = (TextView) this.pf.findViewById(2114387861);
        RoundImageView roundImageView = (RoundImageView) this.pf.findViewById(2114387902);
        RelativeLayout relativeLayout = (RelativeLayout) this.pf.findViewById(2114387851);
        TextView textView3 = (TextView) this.pf.findViewById(2114387622);
        TextView textView4 = (TextView) this.pf.findViewById(2114387672);
        TextView textView5 = (TextView) this.pf.findViewById(2114387703);
        ImageView imageView = (ImageView) this.pf.findViewById(2114387881);
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.g)) {
            String strFo = com.bytedance.sdk.openadsdk.core.iq.eo.fo(this.g);
            if (!TextUtils.isEmpty(strFo) && roundImageView != null) {
                oq.z((View) relativeLayout, 0);
                com.bytedance.sdk.openadsdk.gz.g.z(strFo).to(roundImageView);
            } else {
                oq.z((View) relativeLayout, 8);
            }
            if (textView2 != null) {
                textView2.setText(com.bytedance.sdk.openadsdk.core.iq.eo.dl(this.g));
            }
            if (textView3 != null) {
                int iA = com.bytedance.sdk.openadsdk.core.iq.eo.a(this.g);
                if (iA < 0) {
                    textView3.setVisibility(4);
                    oq.z((View) imageView, 4);
                } else {
                    textView3.setText(String.format(com.bytedance.sdk.component.utils.tb.z(this.z, "tt_live_fans_text"), iA > 10000 ? (iA / 10000.0f) + "w" : String.valueOf(iA)));
                }
            }
            if (textView4 != null) {
                int iGc = com.bytedance.sdk.openadsdk.core.iq.eo.gc(this.g);
                if (iGc < 0) {
                    textView4.setVisibility(4);
                    oq.z((View) imageView, 4);
                } else {
                    textView4.setText(String.format(com.bytedance.sdk.component.utils.tb.z(this.z, "tt_live_watch_text"), iGc > 10000 ? (iGc / 10000.0f) + "w" : String.valueOf(iGc)));
                }
            }
            if (textView != null) {
                textView.setText(com.bytedance.sdk.openadsdk.core.iq.eo.m(this.g));
            }
            View viewZ = z(this.ls);
            if (viewZ != null) {
                frameLayout.removeAllViews();
                frameLayout.addView(viewZ, new ViewGroup.LayoutParams(-1, -1));
            }
            com.bytedance.sdk.openadsdk.core.g.z zVarI = i();
            z(roundImageView, zVarI, "click_live_avata");
            z(textView2, zVarI, "click_live_author_nickname");
            z(textView3, zVarI, "click_live_author_follower_count");
            z(textView4, zVarI, "click_live_author_following_count");
            z(textView, zVarI, "click_live_author_description");
            z(frameLayout, zVarI, "click_live_feed");
            z(view, zVarI, "click_live_button");
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.wp.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    wp.this.gc();
                }
            });
        }
    }

    private com.bytedance.sdk.openadsdk.core.g.z i() {
        final com.bytedance.sdk.openadsdk.core.g.z zVar = new com.bytedance.sdk.openadsdk.core.g.z(this.z, this.g, this.gc, eo.g(this.gc)) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.wp.8
            @Override // com.bytedance.sdk.openadsdk.core.g.g, com.bytedance.sdk.openadsdk.core.g.a
            public void z(View view, com.bytedance.sdk.openadsdk.core.iq.uy uyVar) {
                if (view == null) {
                    super.z(view, uyVar);
                    return;
                }
                HashMap map = new HashMap();
                map.put("click_live_element", view.getTag());
                ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z(map);
                super.z(view, uyVar);
            }
        };
        dl dlVar = new dl() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.wp.9
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.dl
            public void z(View view, int i2, com.bytedance.sdk.openadsdk.core.iq.zw zwVar) {
                try {
                    zwVar.z().put("click_extra_map", ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).gc());
                } catch (JSONException unused) {
                }
                wp.this.z(view, i2, zwVar);
            }
        };
        com.bytedance.sdk.openadsdk.core.g.z.g.z zVar2 = (com.bytedance.sdk.openadsdk.core.g.z.g.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.g.z.class);
        if (zVar2 != null) {
            zVar2.z(dlVar);
            zVar2.z(2);
        }
        return zVar;
    }

    private void z(View view, com.bytedance.sdk.openadsdk.core.g.g gVar, String str) {
        if (view == null || gVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        view.setTag(str);
        view.setOnClickListener(gVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void z(View view, int i2, com.bytedance.sdk.openadsdk.core.iq.zw zwVar) {
        NativeExpressView nativeExpressView = this.ls;
        if (nativeExpressView != null) {
            if (i2 == 1 && nativeExpressView.getClickListener() != null) {
                this.ls.getClickListener().g(this.tb);
            }
            if (i2 == 2 && this.ls.getClickCreativeListener() != null) {
                this.ls.getClickCreativeListener().g(this.tb);
            }
            this.ls.z(view, i2, zwVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected NativeVideoTsView z(Context context, na naVar, String str, boolean z, boolean z2) {
        if ("draw_ad".equals(str)) {
            return new NativeDrawVideoTsView(context, naVar, str, z, z2);
        }
        return new NativeVideoTsView(context, naVar, str, z, z2);
    }

    private void gc(int i2) {
        if (i2 == 1) {
            g();
            this.pf.setBackgroundColor(0);
            if (this.tb != null) {
                com.bytedance.sdk.component.utils.tb.z(getContext(), "tt_dislike_icon_night", this.tb);
                return;
            }
            return;
        }
        z();
        this.pf.setBackgroundColor(-1);
        if (this.tb != null) {
            com.bytedance.sdk.component.utils.tb.z(getContext(), "tt_dislike_icon2", this.tb);
        }
    }

    public void z() {
        if (this.fv == null || this.js == null) {
            return;
        }
        int iOu = this.g.ou();
        if (iOu == 2) {
            this.fv.setTextColor(Color.parseColor("#FFBCBCBC"));
            this.js.setTextColor(Color.parseColor("#FF999999"));
            return;
        }
        if (iOu != 3) {
            if (iOu == 4) {
                this.fv.setTextColor(Color.parseColor("#FF3E3E3E"));
                this.js.setTextColor(Color.parseColor("#FF3E3E3E"));
                return;
            } else if (iOu != 5 && iOu != 15 && iOu != 16) {
                return;
            }
        }
        this.fv.setTextColor(Color.parseColor("#FF222222"));
        this.js.setTextColor(Color.parseColor("#FF505050"));
    }

    public void g() {
        TextView textView = this.fv;
        if (textView == null || this.js == null) {
            return;
        }
        textView.setTextColor(-1);
        this.js.setTextColor(-1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView, com.bytedance.sdk.component.adexpress.theme.z
    public void b_(int i2) {
        super.b_(i2);
        gc(i2);
    }
}
