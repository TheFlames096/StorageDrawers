package com.jaquadro.minecraft.storagedrawers.item;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum EnumUpgradeStorage implements StringRepresentable
{
    IRON(0, 1, "iron", "iron"),
    GOLD(1, 2, "gold", "gold"),
    OBSIDIAN(2, 3, "obsidian", "obsidian"),
    DIAMOND(3, 4, "diamond", "diamond"),
    EMERALD(4, 5, "emerald", "emerald"),
    RUBY(5, 6, "ruby", "ruby"),
    TANZANITE(6, 7, "tanzanite", "tanzanite");

    private static final EnumUpgradeStorage[] META_LOOKUP;
    private static final EnumUpgradeStorage[] LEVEL_LOOKUP;

    private final int meta;
    private final int level;
    private final String name;
    private final String unlocalizedName;

    private EnumUpgradeStorage (int meta, int level, String name, String unlocalizedName) {
        this.meta = meta;
        this.name = name;
        this.level = level;
        this.unlocalizedName = unlocalizedName;
    }

    public int getMetadata () {
        return meta;
    }

    public int getLevel () {
        return level;
    }

    public String getUnlocalizedName () {
        return unlocalizedName;
    }

    public static EnumUpgradeStorage byMetadata (int meta) {
        if (meta < 0 || meta >= META_LOOKUP.length)
            meta = 0;
        return META_LOOKUP[meta];
    }

    public static EnumUpgradeStorage byLevel (int level) {
        if (level < 0 || level >= LEVEL_LOOKUP.length)
            level = 0;
        return LEVEL_LOOKUP[level];
    }

    @Override
    public String toString () {
        return unlocalizedName;
    }

    @Override
    @NotNull
    public String getSerializedName () {
        return name;
    }

    static {
        META_LOOKUP = new EnumUpgradeStorage[values().length];
        for (EnumUpgradeStorage upgrade : values()) {
            META_LOOKUP[upgrade.getMetadata()] = upgrade;
        }

        int maxLevel = 0;
        for (EnumUpgradeStorage upgrade : values()) {
            if (upgrade.getLevel() > maxLevel)
                maxLevel = upgrade.getLevel();
        }

        LEVEL_LOOKUP = new EnumUpgradeStorage[maxLevel + 1];
        for (EnumUpgradeStorage upgrade : values()) {
            LEVEL_LOOKUP[upgrade.getLevel()] = upgrade;
        }
    }
}
