package com.amgcyo.cuttadon.activity.read;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkSettingBgmActivity_ViewBinding implements Unbinder {
    private MkSettingBgmActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2723c;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkSettingBgmActivity f2724s;

        a(MkSettingBgmActivity_ViewBinding mkSettingBgmActivity_ViewBinding, MkSettingBgmActivity mkSettingBgmActivity) {
            this.f2724s = mkSettingBgmActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2724s.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkSettingBgmActivity f2725s;

        b(MkSettingBgmActivity_ViewBinding mkSettingBgmActivity_ViewBinding, MkSettingBgmActivity mkSettingBgmActivity) {
            this.f2725s = mkSettingBgmActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2725s.onViewClicked(view);
        }
    }

    @UiThread
    public MkSettingBgmActivity_ViewBinding(MkSettingBgmActivity mkSettingBgmActivity, View view) {
        this.a = mkSettingBgmActivity;
        mkSettingBgmActivity.cbBgmSwitch = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cb_bgm_switch, "field 'cbBgmSwitch'", CheckBox.class);
        mkSettingBgmActivity.tvBgmVolume = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_bgm_volume, "field 'tvBgmVolume'", TextView.class);
        mkSettingBgmActivity.seekBarBgm = (SeekBar) Utils.findRequiredViewAsType(view, R.id.seekBar_bgm, "field 'seekBarBgm'", SeekBar.class);
        mkSettingBgmActivity.tvCurrentGbmName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_current_gbm_name, "field 'tvCurrentGbmName'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_selector_bgm, "field 'llSelectorBgm' and method 'onViewClicked'");
        mkSettingBgmActivity.llSelectorBgm = (LinearLayout) Utils.castView(viewFindRequiredView, R.id.ll_selector_bgm, "field 'llSelectorBgm'", LinearLayout.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkSettingBgmActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_find_bgm, "field 'llFindBgm' and method 'onViewClicked'");
        mkSettingBgmActivity.llFindBgm = (LinearLayout) Utils.castView(viewFindRequiredView2, R.id.ll_find_bgm, "field 'llFindBgm'", LinearLayout.class);
        this.f2723c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, mkSettingBgmActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkSettingBgmActivity mkSettingBgmActivity = this.a;
        if (mkSettingBgmActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkSettingBgmActivity.cbBgmSwitch = null;
        mkSettingBgmActivity.tvBgmVolume = null;
        mkSettingBgmActivity.seekBarBgm = null;
        mkSettingBgmActivity.tvCurrentGbmName = null;
        mkSettingBgmActivity.llSelectorBgm = null;
        mkSettingBgmActivity.llFindBgm = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2723c.setOnClickListener(null);
        this.f2723c = null;
    }
}
