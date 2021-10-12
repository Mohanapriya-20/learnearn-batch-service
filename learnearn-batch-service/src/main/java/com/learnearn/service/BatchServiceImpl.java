package com.learnearn.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learnearn.exceptions.BatchNotFoundException;
import com.learnearn.exceptions.IdNotFoundException;
import com.learnearn.model.Batch;
import com.learnearn.model.Course;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;
import com.learnearn.repository.IBatchRepository;

@Service
public class BatchServiceImpl implements IBatchService {
	
	RestTemplate restTemplate;
	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	@Autowired
	IBatchRepository batchRepository;
	private static final String BASEURL = "http://localhost:8083/course-service/courses";
	//private static final String BASEURL="http://localhost:8082/cart-service/cart";
	List<Course> courseList=new ArrayList<>();
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
	public Batch getByBatchId(int batchId) throws IdNotFoundException{
		Batch batch= batchRepository.findById(batchId);
		if(batch==null)
			throw new IdNotFoundException("Invalid Batch Id!!");
		return batch;
	}

	@Override
	public Batch getByBatchName(String batchName)  throws BatchNotFoundException {
		Batch batch= batchRepository.findByBatchName(batchName);
		if(batch==null)
			throw new IdNotFoundException("Invalid Batch Name!!");
		return batch;
	}

	@Override
	public List<Batch> getByOwner(String owner) throws BatchNotFoundException{
		List<Batch> batchList=batchRepository.findByOwner(owner);
		if(batchList.isEmpty())
			throw new BatchNotFoundException("Invalid Owner Name!!");
		return batchList;
	}

	@Override
	public List<Batch> getByStartDateAndEndDate(LocalDateTime startDate, LocalDateTime endDate)throws BatchNotFoundException {
		List<Batch> batchList= batchRepository.findByStartDateAndEndDate(startDate, endDate);
		if(batchList.isEmpty())
			throw new BatchNotFoundException("Invalid Start and End date!!");
		return batchList;
	}

	@Override
	public List<Batch> getByStatus(PostStatus status)  throws BatchNotFoundException{
		List<Batch> batchList=  batchRepository.findByStatus(status);
		if(batchList.isEmpty())
			throw new BatchNotFoundException("Currently No Batch hold this Status!!");
		return batchList;
	}

	@Override
	public List<Batch> getByPriority(PostPriority priority) throws BatchNotFoundException {
		List<Batch> batchList= batchRepository.findByPriority(priority);
		if(batchList.isEmpty())
			throw new BatchNotFoundException("Currently No Batch hold this Priority!!");
		return batchList;
	}

	@Override
	public List<Batch> getByBatchNameCourseName(String batchName,String courseName) {
		return batchRepository.findByBatchNameCourseName(batchName, courseName);
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

	@Override
	public Course addCourse(Course course) {
		String url=BASEURL;
		Course courseObj=restTemplate.getForObject(url,Course.class);
		return courseObj;
		
	}

	@Override
	public void updateCourse(Course course) {
		String url=BASEURL;
		Course courseObj=restTemplate.getForObject(url,Course.class);
		
	}
	@Override
	public void deleteCourse(int courseId) {
		String url=BASEURL+"/id/"+courseId;
		Course courseObj=restTemplate.getForObject(url,Course.class);
		
		
	}

	@Override
	public List<Course> getAllCourses() {
		String url=BASEURL;
		List<Course> courseList=restTemplate.getForObject(url, List.class);
		return courseList;
	}

	

	@Override
	public Course getByCourseId(int courseId) {
		String url=BASEURL+"/id/"+courseId;
		Course course=restTemplate.getForObject(url,Course.class);
		return course;
	}
	@Override
	public List<Course> getByCourseName(String courseName) {
		String url=BASEURL+"/name/"+courseName;
		return restTemplate.getForObject(url,List.class);
	
	}

	@Override
	public List<Course> getByCourseOwner(String owner) {
		String url=BASEURL+"/owner/"+owner;
		List<Course> courseList=restTemplate.getForObject(url,List.class);
		return courseList;
	}

	@Override
	public List<Course> getByStratDateAndEndDate(LocalDateTime startDate, LocalDateTime endDate) {
		String url=BASEURL+"/startdate/"+startDate+"/enddate/"+endDate;
		return restTemplate.getForObject(url,List.class);
		//return courseList;
	}

	@Override
	public List<Course> getByCourseStatus(PostStatus status) {
		String url=BASEURL+"/status/"+status;
		List<Course> courseList=restTemplate.getForObject(url,List.class);
		return courseList;
	}

	@Override
	public List<Course> getByCoursePriority(PostPriority priority) {
		String url=BASEURL+"/priority/"+priority;
		List<Course> courseList=restTemplate.getForObject(url,List.class);
		return courseList;
	}

	
	

}
