package com.umeng.pagesdk;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;

/* JADX INFO: loaded from: classes4.dex */
public class PageManger {
    public static final String TAG = "PageManger";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f2376a = null;
    private static boolean b = false;
    private static EfsReporter c = null;
    private static PageConfigManger d = null;
    private static boolean e = true;
    private static float f = 0.0f;
    public static boolean isDebug = true;

    public static Context getApplicationContext() {
        return f2376a;
    }

    public static PageConfigManger getPageConfigManger() {
        return d;
    }

    public static float getRefreshRate() {
        return f;
    }

    public static EfsReporter getReporter() {
        return c;
    }

    public static void init(Context context, EfsReporter efsReporter) {
        if (context == null || efsReporter == null) {
            try {
                if (isDebug) {
                    Log.e(TAG, "init page manager error! parameter is null!");
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (isInit()) {
            if (isDebug) {
                Log.e(TAG, "invalid init ！");
            }
        } else {
            f2376a = context.getApplicationContext();
            c = efsReporter;
            d = new PageConfigManger(context, efsReporter);
            b = true;
        }
    }

    public static boolean isControlMainThread() {
        return e;
    }

    public static boolean isInit() {
        return b;
    }

    public static void onTracePageBegin(Activity activity, String str) {
        try {
            onTracePageBegin(activity, str, false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void onTracePageBegin(Activity activity, String str, boolean z) {
        if (activity != null) {
            try {
                if (activity.getClass() != null && activity.getClass().getName() != null && !TextUtils.isEmpty(str)) {
                    if (!z && (str.equals("onCreate") || str.equals("onStart") || str.equals("onResume") || str.equals("onPause"))) {
                        if (isDebug) {
                            Log.e(TAG, "tracePageBegin. parameter illegality!");
                            return;
                        }
                        return;
                    } else {
                        if (str.length() > 10) {
                            if (isDebug) {
                                Log.e(TAG, "tracePageBegin. method name is " + str + "method name over length !");
                                return;
                            }
                            return;
                        }
                        if (e && !e.a(activity.getApplicationContext()) && isDebug) {
                            Log.e(TAG, "tracePageBegin. Non main process !");
                        }
                        String name = activity.getClass().getName();
                        if (f <= 0.0f) {
                            f = Build.VERSION.SDK_INT >= 30 ? activity.getDisplay().getRefreshRate() : activity.getWindowManager().getDefaultDisplay().getRefreshRate();
                        }
                        d.a(name, str, z);
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (isDebug) {
            Log.e(TAG, "tracePageBegin. parameter null!");
        }
    }

    public static void onTracePageEnd(Activity activity, String str) {
        try {
            onTracePageEnd(activity, str, false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void onTracePageEnd(Activity activity, String str, boolean z) {
        if (activity != null) {
            try {
                if (activity.getClass() != null && activity.getClass().getName() != null && !TextUtils.isEmpty(str)) {
                    if (!z && (str.equals("onCreate") || str.equals("onStart") || str.equals("onResume") || str.equals("onPause"))) {
                        if (isDebug) {
                            Log.e(TAG, "tracePageEnd. parameter illegality!");
                            return;
                        }
                        return;
                    } else if (str.length() > 10) {
                        if (isDebug) {
                            Log.e(TAG, "tracePageEnd. method name is " + str + "method name over length !");
                            return;
                        }
                        return;
                    } else {
                        if (e && !e.a(activity.getApplicationContext()) && isDebug) {
                            Log.e(TAG, "tracePageBegin. Non main process !");
                        }
                        d.b(activity.getClass().getName(), str, z);
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (isDebug) {
            Log.e(TAG, "tracePageEnd. parameter null!");
        }
    }

    public static void setControlMainThread(boolean z) {
        e = z;
    }
}
