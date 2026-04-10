package fm.qingting.common.android;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import androidx.core.util.ObjectsCompat;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class ProcessUtil {
    private static String currentProcessName;

    public static int getProcessId(Context context, String name) {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : getRunningProcesses(context)) {
            if (ObjectsCompat.equals(name, runningAppProcessInfo.processName)) {
                return runningAppProcessInfo.pid;
            }
        }
        return -1;
    }

    public static String getProcessName(Context context, int pid) {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : getRunningProcesses(context)) {
            if (runningAppProcessInfo.pid == pid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    private static List<ActivityManager.RunningAppProcessInfo> getRunningProcesses(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemServicesKt.getActivityManager(context).getRunningAppProcesses();
        return runningAppProcesses == null ? Collections.emptyList() : runningAppProcesses;
    }

    public static boolean isMainProcess(Context context) {
        return ObjectsCompat.equals(context.getPackageName(), getProcessName(context));
    }

    public static void killAllProcesses(Context context) {
        killOtherProcesses(context);
        Process.killProcess(Process.myPid());
    }

    public static void killOtherProcesses(Context context) {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : getRunningProcesses(context)) {
            if (runningAppProcessInfo.uid == Process.myUid() && runningAppProcessInfo.pid != Process.myPid()) {
                Process.killProcess(runningAppProcessInfo.pid);
            }
        }
    }

    public static boolean processExists(Context context, String name) {
        return getProcessId(context, name) != -1;
    }

    public static synchronized String getProcessName(Context context) {
        if (currentProcessName == null) {
            currentProcessName = getProcessName(context, Process.myPid());
        }
        return currentProcessName;
    }
}
