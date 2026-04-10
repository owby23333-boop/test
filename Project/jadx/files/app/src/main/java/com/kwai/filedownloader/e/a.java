package com.kwai.filedownloader.e;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static boolean cw(int i2) {
        h("request pause the task[%d] in the download service", Integer.valueOf(i2));
        return false;
    }

    public static byte cx(int i2) {
        h("request get the status for the task[%d] in the download service", Integer.valueOf(i2));
        return (byte) 0;
    }

    public static boolean cy(int i2) {
        h("request clear the task[%d] data in the database", Integer.valueOf(i2));
        return false;
    }

    private static void h(String str, Object... objArr) {
        d.h(a.class, str + ", but the download service isn't connected yet.\nYou can use FileDownloader#isServiceConnected() to check whether the service has been connected, \nbesides you can use following functions easier to control your requestHttpCode invoke after the service has been connected: \n1. FileDownloader#bindService(Runnable)\n2. FileDownloader#insureServiceBind()\n3. FileDownloader#insureServiceBindAsync()", objArr);
    }

    public static boolean l(String str, String str2, boolean z2) {
        h("request start the task([%s], [%s], [%B]) in the download service", str, str2, Boolean.valueOf(z2));
        return false;
    }
}
