package com.amgcyo.cuttadon.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: FattenDescDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class x0 extends Dialog {
    public x0(Context context) {
        this(context, R.style.QRWaitDialog);
    }

    private void a() {
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Button button = (Button) findViewById(R.id.fatten_desc_btn);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4745s.a(view);
            }
        });
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_fatten_desc);
        a();
    }

    private x0(Context context, int i2) {
        super(context, i2);
    }

    public /* synthetic */ void a(View view) {
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b("shelf_show_fatten_desc_dialog", true);
        dismiss();
    }
}
