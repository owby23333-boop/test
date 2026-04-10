package d.a.o;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.a;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.StringUtils;
import anetwork.channel.aidl.NetworkResponse;
import anetwork.channel.aidl.ParcelableRequest;
import anetwork.channel.aidl.h;
import anetwork.channel.http.NetworkSdkSetting;
import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public abstract class b extends h.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f20725s = 1;

    public b(Context context) {
        NetworkSdkSetting.a(context);
    }

    private NetworkResponse c(ParcelableRequest parcelableRequest) {
        NetworkResponse networkResponse = new NetworkResponse();
        try {
            anetwork.channel.aidl.j.a aVar = (anetwork.channel.aidl.j.a) a(parcelableRequest);
            anetwork.channel.aidl.f inputStream = aVar.getInputStream();
            if (inputStream != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(inputStream.length() > 0 ? inputStream.length() : 1024);
                ByteArray byteArrayA = a.C0005a.a.a(2048);
                while (true) {
                    int i2 = inputStream.read(byteArrayA.getBuffer());
                    if (i2 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(byteArrayA.getBuffer(), 0, i2);
                }
                networkResponse.a(byteArrayOutputStream.toByteArray());
            }
            int iJ = aVar.j();
            if (iJ < 0) {
                networkResponse.a((byte[]) null);
            } else {
                networkResponse.a(aVar.k());
            }
            networkResponse.a(iJ);
            networkResponse.a(aVar.e());
            return networkResponse;
        } catch (RemoteException e2) {
            networkResponse.a(ErrorConstant.ERROR_REMOTE_CALL_FAIL);
            String message = e2.getMessage();
            if (!TextUtils.isEmpty(message)) {
                networkResponse.a(StringUtils.concatString(networkResponse.a(), com.anythink.expressad.foundation.g.a.bQ, message));
            }
            return networkResponse;
        } catch (Exception unused) {
            networkResponse.a(ErrorConstant.ERROR_REQUEST_FAIL);
            return networkResponse;
        }
    }

    @Override // anetwork.channel.aidl.h
    public anetwork.channel.aidl.e a(ParcelableRequest parcelableRequest, anetwork.channel.aidl.g gVar) throws RemoteException {
        try {
            return a(new anetwork.channel.entity.h(parcelableRequest, this.f20725s, false), gVar);
        } catch (Exception e2) {
            ALog.e("anet.UnifiedNetworkDelegate", "asyncSend failed", parcelableRequest.E, e2, new Object[0]);
            throw new RemoteException(e2.getMessage());
        }
    }

    @Override // anetwork.channel.aidl.h
    public NetworkResponse b(ParcelableRequest parcelableRequest) throws RemoteException {
        return c(parcelableRequest);
    }

    private anetwork.channel.aidl.e a(anetwork.channel.entity.h hVar, anetwork.channel.aidl.g gVar) throws RemoteException {
        return new anetwork.channel.aidl.j.b(new m(hVar, new anetwork.channel.entity.d(gVar, hVar)).a());
    }

    @Override // anetwork.channel.aidl.h
    public anetwork.channel.aidl.a a(ParcelableRequest parcelableRequest) throws RemoteException {
        try {
            anetwork.channel.entity.h hVar = new anetwork.channel.entity.h(parcelableRequest, this.f20725s, true);
            anetwork.channel.aidl.j.a aVar = new anetwork.channel.aidl.j.a(hVar);
            aVar.a(a(hVar, new anetwork.channel.aidl.j.d(aVar, null, null)));
            return aVar;
        } catch (Exception e2) {
            ALog.e("anet.UnifiedNetworkDelegate", "asyncSend failed", parcelableRequest.E, e2, new Object[0]);
            throw new RemoteException(e2.getMessage());
        }
    }
}
