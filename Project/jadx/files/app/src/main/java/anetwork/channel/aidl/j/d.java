package anetwork.channel.aidl.j;

import android.os.Handler;
import android.os.RemoteException;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.aidl.DefaultProgressEvent;
import anetwork.channel.aidl.ParcelableHeader;
import anetwork.channel.aidl.f;
import anetwork.channel.aidl.g;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class d extends g.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private d.a.g f553s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Handler f554t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Object f555u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private byte f556v;

    public d(d.a.g gVar, Handler handler, Object obj) {
        this.f556v = (byte) 0;
        this.f553s = gVar;
        if (gVar != null) {
            if (d.a.a.class.isAssignableFrom(gVar.getClass())) {
                this.f556v = (byte) (this.f556v | 1);
            }
            if (d.a.c.class.isAssignableFrom(gVar.getClass())) {
                this.f556v = (byte) (this.f556v | 2);
            }
            if (d.a.d.class.isAssignableFrom(gVar.getClass())) {
                this.f556v = (byte) (this.f556v | 4);
            }
            if (d.a.b.class.isAssignableFrom(gVar.getClass())) {
                this.f556v = (byte) (this.f556v | 8);
            }
        }
        this.f554t = handler;
        this.f555u = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(byte b, Object obj) {
        try {
            if (b == 4) {
                ParcelableHeader parcelableHeader = (ParcelableHeader) obj;
                ((d.a.d) this.f553s).a(parcelableHeader.b(), parcelableHeader.a(), this.f555u);
                if (ALog.isPrintLog(1)) {
                    ALog.d("anet.ParcelableNetworkListenerWrapper", "[onResponseCode]" + parcelableHeader, null, new Object[0]);
                    return;
                }
                return;
            }
            if (b == 2) {
                DefaultProgressEvent defaultProgressEvent = (DefaultProgressEvent) obj;
                if (defaultProgressEvent != null) {
                    defaultProgressEvent.a(this.f555u);
                }
                ((d.a.c) this.f553s).a(defaultProgressEvent, this.f555u);
                if (ALog.isPrintLog(1)) {
                    ALog.d("anet.ParcelableNetworkListenerWrapper", "[onDataReceived]" + defaultProgressEvent, null, new Object[0]);
                    return;
                }
                return;
            }
            if (b != 1) {
                if (b == 8) {
                    ((d.a.b) this.f553s).a((f) obj, this.f555u);
                    if (ALog.isPrintLog(1)) {
                        ALog.d("anet.ParcelableNetworkListenerWrapper", "[onInputStreamReceived]", null, new Object[0]);
                        return;
                    }
                    return;
                }
                return;
            }
            DefaultFinishEvent defaultFinishEvent = (DefaultFinishEvent) obj;
            if (defaultFinishEvent != null) {
                defaultFinishEvent.a(this.f555u);
            }
            ((d.a.a) this.f553s).a(defaultFinishEvent, this.f555u);
            if (ALog.isPrintLog(1)) {
                ALog.d("anet.ParcelableNetworkListenerWrapper", "[onFinished]" + defaultFinishEvent, null, new Object[0]);
            }
        } catch (Exception unused) {
            ALog.e("anet.ParcelableNetworkListenerWrapper", "dispatchCallback error", null, new Object[0]);
        }
    }

    @Override // anetwork.channel.aidl.g
    public byte g() throws RemoteException {
        return this.f556v;
    }

    private void a(byte b, Object obj) {
        Handler handler = this.f554t;
        if (handler == null) {
            b(b, obj);
        } else {
            handler.post(new e(this, b, obj));
        }
    }

    @Override // anetwork.channel.aidl.g
    public void a(DefaultProgressEvent defaultProgressEvent) throws RemoteException {
        if ((this.f556v & 2) != 0) {
            a((byte) 2, defaultProgressEvent);
        }
    }

    @Override // anetwork.channel.aidl.g
    public void a(DefaultFinishEvent defaultFinishEvent) throws RemoteException {
        if ((this.f556v & 1) != 0) {
            a((byte) 1, defaultFinishEvent);
        }
        this.f553s = null;
        this.f555u = null;
        this.f554t = null;
    }

    @Override // anetwork.channel.aidl.g
    public boolean a(int i2, ParcelableHeader parcelableHeader) throws RemoteException {
        if ((this.f556v & 4) == 0) {
            return false;
        }
        a((byte) 4, (Object) parcelableHeader);
        return false;
    }

    @Override // anetwork.channel.aidl.g
    public void a(f fVar) throws RemoteException {
        if ((this.f556v & 8) != 0) {
            a((byte) 8, fVar);
        }
    }
}
