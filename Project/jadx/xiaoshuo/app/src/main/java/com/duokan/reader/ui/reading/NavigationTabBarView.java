package com.duokan.reader.ui.reading;

import android.content.Context;
import android.util.AttributeSet;
import com.duokan.core.ui.TabBarView;
import com.yuewen.mt2;

/* JADX INFO: loaded from: classes5.dex */
public class NavigationTabBarView extends TabBarView {
    public NavigationTabBarView(Context context) {
        this(context, null);
    }

    private int getBgPadding() {
        return getContext().getResources().getDimensionPixelSize(mt2.g.yt);
    }

    public void w(float f) {
        super.u(Math.round(getPaddingLeft() + (f * ((getWidth() - getPaddingLeft()) - getPaddingRight()))));
    }

    public NavigationTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
