package com.duokan.reader.ui.theme;

import android.text.TextPaint;
import android.text.style.URLSpan;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes5.dex */
public class NoLineUrlSpan extends URLSpan {
    public NoLineUrlSpan(String str) {
        super(str);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
    }
}
