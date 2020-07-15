package at.javatraining;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsResource {
	@Autowired
	private NewsRepository newsRepository;
	
	@GetMapping
	public List<News> retrieveAll() {
		return newsRepository.findAll();
	}
 //Todo add Jackson libraries
}
