package com.kwad.sdk.collector.b;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.webkit.WebView;
import com.kwad.sdk.api.proxy.app.ServiceProxyRemote;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.collector.model.b;
import com.kwad.sdk.service.c;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public class a extends com.kwad.sdk.m.a {
    private static AtomicBoolean avn = new AtomicBoolean(false);
    public static volatile Message avo;
    private HandlerC0388a avl = new HandlerC0388a(0);
    private Messenger avm = new Messenger(this.avl);

    public static void register() {
        try {
            c.a(Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote"), a.class);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        super.onCreate(service);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WebView.setDataDirectorySuffix(ay.getProcessName(service.getApplicationContext()));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.d("RemoteService", "WebView has already been initialized " + e.getMessage());
            }
        }
        com.kwad.sdk.core.d.c.d("RemoteService", "onCreate processName:" + ay.getProcessName(service));
        if (!SystemUtil.isInMainProcess(service)) {
            d.a(service, new d.a() { // from class: com.kwad.sdk.collector.b.a.1
                @Override // com.kwad.sdk.collector.d.a
                public final void onLoaded() {
                    com.kwad.sdk.core.d.c.d("RemoteService", "onLoaded");
                    a.avn.set(true);
                    if (a.avo != null) {
                        a.this.avl.handleMessage(a.avo);
                        a.avo = null;
                    }
                }

                @Override // com.kwad.sdk.collector.d.a
                public final void cB(String str) {
                    com.kwad.sdk.core.d.c.e("RemoteService", "onLoadError: " + str);
                    a.avn.set(false);
                }
            });
        } else {
            avn.set(true);
        }
        this.avl.a(service);
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(Service service) {
        super.onDestroy(service);
        com.kwad.sdk.core.d.c.d("RemoteService", "onDestroy");
        this.avl.a(null);
        if (bo(service)) {
            com.kwad.sdk.core.d.c.d("RemoteService", "goto kill myself");
            Process.killProcess(Process.myPid());
        }
    }

    public static AtomicBoolean DP() {
        return avn;
    }

    public static void a(Context context, ServiceConnection serviceConnection) {
        com.kwad.sdk.core.d.c.d("RemoteService", "bindASService");
        context.bindService(new Intent(context, (Class<?>) ServiceProxyRemote.class), serviceConnection, 1);
    }

    public static void b(Context context, ServiceConnection serviceConnection) {
        com.kwad.sdk.core.d.c.d("RemoteService", "unbindASService");
        try {
            context.unbindService(serviceConnection);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(Service service, Intent intent) {
        return this.avm.getBinder();
    }

    /* JADX INFO: renamed from: com.kwad.sdk.collector.b.a$a, reason: collision with other inner class name */
    static class HandlerC0388a extends Handler {
        private WeakReference<Service> avq;

        private HandlerC0388a() {
        }

        /* synthetic */ HandlerC0388a(byte b) {
            this();
        }

        public final void a(Service service) {
            if (service != null) {
                this.avq = new WeakReference<>(service);
            } else {
                this.avq = null;
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            com.kwad.sdk.core.d.c.d("RemoteService", "handleMessage");
            WeakReference<Service> weakReference = this.avq;
            Service service = weakReference != null ? weakReference.get() : null;
            if (service == null) {
                return;
            }
            if (!a.DP().get()) {
                com.kwad.sdk.core.d.c.d("RemoteService", "save buffered message");
                a.avo = Message.obtain(message);
                return;
            }
            final Messenger messenger = message.replyTo;
            int i = message.what;
            com.kwad.sdk.core.d.c.d("RemoteService", "handleMessage what: " + i);
            if (i != 100) {
                return;
            }
            final Bundle bundle = new Bundle();
            g.a(service, new g.b() { // from class: com.kwad.sdk.collector.b.a.a.1
                @Override // com.kwad.sdk.utils.g.b
                public final void x(List<b> list) {
                    com.kwad.sdk.core.d.c.d("RemoteService", "RemoteService: onAppStatusResult list: " + list);
                    if (list != null && !list.isEmpty()) {
                        com.kwad.sdk.core.d.c.d("RemoteService", "RemoteService: onAppStatusResult: " + list.size());
                        JSONArray jSONArrayP = g.a.P(list);
                        String string = jSONArrayP != null ? jSONArrayP.toString() : null;
                        com.kwad.sdk.core.d.c.d("RemoteService", "resultJson :" + string);
                        if (string != null) {
                            AppStatusRules appStatusRulesPr = g.Pr();
                            ArrayList<AppStatusRules.Strategy> allStrategy = appStatusRulesPr != null ? appStatusRulesPr.getAllStrategy() : null;
                            String string2 = allStrategy != null ? aa.S(allStrategy).toString() : null;
                            bundle.putString("resultJson", string);
                            bundle.putString("allStrategyJson", string2);
                        }
                    }
                    try {
                        Message messageObtain = Message.obtain();
                        messageObtain.what = 101;
                        messageObtain.setData(bundle);
                        messenger.send(messageObtain);
                    } catch (RemoteException unused) {
                    }
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    Iterator<b> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().destroy();
                    }
                }
            });
        }
    }

    private static boolean bo(Context context) {
        String processName = ay.getProcessName(context);
        return (processName == null || context.getPackageName().equals(processName)) ? false : true;
    }
}
