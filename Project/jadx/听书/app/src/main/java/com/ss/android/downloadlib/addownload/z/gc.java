package com.ss.android.downloadlib.addownload.z;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ss.android.downloadlib.e.i;

/* JADX INFO: loaded from: classes4.dex */
public class gc extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1998a;
    private boolean dl;
    private String e;
    private String fo;
    private dl g;
    private Activity gc;
    private String gz;
    private String m;
    private a z;

    public gc(Activity activity, String str, String str2, String str3, String str4, boolean z2, a aVar, dl dlVar) {
        super(activity);
        this.gc = activity;
        this.z = aVar;
        this.m = str;
        this.e = str2;
        this.gz = str3;
        this.fo = str4;
        this.g = dlVar;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCanceledOnTouchOutside(z2);
        z(this.gc);
    }

    private void z(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(z(context, 290), -2);
        linearLayout2.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setBackground(z(context, "#ffffff", 4));
        linearLayout2.setOrientation(1);
        int iZ = z(context, 16);
        TextView textView = new TextView(context);
        textView.setTextSize(2, 16.0f);
        textView.setText("是否在WiFi环境下恢复下载？");
        textView.setTextColor(Color.parseColor("#222222"));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(iZ, iZ, iZ, iZ);
        textView.setLayoutParams(layoutParams3);
        if (!TextUtils.isEmpty(this.m)) {
            textView.setText(this.m);
        }
        linearLayout2.addView(textView);
        LinearLayout linearLayout3 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = z(context, 26);
        layoutParams4.bottomMargin = iZ;
        linearLayout3.setOrientation(0);
        linearLayout3.setLayoutParams(layoutParams4);
        TextView textView2 = new TextView(context);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(z(context, 70), z(context, 33)));
        textView2.setText("管理");
        textView2.setTextColor(Color.parseColor("#CFCFCF"));
        textView2.setTextSize(2, 13.0f);
        textView2.setGravity(17);
        if (!TextUtils.isEmpty(this.fo)) {
            textView2.setText(this.fo);
            linearLayout3.addView(textView2);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.z.gc.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    gc.this.delete();
                }
            });
        }
        LinearLayout linearLayout4 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout4.setOrientation(0);
        layoutParams5.rightMargin = z(context, 16);
        linearLayout4.setGravity(5);
        linearLayout4.setLayoutParams(layoutParams5);
        TextView textView3 = new TextView(context);
        textView3.setLayoutParams(new LinearLayout.LayoutParams(z(context, 70), z(context, 33)));
        textView3.setTextColor(Color.parseColor("#CFCFCF"));
        textView3.setText("不，谢谢");
        textView3.setTextSize(2, 13.0f);
        textView3.setGravity(17);
        if (!TextUtils.isEmpty(this.gz)) {
            textView3.setText(this.gz);
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.z.gc.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                gc.this.g();
            }
        });
        linearLayout4.addView(textView3);
        TextView textView4 = new TextView(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(z(context, 70), z(context, 33));
        layoutParams6.leftMargin = z(context, 8);
        layoutParams6.gravity = 5;
        textView4.setLayoutParams(layoutParams6);
        textView4.setTextColor(Color.parseColor("#ffffff"));
        textView4.setTextSize(2, 13.0f);
        textView4.setText("好的");
        textView4.setGravity(17);
        if (!TextUtils.isEmpty(this.e)) {
            textView4.setText(this.e);
        }
        textView4.setBackground(z(context, "#2A90D7", 2));
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.z.gc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                gc.this.z();
            }
        });
        linearLayout4.addView(textView4);
        linearLayout3.addView(linearLayout4);
        linearLayout2.addView(linearLayout3);
        linearLayout.addView(linearLayout2);
        setContentView(linearLayout);
    }

    private static GradientDrawable z(Context context, String str, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius(z(context, i));
        return gradientDrawable;
    }

    private static int z(Context context, int i) {
        return i.z(context, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        this.dl = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        this.f1998a = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.gc.isFinishing()) {
            this.gc.finish();
        }
        if (this.dl) {
            this.z.z();
        } else if (this.f1998a) {
            this.g.delete();
        } else {
            this.z.g();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f1999a;
        private String dl;
        private a e;
        private String g;
        private String gc;
        private dl gz;
        private boolean m;
        private Activity z;

        public z(Activity activity) {
            this.z = activity;
        }

        public z z(String str) {
            this.g = str;
            return this;
        }

        public z g(String str) {
            this.dl = str;
            return this;
        }

        public z dl(String str) {
            this.f1999a = str;
            return this;
        }

        public z a(String str) {
            this.gc = str;
            return this;
        }

        public z z(boolean z) {
            this.m = z;
            return this;
        }

        public z z(a aVar) {
            this.e = aVar;
            return this;
        }

        public z z(dl dlVar) {
            this.gz = dlVar;
            return this;
        }

        public gc z() {
            return new gc(this.z, this.g, this.dl, this.f1999a, this.gc, this.m, this.e, this.gz);
        }
    }
}
