package waldinet.towers_of_the_wild_reworked.config.screens;

import com.google.common.collect.Lists;
import me.shedaniel.clothconfig2.api.*;
import me.shedaniel.clothconfig2.gui.entries.MultiElementListEntry;
import me.shedaniel.clothconfig2.gui.entries.NestedListListEntry;
import me.shedaniel.clothconfig2.impl.builders.DropdownMenuBuilder;
import me.shedaniel.clothconfig2.impl.builders.SubCategoryBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.*;
import java.util.stream.Collectors;

public class DemoConfig
{
    public static ConfigBuilder getConfigBuilderWithDemo()
    {
        class Pair<T, R>
        {
            T t;
            R r;
            
            public Pair(T t, R r) {
                this.t = t;
                this.r = r;
            }
            
            public T getLeft() {
                return t;
            }
            
            public R getRight() {
                return r;
            }
            
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                
                Pair<?, ?> pair = (Pair<?, ?>) o;
                
                if (!Objects.equals(t, pair.t)) return false;
                return Objects.equals(r, pair.r);
            }
            
            @Override
            public int hashCode() {
                int result = t != null ? t.hashCode() : 0;
                result = 31 * result + (r != null ? r.hashCode() : 0);
                return result;
            }
        }
        
        ConfigBuilder builder = ConfigBuilder.create().setTitle(new TranslatableText("title.cloth-config.config"));
        builder.setDefaultBackgroundTexture(new Identifier("minecraft:textures/block/oak_planks.png"));
//        builder.setGlobalized(true);
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        ConfigCategory testing = builder.getOrCreateCategory(new TranslatableText("category.cloth-config.testing"));

        // Lists
        testing.addEntry(entryBuilder.startDoubleList(new TranslatableText("A list of Doubles"), Arrays.asList(1d, 2d, 3d)).setDefaultValue(Arrays.asList(1d, 2d, 3d)).build());
        testing.addEntry(entryBuilder.startLongList(new TranslatableText("A list of Longs"), Arrays.asList(1L, 2L, 3L)).setDefaultValue(Arrays.asList(1L, 2L, 3L)).build());
        testing.addEntry(
            entryBuilder.startStrList(
                new TranslatableText("A list of Strings"),
                Arrays.asList("abc", "xyz")
            ).setTooltip(new TranslatableText("Yes this is some beautiful tooltip\nOh and this is the second line!"))
            .setDefaultValue(Arrays.asList("abc", "xyz"))
            .build()
        );

