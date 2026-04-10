package com.amgcyo.cuttadon.sdk.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.activity.main.MkMainActivity;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.config.MkAppConfig;
import com.amgcyo.cuttadon.api.presenter.ConfigPresenter;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.utils.otherutils.u0;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.List;
import me.jessyan.art.mvp.Message;
import me.jessyan.art.mvp.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class MyBaseAdActivity<P extends me.jessyan.art.mvp.c> extends BaseTitleBarActivity {

    @BindView(R.id.ll_root)
    protected LinearLayout ll_root;

    @BindView(R.id.splash_container)
    protected FrameLayout mSplashContainer;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    protected String f4255o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    protected String f4256p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    protected int f4257q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private int f4258r0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    protected int f4260t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    protected int f4261u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    protected int f4262v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    protected float f4263w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    protected float f4264x0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    protected boolean f4254n0 = true;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    protected List<BaseAd> f4259s0 = null;

    private void q() {
        if (this.f4254n0) {
            List<BaseAd> listB = com.amgcyo.cuttadon.sdk.utils.h.b("splash_screen_err");
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(listB)) {
                return;
            }
            String str = "闪屏启动广告位———错误后广告轮询列表大小：" + listB.size();
            this.f4259s0 = new ArrayList(listB);
            return;
        }
        List<BaseAd> listB2 = com.amgcyo.cuttadon.sdk.utils.h.b("awaken_err");
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(listB2)) {
            return;
        }
        String str2 = "闪屏唤醒广告位———错误后广告轮询列表大小：" + listB2.size();
        this.f4259s0 = new ArrayList(listB2);
    }

    private void r() {
        float fB = 95.0f;
        this.f4262v0 = u0.a(this, 95.0f);
        FrameLayout frameLayout = this.mSplashContainer;
        if (frameLayout != null) {
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                this.f4262v0 = ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                fB = u0.b(this, this.f4262v0);
                String str = fB + "  " + this.f4262v0;
            }
        }
        this.f4260t0 = u0.d(this);
        this.f4261u0 = u0.a(this);
        this.f4264x0 = u0.c(this);
        this.f4263w0 = u0.b(this, this.f4261u0) - fB;
        String str2 = this.f4260t0 + " " + this.f4261u0 + " " + this.f4264x0 + " " + this.f4263w0;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    @Override // android.app.Activity
    public void finish() {
        overridePendingTransition(0, 0);
        super.finish();
    }

    public void initData(@Nullable Bundle bundle) {
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        try {
            com.amgcyo.cuttadon.utils.otherutils.g.d((Activity) this);
            this.f4255o0 = intent.getStringExtra("pos_id");
            this.f4256p0 = intent.getStringExtra("platform");
            r();
            String str = "广告位id：" + this.f4255o0 + " 广告平台：" + this.f4256p0;
            this.f4257q0 = intent.getIntExtra("durationTime", 5);
            this.f4254n0 = intent.getBooleanExtra("needStartMainActivity", true);
            q();
            if (this.f4258r0 != 0) {
                this.ll_root.setBackgroundColor(this.f4258r0);
                showLoading();
                com.amgcyo.cuttadon.f.o.a(this.mSplashContainer, 0, 0, 0, 0);
            } else {
                com.amgcyo.cuttadon.f.o.a(this.mSplashContainer, 0, 0, 0, com.amgcyo.cuttadon.utils.otherutils.n.a(90.0f));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        MkAppConfig appConfig = MkApplication.getAppContext().getAppConfig();
        if (appConfig == null || !appConfig.isIs_cache()) {
            return;
        }
        new ConfigPresenter(me.jessyan.art.f.e.a(this)).a(Message.a(this, new Object[0]));
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_splash;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    protected void n() {
        com.amgcyo.cuttadon.h.a.e.a();
    }

    protected void o() {
        hideLoading();
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) throws Exception {
        overridePendingTransition(0, 0);
        this.f4258r0 = com.amgcyo.cuttadon.utils.otherutils.g.x();
        if (this.f4258r0 != 0) {
            setTheme(R.style.AppTheme);
        } else {
            setTheme(R.style.FullScreenStyle);
        }
        super.onCreate(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 || i2 == 3) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            com.amgcyo.cuttadon.app.o.b.a(this);
        }
    }

    protected void p() {
        if (this.f4258r0 != 0) {
            o();
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            bundle.putLong("common_result_data", 17256L);
            intent.putExtras(bundle);
            setResult(836, intent);
        } else if (this.f4254n0) {
            r0.a(this, (Class<?>) MkMainActivity.class);
        }
        this.f4254n0 = false;
        com.amgcyo.cuttadon.utils.otherutils.g.j(0);
        overridePendingTransition(0, 0);
        finish();
    }
}
