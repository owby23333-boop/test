package com.amgcyo.cuttadon.activity.bookcity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity;
import com.amgcyo.cuttadon.fragment.books.w0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MkEndBookActivity extends BaseXTablayoutActivity {
    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity
    protected List<Fragment> getmFragments() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = extras.getInt("consume_type");
        arrayList.add(w0.a(i2, 1));
        arrayList.add(w0.a(i2, 2));
        if (!com.amgcyo.cuttadon.utils.otherutils.g.j0()) {
            arrayList.add(w0.a(i2, 5));
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
}
