package me.imid.swipebacklayout.lib.app;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

/* JADX INFO: loaded from: classes8.dex */
public class SwipeBackPreferenceActivity extends PreferenceActivity implements SwipeBackActivityBase {
    private SwipeBackActivityHelper mHelper;

    @Override // android.app.Activity
    public View findViewById(int i) {
        SwipeBackActivityHelper swipeBackActivityHelper;
        View viewFindViewById = super.findViewById(i);
        return (viewFindViewById != null || (swipeBackActivityHelper = this.mHelper) == null) ? viewFindViewById : swipeBackActivityHelper.findViewById(i);
    }

    @Override // me.imid.swipebacklayout.lib.app.SwipeBackActivityBase
    public SwipeBackLayout getSwipeBackLayout() {
        return this.mHelper.getSwipeBackLayout();
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SwipeBackActivityHelper swipeBackActivityHelper = new SwipeBackActivityHelper(this);
        this.mHelper = swipeBackActivityHelper;
        swipeBackActivityHelper.onActivityCreate();
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.mHelper.onPostCreate();
    }

    @Override // me.imid.swipebacklayout.lib.app.SwipeBackActivityBase
    public void scrollToFinishActivity() {
        getSwipeBackLayout().scrollToFinishActivity();
    }

    @Override // me.imid.swipebacklayout.lib.app.SwipeBackActivityBase
    public void setSwipeBackEnable(boolean z) {
        getSwipeBackLayout().setEnableGesture(z);
    }
}
