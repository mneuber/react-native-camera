package org.reactnative.camera.standalone.tasks;

import com.facebook.react.bridge.WritableArray;
import org.reactnative.imagelabeler.RNImageLabeler;

public interface ImageLabelerAsyncTaskDelegate {

    void onLabelsDetected(WritableArray labels);

    void onImageLabelingError(RNImageLabeler imageLabeler);

    void onImageLabelingTaskCompleted();
}
