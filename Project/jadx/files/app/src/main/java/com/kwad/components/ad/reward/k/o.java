package com.kwad.components.ad.reward.k;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.model.AdLiveEndResultData;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends w implements View.OnClickListener {
    private com.kwad.components.ad.reward.j qS;
    private ImageView zJ;
    private TextView zK;
    private TextView zL;
    private TextView zM;
    private TextView zN;
    private TextView zO;
    private TextView zP;
    private TextView zQ;

    public o(com.kwad.components.ad.reward.j jVar) {
        this.qS = jVar;
    }

    private void bindView(AdTemplate adTemplate) {
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        KSImageLoader.loadCircleIcon(this.zJ, com.kwad.sdk.core.response.a.a.bL(adInfoCb), this.zJ.getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar));
        this.zK.setText(com.kwad.sdk.core.response.a.a.bJ(adInfoCb));
    }

    private void initView() {
        ViewGroup viewGroup = this.sN;
        if (viewGroup == null) {
            return;
        }
        this.zJ = (ImageView) viewGroup.findViewById(R.id.ksad_live_end_page_author_icon);
        this.zK = (TextView) this.sN.findViewById(R.id.ksad_author_name_txt);
        this.zL = (TextView) this.sN.findViewById(R.id.ksad_live_end_detail_watch_person_count);
        this.zM = (TextView) this.sN.findViewById(R.id.ksad_live_end_detail_like_person_count);
        this.zN = (TextView) this.sN.findViewById(R.id.ksad_live_end_detail_watch_time);
        this.zO = (TextView) this.sN.findViewById(R.id.ksad_live_end_bottom_title);
        this.zP = (TextView) this.sN.findViewById(R.id.ksad_live_end_bottom_action_btn);
        this.zQ = (TextView) this.sN.findViewById(R.id.ksad_live_end_bottom_des_btn);
        this.zP.setOnClickListener(this);
        this.zQ.setOnClickListener(this);
    }

    private static String l(long j2) {
        long j3 = j2 / 3600000;
        long j4 = (j2 / 60000) - (j3 * 60);
        long j5 = ((j2 / 1000) - (60 * j4)) - (com.anythink.expressad.d.a.b.P * j3);
        return j3 > 0 ? String.format("%02d:%02d:%02d", Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)) : String.format("%02d:%02d", Long.valueOf(j4), Long.valueOf(j5));
    }

    public final void W(int i2) {
        TextView textView = this.zO;
        if (textView == null || i2 <= 0) {
            return;
        }
        if (!this.qS.pN) {
            textView.setText("已获得奖励");
            return;
        }
        String str = String.format("再停留%s秒，即可获得奖励", Integer.valueOf(i2));
        SpannableString spannableString = new SpannableString(str);
        int color = hc().getResources().getColor(R.color.ksad_reward_main_color);
        spannableString.setSpan(new ForegroundColorSpan(color), 3, 6, 18);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
        int length = str.length();
        spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
        this.zO.setText(spannableString);
    }

    public final void a(com.kwad.components.ad.reward.j jVar, AdLiveEndResultData.AdLivePushEndInfo adLivePushEndInfo, long j2) {
        CharSequence charSequence;
        TextView textView;
        this.zM.setText(adLivePushEndInfo.mDisplayLikeUserCount);
        this.zN.setText(l(adLivePushEndInfo.mLiveDuration));
        this.zL.setText(adLivePushEndInfo.mDisplayWatchingUserCount);
        if (jVar.pN) {
            String str = String.format("再停留%s秒，即可获得奖励", Integer.valueOf((int) (Math.max(com.kwad.sdk.core.response.a.a.Y(com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate)) - j2, 0L) / 1000)));
            SpannableString spannableString = new SpannableString(str);
            int color = hc().getResources().getColor(R.color.ksad_reward_main_color);
            spannableString.setSpan(new ForegroundColorSpan(color), 3, 6, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = str.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            textView = this.zO;
            charSequence = spannableString;
        } else {
            textView = this.zO;
            charSequence = "内容很精彩，不要错过哦";
        }
        textView.setText(charSequence);
    }

    @Override // com.kwad.components.ad.reward.k.d
    protected final void a(v vVar) {
        super.a(vVar);
        bindView(vVar.getAdTemplate());
    }

    public final void f(ViewGroup viewGroup) {
        super.a(viewGroup, R.id.ksad_reward_origin_live_end_page_stub, R.id.ksad_live_end_page_layout_root);
        initView();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.sdk.core.report.i iVar = new com.kwad.sdk.core.report.i();
        iVar.bm(24);
        if (view.equals(this.zP)) {
            this.qS.a(2, view.getContext(), 38, 1, 0L, false, iVar);
        } else if (view.equals(this.zQ)) {
            this.qS.a(2, view.getContext(), 37, 1, 0L, false, iVar);
        }
    }
}
