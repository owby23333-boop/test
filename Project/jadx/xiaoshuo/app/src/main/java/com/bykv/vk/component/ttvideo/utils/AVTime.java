package com.bykv.vk.component.ttvideo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class AVTime {
    public static String getFormatNow() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm ss:SSS").format(new Date());
    }
}
