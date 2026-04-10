package com.duokan.dkbookshelf.data;

import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.b;
import com.duokan.reader.domain.bookshelf.c;
import com.yuewen.o02;
import com.yuewen.rd2;
import com.yuewen.u12;
import com.yuewen.v70;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class CustomCloudItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rd2<b> f3096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3097b;
    public final CloudItemType c;

    public enum CloudItemStatus {
        CLOUD_ONLY,
        CLOUD_BOOKSHELF,
        CLOUD_DOWNLOADING,
        CLOUD_DOWNLOADED,
        LOCAL_UPLOADING,
        CONNECTING_SERVER
    }

    public enum CloudItemType {
        LOCAL,
        CLOUD
    }

    public CustomCloudItem(o02 o02Var) {
        this.f3096a = new rd2<>();
        this.f3097b = o02Var;
        this.c = CloudItemType.CLOUD;
    }

    public static List<CustomCloudItem> b(List<CustomCloudItem> list, List<v70> list2) {
        boolean z;
        if (list == null || list.size() == 0 || list2 == null || list2.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (CustomCloudItem customCloudItem : list) {
            if (customCloudItem.l()) {
                arrayList.add(customCloudItem);
            } else {
                v70 v70Var = (v70) customCloudItem.e();
                Iterator<v70> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    if (it.next().b0(v70Var)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    arrayList.add(customCloudItem);
                }
            }
        }
        return arrayList;
    }

    public static List<CustomCloudItem> c(List<CustomCloudItem> list, List<u12> list2) {
        boolean z;
        if (list == null || list.size() == 0 || list2 == null || list2.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (CustomCloudItem customCloudItem : list) {
            if (customCloudItem.l()) {
                u12 u12VarE = ((o02) customCloudItem.e()).e();
                Iterator<u12> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    if (it.next().r(u12VarE)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    arrayList.add(customCloudItem);
                }
            } else {
                arrayList.add(customCloudItem);
            }
        }
        return arrayList;
    }

    public int a(CustomCloudItem customCloudItem) {
        int iCompareTo;
        if (l()) {
            if (!customCloudItem.l()) {
                return 1;
            }
            iCompareTo = Long.valueOf(f()).compareTo(Long.valueOf(customCloudItem.f()));
        } else {
            if (customCloudItem.l()) {
                return -1;
            }
            iCompareTo = Long.valueOf(f()).compareTo(Long.valueOf(customCloudItem.f()));
        }
        return iCompareTo * (-1);
    }

    public CloudItemStatus d() {
        return k() ? CloudItemStatus.CONNECTING_SERVER : !l() ? CloudItemStatus.LOCAL_UPLOADING : i() == null ? CloudItemStatus.CLOUD_ONLY : !i().w2() ? CloudItemStatus.CLOUD_DOWNLOADED : i().j1() == BookState.CLOUD_ONLY ? CloudItemStatus.CLOUD_BOOKSHELF : i().j1() != BookState.NORMAL ? CloudItemStatus.CLOUD_DOWNLOADING : CloudItemStatus.CLOUD_DOWNLOADED;
    }

    public Object e() {
        return this.f3097b;
    }

    public long f() {
        return l() ? ((o02) this.f3097b).d() : ((v70) this.f3097b).k();
    }

    public String g() {
        return l() ? ((o02) this.f3097b).h() : ((v70) this.f3097b).L();
    }

    public long h() {
        return l() ? ((o02) this.f3097b).j() : ((v70) this.f3097b).W();
    }

    public b i() {
        if (this.c != CloudItemType.CLOUD) {
            return null;
        }
        if (!this.f3096a.hasValue()) {
            this.f3096a.setValue(c.R4().x4((o02) this.f3097b));
        }
        return this.f3096a.getValue();
    }

    public float j() {
        CloudItemStatus cloudItemStatusD = d();
        if (cloudItemStatusD == CloudItemStatus.CLOUD_DOWNLOADING && i() != null) {
            return i().Z1() / 100.0f;
        }
        if (cloudItemStatusD != CloudItemStatus.LOCAL_UPLOADING) {
            return -1.0f;
        }
        v70 v70Var = (v70) this.f3097b;
        return (v70Var.Y() * 1.0f) / v70Var.W();
    }

    public boolean k() {
        if (l()) {
            return ((o02) this.f3097b).k();
        }
        return false;
    }

    public boolean l() {
        return this.c == CloudItemType.CLOUD;
    }

    public void m(b bVar) {
        this.f3096a.setValue(bVar);
    }

    public void n(boolean z) {
        if (l()) {
            ((o02) this.f3097b).l(z);
        }
    }

    public CustomCloudItem(v70 v70Var) {
        this.f3096a = new rd2<>();
        this.f3097b = v70Var;
        this.c = CloudItemType.LOCAL;
    }
}
