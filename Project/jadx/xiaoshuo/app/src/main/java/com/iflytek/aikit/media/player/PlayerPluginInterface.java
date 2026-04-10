package com.iflytek.aikit.media.player;

import com.iflytek.aikit.core.AiResponse;
import com.iflytek.aikit.plugin.base.PluginInterface;
import com.iflytek.aikit.plugin.player.PlayerCallBack;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface PlayerPluginInterface extends PluginInterface {
    void setPlayerListener(PlayerCallBack playerCallBack);

    void writeData(String str);

    void writeData(byte[] bArr);

    void writeData(byte[] bArr, long j, long j2);

    void writeProcess(int i, List<AiResponse> list);
}
