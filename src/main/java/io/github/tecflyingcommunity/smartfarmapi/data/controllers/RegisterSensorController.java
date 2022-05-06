package io.github.tecflyingcommunity.smartfarmapi.data.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.tecflyingcommunity.smartfarmapi.data.config.PathRest;
import io.github.tecflyingcommunity.smartfarmapi.domain.dtos.SensorDTO;
import io.github.tecflyingcommunity.smartfarmapi.domain.entities.SensorEntity;
import io.github.tecflyingcommunity.smartfarmapi.domain.usecases.RegisterSensor;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = PathRest.API + PathRest.VERSION + PathRest.SENSOR)
public class RegisterSensorController {
	
	private final RegisterSensor registerSensor;

	public RegisterSensorController(RegisterSensor registerSensor) {
		this.registerSensor = registerSensor;
	}
	
	@Operation(summary = "Cadastrar um novo sensor")
	@PostMapping
	public ResponseEntity<SensorDTO> registerSensor(SensorDTO sensorDto) {
		SensorEntity sensor = registerSensor.save(sensorDto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(sensor.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	

}