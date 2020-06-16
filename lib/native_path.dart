import 'dart:async';

import 'package:flutter/services.dart';

class NativePath {
  static const MethodChannel _channel =
      const MethodChannel('native_path');

  static Future<String> resolvePath(String asset) async {
    final String path = await _channel.invokeMethod('resolve_path', {"asset": asset});
    return path;
  }
}
