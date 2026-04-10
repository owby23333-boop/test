package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.widget.TextView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class TbsLogClient {
    static TbsLogClient a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static File f19185c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static String f19186d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static byte[] f19187e = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f19188i = true;
    TextView b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SimpleDateFormat f19189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f19190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private StringBuffer f19191h = new StringBuffer();

    private class a implements Runnable {
        String a;

        a(String str) {
            this.a = null;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView = TbsLogClient.this.b;
            if (textView != null) {
                textView.append(this.a + "\n");
            }
        }
    }

    public TbsLogClient(Context context) {
        this.f19189f = null;
        this.f19190g = null;
        try {
            this.f19190g = context.getApplicationContext();
            this.f19189f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS", Locale.US);
        } catch (Exception unused) {
            this.f19189f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        }
    }

    private void a() {
        String strA;
        try {
            if (f19185c == null) {
                if (!Environment.getExternalStorageState().equals("mounted") || (strA = FileUtil.a(this.f19190g, 6)) == null) {
                    f19185c = null;
                } else {
                    f19185c = new File(strA, "tbslog.txt");
                    f19186d = LogFileUtils.createKey();
                    f19187e = LogFileUtils.createHeaderText(f19185c.getName(), f19186d);
                }
            }
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        } catch (SecurityException e3) {
            e3.printStackTrace();
        }
    }

    public static void setWriteLogJIT(boolean z2) {
        f19188i = z2;
    }

    public void d(String str, String str2) {
    }

    public void e(String str, String str2) {
    }

    public void i(String str, String str2) {
    }

    public void setLogView(TextView textView) {
        this.b = textView;
    }

    public void showLog(String str) {
        TextView textView = this.b;
        if (textView != null) {
            textView.post(new a(str));
        }
    }

    public void v(String str, String str2) {
    }

    public void w(String str, String str2) {
    }

    public void writeLog(String str) {
        try {
            StringBuffer stringBuffer = this.f19191h;
            stringBuffer.append(System.currentTimeMillis());
            stringBuffer.append(" pid=");
            stringBuffer.append(Process.myPid());
            stringBuffer.append(" tid=");
            stringBuffer.append(Process.myTid());
            stringBuffer.append(str);
            stringBuffer.append("\n");
            if (Thread.currentThread() != Looper.getMainLooper().getThread() || f19188i) {
                writeLogToDisk();
            }
            if (this.f19191h.length() > 524288) {
                this.f19191h.delete(0, this.f19191h.length());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void writeLogToDisk() {
        try {
            a();
            if (f19185c != null) {
                LogFileUtils.writeDataToStorage(f19185c, f19186d, f19187e, this.f19191h.toString(), true);
                this.f19191h.delete(0, this.f19191h.length());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
