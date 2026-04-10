package com.duokan.reader.utils;

import android.text.TextPaint;
import android.text.style.URLSpan;

/* JADX INFO: loaded from: classes5.dex */
public class URLSpanNoUnderline extends URLSpan {
    public URLSpanNoUnderline(String str) {
        super(str);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }
}
