package com.amgcyo.cuttadon.activity.bookcity;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.fragment.books.u0;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkListThemeSexActivity extends BaseTitleBarActivity {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    int f2330n0 = 0;

    @BindView(R.id.toolbar_title)
    TextView textView;

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "热门书单";
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            showMessage(o.d(R.string.error_params));
            finish();
            return;
        }
        this.textView.setText(d());
        this.f2330n0 = extras.getInt(ArticleInfo.USER_SEX, 0);
        String str = "sex: " + this.f2330n0;
        u0 u0Var = new u0();
        u0Var.a(Integer.valueOf(this.f2330n0));
        getSupportFragmentManager().beginTransaction().add(R.id.fl_content, u0Var).commit();
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_base;
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
}
