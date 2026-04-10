package com.amgcyo.cuttadon.activity.user;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.fragment.books.y0;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MkMsgNoticeActivity extends BaseXTablayoutActivity<UserPresenter> {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    y0 f2926o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    y0 f2927p0;

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity
    protected List<Fragment> getmFragments() {
        ArrayList arrayList = new ArrayList();
        this.f2926o0 = new y0();
        this.f2926o0.a((Object) 0);
        this.f2927p0 = new y0();
        this.f2927p0.a((Object) 1);
        arrayList.add(this.f2926o0);
        arrayList.add(this.f2927p0);
        return arrayList;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        g0.a().b("comment_number", false);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity
    protected String[] n() {
        return com.amgcyo.cuttadon.utils.otherutils.g.b;
    }
}
