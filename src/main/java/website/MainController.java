package website;



import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;
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

	public String decode(Model model) throws IOException, ParseException {
		String test = "00000001Jingchao\n30\nmale\nHackduke\nmalaria";
		String passwordTest = "12345";
		String encrypted = Cryption.encrypt(test, passwordTest);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(encrypted);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		String decrypted = Cryption.decrypt(encrypted, passwordTest);
		System.out.println(decrypted);

        URL url = new URL("https://api.qrserver.com/v1/read-qr-code/?fileurl=https://raw.githubusercontent.com/MingkuanXu/MediQR/master/example/1.jpeg");
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
        
        Profile profile = Cryption.decodeQR(jsonInfo, "12345", 1);
        
   
		model.addAttribute("pid",profile.getPid());
		model.addAttribute("name",profile.getName());
		model.addAttribute("age",profile.getAge());
		model.addAttribute("gender",profile.getGender());
		model.addAttribute("syndrome",profile.getSyndrome());
		model.addAttribute("diagonosis",profile.getDiagnosis());
		
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