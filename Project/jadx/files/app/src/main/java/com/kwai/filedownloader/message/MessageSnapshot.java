package com.kwai.filedownloader.message;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwai.filedownloader.message.d;
import com.kwai.filedownloader.message.h;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MessageSnapshot implements Parcelable, c {
    public static final Parcelable.Creator<MessageSnapshot> CREATOR = new Parcelable.Creator<MessageSnapshot>() { // from class: com.kwai.filedownloader.message.MessageSnapshot.1
        private static MessageSnapshot a(Parcel parcel) {
            boolean z2 = parcel.readByte() == 1;
            byte b2 = parcel.readByte();
            MessageSnapshot bVar = b2 != -4 ? b2 != -3 ? b2 != -1 ? b2 != 1 ? b2 != 2 ? b2 != 3 ? b2 != 5 ? b2 != 6 ? null : new b(parcel) : z2 ? new d.h(parcel) : new h.C0470h(parcel) : z2 ? new d.g(parcel) : new h.g(parcel) : z2 ? new d.c(parcel) : new h.c(parcel) : z2 ? new d.f(parcel) : new h.f(parcel) : z2 ? new d.C0469d(parcel) : new h.d(parcel) : z2 ? new d.b(parcel) : new h.b(parcel) : z2 ? new d.j(parcel) : new h.j(parcel);
            if (bVar != null) {
                bVar.aGY = z2;
                return bVar;
            }
            throw new IllegalStateException("Can't restore the snapshot because unknown status: " + ((int) b2));
        }

        private static MessageSnapshot[] cT(int i2) {
            return new MessageSnapshot[i2];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MessageSnapshot createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MessageSnapshot[] newArray(int i2) {
            return cT(i2);
        }
    };
    protected boolean aGY;
    private final int id;

    public static class NoFieldException extends IllegalStateException {
        NoFieldException(String str, MessageSnapshot messageSnapshot) {
            super(com.kwai.filedownloader.e.f.j("There isn't a field for '%s' in this message %d %d %s", str, Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.Ge()), messageSnapshot.getClass().getName()));
        }
    }

    public interface a {
        MessageSnapshot Ii();
    }

    public static class b extends MessageSnapshot {
        b(int i2) {
            super(i2);
        }

        b(Parcel parcel) {
            super(parcel);
        }

        @Override // com.kwai.filedownloader.message.c
        public final byte Ge() {
            return (byte) 6;
        }
    }

    MessageSnapshot(int i2) {
        this.id = i2;
    }

    MessageSnapshot(Parcel parcel) {
        this.id = parcel.readInt();
    }

    public int Gi() {
        throw new NoFieldException("getRetryingTimes", this);
    }

    public final boolean Gk() {
        return this.aGY;
    }

    public boolean HU() {
        throw new NoFieldException("isResuming", this);
    }

    public int Ic() {
        throw new NoFieldException("getSmallSofarBytes", this);
    }

    public int Id() {
        throw new NoFieldException("getSmallTotalBytes", this);
    }

    public long Ie() {
        throw new NoFieldException("getLargeTotalBytes", this);
    }

    public boolean If() {
        throw new NoFieldException("isReusedDownloadedFile", this);
    }

    public long Ig() {
        throw new NoFieldException("getLargeSofarBytes", this);
    }

    public Throwable Ih() {
        throw new NoFieldException("getThrowable", this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getEtag() {
        throw new NoFieldException("getEtag", this);
    }

    public String getFileName() {
        throw new NoFieldException("getFileName", this);
    }

    public final int getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.aGY ? (byte) 1 : (byte) 0);
        parcel.writeByte(Ge());
        parcel.writeInt(this.id);
    }
}
