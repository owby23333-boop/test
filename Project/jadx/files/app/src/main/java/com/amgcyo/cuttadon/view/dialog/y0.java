package com.amgcyo.cuttadon.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.amgcyo.cuttadon.api.entity.other.FissionUser;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: Fission5TxaccountDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class y0 extends Dialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4838s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private FissionUser f4839t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f4840u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private a f4841v;

    /* JADX INFO: compiled from: Fission5TxaccountDialog.java */
    public interface a {
        void a();

        void b();
    }

    public y0(Context context, FissionUser fissionUser, String str) {
        this(context, R.style.QRWaitDialog);
        this.f4838s = context;
        this.f4839t = fissionUser;
        this.f4840u = str;
    }

    private void a() {
        Window window = getWindow();
        if (window == null || this.f4838s == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        TextView textView = (TextView) findViewById(R.id.tv_update);
        ((TextView) findViewById(R.id.confirm_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4766s.a(view);
            }
        });
        TextView textView2 = (TextView) findViewById(R.id.tv_money);
        TextView textView3 = (TextView) findViewById(R.id.tv_name);
        TextView textView4 = (TextView) findViewById(R.id.tv_account);
        textView2.setText(this.f4840u);
        textView3.setText(this.f4839t.getFissionName());
        textView4.setText(this.f4839t.getFissionZfb());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4756s.b(view);
            }
        });
    }

    public /* synthetic */ void b(View view) {
        a aVar = this.f4841v;
        if (aVar != null) {
            aVar.a();
            dismiss();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_tx_account);
        a();
    }

    private y0(Context context, int i2) {
        super(context, i2);
    }

    public /* synthetic */ void a(View view) {
        a aVar = this.f4841v;
        if (aVar != null) {
            aVar.b();
            dismiss();
        }
    }

    public void a(a aVar) {
        this.f4841v = aVar;
    }
}
