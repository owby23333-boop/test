package m0;

import android.os.AsyncTask;
import android.os.RemoteException;
import v.c;

/* JADX INFO: compiled from: AsyncTaskC0050a.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends AsyncTask<Void, Void, Boolean> {
    public v.a a;
    public e.a b;

    public a(v.a aVar, e.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // android.os.AsyncTask
    public Boolean doInBackground(Void[] voidArr) {
        boolean zD;
        e.a aVar;
        if (this.a == null) {
            return Boolean.FALSE;
        }
        int i2 = 0;
        while (true) {
            try {
                zD = this.a.d();
            } catch (RemoteException | InterruptedException e2) {
                c.b("MsaAsyncTask", "doInBackground", e2);
            }
            if (zD) {
                break;
            }
            Thread.sleep(10L);
            i2++;
            if (i2 >= 30) {
                break;
            }
        }
        if (zD && (aVar = this.b) != null) {
            aVar.a(true);
        }
        return Boolean.valueOf(zD);
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
    }
}
