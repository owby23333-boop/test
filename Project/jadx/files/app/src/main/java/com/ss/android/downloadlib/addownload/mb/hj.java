package com.ss.android.downloadlib.addownload.mb;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.R;

/* JADX INFO: loaded from: classes3.dex */
public class hj extends Dialog {
    private TextView b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f17997h;
    private b hj;
    private String ko;
    private String lz;
    private TextView mb;
    private TextView ox;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Activity f17998u;
    private String ww;

    public static class mb {
        private String b;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f17999h;
        private String hj;
        private Activity mb;
        private String ox;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private b f18000u;

        public mb(Activity activity) {
            this.mb = activity;
        }

        public mb b(String str) {
            this.hj = str;
            return this;
        }

        public mb mb(String str) {
            this.ox = str;
            return this;
        }

        public mb ox(String str) {
            this.b = str;
            return this;
        }

        public mb mb(boolean z2) {
            this.f17999h = z2;
            return this;
        }

        public mb mb(b bVar) {
            this.f18000u = bVar;
            return this;
        }

        public hj mb() {
            return new hj(this.mb, this.ox, this.b, this.hj, this.f17999h, this.f18000u);
        }
    }

    public hj(@NonNull Activity activity, String str, String str2, String str3, boolean z2, @NonNull b bVar) {
        super(activity, R.style.ttdownloader_translucent_dialog);
        this.f17998u = activity;
        this.hj = bVar;
        this.ko = str;
        this.ww = str2;
        this.lz = str3;
        setCanceledOnTouchOutside(z2);
        hj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f17997h = true;
        dismiss();
    }

    private void hj() {
        setContentView(LayoutInflater.from(this.f17998u.getApplicationContext()).inflate(mb(), (ViewGroup) null));
        this.mb = (TextView) findViewById(ox());
        this.ox = (TextView) findViewById(b());
        this.b = (TextView) findViewById(R.id.message_tv);
        if (!TextUtils.isEmpty(this.ww)) {
            this.mb.setText(this.ww);
        }
        if (!TextUtils.isEmpty(this.lz)) {
            this.ox.setText(this.lz);
        }
        if (!TextUtils.isEmpty(this.ko)) {
            this.b.setText(this.ko);
        }
        this.mb.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.mb.hj.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hj.this.h();
            }
        });
        this.ox.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.mb.hj.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hj.this.u();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        dismiss();
    }

    public int b() {
        return R.id.cancel_tv;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.f17998u.isFinishing()) {
            this.f17998u.finish();
        }
        if (this.f17997h) {
            this.hj.mb();
        } else {
            this.hj.ox();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public int mb() {
        return R.layout.ttdownloader_dialog_select_operation;
    }

    public int ox() {
        return R.id.confirm_tv;
    }
}
