import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:native_path/native_path.dart';

void main() {
  const MethodChannel channel = MethodChannel('native_path');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    // expect(await NativePath.platformVersion, '42');
  });
}
