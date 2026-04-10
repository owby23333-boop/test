package com.amgcyo.cuttadon.view.otherview;

import android.text.TextPaint;
import android.text.style.URLSpan;
import androidx.annotation.NonNull;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class URLSpanNoUnderlineColor extends URLSpan {
    public URLSpanNoUnderlineColor(String str) {
        super(str);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
        textPaint.setColor(com.amgcyo.cuttadon.f.o.b(R.color.color_web));
    }
}
