package miuix.appcompat.internal.app.widget;

import android.content.Context;
import miuix.appcompat.R;

/* JADX INFO: loaded from: classes7.dex */
public class SecondaryExpandTabContainer extends SecondaryTabContainerView {
    public SecondaryExpandTabContainer(Context context) {
        super(context);
        setContentHeight(getTabContainerHeight());
    }

    @Override // miuix.appcompat.internal.app.widget.SecondaryTabContainerView
    public int getDefaultTabTextStyle() {
        return R.attr.actionBarTabTextSecondaryExpandStyle;
    }

    @Override // miuix.appcompat.internal.app.widget.SecondaryTabContainerView
    public int getTabActivatedTextStyle() {
        return R.attr.actionBarTabActivatedTextSecondaryExpandStyle;
    }

    @Override // miuix.appcompat.internal.app.widget.SecondaryTabContainerView
    public int getTabContainerHeight() {
        return -2;
    }
}
