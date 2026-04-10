package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.i.b;
import com.google.android.material.i.c;
import com.google.android.material.theme.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(@NonNull Context context) {
        this(context, null);
    }

    private void a(@NonNull Resources.Theme theme, int i2) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i2, R$styleable.MaterialTextAppearance);
        int iA = a(getContext(), typedArrayObtainStyledAttributes, R$styleable.MaterialTextAppearance_android_lineHeight, R$styleable.MaterialTextAppearance_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        if (iA >= 0) {
            setLineHeight(iA);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(@NonNull Context context, int i2) {
        super.setTextAppearance(context, i2);
        if (a(context)) {
            a(context.getTheme(), i2);
        }
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        int iA;
        super(a.b(context, attributeSet, i2, i3), attributeSet, i2);
        Context context2 = getContext();
        if (a(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (a(context2, theme, attributeSet, i2, i3) || (iA = a(theme, attributeSet, i2, i3)) == -1) {
                return;
            }
            a(theme, iA);
        }
    }

    private static boolean a(Context context) {
        return b.a(context, R$attr.textAppearanceLineHeightEnabled, true);
    }

    private static int a(@NonNull Context context, @NonNull TypedArray typedArray, @NonNull @StyleableRes int... iArr) {
        int iA = -1;
        for (int i2 = 0; i2 < iArr.length && iA < 0; i2++) {
            iA = c.a(context, typedArray, iArr[i2], -1);
        }
        return iA;
    }

    private static boolean a(@NonNull Context context, @NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i2, int i3) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R$styleable.MaterialTextView, i2, i3);
        int iA = a(context, typedArrayObtainStyledAttributes, R$styleable.MaterialTextView_android_lineHeight, R$styleable.MaterialTextView_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        return iA != -1;
    }

    private static int a(@NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i2, int i3) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R$styleable.MaterialTextView, i2, i3);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialTextView_android_textAppearance, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }
}
