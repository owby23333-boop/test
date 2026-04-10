package com.amgcyo.cuttadon.activity.main;

import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkNightModelActivity_ViewBinding implements Unbinder {
    private MkNightModelActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2603c;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkNightModelActivity f2604s;

        a(MkNightModelActivity_ViewBinding mkNightModelActivity_ViewBinding, MkNightModelActivity mkNightModelActivity) {
            this.f2604s = mkNightModelActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2604s.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkNightModelActivity f2605s;

        b(MkNightModelActivity_ViewBinding mkNightModelActivity_ViewBinding, MkNightModelActivity mkNightModelActivity) {
            this.f2605s = mkNightModelActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2605s.onViewClicked(view);
        }
    }

    @UiThread
    public MkNightModelActivity_ViewBinding(MkNightModelActivity mkNightModelActivity, View view) {
        this.a = mkNightModelActivity;
        mkNightModelActivity.sbYjms = (Switch) Utils.findRequiredViewAsType(view, R.id.sb_yjms, "field 'sbYjms'", Switch.class);
        mkNightModelActivity.sbHyms = (Switch) Utils.findRequiredViewAsType(view, R.id.sb_hyms, "field 'sbHyms'", Switch.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_blue_radio, "field 'tvBlueRadio' and method 'onViewClicked'");
        mkNightModelActivity.tvBlueRadio = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_blue_radio, "field 'tvBlueRadio'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkNightModelActivity));
        mkNightModelActivity.seekBarRadio = (SeekBar) Utils.findRequiredViewAsType(view, R.id.seekBar_radio, "field 'seekBarRadio'", SeekBar.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.csb_default, "field 'csbDefault' and method 'onViewClicked'");
        mkNightModelActivity.csbDefault = (TextView) Utils.castView(viewFindRequiredView2, R.id.csb_default, "field 'csbDefault'", TextView.class);
        this.f2603c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, mkNightModelActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkNightModelActivity mkNightModelActivity = this.a;
        if (mkNightModelActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkNightModelActivity.sbYjms = null;
        mkNightModelActivity.sbHyms = null;
        mkNightModelActivity.tvBlueRadio = null;
        mkNightModelActivity.seekBarRadio = null;
        mkNightModelActivity.csbDefault = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2603c.setOnClickListener(null);
        this.f2603c = null;
    }
}
