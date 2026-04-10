package com.amgcyo.cuttadon.activity.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkBackflowActivity extends BaseTitleBarActivity {

    @BindView(R.id.notic_view)
    View notic_view;

    @BindView(R.id.tv_cancel)
    TextView tvCancel;

    @BindView(R.id.tv_msg)
    TextView tvMsg;

    @BindView(R.id.tv_submit)
    TextView tvSubmit;

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

    public /* synthetic */ void e(View view) {
        com.amgcyo.cuttadon.view.webview.b.a((Context) a(), com.amgcyo.cuttadon.utils.otherutils.h.C0());
    }

    public /* synthetic */ void f(View view) {
        showMessage("成功退出账号，请重新登录");
        com.amgcyo.cuttadon.utils.otherutils.r0.b(a());
    }

    public /* synthetic */ void g(View view) {
        com.amgcyo.cuttadon.view.webview.b.a((Context) a(), com.amgcyo.cuttadon.utils.otherutils.h.C0());
    }

    @Override // me.jessyan.art.base.f.h
    @SuppressLint({"SetTextI18n"})
    public void initData(@Nullable Bundle bundle) {
        Bundle extras;
        this.isNeedNightModel = false;
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        String string = extras.getString("key_desc", "您当前使用的版本已经停用，请访问App官网下载最新版本。");
        int i2 = extras.getInt("errorCode", 0);
        this.tv_title.setText("系统通知");
        this.tvMsg.setText(string);
        a(this.tvCancel, this.notic_view);
        ViewGroup.LayoutParams layoutParams = this.tvSubmit.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).width = -1;
            this.tvSubmit.setLayoutParams(layoutParams);
        } else {
            this.tvCancel.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.main.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2639s.e(view);
                }
            });
        }
        MkUser mkUserJ = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (30 != i2 || mkUserJ == null) {
            this.tvSubmit.setText("去App官网下载");
            this.tvSubmit.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.main.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2640s.g(view);
                }
            });
        } else {
            this.tvSubmit.setText("重新登录");
            this.tvSubmit.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.main.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2642s.f(view);
                }
            });
        }
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.dialog_activity;
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

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 || i2 == 3) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }
}
