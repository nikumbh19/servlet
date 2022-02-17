package com.model.persistence.trainee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.model.exceptions.DataAccessException;
import com.model.exceptions.TraineeNotFoundException;
import com.model.persistence.factory.ConnectionFactory;

public class TraineeDaoImpl implements TraineeDao{

	private Connection connection;
	
	public TraineeDaoImpl() {
		connection = ConnectionFactory.getConnection();
	}
	
	@Override
	public Trainee addTrainee(Trainee trainee) {
		try {
			PreparedStatement insertData = connection
					.prepareStatement("insert into trainee(" + "name,branch,percentage) values (?,?,?)",
							Statement.RETURN_GENERATED_KEYS);
			insertData.setString(1, trainee.getName());
			insertData.setString(2, trainee.getBranch().toString());
			insertData.setDouble(3, trainee.getPercentage());
			insertData.executeUpdate();
			
			ResultSet rs = insertData.getGeneratedKeys();
			
			if(rs.next()) {
				trainee.setId(rs.getInt(1));
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return trainee;
	}

	@Override
	public List<Trainee> getAll() throws DataAccessException {
		List<Trainee> trainees = new ArrayList<>();
		try {
			Trainee trainee = null;
			PreparedStatement statement = connection.prepareStatement("select * from trainee");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				trainee = new Trainee(result.getInt(1), result.getString(2), BranchEnum.valueOf(result.getString(3).toUpperCase()),result.getDouble(4));
				trainees.add(trainee);
			}
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}
		return trainees;
	}

	@Override
	public Optional<Trainee> getById(int id) throws TraineeNotFoundException {
		Trainee trainee = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select * from trainee where id=?");
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				trainee = new Trainee(result.getInt(1), result.getString(2), BranchEnum.valueOf(result.getString(3).toUpperCase()),result.getDouble(4));
			}else {
				throw new TraineeNotFoundException("trainee with id= "+id+" is not found");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(trainee);
	}

}
