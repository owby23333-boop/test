package com.liulishuo.filedownloader.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class FileDownloadTaskAtom implements Parcelable {
    public static final Parcelable.Creator<FileDownloadTaskAtom> CREATOR = new a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f17265s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f17266t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f17267u;

    static class a implements Parcelable.Creator<FileDownloadTaskAtom> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileDownloadTaskAtom createFromParcel(Parcel parcel) {
            return new FileDownloadTaskAtom(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileDownloadTaskAtom[] newArray(int i2) {
            return new FileDownloadTaskAtom[i2];
        }
    }

    protected FileDownloadTaskAtom(Parcel parcel) {
        this.f17265s = parcel.readString();
        this.f17266t = parcel.readString();
        this.f17267u = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f17265s);
        parcel.writeString(this.f17266t);
        parcel.writeLong(this.f17267u);
    }
}
