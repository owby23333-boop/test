package com.amgcyo.cuttadon.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.amgcyo.cuttadon.view.otherview.CommonShapeButton;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: StartToTtsDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class r1 extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4789s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private com.amgcyo.cuttadon.g.e f4790t;

    public r1(Context context) {
        this(context, R.style.QRWaitDialog);
        this.f4789s = context;
    }

    private void a() {
        Window window = getWindow();
        if (window == null || this.f4789s == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.width = (int) (com.amgcyo.cuttadon.utils.otherutils.n.c(this.f4789s) * 0.8f);
        attributes.height = -2;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        TextView textView = (TextView) findViewById(R.id.tv_tips);
        CommonShapeButton commonShapeButton = (CommonShapeButton) findViewById(R.id.btn_kown);
        TextView textView2 = (TextView) findViewById(R.id.tv_content);
        ImageView imageView = (ImageView) findViewById(R.id.iv_close);
        textView.setText("听书模式");
        commonShapeButton.setText("看小视频免费听书");
        String strD = com.amgcyo.cuttadon.f.o.d(R.string.tingshu_msg_not_time);
        SpannableString spannableString = new SpannableString(strD + "\n\n提示：听书为第三方付费服务，您只需观看一段小视频即可免费使用。感谢您的支持与理解！");
        int length = strD.length();
        int i2 = length + 43;
        spannableString.setSpan(new AbsoluteSizeSpan(11, true), length, i2, 33);
        spannableString.setSpan(new ForegroundColorSpan(com.amgcyo.cuttadon.f.o.b(R.color.a2a9b2)), length, i2, 33);
        textView2.setText(spannableString);
        commonShapeButton.setOnClickListener(this);
        imageView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.btn_kown) {
            if (id != R.id.iv_close) {
                return;
            }
            dismiss();
        } else {
            com.amgcyo.cuttadon.g.e eVar = this.f4790t;
            if (eVar != null) {
                eVar.b();
            }
            dismiss();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_tips_dialog);
        a();
    }

    private r1(Context context, int i2) {
        super(context, i2);
    }

    public void a(com.amgcyo.cuttadon.g.e eVar) {
        this.f4790t = eVar;
    }
}
