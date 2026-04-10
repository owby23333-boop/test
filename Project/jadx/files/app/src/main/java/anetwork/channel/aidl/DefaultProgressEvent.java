package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class DefaultProgressEvent implements Parcelable, d.a.f {
    public static final Parcelable.Creator<DefaultProgressEvent> CREATOR = new k();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f505s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f506t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f507u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    Object f508v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    byte[] f509w;

    public DefaultProgressEvent() {
    }

    public void a(Object obj) {
        this.f508v = obj;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Object getContext() {
        return this.f508v;
    }

    public String toString() {
        return "DefaultProgressEvent [index=" + this.f505s + ", size=" + this.f506t + ", total=" + this.f507u + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f505s);
        parcel.writeInt(this.f506t);
        parcel.writeInt(this.f507u);
        byte[] bArr = this.f509w;
        parcel.writeInt(bArr != null ? bArr.length : 0);
        parcel.writeByteArray(this.f509w);
    }

    public DefaultProgressEvent(int i2, int i3, int i4, byte[] bArr) {
        this.f505s = i2;
        this.f506t = i3;
        this.f507u = i4;
        this.f509w = bArr;
    }

    public static DefaultProgressEvent a(Parcel parcel) {
        DefaultProgressEvent defaultProgressEvent = new DefaultProgressEvent();
        try {
            defaultProgressEvent.f505s = parcel.readInt();
            defaultProgressEvent.f506t = parcel.readInt();
            defaultProgressEvent.f507u = parcel.readInt();
            int i2 = parcel.readInt();
            if (i2 > 0) {
                byte[] bArr = new byte[i2];
                parcel.readByteArray(bArr);
                defaultProgressEvent.f509w = bArr;
            }
        } catch (Exception unused) {
        }
        return defaultProgressEvent;
    }
}
