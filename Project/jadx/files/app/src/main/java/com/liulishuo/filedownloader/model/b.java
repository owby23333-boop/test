package com.liulishuo.filedownloader.model;

/* JADX INFO: compiled from: FileDownloadStatus.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static boolean a(int i2) {
        return i2 > 0;
    }

    public static boolean a(int i2, int i3) {
        if ((i2 != 3 && i2 != 5 && i2 == i3) || b(i2)) {
            return false;
        }
        if (i2 >= 1 && i2 <= 6 && i3 >= 10 && i3 <= 11) {
            return false;
        }
        if (i2 == 1) {
            return i3 != 0;
        }
        if (i2 == 2) {
            return (i3 == 0 || i3 == 1 || i3 == 6) ? false : true;
        }
        if (i2 == 3) {
            return (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 6) ? false : true;
        }
        if (i2 == 5) {
            return (i3 == 1 || i3 == 6) ? false : true;
        }
        if (i2 != 6) {
            return true;
        }
        return (i3 == 0 || i3 == 1) ? false : true;
    }

    public static boolean b(int i2) {
        return i2 < 0;
    }

    public static boolean b(int i2, int i3) {
        if ((i2 != 3 && i2 != 5 && i2 == i3) || b(i2)) {
            return false;
        }
        if (i3 == -2 || i3 == -1) {
            return true;
        }
        if (i2 == 0) {
            return i3 == 10;
        }
        if (i2 == 1) {
            return i3 == 6;
        }
        if (i2 == 2 || i2 == 3) {
            return i3 == -3 || i3 == 3 || i3 == 5;
        }
        if (i2 == 5 || i2 == 6) {
            return i3 == 2 || i3 == 5;
        }
        if (i2 == 10) {
            return i3 == 11;
        }
        if (i2 != 11) {
            return false;
        }
        return i3 == -4 || i3 == -3 || i3 == 1;
    }

    public static boolean a(com.liulishuo.filedownloader.a aVar) {
        return aVar.c() == 0 || aVar.c() == 3;
    }
}
