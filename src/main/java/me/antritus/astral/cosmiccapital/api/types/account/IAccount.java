package me.antritus.astral.cosmiccapital.api.types.account;

import me.antritus.astral.cosmiccapital.api.IEconomyProvider;
import me.antritus.astral.cosmiccapital.api.types.currency.CurrencyBundle;
import me.antritus.astral.cosmiccapital.api.types.currency.ICurrency;
import me.antritus.astral.cosmiccapital.api.types.entry.CreatesEntry;
import me.antritus.astral.cosmiccapital.api.types.entry.EntryType;
import me.antritus.astral.cosmiccapital.api.types.operator.Operator;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

@SuppressWarnings("unused")
public interface IAccount {

	/**
	 * Returns the unique id for this account
	 * @return id
	 */
	@NotNull
	UUID uniqueId();

	/**
	 * Returns the name for this account.
	 * @return name
	 */
	@NotNull
	String name();

	/**
	 * Returns the date this account was created.
	 * @return creation date (millis)
	 */
	long created();

	/**
	 * Gets the currency for this account.
	 * @return currency, else null
	 */
	@Nullable
	ICurrency<?>[] currency();

	/**
	 * Returns the balance of the account.
	 * @param currency currency
	 * @return balance
	 */
	double balance(ICurrency<?> currency);

	/**
	 * Returns the balance of given currency in the account.
	 * @param currencyName currency name
	 * @return balance
	 */
	double balance(String currencyName);

	CurrencyBundle[] currencyBundles();



	/**
	 * Sends money from account to another account.
	 *
	 * @param economy economy plugin
	 * @param to      economy account
	 * @param currencyBundle currencyBundle
	 * @param information extra information of this action
	 */
	@CreatesEntry
	void transfer(@NotNull IEconomyProvider<?> economy, @NotNull IAccount to, @Nullable String information, CurrencyBundle... currencyBundle);

	/**
	 * Allows receiving transfers from other accounts.
	 * @param economyProvider economy provider
	 * @param from account receiving from
	 * @param currencyBundle currencies and amounts received
	 * @param information extra information of this action
	 */
	@ApiStatus.Internal
	void receive(@NotNull IEconomyProvider<?> economyProvider, @NotNull IAccount from, @Nullable String information, CurrencyBundle... currencyBundle);


	/**
	 * Sets the balance of the account to given amount
	 *
	 * @param economy economy provider
	 * @param operator operator that executed given operation
	 * @param currencyBundle currencyBundle
	 * @param information extra information of this action
	 */
	@CreatesEntry
	void operatorSet(@NotNull IEconomyProvider<?> economy, @NotNull Operator operator, @Nullable String information, CurrencyBundle... currencyBundle);

	/**
	 * Resets balance of the given currency from the account.
	 *
	 * @param economy economy provider
	 * @param currency currency
	 * @param operator operator that executed given operation
	 * @param information extra information of this action
	 */
	@CreatesEntry
	void operatorReset(@NotNull IEconomyProvider<?> economy, ICurrency<?> currency, @NotNull Operator operator, @Nullable String information);

	/**
	 * Resets all balances and currencies from the account.
	 *
	 * @param economy economy provider
	 * @param operator operator that executed given operation
	 * @param information extra information of this action
	 */
	@CreatesEntry
	void operatorReset(@NotNull IEconomyProvider<?> economy, @NotNull Operator operator, @Nullable String information);

	/**
	 * Adds to the balance of the account.
	 *
	 * @param economy economy provider
	 * @param operator operator that executed given operation
	 * @param currencyBundles currencyBundle
	 * @param information extra information of this action
	 */
	@CreatesEntry
	void operatorAdd(@NotNull IEconomyProvider<?> economy, @NotNull Operator operator, @Nullable String information, CurrencyBundle... currencyBundles);

