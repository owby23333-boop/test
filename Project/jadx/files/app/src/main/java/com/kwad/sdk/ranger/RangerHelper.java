package com.kwad.sdk.ranger;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.kwad.sdk.ranger.b;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.r;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Version;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;

/* JADX INFO: loaded from: classes3.dex */
public class RangerHelper {
    private static volatile boolean axr = false;
    private static List<String> axs;
    private static c axt;
    private static List<OkHttpClient> axu = new ArrayList();

    private static boolean Cy() {
        String strUserAgent;
        try {
            strUserAgent = Version.userAgent();
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(strUserAgent)) {
            com.kwad.sdk.core.d.b.d("Ranger_Helper", "TextUtils.isEmpty(userAgent)");
            return false;
        }
        com.kwad.sdk.core.d.b.d("Ranger_Helper", "userAgent:" + strUserAgent);
        String strReplace = strUserAgent.replace("okhttp/", "");
        if (!strReplace.startsWith("3.")) {
            return false;
        }
        int i2 = Integer.parseInt(strReplace.replaceAll("\\.", ""));
        return i2 >= 390 && i2 <= 3131;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final StreamAllocation streamAllocation) {
        g.schedule(new av() { // from class: com.kwad.sdk.ranger.RangerHelper.2
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                RangerHelper.g(r.d(streamAllocation, "call"));
            }
        }, 0L, TimeUnit.SECONDS);
    }

    static void b(c cVar) {
        axt = cVar;
        axs = cVar.axl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Object obj) {
        if (obj == null) {
            com.kwad.sdk.core.d.b.d("Ranger_Helper", "real call null");
            return;
        }
        try {
            OkHttpClient okHttpClient = (OkHttpClient) r.d(obj, "client");
            if (axu.contains(okHttpClient)) {
                com.kwad.sdk.core.d.b.d("Ranger_Helper", "already invoke");
                return;
            }
            axu.add(okHttpClient);
            Object objD = r.d(obj, "eventListener");
            if (objD != null) {
                com.kwad.sdk.core.d.b.d("Ranger_Helper", "eventListener.getClass().getName():" + objD.getClass().getName());
                r.a(okHttpClient, "eventListenerFactory", new b(objD, new b.a() { // from class: com.kwad.sdk.ranger.RangerHelper.3
                }));
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
        }
    }

    @Keep
    public static void replaceInternal() {
        if (axr) {
            return;
        }
        if (!Cy()) {
            axr = true;
            return;
        }
        final Internal internal = (Internal) r.c((Class<?>) Internal.class, "instance");
        if (internal == null) {
            axr = true;
            return;
        }
        com.kwad.sdk.core.d.b.d("Ranger_Helper", "internal:" + internal.getClass().getName());
        try {
            r.a(internal, "instance", new Internal() { // from class: com.kwad.sdk.ranger.RangerHelper.1
                @Keep
                public final void acquire(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
                    RangerHelper.a(streamAllocation);
                    r.b((Object) internal, "acquire", connectionPool, address, streamAllocation, route);
                }

                @Keep
                public final void addLenient(Headers.Builder builder, String str) {
                    try {
                        internal.addLenient(builder, str);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
                    }
                }

                @Keep
                public final void addLenient(Headers.Builder builder, String str, String str2) {
                    try {
                        internal.addLenient(builder, str, str2);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
                    }
                }

                @Keep
                public final void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z2) {
                    try {
                        internal.apply(connectionSpec, sSLSocket, z2);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
                    }
                }

                @Keep
                public final int code(Response.Builder builder) {
                    try {
                        return internal.code(builder);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
                        return -1;
                    }
                }

                @Keep
                public final boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection) {
                    try {
                        return internal.connectionBecameIdle(connectionPool, realConnection);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
                        return false;
                    }
                }

                @Keep
                public final Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                    try {
                        return internal.deduplicate(connectionPool, address, streamAllocation);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
                        return null;
                    }
                }

                @Keep
                public final boolean equalsNonHost(Address address, Address address2) {
                    Boolean bool = (Boolean) r.b((Object) internal, "equalsNonHost", address, address2);
                    if (bool != null) {
                        return bool.booleanValue();
                    }
                    return false;
                }

                @Keep
                public final RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                    return (RealConnection) r.b((Object) internal, MonitorConstants.CONNECT_TYPE_GET, connectionPool, address, streamAllocation);
                }

                @Keep
                public final RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
                    RangerHelper.a(streamAllocation);
                    return (RealConnection) r.b((Object) internal, MonitorConstants.CONNECT_TYPE_GET, connectionPool, address, streamAllocation, route);
                }

                @Keep
                public final HttpUrl getHttpUrlChecked(String str) {
                    return (HttpUrl) r.b((Object) internal, "getHttpUrlChecked", str);
                }

                @Keep
                public final void initCodec(Response.Builder builder, HttpCodec httpCodec) {
                    r.b((Object) internal, "initCodec", builder, httpCodec);
                }

                @Keep
                public final boolean isInvalidHttpUrlHost(IllegalArgumentException illegalArgumentException) {
                    Boolean bool = (Boolean) r.b((Object) internal, "isInvalidHttpUrlHost", illegalArgumentException);
                    if (bool != null) {
                        return bool.booleanValue();
                    }
                    return false;
                }

                @Keep
                public final Call newWebSocketCall(OkHttpClient okHttpClient, Request request) {
                    try {
                        return internal.newWebSocketCall(okHttpClient, request);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
                        return null;
                    }
                }

                @Keep
                public final void put(ConnectionPool connectionPool, RealConnection realConnection) {
                    r.b((Object) internal, "put", connectionPool, realConnection);
                }

                @Keep
                public final RouteDatabase routeDatabase(ConnectionPool connectionPool) {
                    try {
                        return internal.routeDatabase(connectionPool);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
                        return null;
                    }
                }

                @Keep
                public final void setCache(OkHttpClient.Builder builder, InternalCache internalCache) {
                    try {
                        internal.setCache(builder, internalCache);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
                    }
                }

                @Keep
                public final StreamAllocation streamAllocation(Call call) {
                    try {
                        return internal.streamAllocation(call);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
                        return null;
                    }
                }

                @Keep
                public final IOException timeoutExit(Call call, IOException iOException) {
                    return (IOException) r.b((Object) internal, "timeoutExit", call, iOException);
                }
            });
            axr = true;
        } catch (Throwable th) {
            axr = true;
            com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
        }
    }
}
