package anetwork.channel.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.a;
import anet.channel.request.BodyEntry;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class BodyHandlerEntry implements BodyEntry {
    public static final Parcelable.Creator<BodyHandlerEntry> CREATOR = new a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    anetwork.channel.aidl.d f570s;

    /* synthetic */ BodyHandlerEntry(a aVar) {
        this();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // anet.channel.request.BodyEntry
    public String getContentType() {
        return null;
    }

    @Override // anet.channel.request.BodyEntry
    public int writeTo(OutputStream outputStream) throws IOException {
        try {
            ByteArray byteArrayA = a.C0005a.a.a(2048);
            int i2 = 0;
            while (!this.f570s.isCompleted()) {
                int i3 = this.f570s.read(byteArrayA.getBuffer());
                outputStream.write(byteArrayA.getBuffer(), 0, i3);
                i2 += i3;
            }
            byteArrayA.recycle();
            return i2;
        } catch (RemoteException e2) {
            throw new IOException("RemoteException", e2);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStrongInterface(this.f570s);
    }

    private BodyHandlerEntry() {
        this.f570s = null;
    }
}
