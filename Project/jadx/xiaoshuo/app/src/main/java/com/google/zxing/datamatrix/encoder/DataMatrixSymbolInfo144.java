package com.google.zxing.datamatrix.encoder;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes7.dex */
final class DataMatrixSymbolInfo144 extends SymbolInfo {
    public DataMatrixSymbolInfo144() {
        super(false, 1558, MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_CREATE_TIME, 22, 22, 36, -1, 62);
    }

    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int getDataLengthForInterleavedBlock(int i) {
        return i <= 8 ? MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME : MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPEN_TIME;
    }

    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int getInterleavedBlockCount() {
        return 10;
    }
}
