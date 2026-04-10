package com.amgcyo.cuttadon.activity.bookcity;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity;
import com.amgcyo.cuttadon.fragment.books.b1;
import com.baidu.mobads.sdk.api.ArticleInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MkShudanListActivity extends BaseXTablayoutActivity {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    b1 f2333o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    b1 f2334p0;

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity
    protected List<Fragment> getmFragments() {
        ArrayList arrayList = new ArrayList();
        this.f2333o0 = new b1();
        this.f2333o0.a((Object) 1);
        this.f2334p0 = new b1();
        this.f2334p0.a((Object) 2);
        arrayList.add(this.f2333o0);
        arrayList.add(this.f2334p0);
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
        return new String[]{" 男生 ", " 女生 "};
    }
}
