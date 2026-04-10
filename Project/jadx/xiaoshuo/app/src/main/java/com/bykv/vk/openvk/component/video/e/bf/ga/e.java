package com.bykv.vk.openvk.component.video.e.bf.ga;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.component.video.e.bf.zk;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    ga bf;
    List<zk.bf> e;

    public abstract boolean bf();

    public abstract List<zk.bf> d();

    public abstract int e();

    public String e(int i) {
        switch (i) {
            case 200:
                return "OK";
            case 201:
                return "Created";
            case 202:
                return "Accepted";
            case 203:
                return "Non-Authoritative";
            case 204:
                return "No Content";
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_ID /* 205 */:
                return "Reset Content";
            case MediaPlayer.MEDIA_PLAYER_OPTION_DRM_TYPE /* 206 */:
                return "Partial Content";
            default:
                switch (i) {
                    case 300:
                        return "Multiple Choices";
                    case 301:
                        return "Moved Permanently";
                    case 302:
                        return "Temporary Redirect";
                    case 303:
                        return "See Other";
                    case 304:
                        return "Not Modified";
                    case 305:
                        return "Use Proxy";
                    default:
                        switch (i) {
                            case 400:
                                return "Bad Request";
                            case 401:
                                return "Unauthorized";
                            case 402:
                                return "Payment Required";
                            case 403:
                                return "Forbidden";
                            case 404:
                                return "Not Found";
                            case TTAdConstant.LANDING_PAGE_TYPE_CODE /* 405 */:
                                return "Method Not Allowed";
                            case TTAdConstant.DOWNLOAD_APP_INFO_CODE /* 406 */:
                                return "Not Acceptable";
                            case TTAdConstant.DOWNLOAD_URL_CODE /* 407 */:
                                return "Proxy Authentication Required";
                            case 408:
                                return "Request Time-Out";
                            case TTAdConstant.IMAGE_LIST_CODE /* 409 */:
                                return "Conflict";
                            case 410:
                                return "Gone";
                            case TTAdConstant.IMAGE_CODE /* 411 */:
                                return "Length Required";
                            case TTAdConstant.IMAGE_URL_CODE /* 412 */:
                                return "Precondition Failed";
                            case TTAdConstant.VIDEO_INFO_CODE /* 413 */:
                                return "Request Entity Too Large";
                            case TTAdConstant.VIDEO_URL_CODE /* 414 */:
                                return "Request-URI Too Large";
                            case TTAdConstant.VIDEO_COVER_URL_CODE /* 415 */:
                                return "Unsupported Media Type";
                            default:
                                switch (i) {
                                    case 500:
                                        return "Internal Server Error";
                                    case 501:
                                        return "Not Implemented";
                                    case 502:
                                        return "Bad Gateway";
                                    case 503:
                                        return "Service Unavailable";
                                    case 504:
                                        return "Gateway Timeout";
                                    case TypedValues.PositionType.TYPE_SIZE_PERCENT /* 505 */:
                                        return "HTTP Version Not Supported";
                                    default:
                                        return "";
                                }
                        }
                }
        }
    }

    public abstract String e(String str, String str2);

    public abstract String ga();

    public ga p() {
        return this.bf;
    }

    public abstract InputStream tg();

    public abstract String vn();

    public zk.bf e(String str) {
        List<zk.bf> list;
        if (str != null && (list = this.e) != null && list.size() > 0) {
            for (zk.bf bfVar : this.e) {
                if (str.equals(bfVar.e)) {
                    return bfVar;
                }
            }
        }
        return null;
    }
}
