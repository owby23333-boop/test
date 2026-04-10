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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.widget.RewardTaskStepView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.s;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends com.kwad.components.core.l.g {
    private static String qC = "进阶奖励还差 %s 步到手，\n确认放弃吗？";
    private static String qD = "再观看%ss可获得基础奖励，\n确认放弃吗？";
    private AdTemplate mAdTemplate;
    private a qB;

    public interface a extends com.kwad.components.core.webview.a.d.c {
        void g(int i2, int i3);

        void gx();
    }

    public static class b implements a {
        @Override // com.kwad.components.core.webview.a.d.c
        public void J(boolean z2) {
        }

        @Override // com.kwad.components.ad.reward.k.a
        public void g(int i2, int i3) {
        }

        @Override // com.kwad.components.core.webview.a.d.c
        public void gs() {
        }

        @Override // com.kwad.components.ad.reward.k.a
        public void gx() {
        }

        @Override // com.kwad.components.core.webview.a.d.c
        public void gy() {
        }

        @Override // com.kwad.components.core.webview.a.d.c
        public void gz() {
        }
    }

    public static class c extends com.kwad.sdk.core.response.kwai.a {
        public String os;
        public String qI;
        public String qJ;
        public String qK;
        public String qL;
        public String qM;
        public String qN;
        public String qO;
        public com.kwad.components.ad.reward.i.a.a qc;
        public com.kwad.components.ad.reward.i.kwai.a qd;
        public int style;
        public String title;

        private c() {
        }

        static c N(String str) {
            c cVar = new c();
            cVar.style = 0;
            cVar.title = str;
            cVar.qI = "关闭广告";
            cVar.qJ = "继续观看";
            return cVar;
        }

        public static c O(String str) {
            c cVar = new c();
            cVar.style = 0;
            cVar.title = str;
            cVar.qI = "奖励不要了";
            cVar.qJ = "返回";
            return cVar;
        }

        public static c P(String str) {
            c cVar = new c();
            try {
                cVar.parseJson(new JSONObject(str));
            } catch (JSONException unused) {
            }
            return cVar;
        }

        private void Q(String str) {
            this.qO = str;
        }

        static c a(com.kwad.components.ad.reward.i.a.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 1;
            cVar.qc = aVar;
            cVar.qL = str;
            cVar.os = com.kwad.sdk.core.response.a.a.bL(com.kwad.sdk.core.response.a.d.cb(adTemplate));
            return cVar;
        }

        static c a(com.kwad.components.ad.reward.i.kwai.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 2;
            cVar.qd = aVar;
            cVar.qL = str;
            cVar.os = com.kwad.sdk.core.response.a.a.bL(com.kwad.sdk.core.response.a.d.cb(adTemplate));
            return cVar;
        }

        public static c a(AdInfo adInfo, long j2) {
            c cVar = new c();
            cVar.style = 5;
            AdProductInfo adProductInfoCr = com.kwad.sdk.core.response.a.a.cr(adInfo);
            cVar.qM = com.kwad.sdk.core.response.a.a.ao(adInfo);
            cVar.title = adProductInfoCr.getName();
            if (TextUtils.isEmpty(cVar.title)) {
                cVar.title = com.kwad.sdk.core.response.a.a.aq(adInfo);
            }
            cVar.os = adProductInfoCr.getIcon();
            cVar.Q(j2 > 0 ? String.valueOf(j2) : null);
            return cVar;
        }

        static c a(AdTemplate adTemplate, long j2) {
            AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.os = com.kwad.sdk.core.response.a.a.bL(adInfoCb);
            cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j2));
            cVar.qM = com.kwad.sdk.core.response.a.a.bJ(adInfoCb);
            cVar.qN = com.kwad.sdk.core.response.a.a.ao(adInfoCb);
            cVar.qI = "放弃奖励";
            cVar.qJ = "继续观看";
            cVar.qK = com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(adTemplate));
            return cVar;
        }

        static c b(AdTemplate adTemplate, long j2) {
            AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfoBJ = com.kwad.sdk.core.response.a.b.bJ(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.os = merchantLiveReservationInfoBJ.userHeadUrl;
            cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j2));
            cVar.qM = merchantLiveReservationInfoBJ.title;
            cVar.qI = "放弃奖励";
            cVar.qJ = "继续观看";
            cVar.qK = com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(adTemplate));
            return cVar;
        }

        static c i(long j2) {
            c cVar = new c();
            cVar.style = 6;
            cVar.qI = "残忍离开";
            cVar.qJ = "留下看看";
            cVar.Q(j2 > 0 ? String.valueOf(j2) : null);
            return cVar;
        }

        static c i(AdInfo adInfo) {
            c cVar = new c();
            cVar.style = 4;
            AdProductInfo adProductInfoCr = com.kwad.sdk.core.response.a.a.cr(adInfo);
            cVar.title = com.kwad.sdk.core.response.a.a.ao(adInfo);
            cVar.os = adProductInfoCr.getIcon();
            return cVar;
        }

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mLaunchAppTask");
            if (jSONObjectOptJSONObject != null) {
                if (this.qc == null) {
                    this.qc = new com.kwad.components.ad.reward.i.a.a();
                }
                this.qc.parseJson(jSONObjectOptJSONObject);
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("mLandPageOpenTask");
            if (jSONObjectOptJSONObject2 != null) {
                if (this.qd == null) {
                    this.qd = new com.kwad.components.ad.reward.i.kwai.a();
                }
                this.qd.parseJson(jSONObjectOptJSONObject2);
            }
        }

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            com.kwad.components.ad.reward.i.a.a aVar = this.qc;
            if (aVar != null) {
                s.a(jSONObject, "mLaunchAppTask", aVar);
            }
            com.kwad.components.ad.reward.i.kwai.a aVar2 = this.qd;
            if (aVar2 != null) {
                s.a(jSONObject, "mLandPageOpenTask", aVar2);
            }
        }

        public final String fo() {
            return this.os;
        }

        public final String gA() {
            return TextUtils.isEmpty(this.qI) ? "关闭广告" : this.qI;
        }

        public final String gB() {
            return TextUtils.isEmpty(this.qJ) ? "继续观看" : this.qJ;
        }

        public final com.kwad.components.ad.reward.i.a.a gC() {
            return this.qc;
        }

        public final com.kwad.components.ad.reward.i.kwai.a gD() {
            return this.qd;
        }

        public final String gE() {
            return this.qM;
        }

        public final String gF() {
            return this.qN;
        }

        public final String gG() {
            return TextUtils.isEmpty(this.qO) ? "" : String.format("再看%s秒，可获得优惠", this.qO);
        }

        public final int getStyle() {
            return this.style;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    public static c M(String str) {
        return c.O(str);
    }

    private static View a(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, final a aVar) {
        View viewInflate = layoutInflater.inflate(R.layout.ksad_video_close_dialog, viewGroup, false);
        ((TextView) viewInflate.findViewById(R.id.ksad_title)).setText(cVar.getTitle());
        TextView textView = (TextView) viewInflate.findViewById(R.id.ksad_close_btn);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ksad_continue_btn);
        textView.setText(cVar.gA());
        textView2.setText(cVar.gB());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.J(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.gz();
                }
            }
        });
        return viewInflate;
    }

    private static View a(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.gC(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }

    private static View a(com.kwad.components.ad.reward.i.a aVar, final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, final a aVar2) {
        View viewInflate = layoutInflater.inflate(R.layout.ksad_reward_task_launch_app_dialog, viewGroup, false);
        if (aVar instanceof com.kwad.components.ad.reward.i.a.a) {
            com.kwad.components.ad.reward.i.a.a.a((com.kwad.components.ad.reward.i.a.a) aVar, viewInflate.getContext(), adTemplate);
        }
        ((RewardTaskStepView) viewInflate.findViewById(R.id.ksad_reward_task_dialog_steps)).a(aVar.jD(), cVar.qL);
        KSImageLoader.loadAppIcon((ImageView) viewInflate.findViewById(R.id.ksad_reward_task_dialog_icon), cVar.fo(), adTemplate, 12);
        TextView textView = (TextView) viewInflate.findViewById(R.id.ksad_reward_task_dialog_abandon);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ksad_reward_task_dialog_continue);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.ksad_reward_task_dialog_title);
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.jE());
        String string = sb.toString();
        String str = cVar.qL;
        boolean zEquals = "0".equals(str);
        String str2 = zEquals ? String.format(qC, string) : String.format(qD, str);
        int iIndexOf = zEquals ? str2.indexOf(string) : str2.indexOf(str);
        if (iIndexOf < 0) {
            textView3.setText(str2);
        } else {
            int i2 = zEquals ? iIndexOf + 1 : str.length() > 1 ? iIndexOf + 3 : iIndexOf + 2;
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(viewInflate.getContext().getResources().getColor(R.color.ksad_reward_main_color));
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(foregroundColorSpan, iIndexOf, i2, 17);
            textView3.setText(spannableString);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.J(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.gz();
                }
            }
        });
        return viewInflate;
    }

    private View a(final k kVar, LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, c cVar, final a aVar) {
        View viewInflate = layoutInflater.inflate(R.layout.ksad_video_close_extend_dialog, viewGroup, false);
        ((TextView) viewInflate.findViewById(R.id.ksad_reward_close_extend_dialog_play_time_tips)).setText(f(viewInflate.getContext(), cVar.qO));
        TextView textView = (TextView) viewInflate.findViewById(R.id.ksad_reward_close_extend_dialog_btn_deny);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ksad_reward_close_extend_dialog_btn_continue);
        textView.setText(cVar.gA());
        textView2.setText(cVar.gB());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                kVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.J(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                kVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.gz();
                }
            }
        });
        return viewInflate;
    }

    public static c a(j jVar, @Nullable String str) {
        int i2;
        AdTemplate adTemplate = jVar.mAdTemplate;
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        com.kwad.components.ad.reward.i.a.a aVar = jVar.qc;
        com.kwad.components.ad.reward.i.kwai.a aVar2 = jVar.qd;
        int i3 = jVar.qe;
        boolean zG = com.kwad.sdk.core.response.a.d.g(adTemplate, com.kwad.components.ad.reward.kwai.b.l(com.kwad.sdk.core.response.a.d.cb(adTemplate)));
        int i4 = 0;
        if (zG || com.kwad.sdk.core.response.a.d.q(adTemplate)) {
            int iV = (int) com.kwad.sdk.core.response.a.a.V(adInfoCb);
            int iF = com.kwad.sdk.core.response.a.a.F(adInfoCb);
            if (iV <= iF) {
                iF = iV;
            }
            long playDuration = jVar.pw.getPlayDuration();
            if (playDuration < (iF * 1000) - 800 && (i2 = (int) (iF - ((playDuration / 1000.0f) + 0.5f))) >= 0) {
                i4 = i2;
            }
        }
        return (!zG || aVar == null) ? (!com.kwad.sdk.core.response.a.d.q(adTemplate) || aVar2 == null) ? com.kwad.components.ad.reward.kwai.b.j(adInfoCb) ? c.i(adInfoCb) : (com.kwad.sdk.core.response.a.a.ci(adInfoCb) && com.kwad.components.ad.reward.kwai.b.gY() == 1) ? c.a(adInfoCb, i3) : com.kwad.sdk.core.response.a.a.bI(adInfoCb) ? c.O(str) : com.kwad.sdk.core.response.a.a.co(adInfoCb) ? c.a(adTemplate, i3) : com.kwad.sdk.core.response.a.a.aJ(adTemplate) ? c.b(adTemplate, i3) : com.kwad.components.ad.reward.kwai.b.gS() == 1 ? c.i(i3) : c.N(str) : c.a(aVar2, adTemplate, String.valueOf(i4)) : c.a(aVar, adTemplate, String.valueOf(i4));
    }

    public static k a(Activity activity, AdTemplate adTemplate, c cVar, a aVar) {
        k kVar = new k();
        Bundle bundle = new Bundle();
        bundle.putString("key_params_json", cVar.toJson().toString());
        bundle.putString("key_template_json", adTemplate.toJson().toString());
        kVar.setArguments(bundle);
        kVar.a(aVar);
        kVar.show(activity.getFragmentManager(), "videoCloseDialog");
        return kVar;
    }

    private void a(a aVar) {
        this.qB = aVar;
    }

    private static View b(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.gD(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }

    private static View c(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, final a aVar) {
        View viewInflate = layoutInflater.inflate(R.layout.ksad_reward_order_dialog, viewGroup, false);
        KSImageLoader.loadImage((KSCornerImageView) viewInflate.findViewById(R.id.ksad_reward_order_dialog_icon), cVar.os, adTemplate);
        ((TextView) viewInflate.findViewById(R.id.ksad_reward_order_dialog_desc)).setText(cVar.getTitle());
        viewInflate.findViewById(R.id.ksad_reward_order_dialog_btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.gz();
                }
            }
        });
        viewInflate.findViewById(R.id.ksad_reward_order_dialog_btn_view_detail).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.gx();
                }
            }
        });
        viewInflate.findViewById(R.id.ksad_reward_order_dialog_btn_deny).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.J(false);
                }
            }
        });
        return viewInflate;
    }

    private static SpannableString f(Context context, String str) {
        SpannableString spannableString = new SpannableString("再看" + str + "秒，即可获得奖励");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.kwad.sdk.b.kwai.a.getColor(context, R.color.ksad_reward_main_color));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(com.kwad.sdk.b.kwai.a.getColor(context, R.color.ksad_reward_main_color));
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableString.length();
        spannableString.setSpan(foregroundColorSpan, 2, length - 7, 34);
        spannableString.setSpan(foregroundColorSpan2, length - 2, length, 34);
        spannableString.setSpan(styleSpan, 0, length, 34);
        return spannableString;
    }

    @Override // com.kwad.components.core.l.g
    @Nullable
    public final View a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        View viewA;
        getDialog().requestWindowFeature(1);
        Bundle arguments = getArguments();
        String string = arguments.getString("key_params_json");
        try {
            String string2 = arguments.getString("key_template_json");
            this.mAdTemplate = new AdTemplate();
            this.mAdTemplate.parseJson(new JSONObject(string2));
        } catch (Throwable unused) {
        }
        c cVarP = c.P(string);
        int style = cVarP.getStyle();
        if (style == 1) {
            viewA = a(this, layoutInflater, viewGroup, cVarP, this.mAdTemplate, this.qB);
        } else if (style == 2) {
            viewA = b(this, layoutInflater, viewGroup, cVarP, this.mAdTemplate, this.qB);
        } else if (style == 4) {
            viewA = c(this, layoutInflater, viewGroup, cVarP, this.mAdTemplate, this.qB);
            com.kwad.components.core.r.j.a(new com.kwad.components.core.widget.e(), (ViewGroup) viewA);
        } else if (style == 5) {
            com.kwad.components.ad.reward.k.i iVar = new com.kwad.components.ad.reward.k.i(this, this.mAdTemplate, layoutInflater, viewGroup, this.qB);
            iVar.a(cVarP);
            viewA = iVar.hc();
        } else if (style == 6) {
            viewA = a(this, layoutInflater, viewGroup, cVarP, this.qB);
        } else if (style != 8) {
            viewA = a((DialogFragment) this, layoutInflater, viewGroup, cVarP, this.qB);
        } else {
            com.kwad.components.ad.reward.k.l lVar = new com.kwad.components.ad.reward.k.l(this, this.mAdTemplate, layoutInflater, viewGroup, this.qB);
            lVar.a(cVarP);
            viewA = lVar.hc();
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.ad.reward.k.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                return i2 == 4 && keyEvent.getAction() == 0;
            }
        });
        return viewA;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        a aVar = this.qB;
        if (aVar != null) {
            aVar.gs();
        }
    }
}
