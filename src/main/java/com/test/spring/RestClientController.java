package com.test.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(value="/rest-client-test")
public class RestClientController {

	private static final Log log = LogFactory.getLog(RestClientController.class);

	final static String uri = "http://localhost:8080/spring-rest/rest-test";

	/**
	 *
	 * @return
	 */
	@RequestMapping("/")
    public String welcome() {
        return "Welcome to RestTemplate Client Example.";
    }

	/**
	 *
	 * @param str
	 */
	@RequestMapping(value="/reverse", method=RequestMethod.GET)
	public void getReverseString(@RequestParam("str")String str) {

		RestTemplate restTemplate = new RestTemplate();

	    String result = restTemplate.getForObject(uri+"/str/"+str, String.class);

	    System.out.println(result);
	}

	@RequestMapping(value="/reverse2", method=RequestMethod.GET)
	public String getReverseString2(@RequestParam("str")String str, ModelMap model) {

		RestTemplate restTemplate = new RestTemplate();

	    String reversestring = restTemplate.getForObject(uri+"/str/"+str, String.class);
	    System.out.println(reversestring);
        model.addAttribute("reversestring", reversestring);

        return "result";

	}



}