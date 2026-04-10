package com.anythink.nativead.api;

import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ATNativePrepareExInfo extends ATNativePrepareInfo {
    List<View> creativeClickViewList;

    public List<View> getCreativeClickViewList() {
        View view;
        List<View> list = this.creativeClickViewList;
        if (list != null && (view = this.closeView) != null) {
            list.remove(view);
        }
        return this.creativeClickViewList;
    }

    public void setCreativeClickViewList(List<View> list) {
        this.creativeClickViewList = list;
    }
}
