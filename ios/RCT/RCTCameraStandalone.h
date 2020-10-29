#import <UIKit/UIKit.h>
#import <AVFoundation/AVFoundation.h>
#import "CameraFocusSquareStandalone.h"

@class RCTCameraStandaloneManager;

@interface RCTCameraStandalone : UIView

- (id)initWithManager:(RCTCameraStandaloneManager*)manager bridge:(RCTBridge *)bridge;

@property (nonatomic, strong) RCTCameraFocusSquareStandalone *camFocus;
@end
