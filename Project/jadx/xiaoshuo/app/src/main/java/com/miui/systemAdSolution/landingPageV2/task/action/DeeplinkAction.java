package com.miui.systemAdSolution.landingPageV2.task.action;

import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import com.miui.systemAdSolution.landingPageV2.listener.IDeeplinkListener;
import com.miui.systemAdSolution.landingPageV2.task.action.Action;

/* JADX INFO: loaded from: classes17.dex */
public class DeeplinkAction extends Action<IDeeplinkListener> {
    private static final String TAG = "DeeplinkAction";
    private String mTargetPackageName;
    private String mUrl;

    public DeeplinkAction(Parcel parcel) {
        String string;
        String string2;
        super(parcel);
        if (parcel != null) {
            try {
                string = parcel.readString();
                string2 = parcel.readString();
            } catch (Exception e) {
                Log.e(TAG, "DeeplinkAction parse parcel e : ", e);
                return;
            }
        } else {
            string = null;
            string2 = null;
        }
        this.mUrl = string;
        this.mTargetPackageName = string2;
    }

    @Override // com.miui.systemAdSolution.landingPageV2.task.action.Action, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.miui.systemAdSolution.landingPageV2.task.action.Action
    public int getActionType() {
        return 1;
    }

    public String getTargetPackageName() {
        return this.mTargetPackageName;
    }

    public String getUrl() {
        return this.mUrl;
    }

    @Override // com.miui.systemAdSolution.landingPageV2.task.action.Action, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mUrl);
        parcel.writeString(this.mTargetPackageName);
    }

    @Override // com.miui.systemAdSolution.landingPageV2.task.action.Action
    public IDeeplinkListener readBinder(IBinder iBinder) {
        return IDeeplinkListener.Stub.asInterface(iBinder);
    }

    public DeeplinkAction(Action.AdTrackInfo adTrackInfo, IDeeplinkListener iDeeplinkListener, boolean z, String str, String str2) {
        super(adTrackInfo, iDeeplinkListener, z);
        this.mUrl = str;
        this.mTargetPackageName = str2;
    }
}
