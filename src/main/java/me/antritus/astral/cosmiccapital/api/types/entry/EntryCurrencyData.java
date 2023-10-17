package me.antritus.astral.cosmiccapital.api.types.entry;

import com.google.gson.annotations.Expose;
import me.antritus.astral.cosmiccapital.api.CosmicCapitalAPI;
import me.antritus.astral.cosmiccapital.api.managers.ICurrencyManager;
import me.antritus.astral.cosmiccapital.api.providers.CosmicCapitalProvider;
import me.antritus.astral.cosmiccapital.api.types.currency.ICurrency;

public class EntryCurrencyData {
	@Expose(deserialize = false, serialize = false)
	private ICurrency currency;
	@Expose
	private String currencyName;
	@Expose
	private final double balanceBefore;
	@Expose
	private final double balanceAfter;
	@Expose
	private final double balanceChange;

	protected EntryCurrencyData(double balanceBefore, double balanceAfter, double balanceChange) {
		this.balanceBefore = balanceBefore;
		this.balanceAfter = balanceAfter;
		this.balanceChange = balanceChange;
	}
	public EntryCurrencyData(double balanceBefore, double balanceAfter){
		this.balanceBefore = balanceBefore;
		this.balanceAfter = balanceAfter;
		this.balanceChange = balanceBefore-balanceAfter;
	}
	private EntryCurrencyData(){
		this.currency = null;
		this.currencyName = null;
		this.balanceBefore = 0;
		this.balanceAfter = 0;
		this.balanceChange = 0;
	}

	/**
	 * Currency for this bundle
	 * @return currency
	 */
	public ICurrency currency() {
		if (currencyName != null && currency == null){
			CosmicCapitalAPI api = CosmicCapitalProvider.getAPI();
			if (api == null){
				throw new IllegalStateException(CosmicCapitalProvider.class.getName() +"#getAPI() is null! Please wait until using this method!");
			}
			ICurrencyManager currencyManager = api.currencyManager();
			ICurrency currency = currencyManager.getCurrency(currencyName);
			if (currency == null){
				return null;
			}
			this.currency = currency;
		}
		return currency;
	}

	/**
	 * Returns name of the currency in this bundle
	 * @return currency's name
	 */
	public String currencyName() {
		if (currencyName == null && currency != null){
			currencyName = currency.name();
		}
		return currencyName;
	}

	public double balanceBefore() {
		return balanceBefore;
	}

	public double balanceAfter() {
		return balanceAfter;
	}

	public double balanceChange() {
		return balanceChange;
	}
}