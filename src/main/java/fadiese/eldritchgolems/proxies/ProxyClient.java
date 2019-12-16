package fadiese.eldritchgolems.proxies;

import fadiese.eldritchgolems.entities.WoodenGolemEntity;
import fadiese.eldritchgolems.entities.WoodenGolemRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ProxyClient implements IProxy {

    @Override
    public void init() {
        RenderingRegistry.registerEntityRenderingHandler(WoodenGolemEntity.class, WoodenGolemRenderer::new);
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }

    @Override
    public PlayerEntity getClientPlayer() {
        return Minecraft.getInstance().player;
    }
}
