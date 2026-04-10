package com.duokan.reader.services;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.ParcelableMMKV;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DkAidlBasicListObject<T extends Parcelable> implements Parcelable {
    public static final Parcelable.Creator<DkAidlBasicListObject> CREATOR = new a();
    public static int f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<T> f5219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5220b;
    public String c;
    public List<ParcelableMMKV> d;
    public MMKV e;

    public class a implements Parcelable.Creator<DkAidlBasicListObject> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DkAidlBasicListObject createFromParcel(Parcel parcel) {
            return new DkAidlBasicListObject(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DkAidlBasicListObject[] newArray(int i) {
            return new DkAidlBasicListObject[i];
        }
    }

    public List<T> a() {
        return this.f5219a;
    }

    public void b(List<T> list, String str) {
        this.f5219a = list;
        this.c = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5220b);
        List<T> list = this.f5219a;
        if (list != null && list.size() > 0) {
            Parcel parcelObtain = Parcel.obtain();
            try {
                parcelObtain.writeTypedList(this.f5219a);
                this.e.encode(this.f5220b, parcelObtain.marshall());
                parcelObtain.recycle();
                parcel.writeString(this.c);
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
        }
        parcel.writeParcelable(new ParcelableMMKV(this.e), 0);
    }

    public DkAidlBasicListObject(MMKV mmkv) {
        this.f5219a = new LinkedList();
        this.e = mmkv;
        f++;
        this.f5220b = String.valueOf(System.currentTimeMillis()) + "_" + f;
    }

    public DkAidlBasicListObject(Parcel parcel) {
        this.f5219a = new LinkedList();
        this.f5220b = parcel.readString();
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.c = parcel.readString();
            MMKV mmkv = ((ParcelableMMKV) parcel.readParcelable(ParcelableMMKV.class.getClassLoader())).toMMKV();
            byte[] bArrDecodeBytes = mmkv.decodeBytes(this.f5220b);
            parcelObtain.unmarshall(bArrDecodeBytes, 0, bArrDecodeBytes.length);
            parcelObtain.setDataPosition(0);
            LinkedList linkedListCreateTypedArrayList = parcelObtain.createTypedArrayList((Parcelable.Creator) Class.forName(this.c).getField("CREATOR").get(null));
            if (linkedListCreateTypedArrayList == null || linkedListCreateTypedArrayList.size() <= 0) {
                linkedListCreateTypedArrayList = new LinkedList();
            }
            this.f5219a = linkedListCreateTypedArrayList;
            mmkv.remove(this.f5220b);
        } catch (Exception unused) {
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
        parcelObtain.recycle();
    }
}
