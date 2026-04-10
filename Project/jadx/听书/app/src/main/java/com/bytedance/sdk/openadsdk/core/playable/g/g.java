package com.bytedance.sdk.openadsdk.core.playable.g;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.oq;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1296a;
    private boolean z;
    private long g = 0;
    private long dl = 0;

    public g(String str) {
        this.f1296a = "rewarded_video".equalsIgnoreCase(str) || "fullscreen_interstitial_ad".equalsIgnoreCase(str);
    }

    public void z(final Activity activity, na naVar) {
        if (activity == null || naVar == null || !naVar.fo()) {
            return;
        }
        oq.dl(activity);
        try {
            final View decorView = activity.getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.g.g.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i == 0) {
                        g.this.z();
                        try {
                            if (activity.isFinishing()) {
                                return;
                            }
                            decorView.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.g.g.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    oq.dl(activity);
                                }
                            }, 5000L);
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void z(int i) {
        boolean z = i == 4;
        this.z = z;
        if (z) {
            this.g = System.currentTimeMillis();
        }
    }

    public boolean g(Activity activity, na naVar) {
        boolean z = false;
        if (activity != null && naVar != null) {
            boolean z2 = this.z;
            this.z = false;
            if (!naVar.fo() || !z2) {
                return false;
            }
            if (z.z(activity) || g()) {
                return true;
            }
            try {
                if (!this.f1296a || !z.z()) {
                    z = z(activity);
                }
            } catch (Throwable unused) {
            }
        }
        return z;
    }

    public void z() {
        this.dl = System.currentTimeMillis();
    }

    private boolean z(Activity activity) {
        return (activity.getWindow().getDecorView().getSystemUiVisibility() & 2) == 2;
    }

    private boolean g() {
        long j = this.g;
        long jAbs = j > 0 ? Math.abs(j - this.dl) : -1L;
        return jAbs >= 0 && jAbs < 300;
    }
}
