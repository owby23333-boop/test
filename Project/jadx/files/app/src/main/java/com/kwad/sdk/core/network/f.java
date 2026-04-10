package com.kwad.sdk.core.network;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static f afN = new f(-1, "请求超时事件");
    public static f afO = new f(-2, "请求异常");
    public static f afP = new f(-1000, "该业务组件未加载");
    public static f afQ = new f(40001, "网络错误");
    public static f afR = new f(40002, "数据解析错误");
    public static f afS = new f(40003, "广告数据为空");
    public static f afT = new f(40004, "视频资源缓存失败");
    public static f afU = new f(40005, "网络超时");
    public static f afV = new f(40007, "图片下载失败");
    public static f afW = new f(40008, "广告场景不匹配");
    public static f afX = new f(100006, "更多视频请前往快手App查看");
    public static f afY = new f(100007, "复制链接失败，请稍后重试");
    public static f afZ = new f(100008, "内容有点敏感，不可以发送哦");
    public static f aga = new f(130001, "数据不存在");
    public static f agb = new f(0, "网络超时");
    public int errorCode;
    public String msg;

    private f(int i2, String str) {
        this.errorCode = i2;
        this.msg = str;
    }
}
