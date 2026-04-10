package com.kwad.framework.filedownloader.message;

import com.kwad.framework.filedownloader.download.d;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.message.a;
import com.kwad.framework.filedownloader.message.d;
import com.kwad.framework.filedownloader.message.h;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class f {
    public static MessageSnapshot a(int i, File file, boolean z) {
        long length = file.length();
        if (length > 2147483647L) {
            if (z) {
                return new d.a(i, true, length);
            }
            return new d.b(i, true, length);
        }
        if (z) {
            return new h.a(i, true, (int) length);
        }
        return new h.b(i, true, (int) length);
    }

    public static MessageSnapshot a(int i, long j, long j2, boolean z) {
        if (j2 > 2147483647L) {
            if (z) {
                return new d.i(i, j, j2);
            }
            return new d.j(i, j, j2);
        }
        if (z) {
            return new h.i(i, (int) j, (int) j2);
        }
        return new h.j(i, (int) j, (int) j2);
    }

    public static MessageSnapshot a(int i, long j, Throwable th) {
        if (j > 2147483647L) {
            return new d.C0378d(i, j, th);
        }
        return new h.d(i, (int) j, th);
    }

    public static MessageSnapshot e(com.kwad.framework.filedownloader.a aVar) {
        if (aVar.wP()) {
            return new d.e(aVar.getId(), aVar.wH(), aVar.wI());
        }
        return new h.e(aVar.getId(), aVar.getSmallFileSoFarBytes(), aVar.getSmallFileTotalBytes());
    }

    public static MessageSnapshot t(MessageSnapshot messageSnapshot) {
        if (messageSnapshot.wJ() != -3) {
            throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.c("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.wJ())));
        }
        return new a.C0377a(messageSnapshot);
    }

    public static MessageSnapshot a(byte b, com.kwad.framework.filedownloader.d.c cVar, d.a aVar) {
        MessageSnapshot bVar;
        IllegalStateException illegalStateException;
        int id = cVar.getId();
        if (b == -4) {
            throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.c("please use #catchWarn instead %d", Integer.valueOf(id)));
        }
        if (b != -3) {
            if (b != -1) {
                if (b == 1) {
                    if (cVar.wP()) {
                        return new d.f(id, cVar.yZ(), cVar.getTotal());
                    }
                    return new h.f(id, (int) cVar.yZ(), (int) cVar.getTotal());
                }
                if (b == 2) {
                    String filename = cVar.wF() ? cVar.getFilename() : null;
                    if (cVar.wP()) {
                        return new d.c(id, aVar.yE(), cVar.getTotal(), cVar.za(), filename);
                    }
                    return new h.c(id, aVar.yE(), (int) cVar.getTotal(), cVar.za(), filename);
                }
                if (b == 3) {
                    if (cVar.wP()) {
                        return new d.g(id, cVar.yZ());
                    }
                    return new h.g(id, (int) cVar.yZ());
                }
                if (b != 5) {
                    if (b == 6) {
                        return new MessageSnapshot.b(id);
                    }
                    String strC = com.kwad.framework.filedownloader.f.f.c("it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b));
                    com.kwad.framework.filedownloader.f.d.d(f.class, "it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b));
                    if (aVar.getException() != null) {
                        illegalStateException = new IllegalStateException(strC, aVar.getException());
                    } else {
                        illegalStateException = new IllegalStateException(strC);
                    }
                    if (cVar.wP()) {
                        return new d.C0378d(id, cVar.yZ(), illegalStateException);
                    }
                    return new h.d(id, (int) cVar.yZ(), illegalStateException);
                }
                if (cVar.wP()) {
                    bVar = new d.h(id, cVar.yZ(), aVar.getException(), aVar.wN());
                } else {
                    bVar = new h.C0379h(id, (int) cVar.yZ(), aVar.getException(), aVar.wN());
                }
            } else if (cVar.wP()) {
                bVar = new d.C0378d(id, cVar.yZ(), aVar.getException());
            } else {
                bVar = new h.d(id, (int) cVar.yZ(), aVar.getException());
            }
        } else if (cVar.wP()) {
            bVar = new d.b(id, false, cVar.getTotal());
        } else {
            bVar = new h.b(id, false, (int) cVar.getTotal());
        }
        return bVar;
    }
}
