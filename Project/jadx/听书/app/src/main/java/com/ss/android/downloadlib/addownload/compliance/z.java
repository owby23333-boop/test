package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.gromore.R;
import com.ss.android.downloadlib.addownload.compliance.a;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.downloadlib.e.i;
import com.ss.android.downloadlib.guide.install.ClipImageView;

/* JADX INFO: loaded from: classes4.dex */
public class z extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f1980a;
    private TextView dl;
    private ClipImageView e;
    private Activity fo;
    private TextView g;
    private TextView gc;
    private LinearLayout gz;
    private long kb;
    private TextView m;
    private final long uy;
    private final com.ss.android.downloadlib.addownload.g.g wp;
    private TextView z;

    public z(Activity activity, long j) {
        super(activity);
        this.fo = activity;
        this.uy = j;
        this.wp = (com.ss.android.downloadlib.addownload.g.g) dl.z().get(Long.valueOf(j));
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.wp == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(R.layout.ttdownloader_dialog_appinfo);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.ttdownloader_bg_transparent);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.kb = this.wp.g;
        z();
        e.g("lp_app_dialog_show", this.kb);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.downloadlib.addownload.compliance.z.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                e.z("lp_app_dialog_cancel", z.this.kb);
            }
        });
    }

    private void z() {
        this.z = (TextView) findViewById(R.id.tv_app_name);
        this.g = (TextView) findViewById(R.id.tv_app_version);
        this.dl = (TextView) findViewById(R.id.tv_app_developer);
        this.f1980a = (TextView) findViewById(R.id.tv_app_detail);
        this.gc = (TextView) findViewById(R.id.tv_app_privacy);
        this.m = (TextView) findViewById(R.id.tv_give_up);
        this.e = (ClipImageView) findViewById(R.id.iv_app_icon);
        this.gz = (LinearLayout) findViewById(R.id.ll_download);
        this.z.setText(i.z(this.wp.gc, "--"));
        this.g.setText("版本号：" + i.z(this.wp.m, "--"));
        this.dl.setText("开发者：" + i.z(this.wp.e, "应用信息正在完善中"));
        this.e.setRoundRadius(i.z(wp.getContext(), 8.0f));
        this.e.setBackgroundColor(Color.parseColor("#EBEBEB"));
        a.z().z(this.uy, new a.z() { // from class: com.ss.android.downloadlib.addownload.compliance.z.2
            @Override // com.ss.android.downloadlib.addownload.compliance.a.z
            public void z(Bitmap bitmap) {
                if (bitmap != null) {
                    z.this.e.setImageBitmap(bitmap);
                } else {
                    e.z(8, z.this.kb);
                }
            }
        });
        this.f1980a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.z.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.z().z(z.this.fo);
                AppDetailInfoActivity.z(z.this.fo, z.this.uy);
                e.z("lp_app_dialog_click_detail", z.this.kb);
            }
        });
        this.gc.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.z.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.z().z(z.this.fo);
                AppPrivacyPolicyActivity.z(z.this.fo, z.this.uy);
                e.z("lp_app_dialog_click_privacy", z.this.kb);
            }
        });
        this.m.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.z.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z.this.dismiss();
                e.z("lp_app_dialog_click_giveup", z.this.kb);
            }
        });
        this.gz.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.z.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.z("lp_app_dialog_click_download", z.this.kb);
                g.z().g(z.this.kb);
                z.this.dismiss();
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.ss.android.socialbase.appdownloader.dl.z(this.fo);
    }
}
