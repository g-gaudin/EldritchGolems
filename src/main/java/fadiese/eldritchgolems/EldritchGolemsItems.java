package fadiese.eldritchgolems;

import fadiese.eldritchgolems.blocks.GolemHead;
import fadiese.eldritchgolems.entities.WoodenGolemEntity;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(EldritchGolems.MODID)
public class EldritchGolemsItems {
    @ObjectHolder("golemhead")
    public static GolemHead GOLEMHEAD;
    @ObjectHolder("woodengolem")
    public static EntityType<WoodenGolemEntity> WOODENGOLEM;
}
