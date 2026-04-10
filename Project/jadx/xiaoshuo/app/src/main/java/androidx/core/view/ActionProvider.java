package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActionProvider {
    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private SubUiVisibilityListener mSubUiVisibilityListener;
    private VisibilityListener mVisibilityListener;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface SubUiVisibilityListener {
        void onSubUiVisibilityChanged(boolean isVisible);
    }

    public interface VisibilityListener {
        void onActionProviderVisibilityChanged(boolean isVisible);
    }

    public ActionProvider(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem forItem) {
        return onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public void refreshVisibility() {
        if (this.mVisibilityListener == null || !overridesItemVisibility()) {
            return;
        }
        this.mVisibilityListener.onActionProviderVisibilityChanged(isVisible());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSubUiVisibilityListener(SubUiVisibilityListener listener2) {
        this.mSubUiVisibilityListener = listener2;
    }

    public void setVisibilityListener(VisibilityListener listener2) {
        if (this.mVisibilityListener != null && listener2 != null) {
            Log.w(TAG, "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.mVisibilityListener = listener2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void subUiVisibilityChanged(boolean isVisible) {
        SubUiVisibilityListener subUiVisibilityListener = this.mSubUiVisibilityListener;
        if (subUiVisibilityListener != null) {
            subUiVisibilityListener.onSubUiVisibilityChanged(isVisible);
        }
    }
}
