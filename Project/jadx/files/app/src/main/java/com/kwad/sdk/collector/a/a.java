package com.kwad.sdk.collector.a;

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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.proxy.app.ServiceProxyRemote;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.f;
import com.kwad.sdk.utils.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.kwad.sdk.h.a {
    private static AtomicBoolean aaW = new AtomicBoolean(false);
    public static volatile Message aaX;
    private HandlerC0429a aaU = new HandlerC0429a(0);
    private Messenger aaV = new Messenger(this.aaU);

    /* JADX INFO: renamed from: com.kwad.sdk.collector.a.a$a, reason: collision with other inner class name */
    static class HandlerC0429a extends Handler {
        private WeakReference<Service> aaZ;

        private HandlerC0429a() {
        }

        /* synthetic */ HandlerC0429a(byte b) {
            this();
        }

        public final void a(@Nullable Service service) {
            if (service != null) {
                this.aaZ = new WeakReference<>(service);
            } else {
                this.aaZ = null;
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            b.d("RemoteService", "handleMessage");
            WeakReference<Service> weakReference = this.aaZ;
            Service service = weakReference != null ? weakReference.get() : null;
            if (service == null) {
                return;
            }
            if (!a.tY().get()) {
                b.d("RemoteService", "save buffered message");
                a.aaX = Message.obtain(message);
                return;
            }
            final Messenger messenger = message.replyTo;
            int i2 = message.what;
            b.d("RemoteService", "handleMessage what: " + i2);
            if (i2 != 100) {
                return;
            }
            final Bundle bundle = new Bundle();
            f.a(service, new f.b() { // from class: com.kwad.sdk.collector.a.a.a.1
                @Override // com.kwad.sdk.utils.f.b
                public final void n(List<com.kwad.sdk.collector.model.b> list) {
                    b.d("RemoteService", "RemoteService: onAppStatusResult list: " + list);
                    if (list != null && !list.isEmpty()) {
                        b.d("RemoteService", "RemoteService: onAppStatusResult: " + list.size());
                        JSONArray jSONArrayB = f.a.B(list);
                        String string = jSONArrayB != null ? jSONArrayB.toString() : null;
                        b.d("RemoteService", "resultJson :" + string);
                        if (string != null) {
                            AppStatusRules appStatusRulesCH = f.CH();
                            ArrayList<AppStatusRules.Strategy> allStrategy = appStatusRulesCH != null ? appStatusRulesCH.getAllStrategy() : null;
                            String string2 = allStrategy != null ? s.E(allStrategy).toString() : null;
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
                    Iterator<com.kwad.sdk.collector.model.b> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().destroy();
                    }
                }
            });
        }
    }

    public static void a(@NonNull Context context, ServiceConnection serviceConnection) {
        b.d("RemoteService", "bindASService");
        context.bindService(new Intent(context, (Class<?>) ServiceProxyRemote.class), serviceConnection, 1);
    }

    private static boolean aM(Context context) {
        String processName = ao.getProcessName(context);
        return (processName == null || context.getPackageName().equals(processName)) ? false : true;
    }

    public static void b(@NonNull Context context, ServiceConnection serviceConnection) {
        b.d("RemoteService", "unbindASService");
        try {
            context.unbindService(serviceConnection);
        } catch (Exception e2) {
            b.printStackTrace(e2);
        }
    }

    public static void register() {
        try {
            com.kwad.sdk.service.a.a(Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote"), a.class);
        } catch (Throwable unused) {
        }
    }

    public static AtomicBoolean tY() {
        return aaW;
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(@NonNull Service service, Intent intent) {
        return this.aaV.getBinder();
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        super.onCreate(service);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WebView.setDataDirectorySuffix(ao.getProcessName(service.getApplicationContext()));
            } catch (Exception e2) {
                b.d("RemoteService", "WebView has already been initialized " + e2.getMessage());
            }
        }
        b.d("RemoteService", "onCreate processName:" + ao.getProcessName(service));
        if (SystemUtil.isInMainProcess(service)) {
            aaW.set(true);
        } else {
            d.a(service, new d.a() { // from class: com.kwad.sdk.collector.a.a.1
                @Override // com.kwad.sdk.collector.d.a
                public final void aZ(String str) {
                    b.e("RemoteService", "onLoadError: " + str);
                    a.aaW.set(false);
                }

                @Override // com.kwad.sdk.collector.d.a
                public final void onLoaded() {
                    b.d("RemoteService", "onLoaded");
                    a.aaW.set(true);
                    if (a.aaX != null) {
                        a.this.aaU.handleMessage(a.aaX);
                        a.aaX = null;
                    }
                }
            });
        }
        this.aaU.a(service);
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(@NonNull Service service) {
        super.onDestroy(service);
        b.d("RemoteService", "onDestroy");
        this.aaU.a(null);
        if (aM(service)) {
            b.d("RemoteService", "goto kill myself");
            Process.killProcess(Process.myPid());
        }
    }
}
