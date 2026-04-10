package com.anythink.expressad.video.dynview.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.anythink.expressad.foundation.h.i;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.umeng.message.proguard.ad;

/* JADX INFO: loaded from: classes2.dex */
public class AnyThinkLevelLayoutView extends LinearLayout {
    private double a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11748c;

    public AnyThinkLevelLayoutView(Context context) {
        super(context);
    }

    private void a() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        if (this.f11748c) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, dip2px(getContext(), 15.0f));
            layoutParams.setMargins(0, dip2px(getContext(), 2.0f), 0, 0);
            linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setOrientation(0);
            linearLayout2.setLayoutParams(layoutParams);
        } else {
            linearLayout = null;
            linearLayout2 = null;
        }
        removeAllViews();
        if (linearLayout2 != null) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, dip2px(getContext(), 15.0f));
            TextView textView = new TextView(getContext());
            textView.setTypeface(Typeface.defaultFromStyle(1));
            textView.setText(ad.f20405r);
            textView.setTextColor(Color.parseColor("#5f5f5f"));
            TextView textView2 = new TextView(getContext());
            textView2.setTypeface(Typeface.defaultFromStyle(1));
            textView2.setGravity(17);
            textView2.setTextColor(Color.parseColor("#5f5f5f"));
            Drawable drawable = getResources().getDrawable(i.a(getContext(), "anythink_reward_user", i.f10645c));
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2.setCompoundDrawables(drawable, null, null, null);
            textView2.setText(this.b + " )");
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setLines(1);
            linearLayout2.addView(textView, layoutParams2);
            linearLayout2.addView(textView2, layoutParams2);
        }
        double d2 = this.a;
        if (d2 == PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            d2 = 5.0d;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            ImageView imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dip2px(getContext(), 15.0f), dip2px(getContext(), 15.0f));
            if (i2 < d2) {
                imageView.setImageResource(i.a(getContext(), "anythink_download_message_dialog_star_sel", i.f10645c));
            } else {
                imageView.setImageResource(i.a(getContext(), "anythink_download_message_dilaog_star_nor", i.f10645c));
            }
            layoutParams3.weight = 1.0f;
            layoutParams3.setMargins(dip2px(getContext(), 2.0f), 0, 0, 0);
            if (linearLayout != null) {
                linearLayout.addView(imageView, layoutParams3);
            } else {
                addView(imageView, layoutParams3);
            }
        }
        if (linearLayout == null || linearLayout == null) {
            return;
        }
        addView(linearLayout);
        addView(linearLayout2);
    }

    public static int dip2px(Context context, float f2) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return (int) ((f2 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public void setRating(int i2) {
        this.a = i2;
        a();
    }

    public void setRatingAndUser(double d2, int i2) {
        this.a = d2;
        if (i2 == 0) {
            i2 = (int) (((Math.random() * 9.0d) + 1.0d) * 10000.0d);
        }
        this.b = i2;
        this.f11748c = true;
        a();
    }

    public AnyThinkLevelLayoutView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AnyThinkLevelLayoutView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
