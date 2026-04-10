package com.kwad.components.ad.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.widget.d;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.b;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"AppCompatCustomView"})
public class KsPriceView extends TextView implements d {
    private static String Hj = "¥%s 到手约 ¥%s";
    private static String Hk = "¥%s  ¥%s";
    private static String Hl = "¥%s";
    private a Hi;
    private String Hm;
    private String Hn;
    private boolean Ho;

    public static class a {
        private int Hp;
        private int Hq;
        private int Hr;
        private int Hs;
        private int Ht;
        private int Hu;

        public final a aj(int i2) {
            this.Hq = i2;
            return this;
        }

        public final a ak(int i2) {
            this.Ht = i2;
            return this;
        }

        public final a al(int i2) {
            this.Hu = i2;
            return this;
        }

        public final int mh() {
            return this.Hr;
        }

        public final int mi() {
            return this.Ht;
        }

        public final int mj() {
            return this.Hs;
        }

        public final int mk() {
            return this.Hu;
        }

        public final int ml() {
            return this.Hp;
        }

        public final int mm() {
            return this.Hq;
        }
    }

    public KsPriceView(Context context) {
        super(context);
        this.Hi = new a();
        N(context);
    }

    public KsPriceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hi = new a();
        N(context);
    }

    public KsPriceView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Hi = new a();
        N(context);
    }

    @RequiresApi(api = 21)
    public KsPriceView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.Hi = new a();
        N(context);
    }

    private void N(Context context) {
        setMaxLines(1);
        this.Hi.Hr = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.Hi.Hs = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_price_size);
        this.Hi.Ht = context.getResources().getColor(R.color.ksad_reward_original_price);
        this.Hi.Hu = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_original_price_size);
        this.Hi.Hp = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.Hi.Hq = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_price_size);
    }

    @Nullable
    private static SpannableString a(String str, @Nullable String str2, boolean z2, a aVar) {
        String str3;
        if (str2 == null) {
            str3 = String.format(Hl, str);
        } else {
            str3 = String.format(z2 ? Hk : Hj, str, str2);
        }
        SpannableString spannableString = new SpannableString(str3);
        if (str3.startsWith("¥")) {
            spannableString.setSpan(new ForegroundColorSpan(aVar.ml()), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.mm()), 0, 1, 17);
        }
        int iIndexOf = str3.indexOf(str);
        if (iIndexOf < 0) {
            return null;
        }
        int length = str.length() + iIndexOf;
        spannableString.setSpan(new ForegroundColorSpan(aVar.mh()), iIndexOf, length, 18);
        spannableString.setSpan(new AbsoluteSizeSpan(aVar.mj()), iIndexOf, length, 18);
        if (str2 != null) {
            int iLastIndexOf = str3.lastIndexOf(str2) - 1;
            int length2 = str2.length() + 1 + iLastIndexOf;
            spannableString.setSpan(new ForegroundColorSpan(aVar.mi()), iLastIndexOf, length2, 18);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.mk()), iLastIndexOf, length2, 18);
            spannableString.setSpan(new StrikethroughSpan(), iLastIndexOf, length2, 18);
        }
        return spannableString;
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        this.Hi.Hr = eVar.rS();
        d(this.Hm, this.Hn, this.Ho);
    }

    public final void d(String str, String str2, boolean z2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        this.Hm = str;
        this.Hn = str2;
        this.Ho = z2;
        SpannableString spannableStringA = null;
        if (TextUtils.isEmpty(str2)) {
            this.Hn = null;
        }
        if (str != null && str.startsWith("¥")) {
            str = str.replaceFirst("¥", "");
        }
        setTextColor(this.Hi.mh());
        try {
            spannableStringA = a(str, this.Hn, z2, this.Hi);
        } catch (Exception e2) {
            b.printStackTraceOnly(e2);
        }
        if (spannableStringA != null) {
            setText(spannableStringA);
        }
    }

    public final void f(String str, String str2) {
        d(str, str2, false);
    }

    @NonNull
    public a getConfig() {
        return this.Hi;
    }
}
