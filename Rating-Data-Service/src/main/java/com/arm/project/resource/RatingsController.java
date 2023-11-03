package com.arm.project.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arm.project.model.Rating;
import com.arm.project.model.UserRating;

@RestController
@RequestMapping("/rate")
public class RatingsController {

	@GetMapping("/{movieId}")
	public Rating getrating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}

	@GetMapping("users/{userId}")
	public UserRating getUserRatings(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(new Rating("123", 4), new Rating("120", 5), new Rating("121", 6),
				new Rating("122", 7), new Rating("124", 9));
		UserRating rating = new UserRating();
		rating.setUserRatings(ratings);
		return rating;

	}
}
