package com.model.service.trainee;

import java.util.List;
import java.util.Optional;

import com.model.exceptions.DataAccessException;
import com.model.exceptions.TraineeNotFoundException;
import com.model.persistence.trainee.Trainee;

public interface TraineeService {
	public Trainee addTrainee(Trainee trainee);
	public List<Trainee> getAll() throws DataAccessException;
	public Optional<Trainee> getById(int id) throws TraineeNotFoundException;

}
