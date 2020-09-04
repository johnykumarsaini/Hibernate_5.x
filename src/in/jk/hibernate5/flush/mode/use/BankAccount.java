package in.jk.hibernate5.flush.mode.use;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_bank_account")
public class BankAccount {
	
	@Id
	@Column(name="account_number")
	private int accountNumber;
	@Column(name="user_name")
	private String userName;
	@Column(name="bank_name")
	private String bankName;
	@Column(name="branch_name")
	private String branchName;
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", userName=" + userName + ", bankName=" + bankName
				+ ", branchName=" + branchName + "]";
	}
	
	

}
