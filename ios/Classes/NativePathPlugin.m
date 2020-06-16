#import "NativePathPlugin.h"
#if __has_include(<native_path/native_path-Swift.h>)
#import <native_path/native_path-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "native_path-Swift.h"
#endif

@implementation NativePathPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftNativePathPlugin registerWithRegistrar:registrar];
}
@end
