package com.learnearn.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnearn.model.Batch;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;
import com.learnearn.service.IBatchService;

@RestController
@RequestMapping("/batch-service")
public class BatchController {
	IBatchService batchService;
	@Autowired
	public void setBatchService(IBatchService batchService) {
		this.batchService = batchService;
	}
	@PostMapping("/batches")
	Batch addBatch(@RequestBody Batch batch)
	{
		return batchService.addBatch(batch);
	}
	@PutMapping("/batches")
	void updateBatch(@RequestBody Batch batch)
	{
		batchService.updateBatch(batch);
	}
    @DeleteMapping("/batches/batchId/{batchId}")
	void deleteBatch(@PathVariable("batchId") int batchId)
	{
    	batchService.deleteBatch(batchId);
	}
    @GetMapping("/batches")
	public List<Batch> getAll() 
	{
    	return batchService.getAll();
	}
    @GetMapping("/batches/{batchId}")
	Batch getByBatchId(@PathVariable("batchId")  int batchId)
	{
		return batchService.getByBatchId(batchId);
    	
	}
    @GetMapping("/batches/batchName/{batchName}")
    Batch getByBatchName(@PathVariable("batchName")  String batchName)
    {
		return batchService.getByBatchName(batchName);
    	
    }
    @GetMapping("/batches/owner/{owner}")
	List<Batch> getByOwner(@PathVariable("owner")  String owner)
	{
    	return batchService.getByOwner(owner);
	}
    @GetMapping("/batches/startDate/{startDate}/endDate/{endDate}")
	List<Batch> getByStartDateAndEndDate(@PathVariable("startDate")String startDate,@PathVariable("endDate") String endDate)
	{
    	
    	
    	return batchService.getByStartDateAndEndDate(LocalDateTime.parse(startDate),LocalDateTime.parse(endDate));
	}

    @GetMapping("/batches/status/{status}")
	List<Batch> getByStatus(@PathVariable("status") PostStatus status)
	{
    	return batchService.getByStatus(status);
	}
    @GetMapping("/batches/priority/{priority}")
	List<Batch> getByPriority(@PathVariable("priority") PostPriority priority)
	{
    	 return batchService.getByPriority(priority);
	}
//    @GetMapping("/batches/priority/{priority}")
//	List<Batch> getByBatchNameCourseName(String batchName);
//	
//	List<Batch> getByBatchNameCourseStatus(String batchName,PostStatus status);
//	
//	List<Batch> getByBatchNameCoursePriority(String batchName,PostPriority priority);
//	
//	List<Batch> getByBatchNameCourseStartDate(String batchName,LocalDateTime startDate);
	
//	List<Batch> getByBatchNameCourseOwner(String batchName,String owner);


}
