package com.airbnb.epoxy;

import android.widget.Space;
import com.airbnb.viewmodeladapter.R;

/* JADX INFO: loaded from: classes.dex */
class HiddenEpoxyModel extends EpoxyModel<Space> {
    @Override // com.airbnb.epoxy.EpoxyModel
    public int getDefaultLayout() {
        return R.layout.view_holder_empty_view;
    }

    @Override // com.airbnb.epoxy.EpoxyModel
    public int getSpanSize(int i, int i2, int i3) {
        return 0;
    }
}
