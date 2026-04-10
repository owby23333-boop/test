package com.anythink.expressad.foundation.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.t;

/* JADX INFO: loaded from: classes2.dex */
public class ToolBar extends LinearLayout {
    public ToolBar(Context context) {
        super(context);
        a();
    }

    private void a() {
        setOrientation(0);
        int iB = t.b(getContext(), 10.0f);
        setPadding(0, iB, 0, iB);
        ImageView imageView = (ImageView) b();
        imageView.setTag("backward");
        imageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("anythink_expressad_backward", i.f10645c, com.anythink.expressad.foundation.b.a.b().a())));
        addView(imageView);
        ImageView imageView2 = (ImageView) b();
        imageView2.setTag("forward");
        imageView2.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("anythink_expressad_forward", i.f10645c, com.anythink.expressad.foundation.b.a.b().a())));
        addView(imageView2);
        ImageView imageView3 = (ImageView) b();
        imageView3.setTag("refresh");
        imageView3.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("anythink_expressad_refresh", i.f10645c, com.anythink.expressad.foundation.b.a.b().a())));
        addView(imageView3);
        ImageView imageView4 = (ImageView) b();
        imageView4.setTag("exits");
        imageView4.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("anythink_expressad_exits", i.f10645c, com.anythink.expressad.foundation.b.a.b().a())));
        addView(imageView4);
    }

    private View b() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        imageView.setLayoutParams(layoutParams);
        imageView.setClickable(true);
        return imageView;
    }

    public View getItem(String str) {
        return findViewWithTag(str);
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setOnClickListener(onClickListener);
        }
    }

    public ToolBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
