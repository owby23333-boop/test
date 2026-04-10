package fm.qingting.common.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* JADX INFO: loaded from: classes8.dex */
public class MetaDataUtil {
    public static Bundle getMetaDataFromActivity(Context context, ComponentName componentName) {
        try {
            return context.getPackageManager().getActivityInfo(componentName, 128).metaData;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Bundle getMetaDataFromApplication(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Bundle getMetaDataFromProvider(Context context, ComponentName componentName) {
        try {
            return context.getPackageManager().getProviderInfo(componentName, 128).metaData;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Bundle getMetaDataFromReceiver(Context context, ComponentName componentName) {
        try {
            return context.getPackageManager().getReceiverInfo(componentName, 128).metaData;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Bundle getMetaDataFromService(Context context, ComponentName componentName) {
        try {
            return context.getPackageManager().getServiceInfo(componentName, 128).metaData;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
