package anetwork.channel.aidl.j;

import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anetwork.channel.aidl.f;
import anetwork.channel.entity.h;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class c extends f.a {
    private static final ByteArray A = ByteArray.create(0);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f547u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f548v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f549w;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final AtomicBoolean f545s = new AtomicBoolean(false);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private LinkedList<ByteArray> f546t = new LinkedList<>();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f550x = 10000;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    final ReentrantLock f551y = new ReentrantLock();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    final Condition f552z = this.f551y.newCondition();

    private void b() {
        this.f551y.lock();
        try {
            this.f546t.set(this.f547u, A).recycle();
        } finally {
            this.f551y.unlock();
        }
    }

    public void a(ByteArray byteArray) {
        if (this.f545s.get()) {
            return;
        }
        this.f551y.lock();
        try {
            this.f546t.add(byteArray);
            this.f552z.signal();
        } finally {
            this.f551y.unlock();
        }
    }

    @Override // anetwork.channel.aidl.f
    public int available() throws RemoteException {
        if (this.f545s.get()) {
            throw new RuntimeException("Stream is closed");
        }
        this.f551y.lock();
        try {
            int dataLength = 0;
            if (this.f547u == this.f546t.size()) {
                return 0;
            }
            ListIterator<ByteArray> listIterator = this.f546t.listIterator(this.f547u);
            while (listIterator.hasNext()) {
                dataLength += listIterator.next().getDataLength();
            }
            return dataLength - this.f548v;
        } finally {
            this.f551y.unlock();
        }
    }

    @Override // anetwork.channel.aidl.f
    public void close() throws RemoteException {
        if (this.f545s.compareAndSet(false, true)) {
            this.f551y.lock();
            try {
                for (ByteArray byteArray : this.f546t) {
                    if (byteArray != A) {
                        byteArray.recycle();
                    }
                }
                this.f546t.clear();
                this.f546t = null;
                this.f547u = -1;
                this.f548v = -1;
                this.f549w = 0;
            } finally {
                this.f551y.unlock();
            }
        }
    }

    @Override // anetwork.channel.aidl.f
    public long d(int i2) throws RemoteException {
        ByteArray byteArray;
        this.f551y.lock();
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.f547u != this.f546t.size() && (byteArray = this.f546t.get(this.f547u)) != A) {
                    int dataLength = byteArray.getDataLength();
                    int i4 = i2 - i3;
                    if (dataLength - this.f548v < i4) {
                        i3 += dataLength - this.f548v;
                        b();
                        this.f547u++;
                        this.f548v = 0;
                    } else {
                        this.f548v += i4;
                        i3 = i2;
                    }
                }
            } catch (Throwable th) {
                this.f551y.unlock();
                throw th;
            }
        }
        this.f551y.unlock();
        return i3;
    }

    @Override // anetwork.channel.aidl.f
    public int length() throws RemoteException {
        return this.f549w;
    }

    @Override // anetwork.channel.aidl.f
    public int read(byte[] bArr) throws RemoteException {
        return a(bArr, 0, bArr.length);
    }

    @Override // anetwork.channel.aidl.f
    public int readByte() throws RemoteException {
        byte b;
        if (this.f545s.get()) {
            throw new RuntimeException("Stream is closed");
        }
        this.f551y.lock();
        while (true) {
            try {
                try {
                    if (this.f547u == this.f546t.size() && !this.f552z.await(this.f550x, TimeUnit.MILLISECONDS)) {
                        close();
                        throw new RuntimeException("await timeout.");
                    }
                    ByteArray byteArray = this.f546t.get(this.f547u);
                    if (byteArray == A) {
                        b = -1;
                        break;
                    }
                    if (this.f548v < byteArray.getDataLength()) {
                        b = byteArray.getBuffer()[this.f548v];
                        this.f548v++;
                        break;
                    }
                    b();
                    this.f547u++;
                    this.f548v = 0;
                } catch (InterruptedException unused) {
                    close();
                    throw new RuntimeException("await interrupt");
                }
            } finally {
                this.f551y.unlock();
            }
        }
        return b;
    }

    public void a() {
        a(A);
    }

    @Override // anetwork.channel.aidl.f
    public int a(byte[] bArr, int i2, int i3) throws RemoteException {
        int i4;
        if (this.f545s.get()) {
            throw new RuntimeException("Stream is closed");
        }
        if (bArr != null) {
            if (i2 >= 0 && i3 >= 0 && (i4 = i3 + i2) <= bArr.length) {
                this.f551y.lock();
                int i5 = i2;
                while (i5 < i4) {
                    try {
                        try {
                            if (this.f547u == this.f546t.size() && !this.f552z.await(this.f550x, TimeUnit.MILLISECONDS)) {
                                close();
                                throw new RuntimeException("await timeout.");
                            }
                            ByteArray byteArray = this.f546t.get(this.f547u);
                            if (byteArray == A) {
                                break;
                            }
                            int dataLength = byteArray.getDataLength() - this.f548v;
                            int i6 = i4 - i5;
                            if (dataLength < i6) {
                                System.arraycopy(byteArray.getBuffer(), this.f548v, bArr, i5, dataLength);
                                i5 += dataLength;
                                b();
                                this.f547u++;
                                this.f548v = 0;
                            } else {
                                System.arraycopy(byteArray.getBuffer(), this.f548v, bArr, i5, i6);
                                this.f548v += i6;
                                i5 += i6;
                            }
                        } catch (InterruptedException unused) {
                            close();
                            throw new RuntimeException("await interrupt");
                        }
                    } catch (Throwable th) {
                        this.f551y.unlock();
                        throw th;
                    }
                }
                this.f551y.unlock();
                int i7 = i5 - i2;
                if (i7 > 0) {
                    return i7;
                }
                return -1;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new NullPointerException();
    }

    public void a(h hVar, int i2) {
        this.f549w = i2;
        String str = hVar.f591i;
        this.f550x = hVar.f590h;
    }
}
