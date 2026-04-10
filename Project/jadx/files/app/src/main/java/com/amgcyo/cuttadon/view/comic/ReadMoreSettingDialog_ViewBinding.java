package com.amgcyo.cuttadon.view.comic;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class ReadMoreSettingDialog_ViewBinding implements Unbinder {
    private ReadMoreSettingDialog a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f4475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f4476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f4477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f4478f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f4479g;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ ReadMoreSettingDialog f4480s;

        a(ReadMoreSettingDialog_ViewBinding readMoreSettingDialog_ViewBinding, ReadMoreSettingDialog readMoreSettingDialog) {
            this.f4480s = readMoreSettingDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f4480s.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ ReadMoreSettingDialog f4481s;

        b(ReadMoreSettingDialog_ViewBinding readMoreSettingDialog_ViewBinding, ReadMoreSettingDialog readMoreSettingDialog) {
            this.f4481s = readMoreSettingDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f4481s.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ ReadMoreSettingDialog f4482s;

        c(ReadMoreSettingDialog_ViewBinding readMoreSettingDialog_ViewBinding, ReadMoreSettingDialog readMoreSettingDialog) {
            this.f4482s = readMoreSettingDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f4482s.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ ReadMoreSettingDialog f4483s;

        d(ReadMoreSettingDialog_ViewBinding readMoreSettingDialog_ViewBinding, ReadMoreSettingDialog readMoreSettingDialog) {
            this.f4483s = readMoreSettingDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f4483s.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ ReadMoreSettingDialog f4484s;

        e(ReadMoreSettingDialog_ViewBinding readMoreSettingDialog_ViewBinding, ReadMoreSettingDialog readMoreSettingDialog) {
            this.f4484s = readMoreSettingDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f4484s.onViewClicked(view);
        }
    }

    class f extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ ReadMoreSettingDialog f4485s;

        f(ReadMoreSettingDialog_ViewBinding readMoreSettingDialog_ViewBinding, ReadMoreSettingDialog readMoreSettingDialog) {
            this.f4485s = readMoreSettingDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f4485s.onViewClicked(view);
        }
    }

    @UiThread
    public ReadMoreSettingDialog_ViewBinding(ReadMoreSettingDialog readMoreSettingDialog, View view) {
        this.a = readMoreSettingDialog;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.cb_right_mode_read, "field 'cbRightModeRead' and method 'onViewClicked'");
        readMoreSettingDialog.cbRightModeRead = (CheckBox) Utils.castView(viewFindRequiredView, R.id.cb_right_mode_read, "field 'cbRightModeRead'", CheckBox.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, readMoreSettingDialog));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.cb_left_mode_read, "field 'cbLeftModeRead' and method 'onViewClicked'");
        readMoreSettingDialog.cbLeftModeRead = (CheckBox) Utils.castView(viewFindRequiredView2, R.id.cb_left_mode_read, "field 'cbLeftModeRead'", CheckBox.class);
        this.f4475c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, readMoreSettingDialog));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.cb_vertical_mode_read, "field 'cbVerticalModeRead' and method 'onViewClicked'");
        readMoreSettingDialog.cbVerticalModeRead = (CheckBox) Utils.castView(viewFindRequiredView3, R.id.cb_vertical_mode_read, "field 'cbVerticalModeRead'", CheckBox.class);
        this.f4476d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, readMoreSettingDialog));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.cb_cross_mode_read, "field 'cbCrossModeRead' and method 'onViewClicked'");
        readMoreSettingDialog.cbCrossModeRead = (CheckBox) Utils.castView(viewFindRequiredView4, R.id.cb_cross_mode_read, "field 'cbCrossModeRead'", CheckBox.class);
        this.f4477e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, readMoreSettingDialog));
        readMoreSettingDialog.tvMoreSetting = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_more_setting, "field 'tvMoreSetting'", TextView.class);
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.view_tr, "method 'onViewClicked'");
        this.f4478f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, readMoreSettingDialog));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.ll_more_setting, "method 'onViewClicked'");
        this.f4479g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(this, readMoreSettingDialog));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ReadMoreSettingDialog readMoreSettingDialog = this.a;
        if (readMoreSettingDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        readMoreSettingDialog.cbRightModeRead = null;
        readMoreSettingDialog.cbLeftModeRead = null;
        readMoreSettingDialog.cbVerticalModeRead = null;
        readMoreSettingDialog.cbCrossModeRead = null;
        readMoreSettingDialog.tvMoreSetting = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f4475c.setOnClickListener(null);
        this.f4475c = null;
        this.f4476d.setOnClickListener(null);
        this.f4476d = null;
        this.f4477e.setOnClickListener(null);
        this.f4477e = null;
        this.f4478f.setOnClickListener(null);
        this.f4478f = null;
        this.f4479g.setOnClickListener(null);
        this.f4479g = null;
    }
}
