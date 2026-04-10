package com.amgcyo.cuttadon.activity.fission5;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class Fission5RegSuccessActivity extends BaseTitleBarActivity {

    @BindView(R.id.imageView_back)
    ImageView imageView_back;

    @BindView(R.id.tv_title)
    TextView tv_title;

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 19) {
            me.jessyan.art.f.h.a((Activity) a(), (View) null);
            int iA = me.jessyan.art.f.h.a(this.f2277w);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.imageView_back.getLayoutParams();
            layoutParams.topMargin = iA;
            this.imageView_back.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.tv_title.getLayoutParams();
            layoutParams2.topMargin = iA;
            this.tv_title.setLayoutParams(layoutParams2);
        }
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.fission5_reg_success;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }

    @OnClick({R.id.imageView_back, R.id.ll_yqhy})
    public void onClick(View view) {
        if (BaseTitleBarActivity.v()) {
            o.d(R.string.operating_busy);
            return;
        }
        int id = view.getId();
        if (id == R.id.imageView_back) {
            finish();
        } else {
            if (id != R.id.ll_yqhy) {
                return;
            }
            r0.startActivity(this.f2277w, Fission5InvaliUserActivity.class);
        }
    }
}
