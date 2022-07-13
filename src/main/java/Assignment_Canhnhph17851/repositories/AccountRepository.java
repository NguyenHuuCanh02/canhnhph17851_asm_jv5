package Assignment_Canhnhph17851.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import Assignment_Canhnhph17851.entities.Accounts;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Integer> {
//	@Query(value = "SELECT acc FROM Accounts acc WHERE acc.username = :username")
	@Query(name = "Account.findByUsername")
	public Accounts findByUsername(@Param("username") String username);

	@Query("SELECT o FROM Accounts o WHERE o.email = :email")
	public Accounts findByEmail(@Param("email") String email);
}