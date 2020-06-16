import Flutter
import UIKit

public class SwiftNativePathPlugin: NSObject, FlutterPlugin {
  var registrar: FlutterPluginRegistrar!

  public static func register(with registrar: FlutterPluginRegistrar) {
    let channel = FlutterMethodChannel(name: "native_path", binaryMessenger: registrar.messenger())
    let instance = SwiftNativePathPlugin()
    instance.registrar = registrar;
    registrar.addMethodCallDelegate(instance, channel: channel)
  }

  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
    if (call.method == "resolve_path") {
      if let arguments = call.arguments as? NSDictionary {
        var asset = "";
        if let arg = arguments["asset"], let val = arg as? String {
          asset = val
        }
        let key = registrar.lookupKey(forAsset: asset)
        let path = Bundle.main.path(forResource: key, ofType: nil)
        result("file://" + (path ?? ""))
      }
    } else {
      result(FlutterMethodNotImplemented)
    }

    result(FlutterMethodNotImplemented)
  }
}
