package org.reactnative.camera.standalone.tasks;

import org.reactnative.standalone.facedetector.RNFaceDetector;

import com.facebook.react.bridge.WritableArray;

public interface FaceDetectorAsyncTaskDelegate {
  void onFacesDetected(WritableArray faces);
  void onFaceDetectionError(RNFaceDetector faceDetector);
  void onFaceDetectingTaskCompleted();
}
