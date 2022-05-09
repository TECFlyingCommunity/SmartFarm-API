package io.github.tecflyingcommunity.smartfarmapi.domain.dtos;

import io.github.tecflyingcommunity.smartfarmapi.domain.entities.SensorEntity;

public record NewSensorDTO(
        Double temperature,

        Double luminosity,

        Double airHumidity,

        Double soilHumidity
) {
    public NewSensorDTO(SensorEntity entity) {
        this(
                entity.getTemperature(),
                entity.getLuminosity(),
                entity.getAirHumidity(),
                entity.getSoilHumidity()
        );
    }

    public SensorEntity toEntity() {
        final SensorEntity entity = new SensorEntity();
        entity.setTemperature(this.temperature);
        entity.setLuminosity(this.luminosity);
        entity.setAirHumidity(this.airHumidity);
        entity.setSoilHumidity(this.soilHumidity);
        return entity;
    }
}