package com.duokan.dksearch_export.service;

import android.content.Context;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.yuewen.vo;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public interface SearchService extends IProvider {
    List<vo> getSearchHintList(String str);

    List<vo> getSearchResultList(String str);

    void gotoOldSearchPage(Context context, String str, String str2, boolean z);

    void gotoSearchPage(Context context, String str, String str2, String str3);

    void gotoSearchPage(Context context, String str, String str2, String str3, boolean z);

    void gotoSearchResultPage(Context context, String str, String str2);

    default void s2(Context context, String str, boolean z) {
        gotoSearchPage(context, null, null, str, z);
    }

    default void v2(Context context, String str) {
        gotoSearchPage(context, null, null, str);
    }
}
