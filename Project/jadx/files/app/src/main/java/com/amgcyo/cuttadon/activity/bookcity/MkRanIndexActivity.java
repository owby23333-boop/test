package com.amgcyo.cuttadon.activity.bookcity;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity;
import com.amgcyo.cuttadon.fragment.books.MkBookRankIndexFragment;
import com.baidu.mobads.sdk.api.ArticleInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MkRanIndexActivity extends BaseXTablayoutActivity {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    MkBookRankIndexFragment f2331o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    MkBookRankIndexFragment f2332p0;

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity
    protected List<Fragment> getmFragments() {
        ArrayList arrayList = new ArrayList();
        this.f2331o0 = new MkBookRankIndexFragment();
        this.f2331o0.a((Object) 1);
        this.f2332p0 = new MkBookRankIndexFragment();
        this.f2332p0.a((Object) 2);
        arrayList.add(this.f2331o0);
        arrayList.add(this.f2332p0);
        if (!com.amgcyo.cuttadon.utils.otherutils.g.j0()) {
            MkBookRankIndexFragment mkBookRankIndexFragment = new MkBookRankIndexFragment();
            mkBookRankIndexFragment.a((Object) 5);
            arrayList.add(mkBookRankIndexFragment);
        }
        return arrayList;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString(ArticleInfo.USER_SEX);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            if ("male".equals(string)) {
                this.vpClassify.setCurrentItem(0);
            } else {
                this.vpClassify.setCurrentItem(1);
            }
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity
    protected String[] n() {
        return !com.amgcyo.cuttadon.utils.otherutils.g.j0() ? new String[]{" 男生 ", " 女生 ", " 漫画 "} : new String[]{" 男生 ", " 女生 "};
    }
}