	/**
	 * Removes from the balance of the account.
	 *
	 * @param economy economy provider
	 * @param operator operator that executed given operation
	 * @param currencyBundle currencyBundle
	 * @param information extra information of this action
	 */
	@CreatesEntry
	void operatorRemove(@NotNull IEconomyProvider<?> economy, @NotNull Operator operator, @Nullable String information, CurrencyBundle... currencyBundle);

	/**
	 * Custom method to allow plugins to do their own actions.
	 *
	 * @param economy economy provider
	 * @param account account to receive/transfer to/from
	 * @param action  action
	 * @param currencyBundles currencyBundle
	 * @param information extra information of this action
	 */
	@CreatesEntry
	void custom(@NotNull IEconomyProvider<?> economy, @NotNull IAccount account, @NotNull IAccount.CustomAction action, @Nullable String information, CurrencyBundle... currencyBundles);

	/**
	 * Custom method to allow plugins to do their own actions.
	 *
	 * @param economy economy provider
	 * @param operator operator that executed given operation
	 * @param action  action
	 * @param currencyBundle currencyBundle
	 * @param information extra information of this action
	 */
	@CreatesEntry
	void custom(@NotNull IEconomyProvider<?> economy, @NotNull Operator operator, @NotNull IAccount.CustomAction action, @Nullable String information, CurrencyBundle... currencyBundle);

	/**
	 * Custom method to allow plugins to do their own actions.
	 *
	 * @param economy economy provider
	 * @param action  action
	 * @param currencyBundle currencyBundle
	 * @param information extra information of this action
	 */
	@CreatesEntry
	void custom(@NotNull IEconomyProvider<?> economy, @NotNull IAccount.CustomAction action, @Nullable String information, CurrencyBundle... currencyBundle);

	/**
	 * Custom method to allow plugins to do their own actions.
	 *
	 * @param economy economy provider
	 * @param account account to receive/transfer to/from
	 * @param operator operator that executed given operation
	 * @param action  action
	 * @param currencyBundle currencyBundle
	 * @param information extra information of this action
	 */
	@CreatesEntry
	void custom(@NotNull IEconomyProvider<?> economy, @Nullable IAccount account, @Nullable Operator operator, @NotNull IAccount.CustomAction action, @Nullable String information, CurrencyBundle... currencyBundle);


	/**
	 * Custom reset method to allow factions to do their own actions.
	 *
	 * @param economy economy plugin
	 * @param currency currency
	 * @param operator operator
	 * @param information extra information of this action
	 */
	@CreatesEntry
	void customReset(@NotNull IEconomyProvider<?> economy, ICurrency<?> currency, @NotNull Operator operator, @Nullable String information);

	/**
	 * Custom reset method to allow factions to do their own actions.
	 *
	 * @param economy economy plugin
	 * @param operator operator
	 * @param information extra information of this action
	 */
	@CreatesEntry
	void customReset(@NotNull IEconomyProvider<?> economy, @NotNull Operator operator, @Nullable String information);

	/**
	 * Custom reset method to allow factions to do their own actions.
	 *
	 * @param economy economy plugin
	 * @param currency currency
	 * @param information extra information of this action
	 */
	@CreatesEntry
	void customReset(@NotNull IEconomyProvider<?> economy, ICurrency<?> currency, @Nullable String information);

	/**
	 * Custom reset method to allow factions to do their own actions.
	 *
	 * @param economy economy plugin
	 * @param information extra information of this action
	 */
	@CreatesEntry
	void customReset(@NotNull IEconomyProvider<?> economy, @Nullable String information);


	enum CustomAction {
		/**
		 * Adds to the account's balance
		 */
		ADD(EntryType.ADD),
		/**
		 * Removes from the account's balance
		 */
		REMOVE(EntryType.REMOVE),
		/**
		 * Sets the account's balance
		 */
		SET(EntryType.SET),
		;

		private final EntryType entryType;
		CustomAction(EntryType entryType){
			this.entryType = entryType;
		}

		public EntryType entryType() {
			return entryType;
		}
	}

}
