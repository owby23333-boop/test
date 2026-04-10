package com.amgcyo.cuttadon.view.otherview;

import android.text.TextPaint;
import android.text.style.URLSpan;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class URLSpanNoUnderline extends URLSpan {
    public URLSpanNoUnderline(String str) {
        super(str);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }
}
