package org.reactnative.standalone.facedetector;

import org.reactnative.standalone.facedetector.tasks.FileFaceDetectionAsyncTask;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class FaceDetectorModuleStandalone extends ReactContextBaseJavaModule {
  private static final String TAG = "RNFaceDetectorStandalone";
//  private ScopedContext mScopedContext;
private static ReactApplicationContext mScopedContext;

  public FaceDetectorModuleStandalone(ReactApplicationContext reactContext) {
    super(reactContext);
    mScopedContext = reactContext;
  }

  @Override
  public String getName() {
    return TAG;
  }

  @Nullable
  @Override
  public Map<String, Object> getConstants() {
    return Collections.unmodifiableMap(new HashMap<String, Object>() {
      {
        put("Mode", getFaceDetectionModeConstants());
        put("Landmarks", getFaceDetectionLandmarksConstants());
        put("Classifications", getFaceDetectionClassificationsConstants());
      }

      private Map<String, Object> getFaceDetectionModeConstants() {
        return Collections.unmodifiableMap(new HashMap<String, Object>() {
          {
            put("fast", RNFaceDetector.FAST_MODE);
            put("accurate", RNFaceDetector.ACCURATE_MODE);
          }
        });
      }

      private Map<String, Object> getFaceDetectionClassificationsConstants() {
        return Collections.unmodifiableMap(new HashMap<String, Object>() {
          {
            put("all", RNFaceDetector.ALL_CLASSIFICATIONS);
            put("none", RNFaceDetector.NO_CLASSIFICATIONS);
          }
        });
      }

      private Map<String, Object> getFaceDetectionLandmarksConstants() {
        return Collections.unmodifiableMap(new HashMap<String, Object>() {
          {
            put("all", RNFaceDetector.ALL_LANDMARKS);
            put("none", RNFaceDetector.NO_LANDMARKS);
          }
        });
      }
    });
  }

  @ReactMethod
  public void detectFaces(ReadableMap options, final Promise promise) {
    new FileFaceDetectionAsyncTask(mScopedContext, options, promise).execute();
  }
}
