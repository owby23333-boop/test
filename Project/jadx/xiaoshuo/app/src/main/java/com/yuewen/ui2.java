package com.yuewen;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yuewen.ct2;

/* JADX INFO: loaded from: classes17.dex */
public class ui2 extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f18475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f18476b;

    public ui2(Context context, int i) {
        super(context);
        setId(i);
        setOrientation(0);
        setGravity(17);
        a(context);
    }

    public final void a(Context context) {
        Resources resources = getResources();
        this.f18475a = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = resources.getDimensionPixelSize(ct2.g.GX);
        this.f18475a.setAdjustViewBounds(true);
        addView(this.f18475a, 0, layoutParams);
        this.f18476b = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = resources.getDimensionPixelSize(ct2.g.RR);
        layoutParams2.bottomMargin = resources.getDimensionPixelSize(ct2.g.OW);
        this.f18476b.setTextAppearance(ct2.t.zn);
        addView(this.f18476b, 1, layoutParams2);
    }

    public ui2 b(vi2 vi2Var) {
        this.f18475a.setImageResource(vi2Var.b());
        this.f18476b.setText(vi2Var.c());
        return this;
    }
}
