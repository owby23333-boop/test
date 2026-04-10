package com.kwad.sdk.e.kwai;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ba;

/* JADX INFO: loaded from: classes3.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {
    public String asH;
    public String asI;
    public String asJ;
    public long asK;
    public String asL;
    public boolean asM;
    public int loadType;
    public int packageType;
    public String packageUrl;
    public String version;

    public final long AK() {
        return this.asK;
    }

    public final void aa(long j2) {
        this.asK = j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (ba.isEquals(this.asH, bVar.asH) && ba.isEquals(this.asL, bVar.asL) && ba.isEquals(this.version, bVar.version)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.asH);
        sb.append("_");
        sb.append(this.asL);
        sb.append("_");
        sb.append(this.version);
        return TextUtils.isEmpty(sb.toString()) ? super.hashCode() : sb.toString().hashCode();
    }

    public final boolean isValid() {
        return (TextUtils.isEmpty(this.asH) || TextUtils.isEmpty(this.packageUrl) || TextUtils.isEmpty(this.version) || TextUtils.isEmpty(this.asI)) ? false : true;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    @NonNull
    public String toString() {
        return "PackageInfoBean{packageId='" + this.asH + "', zipFileName='" + this.asI + "', zipPath='" + this.asJ + "', startDownloadTime=" + this.asK + ", packageUrl='" + this.packageUrl + "', version='" + this.version + "', checksum='" + this.asL + "', loadType=" + this.loadType + ", packageType=" + this.packageType + ", isPublic=" + this.asM + '}';
    }
}
