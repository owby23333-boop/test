package com.anythink.core.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class m {
    static final int a = 1;
    private static final String b = "InnerBroadcastManager";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f7824c = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Object f7825i = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static m f7826j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f7827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap<BroadcastReceiver, ArrayList<b>> f7828e = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashMap<String, ArrayList<b>> f7829f = new HashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayList<a> f7830g = new ArrayList<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Handler f7831h;

    private static final class a {
        final Intent a;
        final ArrayList<b> b;

        a(Intent intent, ArrayList<b> arrayList) {
            this.a = intent;
            this.b = arrayList;
        }
    }

    private static final class b {
        final IntentFilter a;
        final BroadcastReceiver b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f7832c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f7833d;

        b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.a = intentFilter;
            this.b = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.a);
            if (this.f7833d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private m(Context context) {
        this.f7827d = context;
        this.f7831h = new Handler(context.getMainLooper()) { // from class: com.anythink.core.common.m.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    m.this.a();
                }
            }
        };
    }

    public static m a(Context context) {
        m mVar;
        synchronized (f7825i) {
            if (f7826j == null) {
                f7826j = new m(context.getApplicationContext());
            }
            mVar = f7826j;
        }
        return mVar;
    }

    private void b(Intent intent) {
        if (a(intent)) {
            a();
        }
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f7828e) {
            b bVar = new b(intentFilter, broadcastReceiver);
            ArrayList<b> arrayList = this.f7828e.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f7828e.put(broadcastReceiver, arrayList);
            }
            arrayList.add(bVar);
            for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                String action = intentFilter.getAction(i2);
                ArrayList<b> arrayList2 = this.f7829f.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f7829f.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    public final void a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f7828e) {
            ArrayList<b> arrayListRemove = this.f7828e.remove(broadcastReceiver);
            if (arrayListRemove != null) {
                for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                    b bVar = arrayListRemove.get(size);
                    bVar.f7833d = true;
                    for (int i2 = 0; i2 < bVar.a.countActions(); i2++) {
                        String action = bVar.a.getAction(i2);
                        ArrayList<b> arrayList = this.f7829f.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                b bVar2 = arrayList.get(size2);
                                if (bVar2.b == broadcastReceiver) {
                                    bVar2.f7833d = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.f7829f.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    public final boolean a(Intent intent) {
        String str;
        ArrayList arrayList;
        int i2;
        ArrayList<b> arrayList2;
        String str2;
        synchronized (this.f7828e) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f7827d.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z2 = (intent.getFlags() & 8) != 0;
            if (z2) {
                String str3 = "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent;
            }
            ArrayList<b> arrayList3 = this.f7829f.get(intent.getAction());
            if (arrayList3 != null) {
                if (z2) {
                    "Action list: ".concat(String.valueOf(arrayList3));
                }
                ArrayList arrayList4 = null;
                int i3 = 0;
                while (i3 < arrayList3.size()) {
                    b bVar = arrayList3.get(i3);
                    if (z2) {
                        String str4 = "Matching against filter " + bVar.a;
                    }
                    if (bVar.f7832c) {
                        i2 = i3;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = strResolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        str = action;
                        arrayList = arrayList4;
                        i2 = i3;
                        arrayList2 = arrayList3;
                        str2 = strResolveTypeIfNeeded;
                        int iMatch = bVar.a.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (iMatch >= 0) {
                            if (z2) {
                                String str5 = "  Filter matched!  match=0x" + Integer.toHexString(iMatch);
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(bVar);
                            bVar.f7832c = true;
                            i3 = i2 + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            strResolveTypeIfNeeded = str2;
                        } else if (z2) {
                            "  Filter did not match: ".concat(iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : "type" : "data" : NativeAdvancedJsUtils.f8246p : "category");
                        }
                    }
                    arrayList4 = arrayList;
                    i3 = i2 + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    strResolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i4 = 0; i4 < arrayList5.size(); i4++) {
                        ((b) arrayList5.get(i4)).f7832c = false;
                    }
                    this.f7830g.add(new a(intent, arrayList5));
                    if (!this.f7831h.hasMessages(1)) {
                        this.f7831h.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    final void a() {
        a[] aVarArr;
        while (true) {
            synchronized (this.f7828e) {
                int size = this.f7830g.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new a[size];
                this.f7830g.toArray(aVarArr);
                this.f7830g.clear();
            }
            for (a aVar : aVarArr) {
                int size2 = aVar.b.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    b bVar = aVar.b.get(i2);
                    if (!bVar.f7833d) {
                        bVar.b.onReceive(this.f7827d, aVar.a);
                    }
                }
            }
        }
    }
}
