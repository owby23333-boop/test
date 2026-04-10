package com.amgcyo.cuttadon.app.o;

import com.amgcyo.cuttadon.utils.otherutils.h;
import java.util.Random;

/* JADX INFO: compiled from: TemplateUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final String[] a = {"看最全！更新最快的小说尽在【.{0,10}?】App", "看免费小说，就用【.{0,10}?】App", "复制网址访问:" + h.C0() + " 下载最新版【.{0,10}?】免费小说阅读器", "本书来自【.{0,10}?】App", "一秒记住【" + h.C0() + "】，精彩小说无广告免费阅读！"};

    public static String a(String str) {
        return "\n" + a[new Random().nextInt(a.length)].replace(".{0,10}?", str);
    }
}
