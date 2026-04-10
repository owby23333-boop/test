package com.amgcyo.cuttadon.view.comment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import com.amgcyo.cuttadon.f.o;
import com.fatcatfat.io.R;
import java.util.Locale;

/* JADX INFO: compiled from: MkCommentDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends Dialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private EditText f4630s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f4631t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f4632u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private InterfaceC0115c f4633v;

    /* JADX INFO: compiled from: MkCommentDialog.java */
    class a implements TextWatcher {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ TextView f4634s;

        a(TextView textView) {
            this.f4634s = textView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            c.this.f4631t.setText(String.format(Locale.getDefault(), "%d/%d", Integer.valueOf(c.this.f4630s.length()), Integer.valueOf(c.this.f4632u)));
            if (c.this.f4630s.length() > c.this.f4632u) {
                c.this.f4631t.setTextColor(o.b(R.color.dot_hong));
                c.this.f4630s.setText(editable.toString().substring(0, c.this.f4632u));
                c.this.f4630s.setSelection(c.this.f4632u);
                o.b("您最多能输入" + c.this.f4632u + "个字");
            } else {
                c.this.f4631t.setTextColor(o.b(R.color.text_bottom_comment));
            }
            if (editable.length() > 0) {
                this.f4634s.setBackgroundResource(R.drawable.corners_review_cansend);
            } else {
                this.f4634s.setBackgroundResource(R.drawable.corners_review_send);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* JADX INFO: compiled from: MkCommentDialog.java */
    class b extends com.amgcyo.cuttadon.j.e.a {
        b(int i2) {
            super(i2);
        }

        @Override // com.amgcyo.cuttadon.j.e.a
        public void a(View view) {
            if (TextUtils.isEmpty(c.this.f4630s.getText().toString())) {
                o.b("输入内容为空");
            } else {
                c.this.f4633v.a(c.this.f4630s.getText().toString());
            }
        }
    }

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.view.comment.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MkCommentDialog.java */
    public interface InterfaceC0115c {
        void a(String str);
    }

    public c(Context context) {
        this(context, R.style.comment_style);
    }

    private c(Context context, int i2) {
        super(context, i2);
        this.f4632u = 200;
        setContentView(R.layout.comment_dialog_layout);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.softInputMode = 5;
            attributes.flags = 2;
            attributes.width = window.getWindowManager().getDefaultDisplay().getWidth();
            window.setAttributes(attributes);
            a();
        }
    }

    private void a() {
        this.f4630s = (EditText) findViewById(R.id.dialog_comment_content);
        this.f4631t = (TextView) findViewById(R.id.tv_test);
        a(this.f4632u);
        TextView textView = (TextView) findViewById(R.id.dialog_comment_send);
        this.f4630s.addTextChangedListener(new a(textView));
        textView.setOnClickListener(new b(1200));
        this.f4630s.setFocusable(true);
        this.f4630s.setFocusableInTouchMode(true);
        this.f4630s.requestFocus();
    }

    @SuppressLint({"SetTextI18n"})
    private void a(int i2) {
        this.f4632u = i2;
        this.f4631t.setText("0/" + i2);
    }

    public c a(String str) {
        this.f4630s.setHint(str);
        return this;
    }

    public c a(InterfaceC0115c interfaceC0115c) {
        this.f4633v = interfaceC0115c;
        return this;
    }
}
