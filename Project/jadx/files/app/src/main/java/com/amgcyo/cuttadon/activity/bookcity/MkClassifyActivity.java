package com.amgcyo.cuttadon.activity.bookcity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity;
import com.amgcyo.cuttadon.fragment.books.v0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MkClassifyActivity extends BaseXTablayoutActivity {
    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity
    protected List<Fragment> getmFragments() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(v0.a(1, 1));
        arrayList.add(v0.a(2, 1));
        if (!com.amgcyo.cuttadon.utils.otherutils.g.j0()) {
            arrayList.add(v0.a(5, 3));
        }
        return arrayList;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity
    protected String[] n() {
        return !com.amgcyo.cuttadon.utils.otherutils.g.j0() ? new String[]{" 男生 ", " 女生 ", " 漫画 "} : new String[]{" 男生 ", " 女生 "};
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity, me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }
}
