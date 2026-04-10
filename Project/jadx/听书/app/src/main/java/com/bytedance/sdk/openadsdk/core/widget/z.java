package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class z extends AlertDialog {
    private String g;
    private Context z;

    public z(Context context, String str) {
        super(context, tb.gz(context, "tt_custom_dialog"));
        this.z = context == null ? zw.getContext() : context;
        this.g = str;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.gc.wj(getContext()));
        z();
    }

    private void z() {
        ((TextView) findViewById(2114387699)).setText(this.g);
        findViewById(2114387755).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.z.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z.this.dismiss();
            }
        });
    }
}
