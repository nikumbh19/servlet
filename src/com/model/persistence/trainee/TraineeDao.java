package com.model.persistence.trainee;

import java.util.List;
import java.util.Optional;

import com.model.exceptions.DataAccessException;
import com.model.exceptions.TraineeNotFoundException;


//DAO - Data Access Object
public interface TraineeDao {
	public Trainee addTrainee(Trainee trainee);
	public List<Trainee> getAll() throws DataAccessException;
	public Optional<Trainee> getById(int id) throws TraineeNotFoundException;
}
