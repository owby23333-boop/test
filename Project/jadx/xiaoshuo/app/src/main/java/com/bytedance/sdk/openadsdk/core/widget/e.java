package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.dt;
import com.bytedance.sdk.openadsdk.core.lc;

/* JADX INFO: loaded from: classes10.dex */
public class e extends AlertDialog {
    private String bf;
    private Context e;

    public e(Context context, String str) {
        super(context, dt.p(context, "tt_custom_dialog"));
        this.e = context == null ? lc.getContext() : context;
        this.bf = str;
    }

    private void e() {
        ((TextView) findViewById(dt.ga(this.e, "tt_dialog_content"))).setText(this.bf);
        findViewById(dt.ga(this.e, "tt_button_ok")).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
            }
        });
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(dt.vn(this.e, "tt_adinfo_dialog_layout"));
        e();
    }
}
