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
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.addownload.compliance.hj;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.guide.install.ClipImageView;
import com.ss.android.downloadlib.utils.jb;

/* JADX INFO: loaded from: classes3.dex */
public class mb extends Dialog {
    private TextView b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f17982h;
    private TextView hj;
    private long jb;
    private final com.ss.android.downloadlib.addownload.model.ox je;
    private ClipImageView ko;
    private Activity lz;
    private TextView mb;
    private TextView ox;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextView f17983u;
    private LinearLayout ww;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final long f17984x;

    public mb(@NonNull Activity activity, long j2) {
        super(activity);
        this.lz = activity;
        this.f17984x = j2;
        this.je = b.mb().get(Long.valueOf(j2));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.ss.android.socialbase.appdownloader.b.mb(this.lz);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.je == null) {
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
        this.jb = this.je.ox;
        mb();
        h.ox(EventConstants.Label.LP_APP_DIALOG_SHOW, this.jb);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.downloadlib.addownload.compliance.mb.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                h.mb(EventConstants.Refer.LP_APP_DIALOG_CANCEL, mb.this.jb);
            }
        });
    }

    private void mb() {
        this.mb = (TextView) findViewById(R.id.tv_app_name);
        this.ox = (TextView) findViewById(R.id.tv_app_version);
        this.b = (TextView) findViewById(R.id.tv_app_developer);
        this.hj = (TextView) findViewById(R.id.tv_app_detail);
        this.f17982h = (TextView) findViewById(R.id.tv_app_privacy);
        this.f17983u = (TextView) findViewById(R.id.tv_give_up);
        this.ko = (ClipImageView) findViewById(R.id.iv_app_icon);
        this.ww = (LinearLayout) findViewById(R.id.ll_download);
        this.mb.setText(jb.mb(this.je.f18011h, "--"));
        this.ox.setText("版本号：" + jb.mb(this.je.f18012u, "--"));
        this.b.setText("开发者：" + jb.mb(this.je.ko, "应用信息正在完善中"));
        this.ko.setRoundRadius(jb.mb(x.getContext(), 8.0f));
        this.ko.setBackgroundColor(Color.parseColor("#EBEBEB"));
        hj.mb().mb(this.f17984x, new hj.mb() { // from class: com.ss.android.downloadlib.addownload.compliance.mb.2
            @Override // com.ss.android.downloadlib.addownload.compliance.hj.mb
            public void mb(Bitmap bitmap) {
                if (bitmap != null) {
                    mb.this.ko.setImageBitmap(bitmap);
                } else {
                    h.mb(8, mb.this.jb);
                }
            }
        });
        this.hj.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.mb.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ox.mb().mb(mb.this.lz);
                AppDetailInfoActivity.mb(mb.this.lz, mb.this.f17984x);
                h.mb(EventConstants.Refer.LP_APP_DIALOG_CLICK_DETAIL, mb.this.jb);
            }
        });
        this.f17982h.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.mb.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ox.mb().mb(mb.this.lz);
                AppPrivacyPolicyActivity.mb(mb.this.lz, mb.this.f17984x);
                h.mb(EventConstants.Refer.LP_APP_DIALOG_CLICK_PRIVACY, mb.this.jb);
            }
        });
        this.f17983u.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.mb.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                mb.this.dismiss();
                h.mb(EventConstants.Refer.LP_APP_DIALOG_CLICK_GIVE_UP, mb.this.jb);
            }
        });
        this.ww.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.mb.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.mb(EventConstants.Refer.LP_APP_DIALOG_CLICK_DOWNLOAD, mb.this.jb);
                ox.mb().ox(mb.this.jb);
                mb.this.dismiss();
            }
        });
    }
}
