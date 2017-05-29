package app.controller;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mysql.cj.core.util.StringUtils;

import app.entities.Job;
import app.entities.dao.JobRepository;

@Controller
public class JobController {

	private JobRepository repository;
	
	@Autowired
	public JobController(JobRepository repository){
		this.repository = repository;
	}
	
	@GetMapping("/job")
    public String getJobs(Model model) {

        model.addAttribute("jobs", repository.findAll());
        model.addAttribute("job", new Job());
        return "index";
	 }
	
	@GetMapping("/add")
    public String goAdd(Model model) {
        return "add";
	 }
	
	@PostMapping("/job/add")
	@Transactional
    public String addJob(@ModelAttribute Job job) {
		repository.save(job);
        return "redirect:/job";
    }
	
	@GetMapping("/job/id={id}")
    public String selectJob(@PathVariable("id") Long id, HttpSession session) {
        session.setAttribute("jobOld", repository.findOne(id));
        return "edit";
    }
	
	@GetMapping("/job/view/id={id}")
    public String viewJob(@PathVariable("id") Long id, HttpSession session) {
        session.setAttribute("jobOld", repository.findOne(id));
        return "see";
    }
  
	
    @DeleteMapping("/job/{id}")
    @Transactional
    public String deleteProduct(@PathVariable("id") Long id) {
    	repository.delete(id);
        return "redirect:/job";
    }
    
    @PostMapping("/job/id={id}/save")
    @Transactional
    public String saveProduct(@PathVariable("id") Long id, @ModelAttribute Job job, HttpSession session) {
        Job p = repository.findOne(id);
        
        if(!StringUtils.isEmptyOrWhitespaceOnly(job.getDenumireJob()))
        	p.setDenumireJob(job.getDenumireJob());
        
        if(!StringUtils.isEmptyOrWhitespaceOnly(job.getDescriereJob()))
        	p.setDescriereJob(job.getDescriereJob());
        
        if(!StringUtils.isEmptyOrWhitespaceOnly(job.getDenumireFirma()))
        	p.setDenumireFirma(job.getDenumireFirma());
        
        if(!StringUtils.isEmptyOrWhitespaceOnly(job.getDomeniu()))
        	p.setDomeniu(job.getDomeniu());
        
        if(!StringUtils.isEmptyOrWhitespaceOnly(job.getOras()))
        	p.setOras(job.getOras());
        
        if(!StringUtils.isEmptyOrWhitespaceOnly(job.getNivelCariera()))
        	p.setNivelCariera(job.getNivelCariera());

        session.invalidate();
        return "redirect:/job";
    }
}
