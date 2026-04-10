package com.kwai.filedownloader.message;

import com.kwai.filedownloader.download.d;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.message.a;
import com.kwai.filedownloader.message.d;
import com.kwai.filedownloader.message.h;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class f {
    public static MessageSnapshot a(byte b, com.kwai.filedownloader.c.c cVar, d.a aVar) {
        MessageSnapshot c0469d;
        int id = cVar.getId();
        if (b == -4) {
            throw new IllegalStateException(com.kwai.filedownloader.e.f.j("please use #catchWarn instead %d", Integer.valueOf(id)));
        }
        if (b == -3) {
            return cVar.Gk() ? new d.b(id, false, cVar.getTotal()) : new h.b(id, false, (int) cVar.getTotal());
        }
        if (b == -1) {
            c0469d = cVar.Gk() ? new d.C0469d(id, cVar.Ip(), aVar.getException()) : new h.d(id, (int) cVar.Ip(), aVar.getException());
        } else if (b != 1) {
            if (b == 2) {
                String filename = cVar.Ga() ? cVar.getFilename() : null;
                return cVar.Gk() ? new d.c(id, aVar.HU(), cVar.getTotal(), cVar.Iq(), filename) : new h.c(id, aVar.HU(), (int) cVar.getTotal(), cVar.Iq(), filename);
            }
            if (b == 3) {
                return cVar.Gk() ? new d.g(id, cVar.Ip()) : new h.g(id, (int) cVar.Ip());
            }
            if (b != 5) {
                if (b == 6) {
                    return new MessageSnapshot.b(id);
                }
                String strJ = com.kwai.filedownloader.e.f.j("it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b));
                com.kwai.filedownloader.e.d.h(f.class, "it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b));
                IllegalStateException illegalStateException = aVar.getException() != null ? new IllegalStateException(strJ, aVar.getException()) : new IllegalStateException(strJ);
                return cVar.Gk() ? new d.C0469d(id, cVar.Ip(), illegalStateException) : new h.d(id, (int) cVar.Ip(), illegalStateException);
            }
            c0469d = cVar.Gk() ? new d.h(id, cVar.Ip(), aVar.getException(), aVar.Gi()) : new h.C0470h(id, (int) cVar.Ip(), aVar.getException(), aVar.Gi());
        } else {
            if (!cVar.Gk()) {
                return new h.f(id, (int) cVar.Ip(), (int) cVar.getTotal());
            }
            c0469d = new d.f(id, cVar.Ip(), cVar.getTotal());
        }
        return c0469d;
    }

    public static MessageSnapshot a(int i2, long j2, long j3, boolean z2) {
        return j3 > 2147483647L ? z2 ? new d.i(i2, j2, j3) : new d.j(i2, j2, j3) : z2 ? new h.i(i2, (int) j2, (int) j3) : new h.j(i2, (int) j2, (int) j3);
    }

    public static MessageSnapshot a(int i2, long j2, Throwable th) {
        return j2 > 2147483647L ? new d.C0469d(i2, j2, th) : new h.d(i2, (int) j2, th);
    }

    public static MessageSnapshot a(int i2, File file, boolean z2) {
        long length = file.length();
        return length > 2147483647L ? z2 ? new d.a(i2, true, length) : new d.b(i2, true, length) : z2 ? new h.a(i2, true, (int) length) : new h.b(i2, true, (int) length);
    }

    public static MessageSnapshot e(com.kwai.filedownloader.a aVar) {
        return aVar.Gk() ? new d.e(aVar.getId(), aVar.Gc(), aVar.Gd()) : new h.e(aVar.getId(), aVar.getSmallFileSoFarBytes(), aVar.getSmallFileTotalBytes());
    }

    public static MessageSnapshot t(MessageSnapshot messageSnapshot) {
        if (messageSnapshot.Ge() == -3) {
            return new a.C0468a(messageSnapshot);
        }
        throw new IllegalStateException(com.kwai.filedownloader.e.f.j("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.Ge())));
    }
}
