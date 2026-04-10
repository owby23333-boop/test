package com.yuewen;

import com.duokan.kernel.epublib.DkeResourceDescriptor;
import com.duokan.reader.domain.document.epub.EpubResourceType;

/* JADX INFO: loaded from: classes3.dex */
public class ly0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EpubResourceType f14228b;
    public final String c;
    public final String d;
    public final long e;
    public final String f;
    public final String g;
    public final long h;
    public final boolean i;

    public ly0(DkeResourceDescriptor dkeResourceDescriptor) {
        int i = dkeResourceDescriptor.resourceType;
        if (i == 0) {
            this.f14228b = EpubResourceType.STRUCT;
        } else if (i == 1) {
            this.f14228b = EpubResourceType.TEXT;
        } else if (i == 2) {
            this.f14228b = EpubResourceType.IMAGE;
        } else if (i == 3) {
            this.f14228b = EpubResourceType.FONT;
        } else if (i != 4) {
            this.f14228b = EpubResourceType.UNKNOWN;
        } else {
            this.f14228b = EpubResourceType.MEDIA;
        }
        this.f14227a = dkeResourceDescriptor.packUri;
        this.c = dkeResourceDescriptor.resourceUri;
        this.d = dkeResourceDescriptor.resourceMd5;
        this.e = dkeResourceDescriptor.resourceSize;
        this.f = dkeResourceDescriptor.lowQualityUri;
        this.g = dkeResourceDescriptor.lowQualityMd5;
        this.h = dkeResourceDescriptor.lowQualitySize;
        this.i = dkeResourceDescriptor.hasDrm;
    }

    public boolean a() {
        EpubResourceType epubResourceType = this.f14228b;
        return epubResourceType == EpubResourceType.TEXT || epubResourceType == EpubResourceType.FONT || epubResourceType == EpubResourceType.STRUCT;
    }

    public boolean b() {
        EpubResourceType epubResourceType = this.f14228b;
        return epubResourceType == EpubResourceType.IMAGE || epubResourceType == EpubResourceType.MEDIA || epubResourceType == EpubResourceType.UNKNOWN;
    }

    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            return this.f14227a.equals(((ly0) obj).f14227a);
        }
        return false;
    }

    public int hashCode() {
        return this.f14227a.hashCode();
    }
}
