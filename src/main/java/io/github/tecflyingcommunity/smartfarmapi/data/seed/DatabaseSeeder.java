package io.github.tecflyingcommunity.smartfarmapi.data.seed;

import io.github.tecflyingcommunity.smartfarmapi.data.seed.data.SensorData;
import io.github.tecflyingcommunity.smartfarmapi.domain.usecases.RegisterSensor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final List<DataSeed> dataSeeds;

    public DatabaseSeeder(
            RegisterSensor registerSensor
    ) {
        this.dataSeeds = List.of(
                // new SensorData(registerSensor)
        );
    }

    @Override
    public void run(String... args) throws Exception {
        dataSeeds.forEach(DataSeed::create);
    }
}
