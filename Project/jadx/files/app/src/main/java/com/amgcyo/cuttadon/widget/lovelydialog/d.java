package com.amgcyo.cuttadon.widget.lovelydialog;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.amgcyo.cuttadon.widget.lovelydialog.a;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: LovelyTextInputDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends com.amgcyo.cuttadon.widget.lovelydialog.a<d> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private EditText f5663f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f5664g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f5665h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f5666i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private InterfaceC0124d f5667j;

    /* JADX INFO: compiled from: LovelyTextInputDialog.java */
    private class b implements TextWatcher {
        private b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            d.this.d();
        }
    }

    /* JADX INFO: compiled from: LovelyTextInputDialog.java */
    public interface c {
        void a(String str);
    }

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.widget.lovelydialog.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LovelyTextInputDialog.java */
    public interface InterfaceC0124d {
        boolean check(String str);
    }

    /* JADX INFO: compiled from: LovelyTextInputDialog.java */
    private class e implements View.OnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private c f5669s;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String string = d.this.f5663f.getText().toString();
            if (d.this.f5667j != null && (!d.this.f5667j.check(string))) {
                d.this.e();
                return;
            }
            c cVar = this.f5669s;
            if (cVar != null) {
                cVar.a(string);
            }
            d.this.a();
        }

        private e(c cVar) {
            this.f5669s = cVar;
        }
    }

    public d(Context context, int i2) {
        super(context, i2);
        this.f5665h = (TextView) b(R.id.ld_btn_confirm);
        this.f5666i = (TextView) b(R.id.ld_btn_negative);
        this.f5663f = (EditText) b(R.id.ld_text_input);
        this.f5664g = (TextView) b(R.id.ld_error_message);
        this.f5663f.addTextChangedListener(new b());
    }

    @Override // com.amgcyo.cuttadon.widget.lovelydialog.a
    protected int b() {
        return R.layout.dialog_text_input;
    }

    public d e(int i2) {
        this.f5665h.setTextColor(a(i2));
        return this;
    }

    public d f(int i2) {
        this.f5666i.setTextColor(a(i2));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f5664g.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f5664g.setVisibility(0);
    }

    public d a(@NonNull com.amgcyo.cuttadon.widget.lovelydialog.e<EditText> eVar) {
        eVar.a(this.f5663f);
        return this;
    }

    public d a(@StringRes int i2, c cVar) {
        return a(d(i2), cVar);
    }

    public d a(String str, c cVar) {
        this.f5665h.setText(str);
        this.f5665h.setOnClickListener(new e(cVar));
        return this;
    }

    public d a(@StringRes int i2, View.OnClickListener onClickListener) {
        return a(d(i2), onClickListener);
    }

    public d a(String str, View.OnClickListener onClickListener) {
        this.f5666i.setVisibility(0);
        this.f5666i.setText(str);
        this.f5666i.setOnClickListener(new a.ViewOnClickListenerC0122a(onClickListener, true));
        return this;
    }

    public d a(@StringRes int i2, InterfaceC0124d interfaceC0124d) {
        return a(d(i2), interfaceC0124d);
    }

    public d a(String str, InterfaceC0124d interfaceC0124d) {
        this.f5667j = interfaceC0124d;
        this.f5664g.setText(str);
        return this;
    }

    public d a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f5663f.setText(str);
        }
        return this;
    }
}
