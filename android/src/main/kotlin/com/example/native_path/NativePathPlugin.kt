package com.example.native_path

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

/** NativePathPlugin */
public class NativePathPlugin: FlutterPlugin, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private lateinit var channel : MethodChannel
  lateinit var registrar: Registrar

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "native_path")
    channel.setMethodCallHandler(this);
  }

  // This static function is optional and equivalent to onAttachedToEngine. It supports the old
  // pre-Flutter-1.12 Android projects. You are encouraged to continue supporting
  // plugin registration via this function while apps migrate to use the new Android APIs
  // post-flutter-1.12 via https://flutter.dev/go/android-project-migration.
  //
  // It is encouraged to share logic between onAttachedToEngine and registerWith to keep
  // them functionally equivalent. Only one of onAttachedToEngine or registerWith will be called
  // depending on the user's project. onAttachedToEngine or registerWith must both be defined
  // in the same class.
  companion object {
    @JvmStatic
    fun registerWith(registrar: Registrar) {
      val channel = MethodChannel(registrar.messenger(), "native_path")
      val registrar = registrar
      channel.setMethodCallHandler(NativePathPlugin())
    }
  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
    if (call.method == "resolve_path") {
      val arguments = call.arguments as HashMap<String,Any>;
      var asset = ""
      if(arguments.containsKey("asset")) {
        asset = arguments["asset"] as String
      }
      // val key = registrar.lookupKey(asset)
      

      // AssetManager assetManager = registrar.context().getAssets();
      // String key = registrar.lookupKeyForAsset("icons/heart.png");
      // AssetFileDescriptor fd = assetManager.openFd(key);




      // if let arguments = call.arguments as? NSDictionary {
      //   var asset = "";
      //   if let arg = arguments["asset"], let val = arg as? String {
      //     asset = val
      //   }
      //   let key = registrar.lookupKey(forAsset: asset)
      //   let path = Bundle.main.path(forResource: key, ofType: nil)
      //   result("file://" + (path ?? ""))
      // }
    } else {
      result.notImplemented()
    }
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }
}
