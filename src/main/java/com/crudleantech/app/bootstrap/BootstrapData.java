package com.crudleantech.app.bootstrap;

import com.crudleantech.app.domain.Position;
import com.crudleantech.app.repository.PositionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BootstrapData implements CommandLineRunner {
    private final PositionRepository positionRepository;

    public BootstrapData(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading Customer Data");

        Position p1 = new Position();
        p1.setName("qa");
        positionRepository.save(p1);

        Position p2 = new Position();
        p2.setName("dev");
        positionRepository.save(p2);

        log.info("Positions Saved: " + positionRepository.count());
    }
}
