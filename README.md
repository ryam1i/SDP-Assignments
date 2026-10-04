# Assignment #3 — Structural Design Patterns: Bridge & System Expansion

**Course:** Software Design Patterns  
**Topic:** Structural Patterns (Bridge Pattern) & Domain Expansion

---

## Changes Overview

### 1. Bridge Pattern (`com.music.bridge`)
- **Implementor Interface (`StreamingPlatformGateway`):** Declares platform operations (`authenticate` and `uploadAudioMetadata`).
- **Concrete Implementors:**
  - `SpotifyGateway`: Implements authentication and metadata distribution for Spotify Partner API v2.
  - `AppleMusicGateway`: Implements authentication and metadata distribution for Apple Music Connect.
- **Abstraction (`MusicRelease`):** Abstract base class maintaining a reference to `StreamingPlatformGateway`, providing runtime gateway swapping via `setGateway()`.
- **Refined Abstractions:**
  - `AlbumRelease`: Manages multi-track album distribution and track counts.
  - `SingleTrackRelease`: Manages standalone single-track distribution.

### 2. Builder & Domain Expansion (`com.music.builder`)
- **Domain Models:**
  - `Album`: Lightweight domain entity (`title`, `artist`) representing audio album releases.
  - `AlbumReleaseManifest`: Textual release manifest detailing complete album production metadata.
- **Builders:**
  - `AlbumBuilder`: Builder interface for configuring album metadata (`title`, `artist`, `genre`, `releaseDate`, `recordingType`, `productionType`).
  - `AudioAlbumBuilder`: Concrete builder producing `Album` instances with fail-fast validation.
  - `AlbumManifestBuilder`: Concrete builder constructing structured `AlbumReleaseManifest` documents.

### 3. Client Integration (`Main.java`)
- Extended the production pipeline with album manifest generation via `AlbumManifestBuilder`.
- Demonstrated the Bridge pattern workflow:
  1. Instantiated platform gateways (`SpotifyGateway`, `AppleMusicGateway`).
  2. Distributed `AlbumRelease` via Spotify.
  3. Dynamically switched the streaming platform to Apple Music at runtime using `setGateway()`, showcasing loose coupling between abstraction and implementation.

---

## Clean Code & SOLID Principles Applied
- **Bridge Decoupling:** Separates the release abstraction hierarchy (`MusicRelease`) from the platform implementation hierarchy (`StreamingPlatformGateway`), allowing both to evolve independently.
- **Single Responsibility Principle (SRP):** Domain entities, builders, manifest formatters, and platform gateways each handle a single concern.
- **Open/Closed Principle (OCP):** New streaming platforms (e.g., Tidal, YouTube Music) and new release formats (e.g., EP) can be added without modifying existing code.
- **Dependency Inversion Principle (DIP):** High-level release abstractions depend strictly on the `StreamingPlatformGateway` interface, never on concrete gateway classes.
