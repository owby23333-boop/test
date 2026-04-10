package fm.qingting.qtsdk.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import fm.qingting.qtsdk.auth.IQTAuthResponse;

/* JADX INFO: loaded from: classes8.dex */
public class QTAuthResponse implements Parcelable {
    public static final Parcelable.Creator<QTAuthResponse> CREATOR = new Parcelable.Creator<QTAuthResponse>() { // from class: fm.qingting.qtsdk.auth.QTAuthResponse.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public QTAuthResponse createFromParcel(Parcel in) {
            return new QTAuthResponse(in);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public QTAuthResponse[] newArray(int size) {
            return new QTAuthResponse[size];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f21085a = "fm.qingting.qtsdk.auth.QTAuthResponse";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    IQTAuthResponse f21086b;

    public QTAuthResponse(Parcel in) {
        this.f21086b = IQTAuthResponse.Stub.a(in.readStrongBinder());
    }

    public void a() {
        String str;
        String str2;
        IQTAuthResponse iQTAuthResponse = this.f21086b;
        if (iQTAuthResponse != null) {
            try {
                iQTAuthResponse.onCancel();
            } catch (RemoteException e) {
                e = e;
                str = f21085a;
                str2 = "RemoteException";
                Log.e(str, str2, e);
            } catch (RuntimeException e2) {
                e = e2;
                str = f21085a;
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
        dest.writeStrongBinder(this.f21086b.asBinder());
    }

    public QTAuthResponse(IQTAuthResponse response) {
        this.f21086b = response;
    }

    public void a(int errorCode) {
        String str;
        String str2;
        Bundle bundle = new Bundle();
        bundle.putInt("error", errorCode);
        try {
            this.f21086b.a(bundle);
        } catch (RemoteException e) {
            e = e;
            str = f21085a;
            str2 = "RemoteException";
            Log.e(str, str2, e);
        } catch (RuntimeException e2) {
            e = e2;
            str = f21085a;
            str2 = "RuntimeException";
            Log.e(str, str2, e);
        }
    }

    public void a(String code) {
        String str;
        String str2;
        Bundle bundle = new Bundle();
        bundle.putString("code", code);
        try {
            this.f21086b.a(bundle);
        } catch (RemoteException e) {
            e = e;
            str = f21085a;
            str2 = "RemoteException";
            Log.e(str, str2, e);
        } catch (RuntimeException e2) {
            e = e2;
            str = f21085a;
            str2 = "RuntimeException";
            Log.e(str, str2, e);
        }
    }
}
