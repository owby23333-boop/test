package com.anythink.expressad.out;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.expressad.widget.ATImageView;

/* JADX INFO: loaded from: classes2.dex */
public class LoadingActivity extends Activity {
    private RelativeLayout b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageView f10880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bitmap f10881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f10882e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f10883f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Drawable f10885h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private RelativeLayout f10886i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.anythink.expressad.foundation.g.d.c f10884g = new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.out.LoadingActivity.1
        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            if (LoadingActivity.this.f10880c == null || bitmap == null || bitmap.isRecycled() || !((String) LoadingActivity.this.f10880c.getTag()).equals(str)) {
                return;
            }
            LoadingActivity.this.f10880c.setImageBitmap(bitmap);
            LoadingActivity.this.f10881d = bitmap;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
        }
    };
    BroadcastReceiver a = new BroadcastReceiver() { // from class: com.anythink.expressad.out.LoadingActivity.2
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            LoadingActivity.this.finish();
        }
    };

    public interface a {
        void a();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().hasExtra("icon_url")) {
            this.f10883f = getIntent().getStringExtra("icon_url");
        }
        if (this.b == null) {
            this.b = new RelativeLayout(this);
            this.f10886i = new RelativeLayout(this);
            int iB = com.anythink.expressad.foundation.h.t.b(this, 15.0f);
            this.f10886i.setPadding(iB, iB, iB, iB);
            this.f10886i.setBackgroundResource(getResources().getIdentifier("anythink_native_bg_loading_camera", com.anythink.expressad.foundation.h.i.f10645c, getPackageName()));
            this.f10886i.addView(new TextView(this), new RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(this, 140.0f), com.anythink.expressad.foundation.h.t.b(this, 31.5f)));
            this.f10880c = new ATImageView(this);
            this.f10880c.setId(com.anythink.expressad.foundation.h.t.a());
            this.f10880c.setTag(this.f10883f);
            if (!TextUtils.isEmpty(this.f10883f)) {
                com.anythink.expressad.foundation.g.d.b.a(getApplicationContext()).a(this.f10883f, this.f10884g);
            }
            int iB2 = com.anythink.expressad.foundation.h.t.b(this, 64.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iB2, iB2);
            layoutParams.addRule(13, -1);
            this.f10886i.addView(this.f10880c, layoutParams);
            TextView textView = new TextView(this);
            textView.setSingleLine();
            textView.setTextColor(-1);
            textView.setTextSize(16.0f);
            textView.setText("Relax while loading....");
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(3, this.f10880c.getId());
            layoutParams2.addRule(14, -1);
            this.f10886i.addView(textView, layoutParams2);
            this.b.addView(this.f10886i, new RelativeLayout.LayoutParams(-1, -1));
        }
        setContentView(this.b);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.a != null) {
            com.anythink.core.common.b.k.a(this).a(this.a);
        }
        ImageView imageView = this.f10880c;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        this.f10880c = null;
        this.b = null;
        this.f10884g = null;
        this.f10885h = null;
        RelativeLayout relativeLayout = this.f10886i;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundDrawable(null);
        }
        this.f10886i = null;
        Bitmap bitmap = this.f10881d;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f10881d = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ExitApp");
        if (this.a != null) {
            com.anythink.core.common.b.k.a(this).a(this.a, intentFilter);
        }
    }

    private View a() {
        if (this.b == null) {
            this.b = new RelativeLayout(this);
            this.f10886i = new RelativeLayout(this);
            int iB = com.anythink.expressad.foundation.h.t.b(this, 15.0f);
            this.f10886i.setPadding(iB, iB, iB, iB);
            this.f10886i.setBackgroundResource(getResources().getIdentifier("anythink_native_bg_loading_camera", com.anythink.expressad.foundation.h.i.f10645c, getPackageName()));
            this.f10886i.addView(new TextView(this), new RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(this, 140.0f), com.anythink.expressad.foundation.h.t.b(this, 31.5f)));
            this.f10880c = new ATImageView(this);
            this.f10880c.setId(com.anythink.expressad.foundation.h.t.a());
            this.f10880c.setTag(this.f10883f);
            if (!TextUtils.isEmpty(this.f10883f)) {
                com.anythink.expressad.foundation.g.d.b.a(getApplicationContext()).a(this.f10883f, this.f10884g);
            }
            int iB2 = com.anythink.expressad.foundation.h.t.b(this, 64.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iB2, iB2);
            layoutParams.addRule(13, -1);
            this.f10886i.addView(this.f10880c, layoutParams);
            TextView textView = new TextView(this);
            textView.setSingleLine();
            textView.setTextColor(-1);
            textView.setTextSize(16.0f);
            textView.setText("Relax while loading....");
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(3, this.f10880c.getId());
            layoutParams2.addRule(14, -1);
            this.f10886i.addView(textView, layoutParams2);
            this.b.addView(this.f10886i, new RelativeLayout.LayoutParams(-1, -1));
        }
        return this.b;
    }
}
