package com.amgcyo.cuttadon.view.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: ConfirmCancelMsgDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class s0 extends AlertDialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4792s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private CheckBox f4793t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextView f4794u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TextView f4795v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f4796w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextView f4797x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private com.amgcyo.cuttadon.g.e f4798y;

    public s0(Context context) {
        super(context, R.style.style_permission_dialog);
        this.f4792s = context;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    private void a() {
        this.f4793t = (CheckBox) findViewById(R.id.notice_check);
        this.f4794u = (TextView) findViewById(R.id.notice_tips_left_btn);
        this.f4796w = (TextView) findViewById(R.id.notice_title);
        this.f4797x = (TextView) findViewById(R.id.notice_content);
        this.f4794u.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4682s.a(view);
            }
        });
        this.f4795v = (TextView) findViewById(R.id.notice_tips_right_btn);
        this.f4794u.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4672s.b(view);
            }
        });
        this.f4795v.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4665s.c(view);
            }
        });
    }

    public /* synthetic */ void b(View view) {
        dismiss();
    }

    public /* synthetic */ void c(View view) {
        com.amgcyo.cuttadon.g.e eVar = this.f4798y;
        if (eVar != null) {
            eVar.b();
        }
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
            attributes.y = com.amgcyo.cuttadon.utils.otherutils.n.a(this.f4792s) / 5;
            window.setGravity(48);
            window.setAttributes(attributes);
        }
        a();
    }

    public /* synthetic */ void a(View view) {
        com.amgcyo.cuttadon.g.e eVar = this.f4798y;
        if (eVar != null) {
            eVar.a();
        }
        dismiss();
    }

    public void a(String str, String str2, String str3, String str4) {
        TextView textView = this.f4794u;
        if (textView == null) {
            return;
        }
        textView.setText(str);
        this.f4795v.setText(str2);
        this.f4796w.setText(str3);
        this.f4797x.setText(str4);
        this.f4793t.setVisibility(8);
    }

    public void a(com.amgcyo.cuttadon.g.e eVar) {
        this.f4798y = eVar;
    }
}
