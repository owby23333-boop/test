package com.kwad.components.ad.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.kwad.components.core.widget.d;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;

/* JADX INFO: loaded from: classes3.dex */
public class KsPriceView extends TextView implements d {
    private static String MI = "¥%s 到手约 ¥%s";
    private static String MJ = "¥%s  ¥%s";
    private static String MK = "¥%s";
    private a MH;
    private String ML;
    private String MM;
    private boolean MN;

    public KsPriceView(Context context) {
        super(context);
        this.MH = new a();
        A(context);
    }

    public KsPriceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MH = new a();
        A(context);
    }

    public KsPriceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MH = new a();
        A(context);
    }

    public KsPriceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.MH = new a();
        A(context);
    }

    private void A(Context context) {
        setMaxLines(1);
        this.MH.MQ = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.MH.MR = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_price_size);
        this.MH.MS = context.getResources().getColor(R.color.ksad_reward_original_price);
        this.MH.MT = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_original_price_size);
        this.MH.MO = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.MH.MP = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_price_size);
    }

    public a getConfig() {
        return this.MH;
    }

    public final void h(String str, String str2) {
        d(str, str2, false);
    }

    public final void d(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        this.ML = str;
        this.MM = str2;
        this.MN = z;
        SpannableString spannableStringA = null;
        if (TextUtils.isEmpty(str2)) {
            this.MM = null;
        }
        if (str != null && str.startsWith("¥")) {
            str = str.replaceFirst("¥", "");
        }
        setTextColor(this.MH.nQ());
        try {
            spannableStringA = a(str, this.MM, z, this.MH);
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
        if (spannableStringA != null) {
            setText(spannableStringA);
        }
    }

    private static SpannableString a(String str, String str2, boolean z, a aVar) {
        String str3;
        if (str2 == null) {
            str3 = String.format(MK, str);
        } else {
            str3 = String.format(z ? MJ : MI, str, str2);
        }
        SpannableString spannableString = new SpannableString(str3);
        if (str3.startsWith("¥")) {
            spannableString.setSpan(new ForegroundColorSpan(aVar.nU()), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.nV()), 0, 1, 17);
        }
        int iIndexOf = str3.indexOf(str);
        if (iIndexOf < 0) {
            return null;
        }
        int length = str.length() + iIndexOf;
        spannableString.setSpan(new ForegroundColorSpan(aVar.nQ()), iIndexOf, length, 18);
        spannableString.setSpan(new AbsoluteSizeSpan(aVar.nS()), iIndexOf, length, 18);
        if (str2 != null) {
            int iLastIndexOf = str3.lastIndexOf(str2) - 1;
            int length2 = str2.length() + 1 + iLastIndexOf;
            spannableString.setSpan(new ForegroundColorSpan(aVar.nR()), iLastIndexOf, length2, 18);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.nT()), iLastIndexOf, length2, 18);
            spannableString.setSpan(new StrikethroughSpan(), iLastIndexOf, length2, 18);
        }
        return spannableString;
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        this.MH.MQ = eVar.wf();
        d(this.ML, this.MM, this.MN);
    }

    public static class a {
        private int MO;
        private int MP;
        private int MQ;
        private int MR;
        private int MS;
        private int MT;

        public final int nQ() {
            return this.MQ;
        }

        public final int nR() {
            return this.MS;
        }

        public final int nS() {
            return this.MR;
        }

        public final int nT() {
            return this.MT;
        }

        public final int nU() {
            return this.MO;
        }

        public final int nV() {
            return this.MP;
        }

        public final a as(int i) {
            this.MP = i;
            return this;
        }

        public final a at(int i) {
            this.MS = i;
            return this;
        }

        public final a au(int i) {
            this.MT = i;
            return this;
        }
    }
}
