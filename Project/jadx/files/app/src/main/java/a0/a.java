package a0;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;

/* JADX INFO: compiled from: ParcelableUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static String a(Parcelable parcelable) {
        Parcel parcelObtain = Parcel.obtain();
        parcelable.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return Base64.encodeToString(bArrMarshall, 0);
    }

    public static String[] a(Parcelable[] parcelableArr) {
        String[] strArr = new String[parcelableArr.length];
        for (int i2 = 0; i2 < parcelableArr.length; i2++) {
            Parcelable parcelable = parcelableArr[i2];
            Parcel parcelObtain = Parcel.obtain();
            parcelable.writeToParcel(parcelObtain, 0);
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
            strArr[i2] = Base64.encodeToString(bArrMarshall, 0);
        }
        return strArr;
    }
}
