package com.amgcyo.cuttadon.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.view.otherview.ProgressWheel;
import com.amgcyo.cuttadon.view.otherview.TextDrawable;
import com.fatcatfat.io.R;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.io.File;

/* JADX INFO: compiled from: Fission6ShareDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class a1 extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4667s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Bitmap f4668t;

    /* JADX INFO: compiled from: Fission6ShareDialog.java */
    class a extends com.amgcyo.cuttadon.j.g.h.a<String, Bitmap> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f4669c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f4670d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, View view, int i2) {
            super(str);
            this.f4669c = view;
            this.f4670d = i2;
        }

        @Override // com.amgcyo.cuttadon.j.g.g.a
        public Bitmap a(String str) {
            com.amgcyo.cuttadon.utils.otherutils.m0.a(this.f4669c, DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED, 1280);
            return com.amgcyo.cuttadon.utils.otherutils.m0.a(this.f4669c);
        }

        @Override // com.amgcyo.cuttadon.j.g.g.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Bitmap bitmap) {
            if (bitmap == null || a1.this.f4667s == null) {
                a1.this.c();
                return;
            }
            int i2 = this.f4670d;
            if (i2 == 0) {
                com.amgcyo.cuttadon.utils.otherutils.g.a(a1.this.f4667s, String.valueOf(System.currentTimeMillis()), bitmap);
                return;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                try {
                    com.amgcyo.cuttadon.utils.otherutils.m0.a(a1.this.f4667s, bitmap);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    a1.this.c();
                    return;
                }
            }
            File fileA = com.amgcyo.cuttadon.utils.otherutils.m0.a(bitmap);
            if (fileA == null || !fileA.exists()) {
                a1.this.c();
                return;
            }
            try {
                com.amgcyo.cuttadon.utils.otherutils.m0.a(a1.this.f4667s, fileA);
            } catch (Exception e3) {
                e3.printStackTrace();
                a1.this.c();
            }
        }
    }

    public a1(@NonNull Context context) {
        super(context);
        this.f4667s = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        l.b.a.j.a((CharSequence) "分享失败！请使用复制链接形式进行分享。");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.view.dialog.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f4776s.b();
            }
        }, 1500L);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.td_qq /* 2131298466 */:
                a(2);
                break;
            case R.id.tv_copy /* 2131298648 */:
                b();
                break;
            case R.id.tv_savesd /* 2131298798 */:
                if (this.f4668t != null) {
                    a(0);
                } else {
                    c();
                }
                break;
            case R.id.tv_vx /* 2131298881 */:
                a(1);
                break;
        }
        dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(R.layout.fission6_share_bottom, (ViewGroup) null);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.setGravity(80);
        window.setContentView(viewInflate);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.dialog_animation);
        a();
    }

    private void a() {
        ImageView imageView = (ImageView) findViewById(R.id.img_qrcode);
        ProgressWheel progressWheel = (ProgressWheel) findViewById(R.id.fission6_progresswheel);
        progressWheel.setVisibility(0);
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(com.amgcyo.cuttadon.utils.otherutils.z.b() + File.separator + "fission6_bitmapt.jpg");
        if (bitmapDecodeFile != null) {
            imageView.setImageBitmap(bitmapDecodeFile);
            this.f4668t = bitmapDecodeFile;
            progressWheel.setVisibility(8);
        }
        ((TextDrawable) findViewById(R.id.tv_vx)).setOnClickListener(this);
        ((TextDrawable) findViewById(R.id.td_qq)).setOnClickListener(this);
        ((TextDrawable) findViewById(R.id.tv_copy)).setOnClickListener(this);
        ((TextDrawable) findViewById(R.id.tv_savesd)).setOnClickListener(this);
        ((TextView) findViewById(R.id.tv_cancel)).setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        String str = "您的好友正在使用" + com.amgcyo.cuttadon.f.o.d(R.string.app_name) + "看海量免费小说，邀你一起来体验，下载链接：" + com.amgcyo.cuttadon.utils.otherutils.g0.a().a("fission6_share_url", com.amgcyo.cuttadon.utils.otherutils.h.C0());
        com.amgcyo.cuttadon.utils.otherutils.m0.a(this.f4667s, str, str);
        com.amgcyo.cuttadon.f.o.f("复制成功，可以发给朋友们了！");
    }

    private void a(int i2) {
        View viewInflate = LayoutInflater.from(this.f4667s).inflate(R.layout.fission6_comic, (ViewGroup) null, false);
        if (viewInflate == null) {
            c();
        } else {
            ((ImageView) viewInflate.findViewById(R.id.iv_fission6_codeqr)).setImageBitmap(this.f4668t);
            com.amgcyo.cuttadon.j.g.b.a(new a("", viewInflate, i2));
        }
    }
}
