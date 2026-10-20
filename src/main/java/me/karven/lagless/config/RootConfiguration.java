package me.karven.lagless.config;

import me.karven.lagless.config.module.ModulesConfiguration;
import org.jspecify.annotations.NullMarked;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.yaml.YamlConfigurationLoader;

import java.io.File;

@NullMarked
@ConfigSerializable
public class RootConfiguration {
    public static final RootConfiguration DEFAULT = new RootConfiguration();

    private static YamlConfigurationLoader getLoader() {
        return YamlConfigurationLoader.builder()
                .file(new File("config", "lagless.yml"))
                .build();
    }

    public static RootConfiguration load() throws ConfigurateException {
        final YamlConfigurationLoader loader = getLoader();
        final CommentedConfigurationNode rootNode = loader.load();
        final RootConfiguration configuration = rootNode.get(RootConfiguration.class);

        rootNode.set(configuration == null ? DEFAULT : configuration);
        loader.save(rootNode);

        if (configuration == null) return DEFAULT;
        return configuration;
    }

    public ModulesConfiguration modules = new ModulesConfiguration();
}
