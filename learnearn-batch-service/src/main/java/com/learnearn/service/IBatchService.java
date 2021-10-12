package com.learnearn.service;

import java.time.LocalDateTime;
import java.util.List;

import com.learnearn.exceptions.BatchNotFoundException;
import com.learnearn.exceptions.IdNotFoundException;
import com.learnearn.model.Batch;
import com.learnearn.model.Course;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;

public interface IBatchService {
	Batch addBatch(Batch batch);

	void updateBatch(Batch batch);

	void deleteBatch(int batchId) ;
	List<Batch> getAll();

	Batch getByBatchId(int batchId)throws IdNotFoundException;

	Batch getByBatchName(String batchName) throws BatchNotFoundException;

	List<Batch> getByOwner(String owner)throws BatchNotFoundException;

	List<Batch> getByStartDateAndEndDate(LocalDateTime startDate,LocalDateTime endDate) throws BatchNotFoundException;

	List<Batch> getByStatus( PostStatus status)throws BatchNotFoundException;

	List<Batch> getByPriority(PostPriority priority)throws BatchNotFoundException;
	//both batch and course

	List<Batch> getByBatchNameCourseName(String batchName,String courseName);
	
	List<Batch> getByBatchNameCourseStatus(String batchName,PostStatus status);
	
	List<Batch> getByBatchNameCoursePriority(String batchName,PostPriority priority);
	
	List<Batch> getByBatchNameCourseStartDate(String batchName,LocalDateTime startDate);
	
	List<Batch> getByBatchNameCourseOwner(String batchName,String owner);
	
	//course
	   List<Course> getAllCourses();

		Course addCourse(Course course);

		void updateCourse(Course course);

		void deleteCourse(int courseId);
		
		//derived
		Course getByCourseId(int courseId);
		List<Course> getByCourseName(String courseName);
		List<Course> getByCourseOwner(String owner);
		List<Course> getByStratDateAndEndDate(LocalDateTime startDate,LocalDateTime endDate);
		List<Course> getByCourseStatus(PostStatus status);
		List<Course> getByCoursePriority(PostPriority priority);
		
//		//custom
//		List<Course> getByCompanyNameCourseName(String companyName,String courseName);
//		List<Course> getByBatchNameCourseName(String batchName,String courseName);
//		List<Course> getByCompanyNameCourseStatus(String companyName,PostStatus status);
//		List<Course> getByCompanyNameCoursePriority(String companyName,PostPriority priority);
//		List<Course> getByBatchNameCourseStatus(String bacthName,PostStatus status);
//		List<Course> getByBatchNameCoursePriority(String bacthName,PostPriority priority);
	
}
