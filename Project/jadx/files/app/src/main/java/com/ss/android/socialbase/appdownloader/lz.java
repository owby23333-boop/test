package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import com.anythink.expressad.foundation.h.i;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;

/* JADX INFO: loaded from: classes3.dex */
public class lz {
    public static int b(String str) {
        try {
            return mb(str, DownloadComponentManager.getAppContext().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int h(String str) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "id", DownloadComponentManager.getAppContext().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int hj(String str) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, i.f10647e, DownloadComponentManager.getAppContext().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int mb(String str) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "layout", DownloadComponentManager.getAppContext().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int ox(String str) {
        return mb(DownloadComponentManager.getAppContext(), str);
    }

    public static int u(String str) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, i.f10646d, DownloadComponentManager.getAppContext().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int ox(String str, String str2) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int mb(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, i.f10649g, context.getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int mb(String str, String str2) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, i.f10645c, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
