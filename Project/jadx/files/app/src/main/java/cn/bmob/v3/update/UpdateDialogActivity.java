package cn.bmob.v3.update;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import cn.bmob.v3.update.res.UpdateConfig;
import cn.bmob.v3.util.BmobDbOpenHelper;
import cn.bmob.v3.util.BmobResource;
import cn.bmob.v3.util.ManifestUtils;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class UpdateDialogActivity extends Activity implements View.OnClickListener {
    int id_button_ignore;
    int id_cancel;
    int id_checkbox_Ignore;
    int id_close;
    int id_ok;
    UpdateResponse response;
    int a = 5;
    File file = null;
    boolean isShow = false;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        finish();
        if (this.id_ok == view.getId()) {
            this.a = 6;
        } else if (this.id_cancel == view.getId()) {
            this.a = 7;
        } else if (this.id_close == view.getId()) {
            this.a = 8;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(BmobResource.getInstance(this).getLayout("bmob_update_dialog"));
        this.response = (UpdateResponse) getIntent().getExtras().getSerializable("response");
        String string = getIntent().getExtras().getString(BmobDbOpenHelper.FILE);
        this.isShow = getIntent().getExtras().getBoolean("showCheckBox", false);
        boolean z2 = string != null;
        if (z2) {
            this.file = new File(string);
        }
        int id = BmobResource.getInstance(this).getId("bmob_update_content");
        int id2 = BmobResource.getInstance(this).getId("bmob_update_wifi_indicator");
        this.id_ok = BmobResource.getInstance(this).getId("bmob_update_id_ok");
        this.id_cancel = BmobResource.getInstance(this).getId("bmob_update_id_cancel");
        this.id_button_ignore = BmobResource.getInstance(this).getId("bmob_update_id_ignore");
        this.id_close = BmobResource.getInstance(this).getId("bmob_update_id_close");
        this.id_checkbox_Ignore = BmobResource.getInstance(this).getId("bmob_update_id_check");
        if (!this.response.isforce.booleanValue() || UpdateConfig.isUpdateForce() || UpdateConfig.isSilentDownload()) {
            findViewById(this.id_close).setVisibility(8);
            findViewById(this.id_cancel).setVisibility(0);
        } else {
            findViewById(this.id_close).setVisibility(8);
            findViewById(this.id_cancel).setVisibility(8);
        }
        findViewById(this.id_ok).setOnClickListener(this);
        findViewById(this.id_cancel).setOnClickListener(this);
        findViewById(this.id_close).setOnClickListener(this);
        ((CheckBox) findViewById(this.id_checkbox_Ignore)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cn.bmob.v3.update.UpdateDialogActivity.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                if (z3) {
                    BmobUpdateAgent.add2IgnoreVersion(String.valueOf(UpdateDialogActivity.this.response.version_i));
                } else if (BmobUpdateAgent.isIgnored(String.valueOf(UpdateDialogActivity.this.response.version_i))) {
                    BmobUpdateAgent.deleteIgnoreVersion(String.valueOf(UpdateDialogActivity.this.response.version_i));
                }
            }
        });
        if (id2 > 0) {
            findViewById(id2).setVisibility(ManifestUtils.detectNetWork(this) ? 8 : 0);
        }
        if (!this.isShow || this.response.isforce.booleanValue()) {
            findViewById(this.id_checkbox_Ignore).setVisibility(8);
        } else {
            findViewById(this.id_checkbox_Ignore).setVisibility(0);
        }
        String updateInfo = this.response.getUpdateInfo(this, z2);
        TextView textView = (TextView) findViewById(id);
        textView.requestFocus();
        textView.setText(updateInfo);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        BmobUpdateAgent.dialogResult(this.a, this, this.response, this.file);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (this.response.isforce.booleanValue()) {
                return false;
            }
            this.a = 7;
            BmobUpdateAgent.dialogResult(this.a, this, this.response, this.file);
        }
        return super.onKeyDown(i2, keyEvent);
    }
}
