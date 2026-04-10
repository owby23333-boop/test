package com.kwai.filedownloader.message;

import android.os.Parcel;
import com.kwai.filedownloader.message.MessageSnapshot;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends MessageSnapshot {

    public static class a extends b implements com.kwai.filedownloader.message.b {
        a(int i2, boolean z2, long j2) {
            super(i2, true, j2);
        }
    }

    public static class b extends d {
        private final boolean aGT;
        private final long totalBytes;

        b(int i2, boolean z2, long j2) {
            super(i2);
            this.aGT = z2;
            this.totalBytes = j2;
        }

        b(Parcel parcel) {
            super(parcel);
            this.aGT = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
        }

        @Override // com.kwai.filedownloader.message.c
        public final byte Ge() {
            return (byte) -3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final long Ie() {
            return this.totalBytes;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final boolean If() {
            return this.aGT;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.aGT ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
        }
    }

    public static class c extends d {
        private final String aFr;
        private final boolean aGU;
        private final String aGV;
        private final long totalBytes;

        c(int i2, boolean z2, long j2, String str, String str2) {
            super(i2);
            this.aGU = z2;
            this.totalBytes = j2;
            this.aFr = str;
            this.aGV = str2;
        }

        c(Parcel parcel) {
            super(parcel);
            this.aGU = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
            this.aFr = parcel.readString();
            this.aGV = parcel.readString();
        }

        @Override // com.kwai.filedownloader.message.c
        public final byte Ge() {
            return (byte) 2;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final boolean HU() {
            return this.aGU;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final long Ie() {
            return this.totalBytes;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final String getEtag() {
            return this.aFr;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final String getFileName() {
            return this.aGV;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.aGU ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
            parcel.writeString(this.aFr);
            parcel.writeString(this.aGV);
        }
    }

    /* JADX INFO: renamed from: com.kwai.filedownloader.message.d$d, reason: collision with other inner class name */
    public static class C0469d extends d {
        private final long aGW;
        private final Throwable aGX;

        C0469d(int i2, long j2, Throwable th) {
            super(i2);
            this.aGW = j2;
            this.aGX = th;
        }

        C0469d(Parcel parcel) {
            super(parcel);
            this.aGW = parcel.readLong();
            this.aGX = (Throwable) parcel.readSerializable();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte Ge() {
            return (byte) -1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final long Ig() {
            return this.aGW;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final Throwable Ih() {
            return this.aGX;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.aGW);
            parcel.writeSerializable(this.aGX);
        }
    }

    public static class e extends f {
        e(int i2, long j2, long j3) {
            super(i2, j2, j3);
        }

        @Override // com.kwai.filedownloader.message.d.f, com.kwai.filedownloader.message.c
        public final byte Ge() {
            return (byte) -2;
        }
    }

    public static class f extends d {
        private final long aGW;
        private final long totalBytes;

        f(int i2, long j2, long j3) {
            super(i2);
            this.aGW = j2;
            this.totalBytes = j3;
        }

        f(Parcel parcel) {
            super(parcel);
            this.aGW = parcel.readLong();
            this.totalBytes = parcel.readLong();
        }

        f(f fVar) {
            this(fVar.getId(), fVar.Ig(), fVar.Ie());
        }

        public byte Ge() {
            return (byte) 1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final long Ie() {
            return this.totalBytes;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final long Ig() {
            return this.aGW;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.aGW);
            parcel.writeLong(this.totalBytes);
        }
    }

    public static class g extends d {
        private final long aGW;

        g(int i2, long j2) {
            super(i2);
            this.aGW = j2;
        }

        g(Parcel parcel) {
            super(parcel);
            this.aGW = parcel.readLong();
        }

        @Override // com.kwai.filedownloader.message.c
        public final byte Ge() {
            return (byte) 3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final long Ig() {
            return this.aGW;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.aGW);
        }
    }

    public static class h extends C0469d {
        private final int aGC;

        h(int i2, long j2, Throwable th, int i3) {
            super(i2, j2, th);
            this.aGC = i3;
        }

        h(Parcel parcel) {
            super(parcel);
            this.aGC = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.d.C0469d, com.kwai.filedownloader.message.c
        public final byte Ge() {
            return (byte) 5;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final int Gi() {
            return this.aGC;
        }

        @Override // com.kwai.filedownloader.message.d.C0469d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.d.C0469d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.aGC);
        }
    }

    public static class i extends j implements com.kwai.filedownloader.message.b {
        i(int i2, long j2, long j3) {
            super(i2, j2, j3);
        }
    }

    public static class j extends f implements MessageSnapshot.a {
        j(int i2, long j2, long j3) {
            super(i2, j2, j3);
        }

        j(Parcel parcel) {
            super(parcel);
        }

        @Override // com.kwai.filedownloader.message.d.f, com.kwai.filedownloader.message.c
        public final byte Ge() {
            return (byte) -4;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot.a
        public final MessageSnapshot Ii() {
            return new f(this);
        }
    }

    d(int i2) {
        super(i2);
        this.aGY = true;
    }

    d(Parcel parcel) {
        super(parcel);
    }

    @Override // com.kwai.filedownloader.message.MessageSnapshot
    public final int Ic() {
        if (Ig() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) Ig();
    }

    @Override // com.kwai.filedownloader.message.MessageSnapshot
    public final int Id() {
        if (Ie() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) Ie();
    }
}
