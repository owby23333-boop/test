package com.kwad.sdk.h.a;

import android.text.TextUtils;
import com.kwad.sdk.utils.bp;

/* JADX INFO: loaded from: classes4.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public String aRp;
    public String aRq;
    public String aRr;
    public long aRs;
    public boolean aRt;
    public String ard;
    public int loadType;
    public int packageType;
    public String packageUrl;
    public String version;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (bp.isEquals(this.aRp, bVar.aRp) && bp.isEquals(this.ard, bVar.ard) && bp.isEquals(this.version, bVar.version)) {
                return true;
            }
        }
        return false;
    }

    public final long Mu() {
        return this.aRs;
    }

    public final void aQ(long j) {
        this.aRs = j;
    }

    public int hashCode() {
        StringBuilder sbAppend = new StringBuilder().append(this.aRp).append("_").append(this.ard).append("_").append(this.version);
        return TextUtils.isEmpty(sbAppend.toString()) ? super.hashCode() : sbAppend.toString().hashCode();
    }

    @Override // com.kwad.sdk.core.response.a.a
    public String toString() {
        return "PackageInfoBean{packageId='" + this.aRp + "', zipFileName='" + this.aRq + "', zipPath='" + this.aRr + "', startDownloadTime=" + this.aRs + ", packageUrl='" + this.packageUrl + "', version='" + this.version + "', checksum='" + this.ard + "', loadType=" + this.loadType + ", packageType=" + this.packageType + ", isPublic=" + this.aRt + '}';
    }

    public final boolean isValid() {
        return (TextUtils.isEmpty(this.aRp) || TextUtils.isEmpty(this.packageUrl) || TextUtils.isEmpty(this.version) || TextUtils.isEmpty(this.aRq)) ? false : true;
    }
}
