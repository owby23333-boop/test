package com.bytedance.sdk.openadsdk.core.bannerexpress;

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
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.iq.zw;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ls;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.res.gc;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class BannerExpressBackupView extends BackupView {
    private static ls[] i = {new ls(1, 6.4f, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, 100), new ls(3, 1.2f, 600, 500)};
    private ls fv;
    private TextView js;
    private com.bytedance.sdk.openadsdk.core.kb.g.dl ls;
    private int p;
    private NativeExpressView pf;
    private ImageView q;
    private TextView tb;
    private View v;

    public BannerExpressBackupView(Context context) {
        super(context);
        this.p = 1;
        this.z = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void z(View view, int i2, zw zwVar) {
        if (this.pf != null) {
            if (i2 == 1 || i2 == 2) {
                View viewFindViewById = this.v.findViewById(2114387854);
                if (i2 == 1) {
                    this.pf.getClickListener().g(viewFindViewById);
                } else {
                    this.pf.getClickCreativeListener().g(viewFindViewById);
                }
            }
            this.pf.z(view, i2, zwVar);
        }
    }

    void z(na naVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar) {
        setBackgroundColor(-1);
        this.g = naVar;
        this.pf = nativeExpressView;
        this.ls = dlVar;
        this.gc = "banner_ad";
        this.pf.addView(this, new ViewGroup.LayoutParams(-2, -2));
        this.gz = eo.fo(this.g);
        g(this.gz);
        z();
        dl(uy.ls().bv());
    }

    private void z() {
        this.fv = z(this.pf.getExpectExpressWidth(), this.pf.getExpectExpressHeight());
        if (this.pf.getExpectExpressWidth() > 0 && this.pf.getExpectExpressHeight() > 0) {
            this.m = oq.dl(this.z, this.pf.getExpectExpressWidth());
            this.e = oq.dl(this.z, this.pf.getExpectExpressHeight());
        } else {
            this.m = oq.a(this.z);
            this.e = Float.valueOf(this.m / this.fv.dl).intValue();
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
        if (this.fv.z != 1 && this.fv.z == 3) {
            z(this.fv);
        } else {
            g();
        }
    }

    private void z(ImageView imageView) {
        com.bytedance.sdk.openadsdk.gz.g.z(this.g.jz().get(0)).to(imageView);
        if (com.bytedance.sdk.openadsdk.gc.z.a(this.g)) {
            UpieImageView upieImageView = new UpieImageView(imageView.getContext(), com.bytedance.sdk.openadsdk.gc.z.fo(this.g), com.bytedance.sdk.openadsdk.gc.z.uy(this.g));
            upieImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            com.bytedance.sdk.openadsdk.gc.z.z(imageView, upieImageView);
        }
    }

    private void z(ls lsVar) {
        View viewZ;
        float fDl = (this.e * 1.0f) / oq.dl(this.z, 250.0f);
        View viewGp = gc.gp(this.z);
        this.v = viewGp;
        addView(viewGp);
        FrameLayout frameLayout = (FrameLayout) this.v.findViewById(2114387772);
        this.q = (ImageView) this.v.findViewById(2114387854);
        ImageView imageView = (ImageView) this.v.findViewById(2114387936);
        ImageView imageView2 = (ImageView) this.v.findViewById(2114387931);
        this.js = (TextView) this.v.findViewById(2114387940);
        this.tb = (TextView) this.v.findViewById(2114387920);
        TextView textView = (TextView) this.v.findViewById(2114387927);
        TextView textView2 = (TextView) this.v.findViewById(2114387633);
        oq.z((TextView) this.v.findViewById(2114387658), this.g);
        LinearLayout linearLayout = (LinearLayout) this.v.findViewById(2114387871);
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (oq.dl(this.z, 45.0f) * fDl);
            layoutParams.height = (int) (oq.dl(this.z, 45.0f) * fDl);
        }
        this.js.setTextSize(2, oq.g(this.z, this.js.getTextSize()) * fDl);
        this.tb.setTextSize(2, oq.g(this.z, this.tb.getTextSize()) * fDl);
        textView.setTextSize(2, oq.g(this.z, textView.getTextSize()) * fDl);
        textView2.setTextSize(2, oq.g(this.z, textView2.getTextSize()) * fDl);
        try {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            float f = fDl - 1.0f;
            if (f > 0.0f) {
                layoutParams2.topMargin = oq.dl(this.z, f * 8.0f);
            }
            ((RelativeLayout.LayoutParams) textView2.getLayoutParams()).setMargins(0, (int) (oq.dl(this.z, 16.0f) * fDl), 0, 0);
        } catch (Throwable unused) {
        }
        this.q.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.gc();
            }
        });
        int iDl = oq.dl(this.z, 15.0f);
        oq.z(this.q, iDl, iDl, iDl, iDl);
        if (tf.v(this.g) != null && (viewZ = z(this.pf)) != null) {
            int i2 = (this.m * 406) / 600;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i2, (i2 * 9) / 16);
            if (lsVar.g == 1) {
                int i3 = (this.m * 406) / 600;
                layoutParams3 = new FrameLayout.LayoutParams(i3, (i3 * 9) / 16);
            } else if (lsVar.g == 2) {
                layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            } else if (lsVar.g == 3) {
                int i4 = (this.e * 188) / MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME;
                layoutParams3 = new FrameLayout.LayoutParams((i4 * 16) / 9, i4);
            } else if (lsVar.g == 4) {
                int i5 = (this.m * 480) / 690;
                layoutParams3 = new FrameLayout.LayoutParams(i5, (i5 * 9) / 16);
            }
            layoutParams3.gravity = 17;
            frameLayout.addView(viewZ, 0, layoutParams3);
            oq.z((View) imageView, 8);
        } else {
            z(imageView);
            oq.z((View) imageView, 0);
        }
        com.bytedance.sdk.openadsdk.gz.g.z(this.g.kp()).to(imageView2);
        textView.setText(getNameOrSource());
        this.js.setText(String.format(Locale.getDefault(), "%s提供的广告", getNameOrSource()));
        this.tb.setText(getDescription());
        if (!TextUtils.isEmpty(this.g.no())) {
            textView2.setText(this.g.no());
        }
        z((View) this, true);
        z((View) textView2, true);
        z(frameLayout);
    }

    private void g() {
        float fDl = (this.e * 1.0f) / oq.dl(this.z, 50.0f);
        if ((this.e * 1.0f) / this.m > 0.21875f) {
            fDl = (this.m * 1.0f) / oq.dl(this.z, 320.0f);
        }
        View viewJ = gc.j(this.z);
        this.v = viewJ;
        addView(viewJ);
        this.q = (ImageView) this.v.findViewById(2114387854);
        ImageView imageView = (ImageView) this.v.findViewById(2114387931);
        this.js = (TextView) this.v.findViewById(2114387940);
        TextView textView = (TextView) this.v.findViewById(2114387794);
        TTRatingBar tTRatingBar = (TTRatingBar) this.v.findViewById(2114387891);
        TextView textView2 = (TextView) this.v.findViewById(2114387633);
        this.js.setTextSize(2, oq.g(this.z, this.js.getTextSize()) * fDl);
        textView.setTextSize(2, oq.g(this.z, textView.getTextSize()) * fDl);
        textView2.setTextSize(2, oq.g(this.z, textView2.getTextSize()) * fDl);
        TextView textView3 = (TextView) this.v.findViewById(2114387658);
        this.q.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.gc();
            }
        });
        oq.z(textView3, this.g, 27, 11);
        com.bytedance.sdk.openadsdk.gz.g.z(this.g.kp()).to(imageView);
        this.js.setText(getTitle());
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (oq.dl(this.z, 45.0f) * fDl);
            layoutParams.height = (int) (oq.dl(this.z, 45.0f) * fDl);
        }
        if (!TextUtils.isEmpty(this.g.no())) {
            textView2.setText(this.g.no());
        }
        int iGc = this.g.c() != null ? this.g.c().gc() : 4;
        textView.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(iGc)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(iGc);
        tTRatingBar.setStarImageWidth(oq.dl(this.z, 15.0f) * fDl);
        tTRatingBar.setStarImageHeight(oq.dl(this.z, 14.0f) * fDl);
        tTRatingBar.setStarImagePadding(oq.dl(this.z, 4.0f));
        tTRatingBar.z();
        z((View) this, true);
        z((View) textView2, true);
    }

    private ls z(int i2, int i3) {
        try {
            return ((double) i3) >= Math.floor((((double) i2) * 300.0d) / 600.0d) ? i[1] : i[0];
        } catch (Throwable unused) {
            return i[0];
        }
    }

    private void dl(int i2) {
        if (i2 == 1) {
            a();
            this.v.setBackgroundColor(0);
        } else {
            dl();
            this.v.setBackgroundColor(-1);
        }
    }

    private void dl() {
        if (this.fv.z == 2 || this.fv.z == 3) {
            TextView textView = this.js;
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#FFAEAEAE"));
            }
            TextView textView2 = this.tb;
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor("#3E3E3E"));
            }
            if (this.q != null) {
                this.q.setImageDrawable(gc.t(this.z));
                return;
            }
            return;
        }
        TextView textView3 = this.js;
        if (textView3 != null) {
            textView3.setTextColor(Color.parseColor("#FF333333"));
        }
        if (this.q != null) {
            tb.z(getContext(), "tt_dislike_icon", this.q);
        }
    }

    private void a() {
        if (this.fv.z == 2 || this.fv.z == 3) {
            TextView textView = this.js;
            if (textView != null) {
                textView.setTextColor(-1);
            }
            TextView textView2 = this.tb;
            if (textView2 != null) {
                textView2.setTextColor(-1);
            }
        } else {
            TextView textView3 = this.js;
            if (textView3 != null) {
                textView3.setTextColor(-1);
            }
        }
        if (this.q != null) {
            tb.z(getContext(), "tt_dislike_icon_night", this.q);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView, com.bytedance.sdk.component.adexpress.theme.z
    public void b_(int i2) {
        super.b_(i2);
        dl(i2);
    }
}
