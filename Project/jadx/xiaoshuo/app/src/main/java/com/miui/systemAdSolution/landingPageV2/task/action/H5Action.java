package com.miui.systemAdSolution.landingPageV2.task.action;

import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import com.miui.systemAdSolution.landingPageV2.listener.IH5Listener;
import com.miui.systemAdSolution.landingPageV2.task.action.Action;

/* JADX INFO: loaded from: classes17.dex */
public class H5Action extends Action<IH5Listener> {
    private static final String TAG = "H5Action";
    private String mH5Url;

    public H5Action(Parcel parcel) {
        String string;
        super(parcel);
        if (parcel != null) {
            try {
                string = parcel.readString();
            } catch (Exception e) {
                Log.e(TAG, "H5Action parse parcel e : ", e);
                return;
            }
        } else {
            string = null;
        }
        this.mH5Url = string;
    }

    @Override // com.miui.systemAdSolution.landingPageV2.task.action.Action, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.miui.systemAdSolution.landingPageV2.task.action.Action
    public int getActionType() {
        return 2;
    }

    public String getH5Url() {
        return this.mH5Url;
    }

    @Override // com.miui.systemAdSolution.landingPageV2.task.action.Action, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mH5Url);
    }

    @Override // com.miui.systemAdSolution.landingPageV2.task.action.Action
    public IH5Listener readBinder(IBinder iBinder) {
        return IH5Listener.Stub.asInterface(iBinder);
    }

    public H5Action(Action.AdTrackInfo adTrackInfo, IH5Listener iH5Listener, boolean z, String str) {
        super(adTrackInfo, iH5Listener, z);
        if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "h5 url is null!");
        }
        this.mH5Url = str;
    }
}
