package com.kwai.filedownloader.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.sdk.utils.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.kwai.filedownloader.c.b.1
        private static b b(Parcel parcel) {
            return new b(parcel);
        }

        private static b[] cV(int i2) {
            return new b[i2];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b createFromParcel(Parcel parcel) {
            return b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b[] newArray(int i2) {
            return cV(i2);
        }
    };
    private HashMap<String, List<String>> aHk;

    public b() {
    }

    protected b(Parcel parcel) {
        this.aHk = parcel.readHashMap(String.class.getClassLoader());
    }

    public final HashMap<String, List<String>> Io() {
        return this.aHk;
    }

    public final void aj(String str, String str2) {
        an.et(str);
        an.et(str2);
        if (this.aHk == null) {
            this.aHk = new HashMap<>();
        }
        List<String> arrayList = this.aHk.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.aHk.put(str, arrayList);
        }
        if (arrayList.contains(str2)) {
            return;
        }
        arrayList.add(str2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void fd(String str) {
        HashMap<String, List<String>> map = this.aHk;
        if (map == null) {
            return;
        }
        map.remove(str);
    }

    public final String toString() {
        return this.aHk.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeMap(this.aHk);
    }
}
