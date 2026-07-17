# Contributing to Autism Health Companion

Thank you for your interest in contributing! This guide will help you get started.

## Code of Conduct
We are committed to providing a welcoming and inclusive environment. Please be respectful and kind in all interactions.

## Getting Started

1. Fork the repository
2. Clone your fork: `git clone https://github.com/YOUR_USERNAME/Autism-health-.git`
3. Create a feature branch: `git checkout -b feature/your-feature-name`
4. Make your changes
5. Commit: `git commit -m "Add feature: description"`
6. Push: `git push origin feature/your-feature-name`
7. Create a Pull Request

## Development Setup

### Requirements
- Android Studio Flamingo or later
- JDK 17
- Android SDK 26+
- Kotlin 1.9.0+

### Build Instructions
```bash
# Clone and setup
git clone https://github.com/NIcolasLquastad/Autism-health-.git
cd Autism-health-

# Build debug APK
./gradlew assembleDebug

# Install on device
./gradlew installDebug

# Run tests
./gradlew test

# Build release APK
./gradlew assembleRelease
```

## Code Style
- Follow Kotlin style guide: https://kotlinlang.org/docs/coding-conventions.html
- Use proper naming conventions
- Add meaningful comments
- Keep functions small and focused
- Use coroutines for async operations

## Testing
- Write unit tests for business logic
- Include instrumented tests for UI components
- Aim for 70%+ code coverage
- Test on multiple Android versions (26+)

## Accessibility First
- Always consider autism-friendly design
- Support high contrast mode
- Respect animation preferences
- Test with screen readers
- Provide clear, simple language

## Areas for Contribution
- UI/UX improvements
- Samsung Health integration
- Testing and bug fixes
- Documentation
- Accessibility enhancements
- Localization

## Pull Request Guidelines
1. One feature/fix per PR
2. Clear, descriptive title
3. Reference any related issues
4. Include screenshots for UI changes
5. Update documentation if needed
6. Ensure tests pass

## Questions?
Open a GitHub Discussion or reach out to the maintainers.
