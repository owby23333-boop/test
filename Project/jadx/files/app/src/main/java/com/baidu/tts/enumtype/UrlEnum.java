package com.baidu.tts.enumtype;

import anet.channel.util.HttpConstant;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.net.InetAddress;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public enum UrlEnum {
    TTS_SERVER("https://tsn.baidu.com/text2audio") { // from class: com.baidu.tts.enumtype.UrlEnum.1
        @Override // com.baidu.tts.enumtype.UrlEnum
        public String getIpUrl() {
            String url = UrlEnum.TTS_SERVER.getUrl();
            String ip = UrlEnum.getIp(url);
            LoggerProxy.d("getIpUrl UrlEnum", url);
            if (ip == null) {
                return null;
            }
            return "https://" + ip + "/text2audio";
        }

        @Override // com.baidu.tts.enumtype.UrlEnum
        public String getIpUrlByProtocol(String str) {
            if (str == null) {
                return null;
            }
            String url = UrlEnum.TTS_SERVER.getUrl();
            String ip = UrlEnum.getIp(url);
            LoggerProxy.d("getIpUrlByProtocol UrlEnum", url);
            if (ip == null) {
                return null;
            }
            return str + HttpConstant.SCHEME_SPLIT + ip + "/text2audio";
        }

        @Override // com.baidu.tts.enumtype.UrlEnum
        public String getUrlByProtocol(String str) {
            if (str == null) {
                return null;
            }
            return str + "://tsn.baidu.com/text2audio";
        }
    },
    MODEL_SERVER("https://tts.baidu.com/bos/story.php?") { // from class: com.baidu.tts.enumtype.UrlEnum.2
        @Override // com.baidu.tts.enumtype.UrlEnum
        public String getIpUrl() {
            return null;
        }

        @Override // com.baidu.tts.enumtype.UrlEnum
        public String getIpUrlByProtocol(String str) {
            return null;
        }

        @Override // com.baidu.tts.enumtype.UrlEnum
        public String getUrlByProtocol(String str) {
            return null;
        }
    },
    STATISTICS_SERVER("https://upl.baidu.com/offline/confirm") { // from class: com.baidu.tts.enumtype.UrlEnum.3
        @Override // com.baidu.tts.enumtype.UrlEnum
        public String getIpUrl() {
            return null;
        }

        @Override // com.baidu.tts.enumtype.UrlEnum
        public String getIpUrlByProtocol(String str) {
            return null;
        }

        @Override // com.baidu.tts.enumtype.UrlEnum
        public String getUrlByProtocol(String str) {
            return null;
        }
    },
    STATISTICS_MODELLOAD_SERVER("https://upl.baidu.com/ttsdlstats") { // from class: com.baidu.tts.enumtype.UrlEnum.4
        @Override // com.baidu.tts.enumtype.UrlEnum
        public String getIpUrl() {
            return null;
        }

        @Override // com.baidu.tts.enumtype.UrlEnum
        public String getIpUrlByProtocol(String str) {
            return null;
        }

        @Override // com.baidu.tts.enumtype.UrlEnum
        public String getUrlByProtocol(String str) {
            return null;
        }
    },
    GETLICENSE_SERVER("https://upl.baidu.com/auth/") { // from class: com.baidu.tts.enumtype.UrlEnum.5
        @Override // com.baidu.tts.enumtype.UrlEnum
        public String getIpUrl() {
            return null;
        }

        @Override // com.baidu.tts.enumtype.UrlEnum
        public String getIpUrlByProtocol(String str) {
            return null;
        }

        @Override // com.baidu.tts.enumtype.UrlEnum
        public String getUrlByProtocol(String str) {
            return null;
        }
    };

    private String mUrl;

    public static String getIp(String str) {
        try {
            return InetAddress.getByName(new URL(str).getHost()).getHostAddress();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public abstract String getIpUrl();

    public abstract String getIpUrlByProtocol(String str);

    public String getUrl() {
        return this.mUrl;
    }

    public abstract String getUrlByProtocol(String str);

    public void setmUrl(String str) {
        this.mUrl = str;
    }

    UrlEnum(String str) {
        this.mUrl = str;
    }
}
