package com.anythink.expressad.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.OrientationEventListener;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.anythink.expressad.foundation.f.b;
import com.anythink.expressad.foundation.h.o;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ATBaseActivity extends Activity {
    private static final String a = "ATBaseActivity";
    private OrientationEventListener b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Display f8123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8124d = -1;

    /* JADX INFO: renamed from: com.anythink.expressad.activity.ATBaseActivity$2, reason: invalid class name */
    final class AnonymousClass2 extends OrientationEventListener {
        AnonymousClass2(Context context) {
            super(context, 1);
        }

        @Override // android.view.OrientationEventListener
        public final void onOrientationChanged(int i2) {
            int iC = ATBaseActivity.this.c();
            if (iC < 0) {
                iC = 0;
            }
            if (iC == 1 && ATBaseActivity.this.f8124d != 1) {
                ATBaseActivity.this.f8124d = 1;
                ATBaseActivity.this.a();
                o.d(ATBaseActivity.a, "Orientation Left");
                return;
            }
            if (iC == 3 && ATBaseActivity.this.f8124d != 2) {
                ATBaseActivity.this.f8124d = 2;
                ATBaseActivity.this.a();
                o.d(ATBaseActivity.a, "Orientation Right");
            } else if (iC == 0 && ATBaseActivity.this.f8124d != 3) {
                ATBaseActivity.this.f8124d = 3;
                ATBaseActivity.this.a();
                o.d(ATBaseActivity.a, "Orientation Top");
            } else {
                if (iC != 2 || ATBaseActivity.this.f8124d == 4) {
                    return;
                }
                ATBaseActivity.this.f8124d = 4;
                ATBaseActivity.this.a();
                o.d(ATBaseActivity.a, "Orientation Bottom");
            }
        }
    }

    private void d() {
        try {
            if (Build.VERSION.SDK_INT < 19) {
                getWindow().getDecorView().setSystemUiVisibility(2);
            } else {
                getWindow().addFlags(DownloadExpSwitchCode.BACK_BUGFIX_SIGBUS);
                getWindow().getDecorView().setSystemUiVisibility(4098);
            }
        } catch (Throwable th) {
            o.d(a, th.getMessage());
        }
    }

    public abstract void a(int i2, int i3, int i4, int i5, int i6);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            getWindow().addFlags(512);
            d();
            c();
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        } catch (Exception e2) {
            o.d(a, e2.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        OrientationEventListener orientationEventListener = this.b;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.b = null;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (b.f10401c) {
            return;
        }
        a();
        d();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        d();
    }

    private void b() {
        this.b = new AnonymousClass2(this);
        if (this.b.canDetectOrientation()) {
            this.b.enable();
        } else {
            this.b.disable();
            this.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c() {
        if (this.f8123c == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f8123c = getDisplay();
            } else {
                this.f8123c = ((WindowManager) getSystemService("window")).getDefaultDisplay();
            }
        }
        Display display = this.f8123c;
        if (display == null) {
            return -1;
        }
        try {
            return display.getRotation();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final void a() {
        getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.anythink.expressad.activity.ATBaseActivity.1
            @Override // java.lang.Runnable
            public final void run() {
                int safeInsetLeft;
                int safeInsetRight;
                int safeInsetTop;
                int i2;
                DisplayCutout displayCutout;
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        WindowInsets rootWindowInsets = ATBaseActivity.this.getWindow().getDecorView().getRootWindowInsets();
                        int i3 = 0;
                        if (rootWindowInsets == null || Build.VERSION.SDK_INT < 28 || (displayCutout = rootWindowInsets.getDisplayCutout()) == null) {
                            i3 = -1;
                            safeInsetLeft = 0;
                            safeInsetRight = 0;
                            safeInsetTop = 0;
                            i2 = 0;
                        } else {
                            safeInsetLeft = displayCutout.getSafeInsetLeft();
                            safeInsetRight = displayCutout.getSafeInsetRight();
                            safeInsetTop = displayCutout.getSafeInsetTop();
                            int safeInsetBottom = displayCutout.getSafeInsetBottom();
                            o.d(ATBaseActivity.a, "NOTCH Left:" + safeInsetLeft + " Right:" + safeInsetRight + " Top:" + safeInsetTop + " Bottom:" + safeInsetBottom);
                            int iC = ATBaseActivity.this.c();
                            if (ATBaseActivity.this.f8124d == -1) {
                                ATBaseActivity.this.f8124d = iC == 0 ? 3 : iC == 1 ? 1 : iC == 2 ? 4 : iC == 3 ? 2 : -1;
                                StringBuilder sb = new StringBuilder();
                                sb.append(ATBaseActivity.this.f8124d);
                                o.d(ATBaseActivity.a, sb.toString());
                            }
                            if (iC == 0) {
                                i2 = safeInsetBottom;
                            } else if (iC == 1) {
                                i2 = safeInsetBottom;
                                i3 = 90;
                            } else if (iC == 2) {
                                i2 = safeInsetBottom;
                                i3 = 180;
                            } else if (iC != 3) {
                                i2 = safeInsetBottom;
                                i3 = -1;
                            } else {
                                i2 = safeInsetBottom;
                                i3 = SubsamplingScaleImageView.ORIENTATION_270;
                            }
                        }
                        ATBaseActivity.this.a(i3, safeInsetLeft, safeInsetRight, safeInsetTop, i2);
                        if (ATBaseActivity.this.b == null) {
                            ATBaseActivity.d(ATBaseActivity.this);
                        }
                    }
                } catch (Throwable th) {
                    o.d(ATBaseActivity.a, th.getMessage());
                }
            }
        }, 500L);
    }

    static /* synthetic */ void d(ATBaseActivity aTBaseActivity) {
        aTBaseActivity.b = aTBaseActivity.new AnonymousClass2(aTBaseActivity);
        if (aTBaseActivity.b.canDetectOrientation()) {
            aTBaseActivity.b.enable();
        } else {
            aTBaseActivity.b.disable();
            aTBaseActivity.b = null;
        }
    }
}
