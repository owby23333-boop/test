package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"AppCompatCustomView"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class VisibilityAwareImageButton extends ImageButton {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f15483s;

    public VisibilityAwareImageButton(Context context) {
        this(context, null);
    }

    public final void a(int i2, boolean z2) {
        super.setVisibility(i2);
        if (z2) {
            this.f15483s = i2;
        }
    }

    public final int getUserSetVisibility() {
        return this.f15483s;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i2) {
        a(i2, true);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15483s = getVisibility();
    }
}
