package com.amgcyo.cuttadon.activity.main;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.other.DnsResult;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.presenter.ConfigPresenter;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.utils.otherutils.x0;
import com.amgcyo.cuttadon.view.dialog.j1;
import com.amgcyo.cuttadon.view.popupview.PrivacyPopup;
import com.fatcatfat.io.R;
import com.lxj.xpopup.a;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupAnimation;
import com.umeng.message.PushAgent;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkSplashActivity extends BaseTitleBarActivity<ConfigPresenter> implements com.amgcyo.cuttadon.d.a {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private boolean f2612n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private int f2613o0 = 20220428;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private boolean f2614p0;

    @BindView(R.id.rl_root)
    RelativeLayout rl_root;

    @BindView(R.id.tv_msg)
    TextView tv_msg;

    class a implements com.amgcyo.cuttadon.g.e {
        final /* synthetic */ com.amgcyo.cuttadon.utils.otherutils.g0 a;

        a(com.amgcyo.cuttadon.utils.otherutils.g0 g0Var) {
            this.a = g0Var;
        }

        @Override // com.amgcyo.cuttadon.g.e
        public void a() {
            this.a.b("user_agree_pri", false);
            MkSplashActivity.this.finish();
        }

        @Override // com.amgcyo.cuttadon.g.e
        public void b() {
            new com.amgcyo.cuttadon.d.b(MkSplashActivity.this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "ns0.nmgrygc.com");
            MkApplication.getAppContext().initDeviceIdentifier();
            this.a.b("user_agree_pri", true);
            PushAgent.getInstance(MkSplashActivity.this).onAppStart();
            com.amgcyo.cuttadon.i.m.a(MkSplashActivity.this);
            MkSplashActivity.this.p();
        }
    }

    class b implements com.amgcyo.cuttadon.g.e {
        final /* synthetic */ com.amgcyo.cuttadon.utils.otherutils.g0 a;

        b(com.amgcyo.cuttadon.utils.otherutils.g0 g0Var) {
            this.a = g0Var;
        }

        @Override // com.amgcyo.cuttadon.g.e
        public void a() {
            this.a.b("user_agree_pri", false);
            MkSplashActivity.this.finish();
        }

        @Override // com.amgcyo.cuttadon.g.e
        public void b() {
            new com.amgcyo.cuttadon.d.b(MkSplashActivity.this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "ns0.nmgrygc.com");
            MkApplication.getAppContext().initDeviceIdentifier();
            this.a.b("user_agree_pri", true);
            PushAgent.getInstance(MkSplashActivity.this).onAppStart();
            com.amgcyo.cuttadon.i.m.a(MkSplashActivity.this);
            MkSplashActivity.this.p();
        }
    }

    private void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            for (int i2 = 0; i2 < com.amgcyo.cuttadon.a.f2255f.length; i2++) {
                sb.append(",");
                sb.append(com.amgcyo.cuttadon.a.f2255f[i2]);
            }
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b("Z8716HRlaBgT", sb.toString());
            sb.toString();
        }
        if (!this.f2614p0) {
            ((ConfigPresenter) this.f2276v).d(Message.a(this, new Object[]{Integer.valueOf(this.f2613o0)}));
        } else {
            PushAgent.getInstance(this).onAppStart();
            p();
        }
    }

    private void o() {
        com.amgcyo.cuttadon.utils.otherutils.g0 g0VarA = com.amgcyo.cuttadon.utils.otherutils.g0.a();
        if (g0VarA.a("user_agree_pri", false)) {
            new com.amgcyo.cuttadon.d.b(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "ns0.nmgrygc.com");
        } else {
            if (com.amgcyo.cuttadon.a.f2254e.intValue() != 0) {
                a(g0VarA);
                return;
            }
            j1 j1Var = new j1(this);
            j1Var.show();
            j1Var.a(new a(g0VarA));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        startActivity(new Intent(this, (Class<?>) MkLauncherActivity.class));
        finish();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        o();
        com.amgcyo.cuttadon.utils.otherutils.g.y("11000001");
        com.amgcyo.cuttadon.app.o.c.b(com.amgcyo.cuttadon.app.o.c.g() + 1);
        try {
            MkUser mkUserA = AppDatabase.i().d().a();
            if (mkUserA != null) {
                com.amgcyo.cuttadon.utils.otherutils.g.a(String.valueOf(mkUserA.getUser_id()), mkUserA.getToken());
                x0.c().a(com.amgcyo.cuttadon.utils.otherutils.g.r(mkUserA.getUser_id()), "[SPLASH]注册用户启动app");
            } else {
                x0.c().a("", "[SPLASH]匿名用户启动app");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f2614p0 = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("user_agree_pri", false);
        if (!this.f2614p0 && !isFinishing()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.activity.main.k0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2651s.n();
                }
            }, com.anythink.expressad.video.module.a.a.m.ag);
        }
        if (com.amgcyo.cuttadon.utils.otherutils.g.e()) {
            com.amgcyo.cuttadon.utils.otherutils.h.i("");
        }
        com.amgcyo.cuttadon.utils.otherutils.g.a(false);
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_launcher;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    public /* synthetic */ void n() {
        TextView textView;
        if (this.f2612n0 || (textView = this.tv_msg) == null) {
            return;
        }
        textView.setText("应用正在初始化...");
        this.rl_root.setVisibility(0);
    }

    @Override // com.amgcyo.cuttadon.d.a
    public void processFinish(@NonNull DnsResult dnsResult) {
        try {
            dnsResult.toString();
            String msg = dnsResult.getMsg();
            if (TextUtils.isEmpty(msg)) {
                throw new Exception("dnsresult txtRecord is null ");
            }
            int code = dnsResult.getCode();
            if (100 == code) {
                if (msg.split(",").length <= 0) {
                    throw new Exception("domain list is empty;");
                }
                e(msg);
            } else {
                throw new Exception("dnsresult error code:" + code + " msg: " + msg);
            }
        } catch (Exception unused) {
            e("");
        }
    }

    private void a(com.amgcyo.cuttadon.utils.otherutils.g0 g0Var) {
        PrivacyPopup privacyPopup = new PrivacyPopup(this);
        privacyPopup.setListener(new b(g0Var));
        a.b bVar = new a.b(this);
        bVar.c(true);
        bVar.b(true);
        bVar.d(false);
        bVar.c((Boolean) false);
        bVar.a(PopupAnimation.ScaleAlphaFromCenter);
        bVar.a((BasePopupView) privacyPopup);
        privacyPopup.u();
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public ConfigPresenter obtainPresenter() {
        if (this.f2276v == 0) {
            this.f2276v = new ConfigPresenter(me.jessyan.art.f.e.a(this));
        }
        return (ConfigPresenter) this.f2276v;
    }
}
