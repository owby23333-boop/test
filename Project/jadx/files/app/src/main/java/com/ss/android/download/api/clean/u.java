package com.ss.android.download.api.clean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class u extends h implements Parcelable {
    public static final Parcelable.Creator<u> CREATOR = new Parcelable.Creator<u>() { // from class: com.ss.android.download.api.clean.u.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
        public u createFromParcel(Parcel parcel) {
            return new u(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
        public u[] newArray(int i2) {
            return new u[i2];
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<h> f17930h;
    private boolean ko;
    private String mb;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Map<String, h> f17931u;

    public u() {
        this.f17930h = new ArrayList();
        this.f17931u = new HashMap();
    }

    @Override // com.ss.android.download.api.clean.h, com.ss.android.download.api.clean.b, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ss.android.download.api.clean.h
    public String mb() {
        return "clean_folder";
    }

    @Override // com.ss.android.download.api.clean.h, com.ss.android.download.api.clean.b, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.mb);
        parcel.writeInt(this.ko ? 1 : 0);
        parcel.writeInt(this.f17931u.size());
        for (Map.Entry<String, h> entry : this.f17931u.entrySet()) {
            String key = entry.getKey();
            h value = entry.getValue();
            parcel.writeString(key);
            parcel.writeString(value.mb());
            parcel.writeParcelable(value, 0);
        }
    }

    u(Parcel parcel) {
        Parcelable parcelable;
        super(parcel);
        this.f17930h = new ArrayList();
        this.f17931u = new HashMap();
        this.mb = parcel.readString();
        this.ko = parcel.readInt() == 1;
        int i2 = parcel.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            String string = parcel.readString();
            String string2 = parcel.readString();
            if ("apk_clean_file".equals(string2)) {
                parcelable = parcel.readParcelable(mb.class.getClassLoader());
            } else if ("clean_app_cache".equals(string2)) {
                parcelable = parcel.readParcelable(hj.class.getClassLoader());
            } else if ("clean_folder".equals(string2)) {
                parcelable = parcel.readParcelable(u.class.getClassLoader());
            } else {
                parcelable = parcel.readParcelable(h.class.getClassLoader());
            }
            this.f17931u.put(string, (h) parcelable);
        }
    }
}
