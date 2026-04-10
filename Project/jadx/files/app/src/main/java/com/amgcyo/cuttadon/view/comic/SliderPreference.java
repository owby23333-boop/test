package com.amgcyo.cuttadon.view.comic;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.amgcyo.cuttadon.R$styleable;
import com.amgcyo.cuttadon.app.MkApplication;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class SliderPreference extends OptionFrameLayout implements View.OnClickListener {
    private int A;
    private int B;
    private int C;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private com.amgcyo.cuttadon.utils.comic.a f4512u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private FragmentManager f4513v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Fragment f4514w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f4515x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f4516y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f4517z;

    public SliderPreference(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SliderPreference);
        this.f4516y = typedArrayObtainStyledAttributes.getInt(1, -1);
        this.f4517z = typedArrayObtainStyledAttributes.getInt(0, -1);
        typedArrayObtainStyledAttributes.recycle();
    }

    public int getValue() {
        return this.B;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4513v != null) {
            com.amgcyo.cuttadon.e.a.d dVarA = com.amgcyo.cuttadon.e.a.d.a(this.A, this.f4516y, this.f4517z, this.B, this.C);
            Fragment fragment = this.f4514w;
            if (fragment != null) {
                dVarA.setTargetFragment(fragment, 0);
            }
            dVarA.show(this.f4513v, (String) null);
        }
    }

    public void setValue(int i2) {
        this.f4512u.c(this.f4515x, i2);
        this.B = i2;
        this.f4474t.setText(String.valueOf(this.B));
    }

    public SliderPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SliderPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.custom_option, this);
        this.f4512u = ((MkApplication) context.getApplicationContext()).getmPreferenceManager();
        a(context, attributeSet);
        setOnClickListener(this);
    }

    public void a(FragmentManager fragmentManager, String str, int i2, int i3, int i4) {
        a(fragmentManager, null, str, i2, i3, i4);
    }

    public void a(FragmentManager fragmentManager, com.amgcyo.cuttadon.fragment.base.a aVar, String str, int i2, int i3, int i4) {
        this.f4513v = fragmentManager;
        this.f4514w = aVar;
        this.f4515x = str;
        this.B = this.f4512u.b(str, i2);
        this.A = i3;
        this.C = i4;
        this.f4474t.setText(String.valueOf(this.B));
    }
}
