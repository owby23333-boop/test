package com.lxj.xpopup.impl;

import android.graphics.Color;
import android.os.Build;
import android.widget.TextView;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.lxj.xpopup.R$id;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.util.b;

/* JADX INFO: loaded from: classes3.dex */
public class LoadingPopupView extends CenterPopupView {
    private TextView R;
    private boolean S;
    private CharSequence T;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TransitionSet transitionSetAddTransition = new TransitionSet().setDuration(LoadingPopupView.this.getAnimationDuration()).addTransition(new Fade());
            if (!LoadingPopupView.this.S) {
                transitionSetAddTransition.addTransition(new ChangeBounds());
            }
            TransitionManager.beginDelayedTransition(((CenterPopupView) LoadingPopupView.this).N, transitionSetAddTransition);
            LoadingPopupView.this.S = false;
            if (LoadingPopupView.this.T == null || LoadingPopupView.this.T.length() == 0) {
                LoadingPopupView.this.R.setVisibility(8);
            } else {
                LoadingPopupView.this.R.setVisibility(0);
                LoadingPopupView.this.R.setText(LoadingPopupView.this.T);
            }
        }
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        int i2 = this.O;
        return i2 != 0 ? i2 : R$layout._xpopup_center_impl_loading;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.R = (TextView) findViewById(R$id.tv_title);
        if (Build.VERSION.SDK_INT >= 21) {
            getPopupImplView().setElevation(10.0f);
        }
        if (this.O == 0) {
            getPopupImplView().setBackground(b.a(Color.parseColor("#CF000000"), this.f17361s.f17421p));
        }
        y();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void s() {
        super.s();
        TextView textView = this.R;
        if (textView == null) {
            return;
        }
        textView.setText("");
        this.R.setVisibility(8);
    }

    protected void y() {
        if (this.R == null) {
            return;
        }
        post(new a());
    }
}
