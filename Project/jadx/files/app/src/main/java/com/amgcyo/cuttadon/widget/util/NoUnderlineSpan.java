package com.amgcyo.cuttadon.widget.util;

import android.text.TextPaint;
import android.text.style.UnderlineSpan;

/* JADX INFO: loaded from: classes.dex */
public class NoUnderlineSpan extends UnderlineSpan {
    @Override // android.text.style.UnderlineSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(textPaint.linkColor);
        textPaint.setUnderlineText(false);
    }
}
