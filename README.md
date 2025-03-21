# Overview
This News Shorts App is an Android application built with kotlin and jetpack compose with MVVM architecture with a focus on maintainability, scalability, and clean code practices. It fetches data from a news api to display the major headlines of the day.

## What I Learnt
- Implementing a modular architecture with clean separation of concerns
- Custom reusable UI components built with Jetpack Compose replacing traditional XML layouts
- Implementing MVVM architecture patterns
- Managing asynchronous operations with Coroutines
- Implementing dependency injection with Dagger-Hilt
- Working with APIs using Retrofit
- Applying best practices for maintainable and scalable code

## Architecture
The application follows a modular architecture with clean separation of concerns:
### UI Layer
- Composable functions for rendering UI components
- State management for handling UI state changes
- ViewModels for business logic and state holders

### Data Layer
- Repository pattern for abstracting data sources
- API service interfaces using Retrofit
- Data models and mappers
### Dependency Injection
- Hilt modules for providing dependencies
- Application-scoped and activity-scoped components

## Key Implementation Details

- **Build Configuration** : Uses buildSrc for centralized dependency management, avoiding version conflicts and enhancing modularity
- **Composables**: Custom reusable UI components built with Jetpack Compose replacing traditional XML layouts
- **Coroutines**: Background operations like API calls implemented with coroutines to prevent main thread blocking
- **State Management**: Reactive UI updates through state objects and flows
- **Network Operations**: API calls handled through Retrofit with Gson for JSON parsing
