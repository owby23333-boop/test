package com.bytedance.sdk.openadsdk.res.layout.z;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.un.oq;

/* JADX INFO: loaded from: classes2.dex */
public class z implements com.bytedance.sdk.openadsdk.res.layout.z {
    @Override // com.bytedance.sdk.openadsdk.res.layout.z
    public View g(Context context) {
        Button button = new Button(context);
        button.setId(2114387729);
        button.setLayoutParams(new ViewGroup.LayoutParams(-1, oq.dl(context, 48.0f)));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#2A90D7"));
        button.setBackground(gradientDrawable);
        button.setText(tb.z(context, "tt_download"));
        button.setTextColor(Color.parseColor("#ffffff"));
        button.setTextSize(2, 16.0f);
        return button;
    }
}
