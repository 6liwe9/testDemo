package test.liwe.contorller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public final class HelloController {

	@RequestMapping(value="a.action")
    public String hello(HttpServletRequest request,ModelMap  model){
		System.out.println("test");
		List<A> aa=new ArrayList<A>();
		A a=new A();
		a.a="a";
		a.b="b";
		aa.add(a);
		
		model.put("message", aa);
       // model.addAttribute("message",aa);
        return "hello";
    }
	@RequestMapping(value="remote.action" ,method=RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> ajax(HttpServletRequest request,ModelMap model){
	    Map<String,String[]> reqmap=request.getParameterMap();
	    String [] ret=reqmap.get("value");
	    
        Map<String,Object> a=new HashMap<String,Object>();
        a.put("key", ret[0]+"add");
        return a;
    }
	@RequestMapping(value="time.action" ,method=RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> time(HttpServletRequest request,ModelMap model){

        Map<String,Object> a=new HashMap<String,Object>();
        Date date = new Date();
        a.put("time", date.toString());
        return a;
    }
}
