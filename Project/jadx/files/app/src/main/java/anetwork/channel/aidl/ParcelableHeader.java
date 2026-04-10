package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.util.ALog;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class ParcelableHeader implements Parcelable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static Parcelable.Creator<ParcelableHeader> f520u = new m();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f521s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Map<String, List<String>> f522t;

    public ParcelableHeader(int i2, Map<String, List<String>> map) {
        this.f522t = map;
        this.f521s = i2;
    }

    public Map<String, List<String>> a() {
        return this.f522t;
    }

    public int b() {
        return this.f521s;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ParcelableResponseHeader [responseCode=" + this.f521s + ", header=" + this.f522t + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        if (this.f522t != null) {
            parcel.writeInt(1);
            parcel.writeMap(this.f522t);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.f521s);
    }

    static ParcelableHeader a(Parcel parcel) {
        ParcelableHeader parcelableHeader = new ParcelableHeader();
        try {
            if (parcel.readInt() == 1) {
                parcelableHeader.f522t = parcel.readHashMap(ParcelableHeader.class.getClassLoader());
            }
            parcelableHeader.f521s = parcel.readInt();
        } catch (Throwable th) {
            ALog.e("anet.ParcelableHeader", "[readFromParcel]", null, th, new Object[0]);
        }
        return parcelableHeader;
    }

    ParcelableHeader() {
    }
}
