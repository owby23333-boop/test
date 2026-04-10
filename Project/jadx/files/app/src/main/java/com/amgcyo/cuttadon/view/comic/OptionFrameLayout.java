package com.amgcyo.cuttadon.view.comic;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.amgcyo.cuttadon.R$styleable;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class OptionFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected TextView f4473s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected TextView f4474t;

    public OptionFrameLayout(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CheckBoxPreference);
        String string = typedArrayObtainStyledAttributes.getString(1);
        String string2 = typedArrayObtainStyledAttributes.getString(0);
        this.f4473s = (TextView) findViewById(R.id.custom_option_title);
        this.f4474t = (TextView) findViewById(R.id.custom_option_summary);
        this.f4473s.setText(string);
        this.f4474t.setText(string2);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setSummary(CharSequence charSequence) {
        this.f4474t.setText(charSequence);
    }

    public OptionFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OptionFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.custom_option, this);
        a(context, attributeSet);
    }
}
