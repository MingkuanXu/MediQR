package website;



import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;   


@Controller
public class MainController {
	
	
	
	@PostMapping("/encode")
	public String encode(
			@RequestParam(name="pid") int pid,
			@RequestParam(name="name") String name,
			@RequestParam(name="gender") String gender,
			@RequestParam(name="age") String age,
			@RequestParam(name="syndrome") String syndrome,
			@RequestParam(name="diagonosis") String diagnosis
			) throws IOException {
		
//		Cryption cryption = new Cryption();
		
		String[] description = new String[5];
		description[0] = name;
		description[1] = gender;
		description[2] = age;
		description[3] = syndrome;
		description[4] = diagnosis;

		String password = UserDao.findUserPassword(pid);
		
		Profile patient = new Profile(pid,description);
		
		String imageUrl = Cryption.encodeQR(patient, password);
		
		System.out.printf(imageUrl);
	
		String re = "redirect:/image?url="/*+keyword;*/+URLEncoder.encode(imageUrl, "utf-8"); //进行搜索
		return re;

	}
	
	

	@RequestMapping("/decode")

	public String decode(Model model) throws IOException {

        URL url = new URL("https://api.qrserver.com/v1/read-qr-code/?fileurl=https://github.com/MingkuanXu/MediQR/blob/master/src/main/resources/static/FamilyDinner2.jpeg");
        URLConnection conn = url.openConnection();

        // open the stream and put it into BufferedReader
        BufferedReader br = new BufferedReader(
                           new InputStreamReader(conn.getInputStream()));

        String inputLine;
        String jsonInfo = "";
        while ((inputLine = br.readLine()) != null) {
                jsonInfo+=inputLine;
        }
        
        br.close();

        System.out.println(jsonInfo);
        
        
        int pid = 1;
        String name = "Name1";
        String age = "20";
        String gender = "Male";
        String syndrome = "Fever";
        String diagonosis = "Malaria";
   
		model.addAttribute("pid",pid);
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		model.addAttribute("gender",gender);
		model.addAttribute("syndrome",syndrome);
		model.addAttribute("diagonosis",diagonosis);
		
		return "profile";
		
	}
	
	
	@RequestMapping("/image")
	public String imagepage(@RequestParam(name="url") String url, Model model)  {
		model.addAttribute("url",url);
		return "image";
	}
	
	
	@RequestMapping("/")
	public String mainpage() {
		return "index";
	}

	
	
}