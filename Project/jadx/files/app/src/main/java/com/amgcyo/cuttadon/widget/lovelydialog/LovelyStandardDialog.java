package com.amgcyo.cuttadon.widget.lovelydialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.amgcyo.cuttadon.widget.lovelydialog.a;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class LovelyStandardDialog extends a<LovelyStandardDialog> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Button f5646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Button f5647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Button f5648h;

    public enum ButtonLayout {
        HORIZONTAL(R.layout.dialog_standard),
        VERTICAL(R.layout.dialog_standard_vertical);


        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @LayoutRes
        final int f5652s;

        ButtonLayout(@LayoutRes int i2) {
            this.f5652s = i2;
        }
    }

    public LovelyStandardDialog(Context context, ButtonLayout buttonLayout) {
        super(context, 0, buttonLayout.f5652s);
        this.f5646f = (Button) b(R.id.ld_btn_yes);
        this.f5647g = (Button) b(R.id.ld_btn_no);
        this.f5648h = (Button) b(R.id.ld_btn_neutral);
    }

    public LovelyStandardDialog a(@StringRes int i2, View.OnClickListener onClickListener) {
        return a(d(i2), onClickListener);
    }

    public LovelyStandardDialog b(@StringRes int i2, View.OnClickListener onClickListener) {
        return c(d(i2), onClickListener);
    }

    public LovelyStandardDialog c(String str, @Nullable View.OnClickListener onClickListener) {
        this.f5646f.setVisibility(0);
        this.f5646f.setText(str);
        this.f5646f.setOnClickListener(new a.ViewOnClickListenerC0122a(onClickListener, true));
        return this;
    }

    public LovelyStandardDialog d() {
        this.f5647g.setVisibility(8);
        return this;
    }

    public LovelyStandardDialog e(@ColorInt int i2) {
        this.f5646f.setTextColor(i2);
        this.f5647g.setTextColor(i2);
        this.f5648h.setTextColor(i2);
        return this;
    }

    public LovelyStandardDialog f(@ColorRes int i2) {
        return e(a(i2));
    }

    public LovelyStandardDialog g(@ColorInt int i2) {
        this.f5647g.setTextColor(i2);
        return this;
    }

    public LovelyStandardDialog h(@ColorRes int i2) {
        return g(a(i2));
    }

    public LovelyStandardDialog i(@ColorInt int i2) {
        this.f5646f.setTextColor(i2);
        return this;
    }

    public LovelyStandardDialog j(@ColorRes int i2) {
        return i(a(i2));
    }

    public LovelyStandardDialog a(String str, @Nullable View.OnClickListener onClickListener) {
        this.f5647g.setVisibility(0);
        this.f5647g.setText(str);
        this.f5647g.setOnClickListener(new a.ViewOnClickListenerC0122a(onClickListener, true));
        return this;
    }

    public LovelyStandardDialog b(String str, @Nullable View.OnClickListener onClickListener, boolean z2) {
        this.f5646f.setVisibility(0);
        this.f5646f.setText(str);
        this.f5646f.setOnClickListener(new a.ViewOnClickListenerC0122a(onClickListener, z2));
        return this;
    }

    public LovelyStandardDialog a(String str, @Nullable View.OnClickListener onClickListener, boolean z2) {
        this.f5647g.setText(str);
        this.f5647g.setOnClickListener(new a.ViewOnClickListenerC0122a(onClickListener, z2));
        return this;
    }

    public LovelyStandardDialog b(boolean z2) {
        this.f5647g.setVisibility(z2 ? 8 : 0);
        return this;
    }

    public LovelyStandardDialog b(String str, @Nullable View.OnClickListener onClickListener) {
        this.f5648h.setVisibility(0);
        this.f5648h.setText(str);
        this.f5648h.setOnClickListener(new a.ViewOnClickListenerC0122a(onClickListener, true));
        return this;
    }

    public LovelyStandardDialog a(String str, boolean z2, @Nullable View.OnClickListener onClickListener) {
        this.f5648h.setVisibility(0);
        this.f5648h.setText(str);
        this.f5648h.setOnClickListener(new a.ViewOnClickListenerC0122a(onClickListener, z2));
        return this;
    }

    @Override // com.amgcyo.cuttadon.widget.lovelydialog.a
    protected int b() {
        return ButtonLayout.HORIZONTAL.f5652s;
    }
}
