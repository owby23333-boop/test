package com.ss.android.download.api.clean;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CleanType extends ox implements Parcelable {
    public static final Parcelable.Creator<CleanType> CREATOR = new Parcelable.Creator<CleanType>() { // from class: com.ss.android.download.api.clean.CleanType.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
        public CleanType createFromParcel(Parcel parcel) {
            return new CleanType(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
        public CleanType[] newArray(int i2) {
            return new CleanType[i2];
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f17925h;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Map<String, hj> f17926u;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
        public static final int APK = -1;
        public static final int CACHE = -3;
        public static final int LOG = -2;
        public static final int OTHERS = -5;
        public static final int REMAIN = -4;
    }

    public CleanType() {
        this.f17926u = new HashMap();
    }

    public int getType() {
        return this.f17925h;
    }

    @Override // com.ss.android.download.api.clean.ox, com.ss.android.download.api.clean.u, com.ss.android.download.api.clean.h, com.ss.android.download.api.clean.b, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.f17925h);
        parcel.writeInt(this.f17926u.size());
        for (Map.Entry<String, hj> entry : this.f17926u.entrySet()) {
            try {
                String key = entry.getKey();
                hj value = entry.getValue();
                parcel.writeString(key);
                parcel.writeParcelable(value, 0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    CleanType(Parcel parcel) {
        super(parcel);
        this.f17926u = new HashMap();
        this.f17925h = parcel.readInt();
        int i2 = parcel.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            this.f17926u.put(parcel.readString(), (hj) parcel.readParcelable(hj.class.getClassLoader()));
        }
    }
}
