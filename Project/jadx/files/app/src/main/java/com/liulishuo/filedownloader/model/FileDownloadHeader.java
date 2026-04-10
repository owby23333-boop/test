package com.liulishuo.filedownloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FileDownloadHeader implements Parcelable {
    public static final Parcelable.Creator<FileDownloadHeader> CREATOR = new a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private HashMap<String, List<String>> f17256s;

    static class a implements Parcelable.Creator<FileDownloadHeader> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileDownloadHeader createFromParcel(Parcel parcel) {
            return new FileDownloadHeader(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileDownloadHeader[] newArray(int i2) {
            return new FileDownloadHeader[i2];
        }
    }

    public FileDownloadHeader() {
    }

    public HashMap<String, List<String>> a() {
        return this.f17256s;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f17256s.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeMap(this.f17256s);
    }

    protected FileDownloadHeader(Parcel parcel) {
        this.f17256s = parcel.readHashMap(String.class.getClassLoader());
    }
}
