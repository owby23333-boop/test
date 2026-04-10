package com.anythink.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.anythink.core.common.k.h;
import com.anythink.expressad.foundation.h.i;

/* JADX INFO: loaded from: classes2.dex */
public class FeedbackTextView extends AutoResizeTextView {
    public FeedbackTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundResource(h.a(context, "myoffer_bg_feedback_textview", i.f10645c));
    }

    private void a(Context context) {
        setBackgroundResource(h.a(context, "myoffer_bg_feedback_textview", i.f10645c));
    }
}
