package com.amgcyo.cuttadon.widget.lovelydialog;

import android.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import com.amgcyo.cuttadon.widget.lovelydialog.a;

/* JADX INFO: compiled from: AbsLovelyDialog.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends a> {
    private Dialog a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageView f5653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f5654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f5655e;

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.widget.lovelydialog.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbsLovelyDialog.java */
    protected class ViewOnClickListenerC0122a implements View.OnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private View.OnClickListener f5656s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private boolean f5657t;

        protected ViewOnClickListenerC0122a(View.OnClickListener onClickListener, boolean z2) {
            this.f5656s = onClickListener;
            this.f5657t = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.f5656s;
            if (onClickListener != null) {
                if (onClickListener instanceof c) {
                    ((c) onClickListener).a(a.this.a, view.getId());
                } else {
                    onClickListener.onClick(view);
                }
            }
            if (this.f5657t) {
                a.this.a();
            }
        }
    }

    public a(Context context) {
        this(context, 0);
    }

    @LayoutRes
    protected abstract int b();

    public T b(CharSequence charSequence) {
        this.f5654d.setVisibility(0);
        this.f5654d.setText(charSequence);
        return this;
    }

    public T c(@DrawableRes int i2) {
        this.f5653c.setVisibility(0);
        this.f5653c.setImageResource(i2);
        return this;
    }

    protected String d(@StringRes int i2) {
        return this.b.getContext().getString(i2);
    }

    public Context getContext() {
        return this.b.getContext();
    }

    public a(Context context, int i2) {
        this(context, i2, 0);
    }

    private void a(AlertDialog.Builder builder, @LayoutRes int i2) {
        this.b = LayoutInflater.from(builder.getContext()).inflate(i2, (ViewGroup) null);
        this.a = builder.setView(this.b).create();
        Window window = this.a.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
            window.setWindowAnimations(com.fatcatfat.io.R.style.MyDialogTheme);
        }
        this.f5653c = (ImageView) b(com.fatcatfat.io.R.id.ld_icon);
        this.f5654d = (TextView) b(com.fatcatfat.io.R.id.ld_title);
        this.f5655e = (TextView) b(com.fatcatfat.io.R.id.ld_message);
    }

    public a(Context context, int i2, int i3) {
        a(new AlertDialog.Builder(context, com.fatcatfat.io.R.style.MyDialogTheme), i3 == 0 ? b() : i3);
    }

    protected <ViewClass extends View> ViewClass b(int i2) {
        return (ViewClass) this.b.findViewById(i2);
    }

    public Dialog c() {
        this.a.show();
        return this.a;
    }

    public T a(CharSequence charSequence) {
        this.f5655e.setVisibility(0);
        this.f5655e.setText(charSequence);
        return this;
    }

    public T a(CharSequence charSequence, float f2) {
        this.f5655e.setVisibility(0);
        this.f5655e.setTextSize(2, f2);
        this.f5655e.setLineSpacing(TypedValue.applyDimension(1, 5.0f, getContext().getResources().getDisplayMetrics()), 1.0f);
        this.f5655e.setText(charSequence);
        return this;
    }

    public T a(Drawable drawable) {
        b(com.fatcatfat.io.R.id.ld_color_area).setBackground(drawable);
        return this;
    }

    public T a(boolean z2) {
        this.a.setCancelable(z2);
        return this;
    }

    public void a() {
        this.a.dismiss();
    }

    protected int a(@ColorRes int i2) {
        return ContextCompat.getColor(getContext(), i2);
    }
}
