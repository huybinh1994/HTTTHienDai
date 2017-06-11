package model;

public class loginDTO {
	private MasterDTO master;
	private MerchantsDTO merchants;
	private TokensDTO token;

	public MasterDTO getMaster() {
		return master;
	}
	public void setMaster(MasterDTO master) {
		this.master = master;
	}
	public MerchantsDTO getMerchants() {
		return merchants;
	}
	public void setMerchants(MerchantsDTO merchants) {
		this.merchants = merchants;
	}
	public TokensDTO getToken() {
		return token;
	}
	public void setToken(TokensDTO token) {
		this.token = token;
	}
	
}
