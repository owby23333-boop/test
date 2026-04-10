package com.amgcyo.cuttadon.activity.user;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity;
import com.amgcyo.cuttadon.fragment.books.UserHistoryReadFragment;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MkHistoryReadActivity extends BaseXTablayoutActivity {
    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity
    protected List<Fragment> getmFragments() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(UserHistoryReadFragment.c(1));
        if (!com.amgcyo.cuttadon.utils.otherutils.g.j0()) {
            arrayList.add(UserHistoryReadFragment.c(3));
        }
        return arrayList;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity
    protected String[] n() {
        if (!com.amgcyo.cuttadon.utils.otherutils.g.j0()) {
            return new String[]{"小说", "漫画"};
        }
        int iB = com.amgcyo.cuttadon.f.o.b(R.color.text_33);
        this.E.a(iB, iB);
        this.E.setSelectedTabIndicatorHeight(0);
        return new String[]{"浏览历史"};
    }
}
