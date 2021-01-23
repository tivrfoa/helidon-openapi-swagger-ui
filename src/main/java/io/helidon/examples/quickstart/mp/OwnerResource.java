package io.helidon.examples.quickstart.mp;

import javax.inject.Inject;
import javax.validation.constraints.Pattern;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/owners")
public class OwnerResource {
    private final DbOwnerRepository ownerRepository;

    @Inject
    public OwnerResource(DbOwnerRepository ownerRepo) {
        this.ownerRepository = ownerRepo;
    }

    /**
     * Gets all owners from the database.
     * @return all owners, using JSON-B to map them to JSON
     */
    @GET
    public Iterable<Owner> getAll() {
        return ownerRepository.findAll();
    }

    @Path("/{name}")
    @GET
    public Owner owner(@PathParam("name") String name) {
        return ownerRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Owner by name " + name + " does not exist"));
    }
}