package org.reactnative.camera.standalone.tasks;

import com.facebook.react.bridge.WritableMap;

public interface PictureSavedDelegate {
    void onPictureSaved(WritableMap response);
}
