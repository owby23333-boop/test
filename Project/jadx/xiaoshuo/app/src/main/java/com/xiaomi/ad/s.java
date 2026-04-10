package com.xiaomi.ad;

import android.text.TextUtils;
import com.xiaomi.ad.common.util.MLog;
import com.xiaomi.ad.common.util.SignatureUtils;
import com.xiaomi.ad.mediation.DspNameConstant;
import com.xiaomi.ad.mediation.internal.DspWeight;
import com.xiaomi.ad.p;
import com.xiaomi.ad.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes5.dex */
public class s<T extends p> {
    public static final String j = "AdCacheItem";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7287a;
    public boolean e = false;
    public List<T> f = new ArrayList();
    public Map<String, Integer> g = new HashMap();
    public List<T> h = new ArrayList();
    public w i = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TreeMap<String, List<T>> f7288b = new TreeMap<>(new d(x.f().a()));
    public u c = new u(this);
    public r d = new r(this);

    public class a implements w {
        public a() {
        }

        @Override // com.xiaomi.ad.w
        public void a(v vVar) {
            String str;
            v vVarA = x.f().a();
            if (vVarA == null || vVar == null) {
                str = "mediation currentconfig and changeConfig is null";
            } else {
                v.b bVarB = vVarA.b(s.this.f7287a);
                v.b bVarB2 = vVar.b(s.this.f7287a);
                if (vVarA.a(bVarB, bVarB2)) {
                    if (bVarB == null) {
                        s.this.a();
                        MLog.d(s.j, "current  mediation config  tagid data is null , clear cache data");
                    }
                    str = "mediation config dsp priority don't change";
                } else if (bVarB2 != null) {
                    MLog.d(s.j, "mediation config dsp priority change will resort");
                    s.this.a(vVar);
                    return;
                } else {
                    s.this.a();
                    str = "current changed mediation config  tagid data is null , clear cache data";
                }
            }
            MLog.d(s.j, str);
        }
    }

    public class b implements Comparator<T> {
        public b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(T t, T t2) {
            return Integer.compare(t2.getWeight(), t.getWeight());
        }
    }

    public class c implements Comparator<T> {
        public c() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(T t, T t2) {
            return Integer.compare(t2.getWeight(), t.getWeight());
        }
    }

    public class d implements Comparator<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public v f7292a;

