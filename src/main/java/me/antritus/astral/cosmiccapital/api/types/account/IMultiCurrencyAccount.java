package me.antritus.astral.cosmiccapital.api.types.account;

import com.google.gson.JsonObject;
import me.antritus.astral.cosmiccapital.api.IEconomyProvider;
import me.antritus.astral.cosmiccapital.api.types.currency.CurrencyBundle;
import me.antritus.astral.cosmiccapital.api.types.currency.ICurrency;
import me.antritus.astral.cosmiccapital.api.types.entry.CreatesEntry;
import me.antritus.astral.cosmiccapital.api.types.operator.Operator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public interface IMultiCurrencyAccount extends IAccount {
	/**
	 * Gets the currency for this account.
	 * @return currency, else null
	 */
	@Nullable
	ICurrency[] currency();

	/**
	 * Returns the balance of the account.
	 * @param currency currency
	 * @return balance
	 */
	double balance(ICurrency currency);

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
	 * @param data extra data about action
	 */
	@CreatesEntry
	void transfer(@NotNull IEconomyProvider economy, @NotNull IAccount to, CurrencyBundle[] currencyBundle, @Nullable JsonObject data);


	/**
	 * Sets the balance of the account to given amount
	 *
	 * @param economy       economy plugin
	 * @param operator operator
	 * @param currencyBundle currencyBundle
	 * @param data extra data about action
	 */
	@CreatesEntry
	void operatorSet(@NotNull IEconomyProvider economy, @NotNull Operator operator, CurrencyBundle[] currencyBundle, @Nullable JsonObject data);

	/**
	 * Resets balance of the account.
	 *
	 * @param economy       economy plugin
	 * @param currency currency
	 * @param operator operator
	 * @param data extra data about action
	 */
	@CreatesEntry
	void operatorReset(@NotNull IEconomyProvider economy, ICurrency currency, @NotNull Operator operator, @Nullable JsonObject data);

	/**
	 * Adds to the balance of the account.
	 *
	 * @param economy       economy plugin
	 * @param operator operator
	 * @param currencyBundle currencyBundle
	 * @param data extra data about action
	 */
	@CreatesEntry
	void operatorAdd(@NotNull IEconomyProvider economy, @NotNull Operator operator, CurrencyBundle[] currencyBundle, JsonObject data);

	/**
	 * Custom method to allow plugins to do their own actions.
	 *
	 * @param economy economy plugin
	 * @param account other account
	 * @param action  action
	 * @param currencyBundles currencyBundle
	 * @param data    extra data about action
	 */
	@CreatesEntry
	void custom(@NotNull IEconomyProvider economy, @NotNull ISingleCurrencyAccount account, @NotNull IAccount.CustomAction action, CurrencyBundle[] currencyBundles, @Nullable JsonObject data);

	/**
	 * Removes from the balance of the account.
	 *
	 * @param economy       economy plugin
	 * @param operator operator
	 * @param currencyBundle currencyBundle
	 * @param data extra data about action
	 */
	@CreatesEntry
	void operatorRemove(@NotNull IEconomyProvider economy, @NotNull Operator operator, CurrencyBundle[] currencyBundle, JsonObject data);

	/**
	 * Custom method to allow plugins to do their own actions.
	 *
	 * @param economy economy plugin
	 * @param operator operator
	 * @param action  action
	 * @param currencyBundle currencyBundle
	 * @param data    extra data about action
	 */
	@CreatesEntry
	void custom(@NotNull IEconomyProvider economy, @NotNull Operator operator, @NotNull IAccount.CustomAction action, CurrencyBundle[] currencyBundle, @Nullable JsonObject data);

	/**
	 * Custom method to allow factions to do their own actions.
	 *
	 * @param economy economy plugin
	 * @param action  action
	 * @param currencyBundle currencyBundle
	 * @param data    extra data about action
	 */
	@CreatesEntry
	void custom(@NotNull IEconomyProvider economy, @NotNull IAccount action, CurrencyBundle[] currencyBundle, @Nullable JsonObject data);

	/**
	 * Custom reset method to allow factions to do their own actions.
	 *
	 * @param economy economy plugin
	 * @param currency currency
	 * @param operator operator
	 * @param data    extra data about action
	 */
	@CreatesEntry
	void customReset(@NotNull IEconomyProvider economy, ICurrency currency, @NotNull Operator operator, @Nullable JsonObject data);
	/**
	 * Custom reset method to allow factions to do their own actions.
	 *
	 * @param economy economy plugin
	 * @param operator operator
	 * @param data    extra data about action
	 */
	@CreatesEntry
	void customReset(@NotNull IEconomyProvider economy, @NotNull Operator operator, @Nullable JsonObject data);

	/**
	 * Custom reset method to allow factions to do their own actions.
	 *
	 * @param economy economy plugin
	 * @param currency currency
	 * @param data    extra data about action
	 */
	@CreatesEntry
	void customReset(@NotNull IEconomyProvider economy, ICurrency currency, @Nullable JsonObject data);

	/**
	 * Custom reset method to allow factions to do their own actions.
	 *
	 * @param economy economy plugin
	 * @param data    extra data about action
	 */
	@CreatesEntry
	void customReset(@NotNull IEconomyProvider economy, @Nullable JsonObject data);
}