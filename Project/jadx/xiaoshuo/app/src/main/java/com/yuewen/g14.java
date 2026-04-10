package com.yuewen;

import android.view.View;
import android.widget.TextView;
import com.yuewen.ot2;

/* JADX INFO: loaded from: classes4.dex */
public class g14 {
    public static final int[] c = {-50944, -47542, -31744, -6512472};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f11397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f11398b;

    public g14(View view) {
        this.f11397a = view.findViewById(ot2.k.Ed);
        this.f11398b = (TextView) view.findViewById(ot2.k.Dd);
    }

    public void a(int i) {
        this.f11398b.setText(i + "");
        int i2 = i > 3 ? 3 : i - 1;
        this.f11397a.setVisibility(i <= 3 ? 0 : 8);
        this.f11398b.setTextColor(c[i2]);
    }
}
