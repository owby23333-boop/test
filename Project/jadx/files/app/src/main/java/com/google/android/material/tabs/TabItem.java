package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R$styleable;

/* JADX INFO: loaded from: classes2.dex */
public class TabItem extends View {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CharSequence f15841s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Drawable f15842t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f15843u;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R$styleable.TabItem);
        this.f15841s = tintTypedArrayObtainStyledAttributes.getText(R$styleable.TabItem_android_text);
        this.f15842t = tintTypedArrayObtainStyledAttributes.getDrawable(R$styleable.TabItem_android_icon);
        this.f15843u = tintTypedArrayObtainStyledAttributes.getResourceId(R$styleable.TabItem_android_layout, 0);
        tintTypedArrayObtainStyledAttributes.recycle();
    }
}
