package org.gnomeffinway.herochat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.dthielke.herochat.ChannelChatEvent;
import com.dthielke.herochat.Chatter;

public class HerochatTest extends JavaPlugin implements Listener{
	
	private PluginManager pm;


	@Override
	public void onEnable() {
		pm = getServer().getPluginManager();
		

		pm.registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		// reset any handles
		pm = null;
	}
	@EventHandler(priority = EventPriority.NORMAL)
  public void onChannelChatEvent(ChannelChatEvent event)
  {
    Player from = event.getSender().getPlayer();
    System.out.println(from);
    String format = event.getFormat();
    System.out.println(format);
    format = format.replaceAll("&r", "§r");
    System.out.println(format);
    if(event.getMessage().equals("gaaah"))
    	event.setResult(Chatter.Result.FAIL);
    System.out.println(event.getMessage());
  }
}
