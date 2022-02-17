package com.model.service.trainee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.model.exceptions.DataAccessException;
import com.model.exceptions.TraineeNotFoundException;
import com.model.persistence.trainee.Trainee;
import com.model.persistence.trainee.TraineeDao;
import com.model.persistence.trainee.TraineeDaoImpl;

public class TraineeServiceImpl implements TraineeService{

	private TraineeDao traineeDao;
	
	public TraineeServiceImpl() {
		traineeDao = new TraineeDaoImpl();
	}
	
	@Override
	public Trainee addTrainee(Trainee trainee) {
		return traineeDao.addTrainee(trainee);
	}

	@Override
	public List<Trainee> getAll() throws DataAccessException {
		List<Trainee> trainees = new ArrayList<>();
		trainees = traineeDao.getAll();
		return trainees;
	}

	@Override
	public Optional<Trainee> getById(int id) throws TraineeNotFoundException {
		Optional<Trainee> trainee = traineeDao.getById(id);
		return trainee;
	}

}
