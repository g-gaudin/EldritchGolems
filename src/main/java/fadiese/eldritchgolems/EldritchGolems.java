package fadiese.eldritchgolems;

import fadiese.eldritchgolems.blocks.GolemHead;
import fadiese.eldritchgolems.entities.WoodenGolemEntity;
import fadiese.eldritchgolems.proxies.IProxy;
import fadiese.eldritchgolems.proxies.ProxyClient;
import fadiese.eldritchgolems.proxies.ProxyServer;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(EldritchGolems.MODID)
public class EldritchGolems
{
	public static final String MODID = "eldritchgolems";
	public static final Logger LOGGER = LogManager.getLogger();
	public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ProxyClient(), () -> () -> new ProxyServer());
	
	public EldritchGolems()
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		proxy.init();
	}
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
			event.getRegistry().register(new GolemHead());
		}
		@SubscribeEvent
		public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
			event.getRegistry().register(new BlockItem(EldritchGolemsItems.GOLEMHEAD, new Item.Properties()).setRegistryName("golemhead"));

		}
		@SubscribeEvent
		public static void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> event) {
			event.getRegistry().register(EntityType.Builder.create(WoodenGolemEntity::new, EntityClassification.CREATURE)
					.size(1.4f, 2.7f)
					.setShouldReceiveVelocityUpdates(false)
					.build("woodengolem").setRegistryName(EldritchGolems.MODID, "woodengolem"));

		}
	}
}
