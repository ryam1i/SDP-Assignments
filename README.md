# Assignment #1 — Builder Pattern: Digital Audio Workstation (DAW)

**Course:** Software Design Patterns  
**Topic:** Music Track Production & Release Automation  

---

## 1. Domain Description
This project implements the classical **GoF Builder Pattern** representing a Digital Audio Workstation (DAW). 
Building a music track is a complex, multi-step process involving composition, tempo, harmonic structure, and mastering.

The system supports **multiple representations** from the same construction workflow:
- `Track`: The concrete domain object representing an audio composition.
- `TrackReleaseManifest`: A distribution document containing release metadata for streaming services (Spotify/Apple Music).

---

## 2. Pattern Components

| Component | File | Responsibility |
|---|---|---|
| **Product 1** | `Track.java` | Complex domain product with immutable properties. |
| **Product 2** | `TrackReleaseManifest.java` | Alternative textual representation of the track. |
| **Builder Interface** | `TrackBuilder.java` | Declares common construction steps with method chaining (Fluent API). |
| **Concrete Builder 1** | `AudioTrackBuilder.java` | Assembles `Track` and validates state before creation. |
| **Concrete Builder 2** | `TrackManifestBuilder.java` | Assembles formatted release documentation. |
| **Director** | `SoundProducerDirector.java` | Provides reusable production presets (`makeLoFiBeat`, `makeSynthwaveTrack`). |
| **Client** | `Main.java` | Executes director presets, manual custom builds, and demonstrates validation. |

---

## 3. Clean Code Principles Justification (Ch. 3)

### 1. Meaningful, Intention-Revealing Names
- **Before:**
  ```java
  builder.setB(80);
  builder.setM(true);
  ```
- **After:**
  ```java
  builder.setBpm(80);
  builder.applyMastering();
  ```
- **Justification:** Variable and method names explicitly convey their domain purpose, eliminating guesswork.

---

### 2. Small Functions & Single Level of Abstraction
- **Before:** A large method mixing audio parameters, formatting text, and instantiating the object in one place.
- **After:**
  ```java
  @Override
  public AudioTrackBuilder setBpm(int bpm) {
      this.bpm = bpm;
      return this;
  }
  ```
- **Justification:** Every method performs one focused operation and delegates higher-level orchestration to the client or director.

---

### 3. No Magic Numbers or Strings (Enums & Named Constants)
- **Before:**
  ```java
  if (genre.equals("lofi")) { ... }
  if (bpm < 40 || bpm > 240) { ... }
  ```
- **After:**
  ```java
  private static final int MIN_BPM = 40;
  private static final int MAX_BPM = 240;
  public enum Genre { LO_FI, SYNTHWAVE, ROCK }
  ```
- **Justification:** Replaces error-prone raw literals with strongly typed enums and clear constants.

---

### 4. Validated Construction (Fail-Fast)
- **Before:** Silently allowing incomplete tracks (e.g., missing titles or impossible tempos) into the system, leading to later runtime exceptions.
- **After:**
  ```java
  public Track build() {
      if (title == null || title.isBlank()) {
          throw new IllegalStateException("Ошибка: у трека должно быть название!");
      }
      if (bpm < MIN_BPM || bpm > MAX_BPM) {
          throw new IllegalStateException("Ошибка: недопустимый BPM (" + bpm + ")");
      }
      return new Track(title, genre, bpm, isMastered);
  }
  ```
- **Justification:** Enforces that a `Track` object is guaranteed to be in a consistent, valid state upon instantiation.

---

### 5. Avoid Flag Arguments
- **Before:**
  ```java
  builder.setMastering(true);
  ```
- **After:**
  ```java
  builder.applyMastering();
  ```
- **Justification:** Eliminates boolean flags in method signatures, making method calls expressive commands.

---

## 4. Execution
```bash
javac -d out src/com/music/builder/domain/*.java src/com/music/builder/builders/*.java src/com/music/builder/director/*.java src/Main.java
java -cp out Main
```
