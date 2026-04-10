package com.liulishuo.filedownloader.message;

import android.os.Parcel;
import android.os.Parcelable;
import com.liulishuo.filedownloader.h0.f;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot;
import com.liulishuo.filedownloader.message.SmallMessageSnapshot;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MessageSnapshot implements com.liulishuo.filedownloader.message.b, Parcelable {
    public static final Parcelable.Creator<MessageSnapshot> CREATOR = new a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f17239s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected boolean f17240t;

    public static class NoFieldException extends IllegalStateException {
        NoFieldException(String str, MessageSnapshot messageSnapshot) {
            super(f.a("There isn't a field for '%s' in this message %d %d %s", str, Integer.valueOf(messageSnapshot.e()), Byte.valueOf(messageSnapshot.o()), messageSnapshot.getClass().getName()));
        }
    }

    public static class StartedMessageSnapshot extends MessageSnapshot {
        StartedMessageSnapshot(int i2) {
            super(i2);
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte o() {
            return (byte) 6;
        }

        StartedMessageSnapshot(Parcel parcel) {
            super(parcel);
        }
    }

    static class a implements Parcelable.Creator<MessageSnapshot> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageSnapshot createFromParcel(Parcel parcel) {
            boolean z2 = parcel.readByte() == 1;
            byte b = parcel.readByte();
            MessageSnapshot startedMessageSnapshot = b != -4 ? b != -3 ? b != -1 ? b != 1 ? b != 2 ? b != 3 ? b != 5 ? b != 6 ? null : new StartedMessageSnapshot(parcel) : z2 ? new LargeMessageSnapshot.RetryMessageSnapshot(parcel) : new SmallMessageSnapshot.RetryMessageSnapshot(parcel) : z2 ? new LargeMessageSnapshot.ProgressMessageSnapshot(parcel) : new SmallMessageSnapshot.ProgressMessageSnapshot(parcel) : z2 ? new LargeMessageSnapshot.ConnectedMessageSnapshot(parcel) : new SmallMessageSnapshot.ConnectedMessageSnapshot(parcel) : z2 ? new LargeMessageSnapshot.PendingMessageSnapshot(parcel) : new SmallMessageSnapshot.PendingMessageSnapshot(parcel) : z2 ? new LargeMessageSnapshot.ErrorMessageSnapshot(parcel) : new SmallMessageSnapshot.ErrorMessageSnapshot(parcel) : z2 ? new LargeMessageSnapshot.CompletedSnapshot(parcel) : new SmallMessageSnapshot.CompletedSnapshot(parcel) : z2 ? new LargeMessageSnapshot.WarnMessageSnapshot(parcel) : new SmallMessageSnapshot.WarnMessageSnapshot(parcel);
            if (startedMessageSnapshot != null) {
                startedMessageSnapshot.f17240t = z2;
                return startedMessageSnapshot;
            }
            throw new IllegalStateException("Can't restore the snapshot because unknown status: " + ((int) b));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageSnapshot[] newArray(int i2) {
            return new MessageSnapshot[i2];
        }
    }

    public interface b {
        MessageSnapshot a();
    }

    MessageSnapshot(int i2) {
        this.f17239s = i2;
    }

    public String c() {
        throw new NoFieldException("getEtag", this);
    }

    public String d() {
        throw new NoFieldException("getFileName", this);
    }

    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f17239s;
    }

    public long f() {
        throw new NoFieldException("getLargeSofarBytes", this);
    }

    public long g() {
        throw new NoFieldException("getLargeTotalBytes", this);
    }

    public int h() {
        throw new NoFieldException("getRetryingTimes", this);
    }

    public int i() {
        throw new NoFieldException("getSmallSofarBytes", this);
    }

    public int n() {
        throw new NoFieldException("getSmallTotalBytes", this);
    }

    public abstract /* synthetic */ byte o();

    public Throwable p() {
        throw new NoFieldException("getThrowable", this);
    }

    public boolean q() {
        return this.f17240t;
    }

    public boolean r() {
        throw new NoFieldException("isResuming", this);
    }

    public boolean s() {
        throw new NoFieldException("isReusedDownloadedFile", this);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.f17240t ? (byte) 1 : (byte) 0);
        parcel.writeByte(o());
        parcel.writeInt(this.f17239s);
    }

    MessageSnapshot(Parcel parcel) {
        this.f17239s = parcel.readInt();
    }
}
