package com.xebia.myapp.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xebia.myapp.domain.Person;
import com.xebia.myapp.service.PersonService;

@Controller
@RequestMapping(value = "/person")
public class PersonController {

	@Autowired
	PersonService personService;
	
	@Autowired
	ServletContext context;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView addPersonPage() {
            ModelAndView modelAndView = new ModelAndView("person-add");
            modelAndView.addObject("person-form", new Person());
            return modelAndView;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String addingPerson(@ModelAttribute("person-form") @Valid Person person, BindingResult result, 
    		RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest, HttpSession session) {
    		
    		if(result.hasErrors()){
    			return "person-add";
    		}
    		
			personService.addPerson(person);
    		
    		System.out.println(person);
    		
    		// In order to avoid duplicate submission of the form (on clicking 'refresh' of browser) we cannot use below code
    		// we will land in home.jsp, but be able to do multiple POSTs which is wrong behaviour 
            /*ModelAndView modelAndView = new ModelAndView("home");
            String message = "Person was successfully added.";
            modelAndView.addObject("message", message);
            return modelAndView;*/
    		
    		// The below model map is not available after redirect
    		//ModelMap model = new ModelMap("message","Person was successfully added.");
    		// and the below attribute gets available in the url as (... ? param=value ...) but not in the model
    		//redirectAttributes.addAttribute("message","Person was successfully added.");
    		
    		System.out.println(context.getContextPath());
    		System.out.println(httpServletRequest.getContextPath());
    		
    		// the flash attribute gets added to the FlashMap's output Map in case of a redirect and hence the model Map receives it
    		redirectAttributes.addFlashAttribute("message","Person was successfully added.");
        		
            // POST/REDIRECT/GET pattern
           return "redirect:/welcome/home.ini";
    }
    
    @RequestMapping(value = "/list" , method = RequestMethod.GET)
	public ModelAndView listOfPersons(){
		
		ModelAndView modelAndView = new ModelAndView("person-list");
		
		List<Person> listOfPersons = personService.getPersons();
        modelAndView.addObject("personsList", listOfPersons);
		
		return modelAndView;
	}
    
    
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editTeamPage(@PathVariable Integer id) {
            ModelAndView modelAndView = new ModelAndView("person-edit");
            Person person = personService.getPerson(id);
            modelAndView.addObject("person", person);
            return modelAndView;
    }
    
    
    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public String edditingTeam(@ModelAttribute Person person, @PathVariable Integer id, RedirectAttributes redirectAttributes) {
            
            personService.updatePerson(person);
            
            String message = "Person was successfully edited.";
            redirectAttributes.addFlashAttribute("message", message);
            
            return "redirect:/welcome/home.ini";
    }
    
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String deleteTeam(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
    	
            personService.deletePerson(id);
            String message = "Person was successfully deleted.";
            redirectAttributes.addFlashAttribute("message", message);
            
            return "redirect:/welcome/home.ini";
    }
    
    
	//////////////////////////////////////////////////////////////// 
	//                         TODO CASE 1
	////////////////////////////////////////////////////////////////
	
	/*@RequestMapping(value = "/list" , method = RequestMethod.GET)
	public ModelAndView listOfPersons(){
		
		ModelAndView modelAndView = new ModelAndView("person-list");
		
		List<Person> listOfPersons = personService.getPersons();
        modelAndView.addObject("personsList", listOfPersons);
		
		return modelAndView;
	}*/
	
	
	////////////////////////////////////////////////////////////////
	//                         TODO CASE 2
	////////////////////////////////////////////////////////////////
	
	/*@RequestMapping(value = "/list" , method = RequestMethod.GET)
	public String listOfPersons(Model modelAndView){
		
		List<Person> listOfPersons = personService.getPersons();
        modelAndView.addAttribute("personsList", listOfPersons);
		
		return "person-list";
	}*/
	
	
	////////////////////////////////////////////////////////////////
	//                         TODO CASE 3
	////////////////////////////////////////////////////////////////
	
	//RequestToViewNameTranslator PREFIX + /person/person-list + SUFFIX
	/*@RequestMapping(value = "/person-list" , method = RequestMethod.GET)
	@ModelAttribute("personsList")
	public List<Person> listOfPersons(){
		
		List<Person> listOfPersons = personService.getPersons();
		
		return listOfPersons;
        
	}*/
	
	////////////////////////////////////////////////////////////////
	//                         TODO CASE 4
	////////////////////////////////////////////////////////////////
	
	//RequestToViewNameTranslator PREFIX + /person/person-list + SUFFIX
	/*@RequestMapping(value = "/person-list" , method = RequestMethod.GET)
	public void listOfPersons(){
		
	}
	
	@ModelAttribute("personsList")
	public List<Person> loadPersonsList(){
		List<Person> listOfPersons = personService.getPersons();
		return listOfPersons;
	}*/
								// 	OR
	
  //RequestToViewNameTranslator PREFIX + /person/person-list + SUFFIX
	/*@RequestMapping(value = "/person-list" , method = RequestMethod.GET)
	public void listOfPersons(HttpServletResponse httpServletResponse) throws IOException{
		// httpServletResponse.setContentType("text/xml");
		// httpServletResponse.setContentType("application/json");
		httpServletResponse.setContentType(MediaType.TEXT_PLAIN_VALUE);
		httpServletResponse.setHeader("CUSTOM_MESSAGE", "Just a simple program");
		httpServletResponse.getOutputStream().println("Hello World !");
	}*/
	
								// 	OR
	
  //RequestToViewNameTranslator PREFIX + /person/person-list + SUFFIX
	/*@RequestMapping(value = "/person-list" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Person> listOfPersons(HttpServletResponse httpServletResponse) throws IOException{
		// httpServletResponse.setContentType("text/xml");
		 httpServletResponse.setContentType("application/json");
		//httpServletResponse.setContentType(MediaType.TEXT_PLAIN_VALUE);
		httpServletResponse.setHeader("CUSTOM_MESSAGE", "Just a simple program");
		not in format of json , but still sent as a part of response : httpServletResponse.getOutputStream().println("Hello World !");
		
		List<Person> listOfPersons = personService.getPersons();
		return listOfPersons;
	}*/
	
	////////////////////////////////////////////////////////////////
	//                         TODO CASE 5
	////////////////////////////////////////////////////////////////
	
	/*@RequestMapping(value = "/list" , method = RequestMethod.GET)
	public ResponseEntity<Person> listOfPersons(){
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<Person>(new Person("Shradha", 42), headers, HttpStatus.BAD_GATEWAY);
	}*/
	
							// OR
	
	/*@RequestMapping(value = "/list" , method = RequestMethod.GET)
	public ResponseEntity<List<Person>> listOfPersons(){
		
		List<Person> listOfPersons = personService.getPersons();
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<List<Person>>(listOfPersons, headers, HttpStatus.BAD_GATEWAY);
	}*/
	
	////////////////////////////////////////////////////////////////
	//                         TODO CASE 6
	////////////////////////////////////////////////////////////////
	
	/*@RequestMapping(value = "/list" , method = RequestMethod.GET) // (,  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Person listOfPersons(){
		return new Person("Shradha", 42);
	}*/
	
							// OR
	
	/*@RequestMapping(value = "/list" , method = RequestMethod.GET) // (,  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Person> listOfPersons(){
		List<Person> listOfPersons = personService.getPersons();
		return listOfPersons;
	}*/
	
	
	////////////////////////////////////////////////////////////////
	//                         TODO CASE 7
	////////////////////////////////////////////////////////////////
	
	/*@responseStatus.OK -> default
	@responseStatus error - > on exception*/
	
}
