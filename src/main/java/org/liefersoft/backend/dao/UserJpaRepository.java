package org.liefersoft.backend.dao;

import org.liefersoft.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserJpaRepository extends JpaRepository<User,Long> {
}
