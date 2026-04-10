package com.amgcyo.cuttadon.j.c;

import androidx.room.TypeConverter;
import com.amgcyo.cuttadon.api.entity.other.MkDataBean;
import com.amgcyo.cuttadon.utils.otherutils.r;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: compiled from: MkDataBeanConverter.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: compiled from: MkDataBeanConverter.java */
    class a extends TypeToken<MkDataBean> {
        a(c cVar) {
        }
    }

    @TypeConverter
    public MkDataBean a(String str) {
        if (str == null) {
            return null;
        }
        return (MkDataBean) r.a(str, new a(this).getType());
    }

    @TypeConverter
    public String a(MkDataBean mkDataBean) {
        return r.a(mkDataBean);
    }
}
