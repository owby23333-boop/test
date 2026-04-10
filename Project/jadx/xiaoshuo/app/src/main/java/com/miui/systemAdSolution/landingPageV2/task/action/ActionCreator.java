package com.miui.systemAdSolution.landingPageV2.task.action;

import android.os.Parcel;
import android.util.Log;

/* JADX INFO: loaded from: classes17.dex */
public class ActionCreator {
    private static final String TAG = "ActionCreator";
    public static final int TYPE_DEEPLINK_ACTION = 1;
    public static final int TYPE_DOWNLOAD_ACTION = 3;
    public static final int TYPE_H5_ACTION = 2;
    public static final int TYPE_IACTION = 0;

    public static Action obtainAction(Parcel parcel) {
        int i = parcel.readInt();
        if (i == 0) {
            Log.d(TAG, "error : Action can't be instantiation");
            return null;
        }
        if (i == 1) {
            return new DeeplinkAction(parcel);
        }
        if (i == 2) {
            return new H5Action(parcel);
        }
        if (i == 3) {
            return new DownloadAction(parcel);
        }
        Log.d(TAG, "unknown action type : " + i);
        return null;
    }
}
