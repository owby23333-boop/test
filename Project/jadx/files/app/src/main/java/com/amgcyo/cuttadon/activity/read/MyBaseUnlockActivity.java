package com.amgcyo.cuttadon.activity.read;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.f.s.a;
import com.amgcyo.cuttadon.sdk.ui.SdkFullVideoActivity;
import com.amgcyo.cuttadon.sdk.ui.SdkSplashActivity;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class MyBaseUnlockActivity extends BaseTitleBarActivity implements com.amgcyo.cuttadon.h.f.c {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    protected boolean f2726n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    protected MkBook f2727o0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private List<BaseAd> f2729q0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f2728p0 = 1;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private boolean f2730r0 = false;

    private void a(String str, String str2, int i2) {
        Intent intent;
        if (TextUtils.isEmpty(str2)) {
            n();
            return;
        }
        if (this.f2728p0 == i2) {
            me.jessyan.art.d.d.e().a(SdkSplashActivity.class);
            intent = new Intent(this.f2277w, (Class<?>) SdkSplashActivity.class);
        } else {
            me.jessyan.art.d.d.e().a(SdkFullVideoActivity.class);
            intent = new Intent(this.f2277w, (Class<?>) SdkFullVideoActivity.class);
        }
        Bundle bundle = new Bundle();
        boolean zEquals = "gm".equals(str);
        String str3 = "needStartToMain:" + zEquals;
        bundle.putBoolean("needStartMainActivity", zEquals);
        com.amgcyo.cuttadon.utils.otherutils.g.j(com.amgcyo.cuttadon.f.o.b(R.color.color_80000));
        bundle.putString("pos_id", str2);
        bundle.putString("platform", str);
        intent.putExtras(bundle);
        overridePendingTransition(0, 0);
        com.amgcyo.cuttadon.f.s.a.c((FragmentActivity) this).startActivityForResult(intent, new a.InterfaceC0088a() { // from class: com.amgcyo.cuttadon.activity.read.e1
            @Override // com.amgcyo.cuttadon.f.s.a.InterfaceC0088a
            public final void a(int i3, Intent intent2) {
                this.a.b(i3, intent2);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(java.lang.String r17, int r18) {
        /*
            Method dump skipped, instruction units count: 593
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.activity.read.MyBaseUnlockActivity.c(java.lang.String, int):void");
    }

    private void o() {
        if (1 == this.f2727o0.getForm()) {
            com.amgcyo.cuttadon.utils.otherutils.r0.d(a(), this.f2727o0);
        } else {
            com.amgcyo.cuttadon.utils.otherutils.r0.a(a(), this.f2727o0);
        }
    }

    private void p() {
        String str = "mRewardVerify:" + this.f2726n0;
        if (this.f2726n0) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            bundle.putBoolean("RewardVerify", this.f2726n0);
            intent.putExtras(bundle);
            setResult(859, intent);
        }
        finish();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    protected void b(String str, int i2) {
        List<BaseAd> listJ = com.amgcyo.cuttadon.utils.otherutils.h.J();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(listJ)) {
            this.f2729q0 = new ArrayList();
            String str2 = "章节解锁广告位———错误后广告轮询列表大小：" + listJ.size();
            this.f2729q0.addAll(listJ);
        }
        c(str, i2);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    public /* synthetic */ void e(View view) {
        p();
    }

    public abstract void getData(@NonNull Bundle bundle);

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            n();
            return;
        }
        this.f2727o0 = (MkBook) extras.getSerializable("book");
        if (this.f2727o0 == null) {
            n();
        } else {
            getData(extras);
        }
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
        return true;
    }

    protected void n() {
        showMessage(com.amgcyo.cuttadon.f.o.d(R.string.error_params));
        finish();
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }

    @Override // com.amgcyo.cuttadon.h.f.c
    public void onRewardAdClose(String str) {
        this.f2730r0 = false;
        showMessage(this.f2726n0 ? "解锁成功!" : "解锁失败，请重试");
        if (this.f2727o0 != null) {
            o();
        }
        finish();
    }

    @Override // com.amgcyo.cuttadon.h.f.c
    public void onRewardAdFail(int i2, String str, String str2, String str3) {
        String str4 = "onError: " + i2 + " 错误信息：" + str;
        this.f2730r0 = false;
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2729q0)) {
            this.f2726n0 = false;
            if (this.f2727o0 != null) {
                o();
            }
            showMessage("解锁失败，请重试！错误码为：" + i2);
            finish();
            return;
        }
        BaseAd baseAd = this.f2729q0.get(0);
        String platform = baseAd.getPlatform();
        int style = baseAd.getStyle();
        Iterator<BaseAd> it = this.f2729q0.iterator();
        if (it.hasNext()) {
            try {
                it.next();
                it.remove();
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f2729q0.clear();
            }
        }
        if (!"csj_new".equals(platform)) {
            c(platform, style);
            return;
        }
        if (6 == style) {
            c(platform, style);
            return;
        }
        if (8 == style) {
            String strA = com.amgcyo.cuttadon.utils.otherutils.h.a("csj_new", "v");
            String str5 = "新插屏id：" + strA;
            com.amgcyo.cuttadon.h.b.c.d().a(this.f2277w, strA, str3, this);
        }
    }

    @Override // com.amgcyo.cuttadon.h.f.c
    public void onRewardAdSuccess(com.amgcyo.cuttadon.h.g.h hVar) {
        this.f2726n0 = true;
        String str = " rewardAmount: " + hVar.f3979c + " rewardName:" + hVar.a;
        saveData();
        if (!this.f2730r0) {
            d("恭喜您解锁成功，请返回继续阅读！");
        }
        this.f2730r0 = true;
    }

    @Override // com.amgcyo.cuttadon.h.f.c
    public void onRewardAdVideoCached(Object obj) {
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        RelativeLayout relativeLayout = this.A;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.f1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2742s.e(view);
                }
            });
        }
    }

    public abstract void saveData();

    public /* synthetic */ void b(int i2, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("data ");
        sb.append(intent != null);
        sb.toString();
        if (intent != null) {
            long longExtra = intent.getLongExtra("common_result_data", 0L);
            String str = "min:" + longExtra;
            if (17256 == longExtra) {
                saveData();
                d("解锁成功!");
                if (this.f2727o0 != null) {
                    o();
                } else {
                    c("参数异常，解锁失败，请重试！");
                }
            }
            finish();
        }
    }

    private void c(int i2) {
        showMessage("解锁失败，错误码：" + i2 + "请重试！");
        finish();
    }
}
