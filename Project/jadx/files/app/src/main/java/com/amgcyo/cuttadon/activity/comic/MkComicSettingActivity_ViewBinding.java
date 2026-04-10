package com.amgcyo.cuttadon.activity.comic;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.view.comic.CheckBoxPreference;
import com.amgcyo.cuttadon.view.comic.OptionFrameLayout;
import com.amgcyo.cuttadon.view.comic.SliderPreference;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkComicSettingActivity_ViewBinding implements Unbinder {
    private MkComicSettingActivity a;

    @UiThread
    public MkComicSettingActivity_ViewBinding(MkComicSettingActivity mkComicSettingActivity, View view) {
        this.a = mkComicSettingActivity;
        mkComicSettingActivity.mReaderScaleFactor = (SliderPreference) Utils.findRequiredViewAsType(view, R.id.settings_reader_scale_factor, "field 'mReaderScaleFactor'", SliderPreference.class);
        mkComicSettingActivity.mReaderKeepBright = (CheckBoxPreference) Utils.findRequiredViewAsType(view, R.id.settings_reader_keep_bright, "field 'mReaderKeepBright'", CheckBoxPreference.class);
        mkComicSettingActivity.mOtherNightAlpha = (SliderPreference) Utils.findRequiredViewAsType(view, R.id.settings_other_night_alpha, "field 'mOtherNightAlpha'", SliderPreference.class);
        mkComicSettingActivity.mOtherShowTopbar = (CheckBoxPreference) Utils.findRequiredViewAsType(view, R.id.settings_reader_show_topbar, "field 'mOtherShowTopbar'", CheckBoxPreference.class);
        mkComicSettingActivity.mReaderVolumeKeyControls = (CheckBoxPreference) Utils.findRequiredViewAsType(view, R.id.settings_reader_volume_key, "field 'mReaderVolumeKeyControls'", CheckBoxPreference.class);
        mkComicSettingActivity.mReaderBanDoubleClick = (CheckBoxPreference) Utils.findRequiredViewAsType(view, R.id.settings_reader_ban_double_click, "field 'mReaderBanDoubleClick'", CheckBoxPreference.class);
        mkComicSettingActivity.mReaderQuickTurn = (CheckBoxPreference) Utils.findRequiredViewAsType(view, R.id.settings_reader_quick_turn, "field 'mReaderQuickTurn'", CheckBoxPreference.class);
        mkComicSettingActivity.settings_other_clear = (OptionFrameLayout) Utils.findRequiredViewAsType(view, R.id.settings_other_clear, "field 'settings_other_clear'", OptionFrameLayout.class);
        mkComicSettingActivity.mReaderInterval = (CheckBoxPreference) Utils.findRequiredViewAsType(view, R.id.settings_reader_interval, "field 'mReaderInterval'", CheckBoxPreference.class);
        mkComicSettingActivity.mReaderWifi = (CheckBoxPreference) Utils.findRequiredViewAsType(view, R.id.settings_reader_wifi, "field 'mReaderWifi'", CheckBoxPreference.class);
        mkComicSettingActivity.mReaderBottomTips = (CheckBoxPreference) Utils.findRequiredViewAsType(view, R.id.settings_reader_show_bottomtips, "field 'mReaderBottomTips'", CheckBoxPreference.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkComicSettingActivity mkComicSettingActivity = this.a;
        if (mkComicSettingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkComicSettingActivity.mReaderScaleFactor = null;
        mkComicSettingActivity.mReaderKeepBright = null;
        mkComicSettingActivity.mOtherNightAlpha = null;
        mkComicSettingActivity.mOtherShowTopbar = null;
        mkComicSettingActivity.mReaderVolumeKeyControls = null;
        mkComicSettingActivity.mReaderBanDoubleClick = null;
        mkComicSettingActivity.mReaderQuickTurn = null;
        mkComicSettingActivity.settings_other_clear = null;
        mkComicSettingActivity.mReaderInterval = null;
        mkComicSettingActivity.mReaderWifi = null;
        mkComicSettingActivity.mReaderBottomTips = null;
    }
}
