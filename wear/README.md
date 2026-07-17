# Autism Health Companion - Samsung Galaxy Watch 8 Integration

**Wear App Version:** 0.1.0-alpha

## Overview
This is the companion app for Samsung Galaxy Watch 8 (Wear OS). It provides real-time health monitoring, mood tracking, and seamless integration with Samsung Health.

## Features

### Health Monitoring
- **Real-time Heart Rate**: Continuous monitoring via watch sensors
- **Step Counter**: Track daily steps
- **Calorie Calculator**: Automatic calorie estimation
- **Samsung Health Sync**: Automatic data synchronization
- **Health Alerts**: Notifications for unusual readings

### Mood & Wellness Tracking
- **Quick Mood Logging**: One-tap mood tracking on the watch
- **Sensory Level Monitoring**: Track sensory sensitivities
- **Stress Detection**: Monitor heart rate variability for stress levels
- **Notes Feature**: Add quick voice or text notes

### Connectivity
- **Phone Sync**: Automatic sync with companion phone app
- **Samsung Health Integration**: Direct data write access
- **Cloud Backup**: Optional cloud synchronization
- **Offline Mode**: Works without internet connection

## System Requirements
- Samsung Galaxy Watch 4 or newer (tested on Watch 8)
- Wear OS 3.0+
- Samsung Health app installed
- Android phone with companion app installed

## Installation

### Via Android Studio
1. Open project in Android Studio
2. Switch to "wear" module
3. Connect watch via ADB
4. Run `./gradlew installDebug`

### Via ADB (Manual)
```bash
# Build wear APK
./gradlew wear:assembleDebug

# Install to watch
adb -s WATCH_SERIAL install wear/build/outputs/apk/debug/wear-debug.apk
```

### Via Play Store (Future)
- Coming soon after beta testing

## Samsung Health Integration

### Permissions Required
- `com.samsung.android.healthdata.permission.READ`
- `com.samsung.android.healthdata.permission.WRITE`

### Data Types Supported
- Heart Rate
- Step Count
- Sleep Data
- Oxygen Saturation (SpO2)
- Stress Level
- Calories Burned

### Data Sync
- Automatic sync every 15 minutes
- Manual sync via watch menu
- Real-time alerts for critical readings

## Configuration

### Accessibility Settings
- High contrast mode for AMOLED displays
- Reduced animation support
- Large text options
- Voice command support

### Health Monitoring Settings
- Heart rate monitoring interval: 1 minute (default)
- Stress detection: Enabled
- Sleep detection: Enabled
- Automatic sync: Enabled

## Battery Optimization
- Efficient sensor polling
- Adaptive update frequency
- Background service optimization
- Expected battery life: 1-2 days with continuous monitoring

## Troubleshooting

### Samsung Health Won't Connect
1. Ensure Samsung Health app is installed
2. Check health permissions in watch settings
3. Restart both watch and Samsung Health
4. Unpair and re-pair phone/watch

### Data Not Syncing
1. Check network connection
2. Verify companion app is running on phone
3. Check app logs: `adb logcat | grep AutismHealth`
4. Restart sync service

### High Battery Drain
1. Reduce heart rate monitoring frequency
2. Disable real-time alerts
3. Check for background services
4. Update to latest watch OS

## Developer Commands

```bash
# View watch logs
adb logcat -s AutismHealth

# Install and run
./gradlew installDebugAndroidTest

# Build release APK
./gradlew assembleRelease

# Run tests
./gradlew testDebugUnitTest
```

## Performance Metrics
- App size: ~25MB
- Memory usage: ~50MB
- CPU usage: <10% at idle
- Data sync time: <2 seconds

## Known Limitations
- Sleep tracking only works with Samsung Health
- Some health data requires phone for full analysis
- Voice commands require Samsung Galaxy Watch 4+
- Limited UI customization on older watch models

## Future Enhancements
- Support for other wear OS devices
- Advanced health analytics
- Integration with other health apps
- Offline data storage expansion
- Multi-language support

## Contributing
See main repository CONTRIBUTING.md

## Support
For issues, please file on GitHub: https://github.com/NIcolasLquastad/Autism-health-/issues
