package com.amgcyo.cuttadon.activity.main;

import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.view.otherview.FixedAnimatedRadioButton;
import com.amgcyo.cuttadon.widget.ui.FixedSpeedViewpager;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkMainActivity_ViewBinding implements Unbinder {
    private MkMainActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f2594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f2595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f2596f;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkMainActivity f2597s;

        a(MkMainActivity_ViewBinding mkMainActivity_ViewBinding, MkMainActivity mkMainActivity) {
            this.f2597s = mkMainActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2597s.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkMainActivity f2598s;

        b(MkMainActivity_ViewBinding mkMainActivity_ViewBinding, MkMainActivity mkMainActivity) {
            this.f2598s = mkMainActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2598s.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkMainActivity f2599s;

        c(MkMainActivity_ViewBinding mkMainActivity_ViewBinding, MkMainActivity mkMainActivity) {
            this.f2599s = mkMainActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2599s.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkMainActivity f2600s;

        d(MkMainActivity_ViewBinding mkMainActivity_ViewBinding, MkMainActivity mkMainActivity) {
            this.f2600s = mkMainActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2600s.onClick(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkMainActivity f2601s;

        e(MkMainActivity_ViewBinding mkMainActivity_ViewBinding, MkMainActivity mkMainActivity) {
            this.f2601s = mkMainActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2601s.onClick(view);
        }
    }

    @UiThread
    public MkMainActivity_ViewBinding(MkMainActivity mkMainActivity, View view) {
        this.a = mkMainActivity;
        mkMainActivity.viewpager = (FixedSpeedViewpager) Utils.findRequiredViewAsType(view, R.id.viewpager, "field 'viewpager'", FixedSpeedViewpager.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.rb_bookshelf, "field 'rb_bookshelf' and method 'onClick'");
        mkMainActivity.rb_bookshelf = (FixedAnimatedRadioButton) Utils.castView(viewFindRequiredView, R.id.rb_bookshelf, "field 'rb_bookshelf'", FixedAnimatedRadioButton.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkMainActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rb_bookCity, "field 'rb_bookCity' and method 'onClick'");
        mkMainActivity.rb_bookCity = (FixedAnimatedRadioButton) Utils.castView(viewFindRequiredView2, R.id.rb_bookCity, "field 'rb_bookCity'", FixedAnimatedRadioButton.class);
        this.f2593c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, mkMainActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rb_mine, "field 'rb_mine' and method 'onClick'");
        mkMainActivity.rb_mine = (FixedAnimatedRadioButton) Utils.castView(viewFindRequiredView3, R.id.rb_mine, "field 'rb_mine'", FixedAnimatedRadioButton.class);
        this.f2594d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, mkMainActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.rb_qiushu, "field 'rb_qiushu' and method 'onClick'");
        mkMainActivity.rb_qiushu = (FixedAnimatedRadioButton) Utils.castView(viewFindRequiredView4, R.id.rb_qiushu, "field 'rb_qiushu'", FixedAnimatedRadioButton.class);
        this.f2595e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, mkMainActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.rb_fission6, "field 'rb_fission6' and method 'onClick'");
        mkMainActivity.rb_fission6 = (FixedAnimatedRadioButton) Utils.castView(viewFindRequiredView5, R.id.rb_fission6, "field 'rb_fission6'", FixedAnimatedRadioButton.class);
        this.f2596f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, mkMainActivity));
        mkMainActivity.tabradios = (RadioGroup) Utils.findRequiredViewAsType(view, R.id.tabradios, "field 'tabradios'", RadioGroup.class);
        mkMainActivity.btn_qiushu = (Button) Utils.findRequiredViewAsType(view, R.id.btn_qiushu, "field 'btn_qiushu'", Button.class);
        mkMainActivity.btn_fission6 = (Button) Utils.findRequiredViewAsType(view, R.id.btn_fission6, "field 'btn_fission6'", Button.class);
        mkMainActivity.btn_my = (Button) Utils.findRequiredViewAsType(view, R.id.btn_my, "field 'btn_my'", Button.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkMainActivity mkMainActivity = this.a;
        if (mkMainActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkMainActivity.viewpager = null;
        mkMainActivity.rb_bookshelf = null;
        mkMainActivity.rb_bookCity = null;
        mkMainActivity.rb_mine = null;
        mkMainActivity.rb_qiushu = null;
        mkMainActivity.rb_fission6 = null;
        mkMainActivity.tabradios = null;
        mkMainActivity.btn_qiushu = null;
        mkMainActivity.btn_fission6 = null;
        mkMainActivity.btn_my = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2593c.setOnClickListener(null);
        this.f2593c = null;
        this.f2594d.setOnClickListener(null);
        this.f2594d = null;
        this.f2595e.setOnClickListener(null);
        this.f2595e = null;
        this.f2596f.setOnClickListener(null);
        this.f2596f = null;
    }
}
