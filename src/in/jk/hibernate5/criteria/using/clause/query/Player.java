package in.jk.hibernate5.criteria.using.clause.query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_player")
public class Player {
	
	@Id
	@Column(name="player_id")
	private int playerId;
	@Column(name="player_name")
	private String palyerName;
	@Column(name="code")
	private String country;
	@Column(name="country_code")
	private int countryCode;
	
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPalyerName() {
		return palyerName;
	}
	public void setPalyerName(String palyerName) {
		this.palyerName = palyerName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}
	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", palyerName=" + palyerName + ", country=" + country + ", countryCode="
				+ countryCode + "]";
	}
	
	
	
	

}
