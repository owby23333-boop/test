package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    TTRatingBar f981a;
    TextView dl;
    TextView e;
    private na fo;
    TTRoundRectImageView g;
    TextView gc;
    private final TTBaseVideoActivity gz;
    private boolean kb;
    TextView m;
    private int uy;
    LinearLayout z;

    public z(TTBaseVideoActivity tTBaseVideoActivity) {
        this.gz = tTBaseVideoActivity;
    }

    public void z(na naVar) {
        if (this.kb) {
            return;
        }
        this.kb = true;
        this.fo = naVar;
        this.uy = naVar.zr();
        gc();
        g();
        z(a());
        m();
    }

    private void gc() {
        this.z = (LinearLayout) this.gz.findViewById(2114387739);
        this.g = (TTRoundRectImageView) this.gz.findViewById(2114387773);
        this.dl = (TextView) this.gz.findViewById(2114387645);
        this.f981a = (TTRatingBar) this.gz.findViewById(2114387779);
        this.gc = (TextView) this.gz.findViewById(2114387782);
        this.m = (TextView) this.gz.findViewById(2114387864);
        this.e = (TextView) this.gz.findViewById(2114387709);
        TTRatingBar tTRatingBar = this.f981a;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.f981a.setStarFillNum(4);
            this.f981a.setStarImageWidth(oq.dl(this.gz, 16.0f));
            this.f981a.setStarImageHeight(oq.dl(this.gz, 16.0f));
            this.f981a.setStarImagePadding(oq.dl(this.gz, 4.0f));
            this.f981a.z();
        }
    }

    public void z(com.bytedance.sdk.openadsdk.core.g.g gVar) {
        oq.z(this.z, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.z.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "TTBaseVideoActivity#mLLEndCardBackup");
        TextView textView = this.m;
        if (textView != null) {
            textView.setOnClickListener(gVar);
            this.m.setOnTouchListener(gVar);
        }
    }

    public void z() {
        oq.z((View) this.z, 0);
        na naVar = this.fo;
        if (naVar == null || naVar.tk() == 100.0f) {
            return;
        }
        oq.z((View) this.f981a, 8);
        oq.z((View) this.gc, 8);
    }

    private void m() {
        TTRoundRectImageView tTRoundRectImageView;
        if (this.uy == 1 && (tTRoundRectImageView = this.g) != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tTRoundRectImageView.getLayoutParams();
            layoutParams.setMargins(0, oq.dl(this.gz, 50.0f), 0, 0);
            this.g.setLayoutParams(layoutParams);
        }
    }

    public void g() {
        if (this.g != null) {
            gk gkVarKp = this.fo.kp();
            if (gkVarKp != null && !TextUtils.isEmpty(gkVarKp.z())) {
                com.bytedance.sdk.openadsdk.gz.g.z(gkVarKp).to(this.g);
            } else {
                tb.z((Context) this.gz, "tt_ad_logo_small", (ImageView) this.g);
            }
        }
        if (this.dl != null) {
            if (this.fo.c() != null && !TextUtils.isEmpty(this.fo.c().dl())) {
                this.dl.setText(this.fo.c().dl());
            } else {
                this.dl.setText(this.fo.li());
            }
        }
        if (this.gc != null) {
            int iM = this.fo.c() != null ? this.fo.c().m() : 6870;
            this.gc.setText(String.format(tb.z(this.gz, "tt_comment_num_backup"), iM > 10000 ? (iM / 10000) + "万" : String.valueOf(iM)));
        }
        TextView textView = this.e;
        if (textView != null) {
            oq.z(textView, this.fo);
        }
    }

    public void z(String str) {
        TextView textView;
        if (TextUtils.isEmpty(str) || (textView = this.m) == null) {
            return;
        }
        textView.setText(str);
    }

    public void dl() {
        oq.z((View) this.z, 8);
    }

    protected String a() {
        na naVar = this.fo;
        if (naVar == null) {
            return "立即下载";
        }
        if (TextUtils.isEmpty(naVar.no())) {
            return this.fo.lt() != 4 ? "查看详情" : "立即下载";
        }
        return this.fo.no();
    }
}
