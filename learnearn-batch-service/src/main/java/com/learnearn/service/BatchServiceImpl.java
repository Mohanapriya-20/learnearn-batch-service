package com.learnearn.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.learnearn.model.Batch;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;
import com.learnearn.repository.IBatchRepository;

@Service
public class BatchServiceImpl implements IBatchService {
//	@Autowired
//	RestTemplate restTemplate;
	@Autowired
	IBatchRepository batchRepository;
	//private static final String BASEURL = "http://COMPANY-SERVICE/company-service";

	@Override
	public Batch addBatch(Batch batch) {
		return batchRepository.save(batch);
	}

	@Override
	public void updateBatch(Batch batch) {
		batchRepository.save(batch);
	}

	@Override
	public void deleteBatch(int batchId) {
		batchRepository.deleteById(batchId);
	}
	@Override
	public List<Batch> getAll() {
		return batchRepository.findAll();
	}
	@Override
	public Batch getByBatchId(int batchId) {
		return batchRepository.findById(batchId);
	}

	@Override
	public Batch getByBatchName(String batchName) {
		return batchRepository.findByBatchName(batchName);
	}

	@Override
	public List<Batch> getByOwner(String owner) {
		return batchRepository.findByOwner(owner);
	}

	@Override
	public List<Batch> getByStartDateAndEndDate(LocalDateTime startDate, LocalDateTime endDate) {
		return batchRepository.findByStartDateAndEndDate(startDate, endDate);
	}

	@Override
	public List<Batch> getByStatus(PostStatus status) {
		return batchRepository.findByStatus(status);
	}

	@Override
	public List<Batch> getByPriority(PostPriority priority) {
		return batchRepository.findByPriority(priority);
	}

	@Override
	public List<Batch> getByBatchNameCourseName(String batchName) {
		return batchRepository.findByBatchNameCourseName(batchName, batchName);
	}

	@Override
	public List<Batch> getByBatchNameCourseStatus(String batchName, PostStatus status) {
		return batchRepository.findByBatchNameCourseStatus(batchName, status);
	}

	@Override
	public List<Batch> getByBatchNameCoursePriority(String batchName, PostPriority priority) {
		return batchRepository.findByBatchNameCoursePriority(batchName, priority);
	}

	@Override
	public List<Batch> getByBatchNameCourseStartDate(String batchName, LocalDateTime startDate) {
		return batchRepository.findByBatchNameCourseStartDate(batchName, startDate);
	}

	@Override
	public List<Batch> getByBatchNameCourseOwner(String batchName, String owner) {
		return batchRepository.findByBatchNameCourseOwner(batchName, owner);
	}

	

}
