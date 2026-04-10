package me.jessyan.art.http.imageloader.glide;

import com.bumptech.glide.load.j.g;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class CommonGlideUrl extends g {
    private String mUrl;

    CommonGlideUrl(String str) {
        super(str);
        this.mUrl = str;
    }

    @Override // com.bumptech.glide.load.j.g
    public String getCacheKey() {
        return getPath(this.mUrl);
    }

    public String getPath(String str) {
        try {
            return new URL(str).getPath();
        } catch (Exception unused) {
            return str;
        }
    }
}
