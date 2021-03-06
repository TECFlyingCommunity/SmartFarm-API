package io.github.tecflyingcommunity.smartfarmapi.data.repositories;

import io.github.tecflyingcommunity.smartfarmapi.data.datasources.SensorDataSource;
import io.github.tecflyingcommunity.smartfarmapi.domain.dtos.NewSensorDTO;
import io.github.tecflyingcommunity.smartfarmapi.domain.dtos.SensorDTO;
import io.github.tecflyingcommunity.smartfarmapi.domain.entities.SensorEntity;
import io.github.tecflyingcommunity.smartfarmapi.domain.repositories.SensorRepository;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class SensorRepositoryImpl implements SensorRepository {

    private final SensorDataSource sensorDataSource;

    public SensorRepositoryImpl(SensorDataSource sensorDataSource) {
        this.sensorDataSource = sensorDataSource;
    }

    @Override
    public List<SensorDTO> findAll() {
        final List<SensorEntity> sensorEntities = sensorDataSource.findTop200ByOrderByCreatedAtDesc();
        Collections.reverse(sensorEntities);
        return sensorEntities.stream().map(SensorDTO::new).toList();
    }

    @Override
    public Optional<SensorDTO> findById(Long id) {
        return sensorDataSource.findById(id).map(SensorDTO::new);
    }

    @Override
    public SensorEntity save(NewSensorDTO newSensorDTO) {
        return sensorDataSource.save(newSensorDTO.toEntity());
    }

}
