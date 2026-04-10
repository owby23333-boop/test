package com.amgcyo.cuttadon.view.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: IknowMsgDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class b1 extends AlertDialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f4674s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f4675t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextView f4676u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ImageView f4677v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Context f4678w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f4679x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private com.amgcyo.cuttadon.g.f f4680y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f4681z;

    /* JADX INFO: compiled from: IknowMsgDialog.java */
    class a extends CountDownTimer {
        final /* synthetic */ boolean a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j2, long j3, boolean z2) {
            super(j2, j3);
            this.a = z2;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            b1.this.f4674s.setEnabled(true);
            b1.this.f4674s.setText(b1.this.f4679x);
            if (this.a) {
                b1.this.f4677v.setVisibility(0);
            }
            b1.this.setCancelable(true);
            b1.this.setCanceledOnTouchOutside(true);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            String strValueOf = String.valueOf((int) (j2 / 1000));
            b1.this.f4674s.setText(String.format(b1.this.f4679x + " %ss", strValueOf));
        }
    }

    public b1(Context context) {
        super(context, R.style.style_permission_dialog);
        this.f4679x = "我知道了";
        this.f4681z = 5000L;
        this.f4678w = context;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    private void d() {
        this.f4674s.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4782s.a(view);
            }
        });
        this.f4677v.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4791s.b(view);
            }
        });
    }

    private void e() {
        this.f4674s = (TextView) findViewById(R.id.btn_kown);
        this.f4676u = (TextView) findViewById(R.id.notice_title);
        this.f4675t = (TextView) findViewById(R.id.tv_content);
        this.f4677v = (ImageView) findViewById(R.id.iv_close);
    }

    private void f() {
        Window window = getWindow();
        if (window != null) {
            Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
            WindowManager.LayoutParams attributes = window.getAttributes();
            Point point = new Point();
            defaultDisplay.getSize(point);
            double d2 = point.x;
            Double.isNaN(d2);
            attributes.width = (int) (d2 * 0.85d);
            attributes.y = -this.f4678w.getResources().getDimensionPixelOffset(R.dimen.dimen57dp);
            window.setGravity(17);
            window.setAttributes(attributes);
        }
    }

    private void g() {
        this.f4675t.post(new Runnable() { // from class: com.amgcyo.cuttadon.view.dialog.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f4786s.a();
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_iknowmsg);
        f();
        e();
        d();
    }

    private long c() {
        return this.f4681z;
    }

    public /* synthetic */ void a(View view) {
        com.amgcyo.cuttadon.g.f fVar = this.f4680y;
        if (fVar != null) {
            fVar.a();
        }
        dismiss();
    }

    public /* synthetic */ void b(View view) {
        dismiss();
    }

    public void b() {
        if (this.f4675t == null) {
            return;
        }
        this.f4676u.setText("请遵守评论规范哦");
        String str = com.amgcyo.cuttadon.utils.otherutils.g.E() + "/notice/v3/comment.html?pname=" + com.amgcyo.cuttadon.f.o.d(R.string.app_name) + "&wx=" + com.amgcyo.cuttadon.utils.otherutils.h.D0() + "&qq=" + com.amgcyo.cuttadon.utils.otherutils.h.f0();
        String str2 = "url：" + str;
        this.f4675t.setText(Html.fromHtml("提倡文明用语，禁止低俗恶意，优质评论可获得官方推荐以及福利，违反规则将可能执行删除、禁言及封号处罚。\n<br/>更多详情请查看完整<a href='" + str + "'>《社区规范》</a> "));
        this.f4675t.setMovementMethod(new com.amgcyo.cuttadon.view.otherview.o(this.f4678w, false));
        com.amgcyo.cuttadon.f.o.a(this.f4675t);
        g();
    }

    public void a(com.amgcyo.cuttadon.g.f fVar) {
        this.f4680y = fVar;
    }

    public void a(String str, String... strArr) {
        TextView textView;
        if (this.f4675t == null || (textView = this.f4674s) == null) {
            return;
        }
        if (strArr != null && strArr.length > 0) {
            textView.setText(strArr[0]);
        } else {
            this.f4674s.setText("再试一次");
        }
        SpannableString spannableString = new SpannableString(str + "\n温馨提示：\n建议你在广告出现时，通过点击任意广告的方式来减少此错误的出现！");
        spannableString.setSpan(new RelativeSizeSpan(0.8f), str.length(), str.length() + 38, 17);
        spannableString.setSpan(new ForegroundColorSpan(com.amgcyo.cuttadon.f.o.b(R.color.a2a9b2)), str.length(), str.length() + 38, 33);
        this.f4675t.setText(spannableString);
        g();
    }

    public void a(String str) {
        TextView textView = this.f4675t;
        if (textView == null) {
            return;
        }
        textView.setText(str);
        g();
        this.f4674s.setEnabled(true);
    }

    public /* synthetic */ void a() {
        if (this.f4675t.getLineCount() <= 1) {
            this.f4675t.setGravity(17);
        } else {
            this.f4675t.setGravity(19);
        }
    }

    public void a(String str, String str2, String... strArr) {
        TextView textView = this.f4675t;
        if (textView == null) {
            return;
        }
        textView.setText(str);
        g();
        this.f4674s.setEnabled(false);
        boolean z2 = !TextUtils.isEmpty(str2);
        if (z2) {
            this.f4679x = "查看详情";
        }
        if (strArr != null && strArr.length > 0) {
            this.f4676u.setText(strArr[0]);
        }
        new a(c(), 1000L, z2).start();
    }

    public void a(long j2) {
        this.f4681z = j2;
    }
}
