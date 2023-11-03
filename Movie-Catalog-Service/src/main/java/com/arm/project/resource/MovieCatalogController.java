package com.arm.project.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.arm.project.model.CatalogItem;
import com.arm.project.model.Movie;
import com.arm.project.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	@Autowired
	private RestTemplate template;
	
	@Autowired
	private WebClient.Builder builder;

	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		UserRating ratings = template.getForObject("http://rating-data-service/rate/users/" + userId, UserRating.class);

//		List<Rating> ratings = Arrays.asList(new Rating("123", 4), new Rating("120", 5), new Rating("121", 6),
//				new Rating("122", 7), new Rating("124", 9));

		return ratings.getUserRatings().stream().map(rating -> {
			Movie movie = template.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);

			/*
			 * Movie movie = webclientBuilder .build() .get()
			 * .uri("http://localhost:8282/movies/" + rating.getMovieId()) .retrieve()
			 * .bodyToMono(Movie.class) .block();
			 */
			return new CatalogItem(movie.getName(), "Love Story", rating.getRating());
		}).collect(Collectors.toList());

		// return Collections.singletonList(new CatalogItem("3-idiots", "Educational",
		// 9));

	}
}
