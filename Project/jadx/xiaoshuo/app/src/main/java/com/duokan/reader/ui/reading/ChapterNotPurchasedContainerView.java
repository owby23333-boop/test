package com.duokan.reader.ui.reading;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes5.dex */
public class ChapterNotPurchasedContainerView extends LinearLayout {
    public ChapterNotPurchasedContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a() {
        return true;
    }

    public void b() {
        removeAllViews();
    }

    public void setChapterID(String str) {
    }

    public void setChapterIndex(long j) {
    }

    public void setPrice(int i) {
    }

    public void setTotalCash(int i) {
    }
}
