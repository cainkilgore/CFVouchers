package org.cain.cfvouchers.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cain.cfvouchers.CFVouchers;

public class CreateCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("createcode")) {
			if(args.length < 2) { return false; }
			else {
				if(s instanceof Player) {
					if(s.isOp()) {
						CFVouchers.pl.getConfig().set("vouchers." + args[0], args[1]);
						((Player) s).sendMessage(ChatColor.GREEN + "Voucher code '" + args[0] + "' created!");
					} else {
						((Player) s).sendMessage(ChatColor.RED + "You have no permisson to create vouchers.");
					}
				} else {
					CFVouchers.pl.getConfig().set("vouchers." + args[0], args[1]);
					System.out.println(ChatColor.GREEN + "Voucher code created!");
				}
			}
		}
		return true;
	}

}
