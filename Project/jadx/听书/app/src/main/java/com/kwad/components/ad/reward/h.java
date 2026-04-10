package com.kwad.components.ad.reward;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.widget.RewardTaskStepView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends com.kwad.components.core.proxy.j {
    private static String sM = "进阶奖励还差 %s 步到手，\n确认放弃吗？";
    private static String sN = "再观看%ss可获得基础奖励，\n确认放弃吗？";
    private AdTemplate mAdTemplate;
    private a sL;

    public interface a extends com.kwad.components.core.webview.tachikoma.f.c {
        void h(int i, int i2);

        void hh();
    }

    public static class b implements a {
        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public void G(boolean z) {
        }

        @Override // com.kwad.components.ad.reward.h.a
        public void h(int i, int i2) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public void ha() {
        }

        @Override // com.kwad.components.ad.reward.h.a
        public void hh() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public void hi() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public void hj() {
        }
    }

    public static c g(String str, int i) {
        return c.h(str, i);
    }

    public static c a(g gVar, String str) {
        int i;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.components.ad.reward.l.b.a aVar = gVar.sm;
        com.kwad.components.ad.reward.l.a.a aVar2 = gVar.sn;
        int i2 = gVar.so;
        boolean zK = com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.el(adTemplate)));
        int i3 = 0;
        if (zK || com.kwad.sdk.core.response.b.e.O(adTemplate)) {
            int iAd = (int) com.kwad.sdk.core.response.b.a.ad(adInfoEl);
            int iL = com.kwad.sdk.core.response.b.a.L(adInfoEl);
            if (iAd > iL) {
                iAd = iL;
            }
            long playDuration = gVar.rE.getPlayDuration();
            if (playDuration < (iAd * 1000) - 800 && (i = (int) (iAd - ((playDuration / 1000.0f) + 0.5f))) >= 0) {
                i3 = i;
            }
        }
        if (zK && aVar != null) {
            return c.a(aVar, adTemplate, String.valueOf(i3));
        }
        if (com.kwad.sdk.core.response.b.e.O(adTemplate) && aVar2 != null) {
            return c.a(aVar2, adTemplate, String.valueOf(i3));
        }
        if (com.kwad.components.ad.reward.a.b.i(adInfoEl)) {
            return c.h(adInfoEl);
        }
        if (com.kwad.sdk.core.response.b.a.cj(adInfoEl) == 1 && com.kwad.components.ad.reward.a.b.hJ() == 1) {
            return c.a(adInfoEl, i2);
        }
        if (adTemplate.isNativeRewardPreview) {
            return c.h(str, i2);
        }
        if (com.kwad.sdk.core.response.b.a.cR(adInfoEl)) {
            return c.c(adTemplate, i2);
        }
        if (com.kwad.sdk.core.response.b.a.co(adTemplate)) {
            return c.d(adTemplate, i2);
        }
        if (com.kwad.components.ad.reward.a.b.hD() == 1) {
            return c.n(i2);
        }
        return c.E(str);
    }

    public static h a(Activity activity, AdTemplate adTemplate, c cVar, a aVar) {
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putString("key_params_json", cVar.toJson().toString());
        bundle.putString("key_template_json", adTemplate.toJson().toString());
        hVar.setArguments(bundle);
        hVar.a(aVar);
        hVar.show(activity.getFragmentManager(), "videoCloseDialog");
        return hVar;
    }

    private void a(a aVar) {
        this.sL = aVar;
    }

    @Override // com.kwad.components.core.proxy.j
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewA;
        Bundle arguments = getArguments();
        String string = arguments.getString("key_params_json");
        try {
            String string2 = arguments.getString("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string2));
        } catch (Throwable unused) {
        }
        c cVarF = c.F(string);
        int style = cVarF.getStyle();
        if (style == 1) {
            viewA = a(this, layoutInflater, viewGroup, cVarF, this.mAdTemplate, this.sL);
        } else if (style == 2) {
            viewA = b(this, layoutInflater, viewGroup, cVarF, this.mAdTemplate, this.sL);
        } else if (style == 4) {
            viewA = c(this, layoutInflater, viewGroup, cVarF, this.mAdTemplate, this.sL);
            com.kwad.components.core.t.j.a(new com.kwad.components.core.widget.e(), (ViewGroup) viewA);
        } else if (style == 5) {
            com.kwad.components.ad.reward.n.j jVar = new com.kwad.components.ad.reward.n.j(this, this.mAdTemplate, layoutInflater, viewGroup, this.sL);
            jVar.a(cVarF);
            viewA = jVar.hP();
        } else if (style == 6) {
            viewA = a(this, layoutInflater, viewGroup, cVarF, this.sL);
        } else if (style == 8) {
            com.kwad.components.ad.reward.n.m mVar = new com.kwad.components.ad.reward.n.m(this, this.mAdTemplate, layoutInflater, viewGroup, this.sL);
            mVar.a(cVarF);
            viewA = mVar.hP();
        } else {
            viewA = a((DialogFragment) this, layoutInflater, viewGroup, cVarF, this.sL);
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.ad.reward.h.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4 && keyEvent.getAction() == 0;
            }
        });
        return viewA;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        a aVar = this.sL;
        if (aVar != null) {
            aVar.ha();
        }
    }

    private static View a(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, final a aVar) {
        View viewInflate = layoutInflater.inflate(R.layout.ksad_video_close_dialog, viewGroup, false);
        ((TextView) viewInflate.findViewById(R.id.ksad_title)).setText(cVar.getTitle());
        TextView textView = (TextView) viewInflate.findViewById(R.id.ksad_close_btn);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ksad_continue_btn);
        textView.setText(cVar.hk());
        textView2.setText(cVar.hl());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.G(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.hj();
                }
            }
        });
        return viewInflate;
    }

    private View a(final h hVar, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, final a aVar) {
        View viewInflate = layoutInflater.inflate(R.layout.ksad_video_close_extend_dialog, viewGroup, false);
        ((TextView) viewInflate.findViewById(R.id.ksad_reward_close_extend_dialog_play_time_tips)).setText(f(viewInflate.getContext(), cVar.sZ));
        TextView textView = (TextView) viewInflate.findViewById(R.id.ksad_reward_close_extend_dialog_btn_deny);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ksad_reward_close_extend_dialog_btn_continue);
        textView.setText(cVar.hk());
        textView2.setText(cVar.hl());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                hVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.G(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                hVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.hj();
                }
            }
        });
        return viewInflate;
    }

    private static SpannableString f(Context context, String str) {
        SpannableString spannableString = new SpannableString("再看" + str + "秒，即可获得奖励");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.kwad.sdk.c.a.a.getColor(context, R.color.ksad_reward_main_color));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(com.kwad.sdk.c.a.a.getColor(context, R.color.ksad_reward_main_color));
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableString.length();
        spannableString.setSpan(foregroundColorSpan, 2, length - 7, 34);
        spannableString.setSpan(foregroundColorSpan2, length - 2, length, 34);
        spannableString.setSpan(styleSpan, 0, length, 34);
        return spannableString;
    }

    private static View a(com.kwad.components.ad.reward.l.a aVar, final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, final a aVar2) {
        String str;
        int i;
        View viewInflate = layoutInflater.inflate(R.layout.ksad_reward_task_launch_app_dialog, viewGroup, false);
        if (aVar instanceof com.kwad.components.ad.reward.l.b.a) {
            com.kwad.components.ad.reward.l.b.a.a((com.kwad.components.ad.reward.l.b.a) aVar, viewInflate.getContext(), adTemplate);
        }
        ((RewardTaskStepView) viewInflate.findViewById(R.id.ksad_reward_task_dialog_steps)).a(aVar.kA(), cVar.sV);
        KSImageLoader.loadAppIcon((ImageView) viewInflate.findViewById(R.id.ksad_reward_task_dialog_icon), cVar.ho(), adTemplate, 12);
        TextView textView = (TextView) viewInflate.findViewById(R.id.ksad_reward_task_dialog_abandon);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ksad_reward_task_dialog_continue);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.ksad_reward_task_dialog_title);
        String string = new StringBuilder().append(aVar.kB()).toString();
        String str2 = cVar.sV;
        boolean zEquals = "0".equals(str2);
        if (zEquals) {
            str = String.format(sM, string);
        } else {
            str = String.format(sN, str2);
        }
        int iIndexOf = zEquals ? str.indexOf(string) : str.indexOf(str2);
        if (iIndexOf < 0) {
            textView3.setText(str);
        } else {
            if (zEquals) {
                i = iIndexOf + 1;
            } else {
                i = str2.length() > 1 ? iIndexOf + 3 : iIndexOf + 2;
            }
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(viewInflate.getContext().getResources().getColor(R.color.ksad_reward_main_color));
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(foregroundColorSpan, iIndexOf, i, 17);
            textView3.setText(spannableString);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.G(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.hj();
                }
            }
        });
        return viewInflate;
    }

    private static View a(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.hm(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }

    private static View b(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.hn(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }

    private static View c(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, final a aVar) {
        View viewInflate = layoutInflater.inflate(R.layout.ksad_reward_order_dialog, viewGroup, false);
        KSImageLoader.loadImage((KSCornerImageView) viewInflate.findViewById(R.id.ksad_reward_order_dialog_icon), cVar.sW, adTemplate);
        ((TextView) viewInflate.findViewById(R.id.ksad_reward_order_dialog_desc)).setText(cVar.getTitle());
        viewInflate.findViewById(R.id.ksad_reward_order_dialog_btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.hj();
                }
            }
        });
        viewInflate.findViewById(R.id.ksad_reward_order_dialog_btn_view_detail).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.hh();
                }
            }
        });
        viewInflate.findViewById(R.id.ksad_reward_order_dialog_btn_deny).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.G(false);
                }
            }
        });
        return viewInflate;
    }

    public static class c extends com.kwad.sdk.core.response.a.a {
        public String sS;
        public String sT;
        public String sU;
        public String sV;
        public String sW;
        public String sX;
        public String sY;
        public String sZ;
        public com.kwad.components.ad.reward.l.b.a sm;
        public com.kwad.components.ad.reward.l.a.a sn;
        public int style;
        public String title;

        private c() {
        }

        static c E(String str) {
            c cVar = new c();
            cVar.style = 0;
            cVar.title = str;
            cVar.sS = "关闭广告";
            cVar.sT = "继续观看";
            return cVar;
        }

        static c n(long j) {
            c cVar = new c();
            cVar.style = 6;
            cVar.sS = "残忍离开";
            cVar.sT = "留下看看";
            if (j > 0) {
                cVar.G(String.valueOf(j));
            } else {
                cVar.G(null);
            }
            return cVar;
        }

        static c c(AdTemplate adTemplate, long j) {
            AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.sW = com.kwad.sdk.core.response.b.a.co(adInfoEl);
            cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j));
            cVar.sX = com.kwad.sdk.core.response.b.a.cl(adInfoEl);
            cVar.sY = com.kwad.sdk.core.response.b.a.au(adInfoEl);
            cVar.sS = "放弃奖励";
            cVar.sT = "继续观看";
            cVar.sU = com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.el(adTemplate));
            return cVar;
        }

        static c d(AdTemplate adTemplate, long j) {
            AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfoDt = com.kwad.sdk.core.response.b.b.dt(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.sW = merchantLiveReservationInfoDt.userHeadUrl;
            cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j));
            cVar.sX = merchantLiveReservationInfoDt.title;
            cVar.sS = "放弃奖励";
            cVar.sT = "继续观看";
            cVar.sU = com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.el(adTemplate));
            return cVar;
        }

        public static c h(String str, int i) {
            c cVar = new c();
            cVar.style = 6;
            cVar.title = str;
            cVar.sS = "残忍离开";
            cVar.sT = "留下看看";
            if (i > 0) {
                cVar.sZ = String.valueOf(i);
            }
            return cVar;
        }

        static c a(com.kwad.components.ad.reward.l.b.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 1;
            cVar.sm = aVar;
            cVar.sV = str;
            cVar.sW = com.kwad.sdk.core.response.b.a.co(com.kwad.sdk.core.response.b.e.el(adTemplate));
            return cVar;
        }

        static c a(com.kwad.components.ad.reward.l.a.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 2;
            cVar.sn = aVar;
            cVar.sV = str;
            cVar.sW = com.kwad.sdk.core.response.b.a.co(com.kwad.sdk.core.response.b.e.el(adTemplate));
            return cVar;
        }

        static c h(AdInfo adInfo) {
            c cVar = new c();
            cVar.style = 4;
            AdProductInfo adProductInfoCV = com.kwad.sdk.core.response.b.a.cV(adInfo);
            cVar.title = com.kwad.sdk.core.response.b.a.au(adInfo);
            cVar.sW = adProductInfoCV.getIcon();
            return cVar;
        }

        public static c a(AdInfo adInfo, long j) {
            c cVar = new c();
            cVar.style = 5;
            AdProductInfo adProductInfoCV = com.kwad.sdk.core.response.b.a.cV(adInfo);
            cVar.sX = com.kwad.sdk.core.response.b.a.au(adInfo);
            String name = adProductInfoCV.getName();
            cVar.title = name;
            if (TextUtils.isEmpty(name)) {
                cVar.title = com.kwad.sdk.core.response.b.a.ax(adInfo);
            }
            cVar.sW = adProductInfoCV.getIcon();
            if (j > 0) {
                cVar.G(String.valueOf(j));
            } else {
                cVar.G(null);
            }
            return cVar;
        }

        public static c F(String str) {
            c cVar = new c();
            try {
                cVar.parseJson(new JSONObject(str));
            } catch (JSONException unused) {
            }
            return cVar;
        }

        public final int getStyle() {
            return this.style;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String hk() {
            return TextUtils.isEmpty(this.sS) ? "关闭广告" : this.sS;
        }

        public final String hl() {
            return TextUtils.isEmpty(this.sT) ? "继续观看" : this.sT;
        }

        public final com.kwad.components.ad.reward.l.b.a hm() {
            return this.sm;
        }

        public final com.kwad.components.ad.reward.l.a.a hn() {
            return this.sn;
        }

        public final String ho() {
            return this.sW;
        }

        public final String hp() {
            return this.sX;
        }

        public final String hq() {
            return this.sY;
        }

        public final String hr() {
            return TextUtils.isEmpty(this.sZ) ? "" : String.format("再看%s秒，可获得优惠", this.sZ);
        }

        private void G(String str) {
            this.sZ = str;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterParseJson(JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mLaunchAppTask");
            if (jSONObjectOptJSONObject != null) {
                if (this.sm == null) {
                    this.sm = new com.kwad.components.ad.reward.l.b.a();
                }
                this.sm.parseJson(jSONObjectOptJSONObject);
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("mLandPageOpenTask");
            if (jSONObjectOptJSONObject2 != null) {
                if (this.sn == null) {
                    this.sn = new com.kwad.components.ad.reward.l.a.a();
                }
                this.sn.parseJson(jSONObjectOptJSONObject2);
            }
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            com.kwad.components.ad.reward.l.b.a aVar = this.sm;
            if (aVar != null) {
                aa.a(jSONObject, "mLaunchAppTask", aVar);
            }
            com.kwad.components.ad.reward.l.a.a aVar2 = this.sn;
            if (aVar2 != null) {
                aa.a(jSONObject, "mLandPageOpenTask", aVar2);
            }
        }
    }
}
