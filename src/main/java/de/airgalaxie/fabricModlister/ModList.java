package de.airgalaxie.fabricModlister;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;

import java.util.Comparator;
import java.util.stream.Collectors;

public final class ModList {
    private ModList() {
    }

    public static String forQuery() {
        String mods = FabricLoader.getInstance().getAllMods().stream()
                // Nested JARs are implementation modules (Fabric API alone contains many of them).
                .filter(mod -> mod.getContainingMod().isEmpty())
                .filter(mod -> !"builtin".equals(mod.getMetadata().getType()))
                .sorted(Comparator.comparing(mod -> mod.getMetadata().getId()))
                .map(ModList::format)
                .collect(Collectors.joining("; "));

        return mods.isEmpty() ? "Fabric" : "Fabric: " + mods;
    }

    private static String format(ModContainer container) {
        ModMetadata metadata = container.getMetadata();
        return sanitize(metadata.getName()) + " " + sanitize(metadata.getVersion().getFriendlyString());
    }

    private static String sanitize(String value) {
        // GS4 strings are NUL-terminated; line breaks are not useful to query consumers either.
        return value.replace('\0', '?').replace('\r', ' ').replace('\n', ' ');
    }
}
