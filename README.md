# Fabric Modlister

Fabric Modlister is a small proof of concept for a possible Fabric Server Query API
hook. Minecraft already provides GS4 Query, while Fabric Loader knows which mods are
loaded. Fabric Modlister connects these existing pieces of information and exposes
the loaded top-level Fabric mods and their versions through the `plugins` field of
the existing GS4 full-query response. It does not introduce a custom query protocol.

The supported Minecraft and Fabric Loader versions are defined in
`gradle/libs.versions.toml`.

Example:

```text
plugins = Fabric: Fabric Modlister <version>; Some Mod <version>
```

Nested implementation modules and built-in entries such as Minecraft and Java are
omitted. Enable the vanilla query in `server.properties`:

```properties
enable-query=true
query.port=25565
```

Build with the Java version configured in `gradle/libs.versions.toml` (or newer):

```bash
./gradlew build
```

The distributable mod JAR is written to `build/libs/`.
