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
import java.time.LocalDateTime;    


@Controller
public class MainController {
	

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    
    @GetMapping("/post")
    public String displayPostPage(Model model) throws FileNotFoundException{
    		List<Map<String, String>> comments = CommentsDao.extractFromFile();
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
    		
    		
        CommentsDao.writeToFile(name,date,content);
		//return "redirect:/";
        return "redirect:/post";
    }
    
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