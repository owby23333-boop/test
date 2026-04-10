package com.baidu.mobads.sdk.internal.a;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.internal.bq;
import com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate;
import com.baidu.mobads.sdk.internal.concrete.RVViewHolderDelegate;
import com.baidu.mobads.sdk.internal.concrete.ViewCompatDelegate;
import com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b implements com.baidu.mobads.sdk.internal.a.a {
    public static final String a = "ViewPager2";
    public static final String b = "RVAdapter";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12806c = "RVViewHolder";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12807d = "ViewCompat";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f12808e = "p_e";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f12809f = "p_init";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f12810g = "p_set_class";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f12811h = "e_t";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f12812i = "e_n";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f12813j = "e_a";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f12814k = "e_r";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f12815l = "e_d";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final IAdInterListener f12816m;

    public static class a implements IOAdEventListener {
        private com.baidu.mobads.sdk.internal.a.a a(String str, @NonNull IAdInterListener iAdInterListener, Object[] objArr) {
            if (b.a.equals(str) && b.a(objArr, (Class<?>[]) new Class[]{Context.class})) {
                return new ViewPager2Delegate(iAdInterListener, (Context) objArr[0]);
            }
            if (b.b.equals(str)) {
                return new RVAdapterDelegate(iAdInterListener);
            }
            if (b.f12806c.equals(str) && b.a(objArr, (Class<?>[]) new Class[]{View.class})) {
                return new RVViewHolderDelegate(iAdInterListener, (View) objArr[0]);
            }
            if (b.f12807d.equals(str)) {
                return new ViewCompatDelegate(iAdInterListener);
            }
            return null;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            com.baidu.mobads.sdk.internal.a.a aVarA;
            if (iOAdEvent != null) {
                try {
                    if (b.f12808e.equals(iOAdEvent.getType()) && (data = iOAdEvent.getData()) != null && !data.isEmpty()) {
                        Object obj = data.get(b.f12811h);
                        Object obj2 = data.get(b.f12812i);
                        Object obj3 = data.get(b.f12813j);
                        Object[] objArr = obj3 instanceof Object[] ? (Object[]) obj3 : null;
                        if ((obj2 instanceof String) && (obj instanceof String)) {
                            if (b.f12809f.equals((String) obj2)) {
                                Object obj4 = data.get(b.f12815l);
                                if (!(obj4 instanceof IAdInterListener) || (aVarA = a((String) obj, (IAdInterListener) obj4, objArr)) == null) {
                                    return;
                                }
                                data.put(b.f12814k, aVarA);
                                return;
                            }
                            if (b.f12810g.equals((String) obj2) && (obj3 instanceof Map)) {
                                Map map = (Map) obj3;
                                map.put(b.a, ViewPager2.class);
                                map.put(b.b, RecyclerView.Adapter.class);
                                map.put(b.f12806c, RecyclerView.ViewHolder.class);
                            }
                        }
                    }
                } catch (Throwable th) {
                    bq.a().b(th.getMessage());
                }
            }
        }
    }

    private b(@NonNull IAdInterListener iAdInterListener, @NonNull com.baidu.mobads.sdk.internal.a.a aVar) {
        this.f12816m = iAdInterListener;
        this.f12816m.addEventListener(f12808e, new c(this, aVar));
    }

    public static b a(@NonNull IAdInterListener iAdInterListener, @NonNull com.baidu.mobads.sdk.internal.a.a aVar) {
        return new b(iAdInterListener, aVar);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f12816m;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f12816m;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public final Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
    }

    public final void a(String str) {
        this.f12816m.onAdTaskProcess(str);
    }

    public final Object a(String str, Object... objArr) {
        HashMap map = new HashMap();
        map.put(f12813j, objArr);
        this.f12816m.onAdTaskProcess(str, map);
        return map.get(f12814k);
    }

    public static boolean a(Object[] objArr, Class<?>... clsArr) {
        boolean z2 = objArr == null || objArr.length == 0;
        boolean z3 = clsArr == null || clsArr.length == 0;
        if (z2 && z3) {
            return true;
        }
        if (z2 || z3 || clsArr == null || objArr == null || clsArr.length != objArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            if (!clsArr[i2].isInstance(objArr[i2])) {
                return false;
            }
        }
        return true;
    }
}
