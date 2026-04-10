package ho;

import android.app.Application;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import java.util.Arrays;
import java.util.IllegalFormatException;

/* JADX INFO: loaded from: classes8.dex */
public final class j {
    public static String a(String str) {
        String str2;
        String processName = Application.getProcessName();
        if (processName != null) {
            str2 = processName.substring(processName.lastIndexOf(Consts.DOT) + 1) + "_";
        } else {
            str2 = "";
        }
        return "ho_" + str2 + str;
    }

    public static void b(String str, String str2, Object... objArr) {
        try {
            Log.i(a(str), String.format(str2, objArr));
        } catch (IllegalFormatException unused) {
            Log.i(a(str), str2 + Arrays.toString(objArr));
        }
    }

    public static void a(String str, String str2, Object... objArr) {
        try {
            Log.d(a(str), String.format(str2, objArr));
        } catch (IllegalFormatException unused) {
            Log.d(a(str), str2 + Arrays.toString(objArr));
        }
    }

    public static void b(String str, String str2, Throwable th) {
        Log.w(a(str), str2 + '\n' + Log.getStackTraceString(th));
    }

    public static void a(String str, String str2, Throwable th) {
        Log.e(a(str), str2, th);
    }
}
