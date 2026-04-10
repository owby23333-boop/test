package com.anythink.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppRatingView extends LinearLayout {
    private Context a;
    private List<StarLevelView> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6086d;

    public AppRatingView(Context context) {
        this(context, null, 0);
    }

    public static int dip2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setRating(int i2) {
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            StarLevelView starLevelView = this.b.get(i3);
            if (i3 < i2) {
                starLevelView.setState(true);
            } else {
                starLevelView.setState(false);
            }
        }
    }

    public void setStarMargin(int i2) {
        this.f6086d = i2;
    }

    public void setStarNum(int i2) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.clear();
        removeAllViews();
        setOrientation(0);
        for (int i3 = 0; i3 < i2; i3++) {
            StarLevelView starLevelView = new StarLevelView(getContext());
            int i4 = this.f6085c;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i4);
            if (i3 != i2 - 1) {
                layoutParams.setMargins(0, 0, dip2px(getContext(), this.f6086d), 0);
            }
            starLevelView.setLayoutParams(layoutParams);
            addView(starLevelView);
            this.b.add(starLevelView);
        }
    }

    public void setStarSizeInDp(int i2) {
        this.f6085c = dip2px(this.a, i2);
    }

    public AppRatingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppRatingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = context;
        setStarSizeInDp(17);
        setStarMargin(8);
    }
}
