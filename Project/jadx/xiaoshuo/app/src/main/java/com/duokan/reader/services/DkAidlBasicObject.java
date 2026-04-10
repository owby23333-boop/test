package com.duokan.reader.services;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.ParcelableMMKV;

/* JADX INFO: loaded from: classes4.dex */
public class DkAidlBasicObject<T extends Parcelable> implements Parcelable {
    public static final Parcelable.Creator<DkAidlBasicObject> CREATOR = new a();
    public static int e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Parcelable f5221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5222b;
    public ParcelableMMKV c;
    public MMKV d;

    public class a implements Parcelable.Creator<DkAidlBasicObject> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DkAidlBasicObject createFromParcel(Parcel parcel) {
            return new DkAidlBasicObject(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DkAidlBasicObject[] newArray(int i) {
            return new DkAidlBasicObject[i];
        }
    }

    public void a(T t) {
        this.f5221a = t;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5222b);
        if (this.f5221a != null) {
            Parcel parcelObtain = Parcel.obtain();
            try {
                this.f5221a.writeToParcel(parcelObtain, i);
                this.d.encode(this.f5222b, parcelObtain.marshall());
                parcelObtain.recycle();
                parcel.writeString(this.f5221a.getClass().getName());
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
        }
        parcel.writeParcelable(this.c, 0);
    }

    public DkAidlBasicObject(MMKV mmkv) {
        this.d = mmkv;
        this.c = new ParcelableMMKV(mmkv);
        e++;
        this.f5222b = String.valueOf(System.currentTimeMillis()) + "_" + e;
    }

    public <T extends Parcelable> DkAidlBasicObject(Parcel parcel) {
        this.f5222b = parcel.readString();
        Parcel parcelObtain = Parcel.obtain();
        try {
            String string = parcel.readString();
            ParcelableMMKV parcelableMMKV = (ParcelableMMKV) parcel.readParcelable(ParcelableMMKV.class.getClassLoader());
            this.c = parcelableMMKV;
            byte[] bArrDecodeBytes = parcelableMMKV.toMMKV().decodeBytes(this.f5222b);
            parcelObtain.unmarshall(bArrDecodeBytes, 0, bArrDecodeBytes.length);
            parcelObtain.setDataPosition(0);
            this.f5221a = (Parcelable) ((Parcelable.Creator) Class.forName(string).getField("CREATOR").get(null)).createFromParcel(parcelObtain);
        } catch (Exception unused) {
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
        parcelObtain.recycle();
    }
}
