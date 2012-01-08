package org.cain.cfvouchers.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cfvouchers.CFVouchers;

public class RedeemCommand implements CommandExecutor {

	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		
		int amount = CFVouchers.pl.getConfig().getInt("vouchers." + args[0]);
		String voucher = CFVouchers.pl.getConfig().getString("vouchers." + args[0]);
		
		if(l.equalsIgnoreCase("redeem")) {
			
			if(args.length < 1) { return false; }
			else {
				if(s instanceof Player) {
					if(voucher != null) {
						CFVouchers.economy.depositPlayer(((Player) s).getName(), amount);
						((Player) s).sendMessage(ChatColor.GREEN + "" + amount + " has been redeemed into your account!");
						voucher = null;
					} else {
						((Player) s).sendMessage(ChatColor.RED + "This voucher does not exist. (" + args[0] + ")");
					}
				} else {
					System.out.println("[YOU MAY NOT REDEEM TICKETS IN CONSOLE]");
				}
			}
		}
		return true;
	}

}
