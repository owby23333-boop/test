package x0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.anythink.expressad.video.module.a.a.m;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import s0.a;

/* JADX INFO: compiled from: o_d.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    public s0.a a = null;
    public String b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f21740c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f21741d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ServiceConnection f21742e = new c(this);

    /* JADX INFO: compiled from: o_d.java */
    public static class a {
        public static final b a = new b();
    }

    public synchronized String a(Context context, String str) {
        String strB;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            strB = "";
        } else if (this.a == null) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (context.bindService(intent, this.f21742e, 1)) {
                synchronized (this.f21741d) {
                    try {
                        this.f21741d.wait(m.ag);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            if (this.a == null) {
                strB = "";
            } else {
                try {
                    strB = b(context, str);
                } catch (RemoteException unused2) {
                    strB = "";
                }
            }
        } else {
            try {
                strB = b(context, str);
            } catch (RemoteException unused3) {
                strB = "";
            }
        }
        return strB;
    }

    public final String b(Context context, String str) throws RemoteException {
        Signature[] signatureArr;
        if (TextUtils.isEmpty(this.b)) {
            this.b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.f21740c)) {
            String string = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.b, 64).signatures;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] bArrDigest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : bArrDigest) {
                            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        string = sb.toString();
                    }
                } catch (NoSuchAlgorithmException e3) {
                    e3.printStackTrace();
                }
            }
            this.f21740c = string;
        }
        s0.a aVar = this.a;
        if (aVar == null) {
            context.getPackageName();
            return "";
        }
        a.AbstractBinderC0596a.C0597a c0597a = (a.AbstractBinderC0596a.C0597a) aVar;
        String str2 = this.b;
        String str3 = this.f21740c;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
            parcelObtain.writeString(str2);
            parcelObtain.writeString(str3);
            parcelObtain.writeString(str);
            c0597a.f21698s.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string2 = parcelObtain2.readString();
            parcelObtain2.recycle();
            parcelObtain.recycle();
            return TextUtils.isEmpty(string2) ? "" : string2;
        } catch (Throwable th) {
            parcelObtain2.recycle();
            parcelObtain.recycle();
            throw th;
        }
    }
}
