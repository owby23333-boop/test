package com.liulishuo.filedownloader.message;

import android.os.Parcel;
import com.liulishuo.filedownloader.message.MessageSnapshot;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LargeMessageSnapshot extends MessageSnapshot {

    public static class CompletedFlowDirectlySnapshot extends CompletedSnapshot implements a {
        CompletedFlowDirectlySnapshot(int i2, boolean z2, long j2) {
            super(i2, z2, j2);
        }
    }

    public static class PausedSnapshot extends PendingMessageSnapshot {
        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte o() {
            return (byte) -2;
        }
    }

    public static class PendingMessageSnapshot extends LargeMessageSnapshot {

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final long f17235u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final long f17236v;

        PendingMessageSnapshot(PendingMessageSnapshot pendingMessageSnapshot) {
            this(pendingMessageSnapshot.e(), pendingMessageSnapshot.f(), pendingMessageSnapshot.g());
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public long f() {
            return this.f17235u;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public long g() {
            return this.f17236v;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte o() {
            return (byte) 1;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f17235u);
            parcel.writeLong(this.f17236v);
        }

        PendingMessageSnapshot(int i2, long j2, long j3) {
            super(i2);
            this.f17235u = j2;
            this.f17236v = j3;
        }

        PendingMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f17235u = parcel.readLong();
            this.f17236v = parcel.readLong();
        }
    }

    public static class WarnFlowDirectlySnapshot extends WarnMessageSnapshot implements a {
        WarnFlowDirectlySnapshot(int i2, long j2, long j3) {
            super(i2, j2, j3);
        }
    }

    public static class WarnMessageSnapshot extends PendingMessageSnapshot implements MessageSnapshot.b {
        WarnMessageSnapshot(int i2, long j2, long j3) {
            super(i2, j2, j3);
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot.b
        public MessageSnapshot a() {
            return new PendingMessageSnapshot(this);
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte o() {
            return (byte) -4;
        }

        WarnMessageSnapshot(Parcel parcel) {
            super(parcel);
        }
    }

    LargeMessageSnapshot(int i2) {
        super(i2);
        this.f17240t = true;
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshot
    public int i() {
        if (f() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) f();
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshot
    public int n() {
        if (g() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) g();
    }

    public static class ProgressMessageSnapshot extends LargeMessageSnapshot {

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final long f17237u;

        ProgressMessageSnapshot(int i2, long j2) {
            super(i2);
            this.f17237u = j2;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public long f() {
            return this.f17237u;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte o() {
            return (byte) 3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f17237u);
        }

        ProgressMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f17237u = parcel.readLong();
        }
    }

    public static class RetryMessageSnapshot extends ErrorMessageSnapshot {

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final int f17238w;

        RetryMessageSnapshot(int i2, long j2, Throwable th, int i3) {
            super(i2, j2, th);
            this.f17238w = i3;
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int h() {
            return this.f17238w;
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte o() {
            return (byte) 5;
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f17238w);
        }

        RetryMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f17238w = parcel.readInt();
        }
    }

    public static class CompletedSnapshot extends LargeMessageSnapshot {

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final boolean f17227u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final long f17228v;

        CompletedSnapshot(int i2, boolean z2, long j2) {
            super(i2);
            this.f17227u = z2;
            this.f17228v = j2;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public long g() {
            return this.f17228v;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte o() {
            return (byte) -3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public boolean s() {
            return this.f17227u;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f17227u ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f17228v);
        }

        CompletedSnapshot(Parcel parcel) {
            super(parcel);
            this.f17227u = parcel.readByte() != 0;
            this.f17228v = parcel.readLong();
        }
    }

    public static class ErrorMessageSnapshot extends LargeMessageSnapshot {

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final long f17233u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final Throwable f17234v;

        ErrorMessageSnapshot(int i2, long j2, Throwable th) {
            super(i2);
            this.f17233u = j2;
            this.f17234v = th;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public long f() {
            return this.f17233u;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte o() {
            return (byte) -1;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public Throwable p() {
            return this.f17234v;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f17233u);
            parcel.writeSerializable(this.f17234v);
        }

        ErrorMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f17233u = parcel.readLong();
            this.f17234v = (Throwable) parcel.readSerializable();
        }
    }

    LargeMessageSnapshot(Parcel parcel) {
        super(parcel);
    }

    public static class ConnectedMessageSnapshot extends LargeMessageSnapshot {

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final boolean f17229u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final long f17230v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final String f17231w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final String f17232x;

        ConnectedMessageSnapshot(int i2, boolean z2, long j2, String str, String str2) {
            super(i2);
            this.f17229u = z2;
            this.f17230v = j2;
            this.f17231w = str;
            this.f17232x = str2;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public String c() {
            return this.f17231w;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public String d() {
            return this.f17232x;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public long g() {
            return this.f17230v;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte o() {
            return (byte) 2;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public boolean r() {
            return this.f17229u;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f17229u ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f17230v);
            parcel.writeString(this.f17231w);
            parcel.writeString(this.f17232x);
        }

        ConnectedMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f17229u = parcel.readByte() != 0;
            this.f17230v = parcel.readLong();
            this.f17231w = parcel.readString();
            this.f17232x = parcel.readString();
        }
    }
}
