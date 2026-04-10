package com.bykv.vk.openvk.component.video.z.z.z;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.dl.a;
import com.bytedance.sdk.component.utils.wp;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class z implements com.bykv.vk.openvk.component.video.api.z.g {
    private String z = "video_reward_full";
    private String g = "video_brand";
    private String dl = "video_splash";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f124a = "video_default";
    private String gc = null;
    private String m = null;
    private String e = null;
    private String gz = null;
    private String fo = null;

    @Override // com.bykv.vk.openvk.component.video.api.z.g
    public void z(String str) {
        this.gc = str;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z.g
    public String a() {
        if (this.fo == null) {
            this.fo = this.gc + File.separator + this.f124a;
            File file = new File(this.fo);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.fo;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z.g
    public String z() {
        if (this.m == null) {
            this.m = this.gc + File.separator + this.z;
            File file = new File(this.m);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.m;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z.g
    public String g() {
        if (this.e == null) {
            this.e = this.gc + File.separator + this.g;
            File file = new File(this.e);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.e;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z.g
    public String dl() {
        if (this.gz == null) {
            this.gz = this.gc + File.separator + this.dl;
            File file = new File(this.gz);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.gz;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z.g
    public synchronized void gc() {
        com.bykv.vk.openvk.component.video.api.m.dl.z("Exec clear video cache ");
        com.bykv.vk.openvk.component.video.api.m.dl.z(this.gc);
        Set<String> setE = null;
        for (com.bykv.vk.openvk.component.video.api.z.z zVar : m()) {
            File[] fileArrZ = zVar.z();
            if (fileArrZ != null && fileArrZ.length >= zVar.g()) {
                if (setE == null) {
                    setE = e();
                }
                int iG = zVar.g() - 2;
                if (iG < 0) {
                    iG = 0;
                }
                z(zVar.z(), iG, setE);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z.g
    public boolean z(a aVar) {
        if (TextUtils.isEmpty(aVar.gc()) || TextUtils.isEmpty(aVar.p())) {
            return false;
        }
        return new File(aVar.gc(), aVar.p()).exists();
    }

    @Override // com.bykv.vk.openvk.component.video.api.z.g
    public long g(a aVar) {
        if (TextUtils.isEmpty(aVar.gc()) || TextUtils.isEmpty(aVar.p())) {
            return 0L;
        }
        return com.bykv.vk.openvk.component.video.z.gc.dl.z(aVar.gc(), aVar.p());
    }

    private static void z(File[] fileArr, int i, Set<String> set) {
        if (i >= 0 && fileArr != null) {
            try {
                if (fileArr.length > i) {
                    List listAsList = Arrays.asList(fileArr);
                    Collections.sort(listAsList, new Comparator<File>() { // from class: com.bykv.vk.openvk.component.video.z.z.z.z.1
                        @Override // java.util.Comparator
                        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
                        public int compare(File file, File file2) {
                            long jLastModified = file2.lastModified() - file.lastModified();
                            if (jLastModified == 0) {
                                return 0;
                            }
                            return jLastModified < 0 ? -1 : 1;
                        }
                    });
                    while (i < listAsList.size()) {
                        File file = (File) listAsList.get(i);
                        if (set != null && !set.contains(file.getAbsolutePath())) {
                            ((File) listAsList.get(i)).delete();
                        }
                        i++;
                    }
                }
            } catch (Throwable th) {
                wp.z(th);
            }
        }
    }

    private List<com.bykv.vk.openvk.component.video.api.z.z> m() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.bykv.vk.openvk.component.video.api.z.z(new File(z()).listFiles(), com.bykv.vk.openvk.component.video.z.z.dl()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.z.z(new File(dl()).listFiles(), com.bykv.vk.openvk.component.video.z.z.g()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.z.z(new File(g()).listFiles(), com.bykv.vk.openvk.component.video.z.z.a()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.z.z(new File(a()).listFiles(), com.bykv.vk.openvk.component.video.z.z.gc()));
        return arrayList;
    }

    private Set<String> e() {
        HashSet hashSet = new HashSet();
        for (com.bykv.vk.openvk.component.video.z.z.z zVar : com.bykv.vk.openvk.component.video.z.z.z.z.values()) {
            if (zVar != null && zVar.z() != null) {
                a aVarZ = zVar.z();
                hashSet.add(com.bykv.vk.openvk.component.video.z.gc.dl.g(aVarZ.gc(), aVarZ.p()).getAbsolutePath());
                hashSet.add(com.bykv.vk.openvk.component.video.z.gc.dl.dl(aVarZ.gc(), aVarZ.p()).getAbsolutePath());
            }
        }
        for (com.bykv.vk.openvk.component.video.z.z.g.g gVar : com.bykv.vk.openvk.component.video.z.z.g.dl.z.values()) {
            if (gVar != null && gVar.z() != null) {
                a aVarZ2 = gVar.z();
                hashSet.add(com.bykv.vk.openvk.component.video.z.gc.dl.g(aVarZ2.gc(), aVarZ2.p()).getAbsolutePath());
                hashSet.add(com.bykv.vk.openvk.component.video.z.gc.dl.dl(aVarZ2.gc(), aVarZ2.p()).getAbsolutePath());
            }
        }
        return hashSet;
    }
}
