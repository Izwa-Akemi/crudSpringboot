package crud.exampe.model.entity;

import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admin")
public class AdminEntity {


	@Id
	@Column(name="admin_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long adminId;

	@NonNull
	@Column(name="admin_name")
	private String adminName;

	@NonNull
	@Column(name="admin_email")
	private String adminEmail;

	@NonNull
	@Column(name="password")
	private String password;


	public AdminEntity() {

	}

	public AdminEntity(Long adminId, String adminName, String adminEmail, String password) {
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.password = password;
	}

	public AdminEntity(String adminName, String adminEmail, String password) {
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.password = password;
	}



	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminEntity [adminId=" + adminId + ", adminName=" + adminName + ", adminEmail=" + adminEmail
				+ ", password=" + password + "]";
	}
}