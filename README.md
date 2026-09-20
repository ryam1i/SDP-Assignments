# Assignment #2 — Factory Method & Abstract Factory: Digital Audio Workstation (DAW)

**Course:** Software Design Patterns  
**Topic:** Creational Patterns (Factory Method & Abstract Factory)

---

## Changes Overview

### 1. Factory Method Pattern (`com.music.factory`)
- Added `AudioExporter` product interface for format exporting.
- Added concrete exporter products: `WavAudioExporter` and `FlacAudioExporter`.
- Added `AudioPublisher` abstract creator with `createExporter()` factory method and `publish(Track)` template logic.
- Added concrete creators: `WavPublisher` and `FlacPublisher`.

### 2. Abstract Factory Pattern (`com.music.abstractfactory`)
- Added `TrackProductionFactory` abstract factory interface for track component families.
- Added concrete factories: `StudioTrackFactory` (studio production) and `LiveTrackFactory` (live production).
- Added abstract product interfaces: `VocalTrack` (`recordVocals`) and `InstrumentalTrack` (`playInstruments`).
- Added concrete products: `StudioVocalTrack`, `StudioInstrumentalTrack`, `LiveVocalTrack`, and `LiveInstrumentalTrack`.
- Added `MusicProductionClient` coordinating recording sessions via abstract interfaces.

### 3. Builder & Domain Updates (`com.music.builder`)
- Extended `TrackBuilder`, `AudioTrackBuilder`, and `TrackManifestBuilder` with `artist`, `releaseDate`, `recordingType`, and `productionType`.
- Updated `Track` domain entity to store `title` and `artist`.
- Expanded `Genre` enum with `rap`, `pluggnb`, `synthwave`, `rock`, `alternative`, `hiphop`, `rage`, and `rnb`.
- Updated `SoundProducerDirector` with new preset `makePyramids`.
- Standardized release manifest formatting in English.
- Updated fail-fast validation in `AudioTrackBuilder.build()` to enforce non-empty track names.

### 4. Client Integration (`Main.java`)
- Connected the full production pipeline:
  1. Abstract Factory creates environment-specific performance (Studio & Live).
  2. Builder constructs `Track` objects and distribution manifests.
  3. Factory Method exports and publishes tracks in WAV and FLAC formats.
  4. Exception handling verifies fail-fast construction.

---

## Clean Code Principles Applied
- **Meaningful Names:** Domain-driven identifiers (`createExporter`, `producePerformance`, `applyMastering`).
- **Single Responsibility (SRP):** Separate classes for factories, exporters, publishers, and builders.
- **Open/Closed Principle (OCP):** New audio formats and production environments can be added without altering existing code.
- **Dependency Inversion (DIP):** Client classes depend exclusively on abstractions (`TrackProductionFactory`, `AudioExporter`).
- **Fail-Fast Validation:** Invariants are validated immediately at build time before objects are created.
