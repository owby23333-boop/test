package com.amgcyo.cuttadon.view.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: NoticeTipsStatusDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class f1 extends AlertDialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4702s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f4703t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f4704u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private com.amgcyo.cuttadon.utils.otherutils.g0 f4705v;

    public f1(Context context, String str, String str2) {
        super(context, R.style.style_permission_dialog);
        this.f4702s = context;
        this.f4703t = str;
        this.f4704u = str2;
        this.f4705v = com.amgcyo.cuttadon.utils.otherutils.g0.a();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    private void a() {
        CheckBox checkBox = (CheckBox) findViewById(R.id.notice_check);
        checkBox.setChecked(this.f4705v.a(this.f4703t, false));
        TextView textView = (TextView) findViewById(R.id.notice_tips_left_btn);
        TextView textView2 = (TextView) findViewById(R.id.notice_tips_right_btn);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4831s.a(view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4811s.b(view);
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.amgcyo.cuttadon.view.dialog.v
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.a.a(compoundButton, z2);
            }
        });
    }

    public /* synthetic */ void b(View view) {
        com.amgcyo.cuttadon.utils.otherutils.f0.a(this.f4702s);
        dismiss();
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.notice_tips_dialog);
        Window window = getWindow();
        if (window != null) {
            Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
            WindowManager.LayoutParams attributes = window.getAttributes();
            Point point = new Point();
            defaultDisplay.getSize(point);
            double d2 = point.x;
            Double.isNaN(d2);
            attributes.width = (int) (d2 * 0.8d);
            attributes.y = com.amgcyo.cuttadon.utils.otherutils.n.a(this.f4702s) / 5;
            window.setGravity(48);
            window.setAttributes(attributes);
        }
        a();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.f4705v == null || TextUtils.isEmpty(this.f4704u)) {
            return;
        }
        this.f4705v.b(this.f4704u, true);
    }

    public /* synthetic */ void a(View view) {
        dismiss();
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z2) {
        this.f4705v.b(this.f4703t, z2);
    }
}
