package com.amgcyo.cuttadon.activity.read;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkNovelSettingActivity_ViewBinding implements Unbinder {
    private MkNovelSettingActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f2704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f2705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f2706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f2707g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f2708h;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkNovelSettingActivity f2709s;

        a(MkNovelSettingActivity_ViewBinding mkNovelSettingActivity_ViewBinding, MkNovelSettingActivity mkNovelSettingActivity) {
            this.f2709s = mkNovelSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2709s.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkNovelSettingActivity f2710s;

        b(MkNovelSettingActivity_ViewBinding mkNovelSettingActivity_ViewBinding, MkNovelSettingActivity mkNovelSettingActivity) {
            this.f2710s = mkNovelSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2710s.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkNovelSettingActivity f2711s;

        c(MkNovelSettingActivity_ViewBinding mkNovelSettingActivity_ViewBinding, MkNovelSettingActivity mkNovelSettingActivity) {
            this.f2711s = mkNovelSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2711s.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkNovelSettingActivity f2712s;

        d(MkNovelSettingActivity_ViewBinding mkNovelSettingActivity_ViewBinding, MkNovelSettingActivity mkNovelSettingActivity) {
            this.f2712s = mkNovelSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2712s.onClick(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkNovelSettingActivity f2713s;

        e(MkNovelSettingActivity_ViewBinding mkNovelSettingActivity_ViewBinding, MkNovelSettingActivity mkNovelSettingActivity) {
            this.f2713s = mkNovelSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2713s.onClick(view);
        }
    }

    class f extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkNovelSettingActivity f2714s;

        f(MkNovelSettingActivity_ViewBinding mkNovelSettingActivity_ViewBinding, MkNovelSettingActivity mkNovelSettingActivity) {
            this.f2714s = mkNovelSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2714s.onClick(view);
        }
    }

    class g extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkNovelSettingActivity f2715s;

        g(MkNovelSettingActivity_ViewBinding mkNovelSettingActivity_ViewBinding, MkNovelSettingActivity mkNovelSettingActivity) {
            this.f2715s = mkNovelSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2715s.onClick(view);
        }
    }

    @UiThread
    public MkNovelSettingActivity_ViewBinding(MkNovelSettingActivity mkNovelSettingActivity, View view) {
        this.a = mkNovelSettingActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_tts_engine, "field 'tvTtsEngine' and method 'onClick'");
        mkNovelSettingActivity.tvTtsEngine = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_tts_engine, "field 'tvTtsEngine'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkNovelSettingActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_tts_model, "field 'tv_tts_model' and method 'onClick'");
        mkNovelSettingActivity.tv_tts_model = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_tts_model, "field 'tv_tts_model'", TextView.class);
        this.f2703c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, mkNovelSettingActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_lock_time, "field 'tv_lock_time' and method 'onClick'");
        mkNovelSettingActivity.tv_lock_time = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_lock_time, "field 'tv_lock_time'", TextView.class);
        this.f2704d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, mkNovelSettingActivity));
        mkNovelSettingActivity.switchVolumeKey = (Switch) Utils.findRequiredViewAsType(view, R.id.switch_volume_key, "field 'switchVolumeKey'", Switch.class);
        mkNovelSettingActivity.switchAllClickNext = (Switch) Utils.findRequiredViewAsType(view, R.id.switch_all_click_next, "field 'switchAllClickNext'", Switch.class);
        mkNovelSettingActivity.switch_keep_on = (Switch) Utils.findRequiredViewAsType(view, R.id.switch_keep_on, "field 'switch_keep_on'", Switch.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_tts_engine, "field 'll_tts_engine' and method 'onClick'");
        mkNovelSettingActivity.ll_tts_engine = (LinearLayout) Utils.castView(viewFindRequiredView4, R.id.ll_tts_engine, "field 'll_tts_engine'", LinearLayout.class);
        this.f2705e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, mkNovelSettingActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.ll_keep_alive, "method 'onClick'");
        this.f2706f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, mkNovelSettingActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.ll_tts_model, "method 'onClick'");
        this.f2707g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(this, mkNovelSettingActivity));
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.ll_lock_time, "method 'onClick'");
        this.f2708h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(this, mkNovelSettingActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkNovelSettingActivity mkNovelSettingActivity = this.a;
        if (mkNovelSettingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkNovelSettingActivity.tvTtsEngine = null;
        mkNovelSettingActivity.tv_tts_model = null;
        mkNovelSettingActivity.tv_lock_time = null;
        mkNovelSettingActivity.switchVolumeKey = null;
        mkNovelSettingActivity.switchAllClickNext = null;
        mkNovelSettingActivity.switch_keep_on = null;
        mkNovelSettingActivity.ll_tts_engine = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2703c.setOnClickListener(null);
        this.f2703c = null;
        this.f2704d.setOnClickListener(null);
        this.f2704d = null;
        this.f2705e.setOnClickListener(null);
        this.f2705e = null;
        this.f2706f.setOnClickListener(null);
        this.f2706f = null;
        this.f2707g.setOnClickListener(null);
        this.f2707g = null;
        this.f2708h.setOnClickListener(null);
        this.f2708h = null;
    }
}
