package com.amgcyo.cuttadon.activity.search;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity;
import com.amgcyo.cuttadon.fragment.books.MkHotSearchFragment;
import com.baidu.mobads.sdk.api.ArticleInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MkHotSearchActivity extends BaseXTablayoutActivity {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    int f2772o0 = 0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    MkHotSearchFragment f2773p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    MkHotSearchFragment f2774q0;

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity
    protected List<Fragment> getmFragments() {
        ArrayList arrayList = new ArrayList();
        this.f2773p0 = new MkHotSearchFragment();
        this.f2773p0.a((Object) 1);
        this.f2774q0 = new MkHotSearchFragment();
        this.f2774q0.a((Object) 2);
        arrayList.add(this.f2773p0);
        arrayList.add(this.f2774q0);
        return arrayList;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        this.f2772o0 = extras.getInt(ArticleInfo.USER_SEX, 0);
        String str = "sex: " + this.f2772o0;
        int i2 = this.f2772o0;
        if (i2 == 0 || i2 == 1) {
            this.vpClassify.setCurrentItem(0);
        } else {
            this.vpClassify.setCurrentItem(1);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity
    protected String[] n() {
        return com.amgcyo.cuttadon.utils.otherutils.g.a;
    }
}
