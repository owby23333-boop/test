package com.duokan.reader.domain.cloud;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.duokan.reader.BaseEnv;
import com.yuewen.c04;
import com.yuewen.er1;
import com.yuewen.n50;
import com.yuewen.rv1;
import com.yuewen.xl3;
import com.yuewen.yd;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DkSharedStorageManager implements xl3 {
    public static final String c = "2";
    public static final String d = "3";
    public static final String e = "4";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final yd f4665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<SharedKey, List<d>> f4666b;

    public enum SharedKey {
        USER_PRIVILEGE("/store/v0/time_limited/get"),
        COUPON_COUNT("/store/v0/coupon/list"),
        USER_FAV_COUNT("USER_FAV_COUNT"),
        USER_RECOMMEND_COUNT("USER_RECOMMEND_COUNT"),
        USER_READ_COUNT("USER_READ_COUNT"),
        CART_CACHE("cart_cache"),
        USER_VIP_STATUS("vip_status"),
        COUPONS_CACHE("coupons_cache"),
        COUPONS_DOT_SHOW("mine__ticket-dot_show"),
        DISALLOW_CHECK_GUIDE_READ("disallow_check_guide_read"),
        FREE_TAG_LIST("free-tag-list"),
        FREE_DISPLAY_TAG_LIST("free-display-tag-list"),
        CHECK_IN_LAYER_LIMITED_TIMESTAMP("check_in_layer_limited_timestamp"),
        HAS_CHECK_IN_WATCH_VIDEO("has_check_in_watch_video"),
        NEW_USER_TYPE("new_user_type"),
        TODAY_NEW_USER_TYPE("today_new_user_type"),
        ADD_BOOKSHELF_FOR_GOLD_COIN("add_bookshelf_for_gold_coin");

        String mUrl;

        SharedKey(String str) {
            this.mUrl = str;
        }

        public static SharedKey value(String str) {
            SharedKey[] sharedKeyArrValues = values();
            for (int i = 0; i < sharedKeyArrValues.length; i++) {
                if (TextUtils.equals(sharedKeyArrValues[i].mUrl, str)) {
                    return sharedKeyArrValues[i];
                }
            }
            throw new RuntimeException("no such key");
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f4667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SharedKey f4668b;
        public final /* synthetic */ Serializable c;

        public a(List list, SharedKey sharedKey, Serializable serializable) {
            this.f4667a = list;
            this.f4668b = sharedKey;
            this.c = serializable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f4667a.iterator();
            while (it.hasNext()) {
                ((d) it.next()).d(this.f4668b, this.c);
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f4669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SharedKey f4670b;

        public b(List list, SharedKey sharedKey) {
            this.f4669a = list;
            this.f4670b = sharedKey;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f4669a.iterator();
            while (it.hasNext()) {
                ((d) it.next()).e(this.f4670b);
            }
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static DkSharedStorageManager f4671a = new DkSharedStorageManager(BaseEnv.get());
    }

    public interface d {
        void d(SharedKey sharedKey, Serializable serializable);

        void e(SharedKey sharedKey);
    }

    public static DkSharedStorageManager f() {
        return c.f4671a;
    }

    public final void a(SharedKey sharedKey, d dVar) {
        List<d> linkedList = this.f4666b.get(sharedKey);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.f4666b.put(sharedKey, linkedList);
        }
        linkedList.add(dVar);
    }

    public void b(d dVar, @NonNull SharedKey... sharedKeyArr) {
        er1.b(sharedKeyArr, "keys not allow null !!!");
        for (SharedKey sharedKey : sharedKeyArr) {
            a(sharedKey, dVar);
        }
    }

    public final boolean c(String str, String str2) {
        try {
            return new JSONObject(str).optJSONObject("__data__").equals(new JSONObject(str2).optJSONObject("__data__"));
        } catch (Exception unused) {
            return false;
        }
    }

    public void d(SharedKey sharedKey) {
        try {
            e(sharedKey.mUrl);
        } catch (Exception unused) {
        }
    }

    public void e(String str) {
        try {
            m(SharedKey.value(str));
        } catch (Exception unused) {
        }
        this.f4665a.L(str);
    }

    public String g() {
        return j(SharedKey.TODAY_NEW_USER_TYPE);
    }

    public String h() {
        String strJ = j(SharedKey.NEW_USER_TYPE);
        if (TextUtils.isEmpty(strJ) || TextUtils.equals(strJ, "2")) {
            strJ = "3";
        }
        q(strJ);
        return strJ;
    }

    public int i() {
        return n50.p(h(), 2);
    }

    public String j(SharedKey sharedKey) {
        try {
            return k(sharedKey.mUrl);
        } catch (Exception unused) {
            return "";
        }
    }

    public String k(String str) {
        Serializable serializableB0 = this.f4665a.b0(str);
        return serializableB0 == null ? "" : (String) serializableB0;
    }

    public final void l(SharedKey sharedKey, Serializable serializable) {
        List<d> list = this.f4666b.get(sharedKey);
        if (list != null) {
            rv1.k(new a(list, sharedKey, serializable));
        }
    }

    public final void m(SharedKey sharedKey) {
        List<d> list = this.f4666b.get(sharedKey);
        if (list != null) {
            rv1.k(new b(list, sharedKey));
        }
    }

    public void o(d dVar, @NonNull SharedKey... sharedKeyArr) {
        er1.b(sharedKeyArr, "keys not allow null !!!");
        for (SharedKey sharedKey : sharedKeyArr) {
            List<d> list = this.f4666b.get(sharedKey);
            if (list != null) {
                list.remove(dVar);
            }
        }
    }

    public void p() {
        u(SharedKey.ADD_BOOKSHELF_FOR_GOLD_COIN, "1", true);
    }

    public void q(String str) {
        if (BaseEnv.get().x1() != c04.p()) {
            u(SharedKey.TODAY_NEW_USER_TYPE, str, true);
            BaseEnv.get().U2();
        }
    }

    public void r(String str) {
        u(SharedKey.NEW_USER_TYPE, str, true);
        q(str);
    }

    public void s(SharedKey sharedKey, String str) {
        try {
            v(sharedKey.mUrl, str, true);
        } catch (Exception unused) {
        }
    }

    public void u(SharedKey sharedKey, String str, boolean z) {
        try {
            v(sharedKey.mUrl, str, z);
        } catch (Exception unused) {
        }
    }

    public void v(String str, String str2, boolean z) {
        Serializable serializableB0 = this.f4665a.b0(str);
        if (z) {
            this.f4665a.l0(str, str2);
        } else {
            this.f4665a.j0(str, str2);
        }
        try {
            SharedKey sharedKeyValue = SharedKey.value(str);
            if ((serializableB0 == null || !TextUtils.equals(str2, (String) serializableB0)) && !c(str2, (String) serializableB0)) {
                l(sharedKeyValue, str2);
            }
        } catch (Exception unused) {
        }
    }

    public void w() {
        SharedKey sharedKey = SharedKey.NEW_USER_TYPE;
        if (TextUtils.isEmpty(j(sharedKey))) {
            s(sharedKey, BaseEnv.get().U0());
        }
    }

    public DkSharedStorageManager(BaseEnv baseEnv) {
        this.f4666b = new HashMap<>();
        this.f4665a = new yd(Uri.fromFile(new File(baseEnv.X(), "localstorage.db")).toString());
    }
}
