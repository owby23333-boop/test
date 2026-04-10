package com.liulishuo.filedownloader.message;

import android.os.Parcel;
import com.liulishuo.filedownloader.message.MessageSnapshot;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SmallMessageSnapshot extends MessageSnapshot {

    public static class CompletedFlowDirectlySnapshot extends CompletedSnapshot implements a {
        CompletedFlowDirectlySnapshot(int i2, boolean z2, int i3) {
            super(i2, z2, i3);
        }
    }

    public static class PausedSnapshot extends PendingMessageSnapshot {
        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte o() {
            return (byte) -2;
        }
    }

    public static class PendingMessageSnapshot extends SmallMessageSnapshot {

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final int f17249u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final int f17250v;

        PendingMessageSnapshot(PendingMessageSnapshot pendingMessageSnapshot) {
            this(pendingMessageSnapshot.e(), pendingMessageSnapshot.i(), pendingMessageSnapshot.n());
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int i() {
            return this.f17249u;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int n() {
            return this.f17250v;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte o() {
            return (byte) 1;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f17249u);
            parcel.writeInt(this.f17250v);
        }

        PendingMessageSnapshot(int i2, int i3, int i4) {
            super(i2);
            this.f17249u = i3;
            this.f17250v = i4;
        }

        PendingMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f17249u = parcel.readInt();
            this.f17250v = parcel.readInt();
        }
    }

    public static class WarnFlowDirectlySnapshot extends WarnMessageSnapshot implements a {
        WarnFlowDirectlySnapshot(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }
    }

    public static class WarnMessageSnapshot extends PendingMessageSnapshot implements MessageSnapshot.b {
        WarnMessageSnapshot(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot.b
        public MessageSnapshot a() {
            return new PendingMessageSnapshot(this);
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte o() {
            return (byte) -4;
        }

        WarnMessageSnapshot(Parcel parcel) {
            super(parcel);
        }
    }

    SmallMessageSnapshot(int i2) {
        super(i2);
        this.f17240t = false;
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshot
    public long f() {
        return i();
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshot
    public long g() {
        return n();
    }

    public static class ProgressMessageSnapshot extends SmallMessageSnapshot {

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final int f17251u;

        ProgressMessageSnapshot(int i2, int i3) {
            super(i2);
            this.f17251u = i3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int i() {
            return this.f17251u;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte o() {
            return (byte) 3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f17251u);
        }

        ProgressMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f17251u = parcel.readInt();
        }
    }

    public static class RetryMessageSnapshot extends ErrorMessageSnapshot {

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final int f17252w;

        RetryMessageSnapshot(int i2, int i3, Throwable th, int i4) {
            super(i2, i3, th);
            this.f17252w = i4;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int h() {
            return this.f17252w;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte o() {
            return (byte) 5;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f17252w);
        }

        RetryMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f17252w = parcel.readInt();
        }
    }

    public static class CompletedSnapshot extends SmallMessageSnapshot {

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final boolean f17241u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final int f17242v;

        CompletedSnapshot(int i2, boolean z2, int i3) {
            super(i2);
            this.f17241u = z2;
            this.f17242v = i3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int n() {
            return this.f17242v;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte o() {
            return (byte) -3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public boolean s() {
            return this.f17241u;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f17241u ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f17242v);
        }

        CompletedSnapshot(Parcel parcel) {
            super(parcel);
            this.f17241u = parcel.readByte() != 0;
            this.f17242v = parcel.readInt();
        }
    }

    public static class ErrorMessageSnapshot extends SmallMessageSnapshot {

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final int f17247u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final Throwable f17248v;

        ErrorMessageSnapshot(int i2, int i3, Throwable th) {
            super(i2);
            this.f17247u = i3;
            this.f17248v = th;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int i() {
            return this.f17247u;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte o() {
            return (byte) -1;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public Throwable p() {
            return this.f17248v;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f17247u);
            parcel.writeSerializable(this.f17248v);
        }

        ErrorMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f17247u = parcel.readInt();
            this.f17248v = (Throwable) parcel.readSerializable();
        }
    }

    SmallMessageSnapshot(Parcel parcel) {
        super(parcel);
    }

    public static class ConnectedMessageSnapshot extends SmallMessageSnapshot {

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final boolean f17243u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final int f17244v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final String f17245w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final String f17246x;

        ConnectedMessageSnapshot(int i2, boolean z2, int i3, String str, String str2) {
            super(i2);
            this.f17243u = z2;
            this.f17244v = i3;
            this.f17245w = str;
            this.f17246x = str2;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public String c() {
            return this.f17245w;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public String d() {
            return this.f17246x;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int n() {
            return this.f17244v;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte o() {
            return (byte) 2;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public boolean r() {
            return this.f17243u;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f17243u ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f17244v);
            parcel.writeString(this.f17245w);
            parcel.writeString(this.f17246x);
        }

        ConnectedMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f17243u = parcel.readByte() != 0;
            this.f17244v = parcel.readInt();
            this.f17245w = parcel.readString();
            this.f17246x = parcel.readString();
        }
    }
}
