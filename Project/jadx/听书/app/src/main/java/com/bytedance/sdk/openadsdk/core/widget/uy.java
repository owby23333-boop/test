package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.un.oq;

/* JADX INFO: loaded from: classes2.dex */
public class uy extends AlertDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Button f1425a;
    private Button dl;
    private String e;
    private String fo;
    private TextView g;
    private Context gc;
    private String gz;
    private z kb;
    private String m;
    private Drawable uy;
    private TextView z;

    public interface z {
        void onClickNo(Dialog dialog);

        void onClickYes(Dialog dialog);
    }

    public uy(Context context) {
        super(context, tb.gz(context, "tt_custom_dialog"));
        this.gc = context;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.gc.yx(this.gc));
        setCanceledOnTouchOutside(true);
        z();
    }

    private void z() {
        this.z = (TextView) findViewById(2114387852);
        this.g = (TextView) findViewById(2114387654);
        this.dl = (Button) findViewById(2114387751);
        this.f1425a = (Button) findViewById(2114387889);
        this.dl.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.uy.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                uy.this.dismiss();
                if (uy.this.kb != null) {
                    uy.this.kb.onClickYes(uy.this);
                }
            }
        });
        this.f1425a.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.uy.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                uy.this.dismiss();
                if (uy.this.kb != null) {
                    uy.this.kb.onClickNo(uy.this);
                }
            }
        });
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        g();
    }

    private void g() {
        TextView textView = this.z;
        if (textView != null) {
            textView.setText(this.m);
            Drawable drawable = this.uy;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.uy.getIntrinsicHeight();
                int iDl = oq.dl(this.gc, 45.0f);
                if (intrinsicWidth > iDl || intrinsicWidth < iDl) {
                    intrinsicWidth = iDl;
                }
                if (intrinsicHeight > iDl || intrinsicHeight < iDl) {
                    intrinsicHeight = iDl;
                }
                this.uy.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                this.z.setCompoundDrawables(this.uy, null, null, null);
                this.z.setCompoundDrawablePadding(oq.dl(this.gc, 10.0f));
            }
        }
        TextView textView2 = this.g;
        if (textView2 != null) {
            textView2.setText(this.e);
        }
        Button button = this.dl;
        if (button != null) {
            button.setText(this.gz);
        }
        Button button2 = this.f1425a;
        if (button2 != null) {
            button2.setText(this.fo);
        }
    }

    public uy z(String str) {
        this.m = str;
        return this;
    }

    public uy g(String str) {
        this.e = str;
        return this;
    }

    public uy dl(String str) {
        this.gz = str;
        return this;
    }

    public uy a(String str) {
        this.fo = str;
        return this;
    }

    public uy z(Drawable drawable) {
        this.uy = drawable;
        return this;
    }

    public uy z(z zVar) {
        this.kb = zVar;
        return this;
    }

    public uy z(DialogInterface.OnCancelListener onCancelListener) {
        setOnCancelListener(onCancelListener);
        return this;
    }
}
