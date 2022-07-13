package Assignment_Canhnhph17851.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import Assignment_Canhnhph17851.entities.Carts;

public interface CartRepository extends JpaRepository<Carts, Integer> {
	@Query("SELECT o FROM Carts o WHERE o.account.id = :accountId AND o.product.id = :productId ")
	public Carts findByAccountIdAndProductId(@Param("accountId") int accountId , @Param("productId") int productId);
}
