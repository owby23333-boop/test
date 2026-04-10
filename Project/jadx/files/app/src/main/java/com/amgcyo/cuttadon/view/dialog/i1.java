package com.amgcyo.cuttadon.view.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: PermissionTipsDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class i1 extends AlertDialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4715s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ScrollView f4716t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private LinearLayout f4717u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TextView f4718v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f4719w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private a f4720x;

    /* JADX INFO: compiled from: PermissionTipsDialog.java */
    public interface a {
        void a();

        void b();
    }

    public i1(Context context) {
        super(context, R.style.style_permission_dialog);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.f4715s = context;
    }

    private void a() {
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, Color.red(r0), 0.0f, 1.0f, 0.0f, 0.0f, Color.green(r0), 0.0f, 0.0f, 1.0f, 0.0f, Color.blue(this.f4715s.getResources().getColor(R.color.permission_dialog_img_color)), 0.0f, 0.0f, 0.0f, 1.0f, 1.0f});
        int[] intArray = this.f4715s.getResources().getIntArray(R.array.permission_icon);
        String[] stringArray = this.f4715s.getResources().getStringArray(R.array.permission_title);
        String[] stringArray2 = this.f4715s.getResources().getStringArray(R.array.permission_info);
        for (int i2 = 0; i2 < intArray.length; i2++) {
            String str = stringArray[i2];
            String str2 = stringArray2[i2];
            View viewInflate = View.inflate(this.f4715s, R.layout.permission_list_item, null);
            TypedArray typedArrayObtainTypedArray = this.f4715s.getResources().obtainTypedArray(R.array.permission_icon);
            ((ImageView) viewInflate.findViewById(R.id.item_img)).setImageResource(typedArrayObtainTypedArray.getResourceId(i2, 0));
            ((ImageView) viewInflate.findViewById(R.id.item_img)).setColorFilter(colorMatrixColorFilter);
            ((TextView) viewInflate.findViewById(R.id.item_title)).setText(str);
            ((TextView) viewInflate.findViewById(R.id.item_info)).setText(str2);
            this.f4717u.addView(viewInflate);
            typedArrayObtainTypedArray.recycle();
        }
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.f4715s).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final int i3 = displayMetrics.heightPixels;
        this.f4716t.setLayoutParams(new LinearLayout.LayoutParams(displayMetrics.widthPixels - (this.f4715s.getResources().getDimensionPixelOffset(R.dimen.permission_dialog_margin) * 2), -2));
        this.f4716t.post(new Runnable() { // from class: com.amgcyo.cuttadon.view.dialog.d0
            @Override // java.lang.Runnable
            public final void run() {
                this.f4692s.a(i3, displayMetrics);
            }
        });
    }

    private void b() {
        this.f4718v.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4673s.a(view);
            }
        });
        this.f4719w.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4683s.b(view);
            }
        });
    }

    private void c() {
        this.f4716t = (ScrollView) findViewById(R.id.permission_dialog_list_scroll);
        this.f4717u = (LinearLayout) findViewById(R.id.layout_list);
        this.f4718v = (TextView) findViewById(R.id.agree);
        this.f4719w = (TextView) findViewById(R.id.not_agree);
        if (com.amgcyo.cuttadon.utils.otherutils.g.o0()) {
            this.f4718v.setText(com.amgcyo.cuttadon.f.o.d(R.string.agree_xiaomi));
            this.f4719w.setText(com.amgcyo.cuttadon.f.o.d(R.string.not_agree_xiaomi));
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.permission_dialog_layout);
        c();
        a();
        b();
    }

    public /* synthetic */ void b(View view) {
        a aVar = this.f4720x;
        if (aVar != null) {
            aVar.b();
        }
        dismiss();
    }

    public /* synthetic */ void a(int i2, DisplayMetrics displayMetrics) {
        int i3 = i2 / 2;
        if (this.f4716t.getMeasuredHeight() > i3) {
            this.f4716t.setLayoutParams(new LinearLayout.LayoutParams(displayMetrics.widthPixels - (this.f4715s.getResources().getDimensionPixelOffset(R.dimen.permission_dialog_margin) * 2), i3));
        } else {
            this.f4716t.setLayoutParams(new LinearLayout.LayoutParams(displayMetrics.widthPixels - (this.f4715s.getResources().getDimensionPixelOffset(R.dimen.permission_dialog_margin) * 2), -2));
        }
    }

    public /* synthetic */ void a(View view) {
        a aVar = this.f4720x;
        if (aVar != null) {
            aVar.a();
        }
        dismiss();
    }

    public void a(a aVar) {
        this.f4720x = aVar;
    }
}
