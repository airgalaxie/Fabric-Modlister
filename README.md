# Fabric Modlister

Server-side Fabric mod for Minecraft 26.2. It fills the standard GameSpy4 full-query
`plugins` field with the loaded top-level Fabric mods and their versions.

Example:

```text
plugins = Fabric: Fabric Modlister 1.0-SNAPSHOT; Some Mod 2.3.1
```

Nested implementation modules and built-in entries such as Minecraft and Java are
omitted. Enable the vanilla query in `server.properties`:

```properties
enable-query=true
query.port=25565
```

Build with Java 25 or newer:

```bash
./gradlew build
```

The distributable mod JAR is written to `build/libs/`.
