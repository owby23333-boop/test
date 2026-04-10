package com.lxj.xpopup.core;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.lxj.xpopup.R$style;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: compiled from: FullScreenDialog.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends Dialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    BasePopupView f17407s;

    public a(@NonNull Context context) {
        super(context, R$style._XPopup_TransparentDialog);
    }

    private int f() {
        int i2 = this.f17407s.f17361s.f17429x;
        return i2 == 0 ? com.lxj.xpopup.a.b() : i2;
    }

    public void a(int i2, boolean z2) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (z2) {
            attributes.flags = i2 | attributes.flags;
        } else {
            attributes.flags = (i2 ^ (-1)) & attributes.flags;
        }
        getWindow().setAttributes(attributes);
    }

    public void b() {
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            int id = childAt.getId();
            if (id != -1 && "navigationBarBackground".equals(a(id))) {
                childAt.setVisibility(4);
            }
        }
        viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() | 4610);
    }

    public boolean c() {
        return Build.VERSION.SDK_INT >= 23 && (((Activity) this.f17407s.getContext()).getWindow().getDecorView().getSystemUiVisibility() & 8192) != 0;
    }

    public boolean d() {
        boolean z2 = Build.MODEL.contains("Y") || Build.MODEL.contains("y");
        if (!com.lxj.xpopup.util.a.d()) {
            return false;
        }
        int i2 = Build.VERSION.SDK_INT;
        return (i2 == 26 || i2 == 27) && z2;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (d()) {
            motionEvent.setLocation(motionEvent.getX(), motionEvent.getY() + com.lxj.xpopup.util.b.c());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e() {
        if (Build.VERSION.SDK_INT >= 26) {
            View decorView = getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(this.f17407s.f17361s.f17430y.booleanValue() ? systemUiVisibility | 16 : systemUiVisibility & (-17));
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        BasePopupView basePopupView;
        b bVar;
        super.onCreate(bundle);
        if (getWindow() == null || (basePopupView = this.f17407s) == null || (bVar = basePopupView.f17361s) == null) {
            return;
        }
        if (bVar.H) {
            if (Build.VERSION.SDK_INT >= 26) {
                getWindow().setType(2038);
            } else {
                getWindow().setType(2003);
            }
        }
        if (this.f17407s.f17361s.M) {
            getWindow().addFlags(128);
        }
        getWindow().setBackgroundDrawable(null);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        getWindow().setFlags(16777216, 16777216);
        getWindow().setSoftInputMode(16);
        getWindow().getDecorView().setSystemUiVisibility(1280);
        getWindow().setLayout(-1, Math.max(com.lxj.xpopup.util.b.a(getContext()), com.lxj.xpopup.util.b.b(getContext())));
        if (d()) {
            getWindow().getDecorView().setTranslationY(-com.lxj.xpopup.util.b.c());
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19 && i2 < 21) {
            a(201326592, true);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            a(201326592, false);
            getWindow().setStatusBarColor(0);
            int iF = f();
            if (iF != 0) {
                getWindow().setNavigationBarColor(iF);
            }
            getWindow().addFlags(Integer.MIN_VALUE);
        }
        if (Build.VERSION.SDK_INT == 19) {
            getWindow().clearFlags(DownloadExpSwitchCode.BACK_BUGFIX_SIGBUS);
        }
        if (!this.f17407s.f17361s.f17428w.booleanValue()) {
            b();
        }
        if (!this.f17407s.f17361s.D) {
            getWindow().setFlags(8, 8);
        }
        a();
        e();
        setContentView(this.f17407s);
    }

    public void a() {
        if (!this.f17407s.f17361s.f17427v.booleanValue()) {
            getWindow().getDecorView().setSystemUiVisibility(((ViewGroup) getWindow().getDecorView()).getSystemUiVisibility() | 1284);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(c() ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    private String a(int i2) {
        try {
            return getContext().getResources().getResourceEntryName(i2);
        } catch (Exception unused) {
            return "";
        }
    }

    public a a(BasePopupView basePopupView) {
        if (basePopupView.getParent() != null) {
            ((ViewGroup) basePopupView.getParent()).removeView(basePopupView);
        }
        this.f17407s = basePopupView;
        return this;
    }
}
