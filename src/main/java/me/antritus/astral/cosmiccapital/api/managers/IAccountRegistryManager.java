package me.antritus.astral.cosmiccapital.api.managers;

import me.antritus.astral.cosmiccapital.api.types.account.IAccount;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Allows getting and registering account managers
 */
public interface IAccountRegistryManager {
	/**
	 * Registers a new account manager for specific account class.
	 * @param manager manager
	 * @param accountClazz account class
	 */
	void register(@NotNull IAccountManager manager, @NotNull Class<? extends IAccount> accountClazz);


	/**
	 * Gets account manager from account class.
	 * @param accountClazz account class
	 * @return account manager, else null
	 */
	@Nullable
	IAccountManager getManagerByAccount(@NotNull Class<?> accountClazz);

	/**
	 * Gets account manager from account manager class
	 * @param manager account manager class
	 * @return account manager, else null
	 */
	@Nullable
	IAccountManager getManager(@NotNull Class<? extends IAccountManager> manager);
}
