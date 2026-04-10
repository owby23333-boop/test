package com.amgcyo.cuttadon.activity.setting;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.fatcatfat.io.R;
import com.kwad.sdk.api.KsAdSDK;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class MkAboutActivity extends BaseTitleBarActivity {

    @BindView(R.id.iv_logo)
    ImageView iv_logo;

    @BindView(R.id.ll_website)
    LinearLayout ll_website;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    long[] f2808n0 = new long[5];

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private MkUser f2809o0;

    @BindView(R.id.tv_version)
    TextView tvVersion;

    @BindView(R.id.tv_kefu)
    TextView tv_kefu;

    @BindView(R.id.tv_sebsite)
    TextView tv_sebsite;

    @BindView(R.id.view_line)
    View view_line;

    static /* synthetic */ boolean f(View view) {
        String strM = com.amgcyo.cuttadon.utils.otherutils.g.m();
        String strS = com.amgcyo.cuttadon.utils.otherutils.h.s();
        int iC0 = com.amgcyo.cuttadon.utils.otherutils.h.c0();
        int iA0 = com.amgcyo.cuttadon.utils.otherutils.h.a0();
        int iB0 = com.amgcyo.cuttadon.utils.otherutils.h.b0();
        int iG = com.amgcyo.cuttadon.app.o.c.g();
        long jA = com.amgcyo.cuttadon.utils.otherutils.g.A();
        boolean zM0 = com.amgcyo.cuttadon.utils.otherutils.h.M0();
        int iO = com.amgcyo.cuttadon.utils.otherutils.h.O();
        String strD = com.amgcyo.cuttadon.utils.otherutils.g0.a().d("Z8716HRlaBgT");
        System.out.println(strM + " || " + strS + " || " + iC0 + " || " + iA0 + " || " + iB0 + " || " + iG + " || " + jA + " || " + zM0 + " || " + iO + " || " + strD + " || " + Arrays.toString(com.amgcyo.cuttadon.a.f2255f));
        return true;
    }

    private void o() {
        long[] jArr = this.f2808n0;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.f2808n0;
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        if (this.f2808n0[0] >= SystemClock.uptimeMillis() - com.anythink.expressad.video.module.a.a.m.ag) {
            p();
            this.f2808n0 = new long[5];
        }
    }

    private void p() {
        MkUser mkUser = this.f2809o0;
        if (mkUser == null) {
            e("NOT LOGIN");
            return;
        }
        int user_id = mkUser.getUser_id();
        String token = this.f2809o0.getToken();
        if (TextUtils.isEmpty(token) || user_id <= 0) {
            e("NOT LOGIN");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("RomId：\n%s", Integer.valueOf(user_id)) + "\n" + String.format("UUID：\n%s", token));
        sb.append("\n");
        sb.append(com.amgcyo.cuttadon.utils.otherutils.g.F());
        sb.append("\n");
        sb.append("VERSION_CODE：");
        sb.append(502);
        sb.append("\n");
        sb.append("VERSION_NAME：");
        sb.append("5.0.2");
        sb.append("\n");
        sb.append("FLAVOR：");
        sb.append("fmyd");
        sb.append("\n");
        sb.append("UMChannel：");
        sb.append(com.amgcyo.cuttadon.utils.otherutils.g.T());
        sb.append("\n");
        sb.append("SDK_INT：");
        sb.append(Build.VERSION.SDK_INT);
        sb.append("\n");
        String str = "\n信息：\n" + sb.toString();
        e(sb.toString());
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "关于我们";
    }

    public /* synthetic */ boolean e(View view) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.activity.setting.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f2864s.n();
            }
        }, com.anythink.expressad.exoplayer.i.a.f9492f);
        return true;
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        this.tvVersion.setText(String.format("版本：%s", "5.0.2"));
        String strD0 = com.amgcyo.cuttadon.utils.otherutils.h.D0();
        if (!TextUtils.isEmpty(strD0)) {
            this.tv_kefu.setText(strD0);
        }
        String strC0 = com.amgcyo.cuttadon.utils.otherutils.h.C0();
        if (!TextUtils.isEmpty(strC0)) {
            this.tv_sebsite.setText(strC0);
        }
        this.ll_website.setVisibility(0);
        this.f2809o0 = com.amgcyo.cuttadon.utils.otherutils.g.j();
        this.iv_logo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.amgcyo.cuttadon.activity.setting.d
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f2862s.e(view);
            }
        });
        this.view_line.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.amgcyo.cuttadon.activity.setting.f
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return MkAboutActivity.f(view);
            }
        });
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_about_us;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    public /* synthetic */ void n() {
        r0.startActivity(a(), DebugInfoActivity.class);
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }

    @OnClick({R.id.iv_logo, R.id.ll_update, R.id.ll_website, R.id.ll_service, R.id.ll_haoping, R.id.tv_useragree, R.id.tv_privacy})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_logo /* 2131297195 */:
                o();
                break;
            case R.id.ll_haoping /* 2131297935 */:
                com.amgcyo.cuttadon.utils.otherutils.g.i(a());
                break;
            case R.id.ll_service /* 2131297967 */:
                r0.a(this.f2277w, com.amgcyo.cuttadon.utils.otherutils.h.C0() + "xsds/legel_mzsm.html?appName=");
                zhugeIodEvent("[MY]免责声明");
                break;
            case R.id.ll_update /* 2131297993 */:
                r0.a(this.f2277w, "file:////android_asset/update_log.html");
                zhugeIodEvent("[MY]更新日志");
                break;
            case R.id.ll_website /* 2131297997 */:
                String string = this.tv_sebsite.getText().toString();
                if (!TextUtils.isEmpty(string)) {
                    com.amgcyo.cuttadon.view.webview.b.startActivity(this.f2277w, string);
                }
                zhugeIodEvent("[MY]官方网站");
                break;
            case R.id.tv_privacy /* 2131298778 */:
                r0.a(this.f2277w, com.amgcyo.cuttadon.utils.otherutils.g.C());
                zhugeIodEvent("[MY]隐私政策");
                break;
            case R.id.tv_useragree /* 2131298875 */:
                r0.a(this.f2277w, com.amgcyo.cuttadon.utils.otherutils.g.b0());
                zhugeIodEvent("[MY]用户协议");
                break;
        }
    }

    private void e(String str) {
        String strT = com.amgcyo.cuttadon.utils.otherutils.g.T();
        String strF = com.amgcyo.cuttadon.utils.otherutils.g.F();
        String sDKVersion = TTAdSdk.getAdManager().getSDKVersion();
        String sDKVersion2 = KsAdSDK.getSDKVersion();
        String strN = com.amgcyo.cuttadon.utils.otherutils.g.n();
        boolean zA = com.amgcyo.cuttadon.utils.otherutils.g.a();
        String str2 = Build.MODEL;
        System.out.println("model：" + str2);
        System.out.println("channel：" + strT);
        System.out.println("csj_sdk code：" + sDKVersion);
        System.out.println("ks_sdk code：" + sDKVersion2);
        System.out.println("url：" + strF);
        System.out.println("c_chapter：" + strN);
        System.out.println("bd status：" + zA);
        com.amgcyo.cuttadon.f.o.a(a(), "channel：" + strT + "\nurl：" + strF + "\nstatus:" + zA + "\nmodel：" + str2 + "\nsdk:" + sDKVersion + "\ninfo:" + str, "复制成功！" + strT);
    }
}
