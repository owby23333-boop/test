package com.ss.android.downloadlib.addownload.e;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.adhost.R;

/* JADX INFO: loaded from: classes4.dex */
public class ga extends Dialog {
    private TextView bf;
    private String bh;
    private TextView d;
    private TextView e;
    private tg ga;
    private String m;
    private boolean p;
    private TextView tg;
    private boolean v;
    private d vn;
    private String wu;
    private String xu;
    private Activity zk;

    public static class e {
        private String bf;
        private String d;
        private Activity e;
        private String ga;
        private tg p;
        private String tg;
        private d v;
        private boolean vn;

        public e(Activity activity) {
            this.e = activity;
        }

        public e bf(String str) {
            this.d = str;
            return this;
        }

        public e d(String str) {
            this.tg = str;
            return this;
        }

        public e e(String str) {
            this.bf = str;
            return this;
        }

        public e tg(String str) {
            this.ga = str;
            return this;
        }

        public e e(boolean z) {
            this.vn = z;
            return this;
        }

        public e e(tg tgVar) {
            this.p = tgVar;
            return this;
        }

        public e e(d dVar) {
            this.v = dVar;
            return this;
        }

        public ga e() {
            return new ga(this.e, this.bf, this.d, this.tg, this.ga, this.vn, this.p, this.v);
        }
    }

    public ga(@NonNull Activity activity, String str, String str2, String str3, String str4, boolean z, @NonNull tg tgVar, d dVar) {
        super(activity, R.style.ttdownloader_translucent_dialog);
        this.zk = activity;
        this.ga = tgVar;
        this.m = str;
        this.wu = str2;
        this.xu = str3;
        this.bh = str4;
        this.vn = dVar;
        setCanceledOnTouchOutside(z);
        tg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        this.v = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga() {
        this.p = true;
        dismiss();
    }

    private void tg() {
        setContentView(LayoutInflater.from(this.zk.getApplicationContext()).inflate(e(), (ViewGroup) null));
        this.e = (TextView) findViewById(bf());
        this.bf = (TextView) findViewById(d());
        this.d = (TextView) findViewById(R.id.message_tv);
        this.tg = (TextView) findViewById(R.id.delete_tv);
        if (!TextUtils.isEmpty(this.wu)) {
            this.e.setText(this.wu);
        }
        if (!TextUtils.isEmpty(this.xu)) {
            this.bf.setText(this.xu);
        }
        if (TextUtils.isEmpty(this.bh)) {
            this.tg.setVisibility(8);
        } else {
            this.tg.setText(this.bh);
        }
        if (!TextUtils.isEmpty(this.m)) {
            this.d.setText(this.m);
        }
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.e.ga.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ga.this.ga();
            }
        });
        this.bf.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.e.ga.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ga.this.vn();
            }
        });
        this.tg.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.e.ga.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ga.this.delete();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vn() {
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.zk.isFinishing()) {
            this.zk.finish();
        }
        if (this.p) {
            this.ga.e();
        } else if (this.v) {
            this.vn.delete();
        } else {
            this.ga.bf();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public int bf() {
        return R.id.confirm_tv;
    }

    public int d() {
        return R.id.cancel_tv;
    }

    public int e() {
        return R.layout.ttdownloader_dialog_select_operation;
    }
}
