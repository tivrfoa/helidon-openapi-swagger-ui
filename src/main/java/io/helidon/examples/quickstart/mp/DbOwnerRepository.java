package io.helidon.examples.quickstart.mp;

import java.util.List;
import java.util.Optional;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.H2)
public interface DbOwnerRepository extends CrudRepository<Owner, Long> {
    /**
     * Get all owners from the database.
     *
     * @return all owners
     */
    @Override
    List<Owner> findAll();

    /**
     * Find an owner by name.
     *
     * @param name name of owner
     * @return owner if found
     */
    Optional<Owner> findByName(String name);
}