package com.ss.android.download.api.clean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ox extends u implements Parcelable {
    public static final Parcelable.Creator<ox> CREATOR = new Parcelable.Creator<ox>() { // from class: com.ss.android.download.api.clean.ox.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
        public ox createFromParcel(Parcel parcel) {
            return new ox(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
        public ox[] newArray(int i2) {
            return new ox[i2];
        }
    };
    List<u> mb;

    public ox() {
        this.mb = new ArrayList();
    }

    @Override // com.ss.android.download.api.clean.u, com.ss.android.download.api.clean.h, com.ss.android.download.api.clean.b, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ss.android.download.api.clean.u, com.ss.android.download.api.clean.h, com.ss.android.download.api.clean.b, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        if (this.mb == null) {
            this.mb = new ArrayList();
        }
        parcel.writeInt(this.mb.size());
        Iterator<u> it = this.mb.iterator();
        while (it.hasNext()) {
            parcel.writeParcelable(it.next(), 0);
        }
    }

    ox(Parcel parcel) {
        super(parcel);
        this.mb = new ArrayList();
        int i2 = parcel.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            this.mb.add((u) parcel.readParcelable(u.class.getClassLoader()));
        }
    }
}
