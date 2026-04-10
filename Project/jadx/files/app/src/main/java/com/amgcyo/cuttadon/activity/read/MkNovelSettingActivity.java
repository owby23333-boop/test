package com.amgcyo.cuttadon.activity.read;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.reader.TtsEngineBean;
import com.amgcyo.cuttadon.view.dialog.g1;
import com.amgcyo.cuttadon.view.dialog.s1;
import com.amgcyo.cuttadon.view.dialog.u1;
import com.fatcatfat.io.R;
import com.lxj.xpopup.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MkNovelSettingActivity extends BaseTitleBarActivity {

    @BindView(R.id.ll_tts_engine)
    LinearLayout ll_tts_engine;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private com.amgcyo.cuttadon.utils.otherutils.d0 f2702n0;

    @BindView(R.id.switch_all_click_next)
    Switch switchAllClickNext;

    @BindView(R.id.switch_volume_key)
    Switch switchVolumeKey;

    @BindView(R.id.switch_keep_on)
    Switch switch_keep_on;

    @BindView(R.id.tv_tts_engine)
    TextView tvTtsEngine;

    @BindView(R.id.tv_lock_time)
    TextView tv_lock_time;

    @BindView(R.id.tv_tts_model)
    TextView tv_tts_model;

    class a implements com.hjq.permissions.a {
        a() {
        }

        @Override // com.hjq.permissions.a
        public void a(List<String> list, boolean z2) {
            MkNovelSettingActivity.this.showMessage("获取系统设置权限失败，请手动授予权限");
        }

        @Override // com.hjq.permissions.a
        public void b(List<String> list, boolean z2) {
            MkNovelSettingActivity.this.showMessage("获取系统设置权限成功");
            MkNovelSettingActivity.this.s();
        }
    }

    private void n() {
        if (com.hjq.permissions.f.a(a(), "android.permission.WRITE_SETTINGS")) {
            s();
            return;
        }
        com.lxj.xpopup.a.a(com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary));
        String str = "“" + com.amgcyo.cuttadon.f.o.d(R.string.app_name) + "”" + com.amgcyo.cuttadon.f.o.d(R.string.write_tip);
        a.b bVar = new a.b(a());
        bVar.d(false);
        bVar.a((CharSequence) "温馨提示", (CharSequence) str, (CharSequence) "取消", (CharSequence) "去设置", new com.lxj.xpopup.c.c() { // from class: com.amgcyo.cuttadon.activity.read.w
            @Override // com.lxj.xpopup.c.c
            public final void onConfirm() {
                this.a.p();
            }
        }, (com.lxj.xpopup.c.a) null, false).u();
    }

    private void o() {
        this.switchAllClickNext.setChecked(com.amgcyo.cuttadon.utils.otherutils.g0.a().a("is_allclicknext", false));
        this.switchAllClickNext.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.amgcyo.cuttadon.activity.read.v
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.a.a(compoundButton, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        com.hjq.permissions.f fVarA = com.hjq.permissions.f.a((FragmentActivity) this);
        fVarA.a("android.permission.WRITE_SETTINGS");
        fVarA.a(new a());
    }

    private void q() {
        if (!r() && com.amgcyo.cuttadon.utils.otherutils.g0.a().a("tts_engine_key", 0) == 0) {
            this.tvTtsEngine.setText(getResources().getString(R.string.baidu_tts));
        } else {
            this.tvTtsEngine.setText(getResources().getString(R.string.native_tts));
        }
        if (com.amgcyo.cuttadon.utils.otherutils.g0.a().a("tts_model_key", 0) != 0) {
            this.tv_tts_model.setText(getResources().getString(R.string.model_lrc));
        } else {
            this.tv_tts_model.setText(getResources().getString(R.string.model_ydq));
        }
        int iA = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("read_lock_screen_time_index", 3);
        if (iA == 0) {
            this.tv_lock_time.setText(getResources().getString(R.string.reader_lock_time_5));
            return;
        }
        if (iA == 1) {
            this.tv_lock_time.setText(getResources().getString(R.string.reader_lock_time_15));
            return;
        }
        if (iA == 2) {
            this.tv_lock_time.setText(getResources().getString(R.string.reader_lock_time_30));
        } else if (iA != 4) {
            this.tv_lock_time.setText(getResources().getString(R.string.reader_lock_time_xt));
        } else {
            this.tv_lock_time.setText(getResources().getString(R.string.reader_lock_time_cl));
        }
    }

    private boolean r() {
        return TextUtils.isEmpty(com.amgcyo.cuttadon.utils.otherutils.h.m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        g1 g1Var = new g1(a());
        g1Var.show();
        g1Var.a(new g1.a() { // from class: com.amgcyo.cuttadon.activity.read.x
            @Override // com.amgcyo.cuttadon.view.dialog.g1.a
            public final void a(TtsEngineBean ttsEngineBean) {
                this.a.a(ttsEngineBean);
            }
        });
    }

    private void t() {
        this.switch_keep_on.setChecked(com.amgcyo.cuttadon.utils.otherutils.g0.a().a("is_screen_keep_on", false));
        this.switch_keep_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.amgcyo.cuttadon.activity.read.z
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.a.b(compoundButton, z2);
            }
        });
    }

    private void u() {
        u1 u1Var = new u1(a());
        u1Var.show();
        u1Var.a(new u1.b() { // from class: com.amgcyo.cuttadon.activity.read.y
            @Override // com.amgcyo.cuttadon.view.dialog.u1.b
            public final void a(TtsEngineBean ttsEngineBean) {
                this.a.b(ttsEngineBean);
            }
        });
    }

    private void w() {
        s1 s1Var = new s1(a());
        s1Var.show();
        s1Var.a(new s1.b() { // from class: com.amgcyo.cuttadon.activity.read.a0
            @Override // com.amgcyo.cuttadon.view.dialog.s1.b
            public final void a(TtsEngineBean ttsEngineBean) {
                this.a.c(ttsEngineBean);
            }
        });
    }

    private void x() {
        if (this.f2702n0 == null) {
            this.f2702n0 = new com.amgcyo.cuttadon.utils.otherutils.d0((Activity) a());
        }
        this.f2702n0.a(50L);
    }

    private void y() {
        this.switchVolumeKey.setChecked(com.amgcyo.cuttadon.utils.otherutils.g0.a().a("is_open_volume", false));
        this.switchVolumeKey.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.amgcyo.cuttadon.activity.read.u
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.a.c(compoundButton, z2);
            }
        });
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    public /* synthetic */ void b(CompoundButton compoundButton, boolean z2) {
        if (z2) {
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b("is_screen_keep_on", true);
        } else {
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b("is_screen_keep_on", false);
        }
        x();
    }

    public /* synthetic */ void c(CompoundButton compoundButton, boolean z2) {
        if (z2) {
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b("is_open_volume", true);
        } else {
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b("is_open_volume", false);
        }
        x();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "小说阅读设置";
    }

    @Override // android.app.Activity
    public void finish() {
        setResult(-1);
        super.finish();
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        q();
        y();
        t();
        o();
        this.ll_tts_engine.setVisibility(8);
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_novel_setting;
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

    @OnClick({R.id.tv_tts_model, R.id.tv_tts_engine, R.id.ll_keep_alive, R.id.ll_tts_model, R.id.ll_tts_engine, R.id.tv_lock_time, R.id.ll_lock_time})
    public void onClick(View view) {
        if (BaseTitleBarActivity.v()) {
            com.amgcyo.cuttadon.f.o.d(R.string.operating_busy);
        }
        switch (view.getId()) {
            case R.id.ll_keep_alive /* 2131297942 */:
                com.amgcyo.cuttadon.utils.otherutils.r0.a(this.f2277w);
                break;
            case R.id.ll_lock_time /* 2131297947 */:
            case R.id.tv_lock_time /* 2131298737 */:
                n();
                break;
            case R.id.ll_tts_engine /* 2131297983 */:
            case R.id.tv_tts_engine /* 2131298859 */:
                if (!r()) {
                    w();
                } else {
                    showMessage("目前仅支持" + com.amgcyo.cuttadon.f.o.d(R.string.native_tts));
                }
                break;
            case R.id.ll_tts_model /* 2131297985 */:
            case R.id.tv_tts_model /* 2131298861 */:
                u();
                break;
        }
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z2) {
        if (z2) {
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b("is_allclicknext", true);
        } else {
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b("is_allclicknext", false);
        }
        x();
    }

    public /* synthetic */ void b(TtsEngineBean ttsEngineBean) {
        this.tv_tts_model.setText(ttsEngineBean.getTitle());
    }

    public /* synthetic */ void c(TtsEngineBean ttsEngineBean) {
        this.tvTtsEngine.setText(ttsEngineBean.getTitle());
    }

    public /* synthetic */ void a(TtsEngineBean ttsEngineBean) {
        this.tv_lock_time.setText(ttsEngineBean.getTitle());
    }
}
