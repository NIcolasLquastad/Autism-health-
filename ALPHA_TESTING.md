# Alpha Testing Guide

## Version: 0.1.0-alpha
**Release Date:** July 17, 2026

## Installation Instructions

### Prerequisites
- Android 8.0 (API 26) or higher
- Samsung Galaxy device (recommended for full Samsung Health integration)
- Samsung Health app installed
- 50MB free storage space

### Steps to Install
1. Download the APK file from the Releases page
2. Go to Settings > Security on your Android device
3. Enable "Unknown Sources" or "Allow installation of apps from unknown sources"
4. Open the downloaded APK file
5. Tap "Install"
6. Grant all requested permissions
7. Launch the app

## Known Limitations (Alpha)
- Samsung Health integration is partially implemented
- UI theming needs refinement
- Some animations may not be smooth
- Emergency contact feature not yet fully implemented
- Data export features unavailable

## Features Currently Available
- ✅ Basic mood tracking
- ✅ Sensory level logging
- ✅ Simple health data display
- ✅ Dark mode support
- ✅ High contrast mode (experimental)
- ⚠️ Samsung Health sync (partial)
- ❌ Routine management
- ❌ Notifications
- ❌ Emergency contacts

## How to Report Bugs

### Via GitHub Issues
1. Go to https://github.com/NIcolasLquastad/Autism-health-/issues
2. Click "New Issue"
3. Use the bug report template
4. Include:
   - Device model and Android version
   - Steps to reproduce
   - Expected vs actual behavior
   - Screenshots/videos if possible
   - Logcat output (if available)

### Bug Report Template
```
**Device Information:**
- Device: [e.g., Samsung Galaxy S21]
- Android Version: [e.g., 12]
- App Version: [0.1.0-alpha]

**Describe the Bug:**
[Clear description of what went wrong]

**Steps to Reproduce:**
1.
2.
3.

**Expected Behavior:**
[What should happen]

**Actual Behavior:**
[What actually happened]

**Attachments:**
[Screenshots, videos, logs]
```

## Feature Requests
- Use GitHub Discussions to suggest new features
- Vote on features with 👍 reactions
- Explain use cases for better understanding

## Testing Checklist

- [ ] App installs successfully
- [ ] App launches without crashing
- [ ] Mood tracking works
- [ ] Data persists after app restart
- [ ] Samsung Health connection establishes
- [ ] High contrast mode is readable
- [ ] Text scales properly
- [ ] Animations can be reduced
- [ ] Dark mode displays correctly
- [ ] No memory leaks (monitor with Android Profiler)

## Performance Metrics
- Target: < 100MB RAM usage
- Target: App startup < 3 seconds
- Target: Data sync < 5 seconds

## Contact & Support
- GitHub: https://github.com/NIcolasLquastad/Autism-health-
- Issues: https://github.com/NIcolasLquastad/Autism-health-/issues

## Feedback Survey
Please take a moment to fill out this quick survey after testing:
[Survey Link - To be added]

---

**Thank you for helping us improve the Autism Health Companion App!**
