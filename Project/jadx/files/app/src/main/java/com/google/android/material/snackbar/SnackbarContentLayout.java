package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$styleable;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SnackbarContentLayout extends LinearLayout implements e {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f15817s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Button f15818t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f15819u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f15820v;

    public SnackbarContentLayout(@NonNull Context context) {
        this(context, null);
    }

    private boolean a(int i2, int i3, int i4) {
        boolean z2;
        if (i2 != getOrientation()) {
            setOrientation(i2);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f15817s.getPaddingTop() == i3 && this.f15817s.getPaddingBottom() == i4) {
            return z2;
        }
        a(this.f15817s, i3, i4);
        return true;
    }

    public Button getActionView() {
        return this.f15818t;
    }

    public TextView getMessageView() {
        return this.f15817s;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f15817s = (TextView) findViewById(R$id.snackbar_text);
        this.f15818t = (Button) findViewById(R$id.snackbar_action);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.f15819u
            if (r0 <= 0) goto L18
            int r0 = r7.getMeasuredWidth()
            int r1 = r7.f15819u
            if (r0 <= r1) goto L18
            r8 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            super.onMeasure(r8, r9)
        L18:
            android.content.res.Resources r0 = r7.getResources()
            int r1 = com.google.android.material.R$dimen.design_snackbar_padding_vertical_2lines
            int r0 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r1 = r7.getResources()
            int r2 = com.google.android.material.R$dimen.design_snackbar_padding_vertical
            int r1 = r1.getDimensionPixelSize(r2)
            android.widget.TextView r2 = r7.f15817s
            android.text.Layout r2 = r2.getLayout()
            int r2 = r2.getLineCount()
            r3 = 0
            r4 = 1
            if (r2 <= r4) goto L3c
            r2 = 1
            goto L3d
        L3c:
            r2 = 0
        L3d:
            if (r2 == 0) goto L56
            int r5 = r7.f15820v
            if (r5 <= 0) goto L56
            android.widget.Button r5 = r7.f15818t
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f15820v
            if (r5 <= r6) goto L56
            int r1 = r0 - r1
            boolean r0 = r7.a(r4, r0, r1)
            if (r0 == 0) goto L61
            goto L62
        L56:
            if (r2 == 0) goto L59
            goto L5a
        L59:
            r0 = r1
        L5a:
            boolean r0 = r7.a(r3, r0, r0)
            if (r0 == 0) goto L61
            goto L62
        L61:
            r4 = 0
        L62:
            if (r4 == 0) goto L67
            super.onMeasure(r8, r9)
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }

    public void setMaxInlineActionWidth(int i2) {
        this.f15820v = i2;
    }

    public SnackbarContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
        this.f15819u = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_android_maxWidth, -1);
        this.f15820v = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_maxActionInlineWidth, -1);
        typedArrayObtainStyledAttributes.recycle();
    }

    private static void a(@NonNull View view, int i2, int i3) {
        if (ViewCompat.isPaddingRelative(view)) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i2, ViewCompat.getPaddingEnd(view), i3);
        } else {
            view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i3);
        }
    }
}