        // Color
        SubCategoryBuilder colors = entryBuilder.startSubCategory(new TranslatableText("Colors")).setExpanded(true);
        colors.add(entryBuilder.startColorField(new TranslatableText("A color field"), 0x00ffff).setDefaultValue(0x00ffff).build());
        colors.add(entryBuilder.startColorField(new TranslatableText("An alpha color field"), 0xff00ffff).setDefaultValue(0xff00ffff).setAlphaMode(true).build());
        colors.add(entryBuilder.startColorField(new TranslatableText("An alpha color field"), 0xffffffff).setDefaultValue(0xffff0000).setAlphaMode(true).build());
        colors.add(entryBuilder.startDropdownMenu(new TranslatableText("lol apple"), DropdownMenuBuilder.TopCellElementBuilder.ofItemObject(Items.APPLE), DropdownMenuBuilder.CellCreatorBuilder.ofItemObject()).setDefaultValue(Items.APPLE).setSelections(Registry.ITEM.stream().sorted(Comparator.comparing(Item::toString)).collect(Collectors.toCollection(LinkedHashSet::new))).setSaveConsumer(item -> System.out.println("save this " + item)).build());
        colors.add(entryBuilder.startDropdownMenu(new TranslatableText("lol apple"), DropdownMenuBuilder.TopCellElementBuilder.ofItemObject(Items.APPLE), DropdownMenuBuilder.CellCreatorBuilder.ofItemObject()).setDefaultValue(Items.APPLE).setSelections(Registry.ITEM.stream().sorted(Comparator.comparing(Item::toString)).collect(Collectors.toCollection(LinkedHashSet::new))).setSaveConsumer(item -> System.out.println("save this " + item)).build());
        colors.add(entryBuilder.startDropdownMenu(new TranslatableText("lol apple"), DropdownMenuBuilder.TopCellElementBuilder.ofItemObject(Items.APPLE), DropdownMenuBuilder.CellCreatorBuilder.ofItemObject()).setDefaultValue(Items.APPLE).setSelections(Registry.ITEM.stream().sorted(Comparator.comparing(Item::toString)).collect(Collectors.toCollection(LinkedHashSet::new))).setSaveConsumer(item -> System.out.println("save this " + item)).build());
        colors.add(entryBuilder.startDropdownMenu(new TranslatableText("lol apple"), DropdownMenuBuilder.TopCellElementBuilder.ofItemObject(Items.APPLE), DropdownMenuBuilder.CellCreatorBuilder.ofItemObject()).setDefaultValue(Items.APPLE).setSelections(Registry.ITEM.stream().sorted(Comparator.comparing(Item::toString)).collect(Collectors.toCollection(LinkedHashSet::new))).setSaveConsumer(item -> System.out.println("save this " + item)).build());
        colors.add(entryBuilder.startDropdownMenu(new TranslatableText("lol apple"), DropdownMenuBuilder.TopCellElementBuilder.ofItemObject(Items.APPLE), DropdownMenuBuilder.CellCreatorBuilder.ofItemObject()).setDefaultValue(Items.APPLE).setSelections(Registry.ITEM.stream().sorted(Comparator.comparing(Item::toString)).collect(Collectors.toCollection(LinkedHashSet::new))).setSaveConsumer(item -> System.out.println("save this " + item)).build());
        SubCategoryBuilder innerColors = entryBuilder.startSubCategory(new TranslatableText("Inner Colors")).setExpanded(true);
        innerColors.add(entryBuilder.startDropdownMenu(new TranslatableText("lol apple"), DropdownMenuBuilder.TopCellElementBuilder.ofItemObject(Items.APPLE), DropdownMenuBuilder.CellCreatorBuilder.ofItemObject()).setDefaultValue(Items.APPLE).setSelections(Registry.ITEM.stream().sorted(Comparator.comparing(Item::toString)).collect(Collectors.toCollection(LinkedHashSet::new))).setSaveConsumer(item -> System.out.println("save this " + item)).build());
        innerColors.add(entryBuilder.startDropdownMenu(new TranslatableText("lol apple"), DropdownMenuBuilder.TopCellElementBuilder.ofItemObject(Items.APPLE), DropdownMenuBuilder.CellCreatorBuilder.ofItemObject()).setDefaultValue(Items.APPLE).setSelections(Registry.ITEM.stream().sorted(Comparator.comparing(Item::toString)).collect(Collectors.toCollection(LinkedHashSet::new))).setSaveConsumer(item -> System.out.println("save this " + item)).build());
        innerColors.add(entryBuilder.startDropdownMenu(new TranslatableText("lol apple"), DropdownMenuBuilder.TopCellElementBuilder.ofItemObject(Items.APPLE), DropdownMenuBuilder.CellCreatorBuilder.ofItemObject()).setDefaultValue(Items.APPLE).setSelections(Registry.ITEM.stream().sorted(Comparator.comparing(Item::toString)).collect(Collectors.toCollection(LinkedHashSet::new))).setSaveConsumer(item -> System.out.println("save this " + item)).build());
        SubCategoryBuilder innerInnerColors = entryBuilder.startSubCategory(new TranslatableText("Inner Inner Colors")).setExpanded(true);
        innerInnerColors.add(
            entryBuilder.startDropdownMenu(
                new TranslatableText("lol apple"),
                DropdownMenuBuilder.TopCellElementBuilder.ofItemObject(Items.APPLE),
                DropdownMenuBuilder.CellCreatorBuilder.ofItemObject()
            ).setDefaultValue(Items.APPLE)
            .setSelections(
                Registry.ITEM
                .stream()
                .sorted(Comparator.comparing(Item::toString))
                .collect(Collectors.toCollection(LinkedHashSet::new))
            )
            .setSaveConsumer(item -> System.out.println("save this " + item))
            .build());
            
