package io.helidon.examples.quickstart.mp;

import java.util.Arrays;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.micronaut.context.event.StartupEvent;
import io.micronaut.core.annotation.TypeHint;
import io.micronaut.runtime.event.annotation.EventListener;

@Singleton
@TypeHint(typeNames = {"org.h2.Driver", "org.h2.mvstore.db.MVTableEngine"})
public class DbPopulateData {
    private final DbOwnerRepository ownerRepository;
    @Inject
    DbPopulateData(DbOwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @EventListener
    void init(StartupEvent event) {
        Owner fred = new Owner("Fred");
        fred.setAge(45);
        Owner barney = new Owner("Barney");
        barney.setAge(40);
        ownerRepository.saveAll(Arrays.asList(fred, barney));
    }
}