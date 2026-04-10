package com.amgcyo.cuttadon.activity.setting;

import android.view.View;
import android.widget.Switch;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkSettingActivity_ViewBinding implements Unbinder {
    private MkSettingActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2853c;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkSettingActivity f2854s;

        a(MkSettingActivity_ViewBinding mkSettingActivity_ViewBinding, MkSettingActivity mkSettingActivity) {
            this.f2854s = mkSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2854s.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkSettingActivity f2855s;

        b(MkSettingActivity_ViewBinding mkSettingActivity_ViewBinding, MkSettingActivity mkSettingActivity) {
            this.f2855s = mkSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2855s.onClick(view);
        }
    }

    @UiThread
    public MkSettingActivity_ViewBinding(MkSettingActivity mkSettingActivity, View view) {
        this.a = mkSettingActivity;
        mkSettingActivity.switchJpush = (Switch) Utils.findRequiredViewAsType(view, R.id.switch_jpush, "field 'switchJpush'", Switch.class);
        mkSettingActivity.switch_csj = (Switch) Utils.findRequiredViewAsType(view, R.id.switch_csj, "field 'switch_csj'", Switch.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_about, "method 'onClick'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkSettingActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_clear_cache, "method 'onClick'");
        this.f2853c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, mkSettingActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkSettingActivity mkSettingActivity = this.a;
        if (mkSettingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkSettingActivity.switchJpush = null;
        mkSettingActivity.switch_csj = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2853c.setOnClickListener(null);
        this.f2853c = null;
    }
}
