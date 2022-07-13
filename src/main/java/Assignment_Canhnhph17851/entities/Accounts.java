// Generated with g9.

package Assignment_Canhnhph17851.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import lombok.Data;

@Data
@Entity
@Table(name="accounts")
@NamedQueries(
		@NamedQuery(
				name = "Account.findByUsername",
				query = "SELECT acc FROM Accounts acc WHERE acc.username = :username"))
public class Accounts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;

	@Column(name="fullname")
	private String fullname;

	@Column(name="email")
	private String email;

	@Column(name="photo")
	private String photo;

	@Column(name="activated")
	private int activated;

	@Column(name="admin")
	private int admin;
	@OneToMany(mappedBy = "account")
	private List<Carts> lstCart;
}