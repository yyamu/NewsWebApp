package at.javatraining;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer {
	@Autowired
	private NewsRepository newsRepository;
	
	@EventListener(ContextRefreshedEvent.class)
	public void init() {
		if (newsRepository.count() == 0) {
			newsRepository.saveAll(List.of(
					new News(null, "Hello World" , "Herzlich willkommen am Planeten Erde.", LocalDate.now(), true),
					new News(null, "Nuees News-Portal online", "Alles neu macht der Juli.", LocalDate.now(), false)
					));
		}
		// Todo speichere 2 News in DB
	}

}
