package com.example.e2ekernelengine.feed.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.e2ekernelengine.feed.dto.response.FeedSearchResponseDto;
import com.example.e2ekernelengine.feed.service.FeedService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/feeds")
public class FeedController {

	private final FeedService feedService;

	//-- Read(Search)--//
	@ResponseBody
	@GetMapping("/search")
	// 하나의 키워드가 아닌 문장을 입력받을 수 있게 바꿀 예정
	public ResponseEntity<List<FeedSearchResponseDto>> searchFeedByKeyword(
			@RequestParam(value = "q") String keyword) {

		List<FeedSearchResponseDto> feedResponses = feedService.searchFeedsByKeyword(keyword);

		if (feedResponses.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(feedResponses);
		}
	}

	@GetMapping("")
	public ResponseEntity<Page<FeedSearchResponseDto>> findRecentFeedList(
			@PageableDefault(size = 5, sort = "feedCreatedAt", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<FeedSearchResponseDto> feedList = feedService.findRecentFeedList(pageable);
		return ResponseEntity.ok(feedList);
	}

}
