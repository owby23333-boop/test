package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.request.BodyEntry;
import anet.channel.util.ALog;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class ParcelableRequest implements Parcelable {
    public static final Parcelable.Creator<ParcelableRequest> CREATOR = new n();
    public int B;
    public int C;
    public String D;
    public String E;
    public Map<String, String> F;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public d.a.h f523s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public BodyEntry f524t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f525u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f526v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f527w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f528x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f529y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Map<String, String> f530z = null;
    public Map<String, String> A = null;

    public static ParcelableRequest a(Parcel parcel) {
        ParcelableRequest parcelableRequest = new ParcelableRequest();
        try {
            parcelableRequest.f525u = parcel.readInt();
            parcelableRequest.f526v = parcel.readString();
            parcelableRequest.f527w = parcel.readString();
            boolean z2 = true;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            parcelableRequest.f528x = z2;
            parcelableRequest.f529y = parcel.readString();
            if (parcel.readInt() != 0) {
                parcelableRequest.f530z = parcel.readHashMap(ParcelableRequest.class.getClassLoader());
            }
            if (parcel.readInt() != 0) {
                parcelableRequest.A = parcel.readHashMap(ParcelableRequest.class.getClassLoader());
            }
            parcelableRequest.f524t = (BodyEntry) parcel.readParcelable(ParcelableRequest.class.getClassLoader());
            parcelableRequest.B = parcel.readInt();
            parcelableRequest.C = parcel.readInt();
            parcelableRequest.D = parcel.readString();
            parcelableRequest.E = parcel.readString();
            if (parcel.readInt() != 0) {
                parcelableRequest.F = parcel.readHashMap(ParcelableRequest.class.getClassLoader());
            }
        } catch (Throwable th) {
            ALog.w("anet.ParcelableRequest", "[readFromParcel]", null, th, new Object[0]);
        }
        return parcelableRequest;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        d.a.h hVar = this.f523s;
        if (hVar == null) {
            return;
        }
        try {
            parcel.writeInt(hVar.c());
            parcel.writeString(this.f526v);
            parcel.writeString(this.f523s.f());
            parcel.writeInt(this.f523s.b() ? 1 : 0);
            parcel.writeString(this.f523s.getMethod());
            parcel.writeInt(this.f530z == null ? 0 : 1);
            if (this.f530z != null) {
                parcel.writeMap(this.f530z);
            }
            parcel.writeInt(this.A == null ? 0 : 1);
            if (this.A != null) {
                parcel.writeMap(this.A);
            }
            parcel.writeParcelable(this.f524t, 0);
            parcel.writeInt(this.f523s.a());
            parcel.writeInt(this.f523s.getReadTimeout());
            parcel.writeString(this.f523s.d());
            parcel.writeString(this.f523s.g());
            Map<String, String> mapE = this.f523s.e();
            parcel.writeInt(mapE == null ? 0 : 1);
            if (mapE != null) {
                parcel.writeMap(mapE);
            }
        } catch (Throwable th) {
            ALog.w("anet.ParcelableRequest", "[writeToParcel]", null, th, new Object[0]);
        }
    }

    public String a(String str) {
        Map<String, String> map = this.F;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }
}
