package com.liulishuo.filedownloader.h0;

/* JADX INFO: compiled from: DownloadServiceNotConnectedHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static boolean a(String str, String str2, boolean z2) {
        a("request start the task([%s], [%s], [%B]) in the download service", str, str2, Boolean.valueOf(z2));
        return false;
    }

    public static boolean b(int i2) {
        a("request pause the task[%d] in the download service", Integer.valueOf(i2));
        return false;
    }

    public static byte a(int i2) {
        a("request get the status for the task[%d] in the download service", Integer.valueOf(i2));
        return (byte) 0;
    }

    public static void a(boolean z2) {
        a("request cancel the foreground status[%B] for the download service", Boolean.valueOf(z2));
    }

    private static void a(String str, Object... objArr) {
        d.e(a.class, str + ", but the download service isn't connected yet.\nYou can use FileDownloader#isServiceConnected() to check whether the service has been connected, \nbesides you can use following functions easier to control your code invoke after the service has been connected: \n1. FileDownloader#bindService(Runnable)\n2. FileDownloader#insureServiceBind()\n3. FileDownloader#insureServiceBindAsync()", objArr);
    }
}
