package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d extends MessageSnapshot {
    d(int i2) {
        super(i2);
        this.aoJ = true;
    }

    d(Parcel parcel) {
        super(parcel);
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final int yM() {
        if (yQ() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) yQ();
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final int yN() {
        if (yO() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) yO();
    }

    public static class f extends d {
        private final long aoH;
        private final long totalBytes;

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public byte wJ() {
            return (byte) 1;
        }

        f(f fVar) {
            this(fVar.getId(), fVar.yQ(), fVar.yO());
        }

        f(int i, long j, long j2) {
            super(i);
            this.aoH = j;
            this.totalBytes = j2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long yQ() {
            return this.aoH;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long yO() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.aoH);
            parcel.writeLong(this.totalBytes);
        }

        f(Parcel parcel) {
            super(parcel);
            this.aoH = parcel.readLong();
            this.totalBytes = parcel.readLong();
        }
    }

    public static class c extends d {
        private final String anc;
        private final boolean aoG;
        private final String fileName;
        private final long totalBytes;

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) 2;
        }

        c(int i, boolean z, long j, String str, String str2) {
            super(i);
            this.aoG = z;
            this.totalBytes = j;
            this.anc = str;
            this.fileName = str2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.aoG ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
            parcel.writeString(this.anc);
            parcel.writeString(this.fileName);
        }

        c(Parcel parcel) {
            super(parcel);
            this.aoG = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
            this.anc = parcel.readString();
            this.fileName = parcel.readString();
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getFileName() {
            return this.fileName;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean yE() {
            return this.aoG;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long yO() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getEtag() {
            return this.anc;
        }
    }

    public static class g extends d {
        private final long aoH;

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) 3;
        }

        g(int i, long j) {
            super(i);
            this.aoH = j;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long yQ() {
            return this.aoH;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.aoH);
        }

        g(Parcel parcel) {
            super(parcel);
            this.aoH = parcel.readLong();
        }
    }

    public static class a extends b implements com.kwad.framework.filedownloader.message.b {
        a(int i, boolean z, long j) {
            super(i, true, j);
        }
    }

    public static class b extends d {
        private final boolean aoF;
        private final long totalBytes;

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) -3;
        }

        b(int i, boolean z, long j) {
            super(i);
            this.aoF = z;
            this.totalBytes = j;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.aoF ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
        }

        b(Parcel parcel) {
            super(parcel);
            this.aoF = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long yO() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean yP() {
            return this.aoF;
        }
    }

    /* JADX INFO: renamed from: com.kwad.framework.filedownloader.message.d$d, reason: collision with other inner class name */
    public static class C0378d extends d {
        private final long aoH;
        private final Throwable aoI;

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public byte wJ() {
            return (byte) -1;
        }

        C0378d(int i, long j, Throwable th) {
            super(i);
            this.aoH = j;
            this.aoI = th;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long yQ() {
            return this.aoH;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final Throwable yR() {
            return this.aoI;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.aoH);
            parcel.writeSerializable(this.aoI);
        }

        C0378d(Parcel parcel) {
            super(parcel);
            this.aoH = parcel.readLong();
            this.aoI = (Throwable) parcel.readSerializable();
        }
    }

    public static class h extends C0378d {
        private final int aon;

        @Override // com.kwad.framework.filedownloader.message.d.C0378d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C0378d, com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) 5;
        }

        h(int i, long j, Throwable th, int i2) {
            super(i, j, th);
            this.aon = i2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int wN() {
            return this.aon;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C0378d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aon);
        }

        h(Parcel parcel) {
            super(parcel);
            this.aon = parcel.readInt();
        }
    }

    public static class i extends j implements com.kwad.framework.filedownloader.message.b {
        i(int i, long j, long j2) {
            super(i, j, j2);
        }
    }

    public static class j extends f implements MessageSnapshot.a {
        @Override // com.kwad.framework.filedownloader.message.d.f, com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) -4;
        }

        j(int i, long j, long j2) {
            super(i, j, j2);
        }

        j(Parcel parcel) {
            super(parcel);
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot.a
        public final MessageSnapshot yS() {
            return new f(this);
        }
    }

    public static class e extends f {
        @Override // com.kwad.framework.filedownloader.message.d.f, com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) -2;
        }

        e(int i, long j, long j2) {
            super(i, j, j2);
        }
    }
}
