package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.ss.android.socialbase.appdownloader.dl;
import com.ss.android.socialbase.appdownloader.dl.a;
import com.ss.android.socialbase.appdownloader.dl.i;
import com.ss.android.socialbase.appdownloader.dl.wp;
import com.ss.android.socialbase.appdownloader.fo;
import com.ss.android.socialbase.appdownloader.g;
import com.ss.android.socialbase.appdownloader.gz;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class JumpUnknownSourceActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2045a;
    private Intent dl;
    private Intent g;
    private JSONObject gc;
    private wp z;

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        gz.z().z(this);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        z();
        gz.z().z(this);
    }

    private void z() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.g = intent;
        if (intent != null) {
            this.dl = (Intent) intent.getParcelableExtra("intent");
            this.f2045a = intent.getIntExtra("id", -1);
            try {
                this.gc = new JSONObject(intent.getStringExtra("config"));
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
        if (this.gc == null) {
            dl.z((Activity) this);
            return;
        }
        g();
        wp wpVar = this.z;
        if (wpVar != null && !wpVar.g()) {
            this.z.z();
        } else if (this.z == null) {
            finish();
        }
    }

    private void g() {
        if (this.z != null || this.g == null) {
            return;
        }
        try {
            a aVarG = com.ss.android.socialbase.appdownloader.a.kb().g();
            i iVarZ = aVarG != null ? aVarG.z(this) : null;
            if (iVarZ == null) {
                iVarZ = new com.ss.android.socialbase.appdownloader.a.z(this);
            }
            int iZ = fo.z(this, "tt_appdownloader_tip");
            int iZ2 = fo.z(this, "tt_appdownloader_label_ok");
            int iZ3 = fo.z(this, "tt_appdownloader_label_cancel");
            String strOptString = this.gc.optString("jump_unknown_source_tips");
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = getString(fo.z(this, "tt_appdownloader_jump_unknown_source_tips"));
            }
            iVarZ.z(iZ).z(strOptString).z(iZ2, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                    if (g.z(jumpUnknownSourceActivity, jumpUnknownSourceActivity.dl, JumpUnknownSourceActivity.this.f2045a, JumpUnknownSourceActivity.this.gc)) {
                        g.dl(JumpUnknownSourceActivity.this.f2045a, JumpUnknownSourceActivity.this.gc);
                    } else {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                        g.z((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.dl, true);
                    }
                    g.z(JumpUnknownSourceActivity.this.f2045a, JumpUnknownSourceActivity.this.gc);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).g(iZ3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (JumpUnknownSourceActivity.this.dl != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        g.z((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.dl, true);
                    }
                    g.g(JumpUnknownSourceActivity.this.f2045a, JumpUnknownSourceActivity.this.gc);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).z(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (JumpUnknownSourceActivity.this.dl != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        g.z((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.dl, true);
                    }
                    g.g(JumpUnknownSourceActivity.this.f2045a, JumpUnknownSourceActivity.this.gc);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).z(false);
            this.z = iVarZ.z();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }
}
