package in.jk.hibernate5.criteria.paramter.query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_city")
public class City {
	
	@Id
	@Column(name="")
	private int cityId;
	@Column(name="cityName")
	private String cityName;
	@Column(name="state")
	private String state;
	@Column(name="country")
	private String country;
	
	
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + ", state=" + state + ", country=" + country + "]";
	}
	
	

}
