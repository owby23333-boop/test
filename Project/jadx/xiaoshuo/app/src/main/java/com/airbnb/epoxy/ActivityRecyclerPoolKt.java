package com.airbnb.epoxy;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000¨\u0006\u0003"}, d2 = {"isActivityDestroyed", "", "Landroid/content/Context;", "epoxy-adapter_release"}, k = 2, mv = {1, 4, 2})
public final class ActivityRecyclerPoolKt {
    public static final boolean isActivityDestroyed(@Nullable Context context) {
        Context baseContext;
        if (context == null) {
            return true;
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing()) {
                return true;
            }
            return activity.isDestroyed();
        }
        if (!(context instanceof ContextWrapper)) {
            context = null;
        }
        ContextWrapper contextWrapper = (ContextWrapper) context;
        if (contextWrapper == null || (baseContext = contextWrapper.getBaseContext()) == null) {
            return false;
        }
        return isActivityDestroyed(baseContext);
    }
}
