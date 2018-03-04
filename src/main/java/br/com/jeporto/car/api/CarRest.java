package br.com.jeporto.car.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jeporto.car.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarRest {

	private CarService service;

	@Autowired
	public CarRest(CarService service) {
		this.service = service;
	}

	@PostMapping(value = "/")
	public ResponseEntity<Car> save(@RequestBody Car car) {
		service.save(car);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}