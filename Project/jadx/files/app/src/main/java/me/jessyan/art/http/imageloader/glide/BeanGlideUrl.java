package me.jessyan.art.http.imageloader.glide;

import com.bumptech.glide.load.j.g;
import com.bumptech.glide.load.j.h;
import com.bumptech.glide.load.j.j;
import me.jessyan.art.entity.GlideBean;

/* JADX INFO: loaded from: classes3.dex */
class BeanGlideUrl extends g {
    /* JADX WARN: Illegal instructions before constructor call */
    BeanGlideUrl(String str, GlideBean glideBean) {
        h hVarA;
        if (glideBean == null) {
            hVarA = h.a;
        } else {
            j.a aVar = new j.a();
            aVar.a(GlideConstant.COMIC_ID, glideBean.getId() + "");
            aVar.a(GlideConstant.ENCRYPT_INFO, glideBean.getEncrypt_info());
            aVar.a(GlideConstant.ENCRYPT_TYPE, glideBean.getEncrypt_type() + "");
            hVarA = aVar.a();
        }
        super(str, hVarA);
    }
}
