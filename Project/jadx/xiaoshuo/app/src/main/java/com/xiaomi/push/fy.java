package com.xiaomi.push;

import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes8.dex */
final class fy {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        fs f7984a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f416a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static void m436a(Exception exc) {
        exc.getClass();
    }

    public static a b(Exception exc) {
        Throwable cause;
        m436a(exc);
        boolean z = exc instanceof ha;
        Throwable thA = exc;
        if (z) {
            ha haVar = (ha) exc;
            thA = exc;
            if (haVar.a() != null) {
                thA = haVar.a();
            }
        }
        a aVar = new a();
        String message = thA.getMessage();
        if (thA.getCause() != null) {
            message = thA.getCause().getMessage();
        }
        int iA = gr.a(thA);
        String str = thA.getClass().getSimpleName() + ":" + message;
        if (iA != 0) {
            fs fsVarA = fs.a(fs.CONN_SUCCESS.a() + iA);
            aVar.f7984a = fsVarA;
            if (fsVarA == fs.CONN_BOSH_ERR && (cause = thA.getCause()) != null && (cause instanceof UnknownHostException)) {
                aVar.f7984a = fs.CONN_BOSH_UNKNOWNHOST;
            }
        } else {
            aVar.f7984a = fs.CONN_XMPP_ERR;
        }
        fs fsVar = aVar.f7984a;
        if (fsVar == fs.CONN_TCP_ERR_OTHER || fsVar == fs.CONN_XMPP_ERR || fsVar == fs.CONN_BOSH_ERR) {
            aVar.f416a = str;
        }
        return aVar;
    }

    public static a c(Exception exc) {
        m436a(exc);
        boolean z = exc instanceof ha;
        Throwable thA = exc;
        if (z) {
            ha haVar = (ha) exc;
            thA = exc;
            if (haVar.a() != null) {
                thA = haVar.a();
            }
        }
        a aVar = new a();
        String message = thA.getMessage();
        if (thA.getCause() != null) {
            message = thA.getCause().getMessage();
        }
        int iA = gr.a(thA);
        String str = thA.getClass().getSimpleName() + ":" + message;
        if (iA == 105) {
            aVar.f7984a = fs.BIND_TCP_READ_TIMEOUT;
        } else if (iA == 199) {
            aVar.f7984a = fs.BIND_TCP_ERR;
        } else if (iA == 499) {
            aVar.f7984a = fs.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar.f7984a = fs.BIND_BOSH_ITEM_NOT_FOUND;
            }
        } else if (iA == 109) {
            aVar.f7984a = fs.BIND_TCP_CONNRESET;
        } else if (iA != 110) {
            aVar.f7984a = fs.BIND_XMPP_ERR;
        } else {
            aVar.f7984a = fs.BIND_TCP_BROKEN_PIPE;
        }
        fs fsVar = aVar.f7984a;
        if (fsVar == fs.BIND_TCP_ERR || fsVar == fs.BIND_XMPP_ERR || fsVar == fs.BIND_BOSH_ERR) {
            aVar.f416a = str;
        }
        return aVar;
    }

    public static a d(Exception exc) {
        m436a(exc);
        boolean z = exc instanceof ha;
        Throwable thA = exc;
        if (z) {
            ha haVar = (ha) exc;
            thA = exc;
            if (haVar.a() != null) {
                thA = haVar.a();
            }
        }
        a aVar = new a();
        String message = thA.getMessage();
        int iA = gr.a(thA);
        String str = thA.getClass().getSimpleName() + ":" + message;
        if (iA == 105) {
            aVar.f7984a = fs.CHANNEL_TCP_READTIMEOUT;
        } else if (iA == 199) {
            aVar.f7984a = fs.CHANNEL_TCP_ERR;
        } else if (iA == 499) {
            aVar.f7984a = fs.CHANNEL_BOSH_EXCEPTION;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar.f7984a = fs.CHANNEL_BOSH_ITEMNOTFIND;
            }
        } else if (iA == 109) {
            aVar.f7984a = fs.CHANNEL_TCP_CONNRESET;
        } else if (iA != 110) {
            aVar.f7984a = fs.CHANNEL_XMPPEXCEPTION;
        } else {
            aVar.f7984a = fs.CHANNEL_TCP_BROKEN_PIPE;
        }
        fs fsVar = aVar.f7984a;
        if (fsVar == fs.CHANNEL_TCP_ERR || fsVar == fs.CHANNEL_XMPPEXCEPTION || fsVar == fs.CHANNEL_BOSH_EXCEPTION) {
            aVar.f416a = str;
        }
        return aVar;
    }

    public static a a(Exception exc) {
        m436a(exc);
        boolean z = exc instanceof ha;
        Throwable thA = exc;
        if (z) {
            ha haVar = (ha) exc;
            thA = exc;
            if (haVar.a() != null) {
                thA = haVar.a();
            }
        }
        a aVar = new a();
        String message = thA.getMessage();
        if (thA.getCause() != null) {
            message = thA.getCause().getMessage();
        }
        String str = thA.getClass().getSimpleName() + ":" + message;
        int iA = gr.a(thA);
        if (iA != 0) {
            aVar.f7984a = fs.a(fs.GSLB_REQUEST_SUCCESS.a() + iA);
        }
        if (aVar.f7984a == null) {
            aVar.f7984a = fs.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.f7984a == fs.GSLB_TCP_ERR_OTHER) {
            aVar.f416a = str;
        }
        return aVar;
    }
}
