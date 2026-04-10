package com.amgcyo.cuttadon.view.popupview;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.view.otherview.DrawTextImageView;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class Sign5PopupView_ViewBinding implements Unbinder {
    private Sign5PopupView a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f5172c;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Sign5PopupView f5173s;

        a(Sign5PopupView_ViewBinding sign5PopupView_ViewBinding, Sign5PopupView sign5PopupView) {
            this.f5173s = sign5PopupView;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f5173s.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Sign5PopupView f5174s;

        b(Sign5PopupView_ViewBinding sign5PopupView_ViewBinding, Sign5PopupView sign5PopupView) {
            this.f5174s = sign5PopupView;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f5174s.onViewClicked(view);
        }
    }

    @UiThread
    public Sign5PopupView_ViewBinding(Sign5PopupView sign5PopupView, View view) {
        this.a = sign5PopupView;
        sign5PopupView.iv_bg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bg, "field 'iv_bg'", ImageView.class);
        sign5PopupView.tv_sign_tips = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_sign_tips, "field 'tv_sign_tips'", TextView.class);
        sign5PopupView.bt_lxqd = (TextView) Utils.findRequiredViewAsType(view, R.id.bt_lxqd, "field 'bt_lxqd'", TextView.class);
        sign5PopupView.ll_top_img = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_top_img, "field 'll_top_img'", LinearLayout.class);
        sign5PopupView.ph_top = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.ph_top, "field 'ph_top'", ProgressBar.class);
        sign5PopupView.ll_top_text = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_top_text, "field 'll_top_text'", LinearLayout.class);
        sign5PopupView.ll_coin_tips = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_coin_tips, "field 'll_coin_tips'", LinearLayout.class);
        sign5PopupView.ll_bottom = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_bottom, "field 'll_bottom'", LinearLayout.class);
        sign5PopupView.ph_bottom = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.ph_bottom, "field 'ph_bottom'", ProgressBar.class);
        sign5PopupView.vpb_right = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.vpb_right, "field 'vpb_right'", ProgressBar.class);
        sign5PopupView.rl_sign = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_sign, "field 'rl_sign'", RelativeLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.csb_login, "field 'csb_login' and method 'onViewClicked'");
        sign5PopupView.csb_login = (TextView) Utils.castView(viewFindRequiredView, R.id.csb_login, "field 'csb_login'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, sign5PopupView));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_close, "field 'iv_close' and method 'onViewClicked'");
        sign5PopupView.iv_close = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_close, "field 'iv_close'", ImageView.class);
        this.f5172c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, sign5PopupView));
        sign5PopupView.dti_day1 = (DrawTextImageView) Utils.findRequiredViewAsType(view, R.id.dti_day1, "field 'dti_day1'", DrawTextImageView.class);
        sign5PopupView.dti_day2 = (DrawTextImageView) Utils.findRequiredViewAsType(view, R.id.dti_day2, "field 'dti_day2'", DrawTextImageView.class);
        sign5PopupView.dti_day3 = (DrawTextImageView) Utils.findRequiredViewAsType(view, R.id.dti_day3, "field 'dti_day3'", DrawTextImageView.class);
        sign5PopupView.dti_day4 = (DrawTextImageView) Utils.findRequiredViewAsType(view, R.id.dti_day4, "field 'dti_day4'", DrawTextImageView.class);
        sign5PopupView.dti_day5 = (DrawTextImageView) Utils.findRequiredViewAsType(view, R.id.dti_day5, "field 'dti_day5'", DrawTextImageView.class);
        sign5PopupView.dti_day6 = (DrawTextImageView) Utils.findRequiredViewAsType(view, R.id.dti_day6, "field 'dti_day6'", DrawTextImageView.class);
        sign5PopupView.dti_day7 = (DrawTextImageView) Utils.findRequiredViewAsType(view, R.id.dti_day7, "field 'dti_day7'", DrawTextImageView.class);
        sign5PopupView.dti_day14 = (DrawTextImageView) Utils.findRequiredViewAsType(view, R.id.dti_day14, "field 'dti_day14'", DrawTextImageView.class);
        sign5PopupView.dti_day21 = (DrawTextImageView) Utils.findRequiredViewAsType(view, R.id.dti_day21, "field 'dti_day21'", DrawTextImageView.class);
        sign5PopupView.dti_day30 = (DrawTextImageView) Utils.findRequiredViewAsType(view, R.id.dti_day30, "field 'dti_day30'", DrawTextImageView.class);
        sign5PopupView.tv_day1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_day1, "field 'tv_day1'", TextView.class);
        sign5PopupView.tv_day2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_day2, "field 'tv_day2'", TextView.class);
        sign5PopupView.tv_day3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_day3, "field 'tv_day3'", TextView.class);
        sign5PopupView.tv_day4 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_day4, "field 'tv_day4'", TextView.class);
        sign5PopupView.tv_day5 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_day5, "field 'tv_day5'", TextView.class);
        sign5PopupView.tv_day6 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_day6, "field 'tv_day6'", TextView.class);
        sign5PopupView.tv_day7 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_day7, "field 'tv_day7'", TextView.class);
        sign5PopupView.tv_day14 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_day14, "field 'tv_day14'", TextView.class);
        sign5PopupView.tv_day21 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_day21, "field 'tv_day21'", TextView.class);
        sign5PopupView.tv_day30 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_day30, "field 'tv_day30'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        Sign5PopupView sign5PopupView = this.a;
        if (sign5PopupView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        sign5PopupView.iv_bg = null;
        sign5PopupView.tv_sign_tips = null;
        sign5PopupView.bt_lxqd = null;
        sign5PopupView.ll_top_img = null;
        sign5PopupView.ph_top = null;
        sign5PopupView.ll_top_text = null;
        sign5PopupView.ll_coin_tips = null;
        sign5PopupView.ll_bottom = null;
        sign5PopupView.ph_bottom = null;
        sign5PopupView.vpb_right = null;
        sign5PopupView.rl_sign = null;
        sign5PopupView.csb_login = null;
        sign5PopupView.iv_close = null;
        sign5PopupView.dti_day1 = null;
        sign5PopupView.dti_day2 = null;
        sign5PopupView.dti_day3 = null;
        sign5PopupView.dti_day4 = null;
        sign5PopupView.dti_day5 = null;
        sign5PopupView.dti_day6 = null;
        sign5PopupView.dti_day7 = null;
        sign5PopupView.dti_day14 = null;
        sign5PopupView.dti_day21 = null;
        sign5PopupView.dti_day30 = null;
        sign5PopupView.tv_day1 = null;
        sign5PopupView.tv_day2 = null;
        sign5PopupView.tv_day3 = null;
        sign5PopupView.tv_day4 = null;
        sign5PopupView.tv_day5 = null;
        sign5PopupView.tv_day6 = null;
        sign5PopupView.tv_day7 = null;
        sign5PopupView.tv_day14 = null;
        sign5PopupView.tv_day21 = null;
        sign5PopupView.tv_day30 = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f5172c.setOnClickListener(null);
        this.f5172c = null;
    }
}
