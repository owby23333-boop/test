package com.kwad.sdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class ad {
    private static ad aZw;
    private static final Object mLock = new Object();
    private final Context aZs;
    private final HashMap<BroadcastReceiver, ArrayList<b>> aZt = new HashMap<>();
    private final HashMap<String, ArrayList<b>> aZu = new HashMap<>();
    private final ArrayList<a> aZv = new ArrayList<>();
    private final Handler iK;

    static final class b {
        boolean aZA;
        boolean aZB;
        final BroadcastReceiver aZz;
        final IntentFilter filter;

        b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.aZz = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.aZz);
            sb.append(" filter=");
            sb.append(this.filter);
            if (this.aZB) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    static final class a {
        final ArrayList<b> aZy;
        final Intent intent;

        a(Intent intent, ArrayList<b> arrayList) {
            this.intent = intent;
            this.aZy = arrayList;
        }
    }

    public static ad cO(Context context) {
        ad adVar;
        synchronized (mLock) {
            if (aZw == null) {
                aZw = new ad(context.getApplicationContext());
            }
            adVar = aZw;
        }
        return adVar;
    }

    private ad(Context context) {
        this.aZs = context;
        this.iK = new Handler(context.getMainLooper()) { // from class: com.kwad.sdk.utils.ad.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what == 1) {
                    ad.this.Qd();
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.aZt) {
            b bVar = new b(intentFilter, broadcastReceiver);
            ArrayList<b> arrayList = this.aZt.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.aZt.put(broadcastReceiver, arrayList);
            }
            arrayList.add(bVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<b> arrayList2 = this.aZu.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.aZu.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    public final void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.aZt) {
            ArrayList<b> arrayListRemove = this.aZt.remove(broadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                b bVar = arrayListRemove.get(size);
                bVar.aZB = true;
                for (int i = 0; i < bVar.filter.countActions(); i++) {
                    String action = bVar.filter.getAction(i);
                    ArrayList<b> arrayList = this.aZu.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            b bVar2 = arrayList.get(size2);
                            if (bVar2.aZz == broadcastReceiver) {
                                bVar2.aZB = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.aZu.remove(action);
                        }
                    }
                }
            }
        }
    }

    public final boolean i(Intent intent) {
        int i;
        String str;
        ArrayList arrayList;
        ArrayList<b> arrayList2;
        String str2;
        synchronized (this.aZt) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.aZs.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("KsLocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<b> arrayList3 = this.aZu.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v("KsLocalBroadcastManager", "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    b bVar = arrayList3.get(i2);
                    if (z) {
                        Log.v("KsLocalBroadcastManager", "Matching against filter " + bVar.filter);
                    }
                    if (bVar.aZA) {
                        if (z) {
                            Log.v("KsLocalBroadcastManager", "  Filter's target already added");
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
                        int iMatch = bVar.filter.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (iMatch >= 0) {
                            if (z) {
                                Log.v("KsLocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(bVar);
                            bVar.aZA = true;
                            i2 = i + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            strResolveTypeIfNeeded = str2;
                        } else if (z) {
                            Log.v("KsLocalBroadcastManager", "  Filter did not match: " + (iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
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
                        ((b) arrayList5.get(i3)).aZA = false;
                    }
                    this.aZv.add(new a(intent, arrayList5));
                    if (!this.iK.hasMessages(1)) {
                        this.iK.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    final void Qd() {
        int size;
        a[] aVarArr;
        while (true) {
            synchronized (this.aZt) {
                size = this.aZv.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new a[size];
                this.aZv.toArray(aVarArr);
                this.aZv.clear();
            }
            for (int i = 0; i < size; i++) {
                a aVar = aVarArr[i];
                int size2 = aVar.aZy.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    b bVar = aVar.aZy.get(i2);
                    if (!bVar.aZB) {
                        bVar.aZz.onReceive(this.aZs, aVar.intent);
                    }
                }
            }
        }
    }
}
