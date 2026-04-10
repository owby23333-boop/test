package r0;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: C0035a.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    public IBinder a;

    public a() {
        Method declaredMethod;
        this.a = null;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            if (!((String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, "ro.build.uiversion", "")).contains("360UI") || (declaredMethod = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class)) == null) {
                return;
            }
            this.a = (IBinder) declaredMethod.invoke(null, "qikuid");
        } catch (Exception unused) {
        }
    }

    public boolean a() {
        if (this.a != null) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                this.a.transact(2, parcelObtain, parcelObtain2, 0);
                return parcelObtain2.readInt() == 1;
            } catch (RemoteException e2) {
                e2.printStackTrace();
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
        return false;
    }
}
