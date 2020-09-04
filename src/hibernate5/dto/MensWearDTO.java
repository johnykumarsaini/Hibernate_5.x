package hibernate5.dto;


public class MensWearDTO {

	private int productId;
	private String productName;
	private String company;
	private String productType;
	private String price;

	public MensWearDTO(int productId, String productName ,String company, String productType, String price) {
		
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.company = company;
		this.price = price;

	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MensWear [productId=" + productId + ", productName=" + productName + ", company=" + company
				+ ", productType=" + productType + ", price=" + price + "]";
	}

}
