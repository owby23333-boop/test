package com.amgcyo.cuttadon.view.xtablayout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.amgcyo.cuttadon.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public final class TabItem extends View {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final CharSequence f5582s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final Drawable f5583t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final int f5584u;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R$styleable.TabItem);
        this.f5582s = tintTypedArrayObtainStyledAttributes.getText(2);
        this.f5583t = tintTypedArrayObtainStyledAttributes.getDrawable(0);
        this.f5584u = tintTypedArrayObtainStyledAttributes.getResourceId(1, 0);
        tintTypedArrayObtainStyledAttributes.recycle();
    }
}
