package com.kwai.filedownloader.message;

import android.os.Parcel;
import com.kwai.filedownloader.message.MessageSnapshot;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h extends MessageSnapshot {

    public static class a extends b implements com.kwai.filedownloader.message.b {
        a(int i2, boolean z2, int i3) {
            super(i2, true, i3);
        }
    }

    public static class b extends h {
        private final boolean aGT;
        private final int aHi;

        b(int i2, boolean z2, int i3) {
            super(i2);
            this.aGT = z2;
            this.aHi = i3;
        }

        b(Parcel parcel) {
            super(parcel);
            this.aGT = parcel.readByte() != 0;
            this.aHi = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.c
        public final byte Ge() {
            return (byte) -3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final int Id() {
            return this.aHi;
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
            parcel.writeInt(this.aHi);
        }
    }

    public static class c extends h {
        private final String aFr;
        private final boolean aGU;
        private final String aGV;
        private final int aHi;

        c(int i2, boolean z2, int i3, String str, String str2) {
            super(i2);
            this.aGU = z2;
            this.aHi = i3;
            this.aFr = str;
            this.aGV = str2;
        }

        c(Parcel parcel) {
            super(parcel);
            this.aGU = parcel.readByte() != 0;
            this.aHi = parcel.readInt();
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
        public final int Id() {
            return this.aHi;
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
            parcel.writeInt(this.aHi);
            parcel.writeString(this.aFr);
            parcel.writeString(this.aGV);
        }
    }

    public static class d extends h {
        private final Throwable aGX;
        private final int aHj;

        d(int i2, int i3, Throwable th) {
            super(i2);
            this.aHj = i3;
            this.aGX = th;
        }

        d(Parcel parcel) {
            super(parcel);
            this.aHj = parcel.readInt();
            this.aGX = (Throwable) parcel.readSerializable();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte Ge() {
            return (byte) -1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final int Ic() {
            return this.aHj;
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
            parcel.writeInt(this.aHj);
            parcel.writeSerializable(this.aGX);
        }
    }

    public static class e extends f {
        e(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }

        @Override // com.kwai.filedownloader.message.h.f, com.kwai.filedownloader.message.c
        public final byte Ge() {
            return (byte) -2;
        }
    }

    public static class f extends h {
        private final int aHi;
        private final int aHj;

        f(int i2, int i3, int i4) {
            super(i2);
            this.aHj = i3;
            this.aHi = i4;
        }

        f(Parcel parcel) {
            super(parcel);
            this.aHj = parcel.readInt();
            this.aHi = parcel.readInt();
        }

        f(f fVar) {
            this(fVar.getId(), fVar.Ic(), fVar.Id());
        }

        public byte Ge() {
            return (byte) 1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final int Ic() {
            return this.aHj;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final int Id() {
            return this.aHi;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.aHj);
            parcel.writeInt(this.aHi);
        }
    }

    public static class g extends h {
        private final int aHj;

        g(int i2, int i3) {
            super(i2);
            this.aHj = i3;
        }

        g(Parcel parcel) {
            super(parcel);
            this.aHj = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.c
        public final byte Ge() {
            return (byte) 3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final int Ic() {
            return this.aHj;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.aHj);
        }
    }

    /* JADX INFO: renamed from: com.kwai.filedownloader.message.h$h, reason: collision with other inner class name */
    public static class C0470h extends d {
        private final int aGC;

        C0470h(int i2, int i3, Throwable th, int i4) {
            super(i2, i3, th);
            this.aGC = i4;
        }

        C0470h(Parcel parcel) {
            super(parcel);
            this.aGC = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.h.d, com.kwai.filedownloader.message.c
        public final byte Ge() {
            return (byte) 5;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final int Gi() {
            return this.aGC;
        }

        @Override // com.kwai.filedownloader.message.h.d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.h.d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.aGC);
        }
    }

    public static class i extends j implements com.kwai.filedownloader.message.b {
        i(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }
    }

    public static class j extends f implements MessageSnapshot.a {
        j(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }

        j(Parcel parcel) {
            super(parcel);
        }

        @Override // com.kwai.filedownloader.message.h.f, com.kwai.filedownloader.message.c
        public final byte Ge() {
            return (byte) -4;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot.a
        public final MessageSnapshot Ii() {
            return new f(this);
        }
    }

    h(int i2) {
        super(i2);
        this.aGY = false;
    }

    h(Parcel parcel) {
        super(parcel);
    }

    @Override // com.kwai.filedownloader.message.MessageSnapshot
    public final long Ie() {
        return Id();
    }

    @Override // com.kwai.filedownloader.message.MessageSnapshot
    public final long Ig() {
        return Ic();
    }
}
