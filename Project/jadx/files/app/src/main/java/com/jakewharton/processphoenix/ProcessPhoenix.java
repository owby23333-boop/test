package com.jakewharton.processphoenix;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ProcessPhoenix extends Activity {
    private static Intent a(Context context) {
        String packageName = context.getPackageName();
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (launchIntentForPackage != null) {
            return launchIntentForPackage;
        }
        throw new IllegalStateException("Unable to determine default activity for " + packageName + ". Does an activity specify the DEFAULT category in its intent filter?");
    }

    public static boolean isPhoenixProcess(Context context) {
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == iMyPid && runningAppProcessInfo.processName.endsWith(":phoenix")) {
                return true;
            }
        }
        return false;
    }

    public static void triggerRebirth(Context context) {
        triggerRebirth(context, a(context));
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Process.killProcess(getIntent().getIntExtra("phoenix_main_process_pid", -1));
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("phoenix_restart_intents");
        startActivities((Intent[]) parcelableArrayListExtra.toArray(new Intent[parcelableArrayListExtra.size()]));
        finish();
        Runtime.getRuntime().exit(0);
    }

    public static void triggerRebirth(Context context, Intent... intentArr) {
        if (intentArr.length < 1) {
            throw new IllegalArgumentException("intents cannot be empty");
        }
        intentArr[0].addFlags(268468224);
        Intent intent = new Intent(context, (Class<?>) ProcessPhoenix.class);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putParcelableArrayListExtra("phoenix_restart_intents", new ArrayList<>(Arrays.asList(intentArr)));
        intent.putExtra("phoenix_main_process_pid", Process.myPid());
        context.startActivity(intent);
    }
}
