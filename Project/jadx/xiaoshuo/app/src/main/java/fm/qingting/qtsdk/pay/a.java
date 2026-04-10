package fm.qingting.qtsdk.pay;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import fm.qingting.qtsdk.auth.IQTAuthResponse;

/* JADX INFO: loaded from: classes8.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0798a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f21094a = "fm.qingting.qtsdk.pay.a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    IQTAuthResponse f21095b;

    /* JADX INFO: renamed from: fm.qingting.qtsdk.pay.a$a, reason: collision with other inner class name */
    public class C0798a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel in) {
            return new a(in);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int size) {
            return new a[size];
        }
    }

    public a(Parcel in) {
        this.f21095b = IQTAuthResponse.Stub.a(in.readStrongBinder());
    }

    public void a() {
        String str;
        String str2;
        IQTAuthResponse iQTAuthResponse = this.f21095b;
        if (iQTAuthResponse != null) {
            try {
                iQTAuthResponse.onCancel();
            } catch (RemoteException e) {
                e = e;
                str = f21094a;
                str2 = "RemoteException";
                Log.e(str, str2, e);
            } catch (RuntimeException e2) {
                e = e2;
                str = f21094a;
                str2 = "RuntimeException";
                Log.e(str, str2, e);
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongBinder(this.f21095b.asBinder());
    }

    public a(IQTAuthResponse response) {
        this.f21095b = response;
    }

    public void a(String code) {
        String str;
        String str2;
        Bundle bundle = new Bundle();
        bundle.putString("code", code);
        try {
            this.f21095b.a(bundle);
        } catch (RemoteException e) {
            e = e;
            str = f21094a;
            str2 = "RemoteException";
            Log.e(str, str2, e);
        } catch (RuntimeException e2) {
            e = e2;
            str = f21094a;
            str2 = "RuntimeException";
            Log.e(str, str2, e);
        }
    }
}
