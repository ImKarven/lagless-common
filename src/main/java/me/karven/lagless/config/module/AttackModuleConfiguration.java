package me.karven.lagless.config.module;

import org.jspecify.annotations.NullMarked;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;

import java.util.List;

@NullMarked
@ConfigSerializable
public class AttackModuleConfiguration {

    public boolean enabled = false;
    public EntityTypesConfiguration entityTypes = new EntityTypesConfiguration();


    @NullMarked
    @ConfigSerializable
    public static class EntityTypesConfiguration {

        public Mode mode = Mode.BLACKLIST;
        public List<String> entityTypes = List.of("minecraft:player");

        public enum Mode {
            WHITELIST,
            BLACKLIST
        }
    }
}
