package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.appdownloader.b;
import com.ss.android.socialbase.appdownloader.b.jb;
import com.ss.android.socialbase.appdownloader.b.je;
import com.ss.android.socialbase.appdownloader.hj;
import com.ss.android.socialbase.appdownloader.lz;
import com.ss.android.socialbase.appdownloader.ox;
import com.ss.android.socialbase.appdownloader.ww;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class JumpUnknownSourceActivity extends Activity {

    @Nullable
    private Intent b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private JSONObject f18093h;
    private int hj;
    private jb mb;
    private Intent ox;

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        mb();
        ww.mb().mb(this);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        ww.mb().mb(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.ox = intent;
        if (intent != null) {
            this.b = (Intent) intent.getParcelableExtra("intent");
            this.hj = intent.getIntExtra("id", -1);
            try {
                this.f18093h = new JSONObject(intent.getStringExtra("config"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (this.f18093h == null) {
            b.mb((Activity) this);
            return;
        }
        ox();
        jb jbVar = this.mb;
        if (jbVar != null && !jbVar.ox()) {
            this.mb.mb();
        } else if (this.mb == null) {
            finish();
        }
    }

    private void mb() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void ox() {
        if (this.mb != null || this.ox == null) {
            return;
        }
        try {
            com.ss.android.socialbase.appdownloader.b.b bVarMb = hj.x().mb();
            je jeVarMb = bVarMb != null ? bVarMb.mb(this) : null;
            if (jeVarMb == null) {
                jeVarMb = new com.ss.android.socialbase.appdownloader.hj.mb(this);
            }
            int iMb = lz.mb(this, "tt_appdownloader_tip");
            int iMb2 = lz.mb(this, "tt_appdownloader_label_ok");
            int iMb3 = lz.mb(this, "tt_appdownloader_label_cancel");
            String strOptString = this.f18093h.optString(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNOWN_SOURCE_TIPS);
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = getString(lz.mb(this, "tt_appdownloader_jump_unknown_source_tips"));
            }
            jeVarMb.mb(iMb).mb(strOptString).mb(iMb2, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                    if (ox.mb(jumpUnknownSourceActivity, jumpUnknownSourceActivity.b, JumpUnknownSourceActivity.this.hj, JumpUnknownSourceActivity.this.f18093h)) {
                        ox.b(JumpUnknownSourceActivity.this.hj, JumpUnknownSourceActivity.this.f18093h);
                    } else {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                        ox.mb((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.b, true);
                    }
                    ox.mb(JumpUnknownSourceActivity.this.hj, JumpUnknownSourceActivity.this.f18093h);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).ox(iMb3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    if (JumpUnknownSourceActivity.this.b != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        ox.mb((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.b, true);
                    }
                    ox.ox(JumpUnknownSourceActivity.this.hj, JumpUnknownSourceActivity.this.f18093h);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).mb(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (JumpUnknownSourceActivity.this.b != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        ox.mb((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.b, true);
                    }
                    ox.ox(JumpUnknownSourceActivity.this.hj, JumpUnknownSourceActivity.this.f18093h);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).mb(false);
            this.mb = jeVarMb.mb();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
