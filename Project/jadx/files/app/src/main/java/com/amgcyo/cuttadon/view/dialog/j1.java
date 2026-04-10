package com.amgcyo.cuttadon.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.TextView;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: PrivacyDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class j1 extends Dialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4723s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f4724t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextView f4725u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TextView f4726v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private com.amgcyo.cuttadon.g.e f4727w;

    public j1(Context context) {
        this(context, R.style.QRWaitDialog);
        this.f4723s = context;
    }

    private void a() {
        this.f4724t.setText("温馨提示");
        this.f4726v.setText("退出应用");
        this.f4726v.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4701s.a(view);
            }
        });
        String strD = com.amgcyo.cuttadon.f.o.d(R.string.app_name);
        this.f4725u.setText(Html.fromHtml("\u3000\u3000根据相关法律规定，请您同意<a href='" + com.amgcyo.cuttadon.utils.otherutils.g.C() + "'>《" + strD + "隐私政策》</a>和<a href='" + com.amgcyo.cuttadon.utils.otherutils.g.b0() + "'>《" + strD + "用户协议》</a>后再开始使用我们的应用服务。"));
        this.f4725u.setMovementMethod(new com.amgcyo.cuttadon.view.otherview.o(this.f4723s, false));
        com.amgcyo.cuttadon.f.o.a(this.f4725u);
        Animation animationA = com.amgcyo.cuttadon.j.g.a.a(5);
        this.f4725u.setAnimation(animationA);
        this.f4725u.startAnimation(animationA);
    }

    private void b() {
        Window window = getWindow();
        if (window == null || this.f4723s == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        TextView textView = (TextView) findViewById(R.id.agree);
        this.f4726v = (TextView) findViewById(R.id.not_agree);
        if (com.amgcyo.cuttadon.utils.otherutils.g.o0()) {
            textView.setText(com.amgcyo.cuttadon.f.o.d(R.string.agree_xiaomi));
            this.f4726v.setText(com.amgcyo.cuttadon.f.o.d(R.string.not_agree_xiaomi));
        }
        this.f4726v.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4696s.b(view);
            }
        });
        this.f4724t = (TextView) findViewById(R.id.title_tv);
        this.f4724t.setText(com.amgcyo.cuttadon.f.o.d(R.string.yinsi_tip));
        this.f4725u = (TextView) findViewById(R.id.tv_content);
        this.f4725u.setText(Html.fromHtml("\u3000\u3000欢迎使用" + com.amgcyo.cuttadon.f.o.d(R.string.app_name) + "，为了更好的保护您的隐私和个人信息安全，根据国家相关法律规定和标准更新了<a href='" + com.amgcyo.cuttadon.utils.otherutils.g.C() + "'>《隐私政策》</a>和<a href='" + com.amgcyo.cuttadon.utils.otherutils.g.b0() + "'>《用户协议》</a>，请您在使用前仔细阅读并了解。"));
        this.f4725u.setMovementMethod(new com.amgcyo.cuttadon.view.otherview.o(this.f4723s, false));
        com.amgcyo.cuttadon.f.o.a(this.f4725u);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4707s.c(view);
            }
        });
    }

    public /* synthetic */ void c(View view) {
        com.amgcyo.cuttadon.g.e eVar = this.f4727w;
        if (eVar != null) {
            eVar.b();
            dismiss();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_privacy);
        b();
    }

    private j1(Context context, int i2) {
        super(context, i2);
    }

    public /* synthetic */ void a(View view) {
        com.amgcyo.cuttadon.g.e eVar = this.f4727w;
        if (eVar != null) {
            eVar.a();
            dismiss();
        }
    }

    public void a(com.amgcyo.cuttadon.g.e eVar) {
        this.f4727w = eVar;
    }

    public /* synthetic */ void b(View view) {
        a();
    }
}
