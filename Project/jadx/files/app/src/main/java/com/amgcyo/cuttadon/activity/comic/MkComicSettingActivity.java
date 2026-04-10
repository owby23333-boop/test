package com.amgcyo.cuttadon.activity.comic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.view.comic.CheckBoxPreference;
import com.amgcyo.cuttadon.view.comic.OptionFrameLayout;
import com.amgcyo.cuttadon.view.comic.SliderPreference;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkComicSettingActivity extends BaseTitleBarActivity implements com.amgcyo.cuttadon.view.comic.m.b {

    @BindView(R.id.settings_other_night_alpha)
    SliderPreference mOtherNightAlpha;

    @BindView(R.id.settings_reader_show_topbar)
    CheckBoxPreference mOtherShowTopbar;

    @BindView(R.id.settings_reader_ban_double_click)
    CheckBoxPreference mReaderBanDoubleClick;

    @BindView(R.id.settings_reader_show_bottomtips)
    CheckBoxPreference mReaderBottomTips;

    @BindView(R.id.settings_reader_interval)
    CheckBoxPreference mReaderInterval;

    @BindView(R.id.settings_reader_keep_bright)
    CheckBoxPreference mReaderKeepBright;

    @BindView(R.id.settings_reader_quick_turn)
    CheckBoxPreference mReaderQuickTurn;

    @BindView(R.id.settings_reader_scale_factor)
    SliderPreference mReaderScaleFactor;

    @BindView(R.id.settings_reader_volume_key)
    CheckBoxPreference mReaderVolumeKeyControls;

    @BindView(R.id.settings_reader_wifi)
    CheckBoxPreference mReaderWifi;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private boolean[] f2350n0 = new boolean[9];

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private Intent f2351o0 = new Intent();

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    boolean f2352p0 = false;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    protected com.amgcyo.cuttadon.utils.comic.a f2353q0;

    @BindView(R.id.settings_other_clear)
    OptionFrameLayout settings_other_clear;

    private void n() {
        com.amgcyo.cuttadon.utils.comic.a aVar = this.f2353q0;
        if (aVar != null) {
            this.f2350n0[0] = aVar.a("pref_reader_keep_on", false);
            this.f2350n0[1] = this.f2353q0.a("pref_other_show_topbar", true);
            this.f2350n0[2] = this.f2353q0.a("pref_reader_ban_double_click", false);
            this.f2350n0[3] = this.f2353q0.a("pref_reader_volume_key_controls_page_turning", false);
            this.f2350n0[4] = this.f2353q0.a("pref_reader_page_quick_turn", false);
            this.f2350n0[5] = this.f2353q0.a("pref_reader_stream_interval", false);
            boolean[] zArr = this.f2350n0;
            zArr[6] = this.f2352p0;
            zArr[7] = this.f2353q0.a("pref_reader_stream_wifi", false);
            this.f2350n0[8] = this.f2353q0.a("pref_reader_stream_bottom_tips", false);
            this.f2351o0.putExtra("cimoc.intent.extra.EXTRA_RESULT", this.f2350n0);
            this.f2351o0.putExtra("cimoc.intent.extra.extra_result_scalefactor", this.mReaderScaleFactor.getValue() * 0.01f);
            setResult(-1, this.f2351o0);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "漫画阅读设置";
    }

    public /* synthetic */ void e(View view) {
        this.f2352p0 = true;
        finish();
    }

    @Override // android.app.Activity
    public void finish() {
        n();
        super.finish();
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        this.f2353q0 = MkApplication.getAppContext().mPreferenceManager;
        this.mReaderKeepBright.a("pref_reader_keep_on", false);
        this.mOtherShowTopbar.a("pref_other_show_topbar", true);
        this.mReaderVolumeKeyControls.a("pref_reader_volume_key_controls_page_turning", false);
        this.mReaderBanDoubleClick.a("pref_reader_ban_double_click", false);
        this.mReaderQuickTurn.a("pref_reader_page_quick_turn", false);
        this.mReaderInterval.a("pref_reader_stream_interval", false);
        this.mReaderWifi.a("pref_reader_stream_wifi", false);
        this.mReaderBottomTips.a("pref_reader_stream_bottom_tips", false);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.mReaderScaleFactor.a(supportFragmentManager, "pref_reader_scale_factor", 200, R.string.settings_reader_scale_factor, 8);
        this.mOtherNightAlpha.a(supportFragmentManager, "pref_other_night_alpha", 176, R.string.settings_other_night_alpha, 7);
        this.settings_other_clear.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.comic.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2406s.e(view);
            }
        });
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.comic_setting_activity;
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

    @Override // com.amgcyo.cuttadon.view.comic.m.b
    public void onDialogResult(int i2, Bundle bundle) {
        if (i2 == 7) {
            this.mOtherNightAlpha.setValue(bundle.getInt("cimoc.intent.extra.EXTRA_DIALOG_RESULT_VALUE"));
        } else {
            if (i2 != 8) {
                return;
            }
            this.mReaderScaleFactor.setValue(bundle.getInt("cimoc.intent.extra.EXTRA_DIALOG_RESULT_VALUE"));
        }
    }
}