        public d(v vVar) {
            this.f7292a = vVar;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            v vVar = this.f7292a;
            if (vVar == null) {
                return str.compareTo(str2);
            }
            int iB = vVar.b(s.this.f7287a, str);
            int iB2 = this.f7292a.b(s.this.f7287a, str2);
            return iB == iB2 ? Integer.compare(this.f7292a.a(s.this.f7287a, str), this.f7292a.a(s.this.f7287a, str2)) : Integer.compare(iB2, iB);
        }
    }

    public s(String str) {
        this.f7287a = str;
        x.f().a(this.i);
    }

    public int a(String str) {
        List<T> list = this.f7288b.get(str);
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void b() {
        Iterator<String> it = this.f7288b.navigableKeySet().iterator();
        while (it.hasNext()) {
            List<T> list = this.f7288b.get(it.next());
            if (list != null && list.size() > 0) {
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    if (it2.next().isExpired()) {
                        it2.remove();
                    }
                }
            }
        }
        MLog.d(j, "clean ExpiredAd  TagId = " + e() + SignatureUtils.DELIMITER + c());
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("remaining ad :\n");
        for (String str : this.f7288b.navigableKeySet()) {
            List<T> list = this.f7288b.get(str);
            stringBuffer.append("dps-> ");
            stringBuffer.append(str);
            if (list != null) {
                stringBuffer.append("  remaining ad size ");
                stringBuffer.append(list.size());
                stringBuffer.append(" weight: ");
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next().getWeight() + " ");
                }
            } else {
                stringBuffer.append("  remaining ad size 0");
            }
            stringBuffer.append(SignatureUtils.DELIMITER);
        }
        return stringBuffer.toString();
    }

    public long d() {
        Iterator<String> it = this.f7288b.navigableKeySet().iterator();
        long expireTime = 0;
        while (it.hasNext()) {
            List<T> list = this.f7288b.get(it.next());
            if (list != null && list.size() > 0) {
                for (T t : list) {
                    if (!t.isExpired()) {
                        expireTime = expireTime == 0 ? t.getExpireTime() : Math.min(expireTime, t.getExpireTime());
                    }
                }
            }
        }
        MLog.d(j, "get ad cache minExpireTime = " + expireTime);
        return expireTime;
    }

    public String e() {
        return this.f7287a;
    }

    public boolean f() {
        Iterator<String> it = this.f7288b.navigableKeySet().iterator();
        while (it.hasNext()) {
            List<T> list = this.f7288b.get(it.next());
            if (list != null && !list.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean g() {
        return this.e;
    }

    public boolean b(String str) {
        if (this.f7288b.get(str) == null) {
            return false;
        }
        return !r2.isEmpty();
    }

    public List<T> a(int i) {
        MLog.d(j, "current get ad count = " + i);
        ArrayList arrayList = new ArrayList();
        if (this.e) {
            a(i, arrayList);
        } else {
            MLog.d(j, "isBid is false");
            Iterator<String> it = this.f7288b.navigableKeySet().iterator();
            while (it.hasNext()) {
                List<T> listA = a(it.next(), i);
                if (listA != null) {
                    arrayList.addAll(listA);
                    i -= listA.size();
                    if (i <= 0) {
                        break;
                    }
                }
            }
        }
        MLog.d(j, "cuttent return ad size " + arrayList.size() + SignatureUtils.DELIMITER + c());
        for (T t : arrayList) {
            MLog.d(j, "dspName: " + t.getDspName() + ", weight: " + t.getWeight());
        }
        this.c.a();
        return arrayList;
    }

    public List<T> a(String str, int i) {
        ArrayList arrayList;
        List<T> listSubList = this.f7288b.get(str);
        if (listSubList == null) {
            return null;
        }
        if (i > listSubList.size()) {
            arrayList = new ArrayList(listSubList);
        } else {
            listSubList = listSubList.subList(0, i);
            arrayList = new ArrayList(listSubList);
        }
        listSubList.clear();
        return arrayList;
    }

    public void a() {
        if (this.f7288b.size() > 0) {
            this.f7288b.clear();
        }
    }

    public void a(int i, String str) {
        Iterator<String> it = this.f7288b.navigableKeySet().iterator();
        while (it.hasNext() && this.h.size() != 0) {
            Iterator<T> it2 = this.f7288b.get(it.next()).iterator();
            while (it2.hasNext() && this.h.size() != 0) {
                T next = it2.next();
                Iterator<T> it3 = this.h.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        T next2 = it3.next();
                        if (TextUtils.equals(next.getAdId(), next2.getAdId())) {
                            it2.remove();
                            this.h.remove(next2);
                            break;
                        }
                    }
                }
            }
        }
        List<T> list = this.f7288b.get(str);
        if (list != null && list.size() > i) {
            Collections.sort(list, new c());
            list.subList(i, list.size()).clear();
        }
        MLog.d(j, "bid clean finish and " + c());
    }

    private void a(int i, List<T> list) {
        boolean z;
        String next;
        MLog.d(j, "fetchBidAds");
        NavigableSet<String> navigableSetNavigableKeySet = this.f7288b.navigableKeySet();
        Iterator<String> it = navigableSetNavigableKeySet.iterator();
        this.f.clear();
        String str = "";
        while (true) {
            int iB = 0;
            if (!it.hasNext()) {
                z = false;
                break;
            }
            next = it.next();
            List<T> list2 = this.f7288b.get(next);
            if (!next.contains(DspNameConstant.DSP_XIAOMI)) {
                if (this.g.containsKey(next)) {
                    iB = this.g.get(next).intValue();
                } else {
                    v vVarA = x.f().a();
                    if (vVarA != null) {
                        iB = vVarA.b(this.f7287a, next);
                    }
                }
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    it2.next().setWeight(iB);
                }
            } else if (list2 == null || list2.isEmpty()) {
                break;
            } else {
                str = next;
            }
            this.f.addAll(list2);
        }
        str = next;
        z = true;
        if (!(TextUtils.isEmpty(str) ? true : z)) {
            Collections.sort(this.f, new b());
            List<T> list3 = this.f;
            list.addAll(list3.subList(0, i > list3.size() ? this.f.size() : i));
            this.h.clear();
            this.h.addAll(list);
            this.g.clear();
            this.d.a(i, str);
            return;
        }
        Iterator<String> it3 = navigableSetNavigableKeySet.iterator();
        while (it3.hasNext()) {
            List<T> listA = a(it3.next(), i);
            if (listA != null) {
                list.addAll(listA);
                i -= listA.size();
                if (i <= 0) {
                    return;
                }
            }
        }
    }

    public void a(v vVar) {
        TreeMap<String, List<T>> treeMap = new TreeMap<>(new d(vVar));
        treeMap.putAll(this.f7288b);
        this.f7288b = treeMap;
        MLog.d(j, "mediation config dsp priority resort sucess");
        c();
    }

    public void a(String str, List<T> list) {
        List<T> list2 = this.f7288b.get(str);
        if (list2 != null) {
            list2.addAll(list);
        } else {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            this.f7288b.put(str, linkedList);
        }
        MLog.d(j, "add ad to adcache  -->" + str + " add ad size = " + list.size() + SignatureUtils.DELIMITER + c());
        this.c.a();
    }

    public void a(List<DspWeight> list) {
        for (DspWeight dspWeight : list) {
            this.g.put(dspWeight.getDsp(), Integer.valueOf(dspWeight.getWeight()));
        }
    }

    public void a(boolean z) {
        this.e = z;
    }
}
