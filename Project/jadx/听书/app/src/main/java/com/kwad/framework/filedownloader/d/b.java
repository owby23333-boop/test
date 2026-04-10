package com.kwad.framework.filedownloader.d;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.sdk.utils.ax;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.kwad.framework.filedownloader.d.b.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b createFromParcel(Parcel parcel) {
            return b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b[] newArray(int i) {
            return bV(i);
        }

        private static b b(Parcel parcel) {
            return new b(parcel);
        }

        private static b[] bV(int i) {
            return new b[i];
        }
    };
    private HashMap<String, List<String>> aoV;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void y(String str, String str2) {
        ax.hh(str);
        ax.hh(str2);
        if (this.aoV == null) {
            this.aoV = new HashMap<>();
        }
        List<String> arrayList = this.aoV.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.aoV.put(str, arrayList);
        }
        if (arrayList.contains(str2)) {
            return;
        }
        arrayList.add(str2);
    }

    public final void bw(String str) {
        HashMap<String, List<String>> map = this.aoV;
        if (map == null) {
            return;
        }
        map.remove(str);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.aoV);
    }

    public final HashMap<String, List<String>> yY() {
        return this.aoV;
    }

    public b() {
    }

    protected b(Parcel parcel) {
        this.aoV = parcel.readHashMap(String.class.getClassLoader());
    }

    public final String toString() {
        return this.aoV.toString();
    }
}
