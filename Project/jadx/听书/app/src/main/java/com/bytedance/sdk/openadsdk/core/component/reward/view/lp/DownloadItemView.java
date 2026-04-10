package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.gz.g;
import com.bytedance.sdk.openadsdk.res.gc;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadItemView extends FrameLayout {
    public DownloadItemView(Context context) {
        super(context);
    }

    public void z(na naVar) {
        String strNo;
        if (naVar == null) {
            return;
        }
        Context context = getContext();
        addView(gc.un(context));
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) findViewById(2114387793);
        TextView textView = (TextView) findViewById(2114387875);
        TextView textView2 = (TextView) findViewById(2114387637);
        TextView textView3 = (TextView) findViewById(2114387830);
        TextView textView4 = (TextView) findViewById(2114387630);
        TTRatingBar tTRatingBar = (TTRatingBar) findViewById(2114387609);
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(4);
            tTRatingBar.setStarImageWidth(oq.dl(context, 12.0f));
            tTRatingBar.setStarImageHeight(oq.dl(context, 12.0f));
            tTRatingBar.setStarImagePadding(oq.dl(context, 4.0f));
            tTRatingBar.z();
        }
        if (textView4 != null) {
            int iM = naVar.c() != null ? naVar.c().m() : 6870;
            textView4.setText(String.format(tb.z(context, "tt_comment_num"), iM > 10000 ? (iM / 10000) + "万" : String.valueOf(iM)));
        }
        if (tTRoundRectImageView != null) {
            gk gkVarKp = naVar.kp();
            if (gkVarKp != null && !TextUtils.isEmpty(gkVarKp.z())) {
                g.z(gkVarKp).to(tTRoundRectImageView);
            } else {
                tb.z(context, "tt_ad_logo_small", (ImageView) tTRoundRectImageView);
            }
        }
        if (textView != null) {
            textView.setText(eo.p(naVar));
        }
        if (textView2 != null) {
            textView2.setText(eo.fv(naVar));
        }
        if (textView3 != null) {
            if (TextUtils.isEmpty(naVar.no())) {
                strNo = naVar.lt() != 4 ? "查看详情" : "立即下载";
            } else {
                strNo = naVar.no();
            }
            textView3.setText(strNo);
        }
    }
}
