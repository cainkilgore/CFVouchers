package org.cain.cfvouchers;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.cain.cfvouchers.Commands.CreateCommand;
import org.cain.cfvouchers.Commands.RedeemCommand;

public class CFVouchers extends JavaPlugin {
	
	public static CFVouchers pl;
    public static Economy economy = null;
	
	public void onEnable() {
		pl = this;
		try {
			Bukkit.getServer().getPluginCommand("redeem").setExecutor(new RedeemCommand());
			Bukkit.getServer().getPluginCommand("createcode").setExecutor(new CreateCommand());
			setupEconomy();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("[CFVouchers] CFVouchers found an error. Shutting down for safety.");
			Bukkit.getServer().getPluginManager().disablePlugin(this);
		}
		System.out.println("[CFVouchers] CFVouchers has been enabled!");
	}
	
	public void onDisable() {
		System.out.println("[CFVouchers] CFVouchers has been disabled and is no longer active on the server.");
	}
	
    private Boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }
    

}
