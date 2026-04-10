package com.amgcyo.cuttadon.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: WebUrlTipsDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class v1 extends Dialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4828s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f4829t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextView f4830u;

    public v1(Context context) {
        this(context, R.style.QRWaitDialog);
        this.f4828s = context;
    }

    private void a() {
        Window window = getWindow();
        if (window == null || this.f4828s == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.f4830u = (TextView) findViewById(R.id.agree);
        TextView textView = (TextView) findViewById(R.id.not_agree);
        textView.setText("取消");
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4783s.a(view);
            }
        });
        ((TextView) findViewById(R.id.title_tv)).setText(com.amgcyo.cuttadon.f.o.d(R.string.down_failed_tip));
        this.f4829t = (TextView) findViewById(R.id.tv_content);
        this.f4829t.setMovementMethod(new com.amgcyo.cuttadon.view.otherview.o(this.f4828s, true));
        com.amgcyo.cuttadon.f.o.a(this.f4829t);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_privacy);
        a();
    }

    private v1(Context context, int i2) {
        super(context, i2);
    }

    public /* synthetic */ void a(View view) {
        dismiss();
    }

    public void a(String str, final String str2, String str3) {
        TextView textView;
        if (this.f4828s == null || (textView = this.f4829t) == null) {
            return;
        }
        textView.setText(Html.fromHtml(str));
        this.f4830u.setText(str3);
        this.f4830u.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4787s.a(str2, view);
            }
        });
    }

    public /* synthetic */ void a(String str, View view) {
        Toast.makeText(this.f4828s, "正在使用手机默认浏览器打开", 0).show();
        com.amgcyo.cuttadon.view.webview.b.startActivity(this.f4828s, str);
        dismiss();
    }
}
