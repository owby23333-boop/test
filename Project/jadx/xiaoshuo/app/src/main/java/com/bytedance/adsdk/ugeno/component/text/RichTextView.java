package com.bytedance.adsdk.ugeno.component.text;

import android.content.Context;
import android.text.Html;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class RichTextView extends TextView {
    public RichTextView(Context context) {
        super(context);
    }

    public void setRichText(String str) {
        setText(Html.fromHtml(str, 0));
    }
}
