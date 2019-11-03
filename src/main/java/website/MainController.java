package website;



import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;    


@Controller
public class MainController {
	
	
	
	@PostMapping("/encode")
	public String encode(@RequestParam(name="pid") int pid,
	 @RequestParam(name="description") String description) throws IOException {
		
//		Cryption cryption = new Cryption();
		
		String password = UserDao.findUserPassword(pid);
		
		Profile patient = new Profile(pid,description);
		
		String imageUrl = Cryption.encodeQR(patient, password);
		
		System.out.printf(imageUrl);
	
		
		String re = "redirect:/image?url="/*+keyword;*/+URLEncoder.encode(imageUrl, "utf-8"); //进行搜索
		return re;
		
//		return imageUrl;
//		return "http://google.com";
	}
	
	
	
	
	@RequestMapping("/image")
	public String imagepage(@RequestParam(name="url") String url, Model model)  {
		model.addAttribute("url",url);
		return "image";
	}
	
	/*@PostMapping("/")
	public String encode2(@RequestParam(name="pid") String pid,
	 @RequestParam(name="description") String description) {
		System.out.printf("Index Recieved");
		return "/";
	}*/
	/*
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    
    @GetMapping("/post")
    public String displayPostPage(Model model) throws FileNotFoundException{
    		List<Map<String, String>> comments = UserDao.extractFromFile();
    		model.addAttribute("comments",comments);
    		return "healthy_posts";
    }
    @PostMapping("/post")
    public String comment(@RequestParam(name="name") String name,
    						 @RequestParam(name="content") String content) throws IOException {    
    	
    		// Get local time and format it
    		LocalDateTime now = LocalDateTime.now(); 
    		String date = now.toString();
    		date = date.split("\\.")[0];
    		date = String.join(" ",date.split("T"));
    		
    		
        UserDao.writeToFile(name,date,content);
		//return "redirect:/";
        return "redirect:/post";
    }
    */
    
    /*
    @RequestMapping("/display")
    public String homepage(Model model) {
    		//List<Map<String, String>> comments = jdbcTemplate.queryForList("SELECT * FROM comments");
    		//System.out.println(comments);
        //model.addAttribute("comments",comments);
    		return "test";
    }*/
    
    //@RequestMapping("/")
	
	
	
}