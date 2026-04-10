package com.amgcyo.cuttadon.activity.setting;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.fatcatfat.io.R;
import com.umeng.message.PushAgent;

/* JADX INFO: loaded from: classes.dex */
public class MkSettingActivity extends BaseTitleBarActivity {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    com.amgcyo.cuttadon.utils.otherutils.d0 f2852n0;

    @BindView(R.id.switch_jpush)
    Switch switchJpush;

    @BindView(R.id.switch_csj)
    Switch switch_csj;

    private void c(int i2) {
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b("swtich_csj_ad_push", i2);
        showMessage("您已操作成功，下次启动时生效");
    }

    private void n() {
        this.switch_csj.setChecked(com.amgcyo.cuttadon.utils.otherutils.g0.a().a("swtich_csj_ad_push", 0) == 0);
        this.switch_csj.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.amgcyo.cuttadon.activity.setting.z
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.a.a(compoundButton, z2);
            }
        });
    }

    private void o() {
        this.switchJpush.setChecked(com.amgcyo.cuttadon.utils.otherutils.g0.a().a("swtich_jpush", true));
        this.switchJpush.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.amgcyo.cuttadon.activity.setting.a0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.a.b(compoundButton, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        showMessage("您已操作成功！");
    }

    private void q() {
        if (this.f2852n0 == null) {
            this.f2852n0 = new com.amgcyo.cuttadon.utils.otherutils.d0((Activity) this);
        }
        this.f2852n0.a(50L);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    public /* synthetic */ void b(CompoundButton compoundButton, boolean z2) {
        if (z2) {
            PushAgent.getInstance(getApplicationContext()).enable(new g0(this));
        } else {
            PushAgent.getInstance(getApplicationContext()).enable(new h0(this));
        }
        zhugeIodEvent("[MY]书籍更新提醒");
        q();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return com.amgcyo.cuttadon.f.o.d(R.string.sys_setting);
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        o();
        n();
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_setting;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }

    @OnClick({R.id.ll_about, R.id.ll_clear_cache})
    public void onClick(View view) {
        if (BaseTitleBarActivity.v()) {
            com.amgcyo.cuttadon.f.o.d(R.string.operating_busy);
            return;
        }
        int id = view.getId();
        if (id == R.id.ll_about) {
            r0.startActivity(this.f2277w, MkAboutActivity.class);
            zhugeIodEvent("[MY]关于我们");
        } else {
            if (id != R.id.ll_clear_cache) {
                return;
            }
            r0.startActivity(this.f2277w, MkClearCacheActivity.class);
            zhugeIodEvent("[MY]清除缓存");
        }
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z2) {
        if (z2) {
            c(0);
        } else {
            c(1);
        }
        q();
    }
}
