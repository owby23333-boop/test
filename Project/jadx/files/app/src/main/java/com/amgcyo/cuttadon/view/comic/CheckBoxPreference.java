package com.amgcyo.cuttadon.view.comic;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.amgcyo.cuttadon.R$styleable;
import com.amgcyo.cuttadon.app.MkApplication;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class CheckBoxPreference extends FrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Switch f4430s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private com.amgcyo.cuttadon.utils.comic.a f4431t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f4432u;

    public CheckBoxPreference(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CheckBoxPreference);
        String string = typedArrayObtainStyledAttributes.getString(1);
        String string2 = typedArrayObtainStyledAttributes.getString(0);
        this.f4430s = (Switch) findViewById(R.id.custom_option_checkbox);
        TextView textView = (TextView) findViewById(R.id.custom_option_title);
        TextView textView2 = (TextView) findViewById(R.id.custom_option_summary);
        textView.setText(string);
        textView2.setText(string2);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4432u != null) {
            boolean z2 = !this.f4430s.isChecked();
            this.f4430s.setChecked(z2);
            this.f4431t.b(this.f4432u, z2);
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.custom_option_checkbox, this);
        this.f4431t = ((MkApplication) context.getApplicationContext()).getmPreferenceManager();
        a(context, attributeSet);
        setOnClickListener(this);
    }

    public void a(String str, boolean z2) {
        this.f4432u = str;
        this.f4430s.setChecked(this.f4431t.a(str, z2));
    }
}
