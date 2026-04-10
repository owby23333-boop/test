package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anetwork.channel.statist.StatisticData;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class NetworkResponse implements Parcelable, d.a.i {
    public static final Parcelable.Creator<NetworkResponse> CREATOR = new l();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f510s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f511t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    byte[] f512u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Map<String, List<String>> f513v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Throwable f514w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private StatisticData f515x;

    public NetworkResponse() {
    }

    public void a(int i2) {
        this.f510s = i2;
        this.f511t = ErrorConstant.getErrMsg(i2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NetworkResponse [");
        sb.append("statusCode=");
        sb.append(this.f510s);
        sb.append(", desc=");
        sb.append(this.f511t);
        sb.append(", connHeadFields=");
        sb.append(this.f513v);
        sb.append(", bytedata=");
        byte[] bArr = this.f512u;
        sb.append(bArr != null ? new String(bArr) : "");
        sb.append(", error=");
        sb.append(this.f514w);
        sb.append(", statisticData=");
        sb.append(this.f515x);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f510s);
        parcel.writeString(this.f511t);
        byte[] bArr = this.f512u;
        int length = bArr != null ? bArr.length : 0;
        parcel.writeInt(length);
        if (length > 0) {
            parcel.writeByteArray(this.f512u);
        }
        parcel.writeMap(this.f513v);
        StatisticData statisticData = this.f515x;
        if (statisticData != null) {
            parcel.writeSerializable(statisticData);
        }
    }

    public NetworkResponse(int i2) {
        this.f510s = i2;
        this.f511t = ErrorConstant.getErrMsg(i2);
    }

    public void a(byte[] bArr) {
        this.f512u = bArr;
    }

    public void a(Map<String, List<String>> map) {
        this.f513v = map;
    }

    public void a(String str) {
        this.f511t = str;
    }

    public String a() {
        return this.f511t;
    }

    public static NetworkResponse a(Parcel parcel) {
        NetworkResponse networkResponse = new NetworkResponse();
        try {
            networkResponse.f510s = parcel.readInt();
            networkResponse.f511t = parcel.readString();
            int i2 = parcel.readInt();
            if (i2 > 0) {
                networkResponse.f512u = new byte[i2];
                parcel.readByteArray(networkResponse.f512u);
            }
            networkResponse.f513v = parcel.readHashMap(NetworkResponse.class.getClassLoader());
            try {
                networkResponse.f515x = (StatisticData) parcel.readSerializable();
            } catch (Throwable unused) {
                ALog.i("anet.NetworkResponse", "[readFromParcel] source.readSerializable() error", null, new Object[0]);
            }
        } catch (Exception e2) {
            ALog.w("anet.NetworkResponse", "[readFromParcel]", null, e2, new Object[0]);
        }
        return networkResponse;
    }

    public void a(StatisticData statisticData) {
        this.f515x = statisticData;
    }
}
