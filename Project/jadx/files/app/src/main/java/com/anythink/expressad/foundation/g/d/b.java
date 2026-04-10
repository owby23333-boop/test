package com.anythink.expressad.foundation.g.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.anythink.expressad.foundation.g.d.d;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.s;
import com.anythink.expressad.foundation.h.t;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String a = "ImageLoader";
    private static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f10489c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10490d = "message_key";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f10491e = "message_bitmap";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f10492f = "message_message";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static b f10493g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.anythink.expressad.foundation.g.g.c f10494h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private LinkedHashMap<String, List<c>> f10496j = new LinkedHashMap<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Handler f10497k = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.foundation.g.d.b.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                if (message.what == 1) {
                    String string = message.getData().getString(b.f10490d);
                    Bitmap bitmapA = a.a(message.getData().getString(b.f10491e));
                    b.this.a(string, bitmapA);
                    LinkedList<c> linkedList = (LinkedList) b.this.f10496j.get(string);
                    if (linkedList != null) {
                        for (c cVar : linkedList) {
                            if (cVar != null) {
                                cVar.a(bitmapA, string);
                            }
                        }
                    }
                    b.this.f10496j.remove(string);
                    return;
                }
                if (message.what == 2) {
                    String string2 = message.getData().getString(b.f10490d);
                    String string3 = message.getData().getString(b.f10492f);
                    LinkedList<c> linkedList2 = (LinkedList) b.this.f10496j.get(string2);
                    if (linkedList2 != null) {
                        for (c cVar2 : linkedList2) {
                            if (cVar2 != null) {
                                cVar2.a(string3, string2);
                            }
                        }
                    }
                    b.this.f10496j.remove(string2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.anythink.expressad.foundation.g.a.e<String, Bitmap> f10495i = new com.anythink.expressad.foundation.g.a.c(((int) Runtime.getRuntime().maxMemory()) / 5);

    private b(Context context) {
        this.f10494h = new com.anythink.expressad.foundation.g.g.c(context);
    }

    private Bitmap d(String str) {
        Bitmap bitmapA;
        if (t.a(str)) {
            return null;
        }
        String strA = s.a(str);
        File file = new File(strA);
        if (a(str) != null) {
            return a(str);
        }
        if (!file.exists() || (bitmapA = a.a(strA)) == null) {
            return null;
        }
        a(str, bitmapA);
        return bitmapA;
    }

    public final void c(String str) {
        try {
            if (this.f10495i == null || !this.f10495i.a().contains(str)) {
                return;
            }
            this.f10495i.a(str);
        } catch (Throwable th) {
            o.d(a, th.getMessage());
        }
    }

    private void b() {
        this.f10495i.b();
        LinkedHashMap<String, List<c>> linkedHashMap = this.f10496j;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
    }

    public final void a(String str, Bitmap bitmap) {
        if (a(str) != null || bitmap == null) {
            return;
        }
        this.f10495i.a(str, bitmap);
    }

    public final Bitmap a(String str) {
        return this.f10495i.b(str);
    }

    public static b a(Context context) {
        if (f10493g == null) {
            f10493g = new b(context);
        }
        return f10493g;
    }

    private void c() {
        com.anythink.expressad.foundation.g.a.e<String, Bitmap> eVar = this.f10495i;
        if (eVar != null) {
            eVar.b();
        }
    }

    public final boolean b(String str) {
        if (t.a(str)) {
            return false;
        }
        return a(str) != null || new File(s.a(str)).exists();
    }

    public static void a() {
        com.anythink.expressad.foundation.g.a.e<String, Bitmap> eVar = f10493g.f10495i;
        if (eVar != null) {
            eVar.b();
        }
    }

    private void b(String str, String str2, String str3, c cVar) {
        if (t.a(str) || t.a(str2) || t.a(str3)) {
            return;
        }
        File file = new File(str3);
        Bitmap bitmapA = a(str2);
        if (bitmapA != null && !bitmapA.isRecycled()) {
            cVar.a(bitmapA, str);
            return;
        }
        if (file.exists()) {
            Bitmap bitmapA2 = a.a(str3);
            if (bitmapA2 != null && !bitmapA2.isRecycled()) {
                a(str2, bitmapA2);
                cVar.a(bitmapA2, str);
                return;
            } else {
                a(str, str2, str3, true, cVar);
                return;
            }
        }
        a(str, str2, str3, false, cVar);
    }

    public final void a(String str, c cVar) {
        b(str, str, s.a(str), cVar);
    }

    private void a(String str, String str2, String str3, c cVar) {
        b(str, str2, str3, cVar);
    }

    private void a(String str, String str2, String str3, boolean z2, c cVar) {
        if (!this.f10496j.containsKey(str2)) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(cVar);
            this.f10496j.put(str2, linkedList);
            this.f10494h.a(a(str, str2, str3, z2));
            return;
        }
        LinkedList linkedList2 = (LinkedList) this.f10496j.get(str2);
        if (linkedList2 == null || linkedList2.contains(cVar)) {
            return;
        }
        linkedList2.add(cVar);
    }

    private d a(String str, String str2, String str3, boolean z2) {
        d.a aVar = new d.a() { // from class: com.anythink.expressad.foundation.g.d.b.2
            @Override // com.anythink.expressad.foundation.g.d.d.a
            public final void a(String str4, String str5) {
                Message messageObtainMessage = b.this.f10497k.obtainMessage();
                messageObtainMessage.what = 1;
                Bundle bundle = new Bundle();
                bundle.putString(b.f10490d, str4);
                bundle.putString(b.f10491e, str5);
                messageObtainMessage.setData(bundle);
                b.this.f10497k.sendMessage(messageObtainMessage);
            }

            @Override // com.anythink.expressad.foundation.g.d.d.a
            public final void b(String str4, String str5) {
                Message messageObtainMessage = b.this.f10497k.obtainMessage();
                messageObtainMessage.what = 2;
                Bundle bundle = new Bundle();
                bundle.putString(b.f10490d, str4);
                bundle.putString(b.f10492f, str5);
                messageObtainMessage.setData(bundle);
                b.this.f10497k.sendMessage(messageObtainMessage);
            }
        };
        d dVar = new d(str, str2, str3);
        dVar.a(z2);
        dVar.a(aVar);
        return dVar;
    }
}
