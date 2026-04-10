package com.yuewen;

import android.content.Context;
import android.widget.FrameLayout;
import com.duokan.reader.ui.general.DkLabelView;
import com.yuewen.us2;

/* JADX INFO: loaded from: classes16.dex */
public class t80 extends jz3 {
    public final DkLabelView c;

    public t80(Context context, int i, int i2) {
        super(context, i);
        DkLabelView dkLabelView = new DkLabelView(getContext());
        this.c = dkLabelView;
        addView(dkLabelView, new FrameLayout.LayoutParams(-2, -2, 17));
        dkLabelView.setTextSize(0, getResources().getDimension(us2.g.P8));
        dkLabelView.setIncludeFontPadding(false);
        dkLabelView.setTextColor(i2);
        dkLabelView.setText(getResources().getString(us2.r.tm));
        dkLabelView.setGravity(17);
    }
}
