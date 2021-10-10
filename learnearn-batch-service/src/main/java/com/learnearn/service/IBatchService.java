package com.learnearn.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.learnearn.model.Batch;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;

public interface IBatchService {
	Batch addBatch(Batch batch);

	void updateBatch(Batch batch);

	void deleteBatch(int batchId);
	List<Batch> getAll();

	Batch getByBatchId(int batchId);

	Batch getByBatchName(String batchName);

	List<Batch> getByOwner(String owner);

	List<Batch> getByStartDateAndEndDate(LocalDateTime startDate,LocalDateTime endDate);

	List<Batch> getByStatus( PostStatus status);

	List<Batch> getByPriority(PostPriority priority);

	List<Batch> getByBatchNameCourseName(String batchName);
	
	List<Batch> getByBatchNameCourseStatus(String batchName,PostStatus status);
	
	List<Batch> getByBatchNameCoursePriority(String batchName,PostPriority priority);
	
	List<Batch> getByBatchNameCourseStartDate(String batchName,LocalDateTime startDate);
	
	List<Batch> getByBatchNameCourseOwner(String batchName,String owner);
	
}
