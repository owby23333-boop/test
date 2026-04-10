package com.bykv.vk.openvk.component.video.z.g.gc;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.component.video.z.g.fo;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {
    gc g;
    List<fo.g> z;

    public abstract InputStream a();

    public abstract List<fo.g> dl();

    public abstract boolean g();

    public abstract String gc();

    public abstract String m();

    public abstract int z();

    protected String z(int i) {
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
            case 205:
                return "Reset Content";
            case 206:
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
                            case MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL /* 400 */:
                                return "Bad Request";
                            case 401:
                                return "Unauthorized";
                            case 402:
                                return "Payment Required";
                            case 403:
                                return "Forbidden";
                            case 404:
                                return "Not Found";
                            case 405:
                                return "Method Not Allowed";
                            case 406:
                                return "Not Acceptable";
                            case 407:
                                return "Proxy Authentication Required";
                            case TTAdConstant.INTERACTION_TYPE_CODE /* 408 */:
                                return "Request Time-Out";
                            case TTAdConstant.IMAGE_LIST_CODE /* 409 */:
                                return "Conflict";
                            case TTAdConstant.IMAGE_LIST_SIZE_CODE /* 410 */:
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
                                    case TypedValues.Position.TYPE_DRAWPATH /* 502 */:
                                        return "Bad Gateway";
                                    case TypedValues.Position.TYPE_PERCENT_WIDTH /* 503 */:
                                        return "Service Unavailable";
                                    case TypedValues.Position.TYPE_PERCENT_HEIGHT /* 504 */:
                                        return "Gateway Timeout";
                                    case TypedValues.Position.TYPE_SIZE_PERCENT /* 505 */:
                                        return "HTTP Version Not Supported";
                                    default:
                                        return "";
                                }
                        }
                }
        }
    }

    public abstract String z(String str, String str2);

    public gc e() {
        return this.g;
    }

    protected fo.g z(String str) {
        List<fo.g> list;
        if (str != null && (list = this.z) != null && list.size() > 0) {
            for (fo.g gVar : this.z) {
                if (str.equals(gVar.z)) {
                    return gVar;
                }
            }
        }
        return null;
    }
}
