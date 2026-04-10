package com.amgcyo.cuttadon.activity.main;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.view.dialog.a1;
import com.amgcyo.cuttadon.view.otherview.ProgressWheel;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkShareActivity extends BaseTitleBarActivity<UserPresenter> {

    @BindView(R.id.fission6_progresswheel)
    ProgressWheel fission6Progresswheel;

    @BindView(R.id.img_qrcode)
    ImageView imgQrcode;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private String f2606n0;

    @BindView(R.id.tv_share)
    TextView tvShare;

    @BindView(R.id.tv_website)
    TextView tv_website;

    class a extends com.amgcyo.cuttadon.j.g.h.a<Bitmap, Bitmap> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f2607c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Bitmap bitmap, String str) {
            super(bitmap);
            this.f2607c = str;
        }

        @Override // com.amgcyo.cuttadon.j.g.g.a
        public Bitmap a(Bitmap bitmap) {
            if (bitmap == null) {
                bitmap = BitmapFactory.decodeResource(MkShareActivity.this.getResources(), R.mipmap.app_logo);
            }
            return com.king.zxing.r.a.a(this.f2607c, com.amgcyo.cuttadon.utils.otherutils.n.a(200.0f), bitmap, Color.parseColor("#00998A"));
        }

        @Override // com.amgcyo.cuttadon.j.g.g.b
        public void b(Bitmap bitmap) {
            if (bitmap != null) {
                MkShareActivity.this.imgQrcode.setImageBitmap(bitmap);
                com.amgcyo.cuttadon.utils.otherutils.m0.a("fission6_bitmapt.jpg", bitmap);
            }
            ProgressWheel progressWheel = MkShareActivity.this.fission6Progresswheel;
            if (progressWheel != null) {
                progressWheel.setVisibility(8);
            }
            TextView textView = MkShareActivity.this.tvShare;
            if (textView != null) {
                textView.setEnabled(true);
            }
        }
    }

    private void e(String str) {
        String str2 = "url:" + str;
        Context context = this.f2277w;
        if (context != null) {
            ((Activity) context).runOnUiThread(new Runnable() { // from class: com.amgcyo.cuttadon.activity.main.j0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2649s.n();
                }
            });
        }
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b("fission6_share_url", str);
        com.amgcyo.cuttadon.j.g.b.a(new a(null, str));
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return String.format("分享%s", com.amgcyo.cuttadon.f.o.d(R.string.app_name));
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        this.tvShare.setEnabled(false);
        this.f2606n0 = com.amgcyo.cuttadon.utils.otherutils.h.C0();
        String strReplace = this.f2606n0.replace("https:", "").replace("http:", "").replace("/", "");
        SpannableString spannableString = new SpannableString("App唯一官方网站: " + strReplace);
        spannableString.setSpan(new URLSpan(strReplace), 11, spannableString.length(), 33);
        this.tv_website.setText(spannableString);
        com.amgcyo.cuttadon.f.o.b(this.tv_website);
        e(this.f2606n0);
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mkshare_activity;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    public /* synthetic */ void n() {
        this.fission6Progresswheel.setVisibility(0);
    }

    @OnClick({R.id.tv_website, R.id.tv_share})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.tv_share) {
            new a1(this.f2277w).show();
        } else {
            if (id != R.id.tv_website) {
                return;
            }
            com.amgcyo.cuttadon.f.o.a(this.f2277w, this.f2606n0, R.string.website_copy_suc);
            com.amgcyo.cuttadon.view.webview.b.startActivity(this.f2277w, this.f2606n0);
        }
    }

    @Override // me.jessyan.art.base.f.h
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this));
    }
}
