package com.yuewen;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yuewen.ct2;

/* JADX INFO: loaded from: classes17.dex */
public class pi2 extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f16055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f16056b;

    public pi2(Context context, int i) {
        super(context);
        setId(i);
        setOrientation(1);
        setGravity(17);
        a(context);
    }

    public final void a(Context context) {
        Resources resources = getResources();
        this.f16055a = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = resources.getDimensionPixelSize(ct2.g.GX);
        this.f16055a.setAdjustViewBounds(true);
        addView(this.f16055a, 0, layoutParams);
        this.f16056b = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = resources.getDimensionPixelSize(ct2.g.RR);
        layoutParams2.bottomMargin = resources.getDimensionPixelSize(ct2.g.OW);
        this.f16056b.setTextAppearance(ct2.t.zn);
        addView(this.f16056b, 1, layoutParams2);
    }

    public pi2 b(vi2 vi2Var) {
        this.f16055a.setImageResource(vi2Var.b());
        this.f16056b.setText(vi2Var.c());
        return this;
    }
}
