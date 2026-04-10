package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h extends MessageSnapshot {
    h(int i2) {
        super(i2);
        this.aoJ = false;
    }

    h(Parcel parcel) {
        super(parcel);
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final long yO() {
        return yN();
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final long yQ() {
        return yM();
    }

    public static class f extends h {
        private final int aoT;
        private final int aoU;

        public byte wJ() {
            return (byte) 1;
        }

        f(f fVar) {
            this(fVar.getId(), fVar.yM(), fVar.yN());
        }

        f(int i, int i2, int i3) {
            super(i);
            this.aoU = i2;
            this.aoT = i3;
        }

        f(Parcel parcel) {
            super(parcel);
            this.aoU = parcel.readInt();
            this.aoT = parcel.readInt();
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aoU);
            parcel.writeInt(this.aoT);
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int yM() {
            return this.aoU;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int yN() {
            return this.aoT;
        }
    }

    public static class c extends h {
        private final String anc;
        private final boolean aoG;
        private final int aoT;
        private final String fileName;

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) 2;
        }

        c(int i, boolean z, int i2, String str, String str2) {
            super(i);
            this.aoG = z;
            this.aoT = i2;
            this.anc = str;
            this.fileName = str2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.aoG ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.aoT);
            parcel.writeString(this.anc);
            parcel.writeString(this.fileName);
        }

        c(Parcel parcel) {
            super(parcel);
            this.aoG = parcel.readByte() != 0;
            this.aoT = parcel.readInt();
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
        public final int yN() {
            return this.aoT;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getEtag() {
            return this.anc;
        }
    }

    public static class g extends h {
        private final int aoU;

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) 3;
        }

        g(int i, int i2) {
            super(i);
            this.aoU = i2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int yM() {
            return this.aoU;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aoU);
        }

        g(Parcel parcel) {
            super(parcel);
            this.aoU = parcel.readInt();
        }
    }

    public static class a extends b implements com.kwad.framework.filedownloader.message.b {
        a(int i, boolean z, int i2) {
            super(i, true, i2);
        }
    }

    public static class b extends h {
        private final boolean aoF;
        private final int aoT;

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) -3;
        }

        b(int i, boolean z, int i2) {
            super(i);
            this.aoF = z;
            this.aoT = i2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.aoF ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.aoT);
        }

        b(Parcel parcel) {
            super(parcel);
            this.aoF = parcel.readByte() != 0;
            this.aoT = parcel.readInt();
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int yN() {
            return this.aoT;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean yP() {
            return this.aoF;
        }
    }

    public static class d extends h {
        private final Throwable aoI;
        private final int aoU;

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public byte wJ() {
            return (byte) -1;
        }

        d(int i, int i2, Throwable th) {
            super(i);
            this.aoU = i2;
            this.aoI = th;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int yM() {
            return this.aoU;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final Throwable yR() {
            return this.aoI;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aoU);
            parcel.writeSerializable(this.aoI);
        }

        d(Parcel parcel) {
            super(parcel);
            this.aoU = parcel.readInt();
            this.aoI = (Throwable) parcel.readSerializable();
        }
    }

    /* JADX INFO: renamed from: com.kwad.framework.filedownloader.message.h$h, reason: collision with other inner class name */
    public static class C0379h extends d {
        private final int aon;

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) 5;
        }

        C0379h(int i, int i2, Throwable th, int i3) {
            super(i, i2, th);
            this.aon = i3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int wN() {
            return this.aon;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aon);
        }

        C0379h(Parcel parcel) {
            super(parcel);
            this.aon = parcel.readInt();
        }
    }

    public static class i extends j implements com.kwad.framework.filedownloader.message.b {
        i(int i, int i2, int i3) {
            super(i, i2, i3);
        }
    }

    public static class j extends f implements MessageSnapshot.a {
        @Override // com.kwad.framework.filedownloader.message.h.f, com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) -4;
        }

        j(int i, int i2, int i3) {
            super(i, i2, i3);
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
        @Override // com.kwad.framework.filedownloader.message.h.f, com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) -2;
        }

        e(int i, int i2, int i3) {
            super(i, i2, i3);
        }
    }
}
