package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.AdSize;

/* JADX INFO: loaded from: classes2.dex */
public class dg {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f13098f = 5;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RelativeLayout f13099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f13100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CountDownTimer f13101e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private dj f13102g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Activity f13105j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Boolean f13106k;
    public final String a = "html5_intersitial";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f13103h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f13104i = false;
    protected final bq b = bq.a();

    public dg(Context context, RelativeLayout relativeLayout, Boolean bool, AdSize adSize, String str) {
    }

    private boolean e() {
        return b();
    }

    private View f() {
        this.f13101e = new di(this, 6000L, 1000L).start();
        return this.f13099c;
    }

    private void g() {
        RelativeLayout relativeLayout = this.f13099c;
        if (relativeLayout != null && relativeLayout.getParent() != null) {
            ((ViewGroup) this.f13099c.getParent()).removeView(this.f13099c);
        }
        if (this.f13101e != null) {
            this.b.a("cancel countDownTimer before it finished");
            try {
                this.f13101e.cancel();
            } catch (Exception e2) {
                this.b.a(e2);
            }
        }
    }

    private RelativeLayout.LayoutParams h() {
        return null;
    }

    public void a() {
    }

    public void a(int i2, int i3) {
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        return true;
    }

    protected boolean b() {
        return AdSize.InterstitialForVideoBeforePlay.getValue() == 0;
    }

    protected void c() {
        Activity activity = this.f13105j;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new dh(this));
    }

    public boolean d() {
        return this.f13103h;
    }

    public void a(Activity activity, RelativeLayout relativeLayout) {
        try {
            this.b.a("showInterstitialAdInit");
            if (this.f13103h && !this.f13104i) {
                this.f13104i = true;
                this.f13103h = false;
                this.f13105j = activity;
                a();
                c();
                return;
            }
            if (this.f13104i) {
                this.b.b("interstitial ad is showing now");
            } else {
                if (this.f13103h) {
                    return;
                }
                this.b.b("interstitial ad is not ready");
            }
        } catch (Exception e2) {
            this.b.a(e2);
        }
    }
}
