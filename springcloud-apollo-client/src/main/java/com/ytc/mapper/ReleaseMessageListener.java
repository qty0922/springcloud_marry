package com.ytc.mapper;

import com.ytc.model.ReleaseMessage;

public interface ReleaseMessageListener {
    void handleMessage(ReleaseMessage message);
}
