package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class NavUtils {
    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final String TAG = "NavUtils";

    private NavUtils() {
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Activity sourceActivity) {
        Intent parentActivityIntent = sourceActivity.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        String parentActivityName = getParentActivityName(sourceActivity);
        if (parentActivityName == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(sourceActivity, parentActivityName);
        try {
            return getParentActivityName(sourceActivity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(TAG, "getParentActivityIntent: bad parentActivityName '" + parentActivityName + "' in manifest");
            return null;
        }
    }

    @Nullable
    public static String getParentActivityName(@NonNull Activity sourceActivity) {
        try {
            return getParentActivityName(sourceActivity, sourceActivity.getComponentName());
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void navigateUpFromSameTask(@NonNull Activity sourceActivity) {
        Intent parentActivityIntent = getParentActivityIntent(sourceActivity);
        if (parentActivityIntent != null) {
            navigateUpTo(sourceActivity, parentActivityIntent);
            return;
        }
        throw new IllegalArgumentException("Activity " + sourceActivity.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
    }

    public static void navigateUpTo(@NonNull Activity sourceActivity, @NonNull Intent upIntent) {
        sourceActivity.navigateUpTo(upIntent);
    }

    public static boolean shouldUpRecreateTask(@NonNull Activity sourceActivity, @NonNull Intent targetIntent) {
        return sourceActivity.shouldUpRecreateTask(targetIntent);
    }

    @Nullable
    public static String getParentActivityName(@NonNull Context context, @NonNull ComponentName componentName) throws PackageManager.NameNotFoundException {
        String string;
        ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(componentName, Build.VERSION.SDK_INT >= 29 ? 269222528 : 787072);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString(PARENT_ACTIVITY)) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Context context, @NonNull Class<?> sourceActivityClass) throws PackageManager.NameNotFoundException {
        String parentActivityName = getParentActivityName(context, new ComponentName(context, sourceActivityClass));
        if (parentActivityName == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(context, parentActivityName);
        if (getParentActivityName(context, componentName) == null) {
            return Intent.makeMainActivity(componentName);
        }
        return new Intent().setComponent(componentName);
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Context context, @NonNull ComponentName componentName) throws PackageManager.NameNotFoundException {
        String parentActivityName = getParentActivityName(context, componentName);
        if (parentActivityName == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), parentActivityName);
        if (getParentActivityName(context, componentName2) == null) {
            return Intent.makeMainActivity(componentName2);
        }
        return new Intent().setComponent(componentName2);
    }
}
