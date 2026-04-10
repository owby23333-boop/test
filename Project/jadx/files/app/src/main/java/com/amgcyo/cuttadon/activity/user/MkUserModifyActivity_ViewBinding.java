package com.amgcyo.cuttadon.activity.user;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkUserModifyActivity_ViewBinding implements Unbinder {
    private MkUserModifyActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f2962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f2963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f2964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f2965g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f2966h;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUserModifyActivity f2967s;

        a(MkUserModifyActivity_ViewBinding mkUserModifyActivity_ViewBinding, MkUserModifyActivity mkUserModifyActivity) {
            this.f2967s = mkUserModifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2967s.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUserModifyActivity f2968s;

        b(MkUserModifyActivity_ViewBinding mkUserModifyActivity_ViewBinding, MkUserModifyActivity mkUserModifyActivity) {
            this.f2968s = mkUserModifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2968s.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUserModifyActivity f2969s;

        c(MkUserModifyActivity_ViewBinding mkUserModifyActivity_ViewBinding, MkUserModifyActivity mkUserModifyActivity) {
            this.f2969s = mkUserModifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2969s.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUserModifyActivity f2970s;

        d(MkUserModifyActivity_ViewBinding mkUserModifyActivity_ViewBinding, MkUserModifyActivity mkUserModifyActivity) {
            this.f2970s = mkUserModifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2970s.onClick(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUserModifyActivity f2971s;

        e(MkUserModifyActivity_ViewBinding mkUserModifyActivity_ViewBinding, MkUserModifyActivity mkUserModifyActivity) {
            this.f2971s = mkUserModifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2971s.onClick(view);
        }
    }

    class f extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUserModifyActivity f2972s;

        f(MkUserModifyActivity_ViewBinding mkUserModifyActivity_ViewBinding, MkUserModifyActivity mkUserModifyActivity) {
            this.f2972s = mkUserModifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2972s.onClick(view);
        }
    }

    class g extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUserModifyActivity f2973s;

        g(MkUserModifyActivity_ViewBinding mkUserModifyActivity_ViewBinding, MkUserModifyActivity mkUserModifyActivity) {
            this.f2973s = mkUserModifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2973s.onClick(view);
        }
    }

    @UiThread
    public MkUserModifyActivity_ViewBinding(MkUserModifyActivity mkUserModifyActivity, View view) {
        this.a = mkUserModifyActivity;
        mkUserModifyActivity.ivUserImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_userImg, "field 'ivUserImg'", ImageView.class);
        mkUserModifyActivity.tvUserName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_user_name, "field 'tvUserName'", TextView.class);
        mkUserModifyActivity.tvNick = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_nick, "field 'tvNick'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_nick, "field 'llNick' and method 'onClick'");
        mkUserModifyActivity.llNick = (LinearLayout) Utils.castView(viewFindRequiredView, R.id.ll_nick, "field 'llNick'", LinearLayout.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkUserModifyActivity));
        mkUserModifyActivity.tv_phone = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_phone, "field 'tv_phone'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_bind_phone, "field 'llBindPhone' and method 'onClick'");
        mkUserModifyActivity.llBindPhone = (LinearLayout) Utils.castView(viewFindRequiredView2, R.id.ll_bind_phone, "field 'llBindPhone'", LinearLayout.class);
        this.f2961c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, mkUserModifyActivity));
        mkUserModifyActivity.iv_red_circle = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_red_circle, "field 'iv_red_circle'", ImageView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_cancel_account, "field 'll_cancel_account' and method 'onClick'");
        mkUserModifyActivity.ll_cancel_account = (LinearLayout) Utils.castView(viewFindRequiredView3, R.id.ll_cancel_account, "field 'll_cancel_account'", LinearLayout.class);
        this.f2962d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, mkUserModifyActivity));
        mkUserModifyActivity.view_line = Utils.findRequiredView(view, R.id.view_line, "field 'view_line'");
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_avatar, "method 'onClick'");
        this.f2963e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, mkUserModifyActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.ll_username, "method 'onClick'");
        this.f2964f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, mkUserModifyActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.ll_update_pwd, "method 'onClick'");
        this.f2965g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(this, mkUserModifyActivity));
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.tv_login_out, "method 'onClick'");
        this.f2966h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(this, mkUserModifyActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkUserModifyActivity mkUserModifyActivity = this.a;
        if (mkUserModifyActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkUserModifyActivity.ivUserImg = null;
        mkUserModifyActivity.tvUserName = null;
        mkUserModifyActivity.tvNick = null;
        mkUserModifyActivity.llNick = null;
        mkUserModifyActivity.tv_phone = null;
        mkUserModifyActivity.llBindPhone = null;
        mkUserModifyActivity.iv_red_circle = null;
        mkUserModifyActivity.ll_cancel_account = null;
        mkUserModifyActivity.view_line = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2961c.setOnClickListener(null);
        this.f2961c = null;
        this.f2962d.setOnClickListener(null);
        this.f2962d = null;
        this.f2963e.setOnClickListener(null);
        this.f2963e = null;
        this.f2964f.setOnClickListener(null);
        this.f2964f = null;
        this.f2965g.setOnClickListener(null);
        this.f2965g = null;
        this.f2966h.setOnClickListener(null);
        this.f2966h = null;
    }
}