        innerInnerColors.add(entryBuilder.startDropdownMenu(new TranslatableText("lol apple"), DropdownMenuBuilder.TopCellElementBuilder.ofItemObject(Items.APPLE), DropdownMenuBuilder.CellCreatorBuilder.ofItemObject()).setDefaultValue(Items.APPLE).setSelections(Registry.ITEM.stream().sorted(Comparator.comparing(Item::toString)).collect(Collectors.toCollection(LinkedHashSet::new))).setSaveConsumer(item -> System.out.println("save this " + item)).build());
        innerInnerColors.add(entryBuilder.startDropdownMenu(new TranslatableText("lol apple"), DropdownMenuBuilder.TopCellElementBuilder.ofItemObject(Items.APPLE), DropdownMenuBuilder.CellCreatorBuilder.ofItemObject()).setDefaultValue(Items.APPLE).setSelections(Registry.ITEM.stream().sorted(Comparator.comparing(Item::toString)).collect(Collectors.toCollection(LinkedHashSet::new))).setSaveConsumer(item -> System.out.println("save this " + item)).build());
        innerColors.add(innerInnerColors.build());
        colors.add(innerColors.build());
        testing.addEntry(colors.build());
        testing.addEntry(entryBuilder.startDropdownMenu(new TranslatableText("Suggestion Random Int"), DropdownMenuBuilder.TopCellElementBuilder.of(10,
                s -> {
                    try {
                        return Integer.parseInt(s);
                    } catch (NumberFormatException ignored) {
                        
                    }
                    return null;
                })).setDefaultValue(10).setSelections(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)).build());
        testing.addEntry(entryBuilder.startDropdownMenu(new TranslatableText("Selection Random Int"), DropdownMenuBuilder.TopCellElementBuilder.of(10,
                s -> {
                    try {
                        return Integer.parseInt(s);
                    } catch (NumberFormatException ignored) {
                        
                    }
                    return null;
                })).setDefaultValue(5).setSuggestionMode(false).setSelections(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)).build());
        testing.addEntry(new NestedListListEntry<Pair<Integer, Integer>, MultiElementListEntry<Pair<Integer, Integer>>>(
                new TranslatableText("Nice"),
                Lists.newArrayList(new Pair<>(10, 10), new Pair<>(20, 40)),
                false,
                Optional::empty,
                list -> {},
                () -> Lists.newArrayList(new Pair<>(10, 10), new Pair<>(20, 40)),
                entryBuilder.getResetButtonKey(),
                true,
                true,
                (elem, nestedListListEntry) -> {
                    if (elem == null) {
                        Pair<Integer, Integer> newDefaultElemValue = new Pair<>(10, 10);
                        return new MultiElementListEntry<>(new TranslatableText("Pair"), newDefaultElemValue,
                                Lists.newArrayList(entryBuilder.startIntField(new TranslatableText("Left"), newDefaultElemValue.getLeft()).setDefaultValue(10).build(),
                                        entryBuilder.startIntField(new TranslatableText("Right"), newDefaultElemValue.getRight()).setDefaultValue(10).build()),
                                true);
                    } else {
                        return new MultiElementListEntry<>(new TranslatableText("Pair"), elem,
                                Lists.newArrayList(entryBuilder.startIntField(new TranslatableText("Left"), elem.getLeft()).setDefaultValue(10).build(),
                                        entryBuilder.startIntField(new TranslatableText("Right"), elem.getRight()).setDefaultValue(10).build()),
                                true);
                    }
                }
        ));
        testing.addEntry(entryBuilder.startTextDescription(
                new TranslatableText("text.cloth-config.testing.1",
                    new TranslatableText("ClothConfig"),
                    new TranslatableText("text.cloth-config.testing.2"),
                    new TranslatableText("text.cloth-config.testing.3")
                )
        ).build());
        builder.transparentBackground();
        return builder;
    }    
}
