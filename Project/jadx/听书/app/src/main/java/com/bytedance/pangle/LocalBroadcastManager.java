package com.bytedance.pangle;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock = new Object();
    private final Context mAppContext;
    private final Handler mHandler;
    private final HashMap<PluginBroadcastReceiver, ArrayList<g>> mReceivers = new HashMap<>();
    private final HashMap<String, ArrayList<g>> mActions = new HashMap<>();
    private final ArrayList<z> mPendingBroadcasts = new ArrayList<>();

    private static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f504a;
        boolean dl;
        final PluginBroadcastReceiver g;
        final IntentFilter z;

        g(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
            this.z = intentFilter;
            this.g = pluginBroadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.g);
            sb.append(" filter=");
            sb.append(this.z);
            if (this.f504a) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private static final class z {
        final ArrayList<g> g;
        final Intent z;

        z(Intent intent, ArrayList<g> arrayList) {
            this.z = intent;
            this.g = arrayList;
        }
    }

    public static LocalBroadcastManager getInstance(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = mInstance;
        }
        return localBroadcastManager;
    }

    private LocalBroadcastManager(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) { // from class: com.bytedance.pangle.LocalBroadcastManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    LocalBroadcastManager.this.executePendingBroadcasts();
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    public void registerReceiver(PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            g gVar = new g(intentFilter, pluginBroadcastReceiver);
            ArrayList<g> arrayList = this.mReceivers.get(pluginBroadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.mReceivers.put(pluginBroadcastReceiver, arrayList);
            }
            arrayList.add(gVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<g> arrayList2 = this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(gVar);
            }
        }
    }

    public void unregisterReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
        synchronized (this.mReceivers) {
            ArrayList<g> arrayListRemove = this.mReceivers.remove(pluginBroadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                g gVar = arrayListRemove.get(size);
                gVar.f504a = true;
                for (int i = 0; i < gVar.z.countActions(); i++) {
                    String action = gVar.z.getAction(i);
                    ArrayList<g> arrayList = this.mActions.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            g gVar2 = arrayList.get(size2);
                            if (gVar2.g == pluginBroadcastReceiver) {
                                gVar2.f504a = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.mActions.remove(action);
                        }
                    }
                }
            }
        }
    }

    public boolean sendBroadcast(Intent intent) {
        int i;
        String str;
        ArrayList arrayList;
        ArrayList<g> arrayList2;
        String str2;
        synchronized (this.mReceivers) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z2 = (intent.getFlags() & 8) != 0;
            if (z2) {
                com.bytedance.sdk.openadsdk.api.m.z(TAG, "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<g> arrayList3 = this.mActions.get(intent.getAction());
            if (arrayList3 != null) {
                if (z2) {
                    com.bytedance.sdk.openadsdk.api.m.z(TAG, "Action list: ".concat(String.valueOf(arrayList3)));
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    g gVar = arrayList3.get(i2);
                    if (z2) {
                        com.bytedance.sdk.openadsdk.api.m.z(TAG, "Matching against filter " + gVar.z);
                    }
                    if (gVar.dl) {
                        if (z2) {
                            com.bytedance.sdk.openadsdk.api.m.z(TAG, "  Filter's target already added");
                        }
                        i = i2;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = strResolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i = i2;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = strResolveTypeIfNeeded;
                        int iMatch = gVar.z.match(action, strResolveTypeIfNeeded, scheme, data, categories, TAG);
                        if (iMatch >= 0) {
                            if (z2) {
                                com.bytedance.sdk.openadsdk.api.m.z(TAG, "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(gVar);
                            gVar.dl = true;
                            i2 = i + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            strResolveTypeIfNeeded = str2;
                        } else if (z2) {
                            com.bytedance.sdk.openadsdk.api.m.z(TAG, "  Filter did not match: ".concat(iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                        }
                    }
                    arrayList4 = arrayList;
                    i2 = i + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    strResolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                        ((g) arrayList5.get(i3)).dl = false;
                    }
                    this.mPendingBroadcasts.add(new z(intent, arrayList5));
                    if (!this.mHandler.hasMessages(1)) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    void executePendingBroadcasts() {
        int size;
        z[] zVarArr;
        while (true) {
            synchronized (this.mReceivers) {
                size = this.mPendingBroadcasts.size();
                if (size <= 0) {
                    return;
                }
                zVarArr = new z[size];
                this.mPendingBroadcasts.toArray(zVarArr);
                this.mPendingBroadcasts.clear();
            }
            for (int i = 0; i < size; i++) {
                z zVar = zVarArr[i];
                int size2 = zVar.g.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    g gVar = zVar.g.get(i2);
                    if (!gVar.f504a) {
                        gVar.g.onReceive(this.mAppContext, zVar.z);
                    }
                }
            }
        }
    }
}
