import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';

import 'package:flutter_tts_example/main.dart';

void main() {
  const channel = MethodChannel('flutter_tts');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    TestDefaultBinaryMessengerBinding.instance.defaultBinaryMessenger
        .setMockMethodCallHandler(channel, (call) async {
      switch (call.method) {
        case 'awaitSpeakCompletion':
        case 'stop':
          return 1;
        case 'getVoices':
          return <Map<String, String>>[
            <String, String>{'name': 'Test Voice', 'locale': 'en-US'}
          ];
        case 'getLanguages':
          return <String>['en-US'];
        default:
          return null;
      }
    });
  });

  tearDown(() {
    TestDefaultBinaryMessengerBinding.instance.defaultBinaryMessenger
        .setMockMethodCallHandler(channel, null);
  });

  testWidgets('Flutter TTS example renders its main controls',
      (WidgetTester tester) async {
    await tester.pumpWidget(const MyApp());
    await tester.pumpAndSettle();

    expect(find.text('Flutter TTS'), findsOneWidget);
    expect(find.byType(TextField), findsOneWidget);
    expect(find.text('PLAY'), findsOneWidget);
    expect(find.text('STOP'), findsOneWidget);
    expect(find.text('PAUSE'), findsOneWidget);
    expect(find.byType(Slider), findsNWidgets(3));
  });
}
