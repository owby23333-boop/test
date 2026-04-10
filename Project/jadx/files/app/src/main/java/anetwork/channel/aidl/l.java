package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
final class l implements Parcelable.Creator<NetworkResponse> {
    l() {
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public NetworkResponse createFromParcel(Parcel parcel) {
        return NetworkResponse.a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public NetworkResponse[] newArray(int i2) {
        return new NetworkResponse[i2];
    }
}
