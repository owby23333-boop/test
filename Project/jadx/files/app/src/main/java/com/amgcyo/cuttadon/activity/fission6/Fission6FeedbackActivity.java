package com.amgcyo.cuttadon.activity.fission6;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.fragment.books.MkFeedbackFragment;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class Fission6FeedbackActivity extends BaseTitleBarActivity<UserPresenter> {
    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "我要反馈";
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            finish();
            return;
        }
        String string = extras.getString("otherdata");
        MkFeedbackFragment mkFeedbackFragment = new MkFeedbackFragment();
        mkFeedbackFragment.a((Object) string);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mkFeedbackFragment).commit();
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.fission6_index_activity;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @Override // me.jessyan.art.base.f.h
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this));
    }
}
